package com.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.api.domain.entity.User;

public interface UserService extends IService<User> {
    String findPasswordById(Long id);

    boolean savePwd(Long userId,String newPassword);


}
