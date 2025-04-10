package com.mall.user.service;

import com.mall.common.result.Result;

import java.util.Map;

public interface RegisterService {
    Result<String> register(String username, String password, String confirmedPassword, String phone);
}
