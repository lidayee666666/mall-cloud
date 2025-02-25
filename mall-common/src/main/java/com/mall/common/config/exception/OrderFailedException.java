package com.mall.common.config.exception;


/**
 * 订单失败异常
 */
public class OrderFailedException extends BaseException {

    public OrderFailedException(String msg) {
            super(msg);
    }
}
