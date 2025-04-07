package com.mall.api.client;

import com.mall.api.domain.entity.OrderDetailProduct;
import com.mall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mall-product")
public interface ProductClient {
    @GetMapping("/products/order/api/{id}")
    Result<OrderDetailProduct> getById(@PathVariable("id") Long id);

    @GetMapping("/products/api/check/{productId}")
    boolean checkProductExists(@PathVariable Long productId);
}
