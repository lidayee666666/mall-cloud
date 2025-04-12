package com.mall.api.domain.enums;

/**
 * @author 李青龙
 * @date 2025/04/12 17:41
 * 功能描述:
 */
public enum UserType {
    CUSTOMER("customer"), // 普通顾客
    STAFF("staff");       // 商家员工

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * 根据字符串值获取对应的枚举类型
     */
    public static UserType fromValue(String value) {
        for (UserType userType : UserType.values()) {
            if (userType.getValue().equalsIgnoreCase(value)) {
                return userType;
            }
        }
        throw new IllegalArgumentException("未知的用户类型: " + value);
    }
}
