-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2020 at 01:15 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_cr7_guntupalli`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `addressID` int(10) UNSIGNED NOT NULL,
  `street` varchar(20) DEFAULT NULL,
  `zip` int(6) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`addressID`, `street`, `zip`, `city`, `country`) VALUES
(1, 'Maderstrasse 1', 1040, 'Vienna', 'Austria'),
(2, 'Bigbowlstrasse', 1020, 'Vienna', 'Austria'),
(3, 'Street 3', 42580, 'Vienna', 'Austria'),
(4, 'Street 4', 52580, 'Vienna', 'Austria'),
(5, 'Street 5', 62580, 'Vienna', 'Austria'),
(6, 'Street 6', 72580, 'Vienna', 'Austria'),
(7, 'Street 7', 82580, 'Vienna', 'Austria'),
(8, 'Street 8', 92580, 'Vienna', 'Austria'),
(9, 'Karlsplatz', 1080, 'Vienna', 'Austria'),
(10, 'Street 10', 42580, 'Vienna', 'Austria'),
(11, 'Street 11', 52580, 'Vienna', 'Austria'),
(12, 'Street 12', 62580, 'Vienna', 'Austria'),
(13, 'Street 13', 72580, 'Vienna', 'Austria'),
(14, 'Street 14', 82580, 'Vienna', 'Austria'),
(15, 'Street 15', 92580, 'Vienna', 'Austria'),
(16, 'Street 16', 42580, 'Vienna', 'Austria'),
(17, 'Street 17', 52580, 'Vienna', 'Austria'),
(18, 'Street 18', 62580, 'Vienna', 'Austria'),
(19, 'Street 19', 72580, 'Vienna', 'Austria'),
(20, 'Street 20', 82580, 'Vienna', 'Austria'),
(21, 'Street 21', 92580, 'Vienna', 'Austria');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `classID` int(6) UNSIGNED NOT NULL,
  `classTitle` varchar(30) DEFAULT NULL,
  `classDescription` varchar(800) DEFAULT NULL,
  `fkSchoolID` int(3) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`classID`, `classTitle`, `classDescription`, `fkSchoolID`) VALUES
(1, 'JAVA', 'Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.', 1),
(2, 'Construction Management', 'Construction management (CM) is a professional service that uses specialized, project management techniques to oversee the planning, design, and construction of a project, from its beginning to its end', 1),
(3, 'PHP', 'PHP is a general-purpose scripting language that is especially suited to web development. It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1994; the PHP reference implementation is now produced by The PHP Group. PHP originally stood for Personal Home Page, but it now stands for the recursive initialism PHP: Hypertext Preprocessor', 1),
(4, 'AutoCAD', 'AutoCAD is a commercial computer-aided design (CAD) and drafting software application. Developed and marketed by Autodesk', 1);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `contactID` int(10) UNSIGNED NOT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `emailID` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`contactID`, `phoneNumber`, `emailID`) VALUES
(1, '+436641826474', 'sinduri.g@gmail.com'),
(2, '+436643366474', 'john.doe@gmail.com'),
(3, '+916641826474', 'bruce.banner@gmail.com'),
(4, '+917702171177', 'captaing@gmail.com'),
(5, '+919912453377', 'irong@gmail.com'),
(6, '+919908874594', 'sin@gmail.com'),
(7, '+43664530194', 'sind@gmail.com'),
(8, '+436641826844', 'sing1@gmail.com'),
(9, '+656641826474', 'sing2@gmail.com'),
(10, '+916641826474', 'sing3@gmail.com'),
(11, '+156641826474', 'widow@gmail.com'),
(12, '+166643366474', 'john.doe219@gmail.com'),
(13, '+176641826474', 'john.doe20@gmail.com'),
(14, '187702171177', 'john.doe221@gmail.com'),
(15, '+199912453377', 'john.doe222@gmail.com'),
(16, '+156641826477', 'thor@gmail.com'),
(17, '+166643366473', 'odinson@gmail.com'),
(18, '+176641826494', 'panther@gmail.com'),
(19, '187702171177', 'fladeboe@gmail.com'),
(20, '+199912453377', 'hella@gmail.com'),
(21, '187702171456', 'minerva@gmail.com'),
(22, '+19991245289', 'ahalya@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `mapclassstudent`
--

CREATE TABLE `mapclassstudent` (
  `mapID` int(10) UNSIGNED NOT NULL,
  `fkStudentID` int(10) UNSIGNED DEFAULT NULL,
  `fkClassMapID` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mapclassstudent`
--

