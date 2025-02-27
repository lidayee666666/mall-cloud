package com.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//springboot程序的启动类
@SpringBootApplication
//扫描
@MapperScan("com.mall.product.mapper")
@ComponentScan({
        "com.mall.common",
        "com.mall.product"
})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class);
    }
}
