package com.mall.gateway;

import com.mall.gateway.config.AuthProperties;
import com.mall.gateway.config.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


//springboot程序的启动类
@SpringBootApplication
@EnableConfigurationProperties({AuthProperties.class, JwtProperties.class})
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
