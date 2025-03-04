package com.mall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.order.mapper.OrdersMapper;
import com.mall.order.pojo.Orders;
import com.mall.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Result<List<Orders>> getOrderInfoByUserId() {
        Long userId = UserContext.getUser();
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<Orders> list = ordersMapper.selectList(queryWrapper);
        return Result.success(list);
    }
}
