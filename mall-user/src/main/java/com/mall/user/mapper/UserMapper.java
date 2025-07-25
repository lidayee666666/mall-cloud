package com.mall.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.api.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
