package com.mall.common.exception;


/**
 * 业务异常
 */
public class CategoryNotFoundException extends BaseException {
    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
