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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `product_photo` varchar(100) NOT NULL,
  `product_price` decimal(10,2) NOT NULL,
  `product_model` varchar(100) NOT NULL,
  `product_type` varchar(100) NOT NULL,
  `product_available` tinyint(4) NOT NULL DEFAULT '1',
  `product_size` varchar(100) NOT NULL,
  `product_weight` int(11) NOT NULL,
  `product_storage` int(11) NOT NULL,
  `product_ram` int(11) NOT NULL,
  `product_screen` float DEFAULT NULL,
  `product_os` varchar(100) NOT NULL,
  `product_color` varchar(100) NOT NULL,
  `product_description` varchar(500) NOT NULL,
  `product_processor` varchar(100) NOT NULL,
  `product_company` varchar(100) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Samsung Galaxy S6 Edge','SamsungS6.jpg',18999.00,'G925','PHONES',1,'142.1 x 70.1 x 7 mm',132,32,3,5.1,'Android','Grey','YOUR GALAXY. Make Galaxy S6 edge truly your own by sprucing it up with a theme of your choice. A huge selection of themes designed especially for your phone is available now.','Exynos 7420 (Quad 2.1 GHz+ Quad 1.5 GHz)','Samsung'),(2,'Apple MacBook Pro MF855UA/A','macbookpro13.jpg',41499.00,'MF855UA/A','LAPTOPS',1,'280.5 x 196.5 x 3.5 - 13.1 mm',920,256,8,13,'OS X Yosemite','Aluminum','A groundbreaking Retina display. A new force-sensing trackpad. All-flash architecture. Powerful dual-core and quad-core Intel processors. Together, these features take the notebook to a new level of performance. And they will do the same for you in everything you create','Intel Core i7 (4x 2.5 GHz)','Apple'),(3,'Artline Gaming','artlineGaming.jpg',62599.00,'X97v02','COMPUTERS',1,'260 x 498 x 525 mm',1200,2,32,0,'Windows 10','Black','New computer Artline Gaming allows you to feel the best emotions from your favorite games. Strong, powerfull, well-looking design you can play newest games with high performance and stability.','Intel Core i7 (4x 2.5 GHz)','Artline'),(4,'Apple Iphone 6s 16 gb','iphone6s.jpg',17999.00,'16GB Gold','PHONES',1,'138.1 x 67 x 6.9 mm',129,16,2,4.7,'iOS','Gold','More. In all senses. iPhone 6 is not simply bigger. It is better in all respects. Most , but much thinner . More powerful , but extremely economical. Its smooth metal surface smoothly into the glass of the new HD- the Retina display , forming a solid , finished design. Its hardware works perfectly with the software. This new generation of iPhone , improved throughout .','Apple A9','Apple'),(5,'Samsung Galaxy A7','SamsungA7.jpg',11999.00,'A7 2016','PHONES',1,'151.5 x 74.1 x 7.3 mm',172,16,3,5.5,'Android','Gold','\r\nThe excellent combination of metal and glass\r\nPremium design, reliability and glass splendor of Gorilla Glass. Rate comfortable viewing of images on a 5.5 - inch Full HD screen with a thin bezel .\r\nHigh performance\r\nEight-processor provides quick access to your favorite applications and excellent support multitasking .','Samsung Exynos 7 (1.6 GHz)','Samsung'),(6,'HTC One','htc1.jpg',9499.00,'Desire 700','PHONES',1,'145.5 x 72 x 10.3 mm',149,32,2,5,'Android','Brown','HTC Desire Model 700 is positioned as a budget alternative to the HTC One flagship.\r\nHTC Desire 700 has a processor Spreadtrum Shark 1.2 GHz quad-core Cortex-A7 and Mali400Mp graphics core and 1GB of RAM.\r\nScreen size is 5 inches, and its resolution - 540 x 960 pixels. The pixel density is 220 dpi.','Spreadtrum Shark 1.2 GHz','HTC'),(7,'Apple Macbook Air 13\'','macbookair.jpg',45099.00,'MJVG2UA/A','LAPTOPS',1,'325 x 227 x 3~17 mm',1350,256,4,13.3,'OSx Yosemite','Aluminium','Sure , MacBook Air incredibly thin and light . But Apple also made Ã¢ÂÂÃ¢ÂÂsure that it was a powerful , productive , reliable and easy to use . In addition , MacBook Air can operate without recharging for a whole day . This is the main difference between a thin and light laptop , and the laptop , which has a lot more advantages ','Intel Core i5 (1.6 GHz)','Apple'),(8,'Apple IMac ','AppleMacMF883.jpg',70599.00,'MK472UA/A','COMPUTERS',1,'650 Ñ 203 x 516',9,512,16,27,'Mac OS X El Capitan','Aluminium','Every millimeter Retina display is designed in accordance with the most stringent quality standards. 14.7 million pixels provide incredible clarity . A screen is 1.4 mm thick , created by taking into account the peculiarities of the human eye , provides a completely natural feel . Such attention to detail has allowed Apple to create a new 27 - inch iMac with Retina 5K display . It has an extended range of colors and excellent color reproduction .','Intel Core i7 (3.6 GHz)','Apple'),(9,'Asus Zenbook UX303UA','AsusZenbook.jpg',46599.00,'UX303UA','LAPTOPS',1,'138.1 x 67 x 6.9 mm',1400,128,4,13.3,'Windows 10','Aluminium','Asus performes new notebook ASUS ZENBOOK. New, lightweighted ultrabook that can manage a lot of tasks, rendering video, playing new games, exploring the internet etc. You can always keep this notebook with you becouse of it\'s ultra form-factor and light weight. ','Intel Core i5 (1.4 GHz)','Asus'),(10,'Apple MacBook Pro MU345Z\\D','macbookpro13.jpg',80399.00,'MU345Z\\D','LAPTOPS',1,'280.5 x 196.5 x 3.5 - 13.1 mm',900,1024,16,15,'OSx Yosemite','Aluminium','A groundbreaking Retina display. A new force-sensing trackpad. All-flash architecture. Powerful dual-core and quad-core Intel processors. Together, these features take the notebook to a new level of performance. And they will do the same for you in everything you create','Samsung Exynos 7 (2.6 GHz)','Apple'),(11,'Asus Zenbook UX303UA Black','AsusZenbookUX303.jpg',35099.00,'UX303B/B','LAPTOPS',1,'138.1 x 67 x 6.9 mm',1200,156,4,13,'Windows 10','Black','Asus performes new notebook ASUS ZENBOOK. New, lightweighted ultrabook that can manage a lot of tasks, rendering video, playing new games, exploring the internet etc. You can always keep this notebook with you becouse of it\'s ultra form-factor and light weight.','Intel Core i5 (1.6 GHz)','ASUS'),(12,'Apple Iphone 6s 64 gb','iphone6s.jpg',15399.00,'64 gb Gold','PHONES',1,'138.1 x 67 x 6.9 mm',129,32,2,5,'iOS','Gold','More. In all senses. iPhone 6 is not simply bigger. It is better in all respects. Most , but much thinner . More powerful , but extremely economical. Its smooth metal surface smoothly into the glass of the new HD- the Retina display , forming a solid , finished design. Its hardware works perfectly with the software. This new generation of iPhone , improved throughout .','Apple A9','Apple'),(13,'Apple Macbook Air 11\'','macbookair.jpg',35099.00,'MJV8923','LAPTOPS',1,'325 x 227 x 3~17 mm',1350,128,6,11,'OSx Yosemite','Aluminium','Sure , MacBook Air incredibly thin and light . But Apple also made aÃÂsure that it was a powerful , productive , reliable and easy to use . In addition , MacBook Air can operate without recharging for a whole day . This is the main difference between a thin and light laptop , and the laptop , which has a lot more advantages','Intel Core i5 (1.4 GHz)','Apple');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-11 23:43:07
