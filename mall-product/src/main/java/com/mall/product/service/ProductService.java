package com.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.product.pojo.dto.ProductDTO;
import com.mall.product.pojo.entity.Product;

import java.util.List;

public interface ProductService extends IService<Product> {

    public void saveProduct(ProductDTO productDTO);

    void removeProduct(Long id);

    void updateProduct(ProductDTO productDTO);
}
