package com.mall.cart.controller;

import com.mall.cart.model.dto.CartAddDTO;
import com.mall.cart.model.dto.CartClearDTO;
import com.mall.cart.model.dto.CartUpdateDTO;
import com.mall.cart.model.vo.CartClearVO;
import com.mall.cart.model.vo.CartVO;
import com.mall.cart.service.Impl.CartService;
import com.mall.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "购物车服务接口")
@RestController
@RequestMapping("/carts/api")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @Operation(summary = "获取购物车列表")
    @GetMapping("/list")
    public Result<List<CartVO>> getCartList() {
        logger.info("获取购物车列表");
        return cartService.getCartList();
    }

    @Operation(summary = "更新购物车商品数量")
    @PutMapping("/update")
    public Result<String> updateCartItem(@RequestBody @Valid CartUpdateDTO updateDTO) {
        logger.info("更新购物车商品数量: {}", updateDTO);
        return cartService.updateCartItem(updateDTO);
    }

    @Operation(summary = "删除购物车商品")
    @DeleteMapping("/delete/{productId}")
    public Result<String> deleteCartItem(@NotBlank @PathVariable("productId") Long productId) {
        logger.info("删除购物车商品: {}", productId);
        return cartService.deleteCartItem(productId);
    }

    @Operation(summary = "添加商品到购物车")
    @PostMapping("/add")
    public Result<String> addToCart(@RequestBody @Valid CartAddDTO addDTO) {
        logger.info("添加商品到购物车: {}", addDTO);
        return cartService.addToCart(addDTO);
    }

    @Operation(summary = "购物车商品数量")
    @GetMapping("/count")
    public Result<Integer> getCartCount() {
        logger.info("获取购物车商品数量");
        return cartService.count();
    }

    @Operation(summary = "支付成功清除购物车")
    @PostMapping("/clear")
    public Result<CartClearVO> deleteCartItems(@RequestBody @Valid CartClearDTO clearDTO) {
        logger.info("清除购物车: {}",clearDTO.getCartItemIds());
        return cartService.deleteCartItems(clearDTO.getCartItemIds());
    }
}