package com.mall.store.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("staff")
public class Staff {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商家名称
     */
    private Long user_id;
    /**
     * 商家状态，1启用，0关闭
     */
    private Long store_id;
    /**
     * 创建时间
     */
    private String position;
}
