package com.mall.order.service.impl;

import com.mall.common.result.Result;
import com.mall.order.mapper.OrdersMapper;
import com.mall.order.pojo.Orders;
import com.mall.order.service.OrdersPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrdersPaidServiceImpl implements OrdersPaidService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Result<String> updateOrdersPaid(Long orderId) {
        Orders orders = ordersMapper.selectById(orderId);
        orders.setStatus(2);
        orders.setPaymentType(6);
        Date date = new Date();
        orders.setUpdateTime(date);
        orders.setPayTime(date);
        ordersMapper.updateById(orders);
        return Result.success("修改订单支付状态成功！");
    }
}
