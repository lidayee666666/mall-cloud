/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 : Database - mall-user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mall-user` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mall-user`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '省',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '市',
  `town` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '县/区',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机',
  `street` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '详细地址',
  `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系人',
  `is_default` tinyint DEFAULT NULL COMMENT '是否是默认 1(true)默认 0(false)否',
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='地址表';

/*Data for the table `address` */

insert  into `address`(`id`,`user_id`,`province`,`city`,`town`,`phone`,`street`,`contact`,`is_default`,`notes`) values 
(1,1,'北京市','市辖区','朝阳区',NULL,'用户1的收货地址','联系人1',1,NULL),
(2,32,'上海市','市辖区','浦东新区',NULL,'用户32的收货地址','联系人32',1,NULL),
(3,33,'北京市','市辖区','朝阳区',NULL,'用户33的收货地址','联系人33',1,NULL),
(4,34,'上海市','市辖区','浦东新区',NULL,'用户34的收货地址','联系人34',1,NULL),
(5,35,'北京市','市辖区','朝阳区',NULL,'用户35的收货地址','联系人35',1,NULL),
(6,36,'上海市','市辖区','浦东新区',NULL,'用户36的收货地址','联系人36',1,NULL),
(7,37,'北京市','市辖区','朝阳区',NULL,'用户37的收货地址','联系人37',1,NULL),
(8,38,'上海市','市辖区','浦东新区',NULL,'用户38的收货地址','联系人38',1,NULL),
(9,39,'北京市','市辖区','朝阳区',NULL,'用户39的收货地址','联系人39',1,NULL),
(10,40,'上海市','市辖区','浦东新区',NULL,'用户40的收货地址','联系人40',1,NULL),
(11,2,'上海市','市辖区','浦东新区',NULL,'用户2的收货地址','联系人2',1,NULL),
(12,5,'北京市','市辖区','朝阳区',NULL,'用户5的收货地址','联系人5',1,NULL),
(13,6,'上海市','市辖区','浦东新区',NULL,'用户6的收货地址','联系人6',1,NULL),
(14,7,'北京市','市辖区','朝阳区',NULL,'用户7的收货地址','联系人7',1,NULL),
(15,8,'上海市','市辖区','浦东新区',NULL,'用户8的收货地址','联系人8',1,NULL),
(16,9,'北京市','市辖区','朝阳区',NULL,'用户9的收货地址','联系人9',1,NULL),
(17,10,'上海市','市辖区','浦东新区',NULL,'用户10的收货地址','联系人10',1,NULL),
(18,31,'北京市','市辖区','朝阳区',NULL,'用户31的收货地址','联系人31',1,NULL),
(19,4,'上海市','市辖区','浦东新区',NULL,'用户4的收货地址','联系人4',1,NULL),
(20,11,'北京市','市辖区','朝阳区',NULL,'用户11的收货地址','联系人11',1,NULL),
(21,12,'上海市','市辖区','浦东新区',NULL,'用户12的收货地址','联系人12',1,NULL),
(22,13,'北京市','市辖区','朝阳区',NULL,'用户13的收货地址','联系人13',1,NULL),
(23,14,'上海市','市辖区','浦东新区',NULL,'用户14的收货地址','联系人14',1,NULL),
(24,15,'北京市','市辖区','朝阳区',NULL,'用户15的收货地址','联系人15',1,NULL),
(25,16,'上海市','市辖区','浦东新区',NULL,'用户16的收货地址','联系人16',1,NULL),
(26,17,'北京市','市辖区','朝阳区',NULL,'用户17的收货地址','联系人17',1,NULL),
(27,18,'上海市','市辖区','浦东新区',NULL,'用户18的收货地址','联系人18',1,NULL),
(28,19,'北京市','市辖区','朝阳区',NULL,'用户19的收货地址','联系人19',1,NULL),
(29,20,'上海市','市辖区','浦东新区',NULL,'用户20的收货地址','联系人20',1,NULL),
(30,21,'北京市','市辖区','朝阳区',NULL,'用户21的收货地址','联系人21',1,NULL),
(31,22,'上海市','市辖区','浦东新区',NULL,'用户22的收货地址','联系人22',1,NULL),
(32,23,'北京市','市辖区','朝阳区',NULL,'用户23的收货地址','联系人23',1,NULL),
(33,24,'上海市','市辖区','浦东新区',NULL,'用户24的收货地址','联系人24',1,NULL),
(34,25,'北京市','市辖区','朝阳区',NULL,'用户25的收货地址','联系人25',1,NULL),
(35,26,'上海市','市辖区','浦东新区',NULL,'用户26的收货地址','联系人26',1,NULL),
(36,27,'北京市','市辖区','朝阳区',NULL,'用户27的收货地址','联系人27',1,NULL),
(37,28,'上海市','市辖区','浦东新区',NULL,'用户28的收货地址','联系人28',1,NULL),
(38,29,'北京市','市辖区','朝阳区',NULL,'用户29的收货地址','联系人29',1,NULL),
(39,30,'上海市','市辖区','浦东新区',NULL,'用户30的收货地址','联系人30',1,NULL),
(40,3,'北京市','市辖区','朝阳区',NULL,'用户3的收货地址','联系人3',1,NULL);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '评论的唯一标识',
  `product_id` bigint unsigned NOT NULL COMMENT '商品ID',
  `user_id` bigint unsigned NOT NULL COMMENT '用户ID',
  `content` varchar(500) NOT NULL COMMENT '评论内容',
  `com_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `parent_id` bigint unsigned DEFAULT NULL COMMENT '父评论ID，一级评论为NULL或0',
  `reply_count` int unsigned NOT NULL DEFAULT '0' COMMENT '回复数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论表';

