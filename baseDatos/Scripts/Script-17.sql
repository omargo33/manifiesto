SET GLOBAL innodb_redo_log_capacity = 2*1024*1024*1024;
SET GLOBAL innodb_redo_log_capacity = 32*1024*1024;

SHOW GLOBAL STATUS LIKE 'Innodb_redo_log_capacity_resized';


SET GLOBAL skip-name-resolve = ON;


SHOW GLOBAL STATUS LIKE 'skip-name-resolve';

join_buffer_size


SET GLOBAL join_buffer_size=256000;
SHOW GLOBAL STATUS LIKE 'join_buffer_size';
