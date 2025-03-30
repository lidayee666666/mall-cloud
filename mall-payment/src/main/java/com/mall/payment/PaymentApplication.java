package com.mall.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//扫描
@SpringBootApplication
@MapperScan("com.mall.payment.mapper")
@ComponentScan({
        "com.mall.common",
        "com.mall.payment"
})
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class);
    }
}
