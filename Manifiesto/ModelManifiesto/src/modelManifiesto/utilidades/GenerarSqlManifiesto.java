package modelManifiesto.utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para generar el operador de consultas de manifiesto.
 *
 * @author omargo33@hotmail.com
 * @since 2023-12-08
 *
 */
public class GenerarSqlManifiesto {
    public GenerarSqlManifiesto() {
        super();
    }

    /**
     * Metodo para generar el SQL rehutilizable de consulta de v_manifiesto
     * 
     * @param sqlBase
     * @param idUsuario
     * @param indiceAerolinea
     * @param indiceAeropuertoOrigen
     * @param indiceAeropuertoDestino
     * @param indiceAeronave
     * @param noVuelo
     * @param fechaInicio
     * @param fechaFin
     * @param idManifiesto
     * @param estado
     * @param tipoVuelo
     * @param tipoObservacion
     * @return
     */
    public static String generarSQLExtendido(String sqlBase, int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen,
                                    int indiceAeropuertoDestino, int indiceAeronave, String noVuelo, String fechaInicio,
                                    String fechaFin, String idManifiesto, String estado, String tipoVuelo,
                                    String tipoObservacion) {
        String sql = sqlBase + " where ";

            if (idUsuario > 0) {
                sql = sql + " (id_usuario = " + idUsuario + " )  AND";
            }
            if (indiceAerolinea > 0) {
                sql = sql + " (id_libro_direccion_aerolinea = " + indiceAerolinea + " )  AND";
            }
            if (indiceAeropuertoOrigen > 0) {
                sql = sql + " (id_libro_direccion_aeropuerto = " + indiceAeropuertoOrigen + " ) AND";
            }
            if (indiceAeropuertoDestino > 0) {
                sql = sql + " (id_libro_direccion_aeropuerto_des = " + indiceAeropuertoDestino + " ) AND";
            }
            if (indiceAeronave > 0) {
                sql = sql + " (id_libro_direccion_aeronave = " + indiceAeronave + " ) AND";
            }
            
            if (idManifiesto != null && idManifiesto.trim().length() > 0) {
                sql = sql + " (id_manifiesto = '" + idManifiesto + "' )";

                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "SQL " + sql);
                return sql;    
            }     
            
            if (noVuelo != null && noVuelo.trim().length() > 0 && noVuelo.compareTo("0") != 0) {
                sql = sql + " (UPPER(no_vuelo) LIKE UPPER('%" + noVuelo + "%') ) AND";
            }

            if (estado != null && estado.trim().length() > 0) {
                estado = estado.replaceFirst("!=", "<>");
                sql = sql + " (estado " + estado + ") AND";
            }

            if (tipoVuelo != null && tipoVuelo.trim().length() > 0) {
                sql = sql + " (tipo " + tipoVuelo + ") AND";
            }

            if (tipoObservacion != null && tipoObservacion.trim().length() > 0) {
                tipoObservacion = tipoObservacion.replaceFirst("!=", "<>");
                sql = sql + " (cancelado " + tipoObservacion + ") AND";
            }

            sql =
                sql + " (fecha_corta_local_operacion BETWEEN  '" + convertirDateString(fechaInicio) + "'  AND  '" +
                convertirDateString(fechaFin) + "')";

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "SQL " + sql);
        return sql;
    }


    /**
     * Metodo para convertir una fecha.
     *
     * @param fechaStr
     * @return
     */
    public static java.sql.Date convertirDate(String fechaStr) {
        
        
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try {
            java.util.Date fechaTemp = dateFormat.parse(fechaStr);
            java.sql.Date fechaSQLTemp = new java.sql.Date(fechaTemp.getTime());
            return fechaSQLTemp;
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        return null;
        
    }
    
    
    /**
     * Metodo para convertir una fecha.
     *
     * @param fechaStr
     * @return
     */
    public static String convertirDateString(String fechaStr) {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "fechaStr " +fechaStr);
        
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        DateFormat dateFormatSimple = new SimpleDateFormat("yyyy-MM-dd");
        String respuesta = fechaStr;
        try {
            java.util.Date fechaTemp = dateFormat.parse(fechaStr);
            respuesta = dateFormatSimple.format(fechaTemp);
            return respuesta; 
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        return respuesta;
    }

}
