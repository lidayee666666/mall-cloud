-- 清空数据并重置自增（执行顺序重要！）
USE `mall-user`;
TRUNCATE `address`;
TRUNCATE `user`;

USE `mall-store`;
TRUNCATE `staff`;
TRUNCATE `store`;

USE `mall-product`;
TRUNCATE `categories`;
TRUNCATE `product`;

USE `mall-cart`;
TRUNCATE `cart`;

USE `mall-order`;
TRUNCATE `order-detail`;
TRUNCATE `orders`;

USE `mall-payment`;
TRUNCATE `payment`;

-- 生成测试数据（金额单位统一为分）
-- 用户数据（40条）
INSERT INTO `mall-user`.`user`
(id,username,password,phone,user_type,balance,is_platform_admin) VALUES
                                                                     (1,'customer1','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800001111','customer',1000000,0),
                                                                     (2,'customer2','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800002222','customer',500000,0),
                                                                     (3,'store_staff','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800003333','staff',0,0),
                                                                     (4,'platform_admin','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800004444','customer',0,1),
                                                                     (5,'customer3','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13811112222','customer',800000,0),
                                                                     (6,'customer4','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13822223333','customer',700000,0),
                                                                     (7,'customer5','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13833334444','customer',600000,0),
                                                                     (8,'customer6','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13844445555','customer',900000,0),
                                                                     (9,'customer7','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13855556666','customer',300000,0),
                                                                     (10,'customer8','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13866667777','customer',400000,0),
                                                                     (11,'staff01','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13877778888','staff',0,0),
                                                                     (12,'staff02','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13888889999','staff',0,0),
                                                                     (13,'staff03','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13899990000','staff',0,0),
                                                                     (14,'staff04','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800010002','staff',0,0),
                                                                     (15,'staff05','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800020003','staff',0,0),
                                                                     (16,'staff06','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800030004','staff',0,0),
                                                                     (17,'staff07','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800040005','staff',0,0),
                                                                     (18,'staff08','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800050006','staff',0,0),
                                                                     (19,'staff09','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800060007','staff',0,0),
                                                                     (20,'staff10','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800070008','staff',0,0),
                                                                     (21,'staff11','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800080009','staff',0,0),
                                                                     (22,'staff12','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800090010','staff',0,0),
                                                                     (23,'staff13','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800100011','staff',0,0),
                                                                     (24,'staff14','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800110012','staff',0,0),
                                                                     (25,'staff15','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800120013','staff',0,0),
                                                                     (26,'staff16','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800130014','staff',0,0),
                                                                     (27,'staff17','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800140015','staff',0,0),
                                                                     (28,'staff18','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800150016','staff',0,0),
                                                                     (29,'staff19','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800160017','staff',0,0),
                                                                     (30,'staff20','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800170018','staff',0,0),
                                                                     (31,'customer9','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800180019','customer',200000,0),
                                                                     (32,'customer10','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800190020','customer',150000,0),
                                                                     (33,'customer11','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800200021','customer',250000,0),
                                                                     (34,'customer12','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800210022','customer',350000,0),
                                                                     (35,'customer13','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800220023','customer',450000,0),
                                                                     (36,'customer14','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800230024','customer',550000,0),
                                                                     (37,'customer15','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800240025','customer',650000,0),
                                                                     (38,'customer16','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800250026','customer',750000,0),
                                                                     (39,'customer17','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800260027','customer',850000,0),
                                                                     (40,'customer18','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800270028','customer',950000,0);

-- 地址数据（40条）
INSERT INTO `mall-user`.`address`
(user_id,province,city,town,street,contact,is_default)
SELECT
    id,
    CASE WHEN id%2=0 THEN '上海市' ELSE '北京市' END,
    '市辖区',
    CASE WHEN id%2=0 THEN '浦东新区' ELSE '朝阳区' END,
    CONCAT('用户', id, '的收货地址'),
    CONCAT('联系人', id),
    1
FROM `mall-user`.`user`;

