package com.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mall.user.mapper.UserMapper;
import com.mall.api.domain.entity.User;
import com.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public String findPasswordById(Long id) {
        // 1.根据用户名在数据库中查询用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        User user = userMapper.selectOne(queryWrapper);
        String password = user.getPassword();
        return password;
    }

    @Override
    public boolean savePwd(Long userId,String newPassword) {
        // 创建 QueryWrapper 对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // 设置查询条件（例如根据用户ID）
        queryWrapper.eq("id", userId); // userId 是要修改密码的用户ID

        // 创建一个 User 对象，设置新的密码
        User updateUser = new User();
        updateUser.setPassword(newPassword); // newPassword 是新密码

        // 调用 MyBatis-Plus 的 update 方法进行更新
        boolean isUpdated = userMapper.update(updateUser, queryWrapper) > 0;
        return isUpdated;
    }


}
