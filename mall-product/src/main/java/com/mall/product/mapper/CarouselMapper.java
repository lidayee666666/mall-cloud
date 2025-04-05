package com.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.product.pojo.entity.Product;

import java.util.List;

/**
 * @author 李青龙
 * @date 2025/04/04 20:12
 * 功能描述:    
 */
public interface CarouselMapper extends BaseMapper<Product> {

    List<String> groupByCategoryOrder();
}
