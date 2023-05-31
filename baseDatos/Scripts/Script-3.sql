SELECT * from libro_direccion ld where tipo = 'CA' and indice_secundario = 'N650MV';



SELECT DISTINCT (tipo) from libro_direccion ld;


select * from MV_001_00.libro_direccion where  UPPER(tipo) = UPPER('CA')