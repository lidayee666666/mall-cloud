package com.mall.store.controller;

import com.mall.common.result.Result;
import com.mall.api.domain.entity.Staff;
import com.mall.common.utils.UserContext;
import com.mall.store.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff/api")
@Api(tags = "员工相关接口")
@Slf4j
public class StaffController {

    @Autowired
    private StaffService service;

    @GetMapping("/user")
    @ApiOperation("查询当前员工信息")
    public Result<Staff> getByUserId() {
        log.info("查询当前用户的员工信息:{}", UserContext.getUser());
        Staff staff = service.getByUserId();
        return Result.success(staff);
    }
}