INSERT INTO `mapclassstudent` (`mapID`, `fkStudentID`, `fkClassMapID`) VALUES
(1, 1, 1),
(2, 1, 8),
(3, 1, 9),
(4, 2, 9),
(5, 2, 5),
(6, 3, 12),
(7, 3, 14),
(8, 3, 2),
(9, 3, 3),
(10, 4, 4),
(11, 5, 6),
(12, 5, 7),
(13, 5, 9),
(14, 6, 10),
(15, 6, 11),
(16, 7, 12),
(17, 7, 13),
(18, 7, 14),
(19, 8, 1),
(20, 8, 8),
(21, 8, 9),
(22, 9, 9),
(23, 9, 5),
(24, 10, 12),
(25, 10, 14),
(26, 10, 2),
(27, 10, 3),
(28, 11, 4),
(29, 12, 6),
(30, 12, 7),
(31, 12, 9),
(32, 13, 10),
(33, 13, 11),
(34, 14, 12),
(35, 14, 13),
(36, 14, 14);

-- --------------------------------------------------------

--
-- Table structure for table `mapclassteacher`
--

CREATE TABLE `mapclassteacher` (
  `mapID` int(10) UNSIGNED NOT NULL,
  `fkTeacherID` int(10) UNSIGNED DEFAULT NULL,
  `fkClassMapID` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mapclassteacher`
--

INSERT INTO `mapclassteacher` (`mapID`, `fkTeacherID`, `fkClassMapID`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 8),
(4, 6, 3),
(5, 6, 4),
(6, 3, 5),
(7, 3, 6),
(8, 4, 7),
(9, 5, 8),
(10, 5, 9),
(11, 3, 10),
(12, 4, 11),
(13, 2, 12),
(14, 3, 13),
(15, 4, 14);

-- --------------------------------------------------------

--
-- Table structure for table `mapclassyear`
--

CREATE TABLE `mapclassyear` (
  `mapID` int(10) UNSIGNED NOT NULL,
  `classYear` int(4) DEFAULT NULL,
  `fkClassID` int(6) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mapclassyear`
--

INSERT INTO `mapclassyear` (`mapID`, `classYear`, `fkClassID`) VALUES
(1, 2016, 1),
(2, 2017, 1),
(3, 2018, 1),
(4, 2019, 1),
(5, 2018, 2),
(6, 2019, 2),
(7, 2018, 3),
(8, 2016, 4),
(9, 2017, 4),
(10, 2017, 3),
(11, 2019, 3),
(12, 2016, 3),
(13, 2016, 2),
(14, 2017, 2);

-- --------------------------------------------------------

--
-- Table structure for table `school`
--

CREATE TABLE `school` (
  `schoolID` int(3) UNSIGNED NOT NULL,
  `schoolName` varchar(30) DEFAULT NULL,
  `fkAddressID` int(10) UNSIGNED DEFAULT NULL,
  `fkContactID` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `school`
--

INSERT INTO `school` (`schoolID`, `schoolName`, `fkAddressID`, `fkContactID`) VALUES
(1, 'Course Factory', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` int(10) UNSIGNED NOT NULL,
  `studentFirstName` varchar(30) DEFAULT NULL,
  `studentLastName` varchar(30) DEFAULT NULL,
  `fkContactID` int(10) UNSIGNED DEFAULT NULL,
  `fkAddressID` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `studentFirstName`, `studentLastName`, `fkContactID`, `fkAddressID`) VALUES
(1, 'Minerva', 'Fladeboe', 8, 8),
(2, 'Ahalya', 'Guntupalli', 9, 9),
(3, 'Hella', 'Kancharla', 10, 10),
(4, 'Hemu', 'Rallapalli', 11, 11),
(5, 'Rani', 'Princess', 12, 12),
(6, 'Subbu', 'Shimmer', 13, 13),
(7, 'Mahesh', 'Smith', 14, 14),
(8, 'Luna', 'Prince', 15, 15),
(9, 'Pinkie', 'Pie', 16, 16),
(10, 'Flutter', 'Shy', 17, 17),
(11, 'Twilight', 'Sparkle', 18, 18),
(12, 'Apple', 'Jack', 19, 19),
(13, 'Rainbow', 'Dash', 20, 20),
(14, 'Rarity', 'Stone', 21, 21);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacherID` int(4) UNSIGNED NOT NULL,
  `teacherFirstName` varchar(30) DEFAULT NULL,
  `teacherLastName` varchar(30) DEFAULT NULL,
  `hireDate` datetime DEFAULT NULL,
  `salary` double(10,2) DEFAULT NULL,
  `fkAddressID` int(10) UNSIGNED DEFAULT NULL,
  `fkContactID` int(10) UNSIGNED DEFAULT NULL,
  `statusTeacher` bit(1) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacherID`, `teacherFirstName`, `teacherLastName`, `hireDate`, `salary`, `fkAddressID`, `fkContactID`, `statusTeacher`) VALUES
(1, 'Black', 'Widow', NULL, 30000.00, 2, 2, b'0'),
(2, 'Iron', 'Man', '2016-01-10 00:00:00', 25000.00, 3, 3, b'1'),
(3, 'Bruce', 'Banner', '2016-06-15 00:00:00', 25000.00, 4, 4, b'1'),
(4, 'Thor', 'Odinson', '2017-08-14 00:00:00', 22000.00, 5, 5, b'1'),
(5, 'Captain', 'Marvel', '2017-03-20 00:00:00', 23000.00, 6, 6, b'1'),
(6, 'Loki', 'Odinson', '2018-09-19 00:00:00', 20000.00, 7, 7, b'1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`addressID`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`classID`),
  ADD KEY `fkSchoolID` (`fkSchoolID`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contactID`);

--
-- Indexes for table `mapclassstudent`
--
ALTER TABLE `mapclassstudent`
  ADD PRIMARY KEY (`mapID`),
  ADD KEY `fkStudentID` (`fkStudentID`),
  ADD KEY `fkClassMapID` (`fkClassMapID`);

--
-- Indexes for table `mapclassteacher`
--
ALTER TABLE `mapclassteacher`
  ADD PRIMARY KEY (`mapID`),
  ADD KEY `fkTeacherID` (`fkTeacherID`),
  ADD KEY `fkClassMapID` (`fkClassMapID`);

--
-- Indexes for table `mapclassyear`
--
ALTER TABLE `mapclassyear`
  ADD PRIMARY KEY (`mapID`),
  ADD KEY `fkClassID` (`fkClassID`);

--
-- Indexes for table `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`schoolID`),
  ADD KEY `fkAddressID` (`fkAddressID`),
  ADD KEY `fkContactID` (`fkContactID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`),
  ADD KEY `fkContactID` (`fkContactID`),
  ADD KEY `fkAddressID` (`fkAddressID`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacherID`),
  ADD KEY `fkAddressID` (`fkAddressID`),
  ADD KEY `fkContactID` (`fkContactID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `addressID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `classID` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `contactID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `mapclassstudent`
--
ALTER TABLE `mapclassstudent`
  MODIFY `mapID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `mapclassteacher`
--
ALTER TABLE `mapclassteacher`
  MODIFY `mapID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `mapclassyear`
--
ALTER TABLE `mapclassyear`
  MODIFY `mapID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `school`
--
ALTER TABLE `school`
  MODIFY `schoolID` int(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `studentID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacherID` int(4) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`fkSchoolID`) REFERENCES `school` (`schoolID`);

--
-- Constraints for table `mapclassstudent`
--
ALTER TABLE `mapclassstudent`
  ADD CONSTRAINT `mapclassstudent_ibfk_1` FOREIGN KEY (`fkStudentID`) REFERENCES `student` (`studentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mapclassstudent_ibfk_2` FOREIGN KEY (`fkClassMapID`) REFERENCES `mapclassyear` (`mapID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mapclassteacher`
--
ALTER TABLE `mapclassteacher`
  ADD CONSTRAINT `mapclassteacher_ibfk_1` FOREIGN KEY (`fkTeacherID`) REFERENCES `teacher` (`teacherID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mapclassteacher_ibfk_2` FOREIGN KEY (`fkClassMapID`) REFERENCES `mapclassyear` (`mapID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mapclassyear`
--
ALTER TABLE `mapclassyear`
  ADD CONSTRAINT `mapclassyear_ibfk_1` FOREIGN KEY (`fkClassID`) REFERENCES `class` (`classID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `school`
--
ALTER TABLE `school`
  ADD CONSTRAINT `school_ibfk_1` FOREIGN KEY (`fkAddressID`) REFERENCES `address` (`addressID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `school_ibfk_2` FOREIGN KEY (`fkContactID`) REFERENCES `contact` (`contactID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`fkContactID`) REFERENCES `contact` (`contactID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`fkAddressID`) REFERENCES `address` (`addressID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`fkAddressID`) REFERENCES `address` (`addressID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`fkContactID`) REFERENCES `contact` (`contactID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
