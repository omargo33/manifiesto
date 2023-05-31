-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: GA_001_00
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
-- Current Database: `GA_001_00`
--

/*!40000 DROP DATABASE IF EXISTS `GA_001_00`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `GA_001_00` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `GA_001_00`;

--
-- Table structure for table `archivo`
--

DROP TABLE IF EXISTS `archivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `archivo` (
  `id_archivo` int NOT NULL AUTO_INCREMENT COMMENT 'Id de Archivo',
  `id_grupo` int NOT NULL COMMENT 'Id de grupo al que pertence',
  `nombre_ramdon` varchar(128) NOT NULL COMMENT 'Nombre ofuscado que se encuentra fisicamente',
  `nombre` varchar(256) NOT NULL COMMENT 'Nombre de la información a relatar',
  `extension` varchar(32) NOT NULL COMMENT 'Extension original del archivo',
  `largo` int NOT NULL COMMENT 'Largo en bytes del archivo',
  `path_relativo` varchar(512) NOT NULL COMMENT 'Path relativo {user.home}/path_relativo/trunc(user_date)/nombre_ofuscado',
  `estado` varchar(8) NOT NULL COMMENT 'A=activo X=borrado logico',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_archivo`),
  KEY `archivo_FK` (`id_grupo`),
  CONSTRAINT `archivo_FK` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=512 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivo`
--

LOCK TABLES `archivo` WRITE;
/*!40000 ALTER TABLE `archivo` DISABLE KEYS */;
INSERT INTO `archivo` (`id_archivo`, `id_grupo`, `nombre_ramdon`, `nombre`, `extension`, `largo`, `path_relativo`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (488,90,'90-P4EAjAbB9Wrc','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-P4EAjAbB9Wrc','X','aerocivil','2023-02-23 03:50:57','/Manifiesto-001'),(489,90,'90-yugvjJh8hADV','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-yugvjJh8hADV','X','aerocivil','2023-02-23 03:52:01','/Manifiesto-001'),(490,90,'90-PXuA2kN9QcBG','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-PXuA2kN9QcBG','X','aerocivil','2023-02-23 03:52:28','/faces/Upload'),(491,90,'90-P5kxfmj4cAAN','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-P5kxfmj4cAAN','X','aerocivil','2023-02-23 03:52:51','/Manifiesto-001'),(492,90,'90-JU5JHxTn7hWm','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-JU5JHxTn7hWm','X','aerocivil','2023-02-23 03:55:43','/faces/Upload'),(493,90,'90-eHAfcAW3AZJT','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-eHAfcAW3AZJT','X','aerocivil','2023-02-23 03:55:57','/faces/Upload'),(494,90,'90-KeD5bDMntaD4','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-KeD5bDMntaD4','X','aerocivil','2023-02-23 03:56:09','/Manifiesto-001'),(495,90,'90-HTWrzU29ZUd6','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-HTWrzU29ZUd6','X','aerocivil','2023-02-23 04:00:13','/Manifiesto-001'),(496,90,'90-WnZFzYdPrecE','89-WVtZYx8a2j4m.xls','application/x-ole-storage',19456,'Manifiesto/Usuario/2023-02-22/90-WnZFzYdPrecE','X','aerocivil','2023-02-23 04:00:29','/Manifiesto-001'),(497,90,'90-zB3wnj29Ah5y','ejemplo.xlsx','application/zip',12139,'Manifiesto/Usuario/2023-02-23/90-zB3wnj29Ah5y','X','aerocivil','2023-02-23 17:21:42','/Manifiesto-001'),(498,90,'90-N2N5nECgtC8K','1 Estructura para carga de Información en Bloque.xlsx','application/zip',14515,'Manifiesto/Usuario/2023-03-02/90-N2N5nECgtC8K','A','aerocivil','2023-03-03 01:22:59','/faces/Upload'),(499,91,'91-btDemMeHMMRy','manifiesto-aerocivil-2023-03-04-11-58-01.pdf','application/pdf',114637,'manifiesto/manifiesto/2023-03-04/91-btDemMeHMMRy','A','aerocivil','2023-03-04 16:58:02','/Manifiesto-001'),(500,91,'91-g5n4fBHYtVkp','manifiesto-aerocivil-2023-03-04-12-24-06.pdf','application/pdf',114633,'manifiesto/manifiesto/2023-03-04/91-g5n4fBHYtVkp','A','aerocivil','2023-03-04 17:24:06','/Manifiesto-001'),(501,91,'91-9DNqE2pRXWKg','manifiesto-aerocivil-2023-03-04-13-24-11.pdf','application/pdf',114586,'manifiesto/manifiesto/2023-03-04/91-9DNqE2pRXWKg','A','aerocivil','2023-03-04 18:24:12','/Manifiesto-001'),(502,91,'91-muk3aPrvAam3','manifiesto-aerocivil-2023-03-04-13-25-51.pdf','application/pdf',114553,'manifiesto/manifiesto/2023-03-04/91-muk3aPrvAam3','A','aerocivil','2023-03-04 18:25:52','/Manifiesto-001'),(503,91,'91-U2vBJ2DCANGi','manifiesto-aerocivil-2023-03-04-13-29-12.pdf','application/pdf',114590,'manifiesto/manifiesto/2023-03-04/91-U2vBJ2DCANGi','A','aerocivil','2023-03-04 18:29:13','/Manifiesto-001'),(504,91,'91-eXrYJhizK2gZ','manifiesto-aerocivil-2023-03-04-13-41-49.pdf','application/pdf',114656,'manifiesto/manifiesto/2023-03-04/91-eXrYJhizK2gZ','A','aerocivil','2023-03-04 18:41:50','/Manifiesto-001'),(505,91,'91-A9CFMpAjKuuB','manifiesto-aerocivil-2023-03-04-13-44-00.pdf','application/pdf',114597,'manifiesto/manifiesto/2023-03-04/91-A9CFMpAjKuuB','A','aerocivil','2023-03-04 18:44:01','/Manifiesto-001'),(506,91,'91-eCBY3JubNHwx','manifiesto-aerocivil-2023-03-04-13-46-37.pdf','application/pdf',114621,'manifiesto/manifiesto/2023-03-04/91-eCBY3JubNHwx','A','aerocivil','2023-03-04 18:46:38','/Manifiesto-001'),(507,91,'91-Xm5uvQgqCwK7','manifiesto-aerocivil-2023-03-04-13-47-37.pdf','application/pdf',114618,'manifiesto/manifiesto/2023-03-04/91-Xm5uvQgqCwK7','A','aerocivil','2023-03-04 18:47:37','/Manifiesto-001'),(508,91,'91-aNJHc3GDqqZj','manifiesto-aerocivil-2023-03-04-13-51-45.pdf','application/pdf',114639,'manifiesto/manifiesto/2023-03-04/91-aNJHc3GDqqZj','A','aerocivil','2023-03-04 18:51:46','/Manifiesto-001'),(509,91,'91-2HqWWZneXVhz','manifiesto-aerocivil-2023-03-04-13-58-41.pdf','application/pdf',114681,'manifiesto/manifiesto/2023-03-04/91-2HqWWZneXVhz','A','aerocivil','2023-03-04 18:58:41','/Manifiesto-001'),(510,91,'91-uDU7gHMKhztA','manifiesto-aerocivil-2023-03-07-23-23-07.pdf','application/pdf',114643,'manifiesto/manifiesto/2023-03-07/91-uDU7gHMKhztA','A','aerocivil','2023-03-07 23:23:08','/Manifiesto-001'),(511,91,'91-XMyp4HY9qMft','manifiesto-aerocivil-2023-03-07-23-55-37.pdf','application/pdf',114569,'manifiesto/manifiesto/2023-03-07/91-XMyp4HY9qMft','A','aerocivil','2023-03-07 23:55:38','/Manifiesto-001');
/*!40000 ALTER TABLE `archivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `archivo_evento`
--

DROP TABLE IF EXISTS `archivo_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `archivo_evento` (
  `id_archivo_evento` int NOT NULL AUTO_INCREMENT COMMENT 'Id evento',
  `id_archivo` int DEFAULT NULL COMMENT 'Id archivo',
  `informacion` varchar(512) NOT NULL COMMENT 'Informacion de la accion: Ip+host+userAgent',
  `tipo` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'P=procesos varios Creado = C, Descargado = D y X=eleiminado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_archivo_evento`),
  KEY `archivo_evento_FK` (`id_archivo`),
  CONSTRAINT `archivo_evento_FK` FOREIGN KEY (`id_archivo`) REFERENCES `archivo` (`id_archivo`)
) ENGINE=InnoDB AUTO_INCREMENT=728 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivo_evento`
--

LOCK TABLES `archivo_evento` WRITE;
/*!40000 ALTER TABLE `archivo_evento` DISABLE KEYS */;
INSERT INTO `archivo_evento` (`id_archivo_evento`, `id_archivo`, `informacion`, `tipo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (626,488,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 03:50:57','/faces/Upload'),(627,488,'0:0:0:0:0:0:0:1','X','aerocivil','2023-02-23 03:51:21','/Manifiesto-001'),(628,489,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 03:52:01','/faces/Upload'),(629,489,'Linea 7 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(630,489,'Linea 6 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(631,489,'Linea 9 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(632,489,'Linea 8 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(633,489,'Linea 3 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(634,489,'Linea 2 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(635,489,'Linea 5 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(636,489,'Linea 4 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:08','/Manifiesto-001'),(637,489,'0:0:0:0:0:0:0:1','X','aerocivil','2023-02-23 03:52:20','/Manifiesto-001'),(638,490,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 03:52:28','/faces/Upload'),(639,491,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 03:52:51','/faces/Upload'),(640,491,'Linea 7 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(641,491,'Linea 6 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(642,491,'Linea 9 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(643,491,'Linea 8 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(644,491,'Linea 3 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(645,491,'Linea 2 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(646,491,'Linea 5 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(647,491,'Linea 4 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:52:59','/Manifiesto-001'),(648,491,'0:0:0:0:0:0:0:1','X','aerocivil','2023-02-23 03:53:05','/Manifiesto-001'),(649,492,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 03:55:43','/faces/Upload'),(650,493,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 03:55:57','/faces/Upload'),(651,494,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 03:56:09','/faces/Upload'),(652,494,'Linea 7 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(653,494,'Linea 6 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(654,494,'Linea 9 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(655,494,'Linea 8 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(656,494,'Linea 3 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(657,494,'Linea 2 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(658,494,'Linea 5 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(659,494,'Linea 4 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 03:56:21','/Manifiesto-001'),(660,494,'0:0:0:0:0:0:0:1','X','aerocivil','2023-02-23 03:56:26','/Manifiesto-001'),(661,495,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 04:00:13','/faces/Upload'),(662,495,'Linea 7 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(663,495,'Linea 6 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(664,495,'Linea 9 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(665,495,'Linea 8 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(666,495,'Linea 3 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(667,495,'Linea 2 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(668,495,'Linea 5 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(669,495,'Linea 4 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:18','/Manifiesto-001'),(670,495,'0:0:0:0:0:0:0:1','X','aerocivil','2023-02-23 04:00:23','/Manifiesto-001'),(671,496,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 04:00:29','/faces/Upload'),(672,496,'Linea 7 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(673,496,'Linea 6 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(674,496,'Linea 9 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(675,496,'Linea 8 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(676,496,'Linea 3 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(677,496,'Linea 2 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(678,496,'Linea 5 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(679,496,'Linea 4 El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe','P','aerocivil','2023-02-23 04:00:35','/Manifiesto-001'),(680,496,'0:0:0:0:0:0:0:1','X','aerocivil','2023-02-23 04:00:40','/Manifiesto-001'),(681,497,'Archivo Creado desde elemento base','C','aerocivil','2023-02-23 17:21:42','/faces/Upload'),(682,497,'0:0:0:0:0:0:0:1','X','aerocivil','2023-02-23 17:21:51','/Manifiesto-001'),(683,498,'Archivo Creado desde elemento base','C','aerocivil','2023-03-03 01:22:59','/faces/Upload'),(684,498,'Linea 7 La fecha de operacion tiene un limite de 30.0 días','P','123','2023-03-03 01:24:48','123'),(685,498,'Linea 6 La fecha de operacion tiene un limite de 30.0 días','P','123','2023-03-03 01:24:48','123'),(686,498,'Linea 8 La fecha de operacion tiene un limite de 30.0 días','P','123','2023-03-03 01:24:48','123'),(687,498,'Linea 3 La fecha de operacion tiene un limite de 30.0 días','P','123','2023-03-03 01:24:48','123'),(688,498,'Linea 2 La fecha de operacion tiene un limite de 30.0 días','P','123','2023-03-03 01:24:48','123'),(689,498,'Linea 5 La fecha de operacion tiene un limite de 30.0 días','P','123','2023-03-03 01:24:48','123'),(690,498,'Linea 4 La fecha de operacion tiene un limite de 30.0 días','P','123','2023-03-03 01:24:48','123'),(691,498,'Linea 7 La fecha de operacion tiene un limite de 30.0 días','P','aerocivil','2023-03-03 01:25:12','/Manifiesto-001'),(692,498,'Linea 6 La fecha de operacion tiene un limite de 30.0 días','P','aerocivil','2023-03-03 01:25:12','/Manifiesto-001'),(693,498,'Linea 8 La fecha de operacion tiene un limite de 30.0 días','P','aerocivil','2023-03-03 01:25:12','/Manifiesto-001'),(694,498,'Linea 3 La fecha de operacion tiene un limite de 30.0 días','P','aerocivil','2023-03-03 01:25:12','/Manifiesto-001'),(695,498,'Linea 2 La fecha de operacion tiene un limite de 30.0 días','P','aerocivil','2023-03-03 01:25:12','/Manifiesto-001'),(696,498,'Linea 5 La fecha de operacion tiene un limite de 30.0 días','P','aerocivil','2023-03-03 01:25:12','/Manifiesto-001'),(697,498,'Linea 4 La fecha de operacion tiene un limite de 30.0 días','P','aerocivil','2023-03-03 01:25:12','/Manifiesto-001'),(698,498,'Linea 6 El formato de la columna Fecha Local Operacion no es el correcto, debe ser texto simple','P','sadfsa','2023-03-03 02:45:49','sdfsadf'),(699,498,'Linea 3 El formato de la columna Fecha Local Operacion no es el correcto, debe ser texto simple','P','sadfsa','2023-03-03 02:45:49','sdfsadf'),(700,498,'Linea 2 El formato de la columna Fecha Local Operacion no es el correcto, debe ser texto simple','P','sadfsa','2023-03-03 02:45:49','sdfsadf'),(701,498,'Linea 5 El formato de la columna Fecha Local Operacion no es el correcto, debe ser texto simple','P','sadfsa','2023-03-03 02:45:49','sdfsadf'),(702,498,'Linea 4 El formato de la columna Fecha Local Operacion no es el correcto, debe ser texto simple','P','sadfsa','2023-03-03 02:45:49','sdfsadf'),(703,499,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 16:58:02','/Manifiesto-001'),(704,500,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 17:24:06','/Manifiesto-001'),(705,500,'Descarga de elemento','D','aerocivil','2023-03-04 17:24:09','/faces/Download'),(706,501,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:24:12','/Manifiesto-001'),(707,501,'Descarga de elemento','D','aerocivil','2023-03-04 18:24:14','/faces/Download'),(708,502,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:25:52','/Manifiesto-001'),(709,502,'Descarga de elemento','D','aerocivil','2023-03-04 18:25:54','/faces/Download'),(710,503,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:29:13','/Manifiesto-001'),(711,503,'Descarga de elemento','D','aerocivil','2023-03-04 18:29:27','/faces/Download'),(712,504,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:41:50','/Manifiesto-001'),(713,504,'Descarga de elemento','D','aerocivil','2023-03-04 18:41:52','/faces/Download'),(714,505,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:44:01','/Manifiesto-001'),(715,505,'Descarga de elemento','D','aerocivil','2023-03-04 18:44:04','/faces/Download'),(716,506,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:46:38','/Manifiesto-001'),(717,506,'Descarga de elemento','D','aerocivil','2023-03-04 18:46:40','/faces/Download'),(718,507,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:47:37','/Manifiesto-001'),(719,507,'Descarga de elemento','D','aerocivil','2023-03-04 18:47:39','/faces/Download'),(720,508,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:51:46','/Manifiesto-001'),(721,508,'Descarga de elemento','D','aerocivil','2023-03-04 18:51:48','/faces/Download'),(722,509,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-04 18:58:41','/Manifiesto-001'),(723,509,'Descarga de elemento','D','aerocivil','2023-03-04 18:58:43','/faces/Download'),(724,510,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-07 23:23:08','/Manifiesto-001'),(725,510,'Descarga de elemento','D','aerocivil','2023-03-07 23:23:10','/faces/Download'),(726,511,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-03-07 23:55:39','/Manifiesto-001'),(727,511,'Descarga de elemento','D','aerocivil','2023-03-07 23:55:40','/faces/Download');
/*!40000 ALTER TABLE `archivo_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formato`
--

DROP TABLE IF EXISTS `formato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formato` (
  `id_formato` int NOT NULL AUTO_INCREMENT COMMENT 'Id Formato',
  `indice` varchar(32) DEFAULT NULL COMMENT 'Indice de formato de envio',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del parametro',
  `formato_html` varchar(4096) NOT NULL COMMENT 'Formato Html del Servicio',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_formato`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formato`
--

LOCK TABLES `formato` WRITE;
/*!40000 ALTER TABLE `formato` DISABLE KEYS */;
INSERT INTO `formato` (`id_formato`, `indice`, `nombre`, `formato_html`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,'MAIL_FORMAT_01','Formato de correo + ip dispositivo','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\"> <tr> <td align=\"center\" bgcolor=\"#ffffff\" width=\"300\" style=\"background: #ffffff; padding: 56px 56px 56px 56px;\">  <img src=\"https://www.aerocivil.gov.co/Logos%20encabezado%20master/logo-aeronautica.svg\" width=\"321\"/> </td> </tr> <tr> <td> {cuerpo} </td> </tr><tr><td> <table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 40px 0 20px 0\"><strong>Dispositivo</strong>: </td></tr><tr><td style=\"padding: 0 0 4px 0\">La dirección IP: {ip}</td></tr><tr><td style=\"padding: 0 0 20px 0\">Navegador: {dispositivo}</td></tr></tbody></table></td></tr></tbody></table></td></tr></table>','omar','2022-06-09 23:09:46','manual'),(2,'MAIL_FORMAT_02','Formato de correo','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\"><tr> <td align=\"center\" bgcolor=\"#ffffff\" width=\"300\" style=\"background: #ffffff; padding: 56px 56px 56px 56px;\">  <img src=\"https://www.aerocivil.gov.co/Logos%20encabezado%20master/logo-aeronautica.svg\" width=\"321\"/> </td> </tr> <tr><td> {cuerpo} </td> </tr> </table>','omar','2022-06-09 23:09:46','manual');
/*!40000 ALTER TABLE `formato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo` (
  `id_grupo` int NOT NULL AUTO_INCREMENT,
  `id` int NOT NULL COMMENT 'Indice de referencia de la base de datos',
  `esquema` varchar(16) NOT NULL COMMENT 'Esquema base datos',
  `tabla` varchar(32) NOT NULL COMMENT 'Tabla base de datos',
  `largo_maximo` int DEFAULT '1048576' COMMENT 'Largo del archivo a ser procesado (bytes)',
  `extensiones` varchar(128) DEFAULT 'jpg, png' COMMENT 'Extensiones que el sistema permite ingresar',
  `ancho` int NOT NULL DEFAULT '0' COMMENT 'Ancho maximo de las imagenes',
  `alto` int NOT NULL DEFAULT '0' COMMENT 'alto maximo de las imagenes',
  `maximo_archivo` int DEFAULT '1',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_grupo`),
  KEY `grupo_id_IDX` (`id`,`esquema`,`tabla`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` (`id_grupo`, `id`, `esquema`, `tabla`, `largo_maximo`, `extensiones`, `ancho`, `alto`, `maximo_archivo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (90,19,'Manifiesto','Usuario',8290304,'xlsx, xls',1000,100,5,'aerocivil','2023-02-23 03:50:48','http://localhost:7101'),(91,19,'manifiesto','manifiesto',-1024,'pdf,',1900,1080,-1,'aerocivil','2023-03-04 16:54:43','/Manifiesto-001');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion`
--

LOCK TABLES `informacion` WRITE;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `informacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion`
--

DROP TABLE IF EXISTS `notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion` (
  `id_notificacion` int NOT NULL AUTO_INCREMENT,
  `id_formato` int NOT NULL COMMENT 'Id Formato de envio',
  `id_servicio` int NOT NULL,
  `titulo` varchar(256) DEFAULT NULL COMMENT 'Titulo de la notificacion',
  `contenido` varchar(4096) NOT NULL COMMENT 'Nombre de la información a relatar',
  `direccion_envio` varchar(256) NOT NULL COMMENT 'SMS, correo, direccion dispositivo; etc.',
  `estado` varchar(8) NOT NULL COMMENT 'Estado del envio; P=pendiente, T=Terminado, E=Error',
  `anular` varchar(8) NOT NULL COMMENT 'Si el correo sera anulado S=Si, N=No',
  `fecha_envio` datetime NOT NULL COMMENT 'Fecha de envio',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_notificacion`),
  KEY `notificacion_FK` (`id_formato`),
  KEY `notificacion_estado_IDX` (`estado`,`fecha_envio`) USING BTREE,
  KEY `notificacion_FK_1` (`id_servicio`),
  CONSTRAINT `notificacion_FK` FOREIGN KEY (`id_formato`) REFERENCES `formato` (`id_formato`),
  CONSTRAINT `notificacion_FK_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
INSERT INTO `notificacion` (`id_notificacion`, `id_formato`, `id_servicio`, `titulo`, `contenido`, `direccion_envio`, `estado`, `anular`, `fecha_envio`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (22,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 02:56:23','Pendiente','2022-06-14 02:56:23','/Login-001'),(23,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:04:13','Pendiente','2022-06-14 03:04:13','/Login-001'),(24,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:08:46','Pendiente','2022-06-14 03:08:46','/Login-001'),(25,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:12:20','Pendiente','2022-06-14 03:12:20','/Login-001'),(26,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:16:22','Pendiente','2022-06-14 03:16:22','/Login-001'),(27,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 03:29:03','Pendiente','2022-06-14 03:29:03','/Login-001'),(28,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 03:33:51','Pendiente','2022-06-14 03:33:51','/Login-001'),(29,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 20:50:34','Pendiente','2022-06-14 20:50:35','/Login-001'),(30,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 21:23:08','Pendiente','2022-06-14 21:23:08','/Login-001'),(31,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 21:38:15','Pendiente','2022-06-14 21:38:16','/Login-001'),(32,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','OK','N','2022-06-14 21:40:21','omar78','2022-06-14 21:40:23','/Administrativo-001'),(33,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 22:11:49','omar78','2022-06-14 22:11:49','/Login-001'),(34,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','OK','N','2022-06-14 22:26:52','omar78','2022-06-14 22:26:52','/Administrativo-001'),(35,1,1,'Se ha restablecido la clave','****','omargo33@gmail.com','OK','S','2022-06-14 22:39:04','admin','2022-06-14 22:39:04','/Login-001'),(36,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>aerocivil</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@gmail.com','OK','N','2022-06-14 22:41:17','aerocivil','2022-06-14 22:41:18','/Administrativo-001'),(37,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-15 01:27:59','omar78','2022-06-15 01:27:59','/Login-001'),(38,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','OK','N','2022-06-15 01:36:05','omar78','2022-06-15 01:36:06','/Administrativo-001'),(39,1,1,'Se ha restablecido la clave','****','omargo@hotmail.com','OK','S','2022-07-14 04:24:03','admin','2022-07-14 04:24:03','/Login-001'),(40,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-09-05 02:05:04','omar78','2022-09-05 02:05:05','/Login-001'),(41,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-09-06 04:21:02','omar78','2022-09-06 04:21:03','/Login-001'),(42,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-09-06 05:17:46','omar78','2022-09-06 05:17:47','/Login-001'),(43,1,1,'titulo','body contenido','omargo33@hotmail.com','P','N','2023-03-16 05:49:37','usuario','2023-03-16 05:49:37','usuarioPrograma'),(44,1,1,'titulo','body contenido','omargo33@hotmail.com','P','N','2023-03-17 06:13:24','usuario','2023-03-17 06:13:24','usuarioPrograma'),(45,1,1,'titulo','body contenido','omargo33@hotmail.com','P','N','2023-03-17 06:14:15','usuario','2023-03-17 06:14:15','usuarioPrograma'),(47,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>5pVEeh6a28</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','P','S','2023-03-18 23:50:31','omar78','2023-03-18 23:50:31','LG_001_00'),(48,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>xtMMpnCUYW</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','P','S','2023-03-19 02:12:41','omar78','2023-03-19 02:12:42','LG_001_00'),(49,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>FMK7my66ZT</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','P','S','2023-03-19 21:19:36','omar78','2023-03-19 21:19:36','LG_001_10-1.0.0'),(50,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>fD47Aj2g3N</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','P','S','2023-03-19 21:24:30','omar78','2023-03-19 21:24:30','LG_001_10-1.0.0');
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion_evento`
--

DROP TABLE IF EXISTS `notificacion_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion_evento` (
  `id_notificacion_evento` int NOT NULL AUTO_INCREMENT,
  `id_notificacion` int DEFAULT NULL,
  `informacion` varchar(512) NOT NULL COMMENT 'Informacion del evento',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de evento',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_notificacion_evento`),
  KEY `notificacion_evento_FK` (`id_notificacion`),
  CONSTRAINT `notificacion_evento_FK` FOREIGN KEY (`id_notificacion`) REFERENCES `notificacion` (`id_notificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion_evento`
--

LOCK TABLES `notificacion_evento` WRITE;
/*!40000 ALTER TABLE `notificacion_evento` DISABLE KEYS */;
INSERT INTO `notificacion_evento` (`id_notificacion_evento`, `id_notificacion`, `informacion`, `tipo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (83,22,'Inicia el proceso','IP','Pendiente','2022-06-14 02:57:02','Notificaciones'),(84,22,'Tiene el siguiente error:javax.mail.MessagingException: Could not connect to SMTP host: 204.93.178.46, port: 465, response: -1','KO','Pendiente','2022-06-14 02:59:48','Notificaciones'),(85,23,'Inicia el proceso','IP','Pendiente','2022-06-14 03:05:02','Notificaciones'),(86,23,'Tiene el siguiente error:javax.mail.AuthenticationFailedException: 535 Incorrect authentication data\n','KO','Pendiente','2022-06-14 03:05:06','Notificaciones'),(87,24,'Inicia el proceso','IP','Pendiente','2022-06-14 03:09:02','Notificaciones'),(88,24,'Tiene el siguiente error:javax.mail.AuthenticationFailedException: 535 Incorrect authentication data\n','KO','Pendiente','2022-06-14 03:09:05','Notificaciones'),(89,25,'Inicia el proceso','IP','Pendiente','2022-06-14 03:13:02','Notificaciones'),(90,25,'Tiene el siguiente error:javax.mail.AuthenticationFailedException: 535 Incorrect authentication data\n','KO','Pendiente','2022-06-14 03:13:05','Notificaciones'),(91,26,'Inicia el proceso','IP','Pendiente','2022-06-14 03:17:02','Notificaciones'),(92,26,'Tiene el siguiente error:com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: localhost, 465; timeout -1;\n  nested exception is:\n	java.net.ConnectException: Conexión rehusada (Connection refused)','KO','Pendiente','2022-06-14 03:17:02','Notificaciones'),(93,27,'Inicia el proceso','IP','Pendiente','2022-06-14 03:30:02','Notificaciones'),(94,27,'Enviado','OK','Pendiente','2022-06-14 03:30:04','Notificaciones'),(95,28,'Inicia el proceso','IP','Pendiente','2022-06-14 03:34:02','Notificaciones'),(96,28,'Enviado','OK','Pendiente','2022-06-14 03:34:04','Notificaciones'),(97,29,'Inicia el proceso','IP','Pendiente','2022-06-14 20:51:02','Notificaciones'),(98,29,'Enviado','OK','Pendiente','2022-06-14 20:51:05','Notificaciones'),(99,30,'Inicia el proceso','IP','Pendiente','2022-06-14 21:24:02','Notificaciones'),(100,30,'Enviado','OK','Pendiente','2022-06-14 21:24:05','Notificaciones'),(101,31,'Inicia el proceso','IP','Pendiente','2022-06-14 21:39:02','Notificaciones'),(102,31,'Enviado','OK','Pendiente','2022-06-14 21:39:04','Notificaciones'),(103,32,'Inicia el proceso','IP','omar78','2022-06-14 21:41:02','Notificaciones'),(104,32,'Enviado','OK','omar78','2022-06-14 21:41:04','Notificaciones'),(105,33,'Inicia el proceso','IP','omar78','2022-06-14 22:12:02','Notificaciones'),(106,33,'Enviado','OK','omar78','2022-06-14 22:12:04','Notificaciones'),(107,34,'Inicia el proceso','IP','omar78','2022-06-14 22:27:02','Notificaciones'),(108,34,'Enviado','OK','omar78','2022-06-14 22:27:05','Notificaciones'),(109,35,'Inicia el proceso','IP','admin','2022-06-14 22:40:02','Notificaciones'),(110,35,'Enviado','OK','admin','2022-06-14 22:40:04','Notificaciones'),(111,36,'Inicia el proceso','IP','aerocivil','2022-06-14 22:42:02','Notificaciones'),(112,36,'Enviado','OK','aerocivil','2022-06-14 22:42:04','Notificaciones'),(113,37,'Inicia el proceso','IP','omar78','2022-06-15 01:35:02','Notificaciones'),(114,37,'Enviado','OK','omar78','2022-06-15 01:35:06','Notificaciones'),(115,38,'Inicia el proceso','IP','omar78','2022-06-15 01:37:02','Notificaciones'),(116,38,'Enviado','OK','omar78','2022-06-15 01:37:05','Notificaciones'),(117,39,'Inicia el proceso','IP','admin','2023-02-18 12:22:02','Notificaciones'),(118,39,'Enviado','OK','admin','2023-02-18 12:22:05','Notificaciones'),(119,40,'Inicia el proceso','IP','omar78','2023-02-18 12:22:05','Notificaciones'),(120,40,'Enviado','OK','omar78','2023-02-18 12:22:07','Notificaciones'),(121,41,'Inicia el proceso','IP','omar78','2023-02-18 12:22:07','Notificaciones'),(122,41,'Enviado','OK','omar78','2023-02-18 12:22:09','Notificaciones'),(123,42,'Inicia el proceso','IP','omar78','2023-02-18 12:22:09','Notificaciones'),(124,42,'Enviado','OK','omar78','2023-02-18 12:22:11','Notificaciones');
/*!40000 ALTER TABLE `notificacion_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion_parametro`
--

DROP TABLE IF EXISTS `notificacion_parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificacion_parametro` (
  `id_notificacion_parametro` int NOT NULL AUTO_INCREMENT,
  `id_notificacion` int DEFAULT NULL,
  `llave` varchar(64) NOT NULL COMMENT 'Llave del parametro ingresado',
  `valor` varchar(512) NOT NULL COMMENT 'Valor de la llave',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de parametro a ser usado (ADJ) archivo adjunto por ejemplo',
  PRIMARY KEY (`id_notificacion_parametro`),
  KEY `notificacion_parametro_FK` (`id_notificacion`),
  CONSTRAINT `notificacion_parametro_FK` FOREIGN KEY (`id_notificacion`) REFERENCES `notificacion` (`id_notificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion_parametro`
--

LOCK TABLES `notificacion_parametro` WRITE;
/*!40000 ALTER TABLE `notificacion_parametro` DISABLE KEYS */;
INSERT INTO `notificacion_parametro` (`id_notificacion_parametro`, `id_notificacion`, `llave`, `valor`, `tipo`) VALUES (48,22,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(49,22,'hora','2022-06-13 21:56:23','P'),(50,22,'ip','127.0.0.1','P'),(51,23,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(52,23,'hora','2022-06-13 22:04:13','P'),(53,23,'ip','127.0.0.1','P'),(54,24,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(55,24,'hora','2022-06-13 22:08:45','P'),(56,24,'ip','127.0.0.1','P'),(57,25,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(58,25,'hora','2022-06-13 22:12:19','P'),(59,25,'ip','127.0.0.1','P'),(60,26,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(61,26,'hora','2022-06-13 22:16:22','P'),(62,26,'ip','127.0.0.1','P'),(63,27,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(64,27,'hora','2022-06-13 22:29:02','P'),(65,27,'ip','127.0.0.1','P'),(66,28,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(67,28,'hora','2022-06-13 22:33:50','P'),(68,28,'ip','127.0.0.1','P'),(69,29,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(70,29,'hora','2022-06-14 15:50:34','P'),(71,29,'ip','127.0.0.1','P'),(72,30,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(73,30,'hora','2022-06-14 16:23:07','P'),(74,30,'ip','192.168.1.7','P'),(75,31,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(76,31,'hora','2022-06-14 16:38:15','P'),(77,31,'ip','192.168.1.7','P'),(78,32,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(79,32,'hora','2022-06-14 16:40:21','P'),(80,32,'ip','192.168.1.7','P'),(81,33,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(82,33,'hora','2022-06-14 17:11:49','P'),(83,33,'ip','192.168.1.7','P'),(84,34,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(85,34,'hora','2022-06-14 17:26:51','P'),(86,34,'ip','192.168.1.7','P'),(87,35,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(88,35,'hora','2022-06-14 17:39:03','P'),(89,35,'ip','192.168.1.7','P'),(90,36,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(91,36,'hora','2022-06-14 17:41:17','P'),(92,36,'ip','192.168.1.7','P'),(93,37,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(94,37,'hora','2022-06-14 20:27:58','P'),(95,37,'ip','127.0.0.1','P'),(96,38,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(97,38,'hora','2022-06-14 20:36:05','P'),(98,38,'ip','192.168.1.7','P'),(99,39,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Safari/537.36','P'),(100,39,'hora','2022-07-13 23:24:03','P'),(101,39,'ip','127.0.0.1','P'),(102,40,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.79 Safari/537.36','P'),(103,40,'hora','2022-09-04 21:05:03','P'),(104,40,'ip','127.0.0.1','P'),(105,41,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.79 Safari/537.36','P'),(106,41,'hora','2022-09-05 23:21:02','P'),(107,41,'ip','127.0.0.1','P'),(108,42,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.79 Safari/537.36','P'),(109,42,'hora','2022-09-06 00:17:46','P'),(110,42,'ip','127.0.0.1','P'),(111,47,'dispositivo','vscode-restclient','P'),(112,47,'hora','2023-03-18 18:50:30','P'),(113,47,'ip','127.0.0.1 127.0.0.1:51874','P'),(114,48,'dispositivo','vscode-restclient','P'),(115,48,'hora','2023-03-19 02:12:41','P'),(116,48,'ip','192.168.1.2 192.168.1.2:52600','P'),(117,49,'dispositivo','Dart/2.19 (dart:io)','P'),(118,49,'hora','2023-03-19 21:19:35','P'),(119,49,'ip','192.168.1.2 192.168.1.2:49024','P'),(120,50,'dispositivo','Dart/2.19 (dart:io)','P'),(121,50,'hora','2023-03-19 21:24:29','P'),(122,50,'ip','192.168.1.2 192.168.1.2:52206','P');
/*!40000 ALTER TABLE `notificacion_parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `id_servicio` int NOT NULL AUTO_INCREMENT,
  `indice` varchar(32) DEFAULT NULL,
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de informacion del servicio',
  `valor_01` varchar(512) NOT NULL COMMENT 'Valor 01',
  `valor_02` varchar(512) DEFAULT NULL COMMENT 'Valor 02',
  `tipo` varchar(8) DEFAULT NULL COMMENT 'Tipo de servicios, define si el servicio es: E=EMAIL, S=SMS, NM=notificacion  Movil, NW=notificacion web',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Configuracion del servicio';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` (`id_servicio`, `indice`, `nombre`, `valor_01`, `valor_02`, `tipo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,'TEST_E_01','Test de envio de correos hotmail','13a.usuario=facturacion@procesoelectronico.com 13a.clave=Fac%%001 13a.instancia.servidor=false 13a.acceso.ssl=true mail.smtp.host=smtp.gmail.com mail.smtp.port=465 mail.smtp.auth=true mail.smtp.starttls.enable=true mail.smtp.ssl.protocols=TLSv1.2 mail.smtp.socketFactory.port=465 mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory',NULL,'E','omar','2022-06-09 23:07:08','manual'),(2,'TEST_E_01','Test de envio de correos hotmail','13a.usuario=omargo33@hotmail.com 13a.clave=admin2483700 13a.instancia.servidor=true 13a.acceso.ssl=true mail.smtp.host=smtp.office365.com mail.smtp.post=587 mail.smtp.port=587 mail.smtp.auth=true mail.smtp.starttls.enable=true mail.smtp.ssl.protocols=TLSv1.2 mail.debug=false',NULL,'E','omar','2022-06-09 23:07:08','manual');
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'GA_001_00'
--

--
-- Dumping routines for database 'GA_001_00'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-19 23:28:38
