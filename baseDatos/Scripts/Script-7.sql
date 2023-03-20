select
	((xx.id_menu * 100) + xx.id_rol) as id_permiso_rol,
	(
	select
		task_flow
	from
		menu
	where
		id_menu = xx.id_menu) as url,
	(
	select
		tipo
	from
		rol
	where
		id_rol = xx.id_rol) as rol,
	(
	select
		count(*)
	from
		permiso p2
	where
		p2.id_menu = xx.id_menu
		and p2.id_rol = xx.id_rol
		and p2.crear = 'S' ) as crear,
	(
	select
		count(*)
	from
		permiso p2
	where
		p2.id_menu = xx.id_menu
		and p2.id_rol = xx.id_rol
		and p2.actualizar = 'S' ) as actualizar,
	(
	select
		count(*)
	from
		permiso p2
	where
		p2.id_menu = xx.id_menu
		and p2.id_rol = xx.id_rol
		and p2.borrar = 'S' ) as borrar,
	(
	select
		count(*)
	from
		permiso p2
	where
		p2.id_menu = xx.id_menu
		and p2.id_rol = xx.id_rol
		and p2.ver_auditoria = 'S' ) as ver_auditoria
from
	(
	select
		p.id_menu,
		p.id_rol
	from
		permiso p,
		(
		select
			m.id_menu
		from
			menu m
		where
			m.id_modulo =(
			select
				id_modulo
			from
				modulo
			where
				indice = 'SI_001_10-1.0.0')) x
	where
		p.id_menu = x.id_menu
	group by
		p.id_menu,
		p.id_rol) xx