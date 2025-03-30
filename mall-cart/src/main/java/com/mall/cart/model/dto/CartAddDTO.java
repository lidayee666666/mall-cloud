package com.mall.cart.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Map;

@Data
@Schema(description = "购物车添加商品DTO")
public class CartAddDTO {
    @Schema(description = "商品ID", required = true, example = "12345")
    @NotNull(message = "商品ID不能为空")
    private Long productId;

    @Schema(description = "商品数量", required = true, example = "1")
    @NotNull(message = "商品数量不能为空")
    @Min(value = 1, message = "商品数量必须大于0")
    private Integer num;

    @Schema(description = "商品属性", example = "{\"color\":\"red\",\"size\":\"XL\"}")
    private Map<String, Object> attributes;
}