package com.mall.api.domain.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李青龙
 * @date 2025/04/12 17:13
 * 功能描述:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县/区
     */
    private String town;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 详细地址
     */
    private String street;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 是否是默认地址（1为默认，0为否）
     */
    @TableField("is_default")
    private Boolean isDefault;

    /**
     * 备注
     */
    private String notes;

}