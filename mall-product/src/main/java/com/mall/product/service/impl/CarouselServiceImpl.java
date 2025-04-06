package com.mall.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.result.Result;
import com.mall.product.mapper.CarouselMapper;
import com.mall.product.pojo.entity.Product;
import com.mall.product.pojo.vo.CarouselVO;
import com.mall.product.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李青龙
 * @date 2025/04/04 19:53
 * 功能描述:
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Product> implements CarouselService {

    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public Result<List<CarouselVO>> carouselServe() {
        //lambdaQuery().orderBy( true,true, Product::getSold );
        //根据商品类型进行分组,分组后取每个类别下销量第一的图片
        //lambdaQuery().groupBy(Product::getCategory).count();
        return Result.success(carouselMapper.groupByCategoryOrder());
    }
}
