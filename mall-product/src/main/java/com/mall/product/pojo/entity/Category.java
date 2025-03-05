package com.mall.product.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("categories")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 种类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 种类名称
     */
    private String category;

    /**
     * 商品数量
     */
    private Long productNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 修改人
     */
    private Long updater;

}
