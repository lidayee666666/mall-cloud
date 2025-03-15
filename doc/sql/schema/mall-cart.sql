DROP DATABASE IF EXISTS `mall-cart`;

CREATE DATABASE IF NOT EXISTS `mall-cart`;
USE `mall-cart`;

DROP TABLE IF EXISTS `cart`;

CREATE TABLE IF NOT EXISTS `cart` (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '购物车条目id',
                                      `user_id` bigint NOT NULL COMMENT '用户id',
                                      `product_id` bigint NOT NULL COMMENT '商品id',
                                      `num` int NOT NULL DEFAULT '1' COMMENT '购买数量',
                                      `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名称',
    `price` DECIMAL(10,2) NOT NULL COMMENT '价格,单位/元',
    `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品图片',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间，若为空则表示未删除',
    `attributes` json DEFAULT NULL COMMENT '商品属性，如颜色、尺寸等',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_user_product_id` (`user_id`, `product_id`),
    KEY `key_user_product_id` (`user_id`,`product_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='用户购物车表';