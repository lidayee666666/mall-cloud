package com.mall.api.client;

import com.mall.api.config.DefaultFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mall-user")
public interface UserClient {


}
