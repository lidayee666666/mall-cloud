package com.mall.product.controller;

import com.mall.common.result.Result;
import com.mall.product.pojo.vo.CarouselVO;
import com.mall.product.service.CarouselService;
import com.mall.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李青龙
 * @date 2025/04/04 19:34
 * 功能描述:    商城首页轮播图
 */
@RestController
@Slf4j
@RequestMapping("product/api")
@Tag(name = "CarouselController",description = "商城首页轮播图界面")
public class CarouselController {

    @Autowired
    private CarouselService carouselServe;

    @Operation(summary = "商城首页轮播图接口")
    @GetMapping(path = "/carousel")
    public Result<List<CarouselVO>> carouselList(){
        return carouselServe.carouselServe();
    }
}
