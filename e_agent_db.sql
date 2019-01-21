-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2019 at 05:05 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_agent_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `phone_numbers`
--

CREATE TABLE `phone_numbers` (
  `ADHAAR_NUMBER` varchar(12) NOT NULL,
  `MOBILE_NUMBER` varchar(11) NOT NULL,
  `LANDLINE_NUMBER` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phone_numbers`
--

INSERT INTO `phone_numbers` (`ADHAAR_NUMBER`, `MOBILE_NUMBER`, `LANDLINE_NUMBER`) VALUES
('123456789147', '9004843609', '111111111'),
('551416274321', '9167438404', '1234567'),
('pravleensing', '9004866055', '24567654');

-- --------------------------------------------------------

--
-- Table structure for table `properties`
--

CREATE TABLE `properties` (
  `address` varchar(200) NOT NULL,
  `imglink` varchar(50) NOT NULL,
  `price` varchar(40) NOT NULL,
  `area` varchar(20) NOT NULL,
  `plot_owner` varchar(30) NOT NULL,
  `prop_type` varchar(10) NOT NULL,
  `bedrooms` varchar(10) NOT NULL,
  `hall` varchar(10) NOT NULL,
  `extra_rooms` varchar(30) NOT NULL DEFAULT '-',
  `since` year(4) NOT NULL,
  `booking` varchar(30) NOT NULL,
  `near_by` varchar(200) NOT NULL,
  `rating` varchar(40) NOT NULL,
  `prop_for` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `properties`
--

INSERT INTO `properties` (`address`, `imglink`, `price`, `area`, `plot_owner`, `prop_type`, `bedrooms`, `hall`, `extra_rooms`, `since`, `booking`, `near_by`, `rating`, `prop_for`) VALUES
('Ferozeshah Road, New Delhi ', '../images/flate1.jpg', '12,418 /sq ft', '5000 sq ft', 'Mr. Prasanna Acharya', 'flat', '1', '200 sqf', '1 balcony', 2005, 'booked', '', '../images/star-rating3.png', 'sale'),
('7/293, Sulthanpet, Sulur Taluk, Coimbatore 641669', '../images/flate10.jpg', '990,992 /sq ft', '900 sq ft', 'Mr. Arun Subramanium', 'flat', '2', '400 sqf', '1 balcony', 2000, 'not', 'market, court, government office, bus stand, railway station, hospital', '../images/star-rating5.png', 'rental'),
('10 North South Road, J.V.P.D. Scheme, Juhu, Mumbai 400049', '../images/flate11.jpg', '1000 / sq ft', '9000Sq Ft', 'Dr. Sunita Agarwal', 'flat', '2', '1000 sqf', '2 balcony', 2009, 'not', 'beach, shopping mall, bus stop, taxi stand, hospital', '../images/star-rating5.png', 'rental'),
('Flat No. 502, Swarna Jayanti Sadan Deluxe,Dr. B.D. Marg, New Delhi. 110001', '../images/flate12.jpg', '192,454 /sq ft', '800 sq ft', 'Dr. Soham Agarwal', 'flat', '2', '200 sqf', 'workarea', 2014, 'not', 'hospital, garden, school, taxi stand, grocery shop', '../images/star-rating3.png', 'sale'),
('39, Mahatma Gandhi Road, Haridevpur, Kolkata - 700082', '../images/flate13.png', '100000 / sq ft', '1000 sq ft', 'Mr. Amarjeet Singh', 'flat', '2', '300 sqf', 'work area', 2015, 'booked', 'school, dairy, theater, market', '../images/star-rating3.png', 'rental'),
('401, Brahmaputra Apartments, Dr. B.D. Marg, New Delhi. 110001', '../images/flate14.jpg', '89,078 /sp ft', '577 sq ft', 'Mr. Ashok Siddharth', 'flat', '3', '200 sqf', 'work area', 2003, 'not', 'temple, market,bus stand, taxi stand, hospital, metro station', '../images/star-rating3.png', 'sale'),
('State Committee Office,CPI(M), Melarmath, Agartala, Tripura 799001', '../images/flate15.jpg', '60,992 /sq ft', '2000 sq ft', 'Mr. Dharma Das', 'flat', '3', '800 sqf', 'workarea', 2011, 'not', 'bus stop, richsaw stand, water reservoirs, muncipal offices,police station', '../images/star-rating4.png', 'sale'),
('Lodhi Estate, New Delhi 201301', '../images/flate16.jpg', '24,185 /sq ft', '1000 sq ft', 'Mr. M.J. Akbar', 'flat', '1', '500 sqf', '-', 2001, 'booked', 'Shoping mall, Resturants, Government office, Railway station', '../images/star-rating4.png', 'sale'),
('647, \'Savindhan\' Gandhi Nagar, Bandra (East),Mumbai 400051', '../images/flate17.jpg', '196,992 /sq ft', '350 sq ft', 'Mr. Raj Babbar', 'flat', '1', '190 sqf', '-', 2003, 'not', 'market, railway station, office, taxi stand, theater, hospital', '../images/star-rating3.png', 'sale'),
('39, Mahatma Gandhi Road, P.O, Haridevpur, Kolkata - 700082', '../images/flate18.jpg', '40000 / sq ft', '700 sq ft', 'Mr. Ripun Bora', 'flat', '1', '200 sqf', '1 balcony', 2007, 'not', 'garden, grocery shop, college, clinic, taxi stand', '../images/star-rating4.png', 'sale'),
('Swarna Jayanti Sadan Deluxe, Dr. B.D. Marg, New Delhi 110001', '../images/flate19.jpg', '13,185 /sq ft', '1000 sq ft', 'Mr.Abdul Wahib', 'flat', '1', '300 sqf', '-', 2008, 'not', 'School,Hospital, Swiming pool,theater', '../images/star-rating3.png', 'sale'),
('11, Safdarjung Road, New Delhi ', '../images/flate2.jpg', '20000 / sq ft', '900Sq Ft', 'Mr.Javed Khan', 'flat', '1', '200 sqf', 'work area', 2002, 'not', 'clinic, theatre, school, college,metro station, taxi stand', '../images/star-rating3.png', 'sale'),
('Yashodhan, 212/51, Rambaug Colony,Navi-Peth,Pune 411030', '../images/flate20.jpg', '412,418 /sq ft', '700 sq ft', 'Mrs. Vandana Chavan', 'flat', '1', '200 sqf', 'work area', 2017, 'not', 'school, market, dairy, clinic, bus stand,temple', '../images/star-rating4.png', 'sale'),
('Flat No. 302, Brahmaputra Apartments Dr. B. D. Marg, New Delhi- 110001. ', '../images/flate21.jpg', '500,992 /sq ft', '900 sq ft', 'Ms. Anjali Kishore', 'flat', '1', '400 sqf', '1 balcony', 2000, 'not', 'industrial area, police staion, railway station, richshaw stand, clinic', '../images/star-rating3.png', 'sale'),
('Peevees Mirage, Nilambur P.O., Malappuram District, Kerala. 679329', '../images/flate3.jpg', '56,992 /sq ft', '760 sq ft', 'Mrs. Ananya Nair', 'flat', '1', '400 sqf', '1 balcony', 2004, 'not', 'bus stop, market, rickshaw stand, government office', '../images/star-rating3.png', 'sale'),
('Ellora Enclave, Dayal Bagh, Thana New Agra, Distt. Agra, Uttar Pradesh. 282005', '../images/flate4.jpg', '4300 / sp ft', '800 sq ft', 'State Government', 'flat', '1', '300 sqf', '-', 1980, 'not', 'hospital, industries, school, grocery shops', '../images/star-rating4.png', 'sale'),
('Ram nagar, sevagram road, mumbai', '../images/flate5.jpg', '8000 / sp ft', '600 Sq Ft', 'State Government', 'flat', '1', '300 sqf', '-', 1996, 'not', 'market, temple, school,court', '../images/star-rating4.png', 'sale'),
('151- Janta Kuteer, Dharmshala Road, Hardoi, U.P', '../images/flate6.jpg', '10000 / sq ft', '900 Sq Ft', 'Ms. Crystal Anderson', 'flat', '1', '200 sqf', '1 balcony', 2015, 'not', 'railway station, government office, college, shopping mall,resturansts', '../images/star-rating4.png', 'sale'),
('Palam Vihar, Gurgaon, Haryana 122015', '../images/flate7.jpg', '10,418 /sq ft', '600 sq ft', 'Dr. Anil Agarwal', 'flat', '2', '300 sqf', '-', 2010, 'not', 'bus stop, hospital, grocery shops, school', '../images/star-rating4.png', 'rental'),
('Suite No.14 & 207, V.P. House, Rafi Marg, New Delhi. ', '../images/flate8.jpg', '40000 / sq ft', '900 sq ft', 'Mrs. Jaya Chawan', 'flat', '1', '200 sqf', 'workarea', 2005, 'not', 'market, hospital, bus stop, richshaw stand, school, college, masjid', '../images/star-rating4.png', 'sale'),
('AB-97, Shahjahan Road, New Delhi ', '../images/flate9.jpg', '280,000 /sq ft', '1000 sq ft', 'Mr. K.R. Raman', 'flat', '1', '400 sqf', '-', 2012, 'not', 'market, school, college, garden, hospital', '../images/star-rating5.png', 'sale'),
('Mevalurkuppam, Chennai', '../images/land1.jpg', '1000K', '1800 sq ft', 'State Goverment', 'plot', '-', '0', '-', 2000, 'booked', 'bus stop, hospital, grocery shops, school', '../images/star-rating4.png', 'sale'),
('Avalahalli Off Sarjapur Road, Bangalore', '../images/land2.jpg', '1000K', '1800 sq ft', 'Mr Ram Triphati', 'plot', '-', '0', '-', 2001, 'booked', 'bus stop, hospital, grocery shops, school', '../images/star-rating3.png', 'sale'),
('Village Bhunder, P.O. Sardulgarh, District Mansa (Punjab). 151507', '../images/land3.jpg', '70000 / sq ft', '5000Sq Ft', 'Mr. Amarjeet Singh', 'plot', '-', '0', '-', 2018, 'booked', 'water cannal, government office, school,police station, clinic, market', '../images/star-rating5.png', 'sale'),
('H. No. 16-3-302, Shanthi Nagar, Subash Road, Warangal 506002', '../images/land4.jpg', '20000 / sq ft', '500 sq ft', 'Mr. Bada Rajul', 'plot', '-', '-', '-', 2018, 'not', 'industrial area, grocery shop, transport stand', '../images/star-rating3.png', 'sale'),
('Sector 8-A, Chandigarh 160009', '../images/land5.jpg', '500,992 /sq ft', '5000Sq Ft', 'Mr. Pratap singh Bajwa', 'plot', '-', '1000 sqf', '-', 2015, 'not', 'muncilpal office, police station, market, school, bus station', '../images/star-rating5.png', 'sale'),
('102-104, South Avenue, New Delhi 110011', '../images/land6.jpg', '276,000 /sq ft', '3600 sq ft', 'Mrs. Rita Banerjee', 'plot', '-', '1000 sqf', '-', 2010, 'not', 'railway station, bus stand, taxi stand, clinic, market, government office', '../images/star-rating4.png', 'sale'),
('SOPAN, Gulmohar Park, New Delhi ', '../images/land7.jpg', '500,992 /sq ft', '2000 sq ft', 'Mrs.Nilima Sharma', 'plot', '-', '-', '-', 2017, 'not', 'farms, water cannal, clinic, residential area, police staion', '../images/star-rating3.png', 'sale'),
('Bungalow No. 2, Panama Chowk, Gandhi Nagar, UP. 180004', '../images/luxury1.jpg', '8900,078 /sp ft', '5000Sq Ft', 'Mr. Jharna Das', 'Bungalow', '4', '2000 sqf', 'garden & workarea', 2000, 'booked', 'bus stop, taxi stand, police stand, court, college, shopping mall', '../images/star-rating4.png', 'sale'),
('Bunglow No.9, Teen Murti Lane, New Delhi 110011', '../images/luxury2.jpg', '83,978 /sp ft', '9070 sq ft', 'Mr. Anad Sharma', 'Bungalow', '3', '2000 sqf', '2 balcony', 2011, 'booked', 'Hospital, Bus stop, taxi stand, markets', '../images/star-rating4.png', 'sale'),
('Chanchala Niwas, Ward No-16, PO-Bargarh, Dist.-Bargarh, Odisha', '../images/luxury3.jpg', '70,077 / sq ft', '4750 sq ft', 'Industrial Co-operation', 'Bungalow', '3', '1088 sqf', 'work area', 1999, 'not', 'taxi stand, bank, market, hospital', '../images/star-rating4.png', 'sale'),
('271/182, Ketti Village and Post, Nilgiris District, Tamil Nadu- 643215', '../images/luxury4.jpg', '76,992 /sq ft', '7000 sq ft', 'Mr. K.R. Arjunan', 'Bungalow', '4', '2000 sqf', 'garden & workarea', 1998, 'not', 'bus stop, market, church, temple, clinic', '../images/star-rating3.png', 'rental'),
('Bungalow No. 18, Ashoka Road, New Delhi. ', '../images/luxury5.jpg', '276,000 /sq ft', '3600 sq ft', 'Ms. Rupa Athawale', 'Bungalow', '2', '1000 sqf', 'garden & workarea', 2007, 'not', 'taxi stand, grocery shops, police station, garden, bus stop', '../images/star-rating4.png', 'sale'),
('602, Swarna Jayanti Sadan Deluxe, Dr. B.D. Marg, New Delhi 110001', '../images/luxury6.jpg', '20000 / sq ft', '4000 sq ft', 'Mrs. Santha Cheetri', 'Bungalow', '2', '1000 sqf', '1 balcony', 2000, 'booked', 'office, bus stop, taxi stand, metro station, market', '../images/star-rating4.png', 'sale'),
('Videocon House, 5th Floor, 99, Manav Mandir Road, Nepean Sea Road, Mumbai 400006', '../images/luxury7.jpg', '300000 / sq ft', '2500 sq ft', 'Mr. Hasan Ali', 'Bungalow', '3', '1000 sqf', '2 balcony', 1999, 'not', 'railway station, shopping mall, resturant, college,hospital', '../images/star-rating5.png', 'rental');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `ADHAAR_NUMBER` varchar(12) NOT NULL,
  `FIRST_NAME` varchar(30) NOT NULL,
  `MIDDLE_NAME` varchar(30) NOT NULL,
  `LAST_NAME` varchar(30) NOT NULL,
  `GENDER` varchar(6) NOT NULL,
  `DATE_OF_BIRTH` varchar(20) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `user_address` mediumtext NOT NULL,
  `phno` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`ADHAAR_NUMBER`, `FIRST_NAME`, `MIDDLE_NAME`, `LAST_NAME`, `GENDER`, `DATE_OF_BIRTH`, `EMAIL`, `user_address`, `phno`) VALUES
('123456789147', 'Harish', '', 'Unnikrisnan', 'MM', '1-January-2018', 'user2.com', 'Home,dombivli', '9004843609'),
('551416274321', 'Harish', 'Unnikrishnan', 'Carpenter', 'MM', '1-January-2018', 'hten@gmail.com', 'Gandhi nagar , dombivli east', '9167438404'),
('pravleensing', 'Rait', 'Pravleen', 'Singh', 'MM', '1-January-2018', 'User1.com', 'New Brahmand Annex Phase8,G8,Flat No -101,Manpada,Azad nagar,Thane(w)', '9004866055');

-- --------------------------------------------------------

--
-- Table structure for table `user_cart`
--

CREATE TABLE `user_cart` (
  `EMAIL` varchar(100) NOT NULL,
  `IMAGE_LINK` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_cart`
--

INSERT INTO `user_cart` (`EMAIL`, `IMAGE_LINK`) VALUES
('user1.com', '?'),
('user2.com', '?'),
('hten@gmail.com', '?'),
('User1.com', '../images/flate2.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user_login`
--

CREATE TABLE `user_login` (
  `EMAIL` varchar(30) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_login`
--

INSERT INTO `user_login` (`EMAIL`, `PASSWORD`) VALUES
('hten@gmail.com', '333'),
('User1.com', '111'),
('user2.com', '222');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `phone_numbers`
--
ALTER TABLE `phone_numbers`
  ADD PRIMARY KEY (`ADHAAR_NUMBER`);

--
-- Indexes for table `properties`
--
ALTER TABLE `properties`
  ADD PRIMARY KEY (`imglink`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`ADHAAR_NUMBER`);

--
-- Indexes for table `user_login`
--
ALTER TABLE `user_login`
  ADD PRIMARY KEY (`EMAIL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
