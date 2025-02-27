package com.mall.user.controller;

import com.mall.common.result.Result;
import com.mall.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     * 接收 username、password、VerKey、Yzm，返回:
     * jwt-token
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
        String s = stringRedisTemplate.opsForValue().get(map.get("VerKey"));
        String Yzm = map.get("Yzm");
        return loginService.login(username, password, s, Yzm);
    }
}
