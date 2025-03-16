package com.mall.product.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@ApiModel(description = "商品实体")
public class ProductDTO {
    @ApiModelProperty("商品id")
    private Long id;
    @ApiModelProperty("所属商家id")
    private Long storeId;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("价格（分）")
    private Integer price;

    /**
     * 前端展示价格（元）
     */
    @ApiModelProperty("价格（元）")
    @JsonInclude
    public BigDecimal getPriceYuan() {
        return BigDecimal.valueOf(price)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
    @ApiModelProperty("库存数量")
    private Integer stock;
    @ApiModelProperty("商品图片")
    private String image;
    @ApiModelProperty("类目名称")
    private String category;
    @ApiModelProperty("销量")
    private Integer sold;
    @ApiModelProperty("评论数")
    private Integer commentCount;
    @ApiModelProperty("商品状态 1-正常，2-下架，3-删除")
    private Integer status;
}
