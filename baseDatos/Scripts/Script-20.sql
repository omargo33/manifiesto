select count(*) from MV_001_00.libro_direccion_intercambio ldi ;

SELECT User, Host FROM mysql.user;

show grants;



CREATE USER 'notificacion'@'%' IDENTIFIED BY '1qaz2wsX!';
GRANT ALL PRIVILEGES ON *.* TO 'notificacion'@'%';

CREATE USER 'manifiesto'@'%' IDENTIFIED BY '1qaz2wsX!';
GRANT ALL PRIVILEGES ON *.* TO 'manifiesto'@'%';

CREATE USER 'login'@'%' IDENTIFIED BY '1qaz2wsX!';
GRANT ALL PRIVILEGES ON *.* TO 'login'@'%';


CREATE USER 'base'@'%' IDENTIFIED BY '1qaz2wsX!';
GRANT ALL PRIVILEGES ON *.* TO 'base'@'%';


CREATE USER 'auditoria'@'%' IDENTIFIED BY '1qaz2wsX!';
GRANT ALL PRIVILEGES ON *.* TO 'auditoria'@'%';


CREATE USER 'administrativo'@'%' IDENTIFIED BY '1qaz2wsX!';
GRANT ALL PRIVILEGES ON *.* TO 'administrativo'@'%';

flush privileges;

