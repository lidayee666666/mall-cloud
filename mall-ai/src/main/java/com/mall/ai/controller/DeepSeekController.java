package com.mall.ai.controller;


import com.mall.ai.service.impl.DeepSeekService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Tag(name = "DeepSeek")
@RestController
public class DeepSeekController {

    private final DeepSeekService deepSeekService;

    public DeepSeekController(DeepSeekService deepSeekService) {
        this.deepSeekService = deepSeekService;
    }

    @GetMapping(value = "/ai/api/deepseek/chat-stream", produces = "text/event-stream")
    public SseEmitter chatStream(@RequestParam String message) {
        return deepSeekService.chatStream(message);
    }
}