package com.mall.cart.model.vo;

import com.mall.cart.model.po.Cart;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author 李青龙
 * @date 2025/03/16 17:26
 * 功能描述:
 */
@Data
public class CartVO {
    private String id;
    private Long productId;
    private String name;
    private Integer num;
    private BigDecimal priceYuan; // 元单位
    private String image;
    private Map<String, Object> attributes;

    public static CartVO fromEntity(Cart cart) {
        CartVO vo = new CartVO();
        vo.setId(String.valueOf(cart.getId()));
        vo.setProductId(cart.getProductId());
        vo.setName(cart.getName());
        vo.setNum(cart.getNum());
        vo.setPriceYuan(cart.getPriceYuan());
        vo.setImage(cart.getImage());
        vo.setAttributes(cart.getAttributes());
        return vo;
    }
}