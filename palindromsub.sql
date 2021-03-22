CREATE DATABASE  IF NOT EXISTS `palindromic_substring_problem`;
USE `palindromic_substring_problem`;

--
-- Table structure for table `palindromicsubstr`
--

DROP TABLE IF EXISTS `palindromicsubstr`;

CREATE TABLE `palindromicsubstr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `input_str` varchar(1000) DEFAULT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `palindromicsubstr`
--

INSERT INTO `palindromicsubstr` VALUES 
	(1,'babad','bab'),
	(2,'cbba','bb');