-- 商家数据（20条）
INSERT INTO `mall-store`.`store`
(id,name,status,is_platform) VALUES
                                 (1001,'官方自营店',1,1),
                                 (1002,'数码旗舰店',1,0),
                                 (1003,'服装旗舰店',1,0),
                                 (1004,'家电专营店',1,0),
                                 (1005,'美妆商城',1,0),
                                 (1006,'图书音像店',1,0),
                                 (1007,'运动户外店',1,0),
                                 (1008,'食品生鲜店',1,0),
                                 (1009,'家居生活馆',1,0),
                                 (1010,'数码配件店',1,0),
                                 (1011,'母婴用品店',1,0),
                                 (1012,'宠物用品店',1,0),
                                 (1013,'全球购跨境店',1,0),
                                 (1014,'二手优品店',1,0),
                                 (1015,'本地服务店',1,0),
                                 (1016,'汽车用品店',1,0),
                                 (1017,'医药健康店',1,0),
                                 (1018,'虚拟商品店',1,0),
                                 (1019,'企业采购店',1,0),
                                 (1020,'扶贫助农店',1,0);

-- 员工数据（40条）
INSERT INTO `mall-store`.`staff`
(user_id,store_id,position)
SELECT
    u.id,
    s.id,
    CASE WHEN u.id%2=0 THEN '店员' ELSE '店长' END
FROM `mall-store`.`store` s
         JOIN (SELECT id FROM `mall-user`.`user` WHERE user_type='staff' LIMIT 40) u
              ON s.id BETWEEN 1001 AND 1020;

-- 商品类目（扩展为12个主流分类）
INSERT INTO `mall-product`.`categories`
(category,product_num) VALUES
                           ('手机数码',0),
                           ('家用电器',0),
                           ('服装鞋帽',0),
                           ('美妆个护',0),
                           ('图书音像',0),
                           ('运动户外',0),
                           ('食品生鲜',0),
                           ('家居生活',0),
                           ('母婴用品',0),
                           ('宠物用品',0),
                           ('全球购',0),
                           ('二手优品',0);

