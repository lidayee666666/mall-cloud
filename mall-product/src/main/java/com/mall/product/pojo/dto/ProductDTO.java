package com.mall.product.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
