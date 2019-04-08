-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-04-2019 a las 13:45:52
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarEmpresa` (IN `id_empresa` INT, IN `nombre_empresa` VARCHAR(15), IN `dir_empresa` VARCHAR(30))  NO SQL
UPDATE Empresa SET nombre = nombre_empresa, direccion = dir_empresa WHERE id=id_empresa$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarEmpleado` (IN `id_empleado` INT)  NO SQL
DELETE FROM Empleado WHERE id=id_empleado$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertEmpleado` (IN `nombre` VARCHAR(15), IN `apellidos` VARCHAR(25), IN `telefono` INT, IN `id_empresa` INT)  NO SQL
INSERT INTO empleado (nombre, apellidos, telefono, id_empresa)
VALUES (nombre, apellidos, telefono, id_empresa)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `verEmpleadosNombre` ()  NO SQL
SELECT nombre FROM empleado$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(2) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `Apellidos` varchar(20) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `ID_Empresa` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `Nombre`, `Apellidos`, `Telefono`, `ID_Empresa`) VALUES
(1, 'David', 'Garcia Mateo', 674951211, 2),
(2, 'Miriam', 'Honrubia Gil', 612345789, 2),
(3, 'Sergio', 'Rojano Aguilera', 987654321, 1),
(4, 'Ruben', 'Blanco Garcia', 897654312, 3),
(5, 'Marcos', 'Perez Anjos', 98976543, 2),
(6, 'Angeliyo', 'Gonza', 9876, 3),
(17, 'Sergi', 'Vaghi Garcia', 6785934, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `ID` int(2) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `Direccion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`ID`, `Nombre`, `Direccion`) VALUES
(1, 'YesLifeLofe', 'Calle falsa 123'),
(2, 'Bananania', 'Calle feka 987'),
(4, 'PanOramics', 'Calle baguette'),
(5, 'Mimi', 'Calle234'),
(8, 'Yes Life Work', 'Avenida Madrid 8'),
(9, 'David&Co', 'Calle 1488'),
(10, 'AbdiestroENT', 'Hall de la fama'),
(11, 'DracoMalfoy', 'Calle slytherin'),
(13, 'BoliVic', 'Jaimitus'),
(67, 'Mi casa', 'Calle Dr.vila'),
(68, 'Esteve Terrades', 'Calle de la sabiduria');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `ID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
