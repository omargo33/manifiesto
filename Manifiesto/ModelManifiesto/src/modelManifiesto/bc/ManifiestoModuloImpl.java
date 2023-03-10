package modelManifiesto.bc;

import com.aplicaciones13.reporte.pdf.ImpresionBaseIText;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.ResultSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.bc.VistaObjeto;
import model.bc.modulo.Reporte;

import modelAuditoria.bc.AuditoriaModuloImpl;

import modelManifiesto.bc.common.ManifiestoModulo;
import modelManifiesto.bc.modulo.AerolineaUsuario;
import modelManifiesto.bc.modulo.FilaArchivo;
import modelManifiesto.bc.modulo.Manifiesto;
import modelManifiesto.bc.modulo.Rol;
import modelManifiesto.bc.reporte.Preliquidacion;
import modelManifiesto.bc.reporte.PreliquidacionCobro;
import modelManifiesto.bc.vista.ManifiestoInsertViewImpl;
import modelManifiesto.bc.vista.ManifiestoViewImpl;
import modelManifiesto.bc.vistaNoDML.LibroDireccionesViewNoDMLImpl;
import modelManifiesto.bc.vistaNoDML.ManifiestoViewNoDMLImpl;
import modelManifiesto.bc.vistaNoDML.UsuarioAsignadoViewNoDMLImpl;
import modelManifiesto.bc.vistaNoDML.UsuarioViewNoDMLImpl;

import modelManifiesto.utilidades.estructura.AerolineaUsuarioIndices;

