package com.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.api.client.StoreClient;
import com.mall.api.domain.entity.SimpleStore;
import com.mall.api.domain.entity.Staff;
import com.mall.common.constant.MessageConstant;
import com.mall.common.constant.ProductStatusConstant;
import com.mall.common.domain.PageDTO;
import com.mall.common.domain.PageQuery;
import com.mall.common.exception.CategoryNotFoundException;
import com.mall.common.exception.ProductStatusException;
import com.mall.common.exception.UserPermissionException;
import com.mall.common.result.Result;
import com.mall.product.mapper.ProductMapper;
import com.mall.product.pojo.doc.ProductDoc;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.dto.QueryProductParams;
import com.mall.product.pojo.entity.Category;
import com.mall.product.pojo.entity.Product;
import com.mall.product.pojo.vo.PageVO;
import com.mall.product.pojo.vo.ProductVO;
import com.mall.product.service.CategoryService;
import com.mall.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final StoreClient storeClient;
    private final CategoryService categoryService;
    private final RestHighLevelClient esClient;

    @Override
    public List<String> getRecommends(QueryProductParams query) throws IOException {
        SearchRequest searchRequest = new SearchRequest("product");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 设置查询条件
        sourceBuilder.query(QueryBuilders.matchQuery("all", query.getKeyword()));
        sourceBuilder.size(5);

        // 设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name").preTags("<em>").postTags("</em>");
        highlightBuilder.field("storeName").preTags("<em>").postTags("</em>");
        sourceBuilder.highlighter(highlightBuilder);

        // 设置返回字段
        sourceBuilder.fetchSource(new String[]{"name", "storeName"}, null);

        searchRequest.source(sourceBuilder);
        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);

        return Arrays.stream(response.getHits().getHits())
                .flatMap(hit -> {
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                    List<String> results = new ArrayList<>();
                    if (highlightFields != null) {
                        highlightFields.forEach((k, v) ->
                                results.add(((org.elasticsearch.search.fetch.subphase.highlight.HighlightField)v).fragments()[0].string()));
                    }
                    return results.stream();
                })
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public PageVO<ProductVO> getProducts(QueryProductParams params) throws IOException {
        int from = (params.getPageNo() - 1) * params.getPageSize();

        SearchRequest searchRequest = new SearchRequest("product");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 设置查询条件
        if (params.getKeyword() != null && !params.getKeyword().isEmpty()) {
            sourceBuilder.query(QueryBuilders.matchQuery("all", params.getKeyword()));
        } else {
            sourceBuilder.query(QueryBuilders.matchAllQuery());
        }

        // 设置分页
        sourceBuilder.from(from);
        sourceBuilder.size(params.getPageSize());

        // 设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name").preTags("<em>").postTags("</em>");
        highlightBuilder.field("storeName").preTags("<em>").postTags("</em>");
        sourceBuilder.highlighter(highlightBuilder);

        // 设置排序
        if (params.getSortBy() != null && !params.getSortBy().isEmpty() && !params.getSortBy().equals("default")) {
            sourceBuilder.sort(params.getSortBy());
        }

        searchRequest.source(sourceBuilder);
        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);

        // 处理结果
        long total = response.getHits().getTotalHits().value;
        List<ProductVO> productVOS = Arrays.stream(response.getHits().getHits())
                .map(hit -> {
                    ProductDoc doc = BeanUtil.toBean(hit.getSourceAsMap(), ProductDoc.class);
                    if (doc != null && hit.getHighlightFields() != null) {
                        hit.getHighlightFields().forEach((field, highlightField) -> {
                            if (field.equals("name") && highlightField.getFragments() != null && highlightField.getFragments().length > 0) {
                                doc.setName(highlightField.getFragments()[0].string());
                            } else if (field.equals("storeName") && highlightField.getFragments() != null && highlightField.getFragments().length > 0) {
                                doc.setStoreName(highlightField.getFragments()[0].string());
                            }
                        });
                    }
                    return BeanUtil.copyProperties(doc, ProductVO.class);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // 计算总页数
        long pages = total / params.getPageSize();
        if (total % params.getPageSize() != 0) {
            pages += 1;
        }

        return PageVO.of(total, pages, productVOS);
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Long storeId = productDTO.getStoreId();
        boolean checked = checkRole(storeId);
        if (!checked) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }

        LambdaUpdateWrapper<Category> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Category::getCategory, productDTO.getCategory());
        Category category = categoryService.getOne(wrapper);

        if (category == null) {
            throw new CategoryNotFoundException(MessageConstant.CATEGORY_NOT_FOUND_ERROR);
        }

        Product product = BeanUtil.copyProperties(productDTO, Product.class);
        save(product);
    }

    @Override
    public void removeProduct(Long id) {
        Product product = getById(id);
        Long storeId = product.getStoreId();
        boolean checked = checkRole(storeId);

        if (!checked) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }

        if (!Objects.equals(product.getStatus(), ProductStatusConstant.REMOVE)) {
            throw new ProductStatusException(MessageConstant.PRODUCT_STATUS_ERROR);
        }

        LambdaUpdateWrapper<Product> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Product::getStatus, ProductStatusConstant.DELETE)
                .eq(Product::getId, id);
        update(wrapper);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Long storeId = productDTO.getStoreId();
        boolean checked = checkRole(storeId);

        if (!checked) {
            throw new UserPermissionException(MessageConstant.USER_PERMISSION_ERROR);
        }

        Product product = BeanUtil.copyProperties(productDTO, Product.class);
        updateById(product);
    }

    @Override
    public PageDTO<ProductDTO> queryProductWithCategoryByPage(PageQuery query, Long categoryId) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getId, categoryId);
        Category category = categoryService.getOne(wrapper);

        if (category == null) {
            throw new CategoryNotFoundException(MessageConstant.CATEGORY_NOT_FOUND_ERROR);
        }

        LambdaQueryWrapper<Product> productLambdaQueryWrapper = new LambdaQueryWrapper<>();
        productLambdaQueryWrapper.eq(Product::getCategory, category.getCategory());

        Page<Product> result = page(query.toMpPage("update_time", false), productLambdaQueryWrapper);
        return PageDTO.of(result, ProductDTO.class);
    }

    @Override
    public void saveProductsToES() throws IOException {
        List<Product> products = list();
        BulkRequest bulkRequest = new BulkRequest();

        for (Product product : products) {
            Result<SimpleStore> result = storeClient.getStoreNameById(product.getStoreId());
            if (result.getCode() == 1 && result.getData() != null) {
                ProductDoc doc = new ProductDoc(product, result.getData().getName());
                bulkRequest.add(new IndexRequest("product")
                        .id(doc.getId().toString())
                        .source(BeanUtil.beanToMap(doc)));
            }
        }

        esClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    private boolean checkRole(Long storeId) {
        Result<Staff> result = storeClient.getByUserId();
        Staff staff = result.getData();
        return staff != null && staff.getStoreId().equals(storeId);
    }
}