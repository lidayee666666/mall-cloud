package com.mall.user.controller;

import com.mall.common.result.Result;
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
    public Result<Map<String, String>> captcha() throws Exception {
        log.info("用户获取验证码");
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();//生成验证码
        String key = UUID.randomUUID().toString();//在后端生成一个随机的key
        // 存入redis并设置过期时间为1分钟
        redisTemplate.opsForValue().set(key, verCode, 10, TimeUnit.MINUTES);
        Map<String, String> map = new HashMap<>();
        map.put("verKey", key);
        map.put("code", verCode);
        map.put("verCode", specCaptcha.toBase64());//把生成图片验证码,转为base64格式
        map.put("error_message", "生成成功");
        // 将key和base64返回给前端
        return Result.success(map);
    }
}
