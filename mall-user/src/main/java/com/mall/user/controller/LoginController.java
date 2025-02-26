package com.mall.user.controller;

import com.mall.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     * 接收 username 和 password，返回:
     * jwt-token
     * id
     * username
     * phone
     * balance
     */

    @PostMapping("/users/api/login")
    public Map<String, String> login(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        return loginService.login(username, password);
    }
}
