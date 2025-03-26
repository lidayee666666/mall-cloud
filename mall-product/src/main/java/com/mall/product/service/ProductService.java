package com.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.domain.PageDTO;
import com.mall.common.domain.PageQuery;
import com.mall.product.pojo.doc.ProductDoc;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.dto.QueryProductParams;
import com.mall.product.pojo.entity.Product;
import com.mall.product.pojo.vo.PageVO;
import com.mall.product.pojo.vo.ProductVO;

import java.io.IOException;
import java.util.List;

public interface ProductService extends IService<Product> {

    void saveProduct(ProductDTO productDTO);

    void removeProduct(Long id);

    void updateProduct(ProductDTO productDTO);

    PageDTO<ProductDTO> queryProductWithCategoryByPage(PageQuery query, Long categoryId);

    void saveProductsToES() throws IOException;

    PageVO<ProductVO> getProducts(QueryProductParams query) throws IOException;

    List<String> getRecommends(QueryProductParams query) throws IOException;
}
