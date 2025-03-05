package com.mall.order.service.impl;

import com.mall.api.client.ProductClient;
import com.mall.api.domain.entity.OrderDetailProduct;
import com.mall.common.result.Result;
import com.mall.common.utils.UserContext;
import com.mall.order.mapper.OrderDetailMapper;
import com.mall.order.mapper.OrdersMapper;
import com.mall.order.pojo.OrderDetail;
import com.mall.order.pojo.Orders;
import com.mall.order.pojo.dto.OrdersDTO;
import com.mall.order.service.OrdersAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersAddServiceImpl implements OrdersAddService {
    @Autowired
    private ProductClient productClient;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Result<String> addOrders(OrdersDTO ordersDTO) {
        if (ordersDTO == null) {
            Result.error("订单为空");
        }
        Map<Long, Integer> items = ordersDTO.getItems();
        Integer totalFee = 0;
        Map<OrderDetailProduct, Integer> orderDetailProducts = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : items.entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();
            OrderDetailProduct orderDetailProduct = productClient.getById(productId).getData();

            if (orderDetailProduct == null) {
                return Result.error("商品" + productId + "不存在");
            }

            if (quantity > orderDetailProduct.getStock()) {
                return Result.error("库存不足");
            }
            orderDetailProducts.put(orderDetailProduct, quantity);
            totalFee += quantity * orderDetailProduct.getPrice();
        }

        Orders orders = new Orders(null,
                totalFee,
                ordersDTO.getPaymentType(),
                UserContext.getUser(),
                1,
                null,
                null,
                null,
                null,
                null,
                null,
                null
                );
        ordersMapper.insert(orders);
        System.out.println(orders.getId());

        for (Map.Entry<OrderDetailProduct, Integer> entry : orderDetailProducts.entrySet()) {
            OrderDetailProduct orderDetailProduct = entry.getKey();
            Integer quantity = entry.getValue();
            OrderDetail orderDetail = new OrderDetail(null,
                    orders.getId(),
                    orderDetailProduct.getId(),
                    quantity,
                    orderDetailProduct.getName(),
                    orderDetailProduct.getPrice(),
                    orderDetailProduct.getImage(),
                    null,
                    null
                    );
            orderDetailMapper.insert(orderDetail);
        }
        return Result.success("下单成功！");
    }
}
