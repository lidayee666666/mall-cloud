package com.mall.order.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "OrdersDTO", description = "订单DTO")
public class OrdersDTO {

    @Schema(description = "key：商品id，value：商品购买数量")
    private Map<Long, Integer> items;

    @Schema(description = "支付类型")
    private Integer paymentType;
}