-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 22-Jan-2022 às 22:24
-- Versão do servidor: 5.7.23
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurante`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `parceiros`
--


CREATE SCHEMA IF NOT EXISTS `restaurante` DEFAULT CHARACTER SET utf8 ;
USE `restaurante` ;



DROP TABLE IF EXISTS `parceiros`;
CREATE TABLE IF NOT EXISTS `parceiros` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `email` varchar(250) NOT NULL,
  `telefone` varchar(250) NOT NULL,
  `gps_latitude` varchar(250) NOT NULL,
  `gps_longitude` varchar(250) NOT NULL,
  `youtube_videouid` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `parceiros`
--

INSERT INTO `parceiros` (`id`, `email`, `telefone`, `gps_latitude`, `gps_longitude`, `youtube_videouid`) VALUES
(1, 'fipag@gmail.com', '845698565', '122222', '12456', 'Junior');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `preco` double NOT NULL,
  `validade` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `tipo`, `preco`, `validade`) VALUES
(3, 'Coca cola Grande', 'Bebida', 130, '2022-01-21');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contacto` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `nivel_acesso` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `usuario`, `contacto`, `email`, `senha`, `nivel_acesso`) VALUES
(1, 'linder.junior', '846978018', 'linder', 'linder', 'admin'),
(2, 'jose.silvio', '879890987', 'silviosilva@gmail.com', '12345', 'contabilista');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
