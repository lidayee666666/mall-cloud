package com.mall.api.client;


import com.mall.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "mall-order")
public interface OrderClient {

    @Operation(summary = "支付成功更改订单状态和修改时间")
    @PostMapping("/orders/api/payUpdate/{id}")
    Result<String> payUpdate(@PathVariable Long id);
}
