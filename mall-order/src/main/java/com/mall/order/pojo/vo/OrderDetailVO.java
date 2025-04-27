package com.mall.order.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mall.order.pojo.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李青龙
 * @date 2025/03/16 17:39
 * 功能描述:
 */
@Data
public class OrderDetailVO {
    private Long id;
    private Long orderId;

    private Long productId;

    private String name;

    private BigDecimal totalFeeYuan;
    private Integer paymentType;//支付类型
    private Integer status;//订单状态
    private Integer num;

    private BigDecimal priceYuan;
    private String image;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    public static OrderDetailVO fromEntity(OrderDetail detail) {
        OrderDetailVO vo = new OrderDetailVO();
        vo.setId(detail.getId());
        vo.setProductId(detail.getProductId());
        vo.setName(detail.getName());
        vo.setNum(detail.getNum());
        vo.setCreateTime(detail.getCreateTime());
        vo.setPriceYuan(detail.getPriceYuan());
        vo.setTotalFeeYuan(detail.getPriceYuan());
        vo.setImage(detail.getImage());
        vo.setOrderId(detail.getOrderId());
        return vo;
    }
}