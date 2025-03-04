package com.mall.order.service;

import com.mall.common.result.Result;
import com.mall.order.pojo.Orders;

import java.util.List;

public interface OrderInfoService {
    Result<List<Orders>> getOrderInfoByUserId();
}
