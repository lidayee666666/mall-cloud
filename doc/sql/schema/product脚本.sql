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

/*Table structure for table `categories` */

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '种类id',
  `category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类目名称',
  `product_num` bigint DEFAULT NULL COMMENT '商品数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` bigint DEFAULT NULL COMMENT '创建人',
  `updater` bigint DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='商品种类表';

/*Data for the table `categories` */

insert  into `categories`(`id`,`category`,`product_num`,`create_time`,`update_time`,`creator`,`updater`) values 
(1,'手机数码',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(2,'家用电器',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(3,'服装鞋帽',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(4,'美妆个护',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(5,'图书音像',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(6,'运动户外',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(7,'食品生鲜',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(8,'家居生活',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(9,'母婴用品',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(10,'宠物用品',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(11,'全球购',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL),
(12,'二手优品',0,'2025-04-10 12:29:55','2025-04-10 12:30:11',NULL,NULL);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `store_id` bigint NOT NULL COMMENT '商家id',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `price` int NOT NULL DEFAULT '0' COMMENT '价格（分）',
  `stock` int unsigned NOT NULL COMMENT '库存数量',
  `image` varchar(500) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='商品表';

/*Data for the table `product` */

insert  into `product`(`id`,`store_id`,`name`,`price`,`stock`,`image`,`category`,`sold`,`comment_count`,`status`,`create_time`,`update_time`,`creator`,`updater`) values 
(3001,1001,'旗舰智能手机',599900,0,'http://img.alicdn.com/img/i4/1179720066/O1CN01LcQ7OY1CMH9kzK4h0_!!4611686018427386242-0-saturn_solar.jpg','手机数码',276,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3002,1001,'无线蓝牙耳机',19900,188,'http://img.alicdn.com/img/i2/2208531962468/O1CN014Sfm1Z1U6ONTyrlJC_!!2208531962468-0-alimamacc.jpg_580x580q90.jpg_.webp','手机数码',121,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3003,1002,'4K智能电视',299900,50,'http://img.alicdn.com/img/i1/19068296/O1CN01vHbr3b2B9cn5srTID_!!4611686018427385224-0-saturn_solar.jpg','家用电器',179,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3004,1002,'全自动洗衣机',399900,21,'https://img.alicdn.com/imgextra/i3/2212424393116/O1CN01jRv0Pd1YtBBZvnsqs_!!2212424393116-0-alimamacc.jpg','家用电器',9,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3005,1001,'男士休闲鞋',29900,291,'http://img.alicdn.com/img/i4/2084640046/O1CN01gEz6de1CD7DGDYeju_!!0-saturn_solar.jpg','服装鞋帽',431,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3006,1003,'女士连衣裙',19900,133,'http://img.alicdn.com/img/i3/111299660/O1CN01blUJxk2LEKzeBN9Wx_!!0-saturn_solar.jpg','服装鞋帽',17,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3007,1004,'电饭煲',9900,67,'http://img.alicdn.com/img/i2/1643360180/O1CN01NglPlS1DCUILVzGrW_!!0-saturn_solar.jpg','家用电器',13,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3008,1005,'口红',29900,0,'http://img.alicdn.com/img/i3/688060003/O1CN01yfxe1q1BtQEU4QVGS_!!4611686018427385443-0-saturn_solar.jpg','美妆个护',517,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3009,1006,'编程书籍',8900,493,'http://img.alicdn.com/img/i1/1884000171/O1CN01rVrB2R1D8MhofsVAF_!!0-saturn_solar.jpg','图书音像',7,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3010,1007,'跑步机',199900,30,'http://img.alicdn.com/img/i3/58641111/O1CN01tIclZL1K4t3pvaXoL_!!4611686018427382487-0-saturn_solar.jpg','运动户外',92,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3011,1008,'有机大米',3900,992,'http://img.alicdn.com/img/i4/34486274/O1CN014owLkF1wDXxSmdY6n_!!4611686018427385858-2-saturn_solar.png','食品生鲜',195,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3012,1009,'床上四件套',19900,187,'http://img.alicdn.com/img/i4/1240230048/O1CN01ziWPDz1CE20fPY7ca_!!0-saturn_solar.jpg','家居生活',13,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3013,1010,'手机充电器',4900,281,'http://img.alicdn.com/img/i3/5218037874/O1CN01l5gs5g282LfQ3Usip_!!4611686018427383922-0-saturn_solar.jpg','手机数码',19,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3014,1011,'婴儿推车',59900,91,'http://img.alicdn.com/img/i3/55899220/O1CN01XB1BjH2HyolbejaqS_!!4611686018427384916-0-saturn_solar.jpg','母婴用品',325,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3015,1012,'宠物粮',9900,0,'http://img.alicdn.com/img/i2/109253693/O1CN01couHnu1d9RXkXwpIT_!!0-saturn_solar.jpg_580x580q90.jpg_.webp','宠物用品',440,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3016,1013,'进口红酒',19900,189,'http://img.alicdn.com/img/i4/2940140181/O1CN01CfBUS11DCwhdgqBCn_!!4611686018427386517-0-saturn_solar.jpg','全球购',11,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3017,1014,'二手笔记本',299900,47,'http://img.alicdn.com/img/i3/6604167987/O1CN01Z6shEI28s6PgSpzIJ_!!4611686018427386675-0-saturn_solar.jpg','二手优品',3,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3018,1015,'家政服务',19900,0,'http://img.alicdn.com/img/i3/1496810002/O1CN01w0xAA91BsxobsJk6F_!!4611686018427380242-2-saturn_solar.png','本地服务',13,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3019,1016,'车载充电器',7900,149,'http://img.alicdn.com/img/i3/5218037874/O1CN01l5gs5g282LfQ3Usip_!!4611686018427383922-0-saturn_solar.jpg','汽车用品',1,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3020,1017,'维生素C',2900,294,'http://img.alicdn.com/img/i1/119533050/O1CN01uAPXkE1YOx1wLsOJG_!!4611686018427383290-0-saturn_solar.jpg','医药健康',6,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3021,1001,'旗舰智能手机X',699900,73,'http://img.alicdn.com/img/i1/15237275/O1CN01J2zIM723c0QDIPA5v_!!4611686018427379867-0-saturn_solar.jpg','手机数码',125,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3022,1002,'8K智能电视',599900,19,'http://img.alicdn.com/img/i1/16639385/O1CN01wFY1402JCO7gzBWfH_!!4611686018427381145-0-saturn_solar.jpg','家用电器',11,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3023,1003,'男士西装',59900,94,'https://ilce.alicdn.com/minolta/483209/3/e18f3b6d49a977c392902657d059c207.jpg_800x800.jpg?channel=4&content=%7B%2211%22%3A%7B%22url%22%3A%22https%3A%2F%2Fimg.alicdn.com%2Fbao%2Fuploaded%2Fi3%2F664644235%2FO1CN013yTnbJ1h9gJxwfcQ6_%21%21664644235.jpg%22%2C%22filters%22%3A%5B%7B%22type%22%3A%22copy%22%2C%22attrs%22%3A%7B%22src_rect%22%3A%5B54%2C227%2C634%2C634%5D%2C%22dst_rect%22%3A%5B0%2C0%2C513%2C513%5D%7D%7D%5D%7D%7D&getAvatar=avatar_580x580q90.jpg_.webp','服装鞋帽',6,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3024,1004,'空气炸锅',29900,119,'http://img.alicdn.com/img/i2/6392002997/O1CN01cHNPoA1Y0g3OWFL92_!!4611686018427386293-0-saturn_solar.jpg','家用电器',206,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3025,1005,'香水',49900,0,'http://img.alicdn.com/img/i2/129059638/O1CN01aRi9fR2L4GKIiOqVK_!!4611686018427382582-0-saturn_solar.jpg','美妆个护',557,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3026,1006,'儿童绘本',4900,298,'http://img.alicdn.com/img/i3/7413206091/O1CN01St69Ix1urjTx22hil_!!4611686018427382859-0-saturn_solar.jpg','图书音像',2,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3027,1007,'瑜伽垫',3900,193,'http://img.alicdn.com/img/i4/271390167/O1CN012Ly9i21D6X72nAiJQ_!!0-saturn_solar.jpg','运动户外',7,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3028,1008,'新鲜鸡蛋',990,985,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/6000000003611/O1CN01wQF9tU1cXtEvALiWW_!!6000000003611-2-mia.png','食品生鲜',566,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3029,1009,'餐具套装',9900,138,'http://img.alicdn.com/img/i3/54709221/O1CN01hOE3jV2HzH9gBoikz_!!4611686018427382757-0-saturn_solar.jpg','家居生活',12,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3030,1010,'蓝牙音箱',19900,85,'http://img.alicdn.com/img/i3/2464700053/O1CN01HImT1n1CGJlnF2OMf_!!0-saturn_solar.jpg','手机数码',561,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3031,1011,'儿童安全座椅',89900,77,'http://img.alicdn.com/img/i2/2201503044793/O1CN011N8HBx1lHFI8xvmQC_!!2201503044793-0-alimamacc.jpg','母婴用品',3,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3032,1012,'猫砂盆',4900,189,'http://img.alicdn.com/img/i3/328340019/O1CN01d3ttV81C0kZOhPWJy_!!4611686018427384371-0-saturn_solar.jpg','宠物用品',11,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3033,1013,'进口巧克力',9900,291,'http://img.alicdn.com/img/i2/1280570023/O1CN01X8j9Ga1C2a8oCbWp3_!!4611686018427384487-0-saturn_solar.jpg','全球购',9,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3034,1014,'二手手机',99900,96,'https://img.alicdn.com/imgextra/i4/2937783914/O1CN01DZNVuf1emfFJborNA_!!2937783914-0-alimamacc.jpg','二手优品',4,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3035,1015,'家电清洗',29900,0,'http://img.alicdn.com/img/i4/2475900067/O1CN01hzy1mM1CMjZyEtzF3_!!4611686018427387043-0-saturn_solar.jpg','本地服务',4,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3036,1016,'行车记录仪',19900,90,'http://img.alicdn.com/img/i2/108572212/O1CN01Yvms4Y1SD98uwj5ah_!!4611686018427383348-0-saturn_solar.jpg','汽车用品',10,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3037,1017,'医用口罩',990,0,'http://img.alicdn.com/img/i3/583370131/O1CN01QQkaSr1Cq2oEGf0fi_!!0-saturn_solar.jpg','医药健康',505,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3038,1001,'智能手表',29900,192,'http://img.alicdn.com/img/i1/1963410090/O1CN01RRUvYa1CXGeRYp7jK_!!4611686018427380394-0-saturn_solar.jpg','手机数码',8,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3039,1002,'对开门冰箱',799900,17,'https://img1.360buyimg.com/n6/jfs/t1/270355/26/9388/103445/67e0baf3F660eb8a9/1cd7b21baf4c8bf8.jpg','家用电器',3,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3040,1003,'女士高跟鞋',19900,176,'http://img.alicdn.com/img/i1/1347990131/O1CN01ff8qUh1Cq2vjJkDjg_!!4611686018427384435-0-saturn_solar.jpg','服装鞋帽',245,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3041,1004,'电磁炉',19900,95,'http://img.alicdn.com/img/i2/110849235/O1CN01tSUlE42I5gN9SsesJ_!!0-saturn_solar.jpg','家用电器',5,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3042,1005,'粉底液',39900,0,'http://img.alicdn.com/img/i2/117845398/O1CN01MJrdPD1pkL0YjfQzn_!!4611686018427383190-0-saturn_solar.jpg','美妆个护',111,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3043,1006,'文学小说',6900,191,'http://img.alicdn.com/img/i2/55796337/O1CN01gnc9u61wgOesEA5Ru_!!0-saturn_solar.jpg','图书音像',9,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3044,1007,'登山包',29900,67,'https://img.alicdn.com/imgextra/i1/1808944664/O1CN01CRZry51kKAHjDMWNv_!!1808944664-0-alimamacc.jpg','运动户外',13,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3045,1008,'新鲜牛奶',490,492,'http://img.alicdn.com/img/i2/1400450138/O1CN01tVALrF1CtFhMljBLV_!!4611686018427382874-0-saturn_solar.jpg','食品生鲜',218,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3046,1009,'收纳箱',4900,142,'http://img.alicdn.com/img/i1/7518902247/O1CN01qzFB5Q1STB0Lz3dWK_!!4611686018427385831-0-saturn_solar.jpg_580x580q90.jpg_.webp','家居生活',8,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3047,1010,'手机贴膜',900,0,'http://img.alicdn.com/img/i4/2286400077/O1CN01uJRrRm1CRJXcKkNEC_!!4611686018427384397-0-saturn_solar.jpg','手机数码',158,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3048,1011,'婴儿奶瓶',9900,193,'http://img.alicdn.com/img/i4/107453279/O1CN01S6J1YW1a5pjpqFACN_!!4611686018427386719-0-saturn_solar.jpg','母婴用品',7,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3049,1012,'狗玩具',1900,297,'http://img.alicdn.com/img/i2/5263328257/O1CN01ePwPy52ArlKsycrfS_!!4611686018427380737-0-saturn_solar.jpg','宠物用品',3,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3050,1013,'进口奶粉',29900,97,'http://img.alicdn.com/img/i4/3130538718/O1CN01P1lEeD2EGtwaqRCcZ_!!4611686018427386590-0-saturn_solar.jpg','全球购',3,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3051,1018,'在线课程',9900,0,'http://img.alicdn.com/img/i4/1665580011/O1CN01ilh3zG1Bx5OPTD7TQ_!!4611686018427386859-2-saturn_solar.png','虚拟商品',2,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3052,1019,'办公设备',199900,43,'http://img.alicdn.com/img/i4/25577833/O1CN01Jpb3Ac27jZPbmJSCE_!!4611686018427382121-0-saturn_solar.jpg','企业采购',7,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3053,1020,'有机苹果',2990,0,'http://img.alicdn.com/img/i1/3526856527/O1CN01Pix6NN1y5QA5Q5fnG_!!4611686018427383631-0-saturn_solar.jpg_580x580q90.jpg_.webp','扶贫助农',537,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3054,1005,'男士洁面乳',9900,144,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i4/917264765/O1CN01FSUz3e1l4QIVM0Gkm_!!4611686018427386237-0-item_pic.jpg','美妆个护',6,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3055,1006,'考研英语资料',4900,76,'https://gw.alicdn.com/imgextra/O1CN01751JAD1h1teWlPv7g_!!2206584264218-0-C2M.jpg','图书音像',4,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3056,1007,'登山杖',3900,119,'http://img.alicdn.com/img/i4/53381329/O1CN01c1dZ501LgjQ5B2MwF_!!4611686018427381969-0-saturn_solar.jpg','运动户外',1,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3057,1008,'冷冻牛排',6990,0,'http://img.alicdn.com/img/i3/1238760167/O1CN01iarbSo1D6XAIMDGL4_!!4611686018427386599-0-saturn_solar.jpg','食品生鲜',110,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3058,1009,'智能扫地机',299900,23,'http://img.alicdn.com/img/i2/2395440032/O1CN015RWQFr1C6hinYQww5_!!4611686018427380640-0-saturn_solar.jpg','家居生活',17,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3059,1011,'婴儿辅食机',19900,49,'http://img.alicdn.com/img/i4/2207506986001/O1CN01qRh3ok1uCVlvvM8Pi_!!2207506986001-0-alimamacc.jpg','母婴用品',11,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3060,1012,'猫爬架',29900,0,'http://img.alicdn.com/img/i1/3312554745/O1CN01FDOsLl1kvGMDnFbLl_!!4611686018427384569-0-saturn_solar.jpg','宠物用品',91,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3061,1013,'进口橄榄油',19900,142,'http://img.alicdn.com/img/i3/6010316424/O1CN01YAIYph1xKFGhcYx1g_!!0-saturn_solar.jpg','全球购',8,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3062,1014,'二手相机',159900,23,'http://img.alicdn.com/img/i4/2217007641844/O1CN01yn72331PUbNDBT6yU_!!2217007641844-0-alimamacc.jpg','二手优品',7,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3063,1015,'月嫂服务',49900,0,'http://img.alicdn.com/img/i4/7005136372/O1CN0188xWpa1wwQlzI3NDC_!!4611686018427381236-2-saturn_solar.png','本地服务',7,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3064,1016,'汽车座垫',29900,99,'http://img.alicdn.com/img/i4/7499743566/O1CN013J8mx91cDHPJ1hFLo_!!4611686018427380046-0-saturn_solar.jpg','汽车用品',1,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3065,1017,'钙片',3900,0,'https://img.alicdn.com/imgextra/i3/2217142550823/O1CN01jIXXeq1Hwz0RAw8Wl_!!2217142550823-0-alimamacc.jpg','医药健康',7,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3066,1001,'平板电脑',299900,69,'https://img13.360buyimg.com/n1/s450x450_jfs/t1/174456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','手机数码',11,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3067,1002,'空调',399900,10,'https://img13.360buyimg.com/n1/s450x450_jfs/t1/174456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','家用电器',15,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3068,1003,'儿童运动鞋',9900,173,'https://img14.360buyimg.com/n1/s450x450_jfs/t1/163456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','服装鞋帽',7,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3069,1004,'榨汁机',9900,74,'https://img12.360buyimg.com/n1/s450x450_jfs/t1/185456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','家用电器',16,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3070,1005,'眼影盘',19900,0,'https://img12.360buyimg.com/n1/s450x450_jfs/t1/135456/12/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','美妆个护',10,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3071,1006,'历史书籍',5900,142,'http://img.alicdn.com/img/i2/2206782221245/O1CN01C4EuRJ1L4G6XfE0tL_!!2206782221245-0-alimamacc.jpg','图书音像',8,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3072,1007,'健身哑铃',9900,96,'http://img.alicdn.com/img/i3/1794070059/O1CN016IUQhP1CJ4PtVPb2A_!!4611686018427385387-0-saturn_solar.jpg','运动户外',4,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3073,1008,'有机蔬菜',1990,0,'http://img.alicdn.com/img/i3/43659802/O1CN01aBIKnN2MHNFMxxrxv_!!4611686018427384346-0-saturn_solar.jpg','食品生鲜',7,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3074,1009,'窗帘',19900,56,'http://img.alicdn.com/img/i4/47069196/O1CN01zG4PsY2HnpGhgCpI3_!!4611686018427385868-0-saturn_solar.jpg','家居生活',4,0,2,'2025-04-10 12:29:55','2025-04-16 19:39:47',NULL,NULL),
(3075,1010,'移动电源',9900,190,'http://img.alicdn.com/img/i1/2201050149067/O1CN01DosYVH2Gqk95ezZB0_!!2201050149067-0-alimamacc.jpg','手机数码',10,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3076,1011,'孕妇装',19900,70,'https://img.alicdn.com/imgextra/i2/2201234834599/O1CN01FIlWjb1jqOXxlWbMB_!!2201234834599-0-alimamacc.jpg','母婴用品',10,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3077,1012,'鱼缸',19900,0,'http://img.alicdn.com/img/i2/47796313/O1CN01UleIpP1wVPP02Bibf_!!4611686018427383897-0-saturn_solar.jpg','宠物用品',6,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3078,1013,'进口饼干',4900,194,'http://img.alicdn.com/img/i1/30922889/O1CN01HyqQtU1XDDGOTDp1N_!!4611686018427385993-0-saturn_solar.jpg','全球购',6,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3079,1014,'二手家具',59900,33,'http://img.alicdn.com/img/i2/179270184/O1CN01rp2mm81DEJsenQAqE_!!0-saturn_solar.jpg','二手优品',7,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3080,1015,'搬家服务',19900,0,'http://img.alicdn.com/img/i2/1519180189/O1CN01nuoLYw1DGbqfUUMRn_!!0-saturn_solar.jpg','本地服务',3,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3081,1016,'车载冰箱',29900,53,'http://img.alicdn.com/img/i4/2010740181/O1CN01jJ4xmJ1DCwj2WgX7T_!!4611686018427385301-0-saturn_solar.jpg','汽车用品',7,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3082,1017,'体温计',1900,0,'https://img.alicdn.com/imgextra/i3/3022255082/O1CN01nM2Tzf1nPbomkEAOV_!!3022255082-0-alimamacc.jpg','医药健康',7,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3083,1001,'电子阅读器',99900,65,'https://img12.360buyimg.com/n1/s450x450_jfs/t1/185456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','手机数码',5,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3084,1002,'微波炉',19900,56,'https://img14.360buyimg.com/n1/s450x450_jfs/t1/125678/35/5947/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','家用电器',4,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3085,1003,'男士皮带',9900,113,'https://img13.360buyimg.com/n1/s450x450_jfs/t1/174456/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','服装鞋帽',7,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3086,1004,'电风扇',9900,137,'https://img10.360buyimg.com/n1/s450x450_jfs/t1/129215/21/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','家用电器',13,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3087,1005,'防晒霜',19900,0,'https://img11.360buyimg.com/n1/s450x450_jfs/t1/142536/35/5978/234927/5efbf28cEbf04a25a/e2bcc4110f76b2d8.jpg','美妆个护',11,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL),
(3088,1006,'科普读物',3900,106,'http://img.alicdn.com/img/i1/31738812/O1CN01EpJAU22ExxB63gp8S_!!4611686018427382716-0-saturn_solar.jpg','图书音像',14,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3089,1007,'羽毛球拍',9900,86,'http://img.alicdn.com/img/i3/2385370195/O1CN01kxxkgA1DJM9P50Dcb_!!0-saturn_solar.jpg','运动户外',4,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3090,1008,'有机蜂蜜',3990,0,'http://img.alicdn.com/img/i4/11720877/O1CN01TRQmiA1ILiLgDdvOt_!!0-saturn_solar.jpg','食品生鲜',8,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3091,1009,'台灯',9900,93,'http://img.alicdn.com/img/i4/2046560174/O1CN01cxfWIY1D9jxdsYJcK_!!4611686018427381678-0-saturn_solar.jpg','家居生活',7,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3092,1010,'U盘',4900,249,'https://img.alicdn.com/imgextra/i1/2213011001717/O1CN01lkNtoU1OYR5HbL8c2_!!2213011001717-0-alimamacc.jpg','手机数码',1,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3093,1011,'婴儿湿巾',2900,289,'http://img.alicdn.com/img/i1/109538245/O1CN01tzlFtN2AmGYpxJv6i_!!0-saturn_solar.jpg','母婴用品',11,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3094,1012,'鸟笼',9900,31,'http://img.alicdn.com/img/i4/1170450017/O1CN015YTaR01BzplyLaJkI_!!4611686018427381345-0-saturn_solar.jpg','宠物用品',9,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3095,1013,'进口咖啡',9900,0,'http://img.alicdn.com/img/i2/110496396/O1CN0110qGnn1x7QFdTthbm_!!4611686018427382412-0-saturn_solar.jpg','全球购',6,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3096,1014,'二手自行车',99900,25,'http://img.alicdn.com/img/i4/1175810135/O1CN01ilXc311CrsW9bDt2k_!!4611686018427383895-0-saturn_solar.jpg','二手优品',5,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3097,1015,'保洁服务',9900,0,'http://img.alicdn.com/img/i2/434620194/O1CN01wyVv3D1DItl23Napc_!!0-saturn_solar.jpg','本地服务',12,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3098,1016,'汽车香水',3900,106,'http://img.alicdn.com/img/i1/7367283936/O1CN01MStoIA1ewjwQSuFng_!!4611686018427385056-0-saturn_solar.jpg','汽车用品',14,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3099,1017,'创可贴',490,0,'http://img.alicdn.com/img/i4/2214427906668/O1CN01O4SsHL1z7zwoFKXri_!!2214427906668-0-alimamacc.jpg','医药健康',3,0,2,'2025-04-10 12:29:55','2025-04-16 21:47:22',NULL,NULL),
(3100,1020,'农家土鸡蛋',1990,0,'https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/6000000003611/O1CN01wQF9tU1cXtEvALiWW_!!6000000003611-2-mia.png','扶贫助农',7,0,2,'2025-04-10 12:29:55','2025-04-10 12:31:11',NULL,NULL);

/*Table structure for table `staff_role` */

DROP TABLE IF EXISTS `staff_role`;

CREATE TABLE `staff_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `store_id` bigint NOT NULL COMMENT '所属商家',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `permissions` text COMMENT '权限JSON',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工角色表';

/*Data for the table `staff_role` */

/*Table structure for table `store_detail` */

DROP TABLE IF EXISTS `store_detail`;

CREATE TABLE `store_detail` (
  `store_id` bigint NOT NULL COMMENT '关联商家ID',
  `logo` varchar(255) DEFAULT NULL COMMENT '商家logo',
  `description` text COMMENT '商家描述',
  `contact_phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(255) DEFAULT NULL COMMENT '商家地址',
  `business_license` varchar(255) DEFAULT NULL COMMENT '营业执照图片',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商家详情表';

/*Data for the table `store_detail` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
