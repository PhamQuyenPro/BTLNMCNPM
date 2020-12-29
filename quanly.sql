-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2020 at 05:36 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cnpm`
--

-- --------------------------------------------------------

--
-- Table structure for table `dovat`
--

CREATE TABLE `dovat` (
  `maloai` varchar(5) NOT NULL,
  `tenloai` varchar(16) NOT NULL,
  `donvi` varchar(16) NOT NULL,
  `soluongtoida` int(11) UNSIGNED NOT NULL,
  `trangthai` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dovat`
--

INSERT INTO `dovat` (`maloai`, `tenloai`, `donvi`, `soluongtoida`, `trangthai`) VALUES
('BAN01', 'Bàn', 'Cái', 10, 'Mới 100%'),
('GHB01', 'Ghế băng', 'Cái', 15, 'Mới 100%'),
('GHE01', 'Ghế gỗ', 'Cái', 80, 'Mới 100%'),
('KTD01', 'Khăn trải bàn', 'Cái', 15, 'Mới 100%'),
('KTX01', 'Khăn trải bàn', 'Cái', 20, 'Mới 100%'),
('MCR01', 'Micro', 'Cái', 5, 'Mới 100%'),
('TVI01', 'Tivi', 'Cái', 5, 'Mới 100%'),
('TVI02', 'Tivi', 'Cái', 3, 'Mới 90%');

-- --------------------------------------------------------

--
-- Table structure for table `lsbangiao`
--

