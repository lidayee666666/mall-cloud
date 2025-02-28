package com.mall.user.controller;

import com.wf.captcha.SpecCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Api(tags = "验证码接口")
public class CaptchaController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/captcha")
    @ApiOperation("生成验证码")
    public Map<String, String> captcha() throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();//生成验证码
        String key = UUID.randomUUID().toString();//在后端生成一个随机的key
        System.out.println(key + " " + verCode);
        // 存入redis并设置过期时间为1分钟
        redisTemplate.opsForValue().set(key, verCode, 10, TimeUnit.MINUTES);
        Map<String, String> map = new HashMap<>();
        map.put("verKey", key);
        map.put("code", verCode);
        map.put("verCode", specCaptcha.toBase64());//把生成图片验证码,转为base64格式
        map.put("error_message", "生成成功");
        // 将key和base64返回给前端
        return map;
    }
}
