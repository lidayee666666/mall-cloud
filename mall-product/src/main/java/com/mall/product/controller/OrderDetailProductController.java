package com.mall.product.controller;

import com.mall.api.domain.entity.OrderDetailProduct;
import com.mall.common.result.Result;
import com.mall.product.pojo.entity.Product;
import com.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/order/api/{id}")
    public Result<OrderDetailProduct> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        String name = product.getName();
        Integer price = product.getPrice();
        Integer stock = product.getStock();
        String image = product.getImage();
        Integer status = product.getStatus();
        OrderDetailProduct orderDetailProduct = new OrderDetailProduct(id, name, price, stock, image, status);
        return Result.success(orderDetailProduct);
    }
}