-- 商品数据（100条）
INSERT INTO `mall-product`.`product`
(id,store_id,name,price,stock,category,image) VALUES
                                                  (3001,1001,'旗舰智能手机',599900,100,'手机数码','phone.jpg'),
                                                  (3002,1001,'无线蓝牙耳机',19900,200,'手机数码','earphone.jpg'),
                                                  (3003,1002,'4K智能电视',299900,50,'家用电器','tv.jpg'),
                                                  (3004,1002,'全自动洗衣机',399900,30,'家用电器','washer.jpg'),
                                                  (3005,1001,'男士休闲鞋',29900,300,'服装鞋帽','shoes.jpg'),
                                                  (3006,1003,'女士连衣裙',19900,150,'服装鞋帽','dress.jpg'),
                                                  (3007,1004,'电饭煲',9900,80,'家用电器','cooker.jpg'),
                                                  (3008,1005,'口红',29900,200,'美妆个护','lipstick.jpg'),
                                                  (3009,1006,'编程书籍',8900,500,'图书音像','book.jpg'),
                                                  (3010,1007,'跑步机',199900,30,'运动户外','treadmill.jpg'),
                                                  (3011,1008,'有机大米',3900,1000,'食品生鲜','rice.jpg'),
                                                  (3012,1009,'床上四件套',19900,200,'家居生活','bedding.jpg'),
                                                  (3013,1010,'手机充电器',4900,300,'手机数码','charger.jpg'),
                                                  (3014,1011,'婴儿推车',59900,100,'母婴用品','stroller.jpg'),
                                                  (3015,1012,'宠物粮',9900,500,'宠物用品','petfood.jpg'),
                                                  (3016,1013,'进口红酒',19900,200,'全球购','wine.jpg'),
                                                  (3017,1014,'二手笔记本',299900,50,'二手优品','laptop.jpg'),
                                                  (3018,1015,'家政服务',19900,0,'本地服务','service.jpg'),
                                                  (3019,1016,'车载充电器',7900,150,'汽车用品','carcharger.jpg'),
                                                  (3020,1017,'维生素C',2900,300,'医药健康','vitamin.jpg'),
                                                  (3021,1001,'旗舰智能手机X',699900,80,'手机数码','phone2.jpg'),
                                                  (3022,1002,'8K智能电视',599900,30,'家用电器','tv8k.jpg'),
                                                  (3023,1003,'男士西装',59900,100,'服装鞋帽','suit.jpg'),
                                                  (3024,1004,'空气炸锅',29900,120,'家用电器','fryer.jpg'),
                                                  (3025,1005,'香水',49900,150,'美妆个护','perfume.jpg'),
                                                  (3026,1006,'儿童绘本',4900,300,'图书音像','childrenbook.jpg'),
                                                  (3027,1007,'瑜伽垫',3900,200,'运动户外','yogamat.jpg'),
                                                  (3028,1008,'新鲜鸡蛋',990,1000,'食品生鲜','egg.jpg'),
                                                  (3029,1009,'餐具套装',9900,150,'家居生活','tableware.jpg'),
                                                  (3030,1010,'蓝牙音箱',19900,100,'手机数码','speaker.jpg'),
                                                  (3031,1011,'儿童安全座椅',89900,80,'母婴用品','seat.jpg'),
                                                  (3032,1012,'猫砂盆',4900,200,'宠物用品','litterbox.jpg'),
                                                  (3033,1013,'进口巧克力',9900,300,'全球购','chocolate.jpg'),
                                                  (3034,1014,'二手手机',99900,100,'二手优品','usedphone.jpg'),
                                                  (3035,1015,'家电清洗',29900,0,'本地服务','clean.jpg'),
                                                  (3036,1016,'行车记录仪',19900,100,'汽车用品','dvr.jpg'),
                                                  (3037,1017,'医用口罩',990,500,'医药健康','mask.jpg'),
                                                  (3038,1001,'智能手表',29900,200,'手机数码','watch.jpg'),
                                                  (3039,1002,'对开门冰箱',799900,20,'家用电器','fridge.jpg'),
                                                  (3040,1003,'女士高跟鞋',19900,180,'服装鞋帽','highheel.jpg'),
                                                  (3041,1004,'电磁炉',19900,100,'家用电器','stove.jpg'),
                                                  (3042,1005,'粉底液',39900,120,'美妆个护','foundation.jpg'),
                                                  (3043,1006,'文学小说',6900,200,'图书音像','novel.jpg'),
                                                  (3044,1007,'登山包',29900,80,'运动户外','backpack.jpg'),
                                                  (3045,1008,'新鲜牛奶',490,500,'食品生鲜','milk.jpg'),
                                                  (3046,1009,'收纳箱',4900,150,'家居生活','box.jpg'),
                                                  (3047,1010,'手机贴膜',900,300,'手机数码','film.jpg'),
                                                  (3048,1011,'婴儿奶瓶',9900,200,'母婴用品','bottle.jpg'),
                                                  (3049,1012,'狗玩具',1900,300,'宠物用品','toy.jpg'),
                                                  (3050,1013,'进口奶粉',29900,100,'全球购','milkpowder.jpg'),
                                                  (3051,1018,'在线课程',9900,0,'虚拟商品','course.jpg'),
                                                  (3052,1019,'办公设备',199900,50,'企业采购','printer.jpg'),
                                                  (3053,1020,'有机苹果',2990,200,'扶贫助农','apple.jpg'),
                                                  (3054,1005,'男士洁面乳',9900,150,'美妆个护','facewash.jpg'),
                                                  (3055,1006,'考研英语资料',4900,80,'图书音像','exam.jpg'),
                                                  (3056,1007,'登山杖',3900,120,'运动户外','trekking.jpg'),
                                                  (3057,1008,'冷冻牛排',6990,300,'食品生鲜','beef.jpg'),
                                                  (3058,1009,'智能扫地机',299900,40,'家居生活','robot.jpg'),
                                                  (3059,1011,'婴儿辅食机',19900,60,'母婴用品','foodmaker.jpg'),
                                                  (3060,1012,'猫爬架',29900,70,'宠物用品','cat_tree.jpg'),
                                                  (3061,1013,'进口橄榄油',19900,150,'全球购','oliveoil.jpg'),
                                                  (3062,1014,'二手相机',159900,30,'二手优品','camera.jpg'),
                                                  (3063,1015,'月嫂服务',49900,0,'本地服务','nanny.jpg'),
                                                  (3064,1016,'汽车座垫',29900,100,'汽车用品','carseat.jpg'),
                                                  (3065,1017,'钙片',3900,200,'医药健康','calcium.jpg'),
                                                  (3066,1001,'平板电脑',299900,80,'手机数码','tablet.jpg'),
                                                  (3067,1002,'空调',399900,25,'家用电器','ac.jpg'),
                                                  (3068,1003,'儿童运动鞋',9900,180,'服装鞋帽','kidshoe.jpg'),
                                                  (3069,1004,'榨汁机',9900,90,'家用电器','juicer.jpg'),
                                                  (3070,1005,'眼影盘',19900,120,'美妆个护','eyeshadow.jpg'),
                                                  (3071,1006,'历史书籍',5900,150,'图书音像','history.jpg'),
                                                  (3072,1007,'健身哑铃',9900,100,'运动户外','dumbbell.jpg'),
                                                  (3073,1008,'有机蔬菜',1990,300,'食品生鲜','vegetable.jpg'),
                                                  (3074,1009,'窗帘',19900,60,'家居生活','curtain.jpg'),
                                                  (3075,1010,'移动电源',9900,200,'手机数码','powerbank.jpg'),
                                                  (3076,1011,'孕妇装',19900,80,'母婴用品','maternity.jpg'),
                                                  (3077,1012,'鱼缸',19900,50,'宠物用品','aquarium.jpg'),
                                                  (3078,1013,'进口饼干',4900,200,'全球购','biscuit.jpg'),
                                                  (3079,1014,'二手家具',59900,40,'二手优品','furniture.jpg'),
                                                  (3080,1015,'搬家服务',19900,0,'本地服务','moving.jpg'),
                                                  (3081,1016,'车载冰箱',29900,60,'汽车用品','carfridge.jpg'),
                                                  (3082,1017,'体温计',1900,150,'医药健康','thermometer.jpg'),
                                                  (3083,1001,'电子阅读器',99900,70,'手机数码','ereader.jpg'),
                                                  (3084,1002,'微波炉',19900,60,'家用电器','microwave.jpg'),
                                                  (3085,1003,'男士皮带',9900,120,'服装鞋帽','belt.jpg'),
                                                  (3086,1004,'电风扇',9900,150,'家用电器','fan.jpg'),
                                                  (3087,1005,'防晒霜',19900,180,'美妆个护','sunscreen.jpg'),
                                                  (3088,1006,'科普读物',3900,120,'图书音像','science.jpg'),
                                                  (3089,1007,'羽毛球拍',9900,90,'运动户外','badminton.jpg'),
                                                  (3090,1008,'有机蜂蜜',3990,200,'食品生鲜','honey.jpg'),
                                                  (3091,1009,'台灯',9900,100,'家居生活','lamp.jpg'),
                                                  (3092,1010,'U盘',4900,250,'手机数码','usb.jpg'),
                                                  (3093,1011,'婴儿湿巾',2900,300,'母婴用品','wipes.jpg'),
                                                  (3094,1012,'鸟笼',9900,40,'宠物用品','birdcage.jpg'),
                                                  (3095,1013,'进口咖啡',9900,150,'全球购','coffee.jpg'),
                                                  (3096,1014,'二手自行车',99900,30,'二手优品','bicycle.jpg'),
                                                  (3097,1015,'保洁服务',9900,0,'本地服务','cleaning.jpg'),
                                                  (3098,1016,'汽车香水',3900,120,'汽车用品','carperfume.jpg'),
                                                  (3099,1017,'创可贴',490,500,'医药健康','bandaid.jpg'),
                                                  (3100,1020,'农家土鸡蛋',1990,300,'扶贫助农','eggs.jpg');

