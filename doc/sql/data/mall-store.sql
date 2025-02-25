USE `mall-store`;
# 初始化平台商家（单租户阶段唯一商家）
INSERT INTO store (name, is_platform) VALUES ('默认商家', 1);

INSERT INTO staff (user_id, store_id, position)
VALUES (1, 1, '普通员工');