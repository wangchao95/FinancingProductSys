/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.54 : Database - financingproductsys
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MOD=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`financingproductsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `financingproductsys`;

/*Table structure for table `financingproduct` */

DROP TABLE IF EXISTS `financingproduct`;

CREATE TABLE `financingproduct` (
  `id` varchar(4) NOT NULL,
  `risk` int(50) NOT NULL,
  `income` varchar(50) NOT NULL,
  `saleStarting` datetime NOT NULL,
  `saleEnd` datetime NOT NULL,
  `end` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `financingproduct` */

insert  into `financingproduct`(`id`,`risk`,`income`,`saleStarting`,`saleEnd`,`end`) values ('2104',2,'5.6%','2017-12-14 00:00:00','2017-12-22 00:00:00','2018-12-14 00:00:00'),('2105',3,'5.7%','2017-11-14 00:00:00','2017-12-29 00:00:00','2018-12-17 00:00:00'),('2106',1,'5.3%','2017-10-12 00:00:00','2017-12-26 00:00:00','2018-12-16 00:00:00'),('2107',2,'5.9%','2017-12-14 00:00:00','2017-12-23 00:00:00','2018-12-15 00:00:00'),('2108',1,'6.6%','2017-11-14 00:00:00','2017-12-22 00:00:00','2018-12-14 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
