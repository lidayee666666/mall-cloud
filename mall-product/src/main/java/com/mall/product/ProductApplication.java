package com.mall.product;

import com.mall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
//springboot程序的启动类
@SpringBootApplication
//扫描
@MapperScan("com.mall.product.mapper")
@ComponentScan({
        "com.mall.common",
        "com.mall.product"
})
@EnableFeignClients(basePackages = "com.mall.api.client", defaultConfiguration = DefaultFeignConfig.class)
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class);
    }
}
