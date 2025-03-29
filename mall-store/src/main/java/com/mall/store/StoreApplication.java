package com.mall.store;

import com.mall.api.config.DefaultFeignConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mall.store.mapper")
@ComponentScan({
        "com.mall.common",
        "com.mall.store"
})
@EnableFeignClients(basePackages = "com.mall.api.client", defaultConfiguration = DefaultFeignConfig.class)
public class StoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class);
    }
}
