package com.mall.product.pojo.doc;

import com.mall.product.pojo.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author flash
 * date 2025/03/23 20:46
 * 功能描述:
 */
@Data
@NoArgsConstructor
public class ProductDoc implements Serializable {

    private static final long serialVersionUID = 11L;

    /**
     * 商品id
     */
    private Long id;

    /**
     * 对应商家名称
     */
    private Long storeId;

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

    public ProductDoc(Product product, String storeName) {
        this.id = product.getId();
        this.storeId = product.getStoreId();
        this.storeName = storeName;
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.image = product.getImage();
        this.category = product.getCategory();
        this.sold = product.getSold();
        this.commentCount = product.getCommentCount();
    }
}
