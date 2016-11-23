-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.33 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para tienda
CREATE DATABASE IF NOT EXISTS `tienda` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `tienda`;


-- Volcando estructura para tabla tienda.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL DEFAULT '0',
  `id_producto` int(11) NOT NULL DEFAULT '0',
  `id_factura` int(11) DEFAULT '0',
  `cantidad` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_compra_usuario` (`id_usuario`),
  KEY `FK_compra_producto` (`id_producto`),
  KEY `FK_compra_factura` (`id_factura`),
  CONSTRAINT `FK_compra_factura` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_compra_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_compra_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla tienda.compra: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT IGNORE INTO `compra` (`id`, `id_usuario`, `id_producto`, `id_factura`, `cantidad`) VALUES
	(4, 2, 1, NULL, 15),
	(5, 3, 1, NULL, 11),
	(6, 2, 4, NULL, 1),
	(7, 3, 2, NULL, 111),
	(8, 3, 4, NULL, 32),
	(9, 4, 4, NULL, 22);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;


-- Volcando estructura para tabla tienda.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla tienda.factura: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;


-- Volcando estructura para tabla tienda.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla tienda.producto: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT IGNORE INTO `producto` (`id`, `codigo`, `precio`) VALUES
	(1, 'Flanes', 12.5),
	(2, 'Gelatinas', 4.5),
	(3, 'Yogur', 1.2),
	(4, 'Mantequilla', 6.3);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;


-- Volcando estructura para tabla tienda.tipo_usuario
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla tienda.tipo_usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT IGNORE INTO `tipo_usuario` (`id`, `descripcion`) VALUES
	(1, 'administrador'),
	(2, 'cliente');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;


-- Volcando estructura para tabla tienda.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `apellido1` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `apellido2` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `dni` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `login` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `id_tipo_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_usuario_tipo_usuario` (`id_tipo_usuario`),
  CONSTRAINT `FK_usuario_tipo_usuario` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla tienda.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT IGNORE INTO `usuario` (`id`, `nombre`, `apellido1`, `apellido2`, `dni`, `login`, `password`, `id_tipo_usuario`) VALUES
	(2, 'Dani', 'Castillo', 'Lozano', '45652565V', 'dani', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 1),
	(3, 'Alvaro', 'Martinez', 'Parrales', '23423411G', 'Alvaro', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 2),
	(4, 'Toni', 'Carrasco', 'Gomez', '468455754A', 'Toni', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 2),
	(5, 'Tomas', 'Gerard', 'Fabricio', '469854221C', 'Tomas', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 2),
	(6, 'Alex', 'Matamoros', 'Fernandez', '789544211Q', 'Alex', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 2),
	(7, 'Maria', 'Garrido', 'Gonzalez', '78946216B', 'Maria', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 2),
	(8, 'Cristina', 'Alvarez', 'Ferran', '45691235F', 'Cristina', '4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2', 2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
