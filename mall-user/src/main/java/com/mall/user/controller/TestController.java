package com.mall.user.controller;

import com.mall.common.utils.UserContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class TestController {

    @PostMapping("/users/api/test")
    public void test() {
        CopyOnWriteArrayList<Object> a1 = new CopyOnWriteArrayList<>();
        ConcurrentHashMap a2 = new ConcurrentHashMap();
        System.out.println(UserContext.getUser());
    }
}

