package com.mall.store.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author 李青龙
 * @date 2025/04/12 16:28
 * 功能描述:
 */

@Getter
@Setter
@TableName("store_detail")
public class StoreDetail {
    /**
     * 关联商家ID
     */
    @TableId(value = "store_id", type = IdType.INPUT)
    private Long storeId;

    /**
     * 商家logo
     */
    private String logo;

    /**
     * 商家描述
     */
    private String description;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 营业执照图片
     */
    private String businessLicense;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime; // 使用 LocalDateTime 代替 timestamp
}