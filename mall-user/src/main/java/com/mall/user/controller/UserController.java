package com.mall.user.controller;

import com.mall.common.result.Result;
import com.mall.api.domain.entity.User;
import com.mall.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@Slf4j
@RequestMapping("/users/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @ApiOperation("查询用户信息")
    public Result<User> getById(@PathVariable Long id) {
        log.info("根据id查询用户信息：{}", id);
        User user = userService.getById(id);
        user.setBalance(user.getBalance()/100);
        return Result.success(user);
    }
}
