CREATE TABLE "DATA".T_BT01_RECEPCION_ORDEN_COMPRA (
	ID NUMBER(38,0) NULL,
	USUARIO VARCHAR2(256) NULL,
	USUARIOFECHA TIMESTAMP NULL,
	VALORTEXTO VARCHAR2(256) NULL,
	VALORNUMERO NUMBER(4,0) NULL
)
TABLESPACE DATA_LAYER;
COMMENT ON TABLE "DATA".T_BT01_RECEPCION_ORDEN_COMPRA IS 'Recepcion de la orden de compra desde JDE.
@author bestech';
COMMENT ON COLUMN "DATA".T_BT01_RECEPCION_ORDEN_COMPRA.ID IS 'Identificador secuencial único';
COMMENT ON COLUMN "DATA".T_BT01_RECEPCION_ORDEN_COMPRA.USUARIO IS 'Usuario que ingresa el registro';
COMMENT ON COLUMN "DATA".T_BT01_RECEPCION_ORDEN_COMPRA.USUARIOFECHA IS 'Fecha del usuario';
COMMENT ON COLUMN "DATA".T_BT01_RECEPCION_ORDEN_COMPRA.VALORTEXTO IS 'Valor de pivot para elementos no esperados';
COMMENT ON COLUMN "DATA".T_BT01_RECEPCION_ORDEN_COMPRA.VALORNUMERO IS 'Valor de pivot para elmentos no esperados';
