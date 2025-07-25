DROP DATABASE IF EXISTS `mall-order`;
CREATE DATABASE IF NOT EXISTS `mall-order`;

USE `mall-order`;

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单id',
    `total_fee` int NOT NULL DEFAULT '0' COMMENT '总金额，单位为分',
    `payment_type` tinyint unsigned NOT NULL COMMENT '支付类型，1：h5,2:小程序，3：公众号，4：扫码，5：余额支付，6：支付宝，7：微信支付',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `status` tinyint unsigned DEFAULT NULL COMMENT '订单的状态，1、未付款 2、已付款,未发货 3、已发货,未确认 4、确认收货，交易成功 5、交易取消，订单关闭 6、交易结束，已评价',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
    `consign_time` timestamp NULL DEFAULT NULL COMMENT '发货时间',
    `end_time` timestamp NULL DEFAULT NULL COMMENT '交易完成时间',
    `close_time` timestamp NULL DEFAULT NULL COMMENT '交易关闭时间',
    `comment_time` timestamp NULL DEFAULT NULL COMMENT '评价时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `multi_key_status_time` (`status`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT;


DROP TABLE IF EXISTS `order-detail`;

CREATE TABLE IF NOT EXISTS `order-detail` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单详情id ',
    `order_id` bigint NOT NULL COMMENT '订单id',
    `product_id` bigint NOT NULL COMMENT '商品id',
    `num` int NOT NULL COMMENT '购买数量',
    `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
    `price` int NOT NULL COMMENT '价格,单位：分',
    `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '商品图片',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `user_id` bigint not null comment '用户id',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `key_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='订单详情表';



UPDATE `mall-order`.`order-detail` AS od
    JOIN `mall-product`.`product` AS p ON od.product_id = p.id
    SET od.image = p.image
WHERE od.image = '' OR od.image IS NULL;

alter table `order-detail` modify column image varchar(666)