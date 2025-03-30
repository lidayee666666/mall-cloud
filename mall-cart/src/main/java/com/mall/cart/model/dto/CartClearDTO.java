package com.mall.cart.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

@Data
@Schema(description = "购物车清空DTO")
public class CartClearDTO {
    @Schema(description = "购物车项ID列表", required = true, example = "[\"1\",\"2\",\"3\"]")
    @NotEmpty(message = "购物车项ID列表不能为空")
    private List<String> cartItemIds;
}