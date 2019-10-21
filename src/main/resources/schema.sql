CREATE DATABASE `poc_grpc` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `Customer` (
  `id` int(6) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `Orders` (
  `id` int(6) NOT NULL,
  `customer_id` int(6) NOT NULL,
  `order_number` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CustomerOrder` (`customer_id`),
  CONSTRAINT `FK_CustomerOrder` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;