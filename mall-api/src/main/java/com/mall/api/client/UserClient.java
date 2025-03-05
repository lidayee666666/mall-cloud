package com.mall.api.client;

import com.mall.api.config.DefaultFeignConfig;
import com.mall.api.domain.entity.User;
import com.mall.common.result.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mall-user")
public interface UserClient {
    @GetMapping("/users/api/{id}")
    Result<User> getById(@PathVariable("id") Long id);
}
