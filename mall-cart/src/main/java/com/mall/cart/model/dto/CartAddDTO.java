package com.mall.cart.model.dto;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;

// CartAddDTO.java
@Data
public class CartAddDTO {
    @NotNull(message = "商品ID不能为空")
    private Long productId;

    @NotNull(message = "商品数量不能为空")
    @Min(value = 1, message = "商品数量必须大于0")
    private Integer num; // 修改字段名

    private Map<String, Object> attributes; // 商品属性
}