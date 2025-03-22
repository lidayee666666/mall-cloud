package com.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.api.client.StoreClient;
import com.mall.api.domain.entity.Staff;
import com.mall.common.result.Result;
import com.mall.user.config.JwtProperties;
import com.mall.user.mapper.UserMapper;
import com.mall.api.domain.entity.User;
import com.mall.user.service.LoginService;
import com.mall.user.utils.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Autowired
    private StoreClient storeClient;

    @Override
    public Map<String, String> login(String username, String password, String s, String Yzm) {
        // 1.根据用户名在数据库中查询用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        Map<String, String> map = new HashMap<>();

        // 2.检验验证码
        if (!s.equalsIgnoreCase(Yzm)) {
            map.put("error_message", "验证码输入错误");
//            return map;
            return map;
        }

        // 3.检验是否为空
//        Assert.notNull(user, "用户名错误");
        if (user == null) {
            map.put("error_message", "用户名错误");
//            return map;
            return map;
        }

        // 4.校验是否禁用
        if (user.getStatus() == 0) {
            System.out.println("1321561");
            map.put("error_message", "用户被冻结");
//            return map;
            return map;
//          throw new RuntimeException("用户被冻结");
        }
        // 5.校验密码
        if (!passwordEncoder.matches(password, user.getPassword())) {
            map.put("error_message", "用户名或密码错误");
//            throw new RuntimeException("用户名或密码错误");
//            return map;
            return map;
        }
        // 6.生成TOKEN
        String token = jwtTool.createToken((long)user.getId(), jwtProperties.getTokenTTL());

        map.put("error_message", "success");
        map.put("jwtToken", token);
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("phone", user.getPhone());
        map.put("balance", user.getBalance().toString());
        map.put("avatar", user.getAvatar());
        return map;
    }

    @Override
    public Map<String, String> staffLogin(String username, String password, String s, String yzm) {
        Map<String, String> login = login(username, password, s, yzm);
        if(!"success".equals(login.get("error_message"))) {
            return login;
        }
        Long id = Long.parseLong(login.get("id"));
        Result<Staff> staffResult = storeClient.getByUserId(id);
        Staff staff = staffResult.getData();
        if(staff == null) {
            login.remove("jwtToken");
            login.put("error_message", "该管理员不存在");
            return login;
        }
        login.put("storeId", staff.getStoreId().toString());
        return login;
    }
}
