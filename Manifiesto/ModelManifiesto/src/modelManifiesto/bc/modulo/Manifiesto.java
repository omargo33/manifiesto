package modelManifiesto.bc.modulo;

import modelManifiesto.bc.ManifiestoModuloImpl;

import oracle.jbo.JboException;


public class Manifiesto {
    private static String SQL_UPDATE = "update manifiesto set estado = 'C' where estado like 'BAD%'";

    private static String SQL_UPDATE_ID_MANIFIESTO =
        "update manifiesto set estado = 'C' where estado like 'BAD%' and id_manifiesto = ?";


    public static boolean cambiarEstado(ManifiestoModuloImpl manifiestoModulo, String idManifiesto) {
        boolean estado = true;
        manifiestoModulo.getBaseDML().ejecutaDML(SQL_UPDATE_ID_MANIFIESTO, new Object[] { idManifiesto });

        if (manifiestoModulo.getBaseDML().getMensaje() != null) {
            throw new JboException(manifiestoModulo.getBaseDML().getMensaje());
        }
        manifiestoModulo.commitRollback("", "");

        return estado;
    }


    public static boolean cambiarEstadoCompleto(ManifiestoModuloImpl manifiestoModulo) {
        boolean estado = true;
        manifiestoModulo.getBaseDML().ejecutaDML(SQL_UPDATE, new Object[0]);
        if (manifiestoModulo.getBaseDML().getMensaje() != null) {
            throw new JboException(manifiestoModulo.getBaseDML().getMensaje());
        }
        manifiestoModulo.commitRollback("", "");

        return estado;
    }
}