CREATE TABLE `lsbangiao` (
  `mabangiao` smallint(5) UNSIGNED NOT NULL,
  `cmnd` int(11) UNSIGNED NOT NULL,
  `tg_bangiao` datetime NOT NULL COMMENT 'ngày thuê',
  `tg_tra` datetime NOT NULL COMMENT 'ngày trả',
  `phi` int(10) UNSIGNED NOT NULL COMMENT 'phí (đồng)',
  `mucdich` text DEFAULT NULL COMMENT 'mục đích'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lsbangiao`
--

INSERT INTO `lsbangiao` (`mabangiao`, `cmnd`, `tg_bangiao`, `tg_tra`, `phi`, `mucdich`) VALUES
(1, 121092000, '2020-12-02 17:16:14', '2020-12-04 17:16:14', 500000, NULL),
(2, 123456789, '2020-12-26 17:16:14', '2020-12-28 17:16:14', 145000, NULL),
(3, 121092000, '2021-01-02 23:39:48', '2021-01-03 23:43:19', 10000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lshoatdong`
--

CREATE TABLE `lshoatdong` (
  `stt` smallint(5) UNSIGNED NOT NULL,
  `tenhd` varchar(64) NOT NULL,
  `tg_batdau` datetime NOT NULL,
  `tg_ketthuc` datetime NOT NULL,
  `mathue` smallint(5) UNSIGNED DEFAULT NULL,
  `mucdich` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lshoatdong`
--

INSERT INTO `lshoatdong` (`stt`, `tenhd`, `tg_batdau`, `tg_ketthuc`, `mathue`, `mucdich`) VALUES
(1, 'Hoạt động 01', '2020-12-31 17:27:54', '2021-01-01 17:27:54', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `tentk` varchar(32) NOT NULL,
  `mk` varchar(32) NOT NULL,
  `cmnd` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`tentk`, `mk`, `cmnd`) VALUES
('hung219', 'bkhn', 121092000);

-- --------------------------------------------------------

--
-- Table structure for table `thongtin_bangiao_thue`
--

CREATE TABLE `thongtin_bangiao_thue` (
  `stt` smallint(5) UNSIGNED NOT NULL,
  `maloai` varchar(5) NOT NULL,
  `soluong` int(11) UNSIGNED NOT NULL,
  `trangthai_truoc` varchar(64) NOT NULL,
  `trangthai_sau` varchar(64) NOT NULL,
  `mabangiao` smallint(5) UNSIGNED DEFAULT NULL,
  `mathue` smallint(5) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thongtin_bangiao_thue`
--

INSERT INTO `thongtin_bangiao_thue` (`stt`, `maloai`, `soluong`, `trangthai_truoc`, `trangthai_sau`, `mabangiao`, `mathue`) VALUES
(1, 'BAN01', 2, 'Mới 100%', 'Mới 100%', 1, NULL),
(2, 'GHE01', 5, 'Mới 100%', 'Mới 100%', 1, NULL),
(3, 'KTD01', 5, 'Mới 100%', 'Mới 100%', 1, NULL),
(4, 'BAN01', 1, 'Mới 100%', 'Mới 100%', 2, NULL),
(5, 'GHE01', 1, 'Mới 100%', 'Mới 100%', 2, NULL),
(7, 'KTX01', 2, 'Mới 100%', 'Mới 100%', 2, NULL),
(9, 'MCR01', 2, 'Mới 100%', 'Mới 100%', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `thue_nhavanhoa`
--

CREATE TABLE `thue_nhavanhoa` (
  `mathue` smallint(5) UNSIGNED NOT NULL,
  `cmnd` int(11) UNSIGNED NOT NULL,
  `phi` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thue_nhavanhoa`
--

INSERT INTO `thue_nhavanhoa` (`mathue`, `cmnd`, `phi`) VALUES
(1, 121092000, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `tt_canhan`
--

CREATE TABLE `tt_canhan` (
  `cmnd` int(11) UNSIGNED NOT NULL,
  `hoten` varchar(32) NOT NULL,
  `ngaysinh` date NOT NULL,
  `gioitinh` enum('Nam','Nữ') NOT NULL,
  `sdt` varchar(16) DEFAULT NULL,
  `diachi` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tt_canhan`
--

INSERT INTO `tt_canhan` (`cmnd`, `hoten`, `ngaysinh`, `gioitinh`, `sdt`, `diachi`) VALUES
(121092000, 'Phan Mạnh Hùng', '2000-12-21', 'Nam', '1231231412', 'Hanoi'),
(123456789, 'Nguyễn Văn A', '1997-11-11', 'Nam', '19312314', 'Hanoi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dovat`
--
ALTER TABLE `dovat`
  ADD PRIMARY KEY (`maloai`);

--
-- Indexes for table `lsbangiao`
--
ALTER TABLE `lsbangiao`
  ADD PRIMARY KEY (`mabangiao`),
  ADD KEY `fkIdx_42` (`cmnd`);

--
-- Indexes for table `lshoatdong`
--
ALTER TABLE `lshoatdong`
  ADD PRIMARY KEY (`stt`),
  ADD KEY `fkIdx_65` (`mathue`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`tentk`),
  ADD KEY `fkIdx_39` (`cmnd`);

--
-- Indexes for table `thongtin_bangiao_thue`
--
ALTER TABLE `thongtin_bangiao_thue`
  ADD PRIMARY KEY (`stt`),
  ADD KEY `fkIdx_49` (`maloai`),
  ADD KEY `fkIdx_81` (`mabangiao`),
  ADD KEY `fkIdx_87` (`mathue`);

--
-- Indexes for table `thue_nhavanhoa`
--
ALTER TABLE `thue_nhavanhoa`
  ADD PRIMARY KEY (`mathue`),
  ADD KEY `fkIdx_62` (`cmnd`);

--
-- Indexes for table `tt_canhan`
--
ALTER TABLE `tt_canhan`
  ADD PRIMARY KEY (`cmnd`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lsbangiao`
--
ALTER TABLE `lsbangiao`
  MODIFY `mabangiao` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `lshoatdong`
--
ALTER TABLE `lshoatdong`
  MODIFY `stt` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `thongtin_bangiao_thue`
--
ALTER TABLE `thongtin_bangiao_thue`
  MODIFY `stt` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `thue_nhavanhoa`
--
ALTER TABLE `thue_nhavanhoa`
  MODIFY `mathue` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `lsbangiao`
--
ALTER TABLE `lsbangiao`
  ADD CONSTRAINT `FK_42` FOREIGN KEY (`cmnd`) REFERENCES `tt_canhan` (`cmnd`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `lshoatdong`
--
ALTER TABLE `lshoatdong`
  ADD CONSTRAINT `FK_65` FOREIGN KEY (`mathue`) REFERENCES `thue_nhavanhoa` (`mathue`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_39` FOREIGN KEY (`cmnd`) REFERENCES `tt_canhan` (`cmnd`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `thongtin_bangiao_thue`
--
ALTER TABLE `thongtin_bangiao_thue`
  ADD CONSTRAINT `FK_49` FOREIGN KEY (`maloai`) REFERENCES `dovat` (`maloai`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_81` FOREIGN KEY (`mabangiao`) REFERENCES `lsbangiao` (`mabangiao`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_87` FOREIGN KEY (`mathue`) REFERENCES `thue_nhavanhoa` (`mathue`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `thue_nhavanhoa`
--
ALTER TABLE `thue_nhavanhoa`
  ADD CONSTRAINT `FK_62` FOREIGN KEY (`cmnd`) REFERENCES `tt_canhan` (`cmnd`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
