/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.20 : Database - 1173710212
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`1173710212` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `1173710212`;

/*Table structure for table `deal_table` */

DROP TABLE IF EXISTS `deal_table`;

CREATE TABLE `deal_table` (
  `deal_id` varchar(11) NOT NULL,
  `product_type` varchar(20) NOT NULL,
  `buy_time_year` varchar(10) NOT NULL,
  `buy_time_month` varchar(10) NOT NULL,
  `price` varchar(20) NOT NULL,
  `new_level` varchar(20) NOT NULL,
  `introduce` varchar(140) DEFAULT NULL,
  `contact` varchar(20) NOT NULL,
  `contact_phone` varchar(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  PRIMARY KEY (`deal_id`),
  KEY `deal_table_ibfk_1` (`user_name`),
  CONSTRAINT `deal_table_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `user_table` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `deal_table` */

insert  into `deal_table`(`deal_id`,`product_type`,`buy_time_year`,`buy_time_month`,`price`,`new_level`,`introduce`,`contact`,`contact_phone`,`user_name`) values 
('bqa6eXCetLO','台式机','2008','03','4510','95成新','最新数据','admin-X','13964980765','admin'),
('PGINi91CJJK','笔记本','2000','01','3000','8成新','test2','admin','15648486416','admin'),
('qI4rjIHqMEu','台式机','1955','8','304500','全新','tesbfkhdbdkshbdskhv.dsb','admin-X','50365684935','admin'),
('rXpC7nAYg5r','台式机','2077','09','6541','9成新','最新数据test','admin-X','19648561365','admin'),
('u547DbNZjaW','台式机','2077','08','200','7成新及以下','long time ago','admin-X','12346815965','admin'),
('YZJvwJSSvgb','台式机','1982','12','3066','7成新及以下','daafafafafa','admin-X','68515648622','admin'),
('ZiFiriXmcnL','笔记本','2010','09','1651','9成新','testtttt','admin-X','31555229954','admin');

/*Table structure for table `user_table` */

DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
  `user_name` varchar(20) NOT NULL,
  `user_psw` varchar(20) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_table` */

insert  into `user_table`(`user_name`,`user_psw`) values 
('admin','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
