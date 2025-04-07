package com.mall.common.handler;

import com.mall.common.constant.MessageConstant;
import com.mall.common.exception.BaseException;
import com.mall.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     */
    @ExceptionHandler(BaseException.class)
    public Result handleBaseException(BaseException ex) {
        log.error("捕获到业务异常：", ex);
        return Result.error(ex.getMessage());
    }

    /**
     * 处理SQL约束冲突异常
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        log.error("捕获到SQL约束冲突异常：", ex);

        String message = ex.getMessage();
        if (message != null && message.contains("Duplicate entry")) {
            try {
                String[] split = message.split(" ");
                if (split.length > 2) {
                    String conflictingValue = split[2];
                    return Result.error(conflictingValue + MessageConstant.ALREADY_EXISTS);
                }
            } catch (Exception parseEx) {
                log.error("解析SQL异常消息失败：", parseEx);
            }
        }

        return Result.error(MessageConstant.DATABASE_CONSTRAINT_ERROR);
    }

    /**
     * 捕获非法参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("捕获到非法参数异常：", ex);
        return Result.error(MessageConstant.INVALID_PARAMETER);
    }

    /**
     * 捕获空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Result handleNullPointerException(NullPointerException ex) {
        log.error("捕获到空指针异常：", ex);
        return Result.error(MessageConstant.NULL_POINTER_ERROR);
    }

    /**
     * 捕获未知异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleUnknownException(Exception ex) {
        log.error("捕获到未知异常：", ex);
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }
}