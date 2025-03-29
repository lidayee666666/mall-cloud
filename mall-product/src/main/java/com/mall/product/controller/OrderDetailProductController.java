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
        OrderDetailProduct dto = new OrderDetailProduct(
                product.getId(),
                product.getName(),
                product.getPrice(), // 这里现在传递Integer类型
                product.getStock(),
                product.getImage(),
                product.getStatus()
        );
        return Result.success(dto);
    }

    /*private OrderDetailProduct convertToOrderDetailProduct(Product product) {
        return new OrderDetailProduct(
                product.getId(),
                product.getName(),
                product.getPriceYuan(),
                product.getStock(),
                product.getImage(),
                product.getStatus()
        );
    }*/
}
