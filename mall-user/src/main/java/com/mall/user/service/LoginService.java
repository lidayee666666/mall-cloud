package com.mall.user.service;

import com.mall.common.result.Result;

import java.util.Map;

public interface LoginService {
     Map<String, String> login(String username, String password, String s, String yzm);

    Map<String, String> staffLogin(String username, String password, String s, String yzm);
}
