/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 : Database - mall-cart
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mall-cart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mall-cart`;

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '购物车条目id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `num` int NOT NULL DEFAULT '1' COMMENT '购买数量',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名称',
  `price` int NOT NULL COMMENT '价格,单位/分',
  `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品图片',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted_at` timestamp NULL DEFAULT NULL COMMENT '删除时间，若为空则表示未删除',
  `attributes` json DEFAULT NULL COMMENT '商品属性，如颜色、尺寸等',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_product_id` (`user_id`,`product_id`),
  KEY `key_user_product_id` (`user_id`,`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1912759602199355395 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='用户购物车表';

/*Data for the table `cart` */

insert  into `cart`(`id`,`user_id`,`product_id`,`num`,`name`,`price`,`image`,`create_time`,`update_time`,`deleted_at`,`attributes`) values 
(1,17,3001,4,'旗舰智能手机',599900,'phone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(2,27,3001,5,'旗舰智能手机',599900,'phone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(3,37,3001,3,'旗舰智能手机',599900,'phone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(4,7,3001,5,'旗舰智能手机',599900,'phone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(5,37,3002,4,'无线蓝牙耳机',19900,'earphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(6,7,3002,4,'无线蓝牙耳机',19900,'earphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(7,17,3002,2,'无线蓝牙耳机',19900,'earphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(8,27,3002,4,'无线蓝牙耳机',19900,'earphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(9,17,3003,5,'4K智能电视',299900,'tv.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(10,27,3003,3,'4K智能电视',299900,'tv.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(11,37,3003,3,'4K智能电视',299900,'tv.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(12,7,3003,1,'4K智能电视',299900,'tv.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(13,37,3004,4,'全自动洗衣机',399900,'washer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(14,7,3004,3,'全自动洗衣机',399900,'washer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(15,17,3004,4,'全自动洗衣机',399900,'washer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(16,27,3004,1,'全自动洗衣机',399900,'washer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(17,17,3005,1,'男士休闲鞋',29900,'shoes.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(18,27,3005,2,'男士休闲鞋',29900,'shoes.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(19,37,3005,5,'男士休闲鞋',29900,'shoes.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(20,7,3005,2,'男士休闲鞋',29900,'shoes.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(21,37,3006,5,'女士连衣裙',19900,'dress.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(22,7,3006,5,'女士连衣裙',19900,'dress.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(23,17,3006,1,'女士连衣裙',19900,'dress.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(24,27,3006,3,'女士连衣裙',19900,'dress.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(25,17,3007,2,'电饭煲',9900,'cooker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(26,27,3007,2,'电饭煲',9900,'cooker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(27,37,3007,2,'电饭煲',9900,'cooker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(28,7,3007,1,'电饭煲',9900,'cooker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(29,37,3008,1,'口红',29900,'lipstick.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(30,7,3008,1,'口红',29900,'lipstick.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(31,17,3008,2,'口红',29900,'lipstick.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(32,27,3008,2,'口红',29900,'lipstick.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(33,17,3009,2,'编程书籍',8900,'book.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(34,27,3009,4,'编程书籍',8900,'book.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(35,37,3009,1,'编程书籍',8900,'book.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(36,7,3009,5,'编程书籍',8900,'book.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(37,37,3010,3,'跑步机',199900,'treadmill.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(38,7,3010,3,'跑步机',199900,'treadmill.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(39,17,3010,4,'跑步机',199900,'treadmill.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(40,27,3010,2,'跑步机',199900,'treadmill.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(41,17,3011,4,'有机大米',3900,'rice.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(42,27,3011,1,'有机大米',3900,'rice.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(43,37,3011,1,'有机大米',3900,'rice.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(44,7,3011,3,'有机大米',3900,'rice.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(45,37,3012,4,'床上四件套',19900,'bedding.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(46,7,3012,5,'床上四件套',19900,'bedding.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(47,17,3012,2,'床上四件套',19900,'bedding.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(48,27,3012,2,'床上四件套',19900,'bedding.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(49,17,3013,2,'手机充电器',4900,'charger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(50,27,3013,4,'手机充电器',4900,'charger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(51,37,3013,2,'手机充电器',4900,'charger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(52,7,3013,4,'手机充电器',4900,'charger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(53,37,3014,4,'婴儿推车',59900,'stroller.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(54,7,3014,1,'婴儿推车',59900,'stroller.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(55,17,3014,1,'婴儿推车',59900,'stroller.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(56,27,3014,1,'婴儿推车',59900,'stroller.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(57,38,3014,2,'婴儿推车',59900,'stroller.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(58,18,3015,2,'宠物粮',9900,'petfood.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(59,28,3015,3,'宠物粮',9900,'petfood.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(60,38,3015,3,'宠物粮',9900,'petfood.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(61,8,3015,2,'宠物粮',9900,'petfood.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(62,38,3016,1,'进口红酒',19900,'wine.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(63,8,3016,4,'进口红酒',19900,'wine.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(64,18,3016,5,'进口红酒',19900,'wine.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(65,28,3016,5,'进口红酒',19900,'wine.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(66,18,3017,1,'二手笔记本',299900,'laptop.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(67,28,3017,2,'二手笔记本',299900,'laptop.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(68,38,3017,3,'二手笔记本',299900,'laptop.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(69,8,3017,5,'二手笔记本',299900,'laptop.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(70,38,3018,1,'家政服务',19900,'service.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(71,8,3018,2,'家政服务',19900,'service.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(72,18,3018,2,'家政服务',19900,'service.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(73,28,3018,4,'家政服务',19900,'service.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(74,18,3019,1,'车载充电器',7900,'carcharger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(75,28,3019,4,'车载充电器',7900,'carcharger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(76,38,3019,2,'车载充电器',7900,'carcharger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(77,8,3019,1,'车载充电器',7900,'carcharger.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(78,38,3020,1,'维生素C',2900,'vitamin.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(79,8,3020,1,'维生素C',2900,'vitamin.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(80,18,3020,4,'维生素C',2900,'vitamin.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(81,28,3020,5,'维生素C',2900,'vitamin.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(82,18,3021,5,'旗舰智能手机X',699900,'phone2.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(83,28,3021,1,'旗舰智能手机X',699900,'phone2.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(84,38,3021,3,'旗舰智能手机X',699900,'phone2.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(85,8,3021,5,'旗舰智能手机X',699900,'phone2.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(86,38,3022,2,'8K智能电视',599900,'tv8k.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(87,8,3022,4,'8K智能电视',599900,'tv8k.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(88,18,3022,4,'8K智能电视',599900,'tv8k.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(89,28,3022,5,'8K智能电视',599900,'tv8k.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(90,18,3023,1,'男士西装',59900,'suit.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(91,28,3023,2,'男士西装',59900,'suit.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(92,38,3023,1,'男士西装',59900,'suit.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(93,8,3023,2,'男士西装',59900,'suit.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(94,38,3024,1,'空气炸锅',29900,'fryer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(95,8,3024,3,'空气炸锅',29900,'fryer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(96,18,3024,5,'空气炸锅',29900,'fryer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(97,28,3024,4,'空气炸锅',29900,'fryer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(98,18,3025,5,'香水',49900,'perfume.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(99,28,3025,5,'香水',49900,'perfume.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(100,38,3025,5,'香水',49900,'perfume.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(101,8,3025,4,'香水',49900,'perfume.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(102,38,3026,1,'儿童绘本',4900,'childrenbook.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(103,8,3026,5,'儿童绘本',4900,'childrenbook.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(104,18,3026,1,'儿童绘本',4900,'childrenbook.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(105,28,3026,3,'儿童绘本',4900,'childrenbook.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(106,18,3027,3,'瑜伽垫',3900,'yogamat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(107,28,3027,2,'瑜伽垫',3900,'yogamat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(108,38,3027,3,'瑜伽垫',3900,'yogamat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(109,8,3027,1,'瑜伽垫',3900,'yogamat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(110,38,3028,5,'新鲜鸡蛋',990,'egg.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(111,9,3028,3,'新鲜鸡蛋',990,'egg.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(112,19,3028,5,'新鲜鸡蛋',990,'egg.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(113,29,3028,3,'新鲜鸡蛋',990,'egg.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(114,39,3028,3,'新鲜鸡蛋',990,'egg.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(115,19,3029,3,'餐具套装',9900,'tableware.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(116,29,3029,3,'餐具套装',9900,'tableware.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(117,39,3029,4,'餐具套装',9900,'tableware.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(118,9,3029,2,'餐具套装',9900,'tableware.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(119,39,3030,3,'蓝牙音箱',19900,'speaker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(120,9,3030,2,'蓝牙音箱',19900,'speaker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(121,19,3030,2,'蓝牙音箱',19900,'speaker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(122,29,3030,4,'蓝牙音箱',19900,'speaker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(123,19,3031,3,'儿童安全座椅',89900,'seat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(124,29,3031,3,'儿童安全座椅',89900,'seat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(125,39,3031,1,'儿童安全座椅',89900,'seat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(126,9,3031,1,'儿童安全座椅',89900,'seat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(127,39,3032,2,'猫砂盆',4900,'litterbox.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(128,9,3032,1,'猫砂盆',4900,'litterbox.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(129,19,3032,2,'猫砂盆',4900,'litterbox.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(130,29,3032,1,'猫砂盆',4900,'litterbox.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(131,19,3033,2,'进口巧克力',9900,'chocolate.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(132,29,3033,1,'进口巧克力',9900,'chocolate.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(133,39,3033,3,'进口巧克力',9900,'chocolate.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(134,9,3033,2,'进口巧克力',9900,'chocolate.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(135,39,3034,1,'二手手机',99900,'usedphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(136,9,3034,5,'二手手机',99900,'usedphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(137,19,3034,3,'二手手机',99900,'usedphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(138,29,3034,3,'二手手机',99900,'usedphone.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(139,19,3035,2,'家电清洗',29900,'clean.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(140,29,3035,1,'家电清洗',29900,'clean.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(141,39,3035,1,'家电清洗',29900,'clean.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(142,9,3035,2,'家电清洗',29900,'clean.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(143,39,3036,2,'行车记录仪',19900,'dvr.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(144,9,3036,4,'行车记录仪',19900,'dvr.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(145,19,3036,1,'行车记录仪',19900,'dvr.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(146,29,3036,4,'行车记录仪',19900,'dvr.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(147,19,3037,4,'医用口罩',990,'mask.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(148,29,3037,2,'医用口罩',990,'mask.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(149,39,3037,3,'医用口罩',990,'mask.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(150,9,3037,5,'医用口罩',990,'mask.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(151,39,3038,3,'智能手表',29900,'watch.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(152,9,3038,2,'智能手表',29900,'watch.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(153,19,3038,4,'智能手表',29900,'watch.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(154,29,3038,5,'智能手表',29900,'watch.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(155,19,3039,3,'对开门冰箱',799900,'fridge.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(156,29,3039,5,'对开门冰箱',799900,'fridge.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(157,39,3039,5,'对开门冰箱',799900,'fridge.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(158,9,3039,4,'对开门冰箱',799900,'fridge.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(159,39,3040,3,'女士高跟鞋',19900,'highheel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(160,9,3040,3,'女士高跟鞋',19900,'highheel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(161,19,3040,3,'女士高跟鞋',19900,'highheel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(162,29,3040,5,'女士高跟鞋',19900,'highheel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(163,19,3041,5,'电磁炉',19900,'stove.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(164,29,3041,5,'电磁炉',19900,'stove.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(165,39,3041,1,'电磁炉',19900,'stove.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(166,9,3041,5,'电磁炉',19900,'stove.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(167,40,3042,3,'粉底液',39900,'foundation.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(168,10,3042,2,'粉底液',39900,'foundation.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(169,20,3042,2,'粉底液',39900,'foundation.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(170,30,3042,3,'粉底液',39900,'foundation.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(171,20,3043,2,'文学小说',6900,'novel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(172,30,3043,1,'文学小说',6900,'novel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(173,40,3043,2,'文学小说',6900,'novel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(174,10,3043,3,'文学小说',6900,'novel.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(175,40,3044,3,'登山包',29900,'backpack.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(176,10,3044,5,'登山包',29900,'backpack.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(177,20,3044,2,'登山包',29900,'backpack.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(178,30,3044,2,'登山包',29900,'backpack.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(179,20,3045,1,'新鲜牛奶',490,'milk.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(180,30,3045,1,'新鲜牛奶',490,'milk.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(181,40,3045,3,'新鲜牛奶',490,'milk.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(182,10,3045,5,'新鲜牛奶',490,'milk.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(183,40,3046,5,'收纳箱',4900,'box.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(184,10,3046,2,'收纳箱',4900,'box.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(185,20,3046,5,'收纳箱',4900,'box.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(186,30,3046,4,'收纳箱',4900,'box.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(187,20,3047,4,'手机贴膜',900,'film.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(188,30,3047,5,'手机贴膜',900,'film.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(189,40,3047,4,'手机贴膜',900,'film.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(190,10,3047,3,'手机贴膜',900,'film.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(191,40,3048,5,'婴儿奶瓶',9900,'bottle.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(192,10,3048,2,'婴儿奶瓶',9900,'bottle.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(193,20,3048,3,'婴儿奶瓶',9900,'bottle.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(194,30,3048,4,'婴儿奶瓶',9900,'bottle.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(195,20,3049,5,'狗玩具',1900,'toy.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(196,30,3049,4,'狗玩具',1900,'toy.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(197,40,3049,2,'狗玩具',1900,'toy.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(198,10,3049,2,'狗玩具',1900,'toy.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(199,40,3050,5,'进口奶粉',29900,'milkpowder.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(200,10,3050,2,'进口奶粉',29900,'milkpowder.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(201,20,3050,5,'进口奶粉',29900,'milkpowder.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(202,30,3050,4,'进口奶粉',29900,'milkpowder.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(203,20,3051,2,'在线课程',9900,'course.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(204,30,3051,1,'在线课程',9900,'course.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(205,40,3051,4,'在线课程',9900,'course.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(206,10,3051,5,'在线课程',9900,'course.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(207,40,3052,2,'办公设备',199900,'printer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(208,10,3052,3,'办公设备',199900,'printer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(209,20,3052,4,'办公设备',199900,'printer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(210,30,3052,4,'办公设备',199900,'printer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(211,20,3053,2,'有机苹果',2990,'apple.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(212,30,3053,5,'有机苹果',2990,'apple.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(213,40,3053,4,'有机苹果',2990,'apple.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(214,10,3053,1,'有机苹果',2990,'apple.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(215,40,3054,4,'男士洁面乳',9900,'facewash.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(216,10,3054,2,'男士洁面乳',9900,'facewash.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(217,20,3054,2,'男士洁面乳',9900,'facewash.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(218,30,3054,3,'男士洁面乳',9900,'facewash.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(219,20,3055,3,'考研英语资料',4900,'exam.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(220,30,3055,2,'考研英语资料',4900,'exam.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(221,40,3055,3,'考研英语资料',4900,'exam.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(222,10,3055,2,'考研英语资料',4900,'exam.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(223,21,3055,1,'考研英语资料',4900,'exam.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(225,11,3056,1,'登山杖',3900,'trekking.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(226,21,3056,1,'登山杖',3900,'trekking.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(227,31,3056,4,'登山杖',3900,'trekking.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(228,21,3057,5,'冷冻牛排',6990,'beef.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(229,31,3057,3,'冷冻牛排',6990,'beef.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(231,11,3057,2,'冷冻牛排',6990,'beef.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(233,11,3058,5,'智能扫地机',299900,'robot.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(234,21,3058,3,'智能扫地机',299900,'robot.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(235,31,3058,1,'智能扫地机',299900,'robot.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(236,21,3059,2,'婴儿辅食机',19900,'foodmaker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(237,31,3059,1,'婴儿辅食机',19900,'foodmaker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(239,11,3059,2,'婴儿辅食机',19900,'foodmaker.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(241,11,3060,3,'猫爬架',29900,'cat_tree.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(242,21,3060,4,'猫爬架',29900,'cat_tree.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(243,31,3060,2,'猫爬架',29900,'cat_tree.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(244,21,3061,4,'进口橄榄油',19900,'oliveoil.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(245,31,3061,3,'进口橄榄油',19900,'oliveoil.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(247,11,3061,5,'进口橄榄油',19900,'oliveoil.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(249,11,3062,1,'二手相机',159900,'camera.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(250,21,3062,2,'二手相机',159900,'camera.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(251,31,3062,5,'二手相机',159900,'camera.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(252,21,3063,1,'月嫂服务',49900,'nanny.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(253,31,3063,1,'月嫂服务',49900,'nanny.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(255,11,3063,5,'月嫂服务',49900,'nanny.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(257,11,3064,3,'汽车座垫',29900,'carseat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(258,21,3064,5,'汽车座垫',29900,'carseat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(259,31,3064,4,'汽车座垫',29900,'carseat.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(260,21,3065,2,'钙片',3900,'calcium.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(261,31,3065,5,'钙片',3900,'calcium.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(263,11,3065,4,'钙片',3900,'calcium.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(265,11,3066,5,'平板电脑',299900,'tablet.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(266,21,3066,4,'平板电脑',299900,'tablet.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(267,31,3066,1,'平板电脑',299900,'tablet.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(268,21,3067,4,'空调',399900,'ac.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(269,31,3067,2,'空调',399900,'ac.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(271,11,3067,1,'空调',399900,'ac.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(273,11,3068,3,'儿童运动鞋',9900,'kidshoe.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(274,21,3068,4,'儿童运动鞋',9900,'kidshoe.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(275,31,3068,4,'儿童运动鞋',9900,'kidshoe.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(276,22,3069,2,'榨汁机',9900,'juicer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(277,32,3069,4,'榨汁机',9900,'juicer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(279,12,3069,4,'榨汁机',9900,'juicer.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(281,12,3070,2,'眼影盘',19900,'eyeshadow.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(282,22,3070,2,'眼影盘',19900,'eyeshadow.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(283,32,3070,1,'眼影盘',19900,'eyeshadow.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(284,22,3071,4,'历史书籍',5900,'history.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(285,32,3071,4,'历史书籍',5900,'history.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(287,12,3071,5,'历史书籍',5900,'history.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(289,12,3072,4,'健身哑铃',9900,'dumbbell.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(290,22,3072,5,'健身哑铃',9900,'dumbbell.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(291,32,3072,1,'健身哑铃',9900,'dumbbell.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(292,22,3073,3,'有机蔬菜',1990,'vegetable.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(293,32,3073,2,'有机蔬菜',1990,'vegetable.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(295,12,3073,3,'有机蔬菜',1990,'vegetable.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(297,12,3074,2,'窗帘',19900,'curtain.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(298,22,3074,5,'窗帘',19900,'curtain.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(299,32,3074,1,'窗帘',19900,'curtain.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(300,22,3075,4,'移动电源',9900,'powerbank.jpg','2025-04-10 12:29:55','2025-04-10 12:29:55',NULL,NULL),
(1912759541323227138,1,3088,1,'科普读物',3900,'http://img.alicdn.com/img/i1/31738812/O1CN01EpJAU22ExxB63gp8S_!!4611686018427382716-0-saturn_solar.jpg','2025-04-17 14:46:27','2025-04-17 14:46:27',NULL,NULL),
(1912759547136532481,1,3081,1,'车载冰箱',29900,'http://img.alicdn.com/img/i4/2010740181/O1CN01jJ4xmJ1DCwj2WgX7T_!!4611686018427385301-0-saturn_solar.jpg','2025-04-17 14:46:28','2025-04-17 14:46:28',NULL,NULL),
(1912759602199355394,1,3076,1,'孕妇装',19900,'https://img.alicdn.com/imgextra/i2/2201234834599/O1CN01FIlWjb1jqOXxlWbMB_!!2201234834599-0-alimamacc.jpg','2025-04-17 14:46:41','2025-04-17 14:46:41',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
