CREATE DATABASE ingkvali_nima;
USE Dresses


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ingkvali_nima`
--



-- --------------------------------------------------------

--
-- Table structure for table `Grad`
--

CREATE TABLE IF NOT EXISTS `Grad` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) CHARACTER SET latin2 COLLATE latin2_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `Grad`
--

INSERT INTO `Grad` (`ID`, `Naziv`) VALUES
(1, 'Krapina'),
(2, 'Krapina'),
(3, 'Zagreb'),
(4, 'test5'),
(5, 'test5'),
(6, 'test5'),
(7, 'test5'),
(8, 'test5'),
(9, 'test5'),
(10, 'test5'),
(11, 'test5'),
(12, 'test5'),
(13, 'test5'),
(14, 'test5'),
(15, 'test5'),
(16, 'test5'),
(17, 'test5'),
(18, 'test5'),
(19, 'test5');

-- --------------------------------------------------------

--
-- Table structure for table `Korisnici`
--

CREATE TABLE IF NOT EXISTS `Korisnici` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(50) CHARACTER SET latin2 COLLATE latin2_croatian_ci DEFAULT NULL,
  `Prezime` varchar(50) CHARACTER SET latin2 COLLATE latin2_croatian_ci DEFAULT NULL,
  `Email` varchar(50) CHARACTER SET latin2 COLLATE latin2_croatian_ci DEFAULT NULL,
  `Broj` varchar(50) CHARACTER SET latin2 COLLATE latin2_croatian_ci DEFAULT NULL,
  `GradID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `GradID` (`GradID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
