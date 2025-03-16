package com.mall.order.service;



import com.mall.order.pojo.vo.OrdersVO;

import java.util.List;

public interface OrderInfoService {
    List<OrdersVO> getOrderInfoByUserId();
}
