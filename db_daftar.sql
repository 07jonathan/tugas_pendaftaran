-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2022 at 10:36 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_daftar`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `noTelp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `nama`, `npm`, `password`, `noTelp`) VALUES
(1, 'lutfi', '07286', '000', '081');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `npm` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `noTelp` varchar(13) NOT NULL,
  `status` int(11) DEFAULT 0,
  `paket` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nama`, `npm`, `password`, `noTelp`, `status`, `paket`) VALUES
(1, 'Lutfi', '07286', '123', '081', 1, 'INFORMASI'),
(4, 'tes', '1', '1', '1', 0, ''),
(5, 'coba', '123', '1', '081', 1, ''),
(6, 'coba', '111', '1', '1', 0, ''),
(7, 'coba2', '345', '6666', '9', 1, 'INFORMATIKA'),
(8, 'Rahmat', '07289', '234', '123', 1, 'DESAIN'),
(9, 'jonathan', '07282', '123', '456', 0, 'INFORMATIKA'),
(10, 'dzulfan', '07353', '12', '0851', 1, 'INFORMASI'),
(11, 'amar', '12345', '123', '089765', 1, 'ARSITEKTUR'),
(12, 'amar', '09879', '456', '089', 0, 'Informatika');

-- --------------------------------------------------------

--
-- Table structure for table `paketa`
--

CREATE TABLE `paketa` (
  `paket` varchar(20) NOT NULL,
  `jurusan` varchar(20) NOT NULL,
  `harga` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paketa`
--

INSERT INTO `paketa` (`paket`, `jurusan`, `harga`) VALUES
('A', 'INFORMATIKA', '6000000'),
('A', 'INFORMASI', '7000000'),
('A', 'ARSITEKTUR', '5000000'),
('A', 'DESAIN', '55000000');

-- --------------------------------------------------------

--
-- Table structure for table `paketb`
--

CREATE TABLE `paketb` (
  `paket` varchar(20) NOT NULL,
  `jurusan` varchar(20) NOT NULL,
  `harga` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paketb`
--

INSERT INTO `paketb` (`paket`, `jurusan`, `harga`) VALUES
('B', 'INFORMATIKA', '7500000'),
('B', 'INFORMASI', '8500000'),
('B', 'ARSITEKTUR', '6500000'),
('B', 'DESAIN', '700000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `npm` (`npm`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
