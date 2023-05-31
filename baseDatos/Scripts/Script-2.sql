select total_pasajeros, total_pasajeros_transito, total_excentos_timbres, (total_pasajeros + total_pasajeros_transito - total_excentos_timbres) pasajeros_sujetos_cobro from (
	SELECT sum(pasajeros) total_pasajeros, sum(pasajeros_transito)total_pasajeros_transito, sum(pasajeros_exentos_timbres) total_excentos_timbres FROM MV_001_00.v_manifiesto 
) as v


select timbre from MV_001_00.tasa where nombre = 2022;


SELECT sum(pasajeros) total_pasajeros, sum(pasajeros_transito)total_pasajeros_transito, sum(pasajeros_exentos_timbres) total_excentos_timbres FROM MV_001_00.v_manifiesto;

 

select indice_secundario, nombre  from libro_direccion  where indice = 217283


select timbre, nombre from MV_001_00.tasa where nombre = '2023'