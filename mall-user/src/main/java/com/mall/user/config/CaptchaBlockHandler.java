package com.mall.user.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mall.common.result.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李青龙
 * @date 2025/07/20 21:11
 * @description 功能描述:
 * @since JDK 1.8
 */
public class CaptchaBlockHandler {

    // 正确的限流处理方法签名
    public static Result<Map<String, String>> captchaBlockHandler(BlockException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "验证码获取太频繁，请稍后再试");
        return Result.error(429, "请求过于频繁,请稍后重试", map);
    }



}
