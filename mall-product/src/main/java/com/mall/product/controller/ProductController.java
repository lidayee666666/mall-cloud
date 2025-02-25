package com.mall.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mall-product")
@Api(tags = "商品服务接口")
@Slf4j
public class ProductController {
    /**
     * 第一个测试接口
     * @return
     */
    @GetMapping("/hello")
    @ApiOperation("初始化测试接口")
    public String hello() {
        log.info("hello world");
        return "hello world";
    }
}
