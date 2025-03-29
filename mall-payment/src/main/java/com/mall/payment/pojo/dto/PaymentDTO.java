package com.mall.payment.pojo.dto;


import lombok.Data;

import java.util.List;

@Data
public class PaymentDTO {
    //购物车id
    private List<String>cartIds;
    //总金额
    private Integer totalAmount;
}