-- 分类商品数动态统计
UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='手机数码')
WHERE category='手机数码';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='家用电器')
WHERE category='家用电器';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='服装鞋帽')
WHERE category='服装鞋帽';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='美妆个护')
WHERE category='美妆个护';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='图书音像')
WHERE category='图书音像';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='运动户外')
WHERE category='运动户外';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='食品生鲜')
WHERE category='食品生鲜';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='家居生活')
WHERE category='家居生活';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='母婴用品')
WHERE category='母婴用品';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='宠物用品')
WHERE category='宠物用品';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='全球购')
WHERE category='全球购';

UPDATE `mall-product`.`categories`
SET product_num = (SELECT COUNT(*) FROM `mall-product`.`product` WHERE category='二手优品')
WHERE category='二手优品';

-- 购物车数据（300条）
INSERT INTO `mall-cart`.`cart` (user_id, product_id, num, name, price, image)
SELECT
    user_id,
    product_id,
    num,
    name,
    price,
    image
FROM (
         SELECT
             p.id AS product_id,
             FLOOR(1 + RAND(p.id * 10 + m.n) * 40) AS user_id,
             FLOOR(1 + RAND() * 5) AS num,
             p.name,
             p.price,
             p.image
         FROM `mall-product`.`product` p
                  CROSS JOIN (SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) m
     ) AS temp_data
