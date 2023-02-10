-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: SI_001_00
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `SI_001_00`
--

/*!40000 DROP DATABASE IF EXISTS `SI_001_00`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `SI_001_00` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `SI_001_00`;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `id_ciudad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `latitud` varchar(64) NOT NULL COMMENT 'Latitud',
  `longitud` varchar(64) DEFAULT NULL COMMENT 'Longitud',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`id_ciudad`, `nombre`, `latitud`, `longitud`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (2,'Cueca','-2.90055','-79.00453','manual','2022-08-06 03:46:07','manual'),(3,'Guayaquil','-2.18333','-79.8833','manual','2022-08-06 03:46:07','manual'),(10,'Quito','-0.22985','-78.52495','cambiar','2022-10-09 17:29:08','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(256) NOT NULL COMMENT 'Nombre de la información a relatar',
  `identificacion` varchar(16) NOT NULL COMMENT 'Identificacion del cliente',
  `estado` varchar(8) DEFAULT 'A' COMMENT 'Si el cliente esta o no activo',
  `correo` varchar(256) DEFAULT NULL,
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cliente_identificacion_IDX` (`identificacion`) USING BTREE,
  UNIQUE KEY `cliente_correo_IDX` (`correo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id_cliente`, `razon_social`, `identificacion`, `estado`, `correo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,'Omar Velez 10 jkjsal','010258170900100','A','omargo33@hotmail00100.com','cambiar()','2022-10-04 22:12:55','SI_001_00 1.0.0'),(2,'Omar Velez Datun','0102581709001','X','omargo33@hotmail.com','cambiar()','2022-10-11 17:19:30','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clima`
--

DROP TABLE IF EXISTS `clima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clima` (
  `id_clima` int NOT NULL AUTO_INCREMENT,
  `id_ciudad` int DEFAULT NULL,
  `json` varchar(1536) NOT NULL COMMENT 'Nombre de la información a relatar',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_clima`),
  KEY `clima_FK` (`id_ciudad`),
  CONSTRAINT `clima_FK` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clima`
--

LOCK TABLES `clima` WRITE;
/*!40000 ALTER TABLE `clima` DISABLE KEYS */;
INSERT INTO `clima` (`id_clima`, `id_ciudad`, `json`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (2,2,'jason','jlkj','2022-10-09 14:10:23','sdfas'),(3,2,'jason 01','jlkj','2022-10-09 14:10:23','sdfas'),(4,2,'02','jlkj','2022-10-09 14:10:23','sdfas'),(5,2,'03','jlkj','2022-10-09 14:10:23','sdfas'),(7,2,'05','jlkj','2022-10-09 14:10:23','sdfas'),(8,2,'06','jlkj','2022-10-09 14:10:23','sdfas'),(10,2,'08','jlkj','2022-10-09 14:10:23','sdfas');
/*!40000 ALTER TABLE `clima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion`
--

DROP TABLE IF EXISTS `informacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion` (
  `id_informacion` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `valor_01` varchar(256) NOT NULL COMMENT 'Valor 01',
  `valor_02` varchar(256) DEFAULT NULL COMMENT 'Valor 02',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_informacion`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion`
--

LOCK TABLES `informacion` WRITE;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
INSERT INTO `informacion` (`id_informacion`, `nombre`, `valor_01`, `valor_02`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,'api','https://www.youtube.com/watch?v=XsuE5Hky6xc',NULL,'manula','2022-08-03 05:40:27','maunal'),(2,'E-SI00100-1','Formato del correo incorrecto','@Email','manual','2022-10-05 03:29:42','manual'),(3,'E-SI00100-2','El campo no debe ser nulo','@NotNull','manual','2022-10-05 03:29:42','manual'),(4,'E-SI00100-3','El correo se encuentra utilizado','@ClienteCorreo','manual','2022-10-05 03:29:42','manual'),(5,'E-SI00100-4','La identificacion se encuentra utilizado','@ClienteIdentificacion','manual','2022-10-05 03:29:42','manual'),(6,'E-SI00100-5','La identificacion no es valida para RUC, CI o Pasaporte en EC','@ClienteEcIdentificacion','manual','2022-10-05 03:29:42','manual'),(7,'E-SI00100-6','La ciudad ya se encuentra ingresada','@CiudadNombre','manual','2022-10-05 03:29:42','manual'),(8,'E-SI00100-7','Existen registros asociados que no permiten el borrado','@PreRemove','manula','2022-08-03 05:40:27','maunal'),(10,'E-SI00100-9','Formato latitud incorrecta','@Pattern','manula','2022-08-03 05:40:27','maunal'),(11,'E-SI00100-10','Formato longitud incorrecta','@Pattern','manula','2022-08-03 05:40:27','maunal'),(14,'E-SI00100-11','El nombre de la información se encuentra utilizado','@InformacionNombre','manula','2022-08-03 05:40:27','maunal'),(15,'E-SI00100-12','El campo no puede estar en blanco','@NotBlank','manula','2022-08-03 05:40:27','maunal'),(16,'E-SI00100-13','El nombre de la localizacion se encuentra utilizada','@LocalizacionNombre','manula','2022-08-03 05:40:27','maunal'),(17,'E-SI00100-14','Direccion MAC Address equivocada','@Pattern','manula','2022-08-03 05:40:27','maunal'),(18,'E-SI00100-15','IP 4 Dirección equivocada','@Pattern','manula','2022-08-03 05:40:27','maunal'),(19,'E-SI00100-16','El nombre del monitor se encuentra utilizado','@MonitorNombre','manula','2022-08-03 05:40:27','maunal'),(20,'E-SI00100-17','El serie del monitor se encuentra utilizado','@MonitorSerie','manula','2022-08-03 05:40:27','maunal'),(22,'E-SI00100-19','El monitor no se puede localizar para ser refrescado','SeguridadException','manula','2022-08-03 05:40:27','maunal'),(23,'E-SI00100-20','El token refresh no puede ser actualizado ','SeguridadException','manula','2022-08-03 05:40:27','maunal'),(24,'E-SI00100-21','El token refresh no puede ser liberada la respuesta','SeguridadException','manula','2022-08-03 05:40:27','maunal'),(25,'E-SI00100-22','Busqueda de Monitor mac address Network y Wifi','SeguridadException','manula','2022-08-03 05:40:27','maunal');
/*!40000 ALTER TABLE `informacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacion`
--

DROP TABLE IF EXISTS `localizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localizacion` (
  `id_localizacion` int NOT NULL AUTO_INCREMENT,
  `id_ciudad` int DEFAULT NULL COMMENT 'Ciudad de ubicacion de la pantalla',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `latitud` varchar(64) NOT NULL COMMENT 'Valor 01',
  `longitud` varchar(64) DEFAULT NULL COMMENT 'Valor 02',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_localizacion`),
  KEY `localizacion_FK` (`id_ciudad`),
  CONSTRAINT `localizacion_FK` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacion`
--

LOCK TABLES `localizacion` WRITE;
/*!40000 ALTER TABLE `localizacion` DISABLE KEYS */;
INSERT INTO `localizacion` (`id_localizacion`, `id_ciudad`, `nombre`, `latitud`, `longitud`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (2,2,'Casa Omar Velez','-2.860402','-79.0413050','maual ','2022-08-06 03:53:51','manual');
/*!40000 ALTER TABLE `localizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitor`
--

DROP TABLE IF EXISTS `monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitor` (
  `id_monitor` int NOT NULL AUTO_INCREMENT,
  `id_localizacion` int DEFAULT NULL COMMENT 'Localizacion fisica del monitor',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `clave` varchar(128) DEFAULT NULL COMMENT 'Clave ingresado desde el control remoto',
  `serie` varchar(256) NOT NULL COMMENT 'No de Serie',
  `descripcion` varchar(256) NOT NULL COMMENT 'Descripcion del monitor',
  `tipo_sistema_operativo` varchar(8) DEFAULT NULL COMMENT 'Tipo de sistema operativo',
  `version` varchar(64) DEFAULT NULL COMMENT 'Version del Sistema Operativo',
  `tipo_orientacion` varchar(8) DEFAULT NULL COMMENT 'Orientacion del monitor',
  `network` varchar(128) DEFAULT NULL COMMENT 'Informacion Network',
  `wifi` varchar(128) DEFAULT NULL COMMENT 'Informacion Wifi',
  `ip` varchar(64) DEFAULT NULL COMMENT 'Direccion ip de consultas',
  `puerto` varchar(8) DEFAULT NULL COMMENT 'Puerto de acceso',
  `relacion` varchar(8) DEFAULT NULL COMMENT 'Relacion 16 (16:9) 4 (4:3)',
  `definicion` varchar(8) DEFAULT NULL COMMENT 'Definicion 1920 (1920x1080)...',
  `clima` varchar(8) DEFAULT NULL COMMENT 'Si se muestra o no la informacion del clima',
  `hora` varchar(8) DEFAULT NULL COMMENT 'Presentacion de la hora',
  `debug` varchar(8) DEFAULT NULL COMMENT 'Presenta en pantalla la informacion del trabajo',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Si el dispositivo esta o no activo',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_monitor`),
  KEY `monitor_FK` (`id_localizacion`),
  CONSTRAINT `monitor_FK` FOREIGN KEY (`id_localizacion`) REFERENCES `localizacion` (`id_localizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor`
--

LOCK TABLES `monitor` WRITE;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
INSERT INTO `monitor` (`id_monitor`, `id_localizacion`, `nombre`, `clave`, `serie`, `descripcion`, `tipo_sistema_operativo`, `version`, `tipo_orientacion`, `network`, `wifi`, `ip`, `puerto`, `relacion`, `definicion`, `clima`, `hora`, `debug`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,2,'samsun456','$2a$10$NVlOF.3HeOk4I2CZwSdg8uby5SreRwgCm8yhmdjuF8Rtfzw4Os592','456454545AV - 45','samsun qjdkl ','tizen','6.5','h',NULL,'AB:00:12:12:12:1A','192.168.1.3','24789','16:9','1920','S','S','N','A','usuario()','2022-10-18 23:02:57','SI_001_00 1.0.0'),(2,2,'samsun12345411','$2a$10$mbcK8uKgFYqz/jzaY2LiZuZyIKFlLfXIHR1xP2usfT4Y62MB358uC','456454545AV 01- 45','samsun qjdkl ','tizen','6.5','h','00:00:12:12:12:12','00:00:12:12:12:12','192.168.1.3','24789','16:9','1920','S','S','N','A','samsun456','2022-10-20 05:56:16','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitor_alerta`
--

DROP TABLE IF EXISTS `monitor_alerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitor_alerta` (
  `id_monitor_alerta` int NOT NULL AUTO_INCREMENT,
  `id_monitor` int DEFAULT NULL,
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `descripcion` varchar(2048) NOT NULL COMMENT 'Descripcion de la notificacion de un monitor',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_monitor_alerta`),
  KEY `monitor_alerta_FK` (`id_monitor`),
  CONSTRAINT `monitor_alerta_FK` FOREIGN KEY (`id_monitor`) REFERENCES `monitor` (`id_monitor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor_alerta`
--

LOCK TABLES `monitor_alerta` WRITE;
/*!40000 ALTER TABLE `monitor_alerta` DISABLE KEYS */;
INSERT INTO `monitor_alerta` (`id_monitor_alerta`, `id_monitor`, `nombre`, `descripcion`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,NULL,'alerta enviada cambiada a uno','sadfasdsa',' getUsuario()','2022-10-14 04:25:51','SI_001_00 1.0.0'),(3,NULL,'alerta enviada super nueva agenda','sadfasdsa',' getUsuario()','2022-10-14 04:26:10','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `monitor_alerta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitor_comando`
--

DROP TABLE IF EXISTS `monitor_comando`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitor_comando` (
  `id_monitor_comando` int NOT NULL AUTO_INCREMENT,
  `id_monitor` int DEFAULT NULL COMMENT 'Monitor al que se pide el comando',
  `elemento` varchar(8) NOT NULL COMMENT 'Elemento de ejecucion CLEAN limpia el cache,',
  `respuesta` varchar(8) DEFAULT NULL COMMENT 'Estado de ejecucion',
  `descripcion` varchar(512) DEFAULT NULL COMMENT 'Descripcion de la respuesta',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_monitor_comando`),
  KEY `comando_FK` (`id_monitor`),
  CONSTRAINT `comando_FK` FOREIGN KEY (`id_monitor`) REFERENCES `monitor` (`id_monitor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor_comando`
--

LOCK TABLES `monitor_comando` WRITE;
/*!40000 ALTER TABLE `monitor_comando` DISABLE KEYS */;
INSERT INTO `monitor_comando` (`id_monitor_comando`, `id_monitor`, `elemento`, `respuesta`, `descripcion`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (3,NULL,'12345678','--','kjlkj','getUsuario()','2022-10-14 05:21:30','SI_001_00 1.0.0'),(4,NULL,'8888','--','kjlkj','getUsuario()','2022-10-14 05:22:40','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `monitor_comando` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `id_proyecto` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL COMMENT 'Cliente que es el proyecto',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `fecha_inicio` date NOT NULL COMMENT 'Fecha de inicio del proyecto',
  `fecha_fin` date DEFAULT NULL COMMENT 'Fecha fin del proyecto',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Si el proyecto se encuentra actico',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_proyecto`),
  KEY `proyecto_FK` (`id_cliente`),
  CONSTRAINT `proyecto_FK` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` (`id_proyecto`, `id_cliente`, `nombre`, `fecha_inicio`, `fecha_fin`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,2,'proyecto demopara uno','2022-10-20','2022-12-12','A','getUsuario()','2022-10-16 22:02:26','SI_001_00 1.0.0'),(2,2,'proyecto demo 001','2022-12-12','2022-12-12','X','getUsuario()','2022-10-14 22:52:36','SI_001_00 1.0.0'),(3,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-14 22:52:44','SI_001_00 1.0.0'),(4,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-14 22:52:45','SI_001_00 1.0.0'),(5,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-14 22:52:45','SI_001_00 1.0.0'),(6,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-14 22:52:46','SI_001_00 1.0.0'),(7,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-14 23:07:55','SI_001_00 1.0.0'),(8,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-15 00:50:28','SI_001_00 1.0.0'),(9,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-15 01:55:24','SI_001_00 1.0.0'),(10,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-15 01:55:35','SI_001_00 1.0.0'),(11,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-16 21:47:08','SI_001_00 1.0.0'),(12,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-16 21:51:19','SI_001_00 1.0.0'),(13,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-16 21:57:11','SI_001_00 1.0.0'),(14,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-16 21:57:20','SI_001_00 1.0.0'),(15,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-16 21:58:24','SI_001_00 1.0.0'),(16,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-16 21:59:21','SI_001_00 1.0.0'),(17,2,'proyecto demo 001','2022-12-12','2022-12-12','A','getUsuario()','2022-10-16 22:01:54','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso` (
  `id_recurso` int NOT NULL AUTO_INCREMENT,
  `id_proyecto` int DEFAULT NULL COMMENT 'Proyecto',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de recurso mp4 jpg wav, etc',
  `indice` varchar(64) NOT NULL COMMENT 'Indice con tecnico para descargas y presentacion',
  `duracion` bigint NOT NULL COMMENT 'Tiempo en long time',
  `tipo_orientacion` varchar(8) NOT NULL COMMENT 'Orientacion H V',
  `sonido` int DEFAULT NULL COMMENT 'No tiene sonido(0) 10, 20, 30, 40, -> 100.',
  `brillo` int DEFAULT NULL COMMENT 'Brillo o correccion de Brillo. 10, 20, 30, 40, -> 100.',
  `relacion` varchar(8) DEFAULT NULL COMMENT 'Relacion del video 16 (16:9) 4(4:3)',
  `definicion` varchar(8) DEFAULT NULL COMMENT 'Definicion del video 1920 (1920x1080)....',
  `qr` varchar(8) DEFAULT NULL COMMENT 'Si esta o no activo el codigo qr para redireccionar informacion',
  `qr_posicion_x` int DEFAULT NULL COMMENT 'Porcentaje del eje x',
  `qr_posicion_y` int DEFAULT NULL COMMENT 'Porcentaje eje Y',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Video activo de presentacion',
  `tipo_documento` varchar(8) DEFAULT NULL COMMENT 'Tipo de documento mp4/pdf/jpg/ etc',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_recurso`),
  KEY `recurso_FK` (`id_proyecto`),
  CONSTRAINT `video_FK` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso`
--

LOCK TABLES `recurso` WRITE;
/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` (`id_recurso`, `id_proyecto`, `nombre`, `tipo`, `indice`, `duracion`, `tipo_orientacion`, `sonido`, `brillo`, `relacion`, `definicion`, `qr`, `qr_posicion_x`, `qr_posicion_y`, `estado`, `tipo_documento`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,1,'video dos cuatgro','MP$','IJCA',12345,'H',0,50,'16','1920','S',500,600,'A','M','GetUsuario()','2022-10-17 02:30:13','SI_001_00 1.0.0'),(2,1,'video 1234','MP$','IJCA',12345,'H',0,50,'16','1920','S',500,600,'A','M','GetUsuario()','2022-10-17 01:13:32','SI_001_00 1.0.0'),(3,1,'video 1234','MP$','IJCA',12345,'H',0,50,'16','1920','S',500,600,'X','M','GetUsuario()','2022-10-17 01:13:34','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso_monitor`
--

DROP TABLE IF EXISTS `recurso_monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso_monitor` (
  `id_recurso_monitor` int NOT NULL AUTO_INCREMENT,
  `id_recurso` int DEFAULT NULL COMMENT 'Video',
  `id_monitor` int DEFAULT NULL COMMENT 'Monitor',
  `estado` varchar(8) NOT NULL COMMENT 'activo de presentacion, X borrado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_recurso_monitor`),
  KEY `recurso_monitor_FK` (`id_recurso`),
  KEY `recurso_monitor_FK_1` (`id_monitor`),
  CONSTRAINT `video_monitor_FK` FOREIGN KEY (`id_recurso`) REFERENCES `recurso` (`id_recurso`),
  CONSTRAINT `video_monitor_FK_1` FOREIGN KEY (`id_monitor`) REFERENCES `monitor` (`id_monitor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso_monitor`
--

LOCK TABLES `recurso_monitor` WRITE;
/*!40000 ALTER TABLE `recurso_monitor` DISABLE KEYS */;
INSERT INTO `recurso_monitor` (`id_recurso_monitor`, `id_recurso`, `id_monitor`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,1,1,'A','sfsafd','2022-10-17 02:47:05','sdfsadf'),(2,1,1,'X','getUSuario()','2022-10-18 01:38:53','SI_001_00 1.0.0'),(3,1,2,'A','getUSuario()','2022-10-18 01:35:25','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `recurso_monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso_monitor_calendario`
--

DROP TABLE IF EXISTS `recurso_monitor_calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso_monitor_calendario` (
  `id_recurso_monitor_calendario` int NOT NULL AUTO_INCREMENT,
  `id_recurso_monitor` int DEFAULT NULL COMMENT 'Video Monitor',
  `fecha_presentacion` date NOT NULL COMMENT 'Fecha de presentacion del video',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_recurso_monitor_calendario`),
  KEY `calendario_FK` (`id_recurso_monitor`),
  CONSTRAINT `calendario_FK` FOREIGN KEY (`id_recurso_monitor`) REFERENCES `recurso_monitor` (`id_recurso_monitor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='Dia en que un recurso se presenta en un motitor';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso_monitor_calendario`
--

LOCK TABLES `recurso_monitor_calendario` WRITE;
/*!40000 ALTER TABLE `recurso_monitor_calendario` DISABLE KEYS */;
INSERT INTO `recurso_monitor_calendario` (`id_recurso_monitor_calendario`, `id_recurso_monitor`, `fecha_presentacion`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,1,'2022-12-12','ksdfjalk','2022-10-18 14:19:49','sdfsa'),(3,1,'2022-12-16','cambiar()','2022-10-18 14:45:44','SI_001_00 1.0.0'),(4,1,'2022-12-13','cambiar()','2022-10-18 14:29:21','SI_001_00 1.0.0'),(5,1,'2022-12-13','cambiar()','2022-10-18 14:29:26','SI_001_00 1.0.0'),(6,1,'2022-12-13','cambiar()','2022-10-18 14:29:27','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `recurso_monitor_calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso_monitor_presentacion`
--

DROP TABLE IF EXISTS `recurso_monitor_presentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso_monitor_presentacion` (
  `id_recurso_monitor_presentacion` int NOT NULL AUTO_INCREMENT,
  `id_recurso_monitor` int DEFAULT NULL COMMENT 'Informacion de presentacion de un video en un monitor',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_recurso_monitor_presentacion`),
  KEY `video_monitor_presentacion_FK` (`id_recurso_monitor`),
  CONSTRAINT `video_monitor_presentacion_FK` FOREIGN KEY (`id_recurso_monitor`) REFERENCES `recurso_monitor` (`id_recurso_monitor`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso_monitor_presentacion`
--

LOCK TABLES `recurso_monitor_presentacion` WRITE;
/*!40000 ALTER TABLE `recurso_monitor_presentacion` DISABLE KEYS */;
INSERT INTO `recurso_monitor_presentacion` (`id_recurso_monitor_presentacion`, `id_recurso_monitor`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,1,'omafr','2022-10-18 15:19:09','mnaul'),(2,1,'getUsuario()','2022-10-18 15:19:59','SI_001_00 1.0.0'),(3,1,'getUsuario()','2022-10-18 15:20:00','SI_001_00 1.0.0'),(4,1,'getUsuario()','2022-10-18 15:20:01','SI_001_00 1.0.0'),(5,1,'getUsuario()','2022-10-18 15:20:01','SI_001_00 1.0.0'),(6,1,'getUsuario()','2022-10-18 15:20:01','SI_001_00 1.0.0'),(7,1,'getUsuario()','2022-10-18 15:20:01','SI_001_00 1.0.0'),(8,1,'getUsuario()','2022-10-18 15:20:01','SI_001_00 1.0.0'),(9,1,'getUsuario()','2022-10-18 15:20:02','SI_001_00 1.0.0'),(10,1,'getUsuario()','2022-10-18 15:20:02','SI_001_00 1.0.0'),(11,1,'getUsuario()','2022-10-18 15:20:02','SI_001_00 1.0.0'),(12,1,'getUsuario()','2022-10-18 15:20:02','SI_001_00 1.0.0'),(13,1,'getUsuario()','2022-10-18 15:20:02','SI_001_00 1.0.0'),(14,1,'getUsuario()','2022-10-18 15:20:02','SI_001_00 1.0.0'),(15,1,'getUsuario()','2022-10-18 15:20:03','SI_001_00 1.0.0'),(16,1,'getUsuario()','2022-10-18 15:20:03','SI_001_00 1.0.0'),(17,1,'getUsuario()','2022-10-18 15:20:03','SI_001_00 1.0.0'),(18,1,'getUsuario()','2022-10-18 15:20:03','SI_001_00 1.0.0'),(19,1,'getUsuario()','2022-10-18 15:20:03','SI_001_00 1.0.0'),(20,1,'getUsuario()','2022-10-18 15:20:03','SI_001_00 1.0.0'),(21,1,'getUsuario()','2022-10-18 15:20:04','SI_001_00 1.0.0'),(22,1,'getUsuario()','2022-10-18 15:20:04','SI_001_00 1.0.0'),(23,1,'getUsuario()','2022-10-18 15:20:04','SI_001_00 1.0.0'),(24,1,'getUsuario()','2022-10-18 15:20:04','SI_001_00 1.0.0'),(25,1,'getUsuario()','2022-10-18 15:20:04','SI_001_00 1.0.0'),(26,1,'getUsuario()','2022-10-18 15:20:05','SI_001_00 1.0.0');
/*!40000 ALTER TABLE `recurso_monitor_presentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_recurso_monitor`
--

DROP TABLE IF EXISTS `v_recurso_monitor`;
/*!50001 DROP VIEW IF EXISTS `v_recurso_monitor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_recurso_monitor` AS SELECT 
 1 AS `id_v_recurso_monitor`,
 1 AS `indice`,
 1 AS `tipo`,
 1 AS `duracion`,
 1 AS `tipo_orientacion`,
 1 AS `sonido`,
 1 AS `brillo`,
 1 AS `relacion`,
 1 AS `definicion`,
 1 AS `qr`,
 1 AS `qr_posicion_x`,
 1 AS `qr_posicion_y`,
 1 AS `id_recurso`,
 1 AS `nombre`,
 1 AS `network`,
 1 AS `wifi`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_recursos_monitor`
--

DROP TABLE IF EXISTS `v_recursos_monitor`;
/*!50001 DROP VIEW IF EXISTS `v_recursos_monitor`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_recursos_monitor` AS SELECT 
 1 AS `id_v_recurso_monitor`,
 1 AS `indice`,
 1 AS `tipo`,
 1 AS `duracion`,
 1 AS `tipo_orientacion`,
 1 AS `sonido`,
 1 AS `brillo`,
 1 AS `relacion`,
 1 AS `definicion`,
 1 AS `qr`,
 1 AS `qr_posicion_x`,
 1 AS `qr_posicion_y`,
 1 AS `id_recurso`,
 1 AS `nombre`,
 1 AS `network`,
 1 AS `wifi`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'SI_001_00'
--

--
-- Dumping routines for database 'SI_001_00'
--

--
-- Current Database: `SI_001_00`
--

USE `SI_001_00`;

--
-- Final view structure for view `v_recurso_monitor`
--

/*!50001 DROP VIEW IF EXISTS `v_recurso_monitor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_recurso_monitor` AS select concat(`r`.`id_recurso`,'-',`rm`.`id_recurso_monitor`,'-',`m`.`id_monitor`) AS `id_v_recurso_monitor`,`r`.`indice` AS `indice`,`r`.`tipo` AS `tipo`,`r`.`duracion` AS `duracion`,`r`.`tipo_orientacion` AS `tipo_orientacion`,`r`.`sonido` AS `sonido`,`r`.`brillo` AS `brillo`,`r`.`relacion` AS `relacion`,`r`.`definicion` AS `definicion`,`r`.`qr` AS `qr`,`r`.`qr_posicion_x` AS `qr_posicion_x`,`r`.`qr_posicion_y` AS `qr_posicion_y`,`rm`.`id_recurso` AS `id_recurso`,`m`.`nombre` AS `nombre`,`m`.`network` AS `network`,`m`.`wifi` AS `wifi` from ((`recurso` `r` join `recurso_monitor` `rm`) join `monitor` `m`) where ((`r`.`id_recurso` = `rm`.`id_recurso`) and (`rm`.`id_monitor` = `m`.`id_monitor`) and (`m`.`estado` = 'A') and (`r`.`estado` = 'A') and (`rm`.`estado` = 'A') and `r`.`id_proyecto` in (select `proyecto`.`id_proyecto` from `proyecto` where ((`proyecto`.`estado` = 'A') and (cast(sysdate() as date) between cast(`proyecto`.`fecha_inicio` as date) and cast(`proyecto`.`fecha_fin` as date))))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_recursos_monitor`
--

/*!50001 DROP VIEW IF EXISTS `v_recursos_monitor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_recursos_monitor` AS select concat(`r`.`id_recurso`,'-',`rm`.`id_recurso_monitor`,'-',`m`.`id_monitor`) AS `id_v_recurso_monitor`,`r`.`indice` AS `indice`,`r`.`tipo` AS `tipo`,`r`.`duracion` AS `duracion`,`r`.`tipo_orientacion` AS `tipo_orientacion`,`r`.`sonido` AS `sonido`,`r`.`brillo` AS `brillo`,`r`.`relacion` AS `relacion`,`r`.`definicion` AS `definicion`,`r`.`qr` AS `qr`,`r`.`qr_posicion_x` AS `qr_posicion_x`,`r`.`qr_posicion_y` AS `qr_posicion_y`,`rm`.`id_recurso` AS `id_recurso`,`m`.`nombre` AS `nombre`,`m`.`network` AS `network`,`m`.`wifi` AS `wifi` from ((`recurso` `r` join `recurso_monitor` `rm`) join `monitor` `m`) where ((`r`.`id_recurso` = `rm`.`id_recurso`) and (`rm`.`id_monitor` = `m`.`id_monitor`) and (`m`.`estado` = 'A') and (`r`.`estado` = 'A') and (`rm`.`estado` = 'A') and `r`.`id_proyecto` in (select `proyecto`.`id_proyecto` from `proyecto` where ((`proyecto`.`estado` = 'A') and (cast(sysdate() as date) between cast(`proyecto`.`fecha_inicio` as date) and cast(`proyecto`.`fecha_fin` as date))))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-10  2:59:03
