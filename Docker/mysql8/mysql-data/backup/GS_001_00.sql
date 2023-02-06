-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: GS_001_00
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
-- Current Database: `GS_001_00`
--

/*!40000 DROP DATABASE IF EXISTS `GS_001_00`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `GS_001_00` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `GS_001_00`;

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
  KEY `codigo_definido_usuario_id_modulo_IDX` (`id_modulo`,`grupo`) USING BTREE,
  CONSTRAINT `codigo_definido_usuario_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo_definido_usuario`
--

LOCK TABLES `codigo_definido_usuario` WRITE;
/*!40000 ALTER TABLE `codigo_definido_usuario` DISABLE KEYS */;
INSERT INTO `codigo_definido_usuario` (`id_codigo_definido_usuario`, `id_modulo`, `grupo`, `codigo_texto`, `codigo_numero`, `nombre`, `descripcion`, `orden`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,1,'AD_US_01','A',1,'Activo','Usuario Activo',1,'A','ovelez','2021-05-19 01:41:42','manual'),(2,1,'AD_US_01','X',2,'Borrado','Usuario Borrado',3,'A','ovelez','2021-05-19 01:42:36','manual'),(3,1,'AD_US_01','P',3,'Pausado','Usuario Suspendido',2,'A','ovelez','2021-05-19 01:43:01','manual'),(4,1,'001','AD_US_01',1,'Usuario-Estado','Usuario-Estado',11,'A','ovelez','2021-05-19 01:43:01','manual'),(5,1,'AD_RL_01','A',1,'Activo','Rol Activo',1,'A','ovelez','2021-06-18 17:15:10','manual'),(6,1,'AD_RL_01','I',2,'Inactivo','Rol Inactivo',2,'A','ovelez','2021-06-18 17:15:10','manual'),(7,1,'AD_RL_02','ADM',1,'Administrador','Rol-Administrador',2,'A','ovelez','2021-06-18 17:15:10','manual'),(8,1,'AD_RL_02','LOG',2,'Auditor','Rol-Auditor',3,'A','ovelez','2021-06-18 17:15:10','manual'),(9,1,'AD_RL_02','CLI-01',3,'Cliente 01','Rol-Cliente',4,'A','ovelez','2021-06-18 17:15:10','manual'),(10,1,'AD_RL_02','CLI-02',4,'Cliente 02','Rol-Cliente',5,'A','ovelez','2021-06-18 17:15:10','manual'),(11,1,'AD_RL_02','ROOT',5,'Principal','Rol-Principal',1,'A','ovelez','2021-06-18 17:15:10','manual'),(12,1,'001','AD_RL_01',2,'Rol-Estado','Rol-Estado',12,'A','ovelez','2021-05-19 01:43:01','manual'),(13,1,'001','AD_RL_02',3,'Rol-Tipo-Acceso','Rol-Tipo-Acceso',13,'A','ovelez','2021-05-19 01:43:01','manual'),(14,1,'001','AD_MD_01',4,'Modulo-Estado','Modulo-Estado',17,'A','ovelez','2021-06-22 22:11:12','manual'),(15,1,'AD_MD_01','A',1,'Activo','Modulo Activo',1,'A','ovelez','2021-06-22 22:11:52','manual'),(16,1,'AD_MD_01','I',1,'Inactivo','Modulo Inactivo',2,'A','ovelez','2021-06-22 22:12:39','manual'),(17,1,'001','AD_CD_01',5,'CDU-Estado','CDU-Estado',6,'A','ovelez','2021-06-22 22:11:12','manual'),(18,1,'AD_CD_01','A',1,'Activo','Codigo Definido Usuario Activo',1,'A','ovelez','2021-06-22 23:37:06','manual'),(19,1,'AD_CD_01','I',2,'Inactivo','Codigo Definido Usuario Inactivo',2,'A','ovelez','2021-06-22 23:37:06','manual'),(23,1,'sdfsadf','11',11,'11','11',-1,'A','Pendiente','2021-06-25 22:18:28','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(24,1,'001','AD_PM_01',1,'Parametro-Clave','Administracion de parametros, en el que se tiene como clave o no',14,'A','Pendiente','2021-07-01 16:24:40','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(25,1,'AD_PM_01','C',0,'Clave','El parametro contiene claves',1,'A','Pendiente','2021-07-01 16:26:59','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(26,1,'AD_PM_01','N',1,'Sin Clave','El parametro no tiene claves',2,'A','Pendiente','2021-07-01 16:27:26','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(27,1,'001','AD_TK_01',1,'Token-Tipo','Tipo de toke, Correo, Facebook o cualquier otra red social',15,'A','Pendiente','2021-07-02 15:22:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(28,1,'AD_TK_01','C',1,'Correo','Es el inicial que usa directamente el correo',1,'A','Pendiente','2021-07-02 15:24:18','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(29,1,'AD_TK_01','F',2,'Facebook','Ingreso por Facebook',2,'A','Pendiente','2021-07-02 15:25:51','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(30,1,'AD_TK_01','G',3,'Google','Google Autenticador',3,'A','Pendiente','2021-07-02 16:01:19','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(35,1,'001','AD_TK_02',2,'Token-Estado','Estado del token',16,'A','Pendiente','2021-07-02 16:35:17','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(36,1,'AD_TK_02','A',1,'Activo','Token Activo',2,'A','Pendiente','2021-07-02 16:35:59','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(37,1,'AD_TK_02','I',2,'Inactivo','Token inactivo',3,'A','Pendiente','2021-07-02 16:36:19','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(38,1,'AD_TK_02','C',0,'Creado','Creado pero aun no activado',1,'A','Pendiente','2021-07-02 17:32:39','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(39,1,'001','AD_MN_01',1,'Menu-Tipo','Tipo de menus',9,'A','Pendiente','2021-07-07 22:44:29','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(42,1,'001','AD_MN_02',1,'Menu-Estado','Menu Estado',10,'A','Pendiente','2021-07-07 22:47:25','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(43,1,'AD_MN_01','P',1,'Principal','Es menu principal',1,'A','Pendiente','2021-07-07 22:50:25','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(44,1,'AD_MN_01','S',2,'Secundario','Menu Secundario',2,'A','Pendiente','2021-07-07 22:51:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(45,1,'AD_MN_01','U',2,'Usuario','Menu de Usuario',3,'A','Pendiente','2021-07-07 22:51:27','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(46,1,'AD_MN_01','X',4,'Salir','Menu de salida ',4,'A','Pendiente','2021-07-07 22:52:03','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(47,1,'AD_MN_02','A',1,'Activo','Menu activo',2,'A','Pendiente','2021-07-07 22:52:29','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(48,1,'AD_MN_02','I',2,'Inactivo','Menu inactivo',1,'A','Pendiente','2021-07-07 22:52:47','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(49,1,'001','AD_PR_01',1,'Permiso-Crear','Permisos de creación, actualizar, borrar y auditar',8,'A','Pendiente','2021-07-08 16:36:32','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(50,1,'AD_PR_01','S',1,'Si','Esta habilitado',1,'A','Pendiente','2021-07-08 16:37:51','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(51,1,'AD_PR_01','N',0,'No','No Habilitado',2,'A','Pendiente','2021-07-08 16:38:13','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(52,4,'001','CL_PR_01',1,'Estado proyecto','Estado proyecto',7,'A','omar','2022-01-20 14:41:54','/ViewControllerAdministrativo'),(53,4,'CL_PR_01','A',1,'Activo','Proyecto Activo/Ejecución ',1,'A','omar','2022-01-20 14:42:40','/ViewControllerAdministrativo'),(54,4,'001','CL_UB_01',2,'Ubicación','CDU para la ubicación de clientes',3,'A','omar','2022-01-28 00:37:24','/Administrativo-001'),(55,4,'CL_UB_01','E',1,'Email','Correo de contacto',2,'A','omar','2022-01-28 00:40:08','/Administrativo-001'),(56,4,'CL_UB_01','C',2,'Celular','Teléfono Celular',1,'A','omar','2022-01-28 00:42:06','/Administrativo-001'),(57,4,'CL_UB_01','T',3,'Teléfono','Teléfono Fijo',3,'A','omar','2022-01-28 00:42:35','/Administrativo-001'),(58,6,'001','MV_LD_01',1,'Tipo de Direcciones','Tipo de direcciones para el manifiesto',1,'A','omar','2022-02-18 23:05:46','/Administrativo-001'),(59,6,'MV_LD_01','C',1,'Aerolinea','Aerolinea',0,'A','omar','2022-02-18 23:06:27','/Administrativo-001'),(60,6,'MV_LD_01','AR',2,'Aeropuerto','Aeropuerto Origen/Desino ',1,'A','omar','2022-02-18 23:08:23','/Administrativo-001'),(61,6,'MV_LD_01','CA',2,'Aeronave','Idenfivicacion de Avion',2,'A','omar','2022-02-18 23:09:00','/Administrativo-001'),(62,6,'001','MV_LD_02',2,'Estado libro de direcciones','Estado libro de direcciones si esta borrado acitivo, etc',2,'A','omar','2022-02-20 16:09:55','/Administrativo-001'),(63,6,'MV_LD_02','A',1,'Activo','Activo',0,'A','omar','2022-02-20 16:11:02','/Administrativo-001'),(64,6,'MV_LD_02','I',1,'Inactivo','Inactivo',2,'A','omar','2022-02-20 16:11:29','/Administrativo-001'),(65,6,'MV_LD_02','X',2,'Borrado','Borrado Logico',2,'A','omar','2022-02-20 16:11:51','/Administrativo-001'),(66,6,'001','MV_LD_03',3,'Estado Sin borrar','Estado Sin borrar',4,'A','omar','2022-02-20 16:50:01','/Administrativo-001'),(67,6,'MV_LD_03','A',1,'Activo','Activo',0,'A','omar','2022-02-20 16:11:02','/Administrativo-001'),(68,6,'MV_LD_03','I',1,'Inactivo','Inactivo',2,'A','omar','2022-02-20 16:11:29','/Administrativo-001'),(69,6,'001','MV_MN_02',4,'Tipo de Manifiesto','Tipo de Manifiesto',18,'A','omar','2022-02-21 23:37:02','/Administrativo-001'),(70,6,'MV_MN_02','N',0,'Nacional','Vuelo Local',0,'A','omar','2022-02-21 23:37:34','/Administrativo-001'),(71,6,'MV_MN_02','I',1,'Internacional','Vuelo Internacional',2,'A','omar','2022-02-21 23:38:51','/Administrativo-001'),(72,6,'001','MV_MN_01',2,'Estado','Estado de manifiesto',5,'A','omar','2022-02-22 00:02:12','/Administrativo-001'),(73,6,'MV_MN_01','C',1,'Creado','Creado',1,'A','omar','2022-02-22 00:02:42','/Administrativo-001'),(74,6,'MV_MN_01','B',2,'Bloqueado','Bloqueado para Ediciones',2,'A','omar','2022-02-22 00:03:29','/Administrativo-001'),(75,6,'MV_MN_01','JDE',3,'JDE','Pasado a JDE',3,'A','omar','2022-02-22 00:04:04','/Administrativo-001'),(76,6,'MV_MN_01','BAD',4,'Error JDE','Error al pasar a JDE',4,'A','omar','2022-02-22 00:04:48','/Administrativo-001'),(77,1,'AD_MN_01','R',5,'REST','Rest',5,'A','omar78','2022-12-17 21:57:36','/Administrativo-001'),(78,6,'001','MV_MN_03',2,'Cancelado','Vuelo Cancelado',5,'A','omar','2022-02-22 00:02:12','/Administrativo-001'),(79,6,'MV_MN_03','N',1,'Ninguna','Ninguna',0,'A','omar','2022-02-21 23:38:51','/Administrativo-001'),(80,6,'MV_MN_03','C',2,'Vuelo Cancelado','Vuelo Cancelado',1,'A','omar','2022-02-21 23:38:51','/Administrativo-001');
/*!40000 ALTER TABLE `codigo_definido_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `error`
--

DROP TABLE IF EXISTS `error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `error` (
  `id_error` int NOT NULL AUTO_INCREMENT,
  `indice` varchar(128) NOT NULL COMMENT 'Indice de error',
  `mensaje` varchar(1024) NOT NULL COMMENT 'Mensaje de error',
  `descripcion` varchar(4098) DEFAULT NULL COMMENT 'Descripcion del mensaje de error',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_error`),
  KEY `error_indice_IDX` (`indice`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `error`
--

LOCK TABLES `error` WRITE;
/*!40000 ALTER TABLE `error` DISABLE KEYS */;
INSERT INTO `error` (`id_error`, `indice`, `mensaje`, `descripcion`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,'SAF000001','SAF000001 Error commit para el codigo {0} en la ubicacion {1}.{2}(). Motivado por: {3}','Mensaje que se usa al dar: \n\ncommitRollback(elemento, \"metodoInvocado\");\n\nelemento: es el campo de los datos que va a indicar los datos que se esten haciendo.\n\n\"metodoInvocado\": es el campo con el nombre del metodo que invoca el commitRollback \n\n','ovelez','2021-05-04 23:03:08','manual'),(2,'SAF000002','SAF000002 Error al registrar el acceso {0}','Mensaje que se usa al dar: \n\ncrearAcceso(SAFAuditoriaModuloImpl moduloAplicacion, String nombre, String token, String tokenApi, String usuarioPrograma)\n\nNo fue capaz de ejecutar','ovelez','2021-05-04 23:03:08','manual');
/*!40000 ALTER TABLE `error` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion`
--

LOCK TABLES `informacion` WRITE;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
INSERT INTO `informacion` (`id_informacion`, `nombre`, `valor_01`, `valor_02`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,'Nombre','GS_001_00','','ovelez','2012-12-12 17:12:12','manual'),(2,'Descripción','General Setup version 001','..','ovelez','2012-12-12 17:12:12','manual'),(3,'Autor','Omar Velez omargo33@hotmail.com','..','ovelez','2021-04-08 14:58:38','manual'),(4,'E-GS00100-8','Registro no existe','EmptyResultDataAccessException','ovelez','2021-04-08 14:58:38','manual'),(5,'E-GS00100-18','Formato de fecha incorrecto, YYYY-MM-DD HH:MM:SS','@Pattern','ovelez','2021-04-08 14:58:38','manual'),(6,'W-GS00100-1','La seguridad de usuario no se ejecuto y se presenta en al evaluar','generarMensajeError','ovelez','2021-04-08 14:58:38','manual'),(7,'E-GS00100-2','El campo no debe ser nulo','@NotNull','manual','2022-10-30 14:45:21','manual'),(8,'E-GS00100-3','El campo no puede estar vacio','@NotEmpty','ovelez','2021-04-08 14:58:38','manual'),(9,'E-GS00100-4','El indice del modulo ya existe ','@ModuloIndice','ovelez','2021-04-08 14:58:38','manual'),(10,'E-GS00100-5','El nombre del modulo ya existe ','@ModuloNombre','ovelez','2021-04-08 14:58:38','manual'),(11,'E-GS00100-6','El nombre de usuario ya existe','@UsuarioNick','ovelez','2021-04-08 14:58:38','manual'),(12,'E-GS00100-7','Campo Relacionado a otro recurso no existe','SQLIntegrityConstraintViolationException','ovelez','2021-04-08 14:58:38','manual'),(13,'W-GS00100-2','No esta definido el mensaje de error de ComonController','handleExceptions','ovelez','2021-04-08 14:58:38','manual'),(14,'W-GS00100-3','Autentification Ejecutada','','ovelez','2021-04-08 14:58:38','manual'),(15,'W-GS00100-4','Autentification no Ejecutada','','ovelez','2021-04-08 14:58:38','manual'),(16,'E-GS00100-9','usuarioRechazado No se ejecuto correctamente el JSON de salida','usuarioRechazado','ovelez','2021-04-08 14:58:38','manual'),(17,'W-GS00100-5','Problemas al identificar el usuario','loadUserByUsername','ovelez','2021-04-08 14:58:38','manual'),(18,'W-GS00100-6','Credencial Invalida','generarMensajeError','ovelez','2021-04-08 14:58:38','manual'),(19,'W-GS00100-7','Usuario Excede el numero de intentos validos.','generarMensajeError','ovelez','2021-04-08 14:58:38','manual');
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
  KEY `menu_indice_IDX` (`indice`),
  KEY `menu_FK` (`id_modulo`),
  CONSTRAINT `menu_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id_menu`, `id_modulo`, `tipo`, `indice`, `nombre`, `task_flow`, `estado`, `orden`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (3,1,'P','LG-US-001','Usuario','/WEB-INF/usuario-task-flow.xml#usuario-task-flow','I',1,'Pendiente','2021-07-09 00:39:01','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(6,2,'P','GS-RL-001','Roles','/WEB-INF/rol-task-flow.xml#rol-task-flow','A',3,'Pendiente','2021-07-09 05:02:06','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(9,2,'P','GS-MN-001','Menus','/WEB-INF/menu-task-flow.xml#menu-task-flow','A',2,'Pendiente','2021-07-09 05:19:24','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(10,2,'P','GS-CD-001','Códigos Definidos','/WEB-INF/cdu-task-flow.xml#cdu-task-flow','A',4,'Pendiente','2021-07-11 17:40:39','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(11,2,'P','GS-ER-001','Errores','/WEB-INF/error-task-flow.xml#error-task-flow','A',6,'Pendiente','2022-01-04 15:53:49','manual'),(12,2,'P','GS-IN-001','Informacion','/WEB-INF/informacion-task-flow.xml#informacion-task-flow','A',7,'Pendiente','2022-01-04 16:28:04','manual'),(13,3,'P','IW-EN-001','Reportes','/WEB-INF/reporte-task-flow.xml#reporte-task-flow','A',1,'Pendiente','2022-01-05 04:54:14','manual'),(14,4,'P','CS_001','Cliente','/WEB-INF/cliente-task-flow#cliente-task-flow','A',2,'omar','2022-01-06 13:43:16','/ViewControllerAdministrativo'),(15,2,'P','GS-US-001','Usuarios','/WEB-INF/usuario-task-flow.xml#usuario-task-flow','A',5,'omar','2022-01-08 05:40:54','/ViewControllerAdministrativo'),(16,2,'P','GS-MD-001','Modulos','/WEB-INF/modulo-task-flow.xml#modulo-task-flow','A',1,'omar','2022-01-20 13:53:00','/ViewControllerAdministrativo'),(17,2,'P','GS_CC_001','Cambio Clave','/WEB-INF/clave-task-flow.xml#clave-task-flow','A',8,'omar','2022-01-25 04:46:58','/Administrativo-001'),(18,4,'P','CS_PR_001','Proyecto','/WEB-INF/proyecto-task-flow#proyecto-task-flow','A',1,'omar','2022-01-25 14:42:01','/Administrativo-001'),(19,4,'P','CS_CT_001','Contacto','/WEB-INF/contacto-task-flow#contacto-task-flow','A',3,'omar','2022-02-08 14:53:37','/Administrativo-001'),(20,6,'P','MV_RG_001','Manifiesto ADM','/WEB-INF/manifiesto-usuario-task-flow.xml#manifiesto-usuario-task-flow','A',2,'omar','2022-02-18 18:18:04','/Administrativo-001'),(21,6,'P','MV_AL_001','Manifiesto Vuelo USU','/WEB-INF/manifiesto-usuario-task-flow.xml#manifiesto-usuario-task-flow','A',2,'omar','2022-02-18 20:10:46','/Administrativo-001'),(22,6,'P','MV_LD_001','Libro Direcciones','/WEB-INF/libro-direccion-task-flow.xml#libro-direccion-task-flow','A',1,'omar','2022-02-20 16:37:18','/Administrativo-001'),(23,6,'P','MV_TT_001','Tasas Timbres','/WEB-INF/tasa-task-flow.xml#tasa-task-flow','A',2,'admin','2022-03-15 18:03:26','/Administrativo-001'),(24,6,'P','MV_ER_001','Errores Envio JDE','/WEB-INF/error-rest-task-flow.xml#error-rest-task-flow','A',2,'admin','2022-03-15 18:03:26','/Administrativo-001'),(25,9,'R','GS-MD-011','Modulos','/modulos/**','A',1,'nodata','2022-12-14 05:45:19','none'),(26,2,'P','GS_US_011','Usuarios','/usuarios/**','A',2,'omar78','2022-12-17 20:44:33','/Administrativo-001'),(27,9,'R','GS_US_011','Usuarios','/usuarios/**','A',2,'omar78','2022-12-17 21:10:39','/Administrativo-001'),(28,9,'R','GS_TK_011','Tokens','/tokens/**','A',3,'omar78','2022-12-17 21:24:30','/Administrativo-001'),(29,9,'R','GS_PR_011','Parametros','/parametros/**','A',4,'omar78','2022-12-17 21:32:16','/Administrativo-001'),(30,9,'R','GS_LG_011','Login','/login/**','A',0,'omar78','2022-12-17 21:41:38','/Administrativo-001'),(31,9,'R','GS_MN_011','Menu','/menu/**','A',6,'omar78','2022-12-17 22:01:52','/Administrativo-001');
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
  PRIMARY KEY (`id_modulo`),
  KEY `modulo_indice_IDX` (`indice`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` (`id_modulo`, `indice`, `nombre`, `contexto`, `usuario`, `usuario_fecha`, `usuario_programa`, `estado`) VALUES (1,'LG_001_00','Login','http://192.168.1.7:28080/Login-001/faces/LOG001?server=GF5&?token=','ovelez','2021-05-16 22:47:55','manual','A'),(2,'GS_001_00','Administrativo','http://192.168.1.7:28082/Administrativo-001/faces/LOG001?server=GF5&?token=','Pendiente','2021-07-07 23:24:44','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT','A'),(3,'IW_001_00','Reportes Impresiones','ViewControllerReportes/faces/LOG001','Pendiebnte','2022-01-05 04:52:13','manual','I'),(4,'CS_001_00','Cliente SAF','Cliente-001/faces/LOG001','omar','2022-01-06 13:40:57','/ViewControllerAdministrativo','I'),(6,'MV_001_00','Manifiesto','http://192.168.1.7:28083/Manifiesto-001/faces/LOG001?server=GF5&?token=','omar','2022-02-18 18:13:50','/Administrativo-001','A'),(7,'GA_001_00','Servicios Reportes Notificaciones','Archivo-001/faces/LOG001','omar','2022-02-25 04:30:28','/Administrativo-001','I'),(8,'BD_001_00','Base Desarrollo','BaseDesarrollo-001/faces/LOG001','omar','2022-02-25 04:30:28','/Administrativo-001','I'),(9,'GS_001_10','REST Administrativo','http://127.0.0.1:8080/gs_001_10','none','2022-10-30 15:55:45','GS_001_00 1.0.0','A');
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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` (`id_parametro`, `id_modulo`, `indice`, `clave`, `nombre`, `descripcion`, `valor_texto_01`, `valor_texto_02`, `valor_numero_01`, `valor_numero_02`, `default_texto_01`, `default_texto_02`, `default_numero_01`, `default_numero_02`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (2,1,'002','N','Tiempo de espera ante intentos fallidos','Tiempo en horas, antes que la clave vuelva a estar activo','','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(8,1,'001','N','Numero de Intentos','Numero de Intentos que el login tendra antes de bloquear',NULL,NULL,3,0,'<No Definido>','<No Definido>',3,0,'Pendiente','2021-07-05 21:54:10','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(9,1,'003','N',' reCAPTCHA','reCAPTCHA al sitio web  \"loginADF\"','6LfRpt8bAAAAAFUbbzttVV5FrAhSiIN5vZUsekSL','6LfRpt8bAAAAANCPK5xqiHX2GTp3xC7MmTSL-p4o',NULL,NULL,'Clave del sitio Web','Clave secreta Servidor',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(10,1,'004','N','Contexto Usuario','Contexto Usuario nuevo y/o cambio clave + id_menu del menu que tiene esta inforamcion','http://192.168.1.7:28082/Administrativo-001/faces/LOG000?server=GF5&?token=','',17,NULL,'Contexto de Usuario','Contexto de Usuario',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(11,1,'005','N','Plantilla notificación enviar token','id Plantilla notificación enviar token',NULL,NULL,1,NULL,'Expresión Regular de validación','Mensaje de validación',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(14,8,'200','N','Path Relativo','Path Relativo para guardado de archivos','/home/omarv/',NULL,NULL,NULL,'/homo/user','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(15,1,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','WLS12','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(16,2,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','WLS12','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(18,8,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(19,2,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(20,1,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(21,6,'200','N','Path Relativo','Path Relativo para guardado de archivos','/home/colaborador/',NULL,NULL,NULL,'/homo/user','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(23,2,'001','N','Expresion Regular para el cambio de claves','Expresion regular para claves ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','Debe contener: del 0-9, A-Z, a-z y los caracteres ! @ # & ( ) ; en un largo de 8-20 caracteres ',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(26,6,'001','N','URL Servicio manifiesto JDE','URL Servicio manifiesto JDE','https://186.31.107.90:8089/PY920/IntegracionPortalTasasTimbres',NULL,NULL,NULL,'https://186.31.107.90:8089/PY920/IntegracionPortalTasasTimbres','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(27,6,'002','N','Usuario/Clave URL Servicio manifiesto JDE','Usuario/Clave URL Servicio manifiesto JDE','CONSULTOR','C0nsult0r2021#*',NULL,NULL,'Usuario/Clave asignado desde  JDE ','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(28,6,'003','N','Path de archivo de llave SSL','Path de archivo de llave SSL que debe ser obtenida desde el sitio https','/home/omarv/ssl_jde_aerocivil','1937480',NULL,NULL,'Clave asignada de JDE','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(29,1,'006','N','URL empresarial','Url empresarial','https://www.aerocivil.gov.co/',NULL,1,NULL,'Url del sitio web de la empresa','',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(30,1,'007','N','URL Declaimer','URL de declaimer del sitio web, se usa para dar informacion legal o de contenido variado','https://www.elcarrocolombiano.com/noticias/mitsubishi-asx-2023-basado-en-captur-nuevos-datos/',NULL,1,NULL,'Url del Declamer','',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(31,6,'004','N','Dias de seguridad para ingreso de Cierres','Dias de seguridad para ingreso de Cierres','','',30,NULL,'','',30,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(32,6,'005','N','Maximo de ocupantes de los aviones','Maximo de ocupantes de los aviones validaciones','','',501,NULL,'','',501,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),(33,2,'300','N','Notificacion Crear Clave ','Notificacion Crear Clave (Formato y Servicio)',NULL,NULL,2,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manul'),(34,1,'300','N','Notificacion Solicitud Nueva Clave','Notificacion Solicitud Nueva Clave (Formato y Servicio)',NULL,NULL,1,1,NULL,NULL,1,1,'ovelez','2022-06-11 18:43:12','manual'),(35,2,'301','N','Notificacion Cambio Clave ','Notificacion Cambio Clave (Formato y Servicio)',NULL,NULL,1,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manul'),(36,6,'50','N','Logout del modulo','Logout del modulo','http://192.168.1.7:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'pendiente','2022-04-19 04:10:11','manual'),(37,9,'002','N','Tiempo de espera ante intentos fallidos','Tiempo en horas, antes que la clave vuelva a estar activo','','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(38,9,'001','N','Numero de Intentos','Numero de Intentos que el login tendra antes de bloquear',NULL,NULL,3,0,'<No Definido>','<No Definido>',3,0,'Pendiente','2021-07-05 21:54:10','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(39,9,'003','N',' reCAPTCHA','reCAPTCHA al sitio web  \"loginADF\"','6LfRpt8bAAAAAFUbbzttVV5FrAhSiIN5vZUsekSL','6LfRpt8bAAAAANCPK5xqiHX2GTp3xC7MmTSL-p4o',NULL,NULL,'Clave del sitio Web','Clave secreta Servidor',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(41,9,'005','N','Plantilla notificación enviar token','id Plantilla notificación enviar token',NULL,NULL,1,NULL,'Expresión Regular de validación','Mensaje de validación',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),(42,9,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','SPRING','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(46,9,'300','N','Notificacion Solicitud Nueva Clave','Notificacion Solicitud Nueva Clave (Formato y Servicio)',NULL,NULL,1,1,NULL,NULL,1,1,'ovelez','2022-06-11 18:43:12','manual'),(49,9,'004','N','Expresion Regular para el cambio de claves','Expresion regular para claves ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','Debe contener: del 0-9, A-Z, a-z y los caracteres ! @ # & ( ) ; en un largo de 8-20 caracteres ',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),(50,9,'301','N','Notificacion Crear Clave ','Notificacion Crear Clave (Formato y Servicio)',NULL,NULL,2,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manual'),(51,9,'302','N','Notificacion Cambio Clave ','Notificacion Cambio Clave (Formato y Servicio)',NULL,NULL,1,1,'','',1,1,'ovelez','2022-06-11 17:48:25','manual');
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso` (
  `id_permiso` int NOT NULL AUTO_INCREMENT,
  `id_menu` int DEFAULT NULL COMMENT 'Id de menu',
  `id_rol` int DEFAULT NULL COMMENT 'Id de Rol',
  `crear` varchar(8) NOT NULL COMMENT 'Si el menu permite crear',
  `actualizar` varchar(8) NOT NULL COMMENT 'Si el menu permite actualizar',
  `borrar` varchar(8) NOT NULL COMMENT 'Si el menu permite borrar',
  `ver_auditoria` varchar(8) NOT NULL COMMENT 'Si el menu permite ver la auditoria',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_permiso`),
  KEY `permiso_FK` (`id_rol`),
  KEY `permiso_FK_1` (`id_menu`),
  CONSTRAINT `permiso_FK` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `permiso_FK_1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` (`id_permiso`, `id_menu`, `id_rol`, `crear`, `actualizar`, `borrar`, `ver_auditoria`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (4,6,1,'S','S','S','S','Pendiente','2021-07-09 05:02:38','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(8,6,4,'S','S','S','S','Pendiente','2021-07-09 05:10:35','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(9,6,2,'S','S','S','S','Pendiente','2021-07-09 05:11:59','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(11,9,1,'S','S','S','S','Pendiente','2021-07-09 05:20:01','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(12,10,1,'S','S','S','S','Pendiente','2021-07-11 17:45:20','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(13,10,2,'S','S','S','S','Pendiente','2021-07-11 17:45:29','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(14,10,4,'S','S','S','S','Pendiente','2021-07-11 17:45:45','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(15,11,4,'S','S','S','S','Pendiente','2022-01-04 15:54:50','manual'),(17,12,4,'S','S','S','S','Pendiente','2022-01-04 16:28:32','manual'),(18,3,4,'S','S','S','S','Pendiente','2022-01-05 04:41:15','manual'),(19,13,1,'S','S','S','N','Pendiente','2022-01-05 04:54:43','manual'),(20,14,7,'S','S','S','S','omar','2022-01-06 13:44:28','/ViewControllerAdministrativo'),(21,14,7,'S','S','S','S','omar','2022-01-06 13:46:02','/ViewControllerAdministrativo'),(22,14,7,'S','S','S','S','omar','2022-01-06 13:46:13','/ViewControllerAdministrativo'),(23,15,1,'S','S','S','S','omar','2022-01-08 05:55:12','/ViewControllerAdministrativo'),(24,15,2,'S','S','S','S','omar','2022-01-08 05:55:38','/ViewControllerAdministrativo'),(25,3,1,'S','S','S','S','omar','2022-01-19 04:56:31','/ViewControllerAdministrativo'),(28,3,3,'S','S','S','S','omar','2022-01-19 05:26:01','/ViewControllerAdministrativo'),(29,3,5,'S','S','S','S','omar','2022-01-19 05:26:09','/ViewControllerAdministrativo'),(31,16,1,'S','S','S','S','omar','2022-01-20 16:02:05','/ViewControllerAdministrativo'),(32,16,4,'S','S','S','S','omar','2022-01-20 16:02:10','/ViewControllerAdministrativo'),(48,9,4,'S','S','S','S','omar','2022-01-20 18:30:18','/ViewControllerAdministrativo'),(49,17,1,'S','S','S','N','omar','2022-01-25 04:47:25','/Administrativo-001'),(50,17,2,'S','S','S','N','omar','2022-01-25 04:47:38','/Administrativo-001'),(51,17,3,'S','S','S','N','omar','2022-01-25 04:47:45','/Administrativo-001'),(52,17,5,'S','S','S','N','omar','2022-01-25 04:47:50','/Administrativo-001'),(53,17,4,'S','S','S','N','omar','2022-01-25 04:47:56','/Administrativo-001'),(54,18,7,'S','S','S','S','omar','2022-01-25 14:42:53','/Administrativo-001'),(55,18,7,'S','S','S','S','omar','2022-01-25 14:42:58','/Administrativo-001'),(56,19,7,'S','S','S','S','omar','2022-02-08 14:54:00','/Administrativo-001'),(57,20,8,'S','S','S','S','omar','2022-02-18 18:20:43','/Administrativo-001'),(59,22,8,'S','S','S','S','omar','2022-02-20 16:38:43','/Administrativo-001'),(64,9,8,'S','S','S','S','admin','2022-03-08 21:01:15','/Administrativo-001'),(65,6,8,'S','S','S','S','admin','2022-03-08 21:01:30','/Administrativo-001'),(67,10,8,'S','S','S','S','admin','2022-03-08 21:02:35','/Administrativo-001'),(69,20,3,'S','S','S','S','admin','2022-03-08 21:04:58','/Administrativo-001'),(72,21,5,'S','S','S','S','admin','2022-03-09 14:32:55','/Administrativo-001'),(73,12,3,'S','S','S','S','admin','2022-03-09 14:40:38','/Administrativo-001'),(74,12,5,'S','S','S','S','admin','2022-03-09 14:40:43','/Administrativo-001'),(75,22,5,'S','S','S','S','admin','2022-03-09 14:54:51','/Administrativo-001'),(76,22,3,'S','S','S','S','admin','2022-03-09 15:05:07','/Administrativo-001'),(77,23,3,'S','S','S','S','admin','2022-03-15 18:03:52','/Administrativo-001'),(78,23,5,'S','S','S','S','admin','2022-03-15 18:03:59','/Administrativo-001'),(79,21,3,'S','S','S','S','admin','2022-03-15 20:53:25','/Administrativo-001'),(80,15,3,'S','S','S','S','omar','2022-01-08 05:55:38','/ViewControllerAdministrativo'),(81,15,4,'S','S','S','S','omar','2022-01-08 05:55:38','/ViewControllerAdministrativo'),(82,15,5,'S','S','S','S','omar','2022-01-08 05:55:38','/ViewControllerAdministrativo'),(83,15,7,'S','S','S','S','omar','2022-01-08 05:55:38','/ViewControllerAdministrativo'),(84,15,8,'S','S','S','S','omar','2022-01-08 05:55:38','/ViewControllerAdministrativo'),(85,24,5,'S','S','S','S','admin','2022-03-15 18:03:59','/Administrativo-001'),(86,24,3,'S','S','S','S','admin','2022-03-15 18:03:59','/Administrativo-001'),(87,25,13,'S','N','S','S','omar','2022-01-08 05:55:38','/ViewControllerAdministrativo'),(89,26,13,'S','S','S','S','omar78','2022-12-17 20:47:01','/Administrativo-001'),(90,26,9,'S','S','S','S','omar78','2022-12-17 20:47:09','/Administrativo-001'),(91,27,13,'S','S','S','S','omar78','2022-12-17 21:11:16','/Administrativo-001'),(92,27,9,'S','S','S','S','omar78','2022-12-17 21:11:24','/Administrativo-001'),(93,25,9,'S','S','S','S','omar78','2022-12-17 21:21:29','/Administrativo-001'),(94,28,13,'S','S','S','S','omar78','2022-12-17 21:25:01','/Administrativo-001'),(95,28,9,'S','S','S','S','omar78','2022-12-17 21:25:08','/Administrativo-001'),(96,29,9,'S','S','S','S','omar78','2022-12-17 21:32:48','/Administrativo-001'),(97,29,13,'S','S','S','S','omar78','2022-12-17 21:32:55','/Administrativo-001'),(98,30,13,'S','S','S','S','omar78','2022-12-17 21:42:13','/Administrativo-001'),(99,30,9,'S','S','S','S','omar78','2022-12-17 21:42:18','/Administrativo-001'),(100,31,9,'S','S','S','S','omar78','2022-12-17 22:02:25','/Administrativo-001'),(101,31,13,'S','S','S','S','omar78','2022-12-17 22:02:34','/Administrativo-001');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int DEFAULT NULL COMMENT 'Menu al que afecta este modulo',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del rol',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de Rol tecnico en desarrollo JANZ',
  `estado` varchar(8) NOT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_rol`),
  KEY `rol_FK` (`id_modulo`),
  CONSTRAINT `rol_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id_rol`, `id_modulo`, `nombre`, `tipo`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (1,2,'Administrador','ADM','A','sdfsadf','2021-06-21 22:01:53','fsdfs'),(2,2,'Auditoria','LOG','A','Pendiente','2021-06-25 15:04:11','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(3,2,'Operador 01 Manifeisto','CLI-01','A','Pendiente','2021-06-25 15:04:45','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(4,2,'Root','ROOT','A','Pendiente','2021-07-09 04:53:42','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(5,2,'Operador 02 Manifeisto','CLI-02','A','Pendiente','2021-07-09 04:55:16','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(7,4,'Root Cliente SAF','ROOT','A','omar','2022-02-18 17:59:26','/Administrativo-001'),(8,6,'Root Manifeisto','ROOT','A','omar','2022-02-18 18:20:08','/Administrativo-001'),(9,9,'REST Administrador ','ADM','A','sdfsadf','2021-06-21 22:01:53','fsdfs'),(13,9,'REST Root','ROOT','A','Pendiente','2021-07-09 04:53:42','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_usuario`
--

DROP TABLE IF EXISTS `rol_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_usuario` (
  `id_rol_usuario` int NOT NULL AUTO_INCREMENT,
  `id_rol` int NOT NULL,
  `id_usuario` int NOT NULL,
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_rol_usuario`),
  KEY `rol_usuario_FK` (`id_rol`),
  KEY `rol_usuario_FK_1` (`id_usuario`),
  CONSTRAINT `rol_usuario_FK` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`),
  CONSTRAINT `rol_usuario_FK_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_usuario`
--

LOCK TABLES `rol_usuario` WRITE;
/*!40000 ALTER TABLE `rol_usuario` DISABLE KEYS */;
INSERT INTO `rol_usuario` (`id_rol_usuario`, `id_rol`, `id_usuario`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (6,1,13,'Pendiente','2021-07-01 16:57:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(8,4,13,'Pendiente','2021-07-02 22:10:48','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(9,1,15,'Pendiente','2021-07-04 22:30:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(10,4,15,'Pendiente','2021-07-09 14:04:34','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),(11,3,13,'omar','2022-01-06 13:46:34','/ViewControllerAdministrativo'),(14,5,17,'omar','2022-02-15 17:41:58','/Administrativo-001'),(15,8,13,'omar','2022-02-18 20:12:29','/Administrativo-001'),(18,3,17,'omar','2022-03-08 20:43:51','/Administrativo-001'),(19,5,18,'omar','2022-03-08 20:47:23','/Administrativo-001'),(23,8,19,'admin','2022-03-09 14:35:00','/Administrativo-001'),(24,3,19,'admin','2022-03-09 14:35:08','/Administrativo-001'),(26,3,9,'admin','2022-03-09 15:06:24','/Administrativo-001'),(27,5,9,'admin','2022-03-09 15:11:48','/Administrativo-001'),(28,3,18,'admin','2022-03-09 15:12:11','/Administrativo-001'),(29,3,20,'admin','2022-03-11 14:49:56','/Administrativo-001'),(30,5,20,'admin','2022-03-11 14:50:02','/Administrativo-001'),(44,1,37,'admin','2022-04-19 07:09:00','/Administrativo-001'),(45,1,38,'admin','2022-04-19 07:34:38','/Administrativo-001'),(46,1,39,'admin','2022-04-19 07:51:20','/Administrativo-001'),(47,1,40,'admin','2022-04-19 08:00:45','/Administrativo-001'),(48,2,41,'admin','2022-04-19 08:30:04','/Administrativo-001'),(49,1,42,'admin','2022-04-19 08:55:15','/Administrativo-001'),(51,1,44,'admin','2022-04-19 09:33:58','/Administrativo-001'),(52,1,45,'u023','2022-04-19 09:42:25','/Administrativo-001'),(53,13,13,'omar78','2022-12-15 04:02:12','/Administrativo-001'),(54,9,13,'omar78','2022-12-15 04:15:16','/Administrativo-001');
/*!40000 ALTER TABLE `rol_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `id_servicio` int NOT NULL AUTO_INCREMENT,
  `indice` varchar(64) NOT NULL COMMENT 'Indice del servicio',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de notificacion E correo, S sms, P push, Etc',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `usuario_proveedor` varchar(256) DEFAULT NULL COMMENT 'Usuario del proveedor del servicio',
  `token_proveedor` varchar(256) DEFAULT NULL COMMENT 'Clave, token o password del provedor',
  `configuracion_proveedor_01` varchar(1024) DEFAULT NULL COMMENT 'Configuracion del proveedor',
  `configuracion_proveedor_02` varchar(1024) DEFAULT NULL,
  `estado` varchar(8) DEFAULT NULL COMMENT 'Estado del servicio: A: activo, P: pausado y X borrado logico',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_servicio`),
  KEY `servicio_indice_IDX` (`indice`) USING BTREE,
  KEY `servicio_tipo_IDX` (`tipo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id_token` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de red social, L=linkeid, G=google, etc',
  `social_nick` varchar(256) NOT NULL COMMENT 'Nombre de usuario de red @omargo33',
  `correo` varchar(256) DEFAULT NULL COMMENT 'Correo electrónico',
  `token` varchar(512) NOT NULL COMMENT 'Token o clave encripatada',
  `validador` varchar(512) NOT NULL COMMENT 'Campo validacion de los campos ejecutados',
  `estado` varchar(8) NOT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_token`),
  KEY `token_FK` (`id_usuario`),
  CONSTRAINT `token_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` (`id_token`, `id_usuario`, `tipo`, `social_nick`, `correo`, `token`, `validador`, `estado`, `usuario`, `usuario_fecha`, `usuario_programa`) VALUES (2,9,'F','omargo22','omargo22@hotmail.com','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','123456','A','omar','2022-01-25 23:24:10','weblogic 12c'),(3,9,'C','sdfkjasli','ksjdfalk','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','111','A','omar','2022-01-25 23:24:10','weblogic 12c'),(4,15,'C','omar78','omargo33@hotmail.com','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','-1013466704','A','omar78','2022-06-15 01:36:05','/Administrativo-001'),(5,13,'C','admin','omargo@hotmail.com','$2a$10$NVlOF.3HeOk4I2CZwSdg8uby5SreRwgCm8yhmdjuF8Rtfzw4Os592','92668751','A','admin','2022-06-13 18:03:02','/Administrativo-001'),(6,17,'C','joy','omarfgo@gmail.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','777','A','joy','2022-01-25 23:25:37','weblogic 12c'),(7,18,'C','manifiesto','omarfgo@gmail.com','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','979921403','A','manifiesto','2022-05-02 16:15:03','/Usuario-001'),(8,19,'C','aerocivil','omargo33@gmail.com','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2069474610','A','aerocivil','2022-06-14 22:41:17','/Administrativo-001'),(9,20,'C','truiz','tania.ruiz@sicsas.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','110640424','A','admin','2022-03-11 14:48:03','/Administrativo-001'),(10,21,'C','ovelez','oamrgo@hotmail.com','{SHA-1}zCcnoUrDxkOppCip0kdiAGah/9I=','-1005040125','A','admin','2022-04-19 04:06:06','/Administrativo-001'),(25,36,'C','u001','u001@dom.com','{SHA-1}dy7jGVvJ8l2WzIBTSRLrQlL5RpA=','3533212','A','admin','2022-04-19 07:04:09','/Administrativo-001'),(26,37,'C','u002','u002@dom.com','F1FE2B6E33E2D6F424FF103C4616843D2F5BE523A2C8173055A6D4B040834DB3','3533213','A','admin','2022-04-19 07:08:43','/Administrativo-001'),(27,38,'C','u003','u003@doc.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','3533214','A','admin','2022-04-19 07:34:25','/Administrativo-001'),(28,39,'C','u015','u015@doc.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','3533247','A','admin','2022-04-19 07:51:10','/Administrativo-001'),(29,40,'C','u004','u004@doc.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','3533215','A','admin','2022-04-19 08:00:37','/Administrativo-001'),(30,41,'C','u010','u010@doc.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','3533242','A','admin','2022-04-19 08:29:51','/Administrativo-001'),(31,42,'C','u05','u05@doic.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','113978','A','admin','2022-04-19 08:55:04','/Administrativo-001'),(32,43,'C','u089','u089@gom.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','3533468','A','admin','2022-04-19 09:16:08','/Administrativo-001'),(33,44,'C','u023','u023@dog.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','3533276','A','admin','2022-04-19 09:33:44','/Administrativo-001'),(34,45,'C','u016','u016@doc.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','3533248','A','u023','2022-04-19 09:42:16','/Administrativo-001'),(35,20,'C','truiz','tania.ruiz@sicsas.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','001','A','none','2022-10-31 02:50:26','/Administrativo-001@GS_001_00-1.0.0'),(36,20,'C','truiz','tania.ruiz@sicsas.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','001','A','none','2022-10-31 02:50:29','/Administrativo-001@GS_001_00-1.0.0'),(37,20,'C','truiz','tania.ruiz@sicsas.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','001','A','none','2022-10-31 02:50:30','/Administrativo-001@GS_001_00-1.0.0'),(58,20,'C','truiz','tania.ruiz@sicsas.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','001','A','none','2022-10-31 03:26:59','/Administrativo-001@GS_001_00-1.0.0'),(59,20,'C','truiz','tania.ruiz@sicsas.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','001','A','none','2022-10-31 03:27:01','/Administrativo-001@GS_001_00-1.0.0'),(60,20,'C','truiz','tania.ruiz@sicsas.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','001','A','none','2022-10-31 03:27:01','/Administrativo-001@GS_001_00-1.0.0');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token_servidor`
--

DROP TABLE IF EXISTS `token_servidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token_servidor` (
  `id_token_servidor` int NOT NULL AUTO_INCREMENT,
  `id_token` int DEFAULT NULL,
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de encripcion AES DES JASCRIPT',
  `servidor` varchar(8) NOT NULL COMMENT 'Servidor que esta utilizando WL12=weblogic 12c  WF19=wildfly 19, GF5 glassfish 5',
  `password` varchar(512) DEFAULT NULL COMMENT 'Clave que se ha guardado password',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_token_servidor`),
  KEY `token_servidor_indice_IDX` (`tipo`),
  KEY `token_servidor_FK` (`id_token`),
  CONSTRAINT `token_servidor_FK` FOREIGN KEY (`id_token`) REFERENCES `token` (`id_token`)
) ENGINE=InnoDB AUTO_INCREMENT=724 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token_servidor`
--

LOCK TABLES `token_servidor` WRITE;
/*!40000 ALTER TABLE `token_servidor` DISABLE KEYS */;
INSERT INTO `token_servidor` (`id_token_servidor`, `id_token`, `tipo`, `servidor`, `password`, `usuario_fecha`, `usuario_programa`) VALUES (652,33,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-19 09:41:52','/Login-001'),(653,34,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-19 09:43:37','/Login-001'),(654,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-19 09:44:33','/Login-001'),(658,9,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 13:10:58','/Login-001'),(663,8,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 16:14:20','/Login-001'),(664,9,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 16:15:16','/Login-001'),(665,9,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 16:34:14','/Login-001'),(666,9,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 17:58:32','/Login-001'),(667,10,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 19:12:24','/Login-001'),(668,8,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 19:13:00','/Login-001'),(669,8,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 19:15:51','/Login-001'),(670,8,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 04:42:34','/Login-001'),(672,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 06:09:44','/Login-001'),(674,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 14:45:07','/Login-001'),(675,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 14:48:19','/Login-001'),(676,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 14:49:48','/Login-001'),(677,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 14:50:35','/Login-001'),(679,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 15:04:16','/Login-001'),(680,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 15:05:16','/Login-001'),(681,7,'JASCRIPT','WL12','{SHA-1}Ro6pXejEiYrcOt+g/E1J4G1uDws=','2022-05-02 15:07:31','/Login-001'),(684,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 15:27:59','/Login-001'),(686,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 15:30:11','/Login-001'),(688,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 15:44:34','/Login-001'),(689,7,'JASCRIPT','WL12','{SHA-1}ufgNSIOhpqhkD0wusY+xHke5794=','2022-05-02 15:47:58','/Login-001'),(693,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 15:54:32','/Login-001'),(695,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 16:03:47','/Login-001'),(697,7,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 16:14:39','/Login-001'),(698,7,'JASCRIPT','WL12','{SHA-1}ufgNSIOhpqhkD0wusY+xHke5794=','2022-05-02 16:16:08','/Login-001'),(699,4,'JASCRIPT','WL12','{SHA-1}GCkvbsrDEe+VZwka4Q6iLRobSo8=','2022-06-14 20:51:39','/Login-001'),(700,4,'JASCRIPT','WL12','{SHA-1}GCkvbsrDEe+VZwka4Q6iLRobSo8=','2022-06-14 20:53:15','/Login-001'),(701,4,'JASCRIPT','WL12','{SHA-1}GCkvbsrDEe+VZwka4Q6iLRobSo8=','2022-06-14 20:54:58','/Login-001'),(702,4,'JASCRIPT','WL12','{SHA-1}GCkvbsrDEe+VZwka4Q6iLRobSo8=','2022-06-14 20:59:08','/Login-001'),(703,4,'JASCRIPT','WL12','{SHA-1}GCkvbsrDEe+VZwka4Q6iLRobSo8=','2022-06-14 21:15:39','/Login-001'),(704,4,'JASCRIPT','WL12','{SHA-1}GCkvbsrDEe+VZwka4Q6iLRobSo8=','2022-06-14 21:17:29','/Login-001'),(705,4,'JASCRIPT','WL12','{SHA-1}GCkvbsrDEe+VZwka4Q6iLRobSo8=','2022-06-14 21:20:29','/Login-001'),(706,4,'JASCRIPT','WL12','{SHA-1}KgoR+jTF4ZMSQckErPfupY6X/4Y=','2022-06-14 21:24:19','/Login-001'),(707,4,'JASCRIPT','WL12','{SHA-1}Himv5qjSgFm5gvPGJoBpqq+NVW4=','2022-06-14 21:40:00','/Login-001'),(708,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 21:40:36','/Login-001'),(709,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 21:42:46','/Login-001'),(710,4,'JASCRIPT','WL12','{SHA-1}H9zjAZgGCQZEkPD7gQFHTG5aBuU=','2022-06-14 22:26:18','/Login-001'),(711,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 22:27:05','/Login-001'),(712,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 22:28:21','/Login-001'),(713,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 22:35:28','/Login-001'),(714,8,'JASCRIPT','WL12','{SHA-1}KJ28ZjU5T0VFj/eLqbKcJWrIlTk=','2022-06-14 22:40:38','/Login-001'),(715,8,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 22:41:26','/Login-001'),(716,8,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 22:43:59','/Login-001'),(717,4,'JASCRIPT','WL12','{SHA-1}FHUUjHtembkmTmGWYh5FJQ867WE=','2022-06-15 01:35:27','/Login-001'),(718,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-15 01:36:16','/Login-001'),(720,8,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-09-08 04:14:09','/Login-001'),(721,8,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-09-08 04:14:58','/Login-001'),(722,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-12-17 18:32:19','/Login-001'),(723,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-12-17 19:07:59','/Login-001');
/*!40000 ALTER TABLE `token_servidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `id_archivo` int DEFAULT NULL COMMENT 'Codigo de archivos que no tiene obligotariedad',
  `nick` varchar(128) DEFAULT NULL COMMENT 'Nick de Usuario',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de Usuario',
  `apellido` varchar(128) NOT NULL COMMENT 'Apellido de Usuario',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `validador` varchar(512) NOT NULL COMMENT 'Campo de validacion para los registros',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `contador_ingreso` int DEFAULT NULL COMMENT 'Contador de intentos fallidos',
  `contador_fecha` datetime DEFAULT NULL COMMENT 'Fecha y hora del intentos fallidos',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario_nick_IDX` (`nick`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `id_archivo`, `nick`, `nombre`, `apellido`, `usuario`, `validador`, `usuario_fecha`, `usuario_programa`, `estado`, `contador_ingreso`, `contador_fecha`) VALUES (9,NULL,'omar45','jk45','kljlkj','Pendiente','123','2021-06-22 17:10:25','/Login-001','A',0,'2022-03-11 14:30:05'),(13,NULL,'admin','admin','admin','dsfsadf','3414671','2021-06-22 17:29:13','/Login-001','A',0,'2022-12-17 23:40:19'),(15,NULL,'omar78','jklsdjfklaj','kjslkdfaj','jlksjdflkaj','kjsdalfkj','2021-06-22 21:39:42','/Login-001','A',0,'2022-12-17 19:07:59'),(17,NULL,'joy','Joy','Velez','omar','123','2022-01-22 03:19:16','/Login-001','A',1,'2022-04-21 15:10:30'),(18,NULL,'manifiesto','manifiesto','manifiesto','omar','123','2022-03-08 20:46:09','/Login-001','A',0,'2022-05-02 16:16:08'),(19,NULL,'aerocivil','aerocivil','aerocivil','admin','123','2022-03-08 20:54:53','/Login-001','A',0,'2022-09-08 04:14:58'),(20,NULL,'truiz','Tania','Ruiz','admin','123','2022-03-11 14:45:56','/Login-001','A',0,'2022-04-25 17:58:31'),(21,NULL,'ovelez','ovelez','ovelez','admin','123','2022-04-19 04:05:50','/Login-001','A',1,'2022-04-25 21:14:58'),(36,NULL,'u001','u001','u001','admin','123','2022-04-19 07:03:48','/Administrativo-001','A',0,NULL),(37,NULL,'u002','u002','u002','admin','123','2022-04-19 07:08:27','/Administrativo-001','A',0,NULL),(38,NULL,'u003','u003','u003','admin','123','2022-04-19 07:34:10','/Administrativo-001','A',0,NULL),(39,NULL,'u015','u015','u015','admin','123','2022-04-19 07:50:57','/Administrativo-001','A',0,NULL),(40,NULL,'u004','u004','u004','admin','123','2022-04-19 08:00:24','/Administrativo-001','A',0,NULL),(41,NULL,'u010','u010','u010','admin','123','2022-04-19 08:29:36','/Administrativo-001','A',0,NULL),(42,NULL,'u05','u05','u05','admin','123','2022-04-19 08:54:51','/Administrativo-001','A',0,NULL),(43,NULL,'u089','u089','u089','admin','123','2022-04-19 09:15:50','/Administrativo-001','A',0,NULL),(44,NULL,'u023','u023','u023','admin','123','2022-04-19 09:33:29','/Login-001','A',0,'2022-04-19 09:41:52'),(45,NULL,'u016','jk45-001','kljlkj','none','001','2022-10-30 23:48:41','rest-client@GS_001_00-1.0.0',NULL,NULL,NULL),(46,NULL,'omar45-001','jk45-001','kljlkj','none','001','2022-10-30 23:40:17','rest-client@GS_001_00 1.0.0','I',0,'2022-10-30 23:40:17');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_group_members`
--

DROP TABLE IF EXISTS `v_group_members`;
/*!50001 DROP VIEW IF EXISTS `v_group_members`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_group_members` AS SELECT 
 1 AS `NAME`,
 1 AS `MEMBER`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_groups`
--

DROP TABLE IF EXISTS `v_groups`;
/*!50001 DROP VIEW IF EXISTS `v_groups`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_groups` AS SELECT 
 1 AS `NAME`,
 1 AS `DESCRIPTION`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_menu`
--

DROP TABLE IF EXISTS `v_menu`;
/*!50001 DROP VIEW IF EXISTS `v_menu`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_menu` AS SELECT 
 1 AS `nick`,
 1 AS `id_menu`,
 1 AS `indice_menu`,
 1 AS `nombre_menu`,
 1 AS `task_flow`,
 1 AS `task_flow_informacion`,
 1 AS `tipo`,
 1 AS `indice_modulo`,
 1 AS `nombre_modulo`,
 1 AS `contexto`,
 1 AS `orden`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_menu_usuario`
--

DROP TABLE IF EXISTS `v_menu_usuario`;
/*!50001 DROP VIEW IF EXISTS `v_menu_usuario`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_menu_usuario` AS SELECT 
 1 AS `nick`,
 1 AS `id_menu`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_users`
--

DROP TABLE IF EXISTS `v_users`;
/*!50001 DROP VIEW IF EXISTS `v_users`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_users` AS SELECT 
 1 AS `id_usuario`,
 1 AS `DESCRIPTION`,
 1 AS `NAME`,
 1 AS `PASSWORD`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'GS_001_00'
--

--
-- Dumping routines for database 'GS_001_00'
--
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_actualizar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `permiso_menu_actualizar`(
 	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.actualizar  = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_borrar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `permiso_menu_borrar`(
 	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.borrar = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_crear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `permiso_menu_crear`(
 	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.crear = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_ver_auditoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `permiso_menu_ver_auditoria`(
 	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.ver_auditoria = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
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
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_codigo_definido_usuario_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pv_grupo varchar(128);
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, grupo into pi_orden_original, pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
	--
	-- CDU a destino
	select id_codigo_definido_usuario , orden into pi_id_codigo_definido_usuario_destino,  pi_orden_destino
	from codigo_definido_usuario
	where grupo = pv_grupo
	and orden = (
		select min(orden) 
		FROM codigo_definido_usuario 
		where grupo = pv_grupo
		and orden > pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_codigo_definido_usuario_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_destino
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;

   	--
	-- Cambia el destino	
   	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_original
   	where id_codigo_definido_usuario = pi_id_codigo_definido_usuario_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
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
	IN pii_extremo int, -- Se puede poner -1 o 1000 para los valores extremos.
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pv_grupo varchar(128);
	DECLARE pi_codigo_error int;

	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;          
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- Carga de datos para el proceso.
	SELECT grupo into pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
    -- Ubica para
   	UPDATE codigo_definido_usuario
   	SET orden = pii_extremo
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;   	
   
   	--
	-- Cambia los codigos reorganizados
   	CALL codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);
   	if poi_codigo_error > 0 then   		
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
   
	--
    -- Commit transaccion y fin de transaccion
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
	--
	-- Declaracion de cursor
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
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
   	-- Recorre cursor
   	open cr_orden;
   	rows_loop:loop
   		fetch cr_orden into cr_orden_destino, cr_id_codigo_definido_usuario, cr_orden_origen;
   		--
   		-- Salida de emergencia
   		if cr_done then
   			leave rows_loop;
   		end if;
   		--
		-- Actualizacion de ordemaniento	
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
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_codigo_definido_usuario_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pv_grupo varchar(128);
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, grupo into pi_orden_original, pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
	--
	-- CDU a destino
	select id_codigo_definido_usuario , orden into pi_id_codigo_definido_usuario_destino,  pi_orden_destino
	from codigo_definido_usuario
	where grupo = pv_grupo
	and orden = (
		select max(orden) 
		FROM codigo_definido_usuario 
		where grupo = pv_grupo
		and orden < pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_codigo_definido_usuario_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_destino
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;

   	--
	-- Cambia el destino	
   	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_original
   	where id_codigo_definido_usuario = pi_id_codigo_definido_usuario_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
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
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_menu_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pi_id_modulo varchar(128);
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, id_modulo into pi_orden_original, pi_id_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
	--
	-- CDU a destino
	select id_menu , orden into pi_id_menu_destino,  pi_orden_destino
	from menu
	where id_modulo = pi_id_modulo
	and orden = (
		select min(orden) 
		FROM menu 
		where id_modulo = pi_id_modulo
		and orden > pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_menu_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE menu
   	SET orden = pi_orden_destino
   	where id_menu = pii_id_menu;

   	--
	-- Cambia el destino	
   	UPDATE menu
   	SET orden = pi_orden_original
   	where id_menu = pi_id_menu_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.menu_ordenar(pi_id_modulo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
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
	IN pii_extremo int, -- Se puede poner -1 o 1000 para los valores extremos.
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pi_modulo varchar(128);
	DECLARE pi_codigo_error int;

	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;          
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- Carga de datos para el proceso.
	SELECT id_modulo into pi_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
    -- Ubica para
   	UPDATE menu
   	SET orden = pii_extremo
   	where id_menu = pii_id_menu;   	
   
   	--
	-- Cambia los codigos reorganizados
   	CALL menu_ordenar(pi_modulo,pi_codigo_error);
   	if poi_codigo_error > 0 then   		
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
   
	--
    -- Commit transaccion y fin de transaccion
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
	--
	-- Declaracion de cursor
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
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
   	-- Recorre cursor
   	open cr_orden;
   	rows_loop:loop
   		fetch cr_orden into cr_orden_destino, cr_id_menu, cr_orden_origen;
   		--
   		-- Salida de emergencia
   		if cr_done then
   			leave rows_loop;
   		end if;
   		--
		-- Actualizacion de ordemaniento	
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
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_menu_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pi_modulo int;
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, id_modulo into pi_orden_original, pi_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
	--
	-- CDU a destino
	select id_menu, orden into pi_id_menu_destino, pi_orden_destino
	from menu
	where id_modulo = pi_modulo
	and orden = (
		select max(orden) 
		FROM menu 
		where id_modulo = pi_modulo
		and orden < pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_menu_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE menu
   	SET orden = pi_orden_destino
   	where id_menu = pii_id_menu;

   	--
	-- Cambia el destino	
   	UPDATE menu
   	SET orden = pi_orden_original
   	where id_menu = pi_id_menu_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.menu_ordenar(pi_modulo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Current Database: `GS_001_00`
--

USE `GS_001_00`;

--
-- Final view structure for view `v_group_members`
--

/*!50001 DROP VIEW IF EXISTS `v_group_members`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`172.17.0.1` SQL SECURITY DEFINER */
/*!50001 VIEW `v_group_members` AS select `r`.`tipo` AS `NAME`,`u`.`nick` AS `MEMBER` from ((`rol` `r` join `rol_usuario` `ru`) join `usuario` `u`) where ((`ru`.`id_usuario` = `u`.`id_usuario`) and (`ru`.`id_rol` = `r`.`id_rol`) and (`u`.`estado` = 'A')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_groups`
--

/*!50001 DROP VIEW IF EXISTS `v_groups`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`172.17.0.1` SQL SECURITY DEFINER */
/*!50001 VIEW `v_groups` AS select `rol`.`tipo` AS `NAME`,`rol`.`nombre` AS `DESCRIPTION` from `rol` where (`rol`.`estado` = 'A') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_menu`
--

/*!50001 DROP VIEW IF EXISTS `v_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`172.17.0.1` SQL SECURITY DEFINER */
/*!50001 VIEW `v_menu` AS select `vmu`.`nick` AS `nick`,`m`.`id_menu` AS `id_menu`,`m`.`indice` AS `indice_menu`,`m`.`nombre` AS `nombre_menu`,`m`.`task_flow` AS `task_flow`,`m`.`task_flow` AS `task_flow_informacion`,`m`.`tipo` AS `tipo`,`md`.`indice` AS `indice_modulo`,`md`.`nombre` AS `nombre_modulo`,`md`.`contexto` AS `contexto`,`m`.`orden` AS `orden` from ((`modulo` `md` join `menu` `m`) join `v_menu_usuario` `vmu`) where ((`vmu`.`id_menu` = `m`.`id_menu`) and (`m`.`id_modulo` = `md`.`id_modulo`) and (`m`.`estado` = 'A') and (`md`.`estado` = 'A')) order by `m`.`orden` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_menu_usuario`
--

/*!50001 DROP VIEW IF EXISTS `v_menu_usuario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_menu_usuario` AS select distinct `u`.`nick` AS `nick`,`p`.`id_menu` AS `id_menu` from ((((`rol_usuario` `ru` join `rol` `r`) join `permiso` `p`) join `usuario` `u`) join `token` `t`) where ((`u`.`id_usuario` = `ru`.`id_usuario`) and (`ru`.`id_rol` = `r`.`id_rol`) and (`r`.`id_rol` = `p`.`id_rol`) and (`r`.`estado` = 'A') and (`u`.`estado` = 'A') and (`u`.`id_usuario` = `t`.`id_usuario`) and (`t`.`estado` = 'C') and (`p`.`id_menu` = (select `p`.`valor_numero_01` from (`parametro` `p` join `modulo` `m`) where ((`m`.`indice` = 'LG_001_00') and (`m`.`id_modulo` = `p`.`id_modulo`) and (`p`.`indice` = '004'))))) union all select distinct `u`.`nick` AS `nick`,`p`.`id_menu` AS `id_menu` from ((((`rol_usuario` `ru` join `rol` `r`) join `permiso` `p`) join `usuario` `u`) join `token` `t`) where ((`u`.`id_usuario` = `ru`.`id_usuario`) and (`ru`.`id_rol` = `r`.`id_rol`) and (`r`.`id_rol` = `p`.`id_rol`) and (`r`.`estado` = 'A') and (`u`.`estado` = 'A') and (`u`.`id_usuario` = `t`.`id_usuario`) and (`t`.`estado` = 'A')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_users`
--

/*!50001 DROP VIEW IF EXISTS `v_users`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`172.17.0.1` SQL SECURITY DEFINER */
/*!50001 VIEW `v_users` AS select `u`.`id_usuario` AS `id_usuario`,concat(`u`.`nombre`,' ',`u`.`apellido`) AS `DESCRIPTION`,`u`.`nick` AS `NAME`,(select `t`.`token` from `token` `t` where ((`t`.`id_usuario` = `u`.`id_usuario`) and (`t`.`tipo` = 'C')) limit 1) AS `PASSWORD` from `usuario` `u` where (`u`.`estado` = 'A') */;
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

-- Dump completed on 2023-02-05  4:14:33
