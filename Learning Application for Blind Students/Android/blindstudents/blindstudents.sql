-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 01, 2024 at 02:14 PM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `blindstudents`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `sturegister`
--

CREATE TABLE `sturegister` (
  `id` int(50) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `regnum` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `number` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `sturegister`
--

INSERT INTO `sturegister` (`id`, `name`, `regnum`, `address`, `number`, `gender`, `date`, `department`) VALUES
(1, 'joyal', 'jo', 'trichy', '8525885585', 'Male', '15/7/2023', 'b.com');
