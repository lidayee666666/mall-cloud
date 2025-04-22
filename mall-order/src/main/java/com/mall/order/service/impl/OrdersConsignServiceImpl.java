package com.mall.order.service.impl;

import com.mall.common.result.Result;
import com.mall.order.mapper.OrdersMapper;
import com.mall.order.pojo.Orders;
import com.mall.order.service.OrdersConsignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrdersConsignServiceImpl implements OrdersConsignService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Result<String> consign(Long orderId) {
        Orders orders = ordersMapper.selectById(orderId);
        orders.setStatus(3);
        Date date = new Date();
        orders.setUpdateTime(date);
        orders.setConsignTime(date);
        ordersMapper.updateById(orders);
        return Result.success("修改订单发货状态成功！");
    }

    @Override
    public Integer getStatus(Long id) {
        return ordersMapper.selectById(id).getStatus();
    }


}
