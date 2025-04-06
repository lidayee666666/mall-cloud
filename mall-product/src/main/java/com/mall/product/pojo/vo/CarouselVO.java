package com.mall.product.pojo.vo;

import io.prometheus.client.Summary;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 李青龙
 * @date 2025/04/06 11:27
 * 功能描述:
 */
@Getter
@Setter
public class CarouselVO {
    @Schema(description = "商品分类名称")
    private String category;

    @Schema(description = "商品图片地址")
    private String image;
}
