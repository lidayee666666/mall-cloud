package com.mall.user.service;

import com.mall.common.result.Result;

import java.util.Map;

public interface LoginService {
    public Result<Map<String, String>> login(String username, String password, String s, String yzm);
}
