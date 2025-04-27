package com.mall.order.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("`order-detail`")
public class OrderDetail {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long orderId;
    private Long userId;
    private Long productId;
    private Integer num;
    private String name;//商品名称
    private Integer price; // 单位：分
    private String image;//商品图片
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;

    // 前端展示用元单位
    //@TableField(exist = false)
    public BigDecimal getPriceYuan() {
        return BigDecimal.valueOf(price)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}