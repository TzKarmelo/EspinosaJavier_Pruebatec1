-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 30-12-2023 a las 15:40:08
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  `cargo` varchar(100) COLLATE utf8mb3_spanish_ci NOT NULL,
  `salario` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id`, `nombre`, `apellido`, `cargo`, `salario`, `fecha_inicio`) VALUES
(1, 'Javier', 'Espinosa', 'Programador', 25000, '2023-05-01'),
(2, 'Luisina', 'de Paula', 'Jefe de Proyecto', 55000, '2020-01-18'),
(3, 'Marcos', 'Perez', 'Arquitecto Sistemas', 80000, '2018-10-25'),
(4, 'José', 'Gómez', 'Programador', 22000, '2019-07-26'),
(5, 'Martina', 'Perez', 'CEO', 200000, '2018-03-12'),
(6, 'Lara', 'Ortega', 'Programador', 23000, '2021-04-23'),
(7, 'Jose', 'Pardo', 'Programador', 25000, '2020-12-23'),
(31, 'Pedro', 'Jimenez', 'Mantenimiento', 20000, '2021-11-30'),
(9, 'Julia', 'Otero', 'Marketing', 20000, '2022-03-03'),
(10, 'Laia', 'Soriano', 'Marqueting', 21000, '2022-11-16'),
(11, 'Jori', 'Selfi', 'Programador', 21000, '2021-12-23'),
(34, 'Portela', 'Fernandez', 'Vigilante', 18000, '2020-02-02'),
(13, 'Jose Miguel', 'Estrada', 'Consejero Delegado', 80000, '2020-12-23'),
(32, 'Julia', 'Perez', 'Limpieza', 16000, '2020-02-23'),
(33, 'Jose', 'Espinosa', 'Jefe', 40000, '2010-01-01'),
(35, 'Paula', 'Heredia', 'Limpieza', 14000, '2023-03-02'),
(30, 'Priscila', 'Calimero', 'Directora General', 250000, '2018-03-12');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
