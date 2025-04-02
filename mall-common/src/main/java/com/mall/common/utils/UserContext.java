package com.mall.common.utils;

public class UserContext {
    private static final ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void setUser(Long userId) {
        if (userId == null) {
            removeUser();
        } else {
            tl.set(userId);
        }
    }

    public static Long getUser() {
        return tl.get();
    }

    public static void removeUser() {
        tl.remove();
    }
}