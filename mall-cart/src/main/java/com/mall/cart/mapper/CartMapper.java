package com.mall.cart.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.cart.model.po.Cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
}
