-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2023 at 05:48 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbl4`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Iduser` int(11) NOT NULL,
  `Password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `choose_many`
--

CREATE TABLE `choose_many` (
  `idQuizz` int(11) NOT NULL,
  `answer` varchar(45) DEFAULT NULL,
  `isRight` tinyint(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `choose_one`
--

CREATE TABLE `choose_one` (
  `idquizz` int(11) NOT NULL,
  `right_answer` varchar(45) DEFAULT NULL,
  `wrong_answer1` varchar(45) DEFAULT NULL,
  `wrong_answer2` varchar(45) DEFAULT NULL,
  `wrong_answer3` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `normal_statistic`
--

CREATE TABLE `normal_statistic` (
  `iduser` int(11) NOT NULL,
  `GamePlayed` int(11) DEFAULT NULL,
  `GameWon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `quizz`
--

CREATE TABLE `quizz` (
  `Idquizz` int(11) NOT NULL,
  `quizz_info` varchar(45) DEFAULT NULL,
  `picture` varbinary(255) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `difficulties` int(1) DEFAULT NULL,
  `timeAnswered` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rank_statistc`
--

CREATE TABLE `rank_statistc` (
  `Iduser` int(11) NOT NULL,
  `Rank` varchar(45) DEFAULT NULL,
  `Point` int(11) DEFAULT NULL,
  `GamePlayed` int(11) DEFAULT NULL,
  `GameWon` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `Gender` tinyint(4) DEFAULT NULL,
  `DateCreated` date DEFAULT NULL,
  `Status` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `writing`
--

CREATE TABLE `writing` (
  `idQuizz` int(11) NOT NULL,
  `right_answer1` varchar(45) DEFAULT NULL,
  `right_answer2` varchar(45) DEFAULT NULL,
  `right_answer3` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Iduser`);

--
-- Indexes for table `choose_many`
--
ALTER TABLE `choose_many`
  ADD KEY `idquizz_index` (`idQuizz`);

--
-- Indexes for table `choose_one`
--
ALTER TABLE `choose_one`
  ADD PRIMARY KEY (`idquizz`);

--
-- Indexes for table `normal_statistic`
--
ALTER TABLE `normal_statistic`
  ADD PRIMARY KEY (`iduser`);

--
-- Indexes for table `quizz`
--
ALTER TABLE `quizz`
  ADD PRIMARY KEY (`Idquizz`);

--
-- Indexes for table `rank_statistc`
--
ALTER TABLE `rank_statistc`
  ADD PRIMARY KEY (`Iduser`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- Indexes for table `writing`
--
ALTER TABLE `writing`
  ADD PRIMARY KEY (`idQuizz`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_user1` FOREIGN KEY (`Iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `quizz`
--
ALTER TABLE `quizz`
  ADD CONSTRAINT `fk_quizz1` FOREIGN KEY (`Idquizz`) REFERENCES `choose_one` (`idquizz`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_quizz2` FOREIGN KEY (`Idquizz`) REFERENCES `writing` (`idQuizz`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_quizz3` FOREIGN KEY (`Idquizz`) REFERENCES `choose_many` (`idQuizz`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user2` FOREIGN KEY (`iduser`) REFERENCES `normal_statistic` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user3` FOREIGN KEY (`iduser`) REFERENCES `rank_statistc` (`Iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
