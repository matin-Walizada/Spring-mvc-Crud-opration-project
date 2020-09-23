CREATE TABLE `products_tbl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `doe` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
`photo` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1