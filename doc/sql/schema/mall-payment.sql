DROP DATABASE IF EXISTS `mall-payment`;
CREATE DATABASE IF NOT EXISTS `mall-payment`;

USE `mall-payment`;

DROP TABLE IF EXISTS `payment`;

CREATE TABLE IF NOT EXISTS `payment` (
                                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
                                         `biz_order_no` bigint NOT NULL COMMENT '业务订单号',
                                         `pay_order_no` bigint NOT NULL DEFAULT '0' COMMENT '支付单号',
                                         `biz_user_id` bigint NOT NULL COMMENT '支付用户id',
                                         `pay_channel_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '支付渠道编码',
    `amount` INT NOT NULL COMMENT '支付金额，单位/分',
    `pay_type` tinyint NOT NULL DEFAULT '5' COMMENT '支付类型，1：h5,2:小程序，3：公众号，4：扫码，5：余额支付，6：支付宝，7：微信支付',
    `status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态，0：待提交，1:待支付，2：支付超时或取消，3：支付成功，4：退款中，5：已退款',
    `expand_json` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '拓展字段，用于传递不同渠道单独处理的字段',
    `result_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '第三方返回业务码',
    `result_msg` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '第三方返回提示信息',
    `response_json` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '第三方返回的完整响应内容',
    `pay_success_time` timestamp NULL DEFAULT NULL COMMENT '支付成功时间',
    `pay_over_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '支付超时时间',
    `qr_code_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付二维码链接',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator` bigint NOT NULL DEFAULT '0' COMMENT '创建人',
    `updater` bigint NOT NULL DEFAULT '0' COMMENT '更新人',
    `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `biz_order_no` (`biz_order_no`) USING BTREE,
    UNIQUE KEY `pay_order_no` (`pay_order_no`) USING BTREE,
    KEY `idx_biz_user_id` (`biz_user_id`) USING BTREE,
    KEY `idx_pay_channel_code` (`pay_channel_code`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='支付订单';