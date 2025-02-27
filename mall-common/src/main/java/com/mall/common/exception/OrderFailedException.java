package com.mall.common.exception;


/**
 * 订单失败异常
 */
public class OrderFailedException extends BaseException {

    public OrderFailedException(String msg) {
            super(msg);
    }
}
