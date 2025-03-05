/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 : Database - mall-product
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mall-product` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mall-product`;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `store_id` bigint NOT NULL COMMENT '商家id',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `price` int NOT NULL DEFAULT '0' COMMENT '价格（分）',
  `stock` int unsigned NOT NULL COMMENT '库存数量',
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='商品表';

/*Data for the table `product` */

insert  into `product`(`id`,`store_id`,`name`,`price`,`stock`,`image`,`category`,`sold`,`comment_count`,`status`,`create_time`,`update_time`,`creator`,`updater`) values 
(1,1,'iPhone 15 Pro',999900,100,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','电子产品',150,45,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(2,2,'男士运动鞋',29900,200,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','服装鞋帽',80,22,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(3,3,'智能扫地机器人',59900,50,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','智能家居',30,15,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(4,4,'无线蓝牙耳机',19900,300,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','数码配件',200,68,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(5,5,'纯棉四件套',8900,150,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','家纺用品',45,12,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(6,6,'Java编程思想',7900,80,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','图书音像',25,8,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(7,7,'陶瓷餐具套装',12900,120,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房用品',60,18,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(8,8,'智能手环',14900,250,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','智能穿戴',95,30,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(9,9,'电动剃须刀',8900,180,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','个人护理',75,25,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(10,10,'登山背包',19900,90,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','户外用品',40,10,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(11,1,'iPad Pro 12.9',799900,60,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','电子产品',28,9,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(12,2,'女士真皮手提包',45900,110,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','箱包配饰',65,20,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(13,3,'空气炸锅',25900,70,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房电器',50,16,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(14,4,'机械键盘',32900,130,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','电脑外设',88,35,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(15,5,'记忆棉枕头',6900,200,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','家居用品',120,42,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(16,6,'Python编程入门',4900,95,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','图书音像',33,11,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(17,7,'不锈钢保温杯',3900,300,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房用品',150,55,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(18,8,'智能体脂秤',9900,180,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','健康监测',70,28,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(19,9,'电动牙刷',12900,220,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','个人护理',105,40,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(20,10,'露营帐篷',29900,40,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','户外用品',18,5,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(21,1,'MacBook Pro 16',1499900,30,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','电子产品',12,3,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(22,2,'男士商务衬衫',12900,170,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','服装鞋帽',55,17,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(23,3,'破壁料理机',39900,45,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房电器',22,7,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(24,4,'游戏鼠标',14900,150,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','电脑外设',68,24,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(25,5,'懒人沙发',29900,80,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','家居用品',38,12,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(26,6,'算法导论',9900,60,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','图书音像',15,4,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(27,7,'不粘锅套装',19900,95,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房用品',42,13,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(28,8,'血氧仪',7900,120,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','健康监测',33,10,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(29,9,'美容仪',29900,65,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','个人护理',27,8,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(30,10,'登山杖',4900,200,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','户外用品',50,15,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(31,1,'Apple Watch S8',39900,180,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','智能穿戴',85,30,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(32,2,'女士羊毛大衣',59900,75,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','服装鞋帽',20,6,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(33,3,'咖啡机',45900,50,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房电器',15,4,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(34,4,'4K显示器',129900,25,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','电脑外设',8,2,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(35,5,'香薰加湿器',9900,130,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','家居用品',45,14,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(36,6,'设计模式',6900,85,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','图书音像',22,7,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(37,7,'陶瓷刀套装',14900,110,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房用品',37,11,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(38,8,'按摩仪',19900,90,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','健康监测',28,9,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(39,9,'卷发棒',7900,160,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','个人护理',53,16,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(40,10,'冲锋衣',39900,60,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','户外用品',25,8,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(41,1,'AirPods Pro',19900,250,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','数码配件',130,45,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(42,2,'男士皮带',8900,190,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','箱包配饰',48,15,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(43,3,'电饭煲',12900,100,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房电器',35,11,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(44,4,'移动硬盘',29900,70,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','电脑外设',18,5,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(45,5,'装饰画',4900,140,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','家居装饰',30,9,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(46,6,'计算机网络',8900,55,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','图书音像',12,3,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(47,7,'玻璃保鲜盒',6900,210,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','厨房用品',65,20,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(48,8,'体温计',2900,300,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','健康监测',90,28,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(49,9,'电动鼻毛修剪器',4900,180,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','个人护理',40,12,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1),
(50,10,'防水登山鞋',25900,85,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/1733031322865hhg.jpg','户外用品',22,6,1,'2025-03-03 19:03:12','2025-03-03 20:06:23',1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
