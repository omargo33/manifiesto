-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: GS_001_01
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
-- Current Database: `GS_001_01`
--

/*!40000 DROP DATABASE IF EXISTS `GS_001_01`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `GS_001_01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `GS_001_01`;

--
-- Table structure for table `codigo_definido_usuario`
--

DROP TABLE IF EXISTS `codigo_definido_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codigo_definido_usuario` (
  `id_codigo_definido_usuario` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int NOT NULL,
  `grupo` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Grupo de listas',
  `codigo_texto` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Codigo para los campos de: estado, tipo, grupo y/o categoría',
  `codigo_numero` int NOT NULL COMMENT 'Codigo para los campos de: estado, tipo y/o categoría',
  `nombre` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Nombre del campo',
  `descripcion` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'Descripción del campo para presentación',
  `orden` int NOT NULL COMMENT 'Orden de presentacion',
  `estado` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `usuario` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_codigo_definido_usuario`),
  KEY `codigo_definido_usuario_FK` (`id_modulo`),
  CONSTRAINT `codigo_definido_usuario_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo_definido_usuario`
--

LOCK TABLES `codigo_definido_usuario` WRITE;
/*!40000 ALTER TABLE `codigo_definido_usuario` DISABLE KEYS */;
INSERT INTO `codigo_definido_usuario` (`id_codigo_definido_usuario`, `id_modulo`, `grupo`, `codigo_texto`, `codigo_numero`, `nombre`, `descripcion`, `orden`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,1,'AD_US_01','A',1,'Activo','Usuario Activo',1,'A','ovelez','2021-05-19 01:41:42','manual'),(2,1,'AD_US_01','X',2,'Borrado','Usuario Borrado',3,'A','ovelez','2021-05-19 01:42:36','manual'),(3,1,'AD_US_01','P',3,'Pausado','Usuario Suspendido',2,'A','ovelez','2021-05-19 01:43:01','manual'),(4,1,'001','AD_US_01',1,'Usuario-Estado','Usuario-Estado',11,'A','ovelez','2021-05-19 01:43:01','manual'),(5,1,'AD_RL_01','A',1,'Activo','Rol Activo',1,'A','ovelez','2021-06-18 17:15:10','manual'),(6,1,'AD_RL_01','I',2,'Inactivo','Rol Inactivo',2,'A','ovelez','2021-06-18 17:15:10','manual'),(7,1,'AD_RL_02','ADM',1,'Administrador','Rol-Administrador',2,'A','ovelez','2021-06-18 17:15:10','manual'),(8,1,'AD_RL_02','LOG',2,'Auditor','Rol-Auditor',3,'A','ovelez','2021-06-18 17:15:10','manual'),(9,1,'AD_RL_02','CLI-01',3,'Cliente 01','Rol-Cliente 01',4,'A','ovelez','2021-06-18 17:15:10','manual'),(10,1,'AD_RL_02','CLI-02',4,'Cliente 02','Rol-Cliente 02',5,'A','ovelez','2021-06-18 17:15:10','manual'),(11,1,'AD_RL_02','ROOT',5,'Principal','Rol-Principal',1,'A','ovelez','2021-06-18 17:15:10','manual'),(12,1,'001','AD_RL_01',2,'Rol-Estado','Rol-Estado',12,'A','ovelez','2021-05-19 01:43:01','manual'),(13,1,'001','AD_RL_02',3,'Rol-Tipo-Acceso','Rol-Tipo-Acceso',13,'A','ovelez','2021-05-19 01:43:01','manual'),(14,1,'001','AD_MD_01',4,'Modulo-Estado','Modulo-Estado',17,'A','ovelez','2021-06-22 22:11:12','manual'),(15,1,'AD_MD_01','A',1,'Activo','Modulo Activo',1,'A','ovelez','2021-06-22 22:11:52','manual'),(16,1,'AD_MD_01','I',1,'Inactivo','Modulo Inactivo',2,'A','ovelez','2021-06-22 22:12:39','manual'),(17,1,'001','AD_CD_01',5,'CDU-Estado','CDU-Estado',6,'A','ovelez','2021-06-22 22:11:12','manual'),(18,1,'AD_CD_01','A',1,'Activo','Codigo Definido Usuario Activo',1,'A','ovelez','2021-06-22 23:37:06','manual'),(19,1,'AD_CD_01','I',2,'Inactivo','Codigo Definido Usuario Inactivo',2,'A','ovelez','2021-06-22 23:37:06','manual'),(23,1,'sdfsadf','11',11,'11','11',-1,'A','Pendiente','2021-06-25 22:18:28','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(24,1,'001','AD_PM_01',1,'Parametro-Clave','Administracion de parametros, en el que se tiene como clave o no',14,'A','Pendiente','2021-07-01 16:24:40','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(25,1,'AD_PM_01','C',0,'Clave','El parametro contiene claves',1,'A','Pendiente','2021-07-01 16:26:59','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(26,1,'AD_PM_01','N',1,'Sin Clave','El parametro no tiene claves',2,'A','Pendiente','2021-07-01 16:27:26','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(27,1,'001','AD_TK_01',1,'Token-Tipo','Tipo de toke, Correo, Facebook o cualquier otra red social',15,'A','Pendiente','2021-07-02 15:22:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(28,1,'AD_TK_01','C',1,'Correo','Es el inicial que usa directamente el correo',1,'A','Pendiente','2021-07-02 15:24:18','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(29,1,'AD_TK_01','F',2,'Facebook','Ingreso por Facebook',2,'A','Pendiente','2021-07-02 15:25:51','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(30,1,'AD_TK_01','G',3,'Google','Google Autenticador',3,'A','Pendiente','2021-07-02 16:01:19','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(35,1,'001','AD_TK_02',2,'Token-Estado','Estado del token',16,'A','Pendiente','2021-07-02 16:35:17','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(36,1,'AD_TK_02','A',1,'Activo','Token Activo',2,'A','Pendiente','2021-07-02 16:35:59','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(37,1,'AD_TK_02','I',2,'Inactivo','Token inactivo',3,'A','Pendiente','2021-07-02 16:36:19','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(38,1,'AD_TK_02','C',0,'Creado','Creado pero aun no activado',1,'A','Pendiente','2021-07-02 17:32:39','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(39,1,'001','AD_MN_01',1,'Menu-Tipo','Tipo de menus',9,'A','Pendiente','2021-07-07 22:44:29','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(42,1,'001','AD_MN_02',1,'Menu-Estado','Menu Estado',10,'A','Pendiente','2021-07-07 22:47:25','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(43,1,'AD_MN_01','P',1,'Principal','Es menu principal',1,'A','Pendiente','2021-07-07 22:50:25','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(44,1,'AD_MN_01','S',2,'Secundario','Menu Secundario',2,'A','Pendiente','2021-07-07 22:51:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(45,1,'AD_MN_01','U',2,'Usuario','Menu de Usuario',3,'A','Pendiente','2021-07-07 22:51:27','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(46,1,'AD_MN_01','X',4,'Salir','Menu de salida ',4,'A','Pendiente','2021-07-07 22:52:03','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(47,1,'AD_MN_02','A',1,'Activo','Menu activo',2,'A','Pendiente','2021-07-07 22:52:29','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(48,1,'AD_MN_02','I',2,'Inactivo','Menu inactivo',1,'A','Pendiente','2021-07-07 22:52:47','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(49,1,'001','AD_PR_01',1,'Permiso-Crear','Permisos de creación, actualizar, borrar y auditar',8,'A','Pendiente','2021-07-08 16:36:32','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(50,1,'AD_PR_01','S',1,'Si','Esta habilitado',1,'A','Pendiente','2021-07-08 16:37:51','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(51,1,'AD_PR_01','N',0,'No','No Habilitado',2,'A','Pendiente','2021-07-08 16:38:13','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(52,4,'001','CL_PR_01',1,'Estado proyecto','Estado proyecto',7,'A','omar','2022-01-20 14:41:54','/ViewControllerAdministrativo'),(53,4,'CL_PR_01','A',1,'Activo','Proyecto Activo/Ejecución ',1,'A','omar','2022-01-20 14:42:40','/ViewControllerAdministrativo'),(54,4,'001','CL_UB_01',2,'Ubicación','CDU para la ubicación de clientes',3,'A','omar','2022-01-28 00:37:24','/Administrativo-001'),(55,4,'CL_UB_01','E',1,'Email','Correo de contacto',2,'A','omar','2022-01-28 00:40:08','/Administrativo-001'),(56,4,'CL_UB_01','C',2,'Celular','Teléfono Celular',1,'A','omar','2022-01-28 00:42:06','/Administrativo-001'),(57,4,'CL_UB_01','T',3,'Teléfono','Teléfono Fijo',3,'A','omar','2022-01-28 00:42:35','/Administrativo-001'),(58,6,'001','MV_LD_01',1,'Tipo de Direcciones','Tipo de direcciones para el manifiesto',1,'A','omar','2022-02-18 23:05:46','/Administrativo-001'),(59,6,'MV_LD_01','C',1,'Aerolinea','Aerolinea',0,'A','omar','2022-02-18 23:06:27','/Administrativo-001'),(60,6,'MV_LD_01','AR',2,'Aeropuerto','Aeropuerto Origen/Desino ',1,'A','omar','2022-02-18 23:08:23','/Administrativo-001'),(61,6,'MV_LD_01','CA',2,'Aeronave','Idenfivicacion de Avion',2,'A','omar','2022-02-18 23:09:00','/Administrativo-001'),(62,6,'001','MV_LD_02',2,'Estado libro de direcciones','Estado libro de direcciones si esta borrado acitivo, etc',2,'A','omar','2022-02-20 16:09:55','/Administrativo-001'),(63,6,'MV_LD_02','A',1,'Activo','Activo',0,'A','omar','2022-02-20 16:11:02','/Administrativo-001'),(64,6,'MV_LD_02','I',1,'Inactivo','Inactivo',2,'A','omar','2022-02-20 16:11:29','/Administrativo-001'),(65,6,'MV_LD_02','X',2,'Borrado','Borrado Logico',2,'A','omar','2022-02-20 16:11:51','/Administrativo-001'),(66,6,'001','MV_LD_03',3,'Estado Sin borrar','Estado Sin borrar',4,'A','omar','2022-02-20 16:50:01','/Administrativo-001'),(67,6,'MV_LD_03','A',1,'Activo','Activo',0,'A','omar','2022-02-20 16:11:02','/Administrativo-001'),(68,6,'MV_LD_03','I',1,'Inactivo','Inactivo',2,'A','omar','2022-02-20 16:11:29','/Administrativo-001'),(69,6,'001','MV_MN_02',4,'Tipo de Manifiesto','Tipo de Manifiesto',18,'A','omar','2022-02-21 23:37:02','/Administrativo-001'),(70,6,'MV_MN_02','N',0,'Nacional','Vuelo Local',0,'A','omar','2022-02-21 23:37:34','/Administrativo-001'),(71,6,'MV_MN_02','I',1,'Internacional','Vuelo Internacional',2,'A','omar','2022-02-21 23:38:51','/Administrativo-001'),(72,6,'001','MV_MN_01',2,'Estado','Estado de manifiesto',5,'A','omar','2022-02-22 00:02:12','/Administrativo-001'),(73,6,'MV_MN_01','C',1,'Creado','Creado',1,'A','omar','2022-02-22 00:02:42','/Administrativo-001'),(74,6,'MV_MN_01','B',2,'Bloqueado','Bloqueado para Ediciones',2,'A','omar','2022-02-22 00:03:29','/Administrativo-001'),(75,6,'MV_MN_01','JDE',3,'JDE','Pasado a JDE',3,'A','omar','2022-02-22 00:04:04','/Administrativo-001'),(76,6,'MV_MN_01','BAD',4,'Error JDE','Error al pasar a JDE',4,'A','omar','2022-02-22 00:04:48','/Administrativo-001'),(77,1,'AD_MN_01','R',5,'REST','Rest',5,'A','omar78','2022-12-17 21:57:36','/Administrativo-001'),(78,6,'001','MV_MN_03',2,'Cancelado','Vuelo Cancelado',5,'A','omar','2022-02-22 00:02:12','/Administrativo-001'),(79,6,'MV_MN_03','N',1,'Ninguna','Ninguna',0,'A','omar','2022-02-21 23:38:51','/Administrativo-001'),(80,6,'MV_MN_03','C',2,'Vuelo Cancelado','Vuelo Cancelado',1,'A','omar','2022-02-21 23:38:51','/Administrativo-001'),(81,1,'AD_RL_02','CLI-03',5,'Cliente 03','Rol-Cliente 03',6,'A','ovelez','2021-06-18 17:15:10','manual');
/*!40000 ALTER TABLE `codigo_definido_usuario` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion`
--

LOCK TABLES `informacion` WRITE;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
INSERT INTO `informacion` (`id_informacion`, `nombre`, `valor_01`, `valor_02`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,'Nombre','GS_001_01','','ovelez','2012-12-12 17:12:12','manual'),(2,'Descripción','General Setup version 001','..','ovelez','2012-12-12 17:12:12','manual'),(3,'Autor','Omar Velez omargo33@hotmail.com','..','ovelez','2021-04-08 14:58:38','manual'),(4,'E-GS00100-8','Registro no existe','EmptyResultDataAccessException','ovelez','2021-04-08 14:58:38','manual'),(5,'E-GS00100-18','Formato de fecha incorrecto, YYYY-MM-DD HH:MM:SS','@Pattern','ovelez','2021-04-08 14:58:38','manual'),(6,'W-GS00100-1','La seguridad de usuario no se ejecuto y se presenta en al evaluar','generarMensajeError','ovelez','2021-04-08 14:58:38','manual'),(7,'E-GS00100-2','El campo no debe ser nulo','@NotNull','manual','2022-10-30 14:45:21','manual'),(8,'E-GS00100-3','El campo no puede estar vacio','@NotEmpty','ovelez','2021-04-08 14:58:38','manual'),(9,'E-GS00100-4','El indice del modulo ya existe ','@ModuloIndice','ovelez','2021-04-08 14:58:38','manual'),(10,'E-GS00100-5','El nombre del modulo ya existe ','@ModuloNombre','ovelez','2021-04-08 14:58:38','manual'),(11,'E-GS00100-6','El nombre de usuario ya existe','@UsuarioNick','ovelez','2021-04-08 14:58:38','manual'),(12,'E-GS00100-7','Campo Relacionado a otro recurso no existe','SQLIntegrityConstraintViolationException','ovelez','2021-04-08 14:58:38','manual'),(13,'W-GS00100-2','No esta definido el mensaje de error de ComonController','handleExceptions','ovelez','2021-04-08 14:58:38','manual'),(14,'W-GS00100-3','Autentification Ejecutada','','ovelez','2021-04-08 14:58:38','manual'),(15,'W-GS00100-4','Autentification no Ejecutada','','ovelez','2021-04-08 14:58:38','manual'),(16,'E-GS00100-9','usuarioRechazado No se ejecuto correctamente el JSON de salida','usuarioRechazado','ovelez','2021-04-08 14:58:38','manual'),(17,'W-GS00100-5','Problemas al identificar el usuario','loadUserByUsername','ovelez','2021-04-08 14:58:38','manual'),(18,'W-GS00100-6','Credencial Invalida','generarMensajeError','ovelez','2021-04-08 14:58:38','manual'),(19,'W-GS00100-7','Usuario Excede el numero de intentos validos.','generarMensajeError','ovelez','2021-04-08 14:58:38','manual'),(20,'W-GS00100-8','Token inactivo','generarMensajeError','ovelez','2021-04-08 14:58:38','manual');
/*!40000 ALTER TABLE `informacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id_menu` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int DEFAULT NULL COMMENT 'Id de modulo',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de menu, P=principal, S=secundario, U=usuario y S=salir',
  `indice` varchar(32) NOT NULL COMMENT 'Indice con el que se conce al menu de forma simplificada',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del indice',
  `task_flow` varchar(128) NOT NULL COMMENT 'Contexto del modulo',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo',
  `orden` int DEFAULT '0' COMMENT 'Orden de presentacion',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_menu`),
  KEY `menu_FK` (`id_modulo`),
  CONSTRAINT `menu_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id_menu`, `id_modulo`, `tipo`, `indice`, `nombre`, `task_flow`, `estado`, `orden`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (3,1,'P','LG-US-001','Usuario','/WEB-INF/usuario-task-flow.xml#usuario-task-flow','I',1,'Pendiente','2021-07-09 00:39:01','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(6,2,'P','GS-RL-001','Roles','/WEB-INF/rol-task-flow.xml#rol-task-flow','A',3,'Pendiente','2021-07-09 05:02:06','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(9,2,'P','GS-MN-001','Menus','/WEB-INF/menu-task-flow.xml#menu-task-flow','A',2,'Pendiente','2021-07-09 05:19:24','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(10,2,'P','GS-CD-001','Códigos Definidos','/WEB-INF/cdu-task-flow.xml#cdu-task-flow','A',4,'Pendiente','2021-07-11 17:40:39','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(11,2,'P','GS-ER-001','Errores','/WEB-INF/error-task-flow.xml#error-task-flow','A',6,'Pendiente','2022-01-04 15:53:49','manual'),(12,2,'P','GS-IN-001','Informacion','/WEB-INF/informacion-task-flow.xml#informacion-task-flow','A',7,'Pendiente','2022-01-04 16:28:04','manual'),(13,3,'P','IW-EN-001','Reportes','/WEB-INF/reporte-task-flow.xml#reporte-task-flow','A',1,'Pendiente','2022-01-05 04:54:14','manual'),(14,4,'P','CS_001','Cliente','/WEB-INF/cliente-task-flow#cliente-task-flow','A',2,'omar','2022-01-06 13:43:16','/ViewControllerAdministrativo'),(15,2,'P','GS-US-001','Usuarios','/WEB-INF/usuario-task-flow.xml#usuario-task-flow','A',5,'omar','2022-01-08 05:40:54','/ViewControllerAdministrativo'),(16,2,'P','GS-MD-001','Modulos','/WEB-INF/modulo-task-flow.xml#modulo-task-flow','A',1,'omar','2022-01-20 13:53:00','/ViewControllerAdministrativo'),(17,2,'P','GS_CC_001','Cambio Clave','/WEB-INF/clave-task-flow.xml#clave-task-flow','A',8,'omar','2022-01-25 04:46:58','/Administrativo-001'),(18,4,'P','CS_PR_001','Proyecto','/WEB-INF/proyecto-task-flow#proyecto-task-flow','A',1,'omar','2022-01-25 14:42:01','/Administrativo-001'),(19,4,'P','CS_CT_001','Contacto','/WEB-INF/contacto-task-flow#contacto-task-flow','A',3,'omar','2022-02-08 14:53:37','/Administrativo-001'),(20,6,'P','MV_RG_001','Manifiesto ADM','/WEB-INF/manifiesto-usuario-task-flow.xml#manifiesto-usuario-task-flow','A',2,'omar','2022-02-18 18:18:04','/Administrativo-001'),(21,6,'P','MV_AL_001','Manifiesto Vuelo USU','/WEB-INF/manifiesto-usuario-task-flow.xml#manifiesto-usuario-task-flow','A',2,'omar','2022-02-18 20:10:46','/Administrativo-001'),(22,6,'P','MV_LD_001','Libro Direcciones','/WEB-INF/libro-direccion-task-flow.xml#libro-direccion-task-flow','A',1,'omar','2022-02-20 16:37:18','/Administrativo-001'),(23,6,'P','MV_TT_001','Tasas Timbres','/WEB-INF/tasa-task-flow.xml#tasa-task-flow','A',2,'admin','2022-03-15 18:03:26','/Administrativo-001'),(24,6,'P','MV_ER_001','Errores Envio JDE','/WEB-INF/error-rest-task-flow.xml#error-rest-task-flow','A',2,'admin','2022-03-15 18:03:26','/Administrativo-001'),(25,9,'R','GS-MD-011','Modulos','/modulos/**','A',2,'nodata','2022-12-14 05:45:19','none'),(26,11,'P','LS_LG_011','Loging','/login/**','A',2,'omar78','2022-12-17 20:44:33','/Administrativo-001'),(27,9,'R','GS_US_011','Usuarios','/usuarios/**','A',3,'omar78','2022-12-17 21:10:39','/Administrativo-001'),(28,9,'R','GS_TK_011','Tokens','/tokens/**','A',4,'omar78','2022-12-17 21:24:30','/Administrativo-001'),(29,9,'R','GS_PR_011','Parametros','/parametros/**','A',5,'omar78','2022-12-17 21:32:16','/Administrativo-001'),(30,9,'R','GS_LG_011','Login','/login/**','A',1,'omar78','2022-12-17 21:41:38','/Administrativo-001'),(31,9,'R','GS_MN_011','Menu','/menu/**','A',6,'omar78','2022-12-17 22:01:52','/Administrativo-001'),(32,6,'P','MV_PL_001','Preliquidación','/WEB-INF/preliquidacion-task-flow.xml#preliquidacion-task-flow','A',2,'omar','2022-02-18 20:10:46','/Administrativo-001'),(33,6,'P','MV_CL_001','Carga por Lotes','/WEB-INF/manifiesto-up-task-flow.xml#manifiesto-up-task-flow','A',2,'omar','2022-02-18 20:10:46','/Administrativo-001');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modulo` (
  `id_modulo` int NOT NULL AUTO_INCREMENT,
  `indice` varchar(32) NOT NULL COMMENT 'Indici con el que se conce al modulo de forma simplificada',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del indice',
  `contexto` varchar(128) NOT NULL COMMENT 'Contexto de aplicacion',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  PRIMARY KEY (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` (`id_modulo`, `indice`, `nombre`, `contexto`, `usuario`, `usuario_fecha`, `usuario_programa`, `estado`) VALUES (1,'LG_001_00','Login','http://192.168.1.7:28080/Login-001/faces/LOG001?server=GF5&?token=','ovelez','2021-05-16 22:47:55','manual','A'),(2,'GS_001_01','Administrativo','http://192.168.1.7:28082/Administrativo-001/faces/LOG001?server=GF5&?token=','Pendiente','2021-07-07 23:24:44','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT','A'),(3,'IW_001_00','Reportes Impresiones','ViewControllerReportes/faces/LOG001','Pendiebnte','2022-01-05 04:52:13','manual','I'),(4,'CS_001_00','Cliente SAF','Cliente-001/faces/LOG001','omar','2022-01-06 13:40:57','/ViewControllerAdministrativo','I'),(6,'MV_001_00','Manifiesto','http://192.168.1.7:28083/Manifiesto-001/faces/LOG001?server=GF5&?token=','omar','2022-02-18 18:13:50','/Administrativo-001','A'),(7,'GA_001_00','Servicios Reportes Notificaciones','Archivo-001/faces/LOG001','omar','2022-02-25 04:30:28','/Administrativo-001','I'),(8,'BD_001_00','Base Desarrollo','BaseDesarrollo-001/faces/LOG001','omar','2022-02-25 04:30:28','/Administrativo-001','I'),(9,'GS_001_10-1.0.0','REST Administrativo','http://localhost:8082/gs_001_10','ovelez','2022-10-30 15:55:45','Manual','A'),(10,'SI_001_10-1.0.0','REST Sistema de Informacion','http://localhost:8081/si_001_10','ovelez','2022-10-30 15:55:45','Manual','A'),(11,'LG_001_10-1.0.0','REST Login','http://localhost:8080/ls_001_10','ovelez','2022-10-30 15:55:45','Manual','A'),(12,'test123','test123','http://test','admin','2023-03-22 03:25:25','manual@GS_001_10-1.0.0','A');
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parametro` (
  `id_parametro` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int DEFAULT NULL,
  `indice` varchar(32) NOT NULL COMMENT 'Indice de busquedas',
  `clave` varchar(8) DEFAULT NULL COMMENT 'Si los campos te texto son o no encriptados',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del parametro',
  `descripcion` varchar(512) NOT NULL COMMENT 'Descripción del campo a ser usado',
  `valor_texto_01` varchar(256) DEFAULT NULL COMMENT 'Valor texto a parametro',
  `valor_texto_02` varchar(256) DEFAULT NULL COMMENT 'Valor texto a parametro',
  `valor_numero_01` double DEFAULT NULL COMMENT 'Valor numero a parametro',
  `valor_numero_02` double DEFAULT NULL COMMENT 'Valor numero a parametro',
  `default_texto_01` varchar(256) DEFAULT NULL COMMENT 'Default texto 01',
  `default_texto_02` varchar(256) DEFAULT NULL COMMENT 'Default texto 02',
  `default_numero_01` double DEFAULT NULL COMMENT 'Default numero 01',
  `default_numero_02` double DEFAULT NULL COMMENT 'Default numero 02',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_parametro`),
  KEY `parametro_FK` (`id_modulo`),
  CONSTRAINT `parametro_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` (`id_parametro`, `id_modulo`, `indice`, `clave`, `nombre`, `descripcion`, `valor_texto_01`, `valor_texto_02`, `valor_numero_01`, `valor_numero_02`, `default_texto_01`, `default_texto_02`, `default_numero_01`, `default_numero_02`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (2,1,'002','N','Tiempo de espera ante intentos fallidos','Tiempo en horas, antes que la clave vuelva a estar activo','','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(8,1,'001','N','Numero de Intentos','Numero de Intentos que el login tendra antes de bloquear',NULL,NULL,3,0,'<No Definido>','<No Definido>',3,0,'Pendiente','2021-07-05 21:54:10','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(9,1,'003','N',' reCAPTCHA','reCAPTCHA al sitio web  \"loginADF\"','6LfRpt8bAAAAAFUbbzttVV5FrAhSiIN5vZUsekSL','6LfRpt8bAAAAANCPK5xqiHX2GTp3xC7MmTSL-p4o',NULL,NULL,'Clave del sitio Web','Clave secreta Servidor',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(10,1,'004','N','Contexto Usuario','Contexto Usuario nuevo y/o cambio clave + id_menu del menu que tiene esta inforamcion','http://192.168.1.7:28082/Administrativo-001/faces/LOG000?server=GF5&?token=','',17,NULL,'Contexto de Usuario','Contexto de Usuario',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(11,1,'005','N','Plantilla notificación enviar token','id Plantilla notificación enviar token',NULL,NULL,1,NULL,'Expresión Regular de validación','Mensaje de validación',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(14,8,'200','N','Path Relativo','Path Relativo para guardado de archivos','/home/ovelez/',NULL,NULL,NULL,'/homo/user','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(15,1,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','WLS12','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(16,2,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','WLS12','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(18,8,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(19,2,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(20,1,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(21,6,'200','N','Path Relativo','Path Relativo para guardado de archivos','/home/ovelez/',NULL,NULL,NULL,'/homo/user','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(23,2,'001','N','Expresion Regular para el cambio de claves','Expresion regular para claves ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','Debe contener: del 0-9, A-Z, a-z y los caracteres ! @ # & ( ) ; en un largo de 8-20 caracteres ',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(26,6,'001','N','URL Servicio manifiesto JDE','URL Servicio manifiesto JDE','https://186.31.107.90:8089/PY920/IntegracionPortalTasasTimbres',NULL,NULL,NULL,'https://186.31.107.90:8089/PY920/IntegracionPortalTasasTimbres','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(27,6,'002','N','Usuario/Clave URL Servicio manifiesto JDE','Usuario/Clave URL Servicio manifiesto JDE','CONSULTOR','C0nsult0r2021#*',NULL,NULL,'Usuario/Clave asignado desde  JDE ','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(28,6,'003','N','Path de archivo de llave SSL','Path de archivo de llave SSL que debe ser obtenida desde el sitio https','/home/omarv/ssl_jde_aerocivil','1937480',NULL,NULL,'Clave asignada de JDE','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(29,1,'006','N','URL empresarial','Url empresarial','https://www.aerocivil.gov.co/',NULL,1,NULL,'Url del sitio web de la empresa','',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(30,1,'007','N','URL Declaimer','URL de declaimer del sitio web, se usa para dar informacion legal o de contenido variado','https://www.elcarrocolombiano.com/noticias/mitsubishi-asx-2023-basado-en-captur-nuevos-datos/',NULL,1,NULL,'Url del Declamer','',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(31,6,'004','N','Dias de seguridad para ingreso de Cierres','Dias de seguridad para ingreso de Cierres','','',30,NULL,'','',30,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(32,6,'005','N','Maximo de ocupantes de los aviones','Maximo de ocupantes de los aviones validaciones','','',501,NULL,'','',501,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(33,2,'300','N','Notificacion Crear Clave ','Notificacion Crear Clave (Formato y Servicio)',NULL,NULL,2,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manul'),(34,1,'300','N','Notificacion Solicitud Nueva Clave','Notificacion Solicitud Nueva Clave (Formato y Servicio)',NULL,NULL,1,1,NULL,NULL,1,1,'ovelez','2022-06-11 18:43:12','manual'),(35,2,'301','N','Notificacion Cambio Clave ','Notificacion Cambio Clave (Formato y Servicio)',NULL,NULL,1,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manul'),(36,6,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(37,9,'002','N','Tiempo de espera ante intentos fallidos','Tiempo en horas, antes que la clave vuelva a estar activo','','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(38,9,'001','N','Numero de Intentos','Numero de Intentos que el login tendra antes de bloquear',NULL,NULL,3,0,'<No Definido>','<No Definido>',3,0,'Pendiente','2021-07-05 21:54:10','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(39,9,'003','N',' reCAPTCHA','reCAPTCHA al sitio web  \"loginADF\"','6LfRpt8bAAAAAFUbbzttVV5FrAhSiIN5vZUsekSL','6LfRpt8bAAAAANCPK5xqiHX2GTp3xC7MmTSL-p4o',NULL,NULL,'Clave del sitio Web','Clave secreta Servidor',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(41,9,'005','N','Plantilla notificación enviar token','id Plantilla notificación enviar token',NULL,NULL,1,NULL,'Expresión Regular de validación','Mensaje de validación',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(42,9,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','SPRING','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(46,9,'300','N','Notificacion Solicitud Nueva Clave','Notificacion Solicitud Nueva Clave (Formato y Servicio)',NULL,NULL,1,1,NULL,NULL,1,1,'ovelez','2022-06-11 18:43:12','manual'),(49,9,'004','N','Expresion Regular para el cambio de claves','Expresion regular para claves ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','Debe contener: del 0-9, A-Z, a-z y los caracteres ! @ # & ( ) ; en un largo de 8-20 caracteres ',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(50,9,'301','N','Notificacion Crear Clave ','Notificacion Crear Clave (Formato y Servicio)',NULL,NULL,2,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manual'),(51,9,'302','N','Notificacion Cambio Clave ','Notificacion Cambio Clave (Formato y Servicio)',NULL,NULL,1,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manual'),(52,6,'201','N','Path Imagen Derecha','Path Imagen Derecha','/home/ovelez/Documentos/clientes/Aerocivil/PortalAeronauticaCivil/derecha.jpg',NULL,NULL,NULL,'/home/ovelez/derecha.jpg','<No Definido>',0,0,'omar','2022-02-24 23:31:17','/Administrativo-001'),(53,6,'202','N','Path Imagen Derecha','Path Imagen Derecha','/home/ovelez/Documentos/clientes/Aerocivil/PortalAeronauticaCivil/izquierda.jpg',NULL,NULL,NULL,'/home/ovelez/izquierda.jpg','<No Definido>',0,0,'omar','2022-02-24 23:31:17','/Administrativo-001'),(54,6,'203','N','Titulo impuesto','Titulo impuesto','Titulo impuesto\nTitulo impuesto',NULL,NULL,NULL,'Titulo impuesto\nTitulo impuesto','<No Definido>',0,0,'omar','2022-02-24 23:31:17','/Administrativo-001'),(55,6,'204','N','Titulo impuesto','Titulo impuesto','Titulo documento\nTitulo Documento',NULL,NULL,NULL,'Titulo documento\nTitulo Documento','<No Definido>',0,0,'omar','2022-02-24 23:31:17','/Administrativo-001'),(56,11,'001','N','Numero de Intentos','Numero de Intentos que el login tendra antes de bloquear',NULL,NULL,3,0,'<No Definido>','<No Definido>',3,0,'Pendiente','2021-07-05 21:54:10','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(57,11,'002','N','Tiempo de espera ante intentos fallidos','Tiempo en horas, antes que la clave vuelva a estar activo','','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(58,11,'003','N',' reCAPTCHA','reCAPTCHA al sitio web  \"loginADF\"','6LfRpt8bAAAAAFUbbzttVV5FrAhSiIN5vZUsekSL','6LfRpt8bAAAAANCPK5xqiHX2GTp3xC7MmTSL-p4o',NULL,NULL,'Clave del sitio Web','Clave secreta Servidor',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(59,11,'004','N','Contexto Usuario','Contexto Usuario nuevo y/o cambio clave + id_menu del menu que tiene esta inforamcion','http://192.168.1.7:28082/Administrativo-001/faces/LOG000?server=GF5&?token=','',17,NULL,'Contexto de Usuario','Contexto de Usuario',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(60,11,'005','N','Plantilla notificación enviar token','id Plantilla notificación enviar token',NULL,NULL,1,NULL,'Expresión Regular de validación','Mensaje de validación',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(61,11,'006','N','URL empresarial','Url empresarial','https://www.aerocivil.gov.co/',NULL,1,NULL,'Url del sitio web de la empresa','',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(62,11,'007','N','URL Declaimer','URL de declaimer del sitio web, se usa para dar informacion legal o de contenido variado','https://www.elcarrocolombiano.com/noticias/mitsubishi-asx-2023-basado-en-captur-nuevos-datos/',NULL,1,NULL,'Url del Declamer','',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(63,11,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','WLS12','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(64,11,'300','N','Notificacion Solicitud Nueva Clave','Notificacion Solicitud Nueva Clave (Formato y Servicio)',NULL,NULL,1,1,NULL,NULL,1,1,'ovelez','2022-06-11 18:43:12','manual'),(65,11,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual');
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'GS_001_01'
--

--
-- Dumping routines for database 'GS_001_01'
--
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_bajar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `codigo_definido_usuario_bajar`(
	IN pii_id_codigo_definido_usuario int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	
	
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_codigo_definido_usuario_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pv_grupo varchar(128);
	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	
    
   	START TRANSACTION;
   
   	
	
	SELECT orden, grupo into pi_orden_original, pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
	
	
	select id_codigo_definido_usuario , orden into pi_id_codigo_definido_usuario_destino,  pi_orden_destino
	from codigo_definido_usuario
	where grupo = pv_grupo
	and orden = (
		select min(orden) 
		FROM codigo_definido_usuario 
		where grupo = pv_grupo
		and orden > pi_orden_original
		);

	
	
	if pi_id_codigo_definido_usuario_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	
	
	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_destino
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;

   	
	
   	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_original
   	where id_codigo_definido_usuario = pi_id_codigo_definido_usuario_destino;
   
   	
	
   	CALL GS_001_01.codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	
    
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_extremos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `codigo_definido_usuario_extremos`(
	IN pii_id_codigo_definido_usuario int,		 
	IN pii_extremo int, 
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	
	
	DECLARE pv_grupo varchar(128);
	DECLARE pi_codigo_error int;

	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;          
    	  ROLLBACK;
    END;
   
   	
    
   	START TRANSACTION;
   
   	
	
	SELECT grupo into pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
    
   	UPDATE codigo_definido_usuario
   	SET orden = pii_extremo
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;   	
   
   	
	
   	CALL codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);
   	if poi_codigo_error > 0 then   		
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
   
	
    
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_ordenar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `codigo_definido_usuario_ordenar`(
	IN piv_grupo varchar(128),	
	OUT poi_codigo_error int	
)
BEGIN
	
	
	DECLARE cr_orden_destino int; 
	DECLARE cr_id_codigo_definido_usuario int; 
	DECLARE cr_orden_origen int;
	DECLARE cr_done boolean;
	DECLARE cr_orden cursor for
		SELECT @rowid:=@rowid+1 as orden_destino, id_codigo_definido_usuario, orden as orden_origen 
		FROM codigo_definido_usuario, (SELECT @rowid:=0) as init
		where grupo = piv_grupo
		ORDER BY orden;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET cr_done = TRUE;
	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	
   	
   	open cr_orden;
   	rows_loop:loop
   		fetch cr_orden into cr_orden_destino, cr_id_codigo_definido_usuario, cr_orden_origen;
   		
   		
   		if cr_done then
   			leave rows_loop;
   		end if;
   		
		
		UPDATE codigo_definido_usuario as cdu
		SET cdu.orden = cr_orden_destino 
		WHERE cdu.id_codigo_definido_usuario = cr_id_codigo_definido_usuario;   	
   	end loop;   
   	close cr_orden;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_subir` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `codigo_definido_usuario_subir`(
	IN pii_id_codigo_definido_usuario int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	
	
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_codigo_definido_usuario_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pv_grupo varchar(128);
	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	
    
   	START TRANSACTION;
   
   	
	
	SELECT orden, grupo into pi_orden_original, pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
	
	
	select id_codigo_definido_usuario , orden into pi_id_codigo_definido_usuario_destino,  pi_orden_destino
	from codigo_definido_usuario
	where grupo = pv_grupo
	and orden = (
		select max(orden) 
		FROM codigo_definido_usuario 
		where grupo = pv_grupo
		and orden < pi_orden_original
		);

	
	
	if pi_id_codigo_definido_usuario_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	
	
	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_destino
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;

   	
	
   	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_original
   	where id_codigo_definido_usuario = pi_id_codigo_definido_usuario_destino;
   
   	
	
   	CALL GS_001_01.codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	
    
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_synonym_db` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `create_synonym_db`(
        IN in_db_name VARCHAR(64), 
        IN in_synonym VARCHAR(64)
    )
    MODIFIES SQL DATA
    SQL SECURITY INVOKER
    COMMENT '\n             Description\n             -----------\n             Takes a source database name and synonym name, and then creates the \n             synonym database with views that point to all of the tables within\n             the source database.\n             Useful for creating a "ps" synonym for "performance_schema",\n             or "is" instead of "information_schema", for example.\n             Parameters\n             -----------\n             in_db_name (VARCHAR(64)):\n               The database name that you would like to create a synonym for.\n             in_synonym (VARCHAR(64)):\n               The database synonym name.\n             Example\n             -----------\n             mysql> SHOW DATABASES;\n             +--------------------+\n             | Database           |\n             +--------------------+\n             | information_schema |\n             | mysql              |\n             | performance_schema |\n             | sys                |\n             | test               |\n             +--------------------+\n             5 rows in set (0.00 sec)\n             mysql> CALL sys.create_synonym_db(''performance_schema'', ''ps'');\n             +---------------------------------------+\n             | summary                               |\n             +---------------------------------------+\n             | Created 74 views in the `ps` database |\n             +---------------------------------------+\n             1 row in set (8.57 sec)\n             Query OK, 0 rows affected (8.57 sec)\n             mysql> SHOW DATABASES;\n             +--------------------+\n             | Database           |\n             +--------------------+\n             | information_schema |\n             | mysql              |\n             | performance_schema |\n             | ps                 |\n             | sys                |\n             | test               |\n             +--------------------+\n             6 rows in set (0.00 sec)\n             mysql> SHOW FULL TABLES FROM ps;\n             +------------------------------------------------------+------------+\n             | Tables_in_ps                                         | Table_type |\n             +------------------------------------------------------+------------+\n             | accounts                                             | VIEW       |\n             | cond_instances                                       | VIEW       |\n             | events_stages_current                                | VIEW       |\n             | events_stages_history                                | VIEW       |\n             ...\n            '
BEGIN
    DECLARE v_done bool DEFAULT FALSE;
    DECLARE v_db_name_check VARCHAR(64);
    DECLARE v_db_err_msg TEXT;
    DECLARE v_table VARCHAR(64);
    DECLARE v_views_created INT DEFAULT 0;

    DECLARE db_doesnt_exist CONDITION FOR SQLSTATE '42000';
    DECLARE db_name_exists CONDITION FOR SQLSTATE 'HY000';

    DECLARE c_table_names CURSOR FOR 
        SELECT TABLE_NAME 
          FROM INFORMATION_SCHEMA.TABLES 
         WHERE TABLE_SCHEMA = in_db_name;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_done = TRUE;

    
    SELECT SCHEMA_NAME INTO v_db_name_check
      FROM INFORMATION_SCHEMA.SCHEMATA
     WHERE SCHEMA_NAME = in_db_name;

    IF v_db_name_check IS NULL THEN
        SET v_db_err_msg = CONCAT('Unknown database ', in_db_name);
        SIGNAL SQLSTATE 'HY000'
            SET MESSAGE_TEXT = v_db_err_msg;
    END IF;

    
    SELECT SCHEMA_NAME INTO v_db_name_check
      FROM INFORMATION_SCHEMA.SCHEMATA
     WHERE SCHEMA_NAME = in_synonym;

    IF v_db_name_check = in_synonym THEN
        SET v_db_err_msg = CONCAT('Can\'t create database ', in_synonym, '; database exists');
        SIGNAL SQLSTATE 'HY000'
            SET MESSAGE_TEXT = v_db_err_msg;
    END IF;

    
    SET @create_db_stmt := CONCAT('CREATE DATABASE ', sys.quote_identifier(in_synonym));
    PREPARE create_db_stmt FROM @create_db_stmt;
    EXECUTE create_db_stmt;
    DEALLOCATE PREPARE create_db_stmt;

    SET v_done = FALSE;
    OPEN c_table_names;
    c_table_names: LOOP
        FETCH c_table_names INTO v_table;
        IF v_done THEN
            LEAVE c_table_names;
        END IF;

        SET @create_view_stmt = CONCAT(
            'CREATE SQL SECURITY INVOKER VIEW ',
            sys.quote_identifier(in_synonym),
            '.',
            sys.quote_identifier(v_table),
            ' AS SELECT * FROM ',
            sys.quote_identifier(in_db_name),
            '.',
            sys.quote_identifier(v_table)
        );
        PREPARE create_view_stmt FROM @create_view_stmt;
        EXECUTE create_view_stmt;
        DEALLOCATE PREPARE create_view_stmt;

        SET v_views_created = v_views_created + 1;
    END LOOP;
    CLOSE c_table_names;

    SELECT CONCAT(
        'Created ', v_views_created, ' view',
        IF(v_views_created != 1, 's', ''), ' in the ',
        sys.quote_identifier(in_synonym), ' database'
    ) AS summary;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_bajar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `menu_bajar`(
	IN pii_id_menu int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	
	
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_menu_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pi_id_modulo varchar(128);
	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	
    
   	START TRANSACTION;
   
   	
	
	SELECT orden, id_modulo into pi_orden_original, pi_id_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
	
	
	select id_menu , orden into pi_id_menu_destino,  pi_orden_destino
	from menu
	where id_modulo = pi_id_modulo
	and orden = (
		select min(orden) 
		FROM menu 
		where id_modulo = pi_id_modulo
		and orden > pi_orden_original
		);

	
	
	if pi_id_menu_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	
	
	UPDATE menu
   	SET orden = pi_orden_destino
   	where id_menu = pii_id_menu;

   	
	
   	UPDATE menu
   	SET orden = pi_orden_original
   	where id_menu = pi_id_menu_destino;
   
   	
	
   	CALL GS_001_01.menu_ordenar(pi_id_modulo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	
    
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_extremos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `menu_extremos`(
	IN pii_id_menu int,		 
	IN pii_extremo int, 
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	
	
	DECLARE pi_modulo varchar(128);
	DECLARE pi_codigo_error int;

	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;          
    	  ROLLBACK;
    END;
   
   	
    
   	START TRANSACTION;
   
   	
	
	SELECT id_modulo into pi_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
    
   	UPDATE menu
   	SET orden = pii_extremo
   	where id_menu = pii_id_menu;   	
   
   	
	
   	CALL menu_ordenar(pi_modulo,pi_codigo_error);
   	if poi_codigo_error > 0 then   		
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
   
	
    
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_ordenar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `menu_ordenar`(
	IN pii_id_modulo int,	
	OUT poi_codigo_error int	
)
BEGIN
	
	
	DECLARE cr_orden_destino int; 
	DECLARE cr_id_menu int; 
	DECLARE cr_orden_origen int;
	DECLARE cr_done boolean;
	DECLARE cr_orden cursor for
		SELECT @rowid:=@rowid+1 as orden_destino, id_menu, orden as orden_origen 
		FROM menu, (SELECT @rowid:=0) as init
		where id_modulo = pii_id_modulo
		ORDER BY orden;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET cr_done = TRUE;
	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	
   	
   	open cr_orden;
   	rows_loop:loop
   		fetch cr_orden into cr_orden_destino, cr_id_menu, cr_orden_origen;
   		
   		
   		if cr_done then
   			leave rows_loop;
   		end if;
   		
		
		UPDATE menu as mn
		SET mn.orden = cr_orden_destino 
		WHERE mn.id_menu = cr_id_menu;   	
   	end loop;   
   	close cr_orden;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_subir` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `menu_subir`(
	IN pii_id_menu int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	
	
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_menu_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pi_modulo int;
	
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  
          
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	
    
   	START TRANSACTION;
   
   	
	
	SELECT orden, id_modulo into pi_orden_original, pi_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
	
	
	select id_menu, orden into pi_id_menu_destino, pi_orden_destino
	from menu
	where id_modulo = pi_modulo
	and orden = (
		select max(orden) 
		FROM menu 
		where id_modulo = pi_modulo
		and orden < pi_orden_original
		);

	
	
	if pi_id_menu_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	
	
	UPDATE menu
   	SET orden = pi_orden_destino
   	where id_menu = pii_id_menu;

   	
	
   	UPDATE menu
   	SET orden = pi_orden_original
   	where id_menu = pi_id_menu_destino;
   
   	
	
   	CALL GS_001_01.menu_ordenar(pi_modulo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	
    
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-30 21:51:19
