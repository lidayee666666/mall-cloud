package com.mall.cart.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author 李青龙
 * @date 2025/03/15 16:15
 * 功能描述: 购物车条目实体类
 */
@Getter
@Setter
@TableName(value = "cart")
public class Cart {

    /**
     * 购物车条目id
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 商品id
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 购买数量
     */
    @TableField("num")
    private Integer num;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 价格,单位/分
     */
    @TableField("price")
    private Integer price; // 改为整型存储分

    /**
     * 前端展示价格（元）
     */
    @JsonInclude // 确保该字段被序列化
    public BigDecimal getPriceYuan() {
        return BigDecimal.valueOf(price)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    /**
     * 商品图片
     */
    @TableField("image")
    private String image;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 删除时间，若为空则表示未删除
     */
    @TableField("deleted_at")
    private LocalDateTime deletedAt;

    /**
     * 商品属性，如颜色、尺寸等
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private Map<String, Object> attributes;
    // 如果需要更复杂的 JSON 处理，可以考虑使用 Jackson 或 Gson 库将 JSON 字符串转换为对象
}