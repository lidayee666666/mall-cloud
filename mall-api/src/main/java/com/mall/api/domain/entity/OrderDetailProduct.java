package com.mall.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailProduct {

    private Long id;
    private String name;
    private Integer price; // 改为Integer类型（分单位）
    private Integer stock;
    private String image;
    private Integer status;

    // 添加元单位转换方法
    public BigDecimal getPriceYuan() {
        return BigDecimal.valueOf(price)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}