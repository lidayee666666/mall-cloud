package com.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.exception.LoginFailedException;
import com.mall.user.config.JwtProperties;
import com.mall.user.mapper.UserMapper;
import com.mall.user.pojo.User;
import com.mall.user.service.LoginService;
import com.mall.user.utils.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public Map<String, String> login(String username, String password) {
        // 1.根据用户名在数据库中查询用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        // 2.检验是否为空
        Assert.notNull(user, "用户名错误");

        // 3.校验是否禁用
        if (user.getStatus() == 0) {
            throw new LoginFailedException("用户被冻结");
        }
        // 4.校验密码
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new LoginFailedException("用户名或密码错误");
        }
        // 5.生成TOKEN
        String token = jwtTool.createToken((long)user.getId(), jwtProperties.getTokenTTL());

        Map<String, String> map = new HashMap<>();
        map.put("jwt-token", token);
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("phone", user.getPhone());
        map.put("balance", user.getBalance().toString());
        return map;
    }
}
