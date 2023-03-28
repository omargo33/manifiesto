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