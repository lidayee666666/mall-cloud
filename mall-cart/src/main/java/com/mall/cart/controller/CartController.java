package com.mall.cart.controller;


import com.mall.cart.model.dto.CartAddDTO;
import com.mall.cart.model.dto.CartClearDTO;
import com.mall.cart.model.dto.CartUpdateDTO;
import com.mall.cart.model.po.Cart;
import com.mall.cart.model.vo.CartClearVO;
import com.mall.cart.model.vo.CartVO;
import com.mall.cart.service.Impl.CartService;
import com.mall.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李青龙
 * @date 2025/03/15 16:08
 * 功能描述:
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;

@Api(tags = "购物车服务接口")
@RestController
@RequestMapping("/carts/api")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @ApiOperation("获取购物车列表")
    @GetMapping("/list")
    public Result<List<CartVO>> getCartList() {
        logger.info("获取购物车列表");
        return cartService.getCartList();
    }

    @ApiOperation("更新购物车商品数量")
    @PutMapping("/update")
    public Result<String> updateCartItem(@RequestBody CartUpdateDTO updateDTO) {
        logger.info("更新购物车商品数量: {}", updateDTO);
        return cartService.updateCartItem(updateDTO);
    }

    @ApiOperation("删除购物车商品")
    @DeleteMapping("/delete/{productId}")
    public Result<String> deleteCartItem(@NotBlank @PathVariable(value = "productId") Long productId) {
        logger.info("删除购物车商品: {}", productId);
        return cartService.deleteCartItem(productId);
    }

    @ApiOperation("添加商品到购物车")
    @PostMapping("/add")
    public Result<String> addToCart(@RequestBody CartAddDTO addDTO) {
        logger.info("添加商品到购物车: {}", addDTO);
        return cartService.addToCart(addDTO);
    }

    @ApiOperation("购物车商品数量")
    @GetMapping("/count")
    public Result<Integer> getCartCount() {
        logger.info("获取购物车商品数量");
        return cartService.count();
    }
    @ApiOperation("支付成功清除购物车")
    @PostMapping("/clear")
    public Result<CartClearVO> deleteCartItems(@RequestBody CartClearDTO clearDTO) {
        logger.info("清除购物车: {}",clearDTO.getCartItemIds());
        return cartService.deleteCartItems(clearDTO.getCartItemIds());
    }

}