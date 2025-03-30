package com.mall.user.controller;

import com.mall.common.result.Result;
import com.mall.api.domain.entity.User;
import com.mall.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users/api")
@RequiredArgsConstructor
@Tag(name = "用户管理", description = "用户相关接口") // 替换原来的 @Api 注解
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "查询用户信息", description = "根据用户ID获取用户详细信息") // 替换 @ApiOperation
    public Result<User> getById(@PathVariable Long id) {
        log.info("根据id查询用户信息：{}", id);
        User user = userService.getById(id);
        user.setBalance(user.getBalance()/100);
        return Result.success(user);
    }
}