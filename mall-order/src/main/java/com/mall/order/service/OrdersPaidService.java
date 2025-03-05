package com.mall.order.service;

import com.mall.common.result.Result;

public interface OrdersPaidService {
    Result<String> updateOrdersPaid(Long orderId);
}
