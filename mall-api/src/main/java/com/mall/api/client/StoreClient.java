package com.mall.api.client;

import com.mall.api.domain.entity.SimpleStore;
import com.mall.api.domain.entity.Staff;
import com.mall.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("mall-store")
public interface StoreClient {

    @GetMapping("/staff/api/user")
    Result<Staff> getByUserId();

    @GetMapping("/staff/api/user/{id}")
    Result<Staff> getByUserId(@PathVariable("id") Long id);

    @GetMapping("/store/api/{id}")
    Result<SimpleStore> getStoreNameById(@PathVariable("id") Long id);

    @GetMapping("/store/api/check")
    @Operation(summary = "检查是否是商家员工")
     Result<String> checkStoreStaff();
}
