package com.mall.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mall.store.mapper")
public class StoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class);
    }
}
