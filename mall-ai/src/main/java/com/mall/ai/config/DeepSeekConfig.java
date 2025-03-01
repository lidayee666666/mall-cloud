package com.mall.ai.config;

import lombok.Data;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConfigurationProperties(prefix = "deepseek.api")
@Data
public class DeepSeekConfig {
    private String key;
    private String url;
    private int timeout;
    private int retry;
    private int connectTimeout;
    private int readTimeout;
    private int writeTimeout;

    @Bean
    public OkHttpClient deepseekHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    int retryCount = 0;
                    Response response = null;
                    while (retryCount < retry) {
                        try {
                            response = chain.proceed(request);
                            if (response.isSuccessful()) {
                                return response;
                            }
                        } catch (Exception e) {
                            //log.warn("请求失败，正在重试: " + (retryCount + 1));
                        }
                        retryCount++;
                        if (response != null) {
                            response.close();
                        }
                    }
                    return chain.proceed(request);
                })
                .build();
    }
}