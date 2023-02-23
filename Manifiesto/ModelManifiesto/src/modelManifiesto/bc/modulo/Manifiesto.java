package modelManifiesto.bc.modulo;

import java.io.FileInputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import modelManifiesto.bc.entidad.ManifiestoImpl;

import model.utilidades.Atributos;

import modelManifiesto.bc.ManifiestoModuloImpl;

import modelManifiesto.bc.vista.ManifiestoViewImpl;

import oracle.jbo.JboException;
import oracle.jbo.Row;

/**
 * Objeto para acciones de procesos sobre el manifiesto.
 *
 * @author omargo33@hotmai.com
 */
public class Manifiesto {
    private static String SQL_UPDATE = "update manifiesto set estado = 'C' where estado like 'BAD%'";

    private static String SQL_UPDATE_ID_MANIFIESTO =
        "update manifiesto set estado = 'C' where estado like 'BAD%' and id_manifiesto = ?";


    /**
     * Metodo para cambiar el estado del manifiesto.
     *
     * @param manifiestoModulo
     * @param idManifiesto
     * @return
     */
    public static boolean cambiarEstado(ManifiestoModuloImpl manifiestoModulo, String idManifiesto) {
        boolean estado = true;
        manifiestoModulo.getBaseDML().ejecutaDML(SQL_UPDATE_ID_MANIFIESTO, new Object[] { idManifiesto });

        if (manifiestoModulo.getBaseDML().getMensaje() != null) {
            throw new JboException(manifiestoModulo.getBaseDML().getMensaje());
        }
        manifiestoModulo.commitRollback("", "");

        return estado;
    }

    /**
     * Metodo para cambiar el estado de forma completa.
     *
     * @param manifiestoModulo
     * @return
     */
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
