DROP DATABASE IF EXISTS `mall-user`;
# 数据库名字统一与服务的名字相同
CREATE DATABASE IF NOT EXISTS `mall-user`;
USE `mall-user`;


DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
    `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码，加密存储',
    `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注册手机号',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `status` int DEFAULT '1' COMMENT '账户状态（1正常，0冻结）',
    `balance` int DEFAULT NULL COMMENT '账户余额，单位/分',
PRIMARY KEY (`id`),
UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';


DROP TABLE IF EXISTS `address`;

CREATE TABLE IF NOT EXISTS `address` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `user_id` bigint DEFAULT NULL COMMENT '用户ID',
    `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '省',
    `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '市',
    `town` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '县/区',
    `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
    `street` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '详细地址',
    `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系人',
    `is_default` tinyint DEFAULT NULL COMMENT '是否是默认 1(true)默认 0(false)否',
    `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT '地址表';
