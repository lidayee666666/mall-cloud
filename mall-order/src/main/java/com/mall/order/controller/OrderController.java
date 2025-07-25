package com.mall.order.controller;

import com.mall.common.result.Result;
import com.mall.order.pojo.OrderDetail;
import com.mall.order.pojo.dto.OrdersDTO;
import com.mall.order.pojo.vo.OrderDetailVO;
import com.mall.order.pojo.vo.OrdersVO;
import com.mall.order.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "订单服务接口")
@RestController
@RequestMapping(path = "/orders/api")
public class OrderController {
    @Autowired
    private OrdersAddService ordersAddService;


    @Operation(summary = "添加订单")
    @PostMapping("/add")
    public Result<String> addOrders(@RequestBody OrdersDTO ordersDTO) {
        return ordersAddService.addOrders(ordersDTO);
    }

    @Autowired
    private OrderInfoService orderInfoService;

    @Operation(summary = "根据用户Id获取其订单")
    @PostMapping("/infoByUserId")
    public Result<List<OrderDetailVO>> getOrderInfoByUserId() {
        return Result.success(orderInfoService.getOrderInfoByUserId());
    }

    @Autowired
    private OrderDetailInfoService orderDetailInfoService;

    @Operation(summary = "根据订单Id获取订单详情")
    @PostMapping("/infoByOrderId")
    public Result<List<OrderDetailVO>> getOrderDetailInfoByOrderId(@RequestBody Long orderId) {
        Result<List<OrderDetail>> result = orderDetailInfoService.getOrderDetailInfoByOrderId(orderId);
        List<OrderDetailVO> voList = result.getData().stream()
                .map(OrderDetailVO::fromEntity)
                .collect(Collectors.toList());
        return Result.success(voList);
    }

    @Autowired
    private OrdersPaidService ordersPaidService;

    @Autowired
    private OrdersConsignService ordersConsignService;

    @Operation(summary = "发货后更改订单状态和发货时间")
    @PostMapping("/payUpdate/{id}")
    public Result<String> payUpdate(@PathVariable Long id) {
        return ordersPaidService.updateOrdersPaid(id);
    }

    @Operation(summary = "发货后更改订单状态和发货时间")
    @PostMapping("/consignUpdate/{id}")
    public Result<String> consign(@PathVariable Long id) {
        return ordersConsignService.consign(id);
    }

    @GetMapping("/getStatus/{id}")
    public Result<Integer> getStatus(@PathVariable Long id) {
        return Result.success(ordersConsignService.getStatus(id));
    }
}