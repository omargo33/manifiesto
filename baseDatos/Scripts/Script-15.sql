SHOW INDEXES FROM permiso;


DROP INDEX servicio_tipo_IDX;

set FOREIGN_KEY_CHECKS=0; //disable checks

ALTER TABLE servicio DROP INDEX servicio_tipo_IDX;

set FOREIGN_KEY_CHECKS=1; //enable checks