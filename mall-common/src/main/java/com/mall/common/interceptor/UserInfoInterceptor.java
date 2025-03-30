package com.mall.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.mall.common.utils.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;  // 改为jakarta包
import jakarta.servlet.http.HttpServletResponse; // 改为jakarta包

public class UserInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userInfo = request.getHeader("user-info");
        if (StrUtil.isNotBlank(userInfo)) {
            UserContext.setUser(Long.valueOf(userInfo));
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserContext.removeUser();
    }
}