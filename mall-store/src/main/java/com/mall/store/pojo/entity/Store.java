package com.mall.store.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Data
@TableName("staff")
public class Store {
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
     * 创建时间
     */
    private LocalDateTime createAt;
}
