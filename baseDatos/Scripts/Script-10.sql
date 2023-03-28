select
	xx.*
from
	(
	select
		vm.id_menu AS id_menus_permisos,
		vm.nick,
		vm.indice_modulo,
		vm.nombre_modulo,
		vm.contexto,
		vm.id_menu,
		vm.tipo,
		vm.indice_menu,
		vm.nombre_menu,
		vm.task_flow,
		vm.task_flow_informacion,
		vm.orden,
		GS_001_00.permiso_menu_crear(vm.id_menu,
		vm.nick) crear,
		GS_001_00.permiso_menu_actualizar(vm.id_menu,
		vm.nick) actualizar,
		GS_001_00.permiso_menu_borrar(vm.id_menu,
		vm.nick) borrar,
		GS_001_00.permiso_menu_ver_auditoria(vm.id_menu,
		vm.nick) ver_auditoria
	from
		GS_001_00.v_menu vm
	order by
		vm.orden ) xx
where
	xx.nick = 'joy'; 
