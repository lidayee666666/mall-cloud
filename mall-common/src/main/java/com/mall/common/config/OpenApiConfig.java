package com.mall.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李青龙
 * @date 2025/03/30 13:54
 * 功能描述:
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("StarMarket商城API文档")
                        .version("1.0")
                        .description("StarMarket商城微服务系统API文档"));
    }
}