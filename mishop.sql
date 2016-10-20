-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 19-10-2016 a las 20:49:46
-- Versión del servidor: 5.6.33
-- Versión de PHP: 5.6.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mishop`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itemspedidos`
--

CREATE TABLE `itemspedidos` (
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `itemspedidos`
--

INSERT INTO `itemspedidos` (`idPedido`, `idProducto`, `precio`, `cantidad`) VALUES
(3, 1, 5, 3),
(3, 2, 0, 1),
(3, 6, 1, 4),
(3, 9, 1, 4),
(4, 1, 5, 2),
(5, 1, 5, 1),
(5, 6, 0.95, 3),
(6, 1, 5, 5),
(8, 2, 0.3, 24),
(13, 7, 1.3, 4),
(14, 5, 1.25, 3),
(14, 8, 1.85, 4),
(14, 7, 1.3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `userId`, `date`) VALUES
(1, 1, '2016-10-19'),
(2, 1, '2016-10-19'),
(3, 1, '2016-10-19'),
(4, 1, '2016-10-19'),
(5, 1, '2016-10-19'),
(6, 1, '2016-10-20'),
(7, 1, '2016-10-20'),
(8, 1, '2016-10-20'),
(9, 1, '2016-10-20'),
(10, 1, '2016-10-20'),
(11, 1, '2016-10-20'),
(12, 1, '2016-10-20'),
(13, 1, '2016-10-20'),
(14, 2, '2016-10-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `price` float NOT NULL,
  `amount` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`id`, `description`, `price`, `amount`, `image`) VALUES
(1, 'Pirutelas', 5, 0, NULL),
(2, 'Chicles', 0.3, 0, NULL),
(5, 'Rosquilletas', 1.25, 10, NULL),
(6, 'Leche', 0.95, 0, NULL),
(7, 'Yogur', 1.3, 11, NULL),
(8, 'Galletas', 1.85, 24, NULL),
(9, 'Coca Cola 33cl', 0.56, 19, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `rank` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `rank`) VALUES
(1, 'Dani', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 1),
(2, 'manu', 'BF59D6A4564F9F49964EF377F398E35C7DA2413E9D792C97DFDBBC9687CE8ABC', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `itemspedidos`
--
ALTER TABLE `itemspedidos`
  ADD KEY `idPedido` (`idPedido`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `stock`
--
ALTER TABLE `stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `itemspedidos`
--
ALTER TABLE `itemspedidos`
  ADD CONSTRAINT `itemspedidos_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `itemspedidos_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `stock` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
