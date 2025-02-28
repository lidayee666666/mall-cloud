package com.mall.api.client;

import com.mall.api.domain.entity.Staff;
import com.mall.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("mall-store")
public interface StoreClient {

    @GetMapping("/staff/api/user")
    Result<Staff> getByUserId();
}
