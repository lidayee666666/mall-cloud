package com.mall.cart.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 李青龙
 * @date 2025/03/15 16:28
 * 功能描述:
 */
@Getter
@Setter
public class CartUpdateDTO {
    private Long productId;
    private Integer quantity;
}
