package com.mall.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//springboot程序的启动类
@SpringBootApplication(scanBasePackages = {"com.mall.cart", "com.mall.common"})
//扫描
@MapperScan("com.mall.cart.mapper")
@EnableFeignClients(basePackages = "com.mall.api.client") // 指定 Feign 客户端所在的包
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class);
    }
}
