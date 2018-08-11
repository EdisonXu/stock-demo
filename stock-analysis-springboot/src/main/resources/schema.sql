/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `daily_quote` */

CREATE TABLE IF NOT EXISTS `daily_quote` (
  `stockId` varchar(50) NOT NULL,
  `prevClosePrice` decimal(10,4) DEFAULT NULL,
  `openPrice` decimal(10,4) DEFAULT NULL,
  `highPrice` decimal(10,4) DEFAULT NULL,
  `lowPrice` decimal(10,4) DEFAULT NULL,
  `closePrice` decimal(10,4) DEFAULT NULL,
  `tradingDay` date NOT NULL,
  PRIMARY KEY (`stockId`,`tradingDay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `operate_record` */

CREATE TABLE IF NOT EXISTS `operate_record` (
  `userId` bigint(20) DEFAULT NULL,
  `stockId` varchar(50) DEFAULT NULL,
  `stockName` varchar(50) DEFAULT NULL,
  `price` decimal(10,4) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `reduce_money_event` */

CREATE TABLE IF NOT EXISTS `reduce_money_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wallet_id` bigint(20) DEFAULT NULL,
  `value` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35378 DEFAULT CHARSET=utf8;

/*Table structure for table `stock_snapshot` */

CREATE TABLE IF NOT EXISTS `stock_snapshot` (
  `userId` bigint(20) DEFAULT NULL,
  `stockId` varchar(50) DEFAULT NULL,
  `stockName` varchar(50) DEFAULT NULL,
  `cost` decimal(10,4) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `profitAndLoss` decimal(10,4) DEFAULT NULL,
  `lastUpdateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `idx` (`userId`,`stockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `quote` (
  `stockId` varchar(50) DEFAULT NULL,
  `price` decimal(10,4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  KEY `stockIdx` (`stockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
