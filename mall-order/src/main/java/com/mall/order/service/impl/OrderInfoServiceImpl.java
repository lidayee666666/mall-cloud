package com.mall.order.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.order.mapper.OrderDetailMapper;
import com.mall.order.mapper.OrdersMapper;
import com.mall.order.pojo.OrderDetail;
import com.mall.order.pojo.Orders;
import com.mall.order.pojo.vo.OrderDetailVO;
import com.mall.order.pojo.vo.OrdersVO;
import com.mall.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrdersVO> getOrderInfoByUserId() {
        Long userId = UserContext.getUser();
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<Orders> list = ordersMapper.selectList(queryWrapper);

        // 使用 BeanUtil.copyToList 复制基本字段
        List<OrdersVO> orderDetailVOList = BeanUtil.copyToList(list, OrdersVO.class);

        // 手动设置 priceYuan 字段
        for (int i = 0; i < list.size(); i++) {
            Orders orders = list.get(i);
            OrdersVO ordersVO = orderDetailVOList.get(i);
            ordersVO.setTotalFeeYuan(orders.getTotalFeeYuan());
        }

        return orderDetailVOList;
    }
}
