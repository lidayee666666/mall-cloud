package com.mall.order.service;

import com.mall.common.result.Result;

public interface OrdersConsignService {
    Result<String> consign(Long orderId);

    Integer getStatus(Long id);

}
