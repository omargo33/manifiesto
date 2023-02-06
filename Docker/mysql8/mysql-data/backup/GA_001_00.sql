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
) ENGINE=InnoDB AUTO_INCREMENT=378 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivo`
--

LOCK TABLES `archivo` WRITE;
/*!40000 ALTER TABLE `archivo` DISABLE KEYS */;
INSERT INTO `archivo` (`id_archivo`, `id_grupo`, `nombre_ramdon`, `nombre`, `extension`, `largo`, `path_relativo`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (327,53,'0-vUqAMv3T2jcD','manifiesto-manifiesto-2022-04-25-13-46-33.xls','application/x-ole-storage',10240,'MV_001_00/manifiesto/2022-04-25/0-vUqAMv3T2jcD','A','manifiesto','2022-04-25 13:46:33','/Manifiesto-001'),(328,54,'0-RMfxk26Fpdnp','manifiesto-manifiesto-2022-04-25-13-48-18.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/0-RMfxk26Fpdnp','A','manifiesto','2022-04-25 13:48:19','/Manifiesto-001'),(329,54,'54-eF4TKfMXC6C9','manifiesto-manifiesto-2022-04-25-13-48-40.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-eF4TKfMXC6C9','A','manifiesto','2022-04-25 13:48:40','/Manifiesto-001'),(330,54,'54-GBVXWadxwVDx','manifiesto-manifiesto-2022-04-25-13-49-08.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-GBVXWadxwVDx','A','manifiesto','2022-04-25 13:49:09','/Manifiesto-001'),(331,54,'54-RJW3KXQZeBC4','manifiesto-manifiesto-2022-04-25-13-50-01.xls','application/x-ole-storage',14848,'manifiesto/manifiesto/2022-04-25/54-RJW3KXQZeBC4','A','manifiesto','2022-04-25 13:50:02','/Manifiesto-001'),(332,54,'54-dxgzDrBaGEFp','manifiesto-manifiesto-2022-04-25-13-50-06.xls','application/x-ole-storage',14848,'manifiesto/manifiesto/2022-04-25/54-dxgzDrBaGEFp','A','manifiesto','2022-04-25 13:50:06','/Manifiesto-001'),(333,54,'54-94Kez7hjcgPr','manifiesto-manifiesto-2022-04-25-13-50-12.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-94Kez7hjcgPr','A','manifiesto','2022-04-25 13:50:13','/Manifiesto-001'),(334,54,'54-tPpVKqnyyfQy','manifiesto-manifiesto-2022-04-25-13-50-50.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-tPpVKqnyyfQy','A','manifiesto','2022-04-25 13:50:51','/Manifiesto-001'),(335,54,'54-X3NJjtdYK7AA','manifiesto-manifiesto-2022-04-25-13-51-13.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-X3NJjtdYK7AA','A','manifiesto','2022-04-25 13:51:13','/Manifiesto-001'),(336,54,'54-3j5ri3Xrf3fW','manifiesto-manifiesto-2022-04-25-13-58-02.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-3j5ri3Xrf3fW','A','manifiesto','2022-04-25 13:58:02','/Manifiesto-001'),(337,54,'54-B6dXQifujQUc','manifiesto-manifiesto-2022-04-25-16-55-25.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-B6dXQifujQUc','A','manifiesto','2022-04-25 16:55:27','/Manifiesto-001'),(338,54,'54-WcFC8rDZB5MT','manifiesto-manifiesto-2022-04-25-16-55-32.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-WcFC8rDZB5MT','A','manifiesto','2022-04-25 16:55:32','/Manifiesto-001'),(339,54,'54-8dt84tweV7uf','manifiesto-manifiesto-2022-04-25-16-55-33.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-8dt84tweV7uf','A','manifiesto','2022-04-25 16:55:34','/Manifiesto-001'),(340,54,'54-eNcMfre4VHW7','manifiesto-manifiesto-2022-04-25-16-55-39.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-eNcMfre4VHW7','A','manifiesto','2022-04-25 16:55:40','/Manifiesto-001'),(341,54,'54-kw8nRCaEwUZH','manifiesto-manifiesto-2022-04-25-16-59-16.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-kw8nRCaEwUZH','A','manifiesto','2022-04-25 16:59:17','/Manifiesto-001'),(342,54,'54-q975MbWUnCit','manifiesto-manifiesto-2022-04-25-17-05-22.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-q975MbWUnCit','A','manifiesto','2022-04-25 17:05:23','/Manifiesto-001'),(343,54,'54-iHGiuqMkP9jt','manifiesto-manifiesto-2022-04-25-17-10-35.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-iHGiuqMkP9jt','A','manifiesto','2022-04-25 17:10:37','/Manifiesto-001'),(344,54,'54-vCt82a5GBAbC','manifiesto-manifiesto-2022-04-25-17-13-28.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-vCt82a5GBAbC','A','manifiesto','2022-04-25 17:13:28','/Manifiesto-001'),(345,54,'54-CydaEGa4abce','manifiesto-manifiesto-2022-04-25-17-19-13.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-CydaEGa4abce','A','manifiesto','2022-04-25 17:19:15','/Manifiesto-001'),(346,54,'54-VAHt2PWuezjd','manifiesto-manifiesto-2022-04-25-17-44-14.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-VAHt2PWuezjd','A','manifiesto','2022-04-25 17:44:16','/Manifiesto-001'),(347,54,'54-GriPK4NCCvYA','manifiesto-manifiesto-2022-04-25-17-44-31.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-GriPK4NCCvYA','A','manifiesto','2022-04-25 17:44:31','/Manifiesto-001'),(348,54,'54-zcjd393W5ZhK','manifiesto-manifiesto-2022-04-25-17-45-11.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/54-zcjd393W5ZhK','A','manifiesto','2022-04-25 17:45:11','/Manifiesto-001'),(349,56,'0-YpPeJj5hiBVi','manifiesto-truiz-2022-04-25-17-59-36.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/0-YpPeJj5hiBVi','A','truiz','2022-04-25 17:59:38','/Manifiesto-001'),(350,58,'0-eKMXyavUEveG','manifiesto-admin-2022-04-25-18-43-15.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/0-eKMXyavUEveG','A','admin','2022-04-25 18:43:16','/Manifiesto-001'),(351,59,'0-hWYQYNDnpVyB','manifiesto-aerocivil-2022-04-25-19-13-42.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/0-hWYQYNDnpVyB','A','aerocivil','2022-04-25 19:13:44','/Manifiesto-001'),(352,59,'59-gcq9rQrZViHh','manifiesto-aerocivil-2022-04-25-19-16-08.xls','application/x-ole-storage',10240,'manifiesto/manifiesto/2022-04-25/59-gcq9rQrZViHh','A','aerocivil','2022-04-25 19:16:09','/Manifiesto-001'),(353,54,'54-n22AxKdKdyq5','manifiesto-manifiesto-2022-04-27-00-26-03.xls','application/x-ole-storage',8192,'manifiesto/manifiesto/2022-04-27/54-n22AxKdKdyq5','A','manifiesto','2022-04-27 05:26:05','/Manifiesto-001'),(354,54,'54-PJ2yjwjy8dqC','manifiesto-manifiesto-2022-04-27-00-40-21.xls','application/x-ole-storage',11776,'manifiesto/manifiesto/2022-04-27/54-PJ2yjwjy8dqC','A','manifiesto','2022-04-27 05:40:22','/Manifiesto-001'),(355,58,'58-TzdP7KFjZbNe','manifiesto-admin-2022-04-27-00-41-25.xls','application/x-ole-storage',12800,'manifiesto/manifiesto/2022-04-27/58-TzdP7KFjZbNe','A','admin','2022-04-27 05:41:26','/Manifiesto-001'),(356,58,'58-DubmtGjByYe3','manifiesto-admin-2022-04-27-01-09-07.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2022-04-27/58-DubmtGjByYe3','A','admin','2022-04-27 06:09:08','/Manifiesto-001'),(357,54,'54-BND7jcKGtxT8','manifiesto-manifiesto-2022-04-27-01-09-57.xls','application/x-ole-storage',8192,'manifiesto/manifiesto/2022-04-27/54-BND7jcKGtxT8','A','manifiesto','2022-04-27 06:09:58','/Manifiesto-001'),(358,59,'59-jQGRhiPnEaH8','manifiesto-aerocivil-2022-06-23-21-21-51.xls','application/x-ole-storage',6656,'manifiesto/manifiesto/2022-06-23/59-jQGRhiPnEaH8','A','aerocivil','2022-06-24 02:21:53','/Manifiesto-001'),(359,72,'72-XyG6N8H9cgM3','virtual-box-for-dummies-ebook-spl.pdf','application/pdf',3960753,'Manifiesto/ManifiestoUsuario/2022-07-01/72-XyG6N8H9cgM3','A','aerocivil','2022-07-01 20:46:35','/faces/Upload'),(360,73,'73-9895g8HRjgUt','virtual-box-for-dummies-ebook-spl.pdf','application/pdf',3960753,'Manifiesto/ManifiestoUsuario/2022-07-01/73-9895g8HRjgUt','A','aerocivil','2022-07-01 20:47:45','/faces/Upload'),(361,59,'59-kc2um7WzeZkw','manifiesto-aerocivil-2022-11-27-18-04-32.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2022-11-27/59-kc2um7WzeZkw','A','aerocivil','2022-11-27 23:04:34','/Manifiesto-001'),(362,59,'59-2UDBKDph72c4','manifiesto-aerocivil-2022-11-27-18-10-44.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2022-11-27/59-2UDBKDph72c4','A','aerocivil','2022-11-27 23:10:44','/Manifiesto-001'),(363,59,'59-mVyuxjaXuEtd','manifiesto-aerocivil-2022-11-27-18-18-06.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2022-11-27/59-mVyuxjaXuEtd','A','aerocivil','2022-11-27 23:18:08','/Manifiesto-001'),(364,75,'75-pMRhKJJUqz82','Pago de Matriculación Vehicular.pdf','application/pdf',138122,'Manifiesto/ManifiestoUsuario/2022-11-27/75-pMRhKJJUqz82','X','aerocivil','2022-11-27 23:19:52','/faces/Upload'),(365,75,'75-E6PXRtDnTygj','QAPAQ_LOGO _oct_2022.pdf','application/pdf',8040173,'Manifiesto/ManifiestoUsuario/2022-11-27/75-E6PXRtDnTygj','X','aerocivil','2022-11-27 23:20:59','/faces/Upload'),(366,76,'0-pWejWvCDfcDC','manifiesto-joy-2022-11-27-18-44-36.xls','application/x-ole-storage',5632,'manifiesto/manifiesto/2022-11-27/0-pWejWvCDfcDC','A','joy','2022-11-27 23:44:37','/Manifiesto-001'),(367,76,'76-vZAUWnVFuFH8','manifiesto-joy-2022-11-27-18-44-46.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2022-11-27/76-vZAUWnVFuFH8','A','joy','2022-11-27 23:44:46','/Manifiesto-001'),(368,75,'75-BqRP3JQpCXQq','QAPAQ_LOGO _oct_2022.pdf','application/pdf',8040173,'Manifiesto/ManifiestoUsuario/2022-11-27/75-BqRP3JQpCXQq','X','joy','2022-11-27 23:54:21','/faces/Upload'),(369,76,'76-6x2P9Ga94jd8','manifiesto-joy-2022-11-27-18-54-44.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2022-11-27/76-6x2P9Ga94jd8','A','joy','2022-11-27 23:54:45','/Manifiesto-001'),(370,76,'76-8Y3RGziQmexu','manifiesto-joy-2022-11-27-18-55-17.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2022-11-27/76-8Y3RGziQmexu','A','joy','2022-11-27 23:55:17','/Manifiesto-001'),(371,76,'76-QuF4HrPeuy93','manifiesto-joy-2022-11-27-18-55-46.xls','application/x-ole-storage',7168,'manifiesto/manifiesto/2022-11-27/76-QuF4HrPeuy93','A','joy','2022-11-27 23:55:46','/Manifiesto-001'),(372,76,'76-pjUj5HVmHkRz','manifiesto-joy-2022-11-27-18-58-58.xls','application/x-ole-storage',7168,'manifiesto/manifiesto/2022-11-27/76-pjUj5HVmHkRz','A','joy','2022-11-27 23:58:59','/Manifiesto-001'),(373,76,'76-aJ3wQEi9egN2','manifiesto-joy-2022-11-27-19-02-15.xls','application/x-ole-storage',7168,'manifiesto/manifiesto/2022-11-27/76-aJ3wQEi9egN2','A','joy','2022-11-28 00:02:15','/Manifiesto-001'),(374,75,'75-tgJbmd6UqvtV','QAPAQ_LOGO _oct_2022.pdf','application/pdf',8040173,'Manifiesto/ManifiestoUsuario/2022-11-27/75-tgJbmd6UqvtV','A','joy','2022-11-28 00:03:08','/faces/Upload'),(375,76,'76-MNZ8eqQtFpRn','manifiesto-joy-2022-11-27-19-03-40.xls','application/x-ole-storage',7168,'manifiesto/manifiesto/2022-11-27/76-MNZ8eqQtFpRn','A','joy','2022-11-28 00:03:41','/Manifiesto-001'),(376,59,'59-8XBKd9VGq5GR','manifiesto-aerocivil-2023-02-01-21-27-55.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2023-02-01/59-8XBKd9VGq5GR','A','aerocivil','2023-02-02 02:27:57','/Manifiesto-001'),(377,59,'59-WggvRYCpwfez','manifiesto-aerocivil-2023-02-01-21-29-55.xls','application/x-ole-storage',9216,'manifiesto/manifiesto/2023-02-01/59-WggvRYCpwfez','A','aerocivil','2023-02-02 02:29:55','/Manifiesto-001');
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
  `tipo` varchar(8) NOT NULL COMMENT 'I=in O=out X=eliminado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_archivo_evento`),
  KEY `archivo_evento_FK` (`id_archivo`),
  CONSTRAINT `archivo_evento_FK` FOREIGN KEY (`id_archivo`) REFERENCES `archivo` (`id_archivo`)
) ENGINE=InnoDB AUTO_INCREMENT=299 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivo_evento`
--

LOCK TABLES `archivo_evento` WRITE;
/*!40000 ALTER TABLE `archivo_evento` DISABLE KEYS */;
INSERT INTO `archivo_evento` (`id_archivo_evento`, `id_archivo`, `informacion`, `tipo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (219,327,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:46:34','/Manifiesto-001'),(220,328,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:48:19','/Manifiesto-001'),(221,329,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:48:40','/Manifiesto-001'),(222,330,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:49:09','/Manifiesto-001'),(223,329,'Descarga de elemento','D','manifiesto','2022-04-25 13:49:13','/faces/Download'),(224,328,'Descarga de elemento','D','manifiesto','2022-04-25 13:49:17','/faces/Download'),(225,331,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:50:02','/Manifiesto-001'),(226,332,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:50:06','/Manifiesto-001'),(227,333,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:50:13','/Manifiesto-001'),(228,334,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:50:51','/Manifiesto-001'),(229,335,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:51:13','/Manifiesto-001'),(230,336,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 13:58:02','/Manifiesto-001'),(231,337,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 16:55:27','/Manifiesto-001'),(232,338,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 16:55:32','/Manifiesto-001'),(233,339,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 16:55:34','/Manifiesto-001'),(234,340,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 16:55:40','/Manifiesto-001'),(235,341,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 16:59:18','/Manifiesto-001'),(236,342,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 17:05:23','/Manifiesto-001'),(237,343,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 17:10:37','/Manifiesto-001'),(238,344,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 17:13:28','/Manifiesto-001'),(239,345,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 17:19:15','/Manifiesto-001'),(240,346,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 17:44:16','/Manifiesto-001'),(241,346,'Descarga de elemento','D','manifiesto','2022-04-25 17:44:18','/faces/Download'),(242,347,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 17:44:31','/Manifiesto-001'),(243,348,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-25 17:45:11','/Manifiesto-001'),(244,348,'Descarga de elemento','D','manifiesto','2022-04-25 17:45:13','/faces/Download'),(245,349,'Archivo Generado al solicitar un reporte','C','truiz','2022-04-25 17:59:38','/Manifiesto-001'),(246,349,'Descarga de elemento','D','truiz','2022-04-25 17:59:41','/faces/Download'),(247,350,'Archivo Generado al solicitar un reporte','C','admin','2022-04-25 18:43:16','/Manifiesto-001'),(248,350,'Descarga de elemento','D','admin','2022-04-25 18:43:19','/faces/Download'),(249,351,'Archivo Generado al solicitar un reporte','C','aerocivil','2022-04-25 19:13:44','/Manifiesto-001'),(250,351,'Descarga de elemento','D','aerocivil','2022-04-25 19:13:46','/faces/Download'),(251,352,'Archivo Generado al solicitar un reporte','C','aerocivil','2022-04-25 19:16:09','/Manifiesto-001'),(252,352,'Descarga de elemento','D','aerocivil','2022-04-25 19:16:11','/faces/Download'),(253,353,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-27 05:26:05','/Manifiesto-001'),(254,354,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-27 05:40:22','/Manifiesto-001'),(255,354,'Descarga de elemento','D','manifiesto','2022-04-27 05:40:24','/faces/Download'),(256,355,'Archivo Generado al solicitar un reporte','C','admin','2022-04-27 05:41:26','/Manifiesto-001'),(257,355,'Descarga de elemento','D','admin','2022-04-27 05:41:28','/faces/Download'),(258,356,'Archivo Generado al solicitar un reporte','C','admin','2022-04-27 06:09:08','/Manifiesto-001'),(259,356,'Descarga de elemento','D','admin','2022-04-27 06:09:10','/faces/Download'),(260,357,'Archivo Generado al solicitar un reporte','C','manifiesto','2022-04-27 06:09:58','/Manifiesto-001'),(261,357,'Descarga de elemento','D','manifiesto','2022-04-27 06:09:59','/faces/Download'),(262,358,'Archivo Generado al solicitar un reporte','C','aerocivil','2022-06-24 02:21:53','/Manifiesto-001'),(263,358,'Descarga de elemento','D','aerocivil','2022-06-24 02:21:55','/faces/Download'),(264,359,'Archivo Creado desde elemento base','C','aerocivil','2022-07-01 20:46:35','/faces/Upload'),(265,359,'Descarga de elemento','D','aerocivil','2022-07-01 20:46:52','/faces/Download'),(266,360,'Archivo Creado desde elemento base','C','aerocivil','2022-07-01 20:47:45','/faces/Upload'),(267,361,'Archivo Generado al solicitar un reporte','C','aerocivil','2022-11-27 23:04:34','/Manifiesto-001'),(268,361,'Descarga de elemento','D','aerocivil','2022-11-27 23:04:36','/faces/Download'),(269,361,'Descarga de elemento','D','aerocivil','2022-11-27 23:04:36','/faces/Download'),(270,362,'Archivo Generado al solicitar un reporte','C','aerocivil','2022-11-27 23:10:44','/Manifiesto-001'),(271,362,'Descarga de elemento','D','aerocivil','2022-11-27 23:10:46','/faces/Download'),(272,363,'Archivo Generado al solicitar un reporte','C','aerocivil','2022-11-27 23:18:08','/Manifiesto-001'),(273,363,'Descarga de elemento','D','aerocivil','2022-11-27 23:18:09','/faces/Download'),(274,364,'Archivo Creado desde elemento base','C','aerocivil','2022-11-27 23:19:52','/faces/Upload'),(275,364,'Descarga de elemento','D','aerocivil','2022-11-27 23:20:00','/faces/Download'),(276,365,'Archivo Creado desde elemento base','C','aerocivil','2022-11-27 23:20:59','/faces/Upload'),(277,365,'Descarga de elemento','D','aerocivil','2022-11-27 23:21:08','/faces/Download'),(278,366,'Archivo Generado al solicitar un reporte','C','joy','2022-11-27 23:44:38','/Manifiesto-001'),(279,367,'Archivo Generado al solicitar un reporte','C','joy','2022-11-27 23:44:46','/Manifiesto-001'),(280,367,'Descarga de elemento','D','joy','2022-11-27 23:44:48','/faces/Download'),(281,368,'Archivo Creado desde elemento base','C','joy','2022-11-27 23:54:21','/faces/Upload'),(282,368,'Descarga de elemento','D','joy','2022-11-27 23:54:29','/faces/Download'),(283,369,'Archivo Generado al solicitar un reporte','C','joy','2022-11-27 23:54:45','/Manifiesto-001'),(284,369,'Descarga de elemento','D','joy','2022-11-27 23:55:05','/faces/Download'),(285,370,'Archivo Generado al solicitar un reporte','C','joy','2022-11-27 23:55:17','/Manifiesto-001'),(286,370,'Descarga de elemento','D','joy','2022-11-27 23:55:19','/faces/Download'),(287,371,'Archivo Generado al solicitar un reporte','C','joy','2022-11-27 23:55:46','/Manifiesto-001'),(288,371,'Descarga de elemento','D','joy','2022-11-27 23:55:52','/faces/Download'),(289,372,'Archivo Generado al solicitar un reporte','C','joy','2022-11-27 23:58:59','/Manifiesto-001'),(290,372,'Descarga de elemento','D','joy','2022-11-27 23:59:00','/faces/Download'),(291,373,'Archivo Generado al solicitar un reporte','C','joy','2022-11-28 00:02:16','/Manifiesto-001'),(292,373,'Descarga de elemento','D','joy','2022-11-28 00:02:17','/faces/Download'),(293,374,'Archivo Creado desde elemento base','C','joy','2022-11-28 00:03:08','/faces/Upload'),(294,374,'Descarga de elemento','D','joy','2022-11-28 00:03:17','/faces/Download'),(295,375,'Archivo Generado al solicitar un reporte','C','joy','2022-11-28 00:03:41','/Manifiesto-001'),(296,375,'Descarga de elemento','D','joy','2022-11-28 00:03:42','/faces/Download'),(297,376,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-02-02 02:27:57','/Manifiesto-001'),(298,377,'Archivo Generado al solicitar un reporte','C','aerocivil','2023-02-02 02:29:55','/Manifiesto-001');
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` (`id_grupo`, `id`, `esquema`, `tabla`, `largo_maximo`, `extensiones`, `ancho`, `alto`, `maximo_archivo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (53,18,'MV_001_00','manifiesto',-1024,'xls, xlsx,',1900,1080,-1,'manifiesto','2022-04-25 13:46:33','/Manifiesto-001'),(54,18,'manifiesto','manifiesto',-1024,'xls, xlsx,',1900,1080,-1,'manifiesto','2022-04-25 13:48:19','/Manifiesto-001'),(55,12,'test','test',8192,'pdf, pdf,',1024,1024,5,'manual','2022-04-25 17:41:33','programa'),(56,20,'manifiesto','manifiesto',-1024,'xls, xlsx,',1900,1080,-1,'truiz','2022-04-25 17:59:38','/Manifiesto-001'),(57,17,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'truiz','2022-04-25 17:59:57','http://192.168.1.7:28083'),(58,13,'manifiesto','manifiesto',-1024,'xls, xlsx,',1900,1080,-1,'admin','2022-04-25 18:43:16','/Manifiesto-001'),(59,19,'manifiesto','manifiesto',-1024,'xls, xlsx,',1900,1080,-1,'aerocivil','2022-04-25 19:13:44','/Manifiesto-001'),(60,14,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-04-25 19:16:27','http://192.168.1.7:28083'),(61,0,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'manifiesto','2022-04-27 04:57:57','http://192.168.1.7:7101'),(62,18,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'manifiesto','2022-04-27 04:58:35','http://192.168.1.7:7101'),(63,13,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'admin','2022-04-27 06:08:56','http://192.168.1.7:28083'),(64,16,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'admin','2022-06-07 04:09:22','http://192.168.1.7:7101'),(65,1,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'admin','2022-06-08 05:09:20','http://192.168.1.7:7101'),(66,6,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'admin','2022-06-08 05:09:39','http://192.168.1.7:7101'),(67,4,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'admin','2022-06-08 05:17:17','http://192.168.1.7:7101'),(68,10,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-06-17 00:06:29','http://192.168.1.7:7101'),(69,19,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-06-17 17:13:44','http://192.168.1.7:7101'),(70,20,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-06-24 21:09:24','http://192.168.1.7:7101'),(71,21,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-07-01 02:16:13','http://192.168.1.7:7101'),(72,22,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-07-01 02:18:12','http://192.168.1.7:7101'),(73,23,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-07-01 20:47:33','http://192.168.1.7:28083'),(74,24,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-07-08 02:43:31','http://192.168.1.7:7101'),(75,25,'Manifiesto','ManifiestoUsuario',8290304,'pdf, doc, docx',1000,100,1,'aerocivil','2022-07-08 06:52:20','http://192.168.1.7:7101'),(76,17,'manifiesto','manifiesto',-1024,'xls, xlsx,',1900,1080,-1,'joy','2022-11-27 23:44:37','/Manifiesto-001');
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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
INSERT INTO `notificacion` (`id_notificacion`, `id_formato`, `id_servicio`, `titulo`, `contenido`, `direccion_envio`, `estado`, `anular`, `fecha_envio`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (22,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 02:56:23','Pendiente','2022-06-14 02:56:23','/Login-001'),(23,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:04:13','Pendiente','2022-06-14 03:04:13','/Login-001'),(24,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:08:46','Pendiente','2022-06-14 03:08:46','/Login-001'),(25,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:12:20','Pendiente','2022-06-14 03:12:20','/Login-001'),(26,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','KO','S','2022-06-14 03:16:22','Pendiente','2022-06-14 03:16:22','/Login-001'),(27,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 03:29:03','Pendiente','2022-06-14 03:29:03','/Login-001'),(28,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 03:33:51','Pendiente','2022-06-14 03:33:51','/Login-001'),(29,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 20:50:34','Pendiente','2022-06-14 20:50:35','/Login-001'),(30,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 21:23:08','Pendiente','2022-06-14 21:23:08','/Login-001'),(31,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 21:38:15','Pendiente','2022-06-14 21:38:16','/Login-001'),(32,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','OK','N','2022-06-14 21:40:21','omar78','2022-06-14 21:40:23','/Administrativo-001'),(33,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-14 22:11:49','omar78','2022-06-14 22:11:49','/Login-001'),(34,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','OK','N','2022-06-14 22:26:52','omar78','2022-06-14 22:26:52','/Administrativo-001'),(35,1,1,'Se ha restablecido la clave','****','omargo33@gmail.com','OK','S','2022-06-14 22:39:04','admin','2022-06-14 22:39:04','/Login-001'),(36,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>aerocivil</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@gmail.com','OK','N','2022-06-14 22:41:17','aerocivil','2022-06-14 22:41:18','/Administrativo-001'),(37,1,1,'Se ha restablecido la clave','****','omargo33@hotmail.com','OK','S','2022-06-15 01:27:59','omar78','2022-06-15 01:27:59','/Login-001'),(38,1,1,'Se ha cambiado la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin: 0 auto; padding: 0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta fue <strong>cambiada de forma exitosa</strong>. </td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','OK','N','2022-06-15 01:36:05','omar78','2022-06-15 01:36:06','/Administrativo-001'),(39,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>admin</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>RHTV5QwY</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo@hotmail.com','P','S','2022-07-14 04:24:03','admin','2022-07-14 04:24:03','/Login-001'),(40,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>dHPJjVg3</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','P','S','2022-09-05 02:05:04','omar78','2022-09-05 02:05:05','/Login-001'),(41,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>UgvmctMc</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','P','S','2022-09-06 04:21:02','omar78','2022-09-06 04:21:03','/Login-001'),(42,1,1,'Se ha restablecido la clave','<table border=\"0\" cellpadding=\"0\" align=\"center\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;padding:0\"><tbody><tr><td align=\"center\" bgcolor=\"#ffffff\" width=\"600\" style=\"background: #fff; padding: 0 56px; width: 100%\"><table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\"><tbody><tr><td style=\"padding: 0 0 20px 0\">Estimado/a <strong>omar78</strong>: </td></tr><tr><td style=\"padding: 0 0 20px 0\">La clave de su Cuenta ha cambiado por: </td></tr><tr><td style=\"padding: 0 0 20px 0\"><strong>q3BkyZat</strong></td></tr><tr><td style=\"padding: 0 0 4px 0\">Recuerde que su seguridad es importante y el uso de su clave es estrictamente personal </td></tr><tr><td style=\"padding: 0 0 20px 0\">No olvide cambiar la misma una vez ingresado al sistema </td></tr><tr><td style=\"padding: 0 0 20px 0\">Para acceder a su cuenta puede hacer clic en: <a href=\"http://192.168.1.7:28080/Login-001/faces/Home.jspx\" target=\"_blank\">Ingreso al sitio</a>. </td></tr><tr><td style=\"padding: 0\">Gracias<br /></td></tr></tbody></table></td></tr></tbody></table>','omargo33@hotmail.com','P','S','2022-09-06 05:17:46','omar78','2022-09-06 05:17:47','/Login-001');
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
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion_evento`
--

LOCK TABLES `notificacion_evento` WRITE;
/*!40000 ALTER TABLE `notificacion_evento` DISABLE KEYS */;
INSERT INTO `notificacion_evento` (`id_notificacion_evento`, `id_notificacion`, `informacion`, `tipo`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (83,22,'Inicia el proceso','IP','Pendiente','2022-06-14 02:57:02','Notificaciones'),(84,22,'Tiene el siguiente error:javax.mail.MessagingException: Could not connect to SMTP host: 204.93.178.46, port: 465, response: -1','KO','Pendiente','2022-06-14 02:59:48','Notificaciones'),(85,23,'Inicia el proceso','IP','Pendiente','2022-06-14 03:05:02','Notificaciones'),(86,23,'Tiene el siguiente error:javax.mail.AuthenticationFailedException: 535 Incorrect authentication data\n','KO','Pendiente','2022-06-14 03:05:06','Notificaciones'),(87,24,'Inicia el proceso','IP','Pendiente','2022-06-14 03:09:02','Notificaciones'),(88,24,'Tiene el siguiente error:javax.mail.AuthenticationFailedException: 535 Incorrect authentication data\n','KO','Pendiente','2022-06-14 03:09:05','Notificaciones'),(89,25,'Inicia el proceso','IP','Pendiente','2022-06-14 03:13:02','Notificaciones'),(90,25,'Tiene el siguiente error:javax.mail.AuthenticationFailedException: 535 Incorrect authentication data\n','KO','Pendiente','2022-06-14 03:13:05','Notificaciones'),(91,26,'Inicia el proceso','IP','Pendiente','2022-06-14 03:17:02','Notificaciones'),(92,26,'Tiene el siguiente error:com.sun.mail.util.MailConnectException: Couldn\'t connect to host, port: localhost, 465; timeout -1;\n  nested exception is:\n	java.net.ConnectException: Conexión rehusada (Connection refused)','KO','Pendiente','2022-06-14 03:17:02','Notificaciones'),(93,27,'Inicia el proceso','IP','Pendiente','2022-06-14 03:30:02','Notificaciones'),(94,27,'Enviado','OK','Pendiente','2022-06-14 03:30:04','Notificaciones'),(95,28,'Inicia el proceso','IP','Pendiente','2022-06-14 03:34:02','Notificaciones'),(96,28,'Enviado','OK','Pendiente','2022-06-14 03:34:04','Notificaciones'),(97,29,'Inicia el proceso','IP','Pendiente','2022-06-14 20:51:02','Notificaciones'),(98,29,'Enviado','OK','Pendiente','2022-06-14 20:51:05','Notificaciones'),(99,30,'Inicia el proceso','IP','Pendiente','2022-06-14 21:24:02','Notificaciones'),(100,30,'Enviado','OK','Pendiente','2022-06-14 21:24:05','Notificaciones'),(101,31,'Inicia el proceso','IP','Pendiente','2022-06-14 21:39:02','Notificaciones'),(102,31,'Enviado','OK','Pendiente','2022-06-14 21:39:04','Notificaciones'),(103,32,'Inicia el proceso','IP','omar78','2022-06-14 21:41:02','Notificaciones'),(104,32,'Enviado','OK','omar78','2022-06-14 21:41:04','Notificaciones'),(105,33,'Inicia el proceso','IP','omar78','2022-06-14 22:12:02','Notificaciones'),(106,33,'Enviado','OK','omar78','2022-06-14 22:12:04','Notificaciones'),(107,34,'Inicia el proceso','IP','omar78','2022-06-14 22:27:02','Notificaciones'),(108,34,'Enviado','OK','omar78','2022-06-14 22:27:05','Notificaciones'),(109,35,'Inicia el proceso','IP','admin','2022-06-14 22:40:02','Notificaciones'),(110,35,'Enviado','OK','admin','2022-06-14 22:40:04','Notificaciones'),(111,36,'Inicia el proceso','IP','aerocivil','2022-06-14 22:42:02','Notificaciones'),(112,36,'Enviado','OK','aerocivil','2022-06-14 22:42:04','Notificaciones'),(113,37,'Inicia el proceso','IP','omar78','2022-06-15 01:35:02','Notificaciones'),(114,37,'Enviado','OK','omar78','2022-06-15 01:35:06','Notificaciones'),(115,38,'Inicia el proceso','IP','omar78','2022-06-15 01:37:02','Notificaciones'),(116,38,'Enviado','OK','omar78','2022-06-15 01:37:05','Notificaciones');
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
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion_parametro`
--

LOCK TABLES `notificacion_parametro` WRITE;
/*!40000 ALTER TABLE `notificacion_parametro` DISABLE KEYS */;
INSERT INTO `notificacion_parametro` (`id_notificacion_parametro`, `id_notificacion`, `llave`, `valor`, `tipo`) VALUES (48,22,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(49,22,'hora','2022-06-13 21:56:23','P'),(50,22,'ip','127.0.0.1','P'),(51,23,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(52,23,'hora','2022-06-13 22:04:13','P'),(53,23,'ip','127.0.0.1','P'),(54,24,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(55,24,'hora','2022-06-13 22:08:45','P'),(56,24,'ip','127.0.0.1','P'),(57,25,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(58,25,'hora','2022-06-13 22:12:19','P'),(59,25,'ip','127.0.0.1','P'),(60,26,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(61,26,'hora','2022-06-13 22:16:22','P'),(62,26,'ip','127.0.0.1','P'),(63,27,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(64,27,'hora','2022-06-13 22:29:02','P'),(65,27,'ip','127.0.0.1','P'),(66,28,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(67,28,'hora','2022-06-13 22:33:50','P'),(68,28,'ip','127.0.0.1','P'),(69,29,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(70,29,'hora','2022-06-14 15:50:34','P'),(71,29,'ip','127.0.0.1','P'),(72,30,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(73,30,'hora','2022-06-14 16:23:07','P'),(74,30,'ip','192.168.1.7','P'),(75,31,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(76,31,'hora','2022-06-14 16:38:15','P'),(77,31,'ip','192.168.1.7','P'),(78,32,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(79,32,'hora','2022-06-14 16:40:21','P'),(80,32,'ip','192.168.1.7','P'),(81,33,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(82,33,'hora','2022-06-14 17:11:49','P'),(83,33,'ip','192.168.1.7','P'),(84,34,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(85,34,'hora','2022-06-14 17:26:51','P'),(86,34,'ip','192.168.1.7','P'),(87,35,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(88,35,'hora','2022-06-14 17:39:03','P'),(89,35,'ip','192.168.1.7','P'),(90,36,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(91,36,'hora','2022-06-14 17:41:17','P'),(92,36,'ip','192.168.1.7','P'),(93,37,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(94,37,'hora','2022-06-14 20:27:58','P'),(95,37,'ip','127.0.0.1','P'),(96,38,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36','P'),(97,38,'hora','2022-06-14 20:36:05','P'),(98,38,'ip','192.168.1.7','P'),(99,39,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Safari/537.36','P'),(100,39,'hora','2022-07-13 23:24:03','P'),(101,39,'ip','127.0.0.1','P'),(102,40,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.79 Safari/537.36','P'),(103,40,'hora','2022-09-04 21:05:03','P'),(104,40,'ip','127.0.0.1','P'),(105,41,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.79 Safari/537.36','P'),(106,41,'hora','2022-09-05 23:21:02','P'),(107,41,'ip','127.0.0.1','P'),(108,42,'dispositivo','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.79 Safari/537.36','P'),(109,42,'hora','2022-09-06 00:17:46','P'),(110,42,'ip','127.0.0.1','P');
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

-- Dump completed on 2023-02-05  4:14:22
