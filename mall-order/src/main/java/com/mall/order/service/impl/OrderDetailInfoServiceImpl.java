package com.mall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.result.Result;
import com.mall.order.mapper.OrderDetailMapper;
import com.mall.order.pojo.OrderDetail;
import com.mall.order.service.OrderDetailInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailInfoServiceImpl implements OrderDetailInfoService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Result<List<OrderDetail>> getOrderDetailInfoByOrderId(Long orderId) {
        QueryWrapper<OrderDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        List<OrderDetail> orderDetailList = orderDetailMapper.selectList(queryWrapper);
//        System.out.println(orderDetailList);
        return Result.success(orderDetailList);
    }
}
