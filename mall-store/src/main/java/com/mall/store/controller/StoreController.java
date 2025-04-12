package com.mall.store.controller;

import com.mall.api.domain.entity.SimpleStore;
import com.mall.api.domain.entity.User;
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

import java.util.Objects;

@RestController
@RequestMapping("/store/api")
@Tag(name = "商家相关接口")
@Slf4j
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    @Operation(summary = "根据ID获取商家名称")
    public Result getStoreNameById(@PathVariable Long id) {
        SimpleStore simpleStore = storeService.getStoreNameById(id);
        if (simpleStore == null) {
            Result.error("获取商家信息失败");
        }
        return Result.success(simpleStore);
    }

    @GetMapping("/check")
    @Operation(summary = "检查是否是商家员工")
    public Result<String> checkStoreStaff() {
        User vo = storeService.checkStoreStaff();
        if (vo == null|| Objects.equals(vo.getUserType().getValue(), "customer")) {
            return Result.error("不是商家员工");
        }
        return Result.success("当前身份是商家员工");
    }
}