package com.mall.order.service;

import com.mall.common.result.Result;
import com.mall.order.pojo.OrderDetail;
import com.mall.order.pojo.dto.OrdersDTO;

public interface OrdersAddService {
    Result<String> addOrders(OrdersDTO ordersDTO);
}
