SELECT
	r.tipo
from
	GS_001_00.usuario u,
	GS_001_00.rol_usuario ru,
	GS_001_00.rol r,
	GS_001_00.permiso p,
	GS_001_00.menu m,
	GS_001_00.modulo m2
where
	r.id_rol = ru.id_rol
	and ru.id_usuario = u.id_usuario
	and p.id_rol = r.id_rol
	and p.id_menu = m.id_menu
	and m.id_modulo = m2.id_modulo
--	and u.nick = 'admin'
--	and m2.indice = 'MV_001_00'
GROUP by
	r.tipo;