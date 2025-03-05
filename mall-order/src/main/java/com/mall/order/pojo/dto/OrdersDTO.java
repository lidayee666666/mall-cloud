package com.mall.order.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "订单DTO")
public class OrdersDTO {
    @ApiModelProperty("key：商品id，value：商品购买数量")
    private Map<Long, Integer> items;
    @ApiModelProperty("支付类型")
    private Integer paymentType;
}