GROUP BY user_id, product_id
    LIMIT 300;

-- 生成200条订单数据（金额单位为分）
INSERT INTO `mall-order`.`orders`
(user_id, total_fee, payment_type, status, create_time, pay_time, consign_time, end_time, close_time, comment_time)
SELECT
    user_id,
    total_fee,
    payment_type,
    status,
    create_time,
    CASE WHEN status >= 2 THEN FROM_UNIXTIME(create_ts + FLOOR(60 + RAND()*3600)) ELSE NULL END AS pay_time,
    CASE WHEN status >= 3 THEN FROM_UNIXTIME(create_ts + 86400 + FLOOR(RAND()*86400)) ELSE NULL END AS consign_time,
    CASE WHEN status IN (4,6) THEN FROM_UNIXTIME(create_ts + 3*86400 + FLOOR(RAND()*86400)) ELSE NULL END AS end_time,
    CASE WHEN status = 5 THEN FROM_UNIXTIME(create_ts + FLOOR(86400 + RAND()*86400)) ELSE NULL END AS close_time,
    CASE WHEN status = 6 THEN FROM_UNIXTIME(create_ts + 4*86400 + FLOOR(RAND()*86400)) ELSE NULL END AS comment_time
FROM (
         SELECT
             user_id,
             FLOOR(1000 + RAND()*99000) AS total_fee,
             FLOOR(1 + RAND()*3) AS payment_type,
             status,
             create_time,
             UNIX_TIMESTAMP(create_time) AS create_ts
         FROM (
                  SELECT
                      u.id AS user_id,
                      CASE
                          WHEN RAND() < 0.1 THEN 1
                          WHEN RAND() < 0.3 THEN 2
                          WHEN RAND() < 0.6 THEN 3
                          WHEN RAND() < 0.8 THEN 4
                          WHEN RAND() < 0.9 THEN 5
                          ELSE 6
                          END AS status,
                      DATE_ADD('2024-01-01', INTERVAL FLOOR(RAND()*300) DAY) AS create_time
                  FROM `mall-user`.`user` u
                  WHERE u.user_type = 'customer'
                  ORDER BY RAND()
                      LIMIT 200
              ) AS base_data
     ) AS calc_data;

-- 订单详情（600条）
INSERT INTO `mall-order`.`order-detail`
(order_id,product_id,num,name,price,user_id)
SELECT
    o.id,
    p.id,
    FLOOR(1 + RAND() * 5),
    p.name,
    p.price,
    o.user_id
FROM `mall-order`.`orders` o
         JOIN `mall-product`.`product` p
ORDER BY RAND()
    LIMIT 600;

-- 支付数据（200条）
INSERT INTO `mall-payment`.`payment`
(biz_order_no,pay_order_no,biz_user_id,amount,status,pay_type)
SELECT
    o.id,
    CONCAT(DATE_FORMAT(o.create_time,'%Y%m%d'), o.id),
    o.user_id,
    o.total_fee,
    CASE WHEN o.status > 1 THEN 3 ELSE 1 END,
    o.payment_type
FROM `mall-order`.`orders` o;