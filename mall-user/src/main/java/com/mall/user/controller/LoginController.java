package com.mall.user.controller;

import com.mall.api.client.StoreClient;
import com.mall.common.result.Result;
import com.mall.user.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path = "/users/api")
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private LoginService loginService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/checkStoreStaff")
    @Operation(summary = "检查是否是商家员工")
    Result<String> checkStoreStaff(){
        return storeClient.checkStoreStaff();
    }

    @PostMapping("/login")
    public Result<Map<String, String>> login(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");

        String s = stringRedisTemplate.opsForValue().get(map.get("verKey"));
        String Yzm = map.get("Yzm");
        Map<String, String> login = loginService.login(username, password, s, Yzm);
        System.out.println(login);
        return Result.success(login);
    }

    @PostMapping("/login/staff")
    public Result<Map<String, String>> staffLogin(@RequestBody Map<String, String> map) {
        log.info("员工账号登录：{}", map);
        String username = map.get("username");
        String password = map.get("password");
        String s = stringRedisTemplate.opsForValue().get(map.get("verKey"));
        String Yzm = map.get("Yzm");
        Map<String, String> staffLogin = loginService.staffLogin(username, password, s, Yzm);
        return Result.success(staffLogin);
    }


}
