package com.mall.cart.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.cart.model.dto.CartAddDTO;
import com.mall.cart.model.dto.CartUpdateDTO;
import com.mall.cart.model.po.Cart;
import com.mall.common.result.Result;

import java.util.List;

/**
 * @author flash
 * @date 2025/03/15 16:22
 * 功能描述:
 */
public interface ICartService {
    Result<List<Cart>> getCartList();

    Result<String> updateCartItem(CartUpdateDTO updateDTO);

    Result<String> deleteCartItem(Long productId);

    Result<String> addToCart(CartAddDTO addDTO);

    Result<Integer> count();
}
