-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2024 at 04:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlthanhvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `thanhvien`
--

CREATE TABLE `thanhvien` (
  `MaTV` int(10) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `Khoa` varchar(100) DEFAULT NULL,
  `Nganh` varchar(100) DEFAULT NULL,
  `Email` varchar(25) DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thanhvien`
--

INSERT INTO `thanhvien` (`MaTV`, `Password`, `HoTen`, `Khoa`, `Nganh`, `Email`, `SDT`) VALUES
(1120150184, '12345', 'Trần Thị Nữ', 'GDTH', 'GDTH', 'tranthinu@gmail.com', '1111111111'),
(1121530087, '12345', 'Trần Thiếu Nam', 'TLH', 'QLGD', 'tranthieunam@gmail.com', '1111111112'),
(1123330257, '12345', 'Ngô Tuyết Nhi', 'QTKD', 'QTKD', 'ngotuyetnhi@gmail.com', '1111111113'),
(2147483647, '12345', 'Nguyễn Văn Nam', 'CNTT', 'HTTT', 'nguyenvannam@gmail.com', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `thietbi`
--

CREATE TABLE `thietbi` (
  `MaTB` int(10) NOT NULL,
  `TenTB` varchar(100) NOT NULL,
  `MoTaTB` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thietbi`
--

INSERT INTO `thietbi` (`MaTB`, `TenTB`, `MoTaTB`) VALUES
(1000001, 'Micro', 'Micro không dây MS2023'),
(1000002, 'Micro', 'Micro không dây MS2024'),
(1000003, 'Bảng điện tử', 'Bản điện tử trình chiếu');

-- --------------------------------------------------------

--
-- Table structure for table `thongtinsd`
--

CREATE TABLE `thongtinsd` (
  `MaTT` int(10) NOT NULL,
  `MaTV` int(10) NOT NULL,
  `MaTB` int(10) DEFAULT NULL,
  `TGDatcho` datetime DEFAULT NULL,
  `TGVao` datetime DEFAULT NULL,
  `TGMuon` datetime DEFAULT NULL,
  `TGTra` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thongtinsd`
--

INSERT INTO `thongtinsd` (`MaTT`, `MaTV`, `MaTB`, `TGDatcho`, `TGVao`, `TGMuon`, `TGTra`) VALUES
(1, 1120150184, NULL, '2024-01-01 21:57:51', '2024-01-05 09:00:00', NULL, NULL),
(2, 1123330257, 1000001, NULL, NULL, '2024-02-12 10:00:32', '2024-02-12 14:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `xuly`
--

CREATE TABLE `xuly` (
  `MaXL` int(10) NOT NULL,
  `MaTV` int(10) NOT NULL,
  `HinhThucXL` varchar(250) DEFAULT NULL,
  `SoTien` int(100) DEFAULT NULL,
  `NgayXL` datetime DEFAULT NULL,
  `TrangThaiXL` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `xuly`
--

INSERT INTO `xuly` (`MaXL`, `MaTV`, `HinhThucXL`, `SoTien`, `NgayXL`, `TrangThaiXL`) VALUES
(1, 1121530087, 'Khóa thẻ 1 tháng', NULL, '2023-09-12 08:00:00', 0),
(2, 2147483647, 'Khóa thẻ 2 tháng', NULL, '2023-09-12 08:00:00', 0),
(3, 1123330257, 'Bồi thường mất tài sản', 300000, '2023-09-12 08:00:00', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `thanhvien`
--
ALTER TABLE `thanhvien`
  ADD PRIMARY KEY (`MaTV`);

--
-- Indexes for table `thietbi`
--
ALTER TABLE `thietbi`
  ADD PRIMARY KEY (`MaTB`);

--
-- Indexes for table `thongtinsd`
--
ALTER TABLE `thongtinsd`
  ADD PRIMARY KEY (`MaTT`),
  ADD KEY `MaTV` (`MaTV`,`MaTB`),
  ADD KEY `MaTB` (`MaTB`);

--
-- Indexes for table `xuly`
--
ALTER TABLE `xuly`
  ADD PRIMARY KEY (`MaXL`),
  ADD KEY `MaTV` (`MaTV`),
  ADD KEY `MaTV_2` (`MaTV`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `thongtinsd`
--
ALTER TABLE `thongtinsd`
  ADD CONSTRAINT `thongtinsd_ibfk_1` FOREIGN KEY (`MaTV`) REFERENCES `thanhvien` (`MaTV`),
  ADD CONSTRAINT `thongtinsd_ibfk_2` FOREIGN KEY (`MaTB`) REFERENCES `thietbi` (`MaTB`);

--
-- Constraints for table `xuly`
--
ALTER TABLE `xuly`
  ADD CONSTRAINT `xuly_ibfk_1` FOREIGN KEY (`MaTV`) REFERENCES `thanhvien` (`MaTV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
