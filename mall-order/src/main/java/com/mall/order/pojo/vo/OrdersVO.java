package com.mall.order.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mall.order.pojo.Orders;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李青龙
 * @date 2025/03/16 17:38
 * 功能描述:
 */
@Data
public class OrdersVO {
    private Long id;
    private String name;
    private BigDecimal totalFeeYuan;
    private Integer paymentType;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    public static OrdersVO fromEntity(Orders orders) {
        OrdersVO vo = new OrdersVO();
        vo.setId(orders.getId());
        vo.setName(orders.getName());
        vo.setTotalFeeYuan(orders.getTotalFeeYuan());
        vo.setPaymentType(orders.getPaymentType());
        vo.setStatus(orders.getStatus());
        vo.setCreateTime(orders.getCreateTime());
        return vo;
    }
}