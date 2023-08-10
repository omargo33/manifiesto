select
	m.id_manifiesto AS id_manifiesto,
	m.id_usuario AS id_usuario,
	u.nick AS nick,
	concat(u.nombre, ' ', u.apellido) AS nombre_usuario,
	m.id_libro_direccion_aerolinea AS id_libro_direccion_aerolinea,
	aero.indice_secundario AS indice_aerolinea,
	aero.nombre AS nombre_aerolinea,
	m.id_libro_direccion_aeropuerto AS id_libro_direccion_aeropuerto,
	puer.indice_secundario AS indice_aeropuerto,
	puer.nombre AS nombre_aeropuerto,
	m.id_libro_direccion_aeropuerto_des AS id_libro_direccion_aeropuerto_des,
	dest.indice_secundario AS indice_destino,
	dest.nombre AS nombre_destino,
	m.id_libro_direccion_aeronave AS id_libro_direccion_aeronave,
	nave.indice_secundario AS indice_aeronave,
	nave.nombre AS nombre_aeronave,
	m.fecha_local_operacion AS fecha_local_operacion,
	cast(m.fecha_local_operacion as date) AS fecha_corta_local_operacion,
	year(m.fecha_local_operacion) AS anio_fecha_operacion,
	month(m.fecha_local_operacion) AS mes_fecha_operacion,
	m.no_vuelo AS no_vuelo,
	m.pasajeros AS pasajeros,
	ifnull(m.pasajeros_transito, 0) AS pasajeros_transito,
	(ifnull(m.pasajeros, 0) - ifnull(m.pasajeros_transito, 0)) AS pasajeros_locales,
	ifnull(m.pasajeros_exentos_tasas, 0) AS pasajeros_exentos_tasas,
	(
    	ifnull(m.pasajeros, 0) - 
    	ifnull(m.pasajeros_transito, 0) - 
    	ifnull(m.pasajeros_exentos_tasas, 0)
    ) AS pasajeros_pagan_tasas,
	ifnull(m.pasajeros_pagan_dolares, 0) AS pasajeros_pagan_dolares,
	(
    	ifnull(m.pasajeros, 0) - 
    	ifnull(m.pasajeros_transito, 0) - 
    	ifnull(m.pasajeros_exentos_tasas, 0) - 
    	ifnull(m.pasajeros_pagan_dolares, 0)
    ) AS pasajeros_pagan_pesos,
	(case
		when (m.tipo = 'N') then 0
		else ifnull(m.pasajeros_exentos_timbres, 0)
	end) AS pasajeros_exentos_timbres,
	(case
		when (m.tipo = 'N') then 0
		else (ifnull(m.pasajeros, 0) - ifnull(m.pasajeros_transito, 0) - ifnull(m.pasajeros_exentos_timbres, 0))
	end) AS pasajeros_pagan_timbres,
	(case
		when (m.tipo = 'N') then 0
		else ifnull(m.pasajeros_pagan_timbres_dolares, 0)
	end) AS pasajeros_pagan_timbres_dolares,
	(case
		when (m.tipo = 'N') then 0
		else (ifnull(m.pasajeros, 0) - ifnull(m.pasajeros_transito, 0) - ifnull(m.pasajeros_exentos_timbres, 0) - ifnull(m.pasajeros_pagan_timbres_dolares, 0))
	end) AS pasajeros_pagan_timbres_pesos,
	ifnull(t.tasa, 0) AS tasa,
	ifnull(t.timbre, 0) AS timbre,
	(case
		when (m.tipo = 'N') then 0
		else (ifnull(t.timbre, 0) * (ifnull(m.pasajeros, 0) - ifnull(m.pasajeros_transito, 0) - ifnull(m.pasajeros_exentos_timbres, 0)))
	end) AS timbre_total,
	m.indicador_comprobable AS indicador_comprobable,
	m.tipo AS tipo,
	m.estado AS estado,
	m.usuario AS usuario,
	m.usuario_fecha AS usuario_fecha,
	m.usuario_programa AS usuario_programa
from
	((((((MV_001_00.manifiesto m
left join GS_001_00.usuario u on
	((m.id_usuario = u.id_usuario)))
left join MV_001_00.libro_direccion aero on
	((aero.indice = m.id_libro_direccion_aerolinea)))
left join MV_001_00.libro_direccion puer on
	((puer.indice = m.id_libro_direccion_aeropuerto)))
left join MV_001_00.libro_direccion dest on
	((dest.indice = m.id_libro_direccion_aeropuerto_des)))
left join MV_001_00.libro_direccion nave on
	((nave.indice = m.id_libro_direccion_aeronave)))
left join MV_001_00.tasa t on
	((t.nombre = year(m.fecha_local_operacion))))
order by
	m.fecha_local_operacion desc;
    
   
   
   
   
