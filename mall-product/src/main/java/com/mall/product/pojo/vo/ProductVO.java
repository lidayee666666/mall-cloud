package com.mall.product.pojo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 李青龙
 * date 2025/03/17 15:37
 * 功能描述:
 */
@Data
@NoArgsConstructor
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 12L;

    /**
     * 商品id
     */
    private Long id;

    /**
     * 对应商家id
     */
    private String storeId;

    /**
     * 对应商家名称
     */
    private String storeName;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格（分）
     */
    private Integer price;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 类目名称
     */
    private String category;

    /**
     * 销量
     */
    private Integer sold;

    /**
     * 评论数
     */
    private Integer commentCount;

}
