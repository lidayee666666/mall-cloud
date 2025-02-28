package com.mall.user.controller;

import com.mall.common.result.Result;
import com.mall.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     * 接收 username、password、VerKey、Yzm，返回:
     * jwtToken
     * id
     * username
     * phone
     * balance
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/users/api/login")
    public Result<Map<String, String>> login(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(map);
        String s = stringRedisTemplate.opsForValue().get(map.get("verKey"));
        String Yzm = map.get("Yzm");
        Map<String, String> login = loginService.login(username, password, s, Yzm);
        return Result.success(login);
    }

    @PostMapping("/users/api/login/staff")
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
