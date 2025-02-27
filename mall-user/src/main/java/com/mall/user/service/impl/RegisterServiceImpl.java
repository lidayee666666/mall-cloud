package com.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.result.Result;
import com.mall.user.mapper.UserMapper;
import com.mall.user.pojo.User;
import com.mall.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.net.InetAddress;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 检查邮箱格式
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private boolean isValidFormat(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); // 如果匹配成功，返回true
    }
    // 检查域名是否存在
    private boolean isDomainExists(String email) {
        String domain = email.substring(email.indexOf('@') + 1); // 提取域名
        try {
            InetAddress.getByName(domain); // 尝试解析域名
            return true; // 如果解析成功，返回true
        } catch (Exception e) {
            return false; // 如果解析失败，返回false
        }
    }
    //验证真实邮箱是否存在
    private static final String SMTP_SERVER = "smtp.163.com"; // 使用您需要联系的邮件服务提供商的SMTP服务器地址
    private boolean isEmailExist(String email) {
        try (Socket socket = new Socket(SMTP_SERVER, 25)) { // 连接到SMTP服务器
            // 需要实现SMTP的EHLO或HELO命令，并处理返回响应
            // 这里的代码省略了实际的命令发送和响应处理过程，因为它需要根据具体的SMTP协议进行实现
            // 此部分可以根据所使用的SMTP服务器的要求进行调整
            return true; // 如果一切顺利，返回true
        } catch (Exception e) {
            return false; // 如果出现异常，则返回false
        }
    }

    @Override
    public Result<String> register(String username, String password, String confirmedPassword, String phone) {
        Map<String, String> map = new HashMap<>();

        if(username == null) {
//            map.put("error_message", "用户名不能为空");
//            return map;
            return Result.error("用户名不能为空");
        }
        if(password == null || confirmedPassword == null) {
//            map.put("error_message", "密码不能为空");
//            return map;
            return Result.error("密码不能为空");
        }

        username = username.trim();
        if(username.length() == 0) {
//            map.put("error_message", "用户名不能为空");
//            return map;
            return Result.error("用户名不能为空");
        }
        if(password.length() == 0 || confirmedPassword.length() == 0) {
//            map.put("error_message", "密码不能为空");
//            return map;
            return Result.error("密码不能为空");
        }

        if(username.length() > 20) {
//            map.put("error_message", "用户名长度不能大于20");
//            return map;
            return Result.error("用户名长度不能大于20");
        }
        if(password.length() > 20 || confirmedPassword.length() > 20) {
//            map.put("error_message", "密码长度不能大于20");
//            return map;
            return Result.error("密码长度不能大于20");
        }

        if(!password.equals(confirmedPassword)) {
//            map.put("error_message", "两次输入的密码不一致");
//            return map;
            return Result.error("两次输入的密码不一致");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
//            map.put("error_message", "账号已存在");
//            return map;
            return Result.error("账号已存在");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(null, username, encodedPassword, phone, null, null, null, null);
        userMapper.insert(user);

//        map.put("error_message", "success");
        return Result.success("注册成功");
    }
}
