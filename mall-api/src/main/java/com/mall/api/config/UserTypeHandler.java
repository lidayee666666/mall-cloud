package com.mall.api.config;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.mall.api.domain.enums.UserType;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author 李青龙
 * @date 2025/04/12 17:42
 * 功能描述:
 */
@MappedTypes(UserType.class)
public class UserTypeHandler extends AbstractJsonTypeHandler<UserType> {

    @Override
    protected UserType parse(String json) {
        return UserType.fromValue(json);
    }

    @Override
    protected String toJson(UserType obj) {
        return obj.getValue();
    }
}