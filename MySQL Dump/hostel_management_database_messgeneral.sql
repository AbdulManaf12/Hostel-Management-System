CREATE DATABASE  IF NOT EXISTS `hostel_management_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hostel_management_database`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: hostel_management_database
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messgeneral`
--

DROP TABLE IF EXISTS `messgeneral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messgeneral` (
  `t` int DEFAULT NULL,
  `one_unit` double DEFAULT NULL,
  `morning_unit` int DEFAULT NULL,
  `lunch_unit` int DEFAULT NULL,
  `dinner_unit` int DEFAULT NULL,
  `Mon1` varchar(40) DEFAULT NULL,
  `Mon2` varchar(40) DEFAULT NULL,
  `Mon3` varchar(40) DEFAULT NULL,
  `Tues1` varchar(40) DEFAULT NULL,
  `Tues2` varchar(40) DEFAULT NULL,
  `Tues3` varchar(40) DEFAULT NULL,
  `Wed1` varchar(40) DEFAULT NULL,
  `Wed2` varchar(40) DEFAULT NULL,
  `Wed3` varchar(40) DEFAULT NULL,
  `Thrus1` varchar(40) DEFAULT NULL,
  `Thrus2` varchar(40) DEFAULT NULL,
  `Thrus3` varchar(40) DEFAULT NULL,
  `Fri1` varchar(40) DEFAULT NULL,
  `Fri2` varchar(40) DEFAULT NULL,
  `Fri3` varchar(40) DEFAULT NULL,
  `Sat1` varchar(40) DEFAULT NULL,
  `Sat2` varchar(40) DEFAULT NULL,
  `Sat3` varchar(40) DEFAULT NULL,
  `Sun1` varchar(40) DEFAULT NULL,
  `Sun2` varchar(40) DEFAULT NULL,
  `Sun3` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messgeneral`
--

LOCK TABLES `messgeneral` WRITE;
/*!40000 ALTER TABLE `messgeneral` DISABLE KEYS */;
INSERT INTO `messgeneral` VALUES (34,23,3,3,3,'Dahi','Dal','Murgi','Anda','Sabzi','Kabab','Partha','Potato','Fish','Potato','Sabzi','Sabzi','Halwa Pori','Dal','Meat','Dahi and Dal','Murgi','Biryani','Partha','Brunch','Mugi');
/*!40000 ALTER TABLE `messgeneral` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-22 20:30:43
