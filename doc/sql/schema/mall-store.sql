DROP DATABASE IF EXISTS `mall-store`;
# 数据库名字统一与服务的名字相同
CREATE DATABASE IF NOT EXISTS `mall-store`;
USE `mall-store`;


DROP TABLE IF EXISTS `store`;


CREATE TABLE `store` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '商家id',
    `name` VARCHAR(100) NOT NULL COMMENT '商家名称',
    `status` TINYINT NOT NULL DEFAULT 0 COMMENT '商家状态，1启用，0关闭',
    `is_platform` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否平台级商家',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='商家表';


DROP TABLE IF EXISTS `staff`;


CREATE TABLE `staff` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '员工id',
    `user_id` bigint NOT NULL COMMENT '对应用户id',
    `store_id` BIGINT UNSIGNED NOT NULL COMMENT '所属商家',
    `position` VARCHAR(50) NOT NULL COMMENT '职位名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='员工信息表';

ALTER TABLE `staff`
--     ADD COLUMN `role_id` bigint COMMENT '角色ID',
ADD COLUMN `status` tinyint DEFAULT 1 COMMENT '状态：1-在职，0-离职',
ADD COLUMN `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
ADD COLUMN `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间';