package com.mall.common.exception;

/**
 * 删除不被允许异常
 */
public class DeletionNotAllowedException extends BaseException {
    public DeletionNotAllowedException(String msg) {
        super(msg);
    }
}
