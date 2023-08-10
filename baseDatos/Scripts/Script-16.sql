
-- Crear Job
begin
dbms_scheduler.create_job (  
 job_name            => 'JOB_TEST_PEDIDOS',  
 job_type            => 'PLSQL_BLOCK',  
 job_action          => 'begin DATA.pk_jde_pedidos_ws.SP_ENVIARPEDIDOS(SYSDATE); end;',  
 number_of_arguments => 0,  
 start_date          => sysdate +30/24/59, -- sysdate + 30 minutos  
 job_class           => 'DEFAULT_JOB_CLASS',  -- Priority Group  
 enabled             => TRUE,  
 auto_drop           => TRUE,  
 comments            => 'JOB de prueba de pedidos');
end;

-- Ejecutar Job de manera manual sin esperar el time
begin  
	dbms_scheduler.run_job('JOB_TEST_PEDIDOS',TRUE);  
end;


-- Borrar Job
begin
dbms_scheduler.drop_job('JOB_TEST_PEDIDOS');
end;
