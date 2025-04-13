package com.mall.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Schema(name = "ProductDTO", description = "商品数据传输对象")
public class ProductDTO {
    @Schema(description = "商品id", example = "1")
    private Long id;

    @Schema(description = "所属商家id", example = "1001")
    private Long storeId;

    @Schema(description = "商品名称", example = "高端智能手机")
    private String name;

    @Schema(description = "价格（分）", hidden = true)
    @JsonIgnore
    private Integer price;

    @Schema(description = "价格（元）", example = "5999.00", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonInclude(JsonInclude.Include.ALWAYS)
    public BigDecimal getPriceYuan() {
        if (price == null) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.valueOf(price)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    @Schema(description = "库存数量", example = "100")
    private Integer stock;

    @Schema(description = "商品图片URL", example = "https://example.com/image.jpg")
    private String image;

    @Schema(description = "类目名称", example = "电子产品")
    private String category;

    @Schema(description = "销量", example = "500")
    private Integer sold;

    @Schema(description = "评论数", example = "120")
    private Integer commentCount;

    @Schema(description = "商品状态: 1-正常, 2-下架, 3-删除", example = "1")
    private Integer status;
}