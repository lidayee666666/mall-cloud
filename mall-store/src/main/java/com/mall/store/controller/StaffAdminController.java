package com.mall.store.controller;

import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.store.pojo.dto.StaffAddDTO;
import com.mall.store.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李青龙
 * @date 2025/04/12 15:56
 * 功能描述:
 */
@RestController
@RequestMapping("/staff/api/admin")
@Tag(name = "员工管理接口")
public class StaffAdminController {

    @Autowired
    private StaffService staffService;

    @PostMapping("addStaff")
    @Operation(summary = "添加员工")
    public Result<Void> addStaff(@RequestBody StaffAddDTO dto) {
        Long storeId = UserContext.getUser();
        staffService.addStaff(storeId, dto);
        return Result.success();
    }


}