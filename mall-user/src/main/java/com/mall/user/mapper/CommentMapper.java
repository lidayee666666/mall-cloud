package com.mall.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.user.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
