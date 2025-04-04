package com.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.result.Result;
import com.mall.product.pojo.entity.Product;
import com.mall.product.pojo.vo.CarouselVO;

import java.util.List;

/**
 * @author 李青龙
 * @date 2025/04/04 19:51
 * 功能描述:
 */
public interface CarouselService extends IService<Product> {
    Result<List<CarouselVO>> carouselServe();
}
