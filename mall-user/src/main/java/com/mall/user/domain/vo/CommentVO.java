package com.mall.user.domain.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentVO {
     //后端传回来id user.avatar user.Nickname commentTime Content replyCount
     private Long id;
    private Long userId;
    private String avatar;
    private String username;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date comTime;
    private Long replyCount;//回复个数
}
