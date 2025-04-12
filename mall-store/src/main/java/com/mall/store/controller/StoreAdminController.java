package com.mall.store.controller;

import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.store.pojo.dto.StoreUpdateDTO;
import com.mall.store.pojo.vo.StoreDetailVO;
import com.mall.store.service.StoreDetailService;
import com.mall.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李青龙
 * @date 2025/04/12 15:54
 * 功能描述:
 */
@RestController
@RequestMapping("/store/api/admin")
@Tag(name = "商家管理接口")
public class StoreAdminController {

    @Autowired
    private StoreDetailService service;

    @GetMapping("/info")
    @Operation(summary = "获取当前商家详细信息")
    public Result<StoreDetailVO> getStoreDetail() {
        Long storeId = UserContext.getUser();
        return Result.success(service.getStoreDetail(storeId));
    }

    @PutMapping("/edit")
    @Operation(summary = "更新商家信息")
    public Result<Void> updateStoreInfo(@RequestBody StoreUpdateDTO dto) {
        Long storeId = UserContext.getUser();
        service.updateStoreInfo(storeId, dto);
        return Result.success();
    }
}