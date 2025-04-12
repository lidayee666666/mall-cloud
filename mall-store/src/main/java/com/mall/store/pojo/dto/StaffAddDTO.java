package com.mall.store.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StaffAddDTO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //员工的用户表id
    private Long userId;

    //员工所属商家id
    private Long storeId;

    /**
     * 员工状态，1启用，0关闭
     */
    private Long status;

    /**
     * 职位名称
     */
    private String position;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 修改时间
     */
    private LocalDateTime updatedAt;
}
