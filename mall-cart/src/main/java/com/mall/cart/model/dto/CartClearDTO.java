package com.mall.cart.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartClearDTO {
    private List<String>cartItemIds;
}
