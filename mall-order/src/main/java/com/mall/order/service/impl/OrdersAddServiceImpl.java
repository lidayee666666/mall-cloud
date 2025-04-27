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

import java.math.BigDecimal;
import java.util.HashMap;
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
            return Result.error("订单为空");
        }

        Map<Long, Integer> items = ordersDTO.getItems();
        int totalFee = 0; // 使用分单位计算

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

            totalFee += orderDetailProduct.getPrice() * quantity;
            orderDetailProducts.put(orderDetailProduct, quantity);
        }

        Orders orders = new Orders();
        orders.setTotalFee(totalFee);
        //orders.setPaymentType(ordersDTO.getPaymentType());
        orders.setUserId(UserContext.getUser());
        orders.setStatus(1);//未付款

        ordersMapper.insert(orders);

        for (Map.Entry<OrderDetailProduct, Integer> entry : orderDetailProducts.entrySet()) {

            OrderDetailProduct product = entry.getKey();

            Integer quantity = entry.getValue();

            OrderDetail orderDetail = new OrderDetail(null,
                    orders.getId(),
                    UserContext.getUser(),
                    product.getId(),
                    quantity,
                    product.getName(),
                    product.getPrice(), // 价格
                    product.getImage(),
                    null,
                    null

            );

            orderDetailMapper.insert(orderDetail);
        }
        return Result.success(String.valueOf(orders.getId()));
    }
}