package com.mall.payment.pojo.entity;

import lombok.Data;

/**
 * @author 李青龙
 * @date 2025/04/12 19:49
 * 功能描述:
 */
@Data
public class AliPay {
    private String traceNo;
    private double totalAmount;
    private String subject;
    private String alipayTraceNo;
}
