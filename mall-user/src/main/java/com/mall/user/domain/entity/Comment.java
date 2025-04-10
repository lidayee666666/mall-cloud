package com.mall.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("comment")
public class Comment {
    private Long id;
    private Long productId;
    private Long userId;

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date comTime;
    private Long parentId;  // 父级评论ID，null 表示这是一级评论
    private Long replyCount;//回复个数

}
