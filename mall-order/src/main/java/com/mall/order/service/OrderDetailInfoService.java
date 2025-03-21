package com.mall.order.service;

import com.mall.common.result.Result;
import com.mall.order.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailInfoService {
     Result<List<OrderDetail>> getOrderDetailInfoByOrderId(Long orderId);
}
