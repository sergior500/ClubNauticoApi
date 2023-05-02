-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: mysqlDawes:3306
-- Tiempo de generación: 17-04-2023 a las 07:32:39
-- Versión del servidor: 5.7.22
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nautic_club`
--

CREATE DATABASE `nautic_club`;

USE `nautic_club`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barco`
--

CREATE TABLE `barco` (
  `Num_Matricula` int(11) NOT NULL,
  `Nombre` varchar(12) NOT NULL,
  `Num_Amarre` int(6) NOT NULL,
  `Cuota` int(6) NOT NULL,
  `Dueño` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `barco`
--

INSERT INTO `barco` (`Num_Matricula`, `Nombre`, `Num_Amarre`, `Cuota`, `Dueño`) VALUES
(1, 'prueba1', 1, 24, 1),
(3, 'Pruebitas', 2, 25, 1),
(4, 'pruebasEdit', 2, 45, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patron`
--

CREATE TABLE `patron` (
  `Id_Patron` int(6) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE `salida` (
  `Num_Matricula` int(6) NOT NULL,
  `Id_Patron` int(6) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE `socio` (
  `Nombre` varchar(24) NOT NULL,
  `Apellido` varchar(24) NOT NULL,
  `Num_Socio` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `socio`
--

INSERT INTO `socio` (`Nombre`, `Apellido`, `Num_Socio`) VALUES
('Paco', 'Perez', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `barco`
--
ALTER TABLE `barco`
  ADD PRIMARY KEY (`Num_Matricula`),
  ADD KEY `Dueño` (`Dueño`);

--
-- Indices de la tabla `patron`
--
ALTER TABLE `patron`
  ADD PRIMARY KEY (`Id_Patron`);

--
-- Indices de la tabla `salida`
--
ALTER TABLE `salida`
  ADD PRIMARY KEY (`Num_Matricula`,`Id_Patron`,`Fecha`),
  ADD KEY `IdPatron` (`Id_Patron`);

--
-- Indices de la tabla `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`Num_Socio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `barco`
--
ALTER TABLE `barco`
  MODIFY `Num_Matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `patron`
--
ALTER TABLE `patron`
  MODIFY `Id_Patron` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `socio`
--
ALTER TABLE `socio`
  MODIFY `Num_Socio` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `barco`
--
ALTER TABLE `barco`
  ADD CONSTRAINT `barco_ibfk_1` FOREIGN KEY (`Dueño`) REFERENCES `socio` (`Num_Socio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `salida_ibfk_1` FOREIGN KEY (`Id_Patron`) REFERENCES `patron` (`Id_Patron`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `salida_ibfk_2` FOREIGN KEY (`Num_Matricula`) REFERENCES `barco` (`Num_Matricula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
