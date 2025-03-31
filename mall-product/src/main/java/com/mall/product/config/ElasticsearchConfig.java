package com.mall.product.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                                new HttpHost("localhost", 9200, "http")
                        )
                        // 7.6.1需要设置请求头
                        .setDefaultHeaders(new Header[]{
                                new BasicHeader("Content-Type", "application/json")
                        })
        );
    }
}