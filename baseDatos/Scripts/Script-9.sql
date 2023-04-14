## Crear usuario
CREATE USER 'sic'@'localhost' IDENTIFIED BY '1qaz2wsX!';

## Ver los permisos del usuario creado
SHOW GRANTS FOR 'sic'@'localhost';
## Dar permisos
GRANT ALL PRIVILEGES ON *.* TO 'sic'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'sic' WITH GRANT OPTION;


## Revocar privilegios
## REVOKE ALL PRIVILEGES ON *.* FROM 'sic'@'localhost';
## Activar privilegios
FLUSH PRIVILEGES;

## Ver los permisos del usuario creado para ver los cambios.
SHOW GRANTS FOR 'sic'@'localhost';



CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `MV_001_00`.`v_parametro` AS
select
    `p`.`id_parametro` AS `id_parametro`,
    `p`.`id_modulo` AS `id_modulo`,
    `p`.`indice` AS `indice`,
    `p`.`clave` AS `clave`,
    `p`.`nombre` AS `nombre`,
    `p`.`descripcion` AS `descripcion`,
    `p`.`valor_texto_01` AS `valor_texto_01`,
    `p`.`valor_texto_02` AS `valor_texto_02`,
    `p`.`valor_numero_01` AS `valor_numero_01`,
    `p`.`valor_numero_02` AS `valor_numero_02`,
    `p`.`default_texto_01` AS `default_texto_01`,
    `p`.`default_texto_02` AS `default_texto_02`,
    `p`.`default_numero_01` AS `default_numero_01`,
    `p`.`default_numero_02` AS `default_numero_02`,
    `p`.`usuario` AS `usuario`,
    `p`.`usuario_fecha` AS `usuario_fecha`,
    `p`.`usuario_programa` AS `usuario_programa`
from
    `GS_001_00`.`parametro` `p`;