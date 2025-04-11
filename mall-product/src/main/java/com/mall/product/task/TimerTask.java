package com.mall.product.task;

import com.mall.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author flash
 * date 2025/03/25 17:20
 * 功能描述:
 */
@Component
public class TimerTask {

    @Autowired
    private ProductService productService;

    // 指定每日的 00:00 执行, 更新redis的热门景点, 重新获取数据库中热门景点的数据
    /*
        0 秒
        0 分钟
        0 小时（即午夜）
        * 日（每天）
        * 月（每个月）
        ? 星期（不指定）
    */
    @Scheduled(cron = "0 0 0 * * ?")
    //@Scheduled(fixedRate = 20 * 60 * 1000)
    public void productToES() {
        // 添加到ES中
        try {
            productService.saveProductsToES();
        } catch (IOException e) {
            throw new RuntimeException("添加数据至ES失败");
        }
    }
}
