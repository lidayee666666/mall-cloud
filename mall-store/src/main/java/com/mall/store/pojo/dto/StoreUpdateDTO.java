package com.mall.store.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("store")
public class StoreUpdateDTO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商家名称
     */
    private String name;
    /**
     * 商家状态，1启用，0关闭
     */
    private boolean status;
    /**
     * 是否平台级商家
     */
    private boolean isPlatform;

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

}
