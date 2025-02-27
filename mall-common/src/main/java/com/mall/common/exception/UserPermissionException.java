package com.mall.common.exception;

/**
 * 用户权限异常，进行了权限以上的操作
 */
public class UserPermissionException extends BaseException{
    public UserPermissionException(String msg) {
        super(msg);
    }
}
