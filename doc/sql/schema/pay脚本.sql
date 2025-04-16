/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 : Database - mall-payment
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mall-payment` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mall-payment`;

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `biz_order_no` bigint NOT NULL DEFAULT '0' COMMENT '业务订单号',
  `pay_order_no` bigint NOT NULL DEFAULT '0' COMMENT '支付单号',
  `biz_user_id` bigint NOT NULL COMMENT '支付用户id',
  `pay_channel_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '支付渠道编码',
  `amount` int NOT NULL COMMENT '支付金额，单位/分',
  `pay_type` tinyint NOT NULL DEFAULT '5' COMMENT '支付类型，1：h5,2:小程序，3：公众号，4：扫码，5：余额支付，6：支付宝，7：微信支付',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态，0：待提交，1:待支付，2：支付超时或取消，3：支付成功，4：退款中，5：已退款',
  `expand_json` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '拓展字段，用于传递不同渠道单独处理的字段',
  `result_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '第三方返回业务码',
  `result_msg` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '第三方返回提示信息',
  `response_json` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '第三方返回的完整响应内容',
  `pay_success_time` timestamp NULL DEFAULT NULL COMMENT '支付成功时间',
  `pay_over_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '支付超时时间',
  `qr_code_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付二维码链接',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` bigint NOT NULL DEFAULT '0' COMMENT '创建人',
  `updater` bigint NOT NULL DEFAULT '0' COMMENT '更新人',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `biz_order_no` (`biz_order_no`) USING BTREE,
  UNIQUE KEY `pay_order_no` (`pay_order_no`) USING BTREE,
  KEY `idx_biz_user_id` (`biz_user_id`) USING BTREE,
  KEY `idx_pay_channel_code` (`pay_channel_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='支付订单';

/*Data for the table `payment` */

insert  into `payment`(`id`,`biz_order_no`,`pay_order_no`,`biz_user_id`,`pay_channel_code`,`amount`,`pay_type`,`status`,`expand_json`,`result_code`,`result_msg`,`response_json`,`pay_success_time`,`pay_over_time`,`qr_code_url`,`create_time`,`update_time`,`creator`,`updater`,`is_delete`) values 
(1,1,202408181,36,'0',26734,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(2,2,202404192,9,'0',55889,3,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(3,3,202407303,33,'0',95326,3,1,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(4,4,202403034,10,'0',7991,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(5,5,202406245,7,'0',93216,3,1,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(6,6,202405076,5,'0',79992,3,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(7,7,202408267,34,'0',58408,3,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(8,8,202406038,35,'0',74796,3,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(9,9,202403029,37,'0',93793,3,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(10,10,2024051910,6,'0',20965,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(11,11,2024022311,1,'0',52010,1,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(12,12,2024060212,38,'0',77779,3,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(13,13,2024092813,31,'0',21607,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(14,14,2024012714,8,'0',58172,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(15,15,2024051615,39,'0',22941,3,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(16,16,2024030916,2,'0',18105,1,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(17,17,2024082717,4,'0',38604,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(18,18,2024040318,32,'0',72503,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(19,19,2024092519,40,'0',52978,1,3,NULL,'','',NULL,NULL,'2025-04-10 12:29:55',NULL,'2025-04-10 12:29:55','2025-04-10 12:29:55',0,0,'\0'),
(32,32,555278041,2,'0',2264,6,3,NULL,'','',NULL,NULL,'2025-04-10 12:38:58',NULL,'2025-04-10 12:38:58','2025-04-10 12:38:58',2,2,'\0'),
(33,33,862029909,2,'0',656,6,3,NULL,'','',NULL,NULL,'2025-04-10 12:39:12',NULL,'2025-04-10 12:39:12','2025-04-10 12:39:12',2,2,'\0'),
(34,34,542539756,2,'0',59,2,3,NULL,'','',NULL,NULL,'2025-04-10 12:39:18',NULL,'2025-04-10 12:39:18','2025-04-10 12:39:18',2,2,'\0'),
(35,35,291255608,2,'0',89,7,3,NULL,'','',NULL,NULL,'2025-04-10 12:39:44',NULL,'2025-04-10 12:39:44','2025-04-10 12:39:44',2,2,'\0'),
(36,36,944084968,1,'0',199,6,3,NULL,'','',NULL,NULL,'2025-04-13 15:51:54',NULL,'2025-04-13 15:51:54','2025-04-13 15:51:54',1,1,'\0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
