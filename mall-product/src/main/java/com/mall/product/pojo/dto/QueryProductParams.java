package com.mall.product.pojo.dto;

import com.mall.common.domain.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author flash
 * date 2025/03/26 11:06
 * 功能描述:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryProductParams extends PageQuery {
    // 搜索关键词
    private String keyword;

    // 商品名称
    private String name;
    // 商品最低价格
    private Integer minPrice;
    // 商品最高价格
    private Integer maxPrice;
    // 销售量
    private Integer sold;
    // 剩余库存
    private Integer stock;
    // 商家名称
    private String storeName;
    // 商品分类名称
    private String category;
    // 评论数量
    private Integer commentCount;
}
