# 注：由于应用层采用的密码加密算法未确定，此处的密码为无效值，仅做测试使用
USE `mall-user`;

INSERT INTO user (id, username, password, phone, is_platform_admin)
VALUES (1, 'admin', '123456', '13900000000', 1);


INSERT INTO `address` (id, user_id, province, city, town, phone, street, contact, is_default, notes)
VALUES (1, 1, '广东省', '广州市', '番禺区', '13900000000', '大学城xxxx大学', 'kafu', 1, '测试数据');