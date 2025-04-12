-- 在mall-store数据库中增加以下表

-- 商家详情表
CREATE TABLE `store_detail` (
                                `store_id` bigint NOT NULL COMMENT '关联商家ID',
                                `logo` varchar(255) DEFAULT NULL COMMENT '商家logo',
                                `description` text COMMENT '商家描述',
                                `contact_phone` varchar(20) COMMENT '联系电话',
                                `address` varchar(255) COMMENT '商家地址',
                                `business_license` varchar(255) COMMENT '营业执照图片',
                                `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                PRIMARY KEY (`store_id`)
) ENGINE=InnoDB COMMENT='商家详情表';

-- -- 员工角色表
-- CREATE TABLE `staff_role` (
--                               `id` bigint NOT NULL AUTO_INCREMENT,
--                               `store_id` bigint NOT NULL COMMENT '所属商家',
--                               `name` varchar(50) NOT NULL COMMENT '角色名称',
--                               `permissions` text COMMENT '权限JSON',
--                               PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB COMMENT='员工角色表';

-- 修改staff表增加字段
ALTER TABLE `staff`
--     ADD COLUMN `role_id` bigint COMMENT '角色ID',
ADD COLUMN `status` tinyint DEFAULT 1 COMMENT '状态：1-在职，0-离职',
ADD COLUMN `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
ADD COLUMN `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间';