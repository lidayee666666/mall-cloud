DROP DATABASE IF EXISTS `mall-product`;
CREATE DATABASE IF NOT EXISTS `mall-product`;

USE `mall-product`;

DROP TABLE IF EXISTS `product`;

CREATE TABLE IF NOT EXISTS `product` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `store_id` bigint NOT NULL COMMENT '商家id',
    `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
    `price` int NOT NULL DEFAULT '0' COMMENT '价格（分）',
    `stock` int UNSIGNED NOT NULL COMMENT '库存数量',
    `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品图片',
    `category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类目名称',
    `sold` int DEFAULT '0' COMMENT '销量',
    `comment_count` int DEFAULT '0' COMMENT '评论数',
    `status` int DEFAULT '2' COMMENT '商品状态 1-正常，2-下架，3-删除',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `creator` bigint DEFAULT NULL COMMENT '创建人',
    `updater` bigint DEFAULT NULL COMMENT '修改人',
    PRIMARY KEY (`id`),
    KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='商品表';