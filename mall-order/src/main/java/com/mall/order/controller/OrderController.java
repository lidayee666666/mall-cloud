package com.mall.order.controller;


import cn.hutool.core.bean.BeanUtil;
import com.mall.common.result.Result;
import com.mall.order.pojo.OrderDetail;
import com.mall.order.pojo.Orders;
import com.mall.order.pojo.dto.OrdersDTO;
import com.mall.order.pojo.vo.OrderDetailVO;
import com.mall.order.pojo.vo.OrdersVO;
import com.mall.order.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "订单服务接口")
@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private OrdersAddService ordersAddService;
    @ApiOperation("添加订单")
    @PostMapping("/api/add")
    public Result<String> addOrders(@RequestBody OrdersDTO ordersDTO) {
        return ordersAddService.addOrders(ordersDTO);
    }

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation("根据用户Id获取其订单")
    @PostMapping("/api/infoByUserId")
    public Result<List<OrdersVO>> getOrderInfoByUserId() {
            return Result.success(orderInfoService.getOrderInfoByUserId());
    }

    @Autowired
    private OrderDetailInfoService orderDetailInfoService;
    @ApiOperation("根据订单Id获取订单详情")
    @PostMapping("/api/infoByOrderId")
    public Result<List<OrderDetailVO>> getOrderDetailInfoByOrderId(@RequestBody Long orderId) {
        Result<List<OrderDetail>> result = orderDetailInfoService.getOrderDetailInfoByOrderId(orderId);
        List<OrderDetailVO> voList = result.getData().stream()
                .map(OrderDetailVO::fromEntity)
                .collect(Collectors.toList());
        return Result.success(voList);
    }

    @Autowired
    private OrdersPaidService ordersPaidService;
    @ApiOperation("支付结束后更改订单状态和支付时间")
    @PostMapping("/api/paymentUpdate")
    public Result<String> updateOrdersPaid(@RequestBody Long orderId) {
        return ordersPaidService.updateOrdersPaid(orderId);
    }

    @Autowired
    private OrdersConsignService ordersConsignService;
    @ApiOperation("发货后更改订单状态和发货时间")
    @PostMapping("/api/consignUpdate")
    public Result<String> consign(@RequestBody  Long orderId) {
        return ordersConsignService.consign(orderId);
    }
}
