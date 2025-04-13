package com.mall.api.client;


import com.mall.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "mall-order")
public interface OrderClient {

    @Operation(summary = "发货后更改订单状态和发货时间")
    @PostMapping("/orders/api/consignUpdate/{id}")
    Result<String> consign(@PathVariable Long id);
}
