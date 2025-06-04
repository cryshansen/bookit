-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 11, 2025 at 03:41 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `advertising`
--

CREATE TABLE `advertising` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `link` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `advertising`
--

INSERT INTO `advertising` (`id`, `title`, `description`, `link`) VALUES
(1, 'Hello World', 'Im testing the connection', 'appoint.html'),
(2, 'Good Afternoon!', 'Im testing the app to get this record', 'booking.html'),
(3, 'Hello World', 'Im testing the connection', 'appoint.html'),
(4, 'Good Afternoon!', 'Im testing the app to get this record', 'booking.html');

-- --------------------------------------------------------

--
-- Table structure for table `appoint`
--

CREATE TABLE `appoint` (
  `appoint_id` int(11) NOT NULL,
  `appoint_date` datetime NOT NULL,
  `appoint_timeslot` varchar(12) NOT NULL,
  `appoint_token` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `appoint`
--

INSERT INTO `appoint` (`appoint_id`, `appoint_date`, `appoint_timeslot`, `appoint_token`) VALUES
(34, '2022-06-30 09:00:00', '9:00', '164312185792646'),
(35, '2022-06-23 16:00:00', '16:00', '417148021509809'),
(36, '2022-06-23 16:00:00', '16:00', '417148021509809'),
(37, '2022-06-23 16:00:00', '16:00', '417148021509809'),
(38, '2022-06-23 16:00:00', '16:00', '417148021509809'),
(39, '2022-05-30 13:00:00', '13:00', '8512005901534216'),
(40, '2022-05-30 13:00:00', '13:00', '380046240679558'),
(41, '2022-05-30 13:00:00', '13:00', '77624750118776'),
(42, '2025-02-28 16:00:00', '16:00', '827204326578592'),
(43, '2025-02-28 16:00:00', '16:00', '222273668637441'),
(44, '2025-02-28 16:00:00', '16:00', '185901669795863'),
(45, '2025-02-28 16:00:00', '16:00', '7501248967637193'),
(46, '2025-02-28 16:00:00', '16:00', '634406429831715'),
(47, '2025-02-28 17:15:00', '17:15', '898623144605368'),
(48, '2025-03-18 10:30:00', '10:30', '856187898928615'),
(49, '2025-07-31 00:00:00', 'undefined', '856115810926928'),
(50, '2025-07-31 16:00:00', '16:00', '576919802927375'),
(51, '2025-02-27 13:00:00', '13:00', '568047024643404'),
(52, '2025-02-27 13:00:00', '13:00', '3842310572717658');

-- --------------------------------------------------------

--
-- Table structure for table `bookitt`
--

CREATE TABLE `bookitt` (
  `book_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `time` varchar(12) NOT NULL,
  `client_id` int(11) NOT NULL,
  `token` varchar(50) NOT NULL,
  `confirm` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bookitt`
--

INSERT INTO `bookitt` (`book_id`, `date`, `time`, `client_id`, `token`, `confirm`) VALUES
(1, '2025-02-28 00:00:00', '16:00', 0, '634406429831715', ''),
(2, '2025-02-28 00:00:00', '16:00', 0, '634406429831715', ''),
(3, '2025-02-28 00:00:00', '16:00', 0, '634406429831715', '');

-- --------------------------------------------------------

--
-- Table structure for table `book_settings`
--

CREATE TABLE `book_settings` (
  `book_settings_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book_settings`
--

INSERT INTO `book_settings` (`book_settings_id`, `start_date`) VALUES
(1, '2025-03-05 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `client` varchar(400) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `email` varchar(300) NOT NULL,
  `client_token` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `amount` decimal(9,2) NOT NULL,
  `response_code` int(11) NOT NULL,
  `response_desc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `firstname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `middle_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(12) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `user_status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `firstname`, `middle_name`, `lastname`, `phone`, `user_email`, `user_status`) VALUES
(1, 'bob', 'bob', 'm', 'bob', '', '', 0),
(2, 'jane', 'jane', 'M', 'Smith', '', '', 0),
(3, 'bob', 'bob', 'm', 'bob', '', '', 0),
(4, 'jane', 'jane', 'M', 'Smith', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_authentication`
--

CREATE TABLE `user_authentication` (
  `user_au_id` int(11) NOT NULL,
  `password` varchar(250) NOT NULL,
  `authentinticate` int(11) NOT NULL COMMENT 'count number for when tries more than three times',
  `2factor_code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advertising`
--
ALTER TABLE `advertising`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `appoint`
--
ALTER TABLE `appoint`
  ADD PRIMARY KEY (`appoint_id`);

--
-- Indexes for table `bookitt`
--
ALTER TABLE `bookitt`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `book_settings`
--
ALTER TABLE `book_settings`
  ADD PRIMARY KEY (`book_settings_id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `order_id` (`order_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_authentication`
--
ALTER TABLE `user_authentication`
  ADD PRIMARY KEY (`user_au_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advertising`
--
ALTER TABLE `advertising`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `appoint`
--
ALTER TABLE `appoint`
  MODIFY `appoint_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `bookitt`
--
ALTER TABLE `bookitt`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `book_settings`
--
ALTER TABLE `book_settings`
  MODIFY `book_settings_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user_authentication`
--
ALTER TABLE `user_authentication`
  MODIFY `user_au_id` int(11) NOT NULL AUTO_INCREMENT;
