package com.mall.ai.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.ai.config.DeepSeekConfig;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class DeepSeekService {
    private final OkHttpClient client;
    private final DeepSeekConfig config;
    private final ObjectMapper objectMapper;

    public DeepSeekService(OkHttpClient deepseekHttpClient, DeepSeekConfig config) {
        this.client = deepseekHttpClient;
        this.config = config;
        this.objectMapper = new ObjectMapper();
    }

    public SseEmitter chatStream(String message) {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        emitter.onCompletion(() -> {
            log.info("SSE 完成");
        });

        emitter.onTimeout(() -> {
            log.info("SSE 超时");
        });

        emitter.onError((ex) -> {
            log.error("SSE 错误", ex);
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                // 构建请求体
                Map<String, Object> requestBody = new HashMap<>();
                requestBody.put("model", "deepseek-chat");
                requestBody.put("stream", true);

                List<Map<String, String>> messages = new ArrayList<>();
                Map<String, String> userMessage = new HashMap<>();
                userMessage.put("role", "user");
                userMessage.put("content", message);
                messages.add(userMessage);
                requestBody.put("messages", messages);

                String jsonBody = objectMapper.writeValueAsString(requestBody);
                log.info("发送请求体: {}", jsonBody);

                // 构建请求
                Request request = new Request.Builder()
                        .url(config.getUrl())
                        .addHeader("Authorization", "Bearer " + config.getKey())
                        .addHeader("Content-Type", "application/json")
                        .post(RequestBody.create(MediaType.parse("application/json"), jsonBody))
                        .build();

                log.info("开始发送请求到: {}", config.getUrl());

                // 发送请求
                try (Response response = client.newCall(request).execute()) {
                    log.info("收到响应状态码: {}", response.code());

                    if (!response.isSuccessful()) {
                        String errorBody = response.body() != null ? response.body().string() : "无响应体";
                        log.error("API调用失败: {} - {}", response.code(), errorBody);
                        emitter.completeWithError(new RuntimeException("API调用失败: " + response.code()));
                        return;
                    }

                    ResponseBody responseBody = response.body();
                    if (responseBody == null) {
                        log.error("响应体为空");
                        emitter.completeWithError(new RuntimeException("响应体为空"));
                        return;
                    }

                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(responseBody.byteStream(), StandardCharsets.UTF_8))) {

                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.isEmpty()) {
                                continue;
                            }

                            log.debug("收到原始数据: {}", line);

                            if ("data: [DONE]".equals(line)) {
                                log.info("收到结束标记");
                                emitter.send(SseEmitter.event().data("[DONE]"));
                                break;
                            }

                            if (line.startsWith("data: ")) {
                                String jsonData = line.substring(6);
                                try {
                                    // 验证 JSON 数据格式
                                    JsonNode jsonNode = objectMapper.readTree(jsonData);
                                    log.debug("解析后的JSON数据: {}", jsonNode);
                                    emitter.send(SseEmitter.event().data(jsonData));
                                } catch (JsonProcessingException e) {
                                    log.error("JSON解析错误: {}", jsonData, e);
                                }
                            }
                        }
                    }
                }

                log.info("数据传输完成");
                emitter.complete();

            } catch (Exception e) {
                log.error("处理过程中发生错误", e);
                emitter.completeWithError(e);
            } finally {
                executor.shutdown();
            }
        });

        return emitter;
    }
}