package com.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
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
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<String> getRecommends(QueryProductParams query) throws IOException {
        String keyword = query.getKeyword();

        // 1. 创建SearchRequest
        SearchRequest searchRequest = new SearchRequest("product");

        // 2. 构建SearchSourceBuilder
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 3. 设置查询条件 - 匹配all字段
        sourceBuilder.query(QueryBuilders.matchQuery("all", keyword));

        // 4. 设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name").requireFieldMatch(false)
                .field("storeName").requireFieldMatch(false)
                .preTags("")  // 设置高亮前缀标签
                .postTags(""); // 设置高亮后缀标签

        sourceBuilder.highlighter(highlightBuilder);

        // 5. 设置返回字段
        sourceBuilder.fetchSource(new String[]{"name", "storeName"}, null);

        // 6. 设置返回结果数量
        sourceBuilder.size(5);

        // 7. 将SearchSourceBuilder添加到SearchRequest中
        searchRequest.source(sourceBuilder);

        // 8. 执行查询
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        return getRecommends(response);
    }

    List<String> getRecommends(SearchResponse response) {
        Set<String> set = new HashSet<>();

        for (SearchHit hit : response.getHits().getHits()) {
            // 获取高亮结果
            Map<String, HighlightField> hitHighlightFields = hit.getHighlightFields();
            if (!CollectionUtils.isEmpty(hitHighlightFields)) {
                // 根据字段名获取高亮结果
                HighlightField highlightField = hitHighlightFields.get("name");
                if (highlightField != null) {
                    String name = highlightField.getFragments()[0].toString();
                    set.add(name);
                }
                HighlightField highlightField2 = hitHighlightFields.get("storeName");
                if (highlightField2 != null) {
                    String storeName = highlightField2.getFragments()[0].toString();
                    set.add(storeName);
                }
            }
        }
        return set.stream().toList();
    }

    @Override
    public PageVO<ProductVO> getProducts(QueryProductParams params) throws IOException {
        // 1. 构建查询条件
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        // 2. 计算分页起始位置 (Elasticsearch的from是基于0的)
        int from = (params.getPageNo() - 1) * params.getPageSize();
        int size = params.getPageSize();

        // 添加名称查询条件 (如果name不为空)
        if (params.getKeyword() != null && !params.getKeyword().isEmpty()) {
            boolQuery.must(QueryBuilders.matchQuery("all", params.getKeyword()));
        } else {
            boolQuery.must(QueryBuilders.matchAllQuery());
        }

        // 3. 构建高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .field(new HighlightBuilder.Field("name")
                        .requireFieldMatch(false))
                .field(new HighlightBuilder.Field("storeName")
                        .requireFieldMatch(false));

        // 4. 构建搜索请求
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder()
                .query(boolQuery)
                .from(from)
                .size(size)
                .highlighter(highlightBuilder);

        String sortBy = params.getSortBy();
        if (sortBy != null && !sortBy.isEmpty() && !sortBy.equals("default")) {
            sourceBuilder.sort(sortBy, SortOrder.ASC);// 保持价格升序排序
        }

        SearchRequest searchRequest = new SearchRequest("product")
                .source(sourceBuilder);

        // 5. 执行查询
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        // 6. 解析结果
        PageVO<ProductVO> res = handleResponse(response);
        long pages = res.getTotal() / size;
        if (res.getTotal() % size != 0) {
            res.setPages(pages + 1);
        } else {
            res.setPages(pages);
        }
        return res;
    }

    private PageVO<ProductVO> handleResponse(SearchResponse response) {
        // 结果解析
        SearchHits searchHits = response.getHits();
        // 获取总条数
        long total = searchHits.getTotalHits().value;
        System.out.println("total = " + total);
        // 获取文档数组
        SearchHit[] hits = searchHits.getHits();

        ArrayList<ProductDoc> list = new ArrayList<>();
        for (SearchHit hit : hits) {
            // 获取文档source
            String json = hit.getSourceAsString();
            // 反序列化为ProductDoc对象
            ProductDoc productDoc = JSON.parseObject(json, ProductDoc.class);
            // 处理高亮结果
            Map<String, HighlightField> hitHighlightFields = hit.getHighlightFields();
            if (!CollectionUtils.isEmpty(hitHighlightFields)) {
                // 根据字段名获取高亮结果
                HighlightField highlightField = hitHighlightFields.get("name");
                if (highlightField != null) {
                    String name = highlightField.getFragments()[0].toString();
                    productDoc.setName(name);
                }
                HighlightField highlightField2 = hitHighlightFields.get("storeName");
                if (highlightField2 != null) {
                    String storeName = highlightField2.getFragments()[0].toString();
                    productDoc.setStoreName(storeName);
                }
            }

//            System.out.println(productDoc);
            list.add(productDoc);
        }
        List<ProductVO> productVOS = BeanUtil.copyToList(list, ProductVO.class);

        return PageVO.of(total, 0L, productVOS);
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
        // 进行新增操作
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
        // 对没有下架的商品也不能删除
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
        // 先获取对应的种类名称
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getId, categoryId);
        Category category = categoryService.getOne(wrapper);
        if (category == null) {
            throw new CategoryNotFoundException(MessageConstant.CATEGORY_NOT_FOUND_ERROR);
        }
        // 再获取种类名称对应的商品
        LambdaQueryWrapper<Product> productLambdaQueryWrapper = new LambdaQueryWrapper<>();
        productLambdaQueryWrapper.eq(Product::getCategory, category.getCategory());
        // 1.分页查询
        Page<Product> result = page(query.toMpPage("update_time", false), productLambdaQueryWrapper);
        // 2.封装并返回
        PageDTO<ProductDTO> pageDTO = PageDTO.of(result, ProductDTO.class);
        return pageDTO;
    }

    @Autowired
    private RestHighLevelClient client;

    @Override
    public void saveProductsToES() throws IOException {
        // 从数据库中获取数据
        List<Product> list = list();

        // 1.准备Request
        BulkRequest request = new BulkRequest();
        // 2.准备参数, 添加多个新增的Request
        for (Product product : list) {
            // 将Product转换为为ProductDoc类型
            Result<SimpleStore> simpleStoreResult = storeClient.getStoreNameById(product.getStoreId());
            if (simpleStoreResult.getCode() != 1) {
                continue;
            }
            String storeName = simpleStoreResult.getData().getName();
            ProductDoc productdoc = new ProductDoc(product, storeName);
            request.add(new IndexRequest("product")
                    .id(productdoc.getId().toString())
                    .source(JSON.toJSONString(productdoc), XContentType.JSON));
        }
        // 3.发送请求
        client.bulk(request, RequestOptions.DEFAULT);
    }

    // 获取商家名称
    private String getStoreName(Product product) {
        Result<SimpleStore> storeResult = storeClient.getStoreNameById(product.getStoreId());
        String storeName;
        if (storeResult.getCode() != 1) {
            throw new RuntimeException("商品所属商家信息获取失败");
        } else {
            if (storeResult.getData() == null) {
                throw new RuntimeException("商品所属商家信息获取失败");
            } else {
                storeName = storeResult.getData().getName();
            }
        }
        return storeName;
    }

    private boolean checkRole(Long storeId) {
        // 使用feign调用商家服务，在员工表查询当前账号身份，获取其所属商家
        Result<Staff> result = storeClient.getByUserId();
        // 与当前商家比对，如果不一致或当前用户非员工则返回false
        Staff staff = result.getData();
        if (staff == null) {
            return false;
        }
        return staff.getStoreId().equals(storeId);
    }
}
