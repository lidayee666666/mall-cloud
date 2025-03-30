package com.mall.store.controller;

import com.mall.api.domain.entity.SimpleStore;
import com.mall.common.result.Result;
import com.mall.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/api")
@Tag(name = "商家相关接口")
@Slf4j
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取商家信息")
    public Result getStoreNameById(@PathVariable Long id) {
        SimpleStore simpleStore = storeService.getStoreNameById(id);
        if (simpleStore == null) {
            Result.error("获取商家信息失败");
        }
        return Result.success(simpleStore);
    }
}