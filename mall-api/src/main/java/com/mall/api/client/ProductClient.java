package com.mall.api.client;

import com.mall.api.config.DefaultFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "mall-product")
public interface ProductClient {

}
