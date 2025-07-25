package com.mall.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mall.common.result.Result;
import com.mall.user.config.CaptchaBlockHandler;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class CaptchaController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/captcha")
    @SentinelResource(
            value = "captcha-api",  // 资源名称
            blockHandler = "captchaBlockHandler",  // 限流处理方法
            blockHandlerClass = CaptchaBlockHandler.class  // 限流处理类
    )

    public Result<Map<String, String>> captcha() {
        log.info("用户获取验证码");
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(key, verCode, 10, TimeUnit.MINUTES);

        Map<String, String> map = new HashMap<>();
        map.put("verKey", key);
        map.put("code", verCode);
        map.put("verCode", specCaptcha.toBase64());
        map.put("error_message", "生成成功");
        return Result.success(map);
    }
}
