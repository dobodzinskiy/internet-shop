-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_surname` varchar(255) DEFAULT NULL,
  `user_gender` varchar(10) DEFAULT NULL,
  `user_mail` varchar(50) NOT NULL,
  `user_password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `user_login` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `staff` tinyint(4) NOT NULL DEFAULT '0',
  `registration_date` date NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `users_user_login_uindex` (`user_login`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (20,'Denis','Obodzinskiy','Male','denisobodzinskiy@gmail.com','01inafop',1,'admin','380502838571',1,'2016-04-20'),(24,'Denis','Obodzinskiy','Male','denisobodzinskiy@gmail.com','denis',1,'denis','380502838571',0,'2016-05-16'),(25,'Denis','Obodzinskiy','Male','denisobodzinskiy@gmail.com','moder',1,'Moder','380502838571',0,'2016-05-16'),(26,'Denis','Obodzinskiy','Male','denisobodzinskiy@gmail.com','manager',1,'Manager','380502838571',1,'2016-05-09'),(27,'name','LastName','Male','denisobodzinskiy@gmail.com','user',1,'newUser','380502838571',0,'2016-05-20'),(28,NULL,NULL,NULL,'denisobodzinskiy@gmail.com','user',1,'user5','380502838571',0,'2016-05-20'),(29,NULL,NULL,NULL,'denisobodzinskiy@gmail.com','testUser',1,'testUser','380502838571',0,'2016-05-26');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-02 17:55:26
