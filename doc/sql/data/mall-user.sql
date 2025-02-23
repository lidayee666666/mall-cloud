USE `mall-user`;

# 注：由于应用层采用的密码加密算法未确定，此处的密码为无效值，仅做测试使用
INSERT INTO `user` (id, username, password, phone)
VALUES (1, 'kafu', '123456', '13900000000');


INSERT INTO `address` (id, user_id, province, city, town, phone, street, contact, is_default, notes)
VALUES (1, 1, '广东省', '广州市', '番禺区', '13900000000', '大学城xxxx大学', 'kafu', 1, '测试数据');