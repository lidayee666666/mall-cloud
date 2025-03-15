package com.mall.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailProduct {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String image;
    private Integer status;
}
