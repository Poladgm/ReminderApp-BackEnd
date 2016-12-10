-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2016 at 07:01 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `collaboration`
--

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `eventId` int(11) NOT NULL AUTO_INCREMENT,
  `deadLine` varchar(255) DEFAULT NULL,
  `description` longtext,
  `eventCreatedDate` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eventId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventId`, `deadLine`, `description`, `eventCreatedDate`, `title`, `userId`) VALUES
(1, '30/11/16', 'Hello this is ismail', 'Fri Dec 09 22:45:12 IST 2016', 'Prepare Coffee', 'ismail@gmail.com'),
(2, '3/11/16', 'prepare Tea for breakfast', 'Thu Dec 08 11:52:09 IST 2016', 'Prepare Tea', 'ismail@gmail.com'),
(3, '', 'hello how are you', 'Thu Dec 08 22:46:24 IST 2016', 'Hello World', 'ismail@gmail.com'),
(4, '', 'Pleasure mornings', 'Thu Dec 08 22:49:16 IST 2016', 'make some cooldrinks', 'ismail@gmail.com'),
(6, '', 'Im fine ismail', 'Thu Dec 08 23:17:17 IST 2016', 'Hello Ajmal', 'ajmal@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `fName` varchar(255) DEFAULT NULL,
  `lName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneNo` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `city`, `emailId`, `fName`, `lName`, `password`, `phoneNo`, `role`) VALUES
(1, 'Virudhunagar', 'ismail@gmail.com', 'Mohammed', 'Ismail', '12345', '123456789', 'USER'),
(2, 'Virudhunagar', 'ajmal@gmail.com', 'Mohammed', 'Ajmal', '54321', '08124794942', 'USER');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
