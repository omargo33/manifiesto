select * from information_schema.table_constraints 
where CONSTRAINT_TYPE = 'FOREIGN KEY'
AND TABLE_SCHEMA = 'GS_001_00';


ALTER TABLE GS_001_00.token_servidor DROP FOREIGN KEY token_servidor_FK;