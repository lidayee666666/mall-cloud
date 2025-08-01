package com.mall.cart.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.cart.model.dto.CartAddDTO;
import com.mall.cart.model.dto.CartClearDTO;
import com.mall.cart.model.dto.CartUpdateDTO;
import com.mall.cart.model.po.Cart;
import com.mall.cart.model.vo.CartClearVO;
import com.mall.cart.model.vo.CartVO;
import com.mall.common.result.Result;

import java.util.List;

/**
 * @author flash
 * @date 2025/03/15 16:22
 * 功能描述:
 */
public interface ICartService {
    Result<List<CartVO>> getCartList();

    Result<String> updateCartItem(CartUpdateDTO updateDTO);

    Result<String> deleteCartItem(Long productId);

    Result<String> addToCart(CartAddDTO addDTO);

    Result<Integer> count();

    Result<CartClearVO> deleteCartItems(List<String>cartItemIds);
}