/*Data for the table `comment` */

insert  into `comment`(`id`,`product_id`,`user_id`,`content`,`com_time`,`parent_id`,`reply_count`) values 
(1,101,1,'一级评论 A','2025-04-05 10:00:00',NULL,0),
(2,101,2,'二级评论 A1','2025-04-05 10:05:00',1,0),
(3,101,3,'二级评论 A2','2025-04-05 10:10:00',1,0),
(4,101,4,'一级评论 B','2025-04-05 11:00:00',NULL,0),
(5,101,5,'二级评论 B1','2025-04-05 11:05:00',4,0),
(6,3001,1,'商品质量非常好，物流速度也超快！','2025-04-07 15:12:55',NULL,0),
(7,3001,4,'没问题！','2025-04-07 16:18:49',5,0),
(8,3099,1,'666','2025-04-07 18:51:13',NULL,0),
(9,3023,1,'666','2025-04-07 19:46:08',NULL,0),
(10,3001,1,'666','2025-04-10 13:27:19',NULL,1),
(12,3001,1,'555','2025-04-10 13:46:00',10,0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg' COMMENT '用户头像',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注册手机号',
  `user_type` enum('customer','staff') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'customer' COMMENT '标识用户身份：普通顾客/某个商家的员工',
  `is_platform_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否平台管理员',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int DEFAULT '1' COMMENT '账户状态（1正常，0冻结）',
  `balance` int DEFAULT '0' COMMENT '账户余额，单位/分',
  `nickname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT 'default nickname',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`avatar`,`username`,`password`,`phone`,`user_type`,`is_platform_admin`,`create_time`,`update_time`,`status`,`balance`,`nickname`) values 
(1,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer1','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800001111','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,1000000,'default nickname'),
(2,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer2','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800002222','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,500000,'default nickname'),
(3,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','store_staff','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800003333','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(4,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','platform_admin','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800004444','customer',1,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(5,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer3','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13811112222','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,800000,'default nickname'),
(6,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer4','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13822223333','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,700000,'default nickname'),
(7,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer5','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13833334444','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,600000,'default nickname'),
(8,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer6','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13844445555','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,900000,'default nickname'),
(9,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer7','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13855556666','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,300000,'default nickname'),
(10,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer8','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13866667777','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,400000,'default nickname'),
(11,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff01','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13877778888','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(12,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff02','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13888889999','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(13,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff03','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13899990000','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(14,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff04','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800010002','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(15,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff05','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800020003','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(16,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff06','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800030004','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(17,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff07','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800040005','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(18,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff08','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800050006','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(19,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff09','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800060007','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(20,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff10','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800070008','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(21,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff11','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800080009','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(22,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff12','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800090010','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(23,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff13','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800100011','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(24,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff14','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800110012','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(25,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff15','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800120013','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(26,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff16','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800130014','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(27,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff17','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800140015','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(28,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff18','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800150016','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(29,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff19','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800160017','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(30,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','staff20','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800170018','staff',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,0,'default nickname'),
(31,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer9','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800180019','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,200000,'default nickname'),
(32,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer10','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800190020','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,150000,'default nickname'),
(33,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer11','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800200021','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,250000,'default nickname'),
(34,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer12','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800210022','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,350000,'default nickname'),
(35,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer13','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800220023','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,450000,'default nickname'),
(36,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer14','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800230024','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,550000,'default nickname'),
(37,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer15','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800240025','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,650000,'default nickname'),
(38,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer16','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800250026','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,750000,'default nickname'),
(39,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer17','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800260027','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,850000,'default nickname'),
(40,'https://feifan-longye.oss-cn-beijing.aliyuncs.com/defaultAvatar.jpg','customer18','$2a$10$fOhr.BFWkCxYOhWKUV6yi.N4ARsXinKQ3rYvFHZ9DFmJTcfDUAulS','13800270028','customer',0,'2025-04-10 12:29:55','2025-04-10 12:29:55',1,950000,'default nickname');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
