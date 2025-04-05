package com.mall.user.controller;

import com.mall.common.result.Result;
import com.mall.api.domain.entity.User;
import com.mall.common.utils.UserContext;
import com.mall.user.service.UserService;
import com.mall.user.utils.JwtTool;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/users/api")
@RequiredArgsConstructor
@Tag(name = "用户管理", description = "用户相关接口") // 替换原来的 @Api 注解
public class UserController {

    private final UserService userService;

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/findUserById")
    @Operation(summary = "查询用户信息", description = "根据用户ID获取用户详细信息") // 替换 @ApiOperation
    public Result<User> getById() {
        Long id = UserContext.getUser();
        log.info("根据id查询用户信息：{}", id);
        User user = userService.getById(id);
        user.setBalance(user.getBalance()/100);
        return Result.success(user);
    }

    @GetMapping("/findPasswordById")
    @Operation(summary = "查询用户信息", description = "根据用户ID获取用户密码") // 替换 @ApiOperation
    public Result<Integer>findPasswordById(@RequestHeader("Authorization") String token,
                                           String password){
        try {
            // 1. 解析 Token 获取用户 ID
            Long userId = jwtTool.parseToken(token);
            if (userId == null) {
                log.warn("无效的 Token");
                return Result.error("无效的 Token");
            }

            // 2. 根据用户 ID 查询用户信息
            User user = userService.getById(userId);
            if (user == null) {
                log.warn("未找到用户 ID: {}", userId);
                return Result.error("用户不存在");
            }

            // 3. 验证密码是否正确
            boolean isPasswordValid = passwordEncoder.matches(password, user.getPassword());
            if (isPasswordValid) {
                log.info("密码验证成功，用户 ID: {}", userId);
                return Result.success(200); // 返回成功状态码
            } else {
                log.warn("密码验证失败，用户 ID: {}", userId);
                return Result.error("密码错误"); // 返回错误信息
            }
        } catch (Exception e) {
            log.error("根据 ID 查找密码时发生异常: {}", e.getMessage(), e);
            return Result.error("服务器内部错误");
        }

    }
    @PutMapping("/savePwd")
    @Operation(summary = "修改用户信息", description = "修改密码") // 替换 @ApiOperation
    public Result<Integer>savePwd(@RequestHeader("Authorization") String token,
                                   String newPassword){
        //根据id修改密码 成功返回200 不成功返回201
        log.info("修改密码");
        // 解析 Token 获取用户 ID
        Long userId = jwtTool.parseToken(token);
        User user = userService.getById(userId);
        String encodedPassword = passwordEncoder.encode(newPassword);
        boolean isUpdate= userService.savePwd(userId,encodedPassword);
        if(isUpdate) {
            return Result.success(200);
        }else {
            return Result.error("修改失败");
        }
    }
    @GetMapping("/pwdInfo")
    @Operation(summary = "查询用户信息", description = "查密码和账号") // 替换 @ApiOperation
    public Result<Map<String, Object>> pwdInfo(@RequestHeader("Authorization") String token){
        //后端传回username account
        log.info("查询密码和账号");
        // 解析 Token 获取用户 ID
        Long userId = jwtTool.parseToken(token);
        User user = userService.getById(userId);
        // 构造返回数据
        Map<String, Object> response = new HashMap<>();
        response.put("username", user.getUsername());
        response.put("account", user.getId());

        return Result.success(response);
    }


}




