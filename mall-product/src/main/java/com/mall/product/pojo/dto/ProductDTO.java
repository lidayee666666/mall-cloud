package com.mall.product.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@ApiModel(description = "商品数据传输对象")
public class ProductDTO {
    @ApiModelProperty("商品id")
    private Long id;
    @ApiModelProperty("所属商家id")
    private Long storeId;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("价格（分）")
    @JsonIgnore
    private Integer price;

    @ApiModelProperty("价格（元）")
    @JsonInclude(JsonInclude.Include.ALWAYS) // 确保始终包含该字段
    public BigDecimal getPriceYuan() {
        if (price == null) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP); // 处理null，返回0.00元
        }
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