import oracle.jbo.JboException;
import oracle.jbo.server.ViewLinkImpl;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Feb 18 01:00:06 ECT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ManifiestoModuloImpl extends AuditoriaModuloImpl implements ManifiestoModulo {

    AerolineaUsuarioIndices aerolineaUsuarioIndices = new AerolineaUsuarioIndices();

    final String SQL_MANIFIESTO_EXCEL =
        "SELECT id_manifiesto, id_usuario, nick, nombre_usuario, id_libro_direccion_aerolinea, indice_aerolinea, nombre_aerolinea, id_libro_direccion_aeropuerto, indice_aeropuerto, nombre_aeropuerto, id_libro_direccion_aeropuerto_des, indice_destino, nombre_destino, id_libro_direccion_aeronave, indice_aeronave, nombre_aeronave, fecha_local_operacion, fecha_corta_local_operacion, anio_fecha_operacion as 'año_fecha_operacion', mes_fecha_operacion, no_vuelo, pasajeros, pasajeros_transito, pasajeros_locales, pasajeros_exentos_tasas, pasajeros_pagan_tasas, pasajeros_pagan_dolares, pasajeros_pagan_pesos, pasajeros_exentos_timbres, pasajeros_pagan_timbres, pasajeros_pagan_timbres_dolares, pasajeros_pagan_timbres_pesos, tasa, CAST(timbre AS CHAR) timbre, CAST(timbre_total AS CHAR) timbre_total, indicador_comprobable, tipo, estado, usuario, usuario_fecha, usuario_programa FROM MV_001_00.v_manifiesto where";

    final String SQL_MANIFIESTO_PDF =
        "SELECT id_manifiesto, indice_aerolinea, nombre_aerolinea, indice_destino, nombre_destino, indice_aeronave, nombre_aeronave, fecha_corta_local_operacion, no_vuelo, pasajeros, pasajeros_transito, pasajeros_locales, pasajeros_exentos_tasas, pasajeros_pagan_tasas, pasajeros_exentos_timbres, pasajeros_pagan_timbres, timbre, timbre_total, tipo, estado  FROM MV_001_00.v_manifiesto where";

    final String SQL_MANIFIESTO_TOTALES =
        "SELECT sum(pasajeros) total_pasajeros, sum(pasajeros_transito)total_pasajeros_transito, sum(pasajeros_exentos_timbres) total_excentos_timbres FROM MV_001_00.v_manifiesto where";

    final String SQL_MANIFIESTO_TIMBRE = "select timbre from MV_001_00.tasa where nombre = ?";

    final String SQL_MANIFIESTO_AEROLINEA =
        "select indice_secundario, nombre, identificacion_fiscal, nombre_01, identificacion_01, nombre_02, Identificacion_02 from libro_direccion  where indice = ?";

    final String SQL_UPDATE_NOMBRES_AEROLINEA =
        "UPDATE libro_direccion SET nombre_01 = ?, identificacion_01 = ?, nombre_02 = ?, identificacion_02 = ?  WHERE indice = ?";


    /**
     * This is the default constructor (do not remove).
     */
    public ManifiestoModuloImpl() {
        super();
        setNombreBundle("modelManifiesto.ModelManifiestoBundle");
    }

    /**
     * Metodo para cambiar el estado del Manifiesto y evitar su edision.
     *
     * @param idManifiesto
     */
    public void cambiarEstadoManifiesto(String idManifiesto) {
        Manifiesto.cambiarEstado(this, idManifiesto);
    }

    /**
     * Metodo para cambiar el estado a todos los elementos.
     */
    public void cambiarEstadoManifiestos() {
        Manifiesto.cambiarEstadoCompleto(this);
    }

    /**
     * Metodo para subir archivos de manifiesto.
     *
     * @param id
     * @param esquema
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public Map<String, String> subirLoteArchivos(String id, String esquema, String tabla, String usuario,
                                                 String usuarioPrograma) {

        //Hace un commit para liberar data.
        commitRollback("subirLoteArchivos", "subirLoteArchivos");

        return procesarLotes(this, id, esquema, tabla, usuario, usuarioPrograma);
    }

    /**
     * Metodo para validar si un rol es usuario de un formato en particular
     *
     * @param nick
     * @param rol
     * @param indiceModulo
     * @return
     */
    public boolean isOnlyUsuarioRol(String nick, String rol, String indiceModulo) {
        return Rol.validarRolPorModulo(this, indiceModulo, rol, nick);
    }

    /**
     * Metodo para generar el archivo de excel de manifiesto.
     *
     * @param idUsuario
     * @param indiceAerolinea
     * @param indiceAeropuertoOrigen
     * @param indiceAeropuertoDestino
     * @param indiceAeronave
     * @param noVuelo
     * @param fechaInicio
     * @param fechaFin
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public int excelManifiesto(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen,
                               int indiceAeropuertoDestino, int indiceAeronave, String noVuelo, String fechaInicio,
                               String fechaFin, String tabla, String usuario, String usuarioPrograma) {
        int idArchivo = 0;
        String pattern = "yyyy-MM-dd-HH-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String nombrePagina = String.format("%s-%s-%s.xls", tabla, usuario, simpleDateFormat.format(new Date()));

        String sql = SQL_MANIFIESTO_EXCEL;

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
        if (noVuelo != null && noVuelo.trim().length() > 0 && noVuelo.compareTo("0") != 0) {
            sql = sql + " (UPPER(no_vuelo) LIKE UPPER('%" + noVuelo + "%') ) AND";
        }

        sql =
            sql + " (fecha_corta_local_operacion BETWEEN  '" + convertirDate(fechaInicio) + "'  AND  '" +
            convertirDate(fechaFin) + "')";

        ResultSet resultSet = this.getBaseDML().ejecutaConsulta(sql);
        if (this.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        idArchivo =
            Reporte.crearReporteExcel(this, resultSet, nombrePagina, "manifiesto", tabla, usuario, usuarioPrograma);
        return idArchivo;
    }

    /**
     * Metodo para calculos internos previo a la presentacion del PDF de pre calificacion
     *
     * @param idUsuario
     * @param indiceAerolinea
     * @param indiceAeropuertoOrigen
     * @param indiceAeropuertoDestino
     * @param indiceAeronave
     * @param noVuelo
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    public Map calculosPreCalificacion(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen,
                                       int indiceAeropuertoDestino, int indiceAeronave, String noVuelo,
                                       String fechaInicio, String fechaFin) {
        String sql = SQL_MANIFIESTO_TOTALES;
        int totalPasajeros = 0;
        int totalPasajerosTransito = 0;
        int totalExcenteosTimbres = 0;
        Object valorTimbre = new Object();
        Map<String, String> mapa = new HashMap<String, String>();

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
        if (noVuelo != null && noVuelo.trim().length() > 0 && noVuelo.compareTo("0") != 0) {
            sql = sql + " (UPPER(no_vuelo) LIKE UPPER('%" + noVuelo + "%') ) AND";
        }

        sql =
            sql + " (fecha_corta_local_operacion BETWEEN  '" + convertirDate(fechaInicio) + "'  AND  '" +
            convertirDate(fechaFin) + "')";

        ResultSet resultSet = this.getBaseDML().ejecutaConsulta(sql);
        if (this.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }
        try {
            while (resultSet.next()) {
                totalPasajeros = resultSet.getInt(1);
                totalPasajerosTransito = resultSet.getInt(2);
                totalExcenteosTimbres = resultSet.getInt(3);
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }

        valorTimbre =
            this.getBaseDML()
            .ejecutaConsultaUnicoDato(SQL_MANIFIESTO_TIMBRE, convertirDate(fechaInicio).substring(0, 4));

        mapa.put("fechaInicio", convertirDate(fechaInicio));
        mapa.put("fechaFin", convertirDate(fechaFin));
        mapa.put("totalPasajeros", String.valueOf(totalPasajeros));
        mapa.put("totalPasajerosTransito", String.valueOf(totalPasajerosTransito));
        mapa.put("totalPasajerosExcentosTimbre", String.valueOf(totalExcenteosTimbres));
        mapa.put("totalCobroImpuesto",
                 String.valueOf((totalPasajeros - totalPasajerosTransito - totalExcenteosTimbres)));
        mapa.put("totalCalculoImpuesto",
                 String.valueOf((totalPasajeros - totalPasajerosTransito - totalExcenteosTimbres)));
        mapa.put("tarifaImpuesto", String.valueOf(valorTimbre));

        resultSet = this.getBaseDML().ejecutaConsulta(SQL_MANIFIESTO_AEROLINEA, indiceAerolinea);
        if (this.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }
        try {
            while (resultSet.next()) {
                mapa.put("indiceAerolinea", String.valueOf(indiceAerolinea));
                mapa.put("siglaAerolineaOrigen", resultSet.getString(3));
                mapa.put("descripcionAerolineaOrigen", resultSet.getString(2));
                mapa.put("nombre01", resultSet.getString(4));
                mapa.put("identificacion01", resultSet.getString(5));
                mapa.put("nombre02", resultSet.getString(6));
                mapa.put("identificacion02", resultSet.getString(7));
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }

        return mapa;
    }

    /**
     * Metodo para generar el archivo de pdf de manifiesto.
     *
     * @param idUsuario
     * @param indiceAerolinea
     * @param indiceAeropuertoOrigen
     * @param indiceAeropuertoDestino
     * @param indiceAeronave
     * @param noVuelo
     * @param fechaInicio
     * @param fechaFin
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public int pdfManifiesto(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen,
                             int indiceAeropuertoDestino, int indiceAeronave, String noVuelo, String fechaInicio,
                             String fechaFin, String tabla, String usuario, String usuarioPrograma) {
        int idArchivo = 0;
        String pattern = "yyyy-MM-dd-HH-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String nombrePagina = String.format("%s-%s-%s.pdf", tabla, usuario, simpleDateFormat.format(new Date()));

        String sql = SQL_MANIFIESTO_PDF;

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
        if (noVuelo != null && noVuelo.trim().length() > 0 && noVuelo.compareTo("0") != 0) {
            sql = sql + " (UPPER(no_vuelo) LIKE UPPER('%" + noVuelo + "%') ) AND";
        }

        sql =
            sql + " (fecha_corta_local_operacion BETWEEN  '" + convertirDate(fechaInicio) + "'  AND  '" +
            convertirDate(fechaFin) + "')";

        ResultSet resultSet = this.getBaseDML().ejecutaConsulta(sql);
        if (this.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        Preliquidacion preliquidacion = new Preliquidacion();
        preliquidacion.setOrdenElementos(new int[] { 1, 2, 3 });
        preliquidacion.setValores(resultSet);
        ImpresionBaseIText impresionBaseIText = new ImpresionBaseIText(preliquidacion);

        Map<String, String> mapa = new HashMap<>();
        mapa.put("documentoNombre", "nombre");
        mapa.put("documentoCodigo", "codigo");
        mapa.put("documentoCodigo", "codigo");
        mapa.put("fechaInicio", fechaInicio);
        mapa.put("fechaFin", fechaFin);


        idArchivo =
            Reporte.crearReportePDF(this, impresionBaseIText, mapa, nombrePagina, "manifiesto", tabla, usuario,
                                    usuarioPrograma);
        return idArchivo;
    }

    /**
     * Metodo para generar la precalificacion.
     *
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @param mapa
     * @return
     */
    @SuppressWarnings("unchecked")
    public int pdfPreCalificacion(String tabla, String usuario, String usuarioPrograma, Map mapa) {
        int idArchivo = 0;
        String pattern = "yyyy-MM-dd-HH-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String nombrePagina = String.format("%s-%s-%s.pdf", tabla, usuario, simpleDateFormat.format(new Date()));

        PreliquidacionCobro preliquidacionCobro = new PreliquidacionCobro();
        preliquidacionCobro.setOrdenElementos(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        ImpresionBaseIText impresionBaseIText = new ImpresionBaseIText(preliquidacionCobro);

        mapa.put("documentoNombre", "nombre");
        mapa.put("documentoCodigo", "codigo");
        mapa.put("horizontal", "true");
        mapa.put("imagenColombia", base_obtenerParametroTexto01("201"));
        mapa.put("imagenAerocivil", base_obtenerParametroTexto01("202"));
        mapa.put("tituloImpuesto", base_obtenerParametroTexto01("203"));
        mapa.put("tituloDocumento", base_obtenerParametroTexto01("204"));

        try {
            int indice = Integer.parseInt(String.valueOf(mapa.get("indiceAerolinea")));
            updateNombresResponsables(indice, String.valueOf(mapa.get("nombre01")),
                                      String.valueOf(mapa.get("identificacion01")),
                                      String.valueOf(mapa.get("nombre02")),
                                      String.valueOf(mapa.get("identificacion02")));
        } catch (Exception e) {
            throw new JboException("No se puede actualizar responsables");
        }

        idArchivo =
            Reporte.crearReportePDF(this, impresionBaseIText, mapa, nombrePagina, "manifiesto", tabla, usuario,
                                    usuarioPrograma);
        return idArchivo;
    }

    /**
     * Metodo para actualizar los datos de responsables.
     *
     * @param indice
     * @param nombre01
     * @param identificacion01
     * @param nombre02
     * @param identificacion02
     */
    private void updateNombresResponsables(int indice, String nombre01, String identificacion01, String nombre02,
                                           String identificacion02) {
        this.getBaseDML()
            .ejecutaDML(SQL_UPDATE_NOMBRES_AEROLINEA, nombre01, identificacion01, nombre02, identificacion02, indice);

        if (this.getBaseDML().getMensaje() != null) {
            throw new JboException(this.getBaseDML().getMensaje());
        }
    }

    /**
     * Metodo para convertir una fecha.
     *
     * @param fechaStr
     * @return
     */
    private String convertirDate(String fechaStr) {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        DateFormat dateFormatSimple = new SimpleDateFormat("yyyy-MM-dd");
        String respuesta = fechaStr;
        try {
            java.util.Date fechaTemp = dateFormat.parse(fechaStr);
            respuesta = dateFormatSimple.format(fechaTemp);

        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        return respuesta;
    }

    /**
     * Metodo para buscar informacion del usuario de manifiesto.
     *
     * Consulta:
     * idUsuario por default
     *
     * @param nick
     * @return
     */
    public int getIdUsuarioNick(String nick) {
        aerolineaUsuarioIndices = AerolineaUsuario.buscarUsuario(this, nick);
        return aerolineaUsuarioIndices.getIdUsuario();
    }


    public int getIdAerolineaNick(String nick) {
        aerolineaUsuarioIndices = AerolineaUsuario.buscarUsuario(this, nick);
        return aerolineaUsuarioIndices.getIdAerolinea();
    }

    public int getIdAeropuertoNick(String nick) {
        aerolineaUsuarioIndices = AerolineaUsuario.buscarUsuario(this, nick);
        return aerolineaUsuarioIndices.getIdAeropuerto();
    }

    /**
     * Container's getter for InformacionView1.
     * @return InformacionView1
     */
    public VistaObjeto getInformacionView1() {
        return (VistaObjeto) findViewObject("InformacionView1");
    }

    /**
     * Container's getter for ManifiestoView1.
     * @return ManifiestoView1
     */
    public ManifiestoViewImpl getManifiestoView1() {
        return (ManifiestoViewImpl) findViewObject("ManifiestoView1");
    }


    /**
     * Container's getter for ManifiestoView1.
     * @return ManifiestoView1
     */
    public ManifiestoInsertViewImpl getManifiestoInsertView1() {
        return (ManifiestoInsertViewImpl) findViewObject("ManifiestoInsertView1");
    }


    /**
     * Container's getter for LibroDireccion1View1.
     * @return LibroDireccion1View1
     */
    public VistaObjeto getLibroDireccionView1() {
        return (VistaObjeto) findViewObject("LibroDireccionView1");
    }


    /**
     * Container's getter for UsuarioViewNoDML1.
     * @return UsuarioViewNoDML1
     */
    public UsuarioViewNoDMLImpl getUsuarioViewNoDML1() {
        return (UsuarioViewNoDMLImpl) findViewObject("UsuarioViewNoDML1");
    }

    /**
     * Container's getter for AerolineaUsuarioView2.
     * @return AerolineaUsuarioView2
     */
    public VistaObjeto getAerolineaUsuarioView2() {
        return (VistaObjeto) findViewObject("AerolineaUsuarioView2");
    }

    /**
     * Container's getter for AerolineaUsuarioView1.
     * @return AerolineaUsuarioView1
     */
    public VistaObjeto getAerolineaUsuarioView1() {
        return (VistaObjeto) findViewObject("AerolineaUsuarioView1");
    }

    /**
     * Container's getter for LibroDireccionAerolineaUsuarioLink1.
     * @return LibroDireccionAerolineaUsuarioLink1
     */
    public ViewLinkImpl getLibroDireccionAerolineaUsuarioLink1() {
        return (ViewLinkImpl) findViewLink("LibroDireccionAerolineaUsuarioLink1");
    }


    /**
     * Container's getter for UsuarioViewNoDML3.
     * @return UsuarioViewNoDML3
     */
    public model.bc.vistaNoDML.UsuarioViewNoDMLImpl getBase_UsuarioViewNoDML1() {
        return (model.bc.vistaNoDML.UsuarioViewNoDMLImpl) findViewObject("Base_UsuarioViewNoDML1");
    }

    /**
     * Container's getter for UsuarioAsignadoViewNoDML1.
     * @return UsuarioAsignadoViewNoDML1
     */
    public UsuarioAsignadoViewNoDMLImpl getUsuarioAsignadoViewNoDML1() {
        return (UsuarioAsignadoViewNoDMLImpl) findViewObject("UsuarioAsignadoViewNoDML1");
    }

    /**
     * Container's getter for LibroDireccionesViewNoDML1.
     * @return LibroDireccionesViewNoDML1
     */
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAeropuertoViewNoDML1() {
        return (LibroDireccionesViewNoDMLImpl) findViewObject("LibroDireccionesAeropuertoViewNoDML1");
    }

    /**
     * Container's getter for TasaView1.
     * @return TasaView1
     */
    public VistaObjeto getTasaView1() {
        return (VistaObjeto) findViewObject("TasaView1");
    }

    /**
     * Container's getter for ManifiestoViewNoDML1.
     * @return ManifiestoViewNoDML1
     */
    public ManifiestoViewNoDMLImpl getManifiestoViewNoDML1() {
        return (ManifiestoViewNoDMLImpl) findViewObject("ManifiestoViewNoDML1");
    }

    /**
     * Container's getter for LibroDireccionesViewNoDML1.
     * @return LibroDireccionesViewNoDML1
     */
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAeronaveViewNoDML1() {
        return (LibroDireccionesViewNoDMLImpl) findViewObject("LibroDireccionesAeronaveViewNoDML1");
    }

    /**
     * Container's getter for LibroDireccionesViewNoDML1.
     * @return LibroDireccionesViewNoDML1
     */
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAeropuertoDestinoViewNoDML1() {
        return (LibroDireccionesViewNoDMLImpl) findViewObject("LibroDireccionesAeropuertoDestinoViewNoDML1");
    }

    /**
     * Container's getter for LibroDireccionesViewNoDML1.
     * @return LibroDireccionesViewNoDML1
     */
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAerolineaViewNoDML1() {
        return (LibroDireccionesViewNoDMLImpl) findViewObject("LibroDireccionesAerolineaViewNoDML1");
    }


    /**
     * Metodo para procesar por lotes.
     *
     * Obtiene idGrupo.
     * Obtiene idArchivos y path's
     * Valida el contenido de los archivos.
     * De no haber errores guarda el archivo.
     *
     * @param id
     * @param esquema
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public Map<String, String> procesarLotes(ManifiestoModuloImpl manifiestoModulo, String id, String esquema,
                                             String tabla, String usuario, String usuarioPrograma) {
        Map<String, String> mapRespuesta = new HashMap<>();

        //TODO cambiar por SQL directo
        int idGrupo = this.base_grupoBuscarIdGrupo(Integer.parseInt(id), esquema, tabla);
        Map<String, String> mapaArchivos = this.base_grupoPathsArchivos(idGrupo);

        Iterator<String> it = mapaArchivos.keySet().iterator();
        while (it.hasNext()) {
            String clave = it.next();
            String path = mapaArchivos.get(clave);
            mapRespuesta.putAll(validarArchivoManifiesto(manifiestoModulo, Integer.parseInt(clave), path, usuario,
                                                         usuarioPrograma));
        }

        if (mapRespuesta.size() == 0) {
            it = mapaArchivos.keySet().iterator();
            while (it.hasNext()) {
                String clave = it.next();
                String path = mapaArchivos.get(clave);
                mapRespuesta.putAll(guardarArchivoManifiesto(manifiestoModulo, path, id, usuario, usuarioPrograma));
            }
        }

        return mapRespuesta;
    }

    /**
     * Metodo para validar el archivo de manifiesto con los procesos de:
     *
     * @param idArchivo
     * @param path
     * @return
     */
    private Map<String, String> validarArchivoManifiesto(ManifiestoModuloImpl manifiestoModulo, int idArchivo,
                                                         String path, String usuario, String usuarioPrograma) {
        Map<String, String> mapEventos = new HashMap<>();
        try {
            FilaArchivo filaTrabajo = new FilaArchivo();
            FileInputStream fs = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(fs);
            Sheet pagina = wb.getSheetAt(0);

            if (pagina != null) {
                int totalFilas = pagina.getLastRowNum();
                if (totalFilas > 0) {
                    for (int row = 0; row <= totalFilas; row++) {
                        filaTrabajo = new FilaArchivo(pagina, row);
                        if (!filaTrabajo.isValidar(manifiestoModulo)) {
                            mapEventos.put("P3-" + row,
                                           String.format("Linea %s %s", row, filaTrabajo.errorValidacion()));
                        }
                    }
                } else {
                    mapEventos.put("P2", "La página no tiene contenido");
                }
            } else {
                mapEventos.put("P1", "Archivo no tiene páginas");
            }
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }

        Iterator<String> it = mapEventos.keySet().iterator();
        while (it.hasNext()) {
            String valor = mapEventos.get(it.next());
            this.base_archivoCrearEvento(idArchivo, "P", valor, usuario, usuarioPrograma);
        }
        return mapEventos;
    }

    /**
     * Metodo para guardar la informacion en las tablas de manifiesto.
     *
     * @param path
     * @param id
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    private Map<String, String> guardarArchivoManifiesto(ManifiestoModuloImpl manifiestoModulo, String path, String id,
                                                         String usuario, String usuarioPrograma) {
        Map<String, String> mapEventos = new HashMap<>();
        try {
            FilaArchivo filaTrabajo = new FilaArchivo();
            FileInputStream fs = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(fs);
            Sheet pagina = wb.getSheetAt(0);

            if (pagina != null) {
                int totalFilas = pagina.getLastRowNum();
                if (totalFilas > 0) {
                    for (int row = 0; row <= totalFilas; row++) {
                        filaTrabajo = new FilaArchivo(pagina, row);
                        filaTrabajo.crearManifiesto(manifiestoModulo, id, usuario, usuarioPrograma);
                    }
                } else {
                    mapEventos.put("P1", "Archivo no tiene páginas");
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        return mapEventos;
    }
}
