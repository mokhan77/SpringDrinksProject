CREATE TABLE `drink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `taste` bigint DEFAULT NULL,
  `colour` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ;
