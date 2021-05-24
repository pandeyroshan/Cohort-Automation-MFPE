-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: cohort_automation
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_text` longtext NOT NULL,
  `is_text_type` tinyint(1) NOT NULL,
  `is_number_type` tinyint(1) NOT NULL,
  `answered_by_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `is_present` tinyint(1) NOT NULL,
  `timestamp` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,909102,'2021-05-02',1,'2021-05-02 21:47:35.000000'),(5,909141,'2021-05-02',1,'2021-05-02 23:17:11.243660'),(6,909141,'2021-05-03',1,'2021-05-03 07:43:23.067950'),(7,909102,'2021-05-06',1,'2021-05-06 11:06:30.876567'),(8,123,'2021-05-06',1,'2021-05-06 16:09:04.561628');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cohort`
--

DROP TABLE IF EXISTS `cohort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cohort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `start_date` date DEFAULT NULL,
  `total_weeks` int(4) DEFAULT NULL,
  `coach_id` varchar(10) NOT NULL,
  `mentor_id` varchar(10) NOT NULL,
  `sme_id` varchar(10) NOT NULL,
  `trainer_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cohort`
--

LOCK TABLES `cohort` WRITE;
/*!40000 ALTER TABLE `cohort` DISABLE KEYS */;
INSERT INTO `cohort` VALUES (1,'INTADM21AJ021','Advance Java','2021-02-11',12,'909002','909001','909100','909003'),(2,'INTADM21AJ022','Basic Java','2000-02-12',14,'909584','909005','909101','909542');
/*!40000 ALTER TABLE `cohort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learning_path`
--

DROP TABLE IF EXISTS `learning_path`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `learning_path` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_by` varchar(10) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `cohort_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learning_path`
--

LOCK TABLES `learning_path` WRITE;
/*!40000 ALTER TABLE `learning_path` DISABLE KEYS */;
/*!40000 ALTER TABLE `learning_path` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_link` varchar(200) NOT NULL,
  `start_datetime` datetime(6) NOT NULL,
  `end_datetime` datetime(6) NOT NULL,
  `is_cancelled` tinyint(1) NOT NULL,
  `note` longtext NOT NULL,
  `requires_message_alert` tinyint(1) NOT NULL,
  `heading` varchar(200) DEFAULT NULL,
  `cohort` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `notification_text` varchar(500) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `is_seen` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_text` varchar(1000) NOT NULL,
  `is_text_type` tinyint(1) NOT NULL,
  `is_number_type` tinyint(1) NOT NULL,
  `survey_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Employee ID',0,1,9),(2,'Employee Name',1,0,9),(3,'Employee ID',0,1,10),(4,'Employee A/C No',0,1,10);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `survey`
--

DROP TABLE IF EXISTS `survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `survey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `survey_name` varchar(200) NOT NULL,
  `survey_start_timestamp` datetime(6) NOT NULL,
  `survey_end_timestamp` datetime(6) NOT NULL,
  `is_disable` tinyint(1) NOT NULL,
  `total_response` int(11) NOT NULL,
  `created_by_id` int(11) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `cohort` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `survey`
--

LOCK TABLES `survey` WRITE;
/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
INSERT INTO `survey` VALUES (9,'S1','2021-05-05 15:40:00.000000','2021-05-05 15:45:00.000000',0,0,909102,'2021-05-05 15:41:06.040529',NULL),(10,'S2','2021-05-05 16:45:00.000000','2021-05-05 16:50:00.000000',0,0,909102,'2021-05-05 16:43:11.668875',NULL);
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(10000) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `personal_email` varchar(254) NOT NULL,
  `corporate_email` varchar(254) NOT NULL,
  `is_mentor` tinyint(1) NOT NULL,
  `is_SME` tinyint(1) NOT NULL,
  `is_trainer` tinyint(1) NOT NULL,
  `is_coach` tinyint(1) NOT NULL,
  `is_member` tinyint(1) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `last_ip` char(39) DEFAULT NULL,
  `is_first_login` tinyint(1) DEFAULT '1',
  `cohort` varchar(100) DEFAULT NULL,
  `is_admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,999999,'admin','admin','Admin','Admin','admin@gmail.com','admin@gmail.com',0,0,0,0,0,'2021-05-20 12:04:18.067782','3.3.3.3',0,'ZZZZZ',1),(3,909100,'909100','4#2Llf$&','Anil','Gurrala','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',0,1,0,0,0,'2021-05-19 18:21:38.677478',NULL,1,NULL,0),(4,909101,'909101','19$#8L$&','Alex','Goot','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',0,1,0,0,0,NULL,NULL,1,NULL,0),(5,909001,'909001','!*U*@V#z','Jada','Facer','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',1,0,0,0,0,NULL,NULL,1,NULL,0),(6,909002,'909002','#SQ6ENnJ','Sri','Lalitha','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',0,0,0,1,0,NULL,NULL,1,NULL,0),(7,909003,'909003','V$8J2@5t','Anuj','Sharma','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',0,0,1,0,0,NULL,NULL,1,NULL,0),(8,909005,'909005','0U8s*wAb','Gaurav','Saxena','pandeyroshanjuet@gmail.com','pandeyroshanjuet@gmail.com',1,0,0,0,0,NULL,NULL,1,NULL,0),(9,909584,'909584','Ws6A02K#','Sagarika','P.','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',0,0,0,1,0,NULL,NULL,1,NULL,0),(10,909542,'909542','!@b1z0T8','Mahesh','Kumar','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',0,0,1,0,0,NULL,NULL,1,NULL,0),(11,909111,'909111','3wri$4ey','Roshan','Pandey','pandeyroshan556@gmail.com','pandeyroshan556@gmail.com',0,1,0,0,0,NULL,NULL,1,NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-23 20:13:26
