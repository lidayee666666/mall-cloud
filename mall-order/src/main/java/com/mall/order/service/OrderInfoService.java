package com.mall.order.service;



import com.mall.order.pojo.vo.OrderDetailVO;
import com.mall.order.pojo.vo.OrdersVO;

import java.util.List;

public interface OrderInfoService {
    List<OrderDetailVO> getOrderInfoByUserId();
}
