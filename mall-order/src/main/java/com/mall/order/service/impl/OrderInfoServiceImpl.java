package com.mall.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.utils.UserContext;
import com.mall.order.mapper.OrderDetailMapper;
import com.mall.order.mapper.OrdersMapper;
import com.mall.order.pojo.OrderDetail;
import com.mall.order.pojo.Orders;
import com.mall.order.pojo.vo.OrderDetailVO;
import com.mall.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;


    @Override
    public List<OrderDetailVO> getOrderInfoByUserId() {

        Long userId = UserContext.getUser();

        QueryWrapper<OrderDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        List<OrderDetail> list = orderDetailMapper.selectList(queryWrapper);


        List<OrderDetailVO> collect = list.stream()
                .map(OrderDetailVO::fromEntity)
                .collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {
            Orders orders = ordersMapper.selectById(collect.get(i).getOrderId());
            collect.get(i).setStatus(orders.getStatus());
            collect.get(i).setPaymentType(orders.getPaymentType());
        }

        return collect;
    }
}
