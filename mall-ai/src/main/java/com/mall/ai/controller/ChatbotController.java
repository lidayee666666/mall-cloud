package com.mall.ai.controller;

import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.reactivex.Flowable;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.concurrent.atomic.AtomicInteger;

@Tag(name = "AI管理")
@RestController
@RequestMapping("/ai/api/chatbot")
public class ChatbotController {

    /**
     * 实现 chat 接口，支持流式返回数据
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public ResponseBodyEmitter streamData(@RequestBody String query) {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter(180000L);
        JsonObject jsonObject = new JsonParser().parse(query).getAsJsonObject();
        try {
            streamCall(emitter, jsonObject.get("prompt").getAsString());
        } catch (NoApiKeyException | InputRequiredException e) {
            e.printStackTrace();
        }

        return emitter;
    }

    /**
     * 调用百炼应用，封装流式返回数据
     * 返回数据格式
     * id:1
     * event:result
     * :HTTP_STATUS/200
     * data:{"output":{"session_id":"xxx","finish_reason":"null","text":"相关的问题"}}
     *
     * @param emitter
     * @param query
     * @throws NoApiKeyException
     * @throws InputRequiredException
     */
    public void streamCall(ResponseBodyEmitter emitter, String query) throws NoApiKeyException, InputRequiredException {
        // appId 填入百炼应用 ID
        ApplicationParam param = ApplicationParam.builder()
                .appId("dcbf796c9540418998dc5f09f9b812eb")
                .prompt(query)
                .incrementalOutput(true)
                .build();

        Application application = new Application();
        Flowable<ApplicationResult> result = application.streamCall(param);
        AtomicInteger counter = new AtomicInteger(0);
        result.blockingForEach(data -> {
            int newValue = counter.incrementAndGet();
            String resData = "id:" + newValue + "\nevent:result\n:HTTP_STATUS/200\ndata:" + new Gson().toJson(data) + "\n\n";
            emitter.send(resData.getBytes(java.nio.charset.StandardCharsets.UTF_8));

            if ("stop".equals(data.getOutput().getFinishReason())) {
                emitter.complete();
            }
        });

    }
}
