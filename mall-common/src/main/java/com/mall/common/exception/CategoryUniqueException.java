package com.mall.common.exception;


/**
 * 业务异常
 */
public class CategoryUniqueException extends BaseException {
    public CategoryUniqueException() {
    }

    public CategoryUniqueException(String msg) {
        super(msg);
    }
}
