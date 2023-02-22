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

import modelManifiesto.bc.ManifiestoModuloImpl;

import oracle.jbo.JboException;

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

    /**
     * Metodo para procesar por lotes.
     *
     * Obtiene idGrupo.
     * Obtiene idArchivos y path's
     * Valida el contenido de los archivos.
     * De no haber errores guarda el archivo.
     *
     * @param manifiestoModulo
     * @param id
     * @param esquema
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public static Map<String, String> procesarLotes(ManifiestoModuloImpl manifiestoModulo, String id, String esquema,
                                                    String tabla, String usuario, String usuarioPrograma) {
        Map<String, String> mapRespuesta = new HashMap<>();
        int idGrupo = manifiestoModulo.base_grupoBuscarIdGrupo(Integer.parseInt(id), esquema, tabla);
        Map<String, String> mapaArchivos = manifiestoModulo.base_grupoPathsArchivos(idGrupo);

        Iterator<String> it = mapaArchivos.keySet().iterator();
        while (it.hasNext()) {
            String clave = it.next();
            String path = mapaArchivos.get(clave);
            mapRespuesta.putAll(validarArchivoManifiesto(manifiestoModulo, Integer.parseInt(clave), path, usuario,
                                                         usuarioPrograma));
        }

        if (mapRespuesta.size() == 0) {
            while (it.hasNext()) {
                String clave = it.next();
                String path = mapaArchivos.get(clave);
                mapRespuesta.putAll(guardarArchivoManifiesto(manifiestoModulo, Integer.parseInt(clave), path));
            }
        }

        return mapRespuesta;
    }

    /**
     * Metodo para validar el archivo de manifiesto con los procesos de:
     *
     * @param manifiestoModulo
     * @param idArchivo
     * @param path
     * @return
     */
    private static Map<String, String> validarArchivoManifiesto(ManifiestoModuloImpl manifiestoModulo, int idArchivo,
                                                                String path, String usuario, String usuarioPrograma) {
        Map<String, String> mapEventos = new HashMap<>();
        try {
            FileInputStream fs = new FileInputStream(path);
            Workbook wb = Workbook.getWorkbook(fs);
            Sheet[] paginas = wb.getSheets();
            FilaArchivo filaTrabajo = new FilaArchivo();
            if (paginas.length > 0) {
                Sheet pagina = paginas[0];
                int totalFilas = pagina.getRows();
                if (totalFilas > 2) {
                    for (int row = 2; row < totalFilas; row++) {
                        filaTrabajo = new FilaArchivo(pagina, row);
                        if (!filaTrabajo.isValidar(manifiestoModulo)) {
                            mapEventos.put("P3-" + row, row + " " + filaTrabajo.errorValidacion());
                        }
                    }
                } else {
                    mapEventos.put("P2", "La página no tiene contenido");
                }
            } else {
                mapEventos.put("P1", "Archivo no tiene páginas");
            }
        } catch (BiffException | IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }

        Iterator<String> it = mapEventos.keySet().iterator();
        while (it.hasNext()) {
            String valor = mapEventos.get(it.next());
            manifiestoModulo.base_archivoCrearEvento(idArchivo, "P", valor, usuario, usuarioPrograma);
        }
        return mapEventos;
    }

    /**
     * Metodo para guardar la informacion en las tablas de manifiesto.
     *
     * @param manifiestoModulo
     * @param clave
     * @param path
     * @return
     */
    private static Map<String, String> guardarArchivoManifiesto(ManifiestoModuloImpl manifiestoModulo, int clave,
                                                                String path) {
        Map<String, String> mapEventos = new HashMap<>();
        return mapEventos;
    }

    /**
     * Objeto con para la informacion del fila de archivo.
     *
     */
    static class FilaArchivo {

        private static String SQL_LIBRO_DIRECCIONES =
            "select count(*) existe from MV_001_00.libro_direccion ld where UPPER(indice_secundario) = UPPER(?) and UPPER(tipo) = UPPER(?)";

        private static String SQL_EXISTE_MANIFIESTO =
            "select count(0) from MV_001_00.manifiesto m where m.id_libro_direccion_aerolinea in ( select indice from MV_001_00.libro_direccion ld where UPPER(indice_secundario) = UPPER(?) and UPPER(tipo) = UPPER('C') ) and m.id_libro_direccion_aeropuerto in ( select indice from MV_001_00.libro_direccion ld where UPPER(indice_secundario) = UPPER(?) and UPPER(tipo) = UPPER('AR') ) and m.id_libro_direccion_aeropuerto_des in ( select indice from MV_001_00.libro_direccion ld where UPPER(indice_secundario) = UPPER(?) and UPPER(tipo) = UPPER('AR') ) and m.id_libro_direccion_aeronave in ( select indice from MV_001_00.libro_direccion ld where UPPER(indice_secundario) = UPPER(?) and UPPER(tipo) = UPPER('CA')) and upper(m.no_vuelo) = upper(?) and date(m.fecha_local_operacion) = date(str_to_date(?, '%Y-%m-%d'))";

        private String indiceAerolinea;
        private String indiceAeropuertoOrigen;
        private String indiceAeropuertoDestino;
        private String indiceAeronave;
        private String fecha;
        private String numeroVuelo;
        private String pasajeros;
        private String pasajerosTransito;
        private String pasajerosExentosTasas;
        private String pasajerosPaganDolares;
        private String pasajerosExcentosTimbres;
        private String pasajerosPaganTimbresDolares;
        private String tipo;

        private String mensaje;

        /**
         * Metodo constructor.
         *
         */
        public FilaArchivo() {
            this.indiceAerolinea = "";
            this.indiceAeropuertoOrigen = "";
            this.indiceAeropuertoDestino = "";
            this.indiceAeronave = "";

            this.fecha = "";
            this.numeroVuelo = "";
            this.pasajeros = "";
            this.pasajerosTransito = "";
            this.pasajerosExentosTasas = "";
            this.pasajerosPaganDolares = "";
            this.pasajerosExcentosTimbres = "";
            this.pasajerosPaganTimbresDolares = "";
            this.tipo = "";
        }

        /**
         * Metodo para validar los datos del registro.
         *
         * @param manifiestoModulo
         * @return
         */
        public boolean isValidar(ManifiestoModuloImpl manifiestoModulo) {
            if (!isPasajeros()) {
                return false;
            }

            if (!isPasajerosTransito()) {
                return false;
            }

            if (!isPasajerosExentosTasas()) {
                return false;
            }

            if (!isPasajerosPaganDolares()) {
                return false;
            }

            if (!isPasajerosExcentosTimbres()) {
                return false;
            }

            if (!isPasajerosPaganTimbresDolares()) {
                return false;
            }

            if (!isFecha()) {
                return false;
            }

            if (!isTipo()) {
                return false;
            }

            if (!isNumeroVuelo()) {
                return false;
            }

            if (!isAerolinea(manifiestoModulo)) {
                return false;
            }

            if (!isAeropuertoOrigen(manifiestoModulo)) {
                return false;
            }

            if (!isAeropuertoDestino(manifiestoModulo)) {
                return false;
            }

            if (!isAeronave(manifiestoModulo)) {
                return false;
            }            

            if (!isExisteRegistro(manifiestoModulo)) {
                return false;
            }
            
            if (this.tipo.compareTo("N") == 0) {
                this.pasajerosExcentosTimbres = "0";
                this.pasajerosPaganTimbresDolares = "0";
            }


            return true;
        }

        public String errorValidacion() {
            return mensaje;
        }

        /**
         * Metodo para crear el objeto.
         *
         * @param pagina
         * @param row
         */
        public FilaArchivo(Sheet pagina, int row) {
            this.indiceAerolinea = pagina.getCell(0, row).getContents();
            this.indiceAeropuertoOrigen = pagina.getCell(2, row).getContents();
            this.indiceAeropuertoDestino = pagina.getCell(3, row).getContents();
            this.indiceAeronave = pagina.getCell(4, row).getContents();
            this.fecha = pagina.getCell(5, row).getContents();
            this.numeroVuelo = pagina.getCell(8, row).getContents();

            this.pasajeros = pagina.getCell(9, row).getContents();
            this.pasajerosTransito = pagina.getCell(10, row).getContents();
            this.pasajerosExentosTasas = pagina.getCell(12, row).getContents();
            this.pasajerosPaganDolares = pagina.getCell(14, row).getContents();
            this.pasajerosExcentosTimbres = pagina.getCell(17, row).getContents();
            this.pasajerosPaganTimbresDolares = pagina.getCell(19, row).getContents();
            this.tipo = pagina.getCell(16, row).getContents();
        }

        public String getIndiceAerolinea() {
            return indiceAerolinea;
        }

        private boolean isLibroDirecciones(ManifiestoModuloImpl manifiestoModulo, String indice, String tipo) {
            Object data = manifiestoModulo.getBaseDML().ejecutaConsultaUnicoDato(SQL_LIBRO_DIRECCIONES, indice, tipo);
            if (data != null && String.valueOf(data).compareTo("1") == 0) {
                return true;
            }
            return false;
        }

        public boolean isAerolinea(ManifiestoModuloImpl manifiestoModulo) {
            if (isLibroDirecciones(manifiestoModulo, this.indiceAerolinea, "C")) {
                return true;
            }
            mensaje = "No se ha localizado la aerolinea";
            return false;
        }

        public void setIndiceAerolinea(String indiceAerolinea) {
            this.indiceAerolinea = indiceAerolinea;
        }

        public String getIndiceAeropuertoOrigen() {
            return indiceAeropuertoOrigen;
        }

        public boolean isAeropuertoOrigen(ManifiestoModuloImpl manifiestoModulo) {
            if (isLibroDirecciones(manifiestoModulo, this.indiceAeropuertoOrigen, "AR")) {
                return true;
            }
            mensaje = "No se ha localizado el aeropuerto origen";
            return false;
        }

        public void setIndiceAeropuertoOrigen(String indiceAeropuertoOrigen) {
            this.indiceAeropuertoOrigen = indiceAeropuertoOrigen;
        }

        public String getIndiceAeropuertoDestino() {
            return indiceAeropuertoDestino;
        }

        public boolean isAeropuertoDestino(ManifiestoModuloImpl manifiestoModulo) {
            if (isLibroDirecciones(manifiestoModulo, this.indiceAeropuertoDestino, "AR")) {
                return true;
            }
            mensaje = "No se ha localizado el aeropuerto destino";
            return false;
        }

        public void setIndiceAeropuertoDestino(String indiceAeropuertoDestino) {
            this.indiceAeropuertoDestino = indiceAeropuertoDestino;
        }

        public String getIndiceAeronave() {
            return indiceAeronave;
        }

        public void setIndiceAeronave(String indiceAeronave) {
            this.indiceAeronave = indiceAeronave;
        }

        public boolean isAeronave(ManifiestoModuloImpl manifiestoModulo) {
            if (isLibroDirecciones(manifiestoModulo, this.indiceAeropuertoDestino, "CA")) {
                return true;
            }
            mensaje = "No se ha localizado la aeronave";
            return false;
        }

        public Date getFecha() {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = formatter.parse(fecha);
            } catch (Exception e) {
                date = new Date();
            }
            return date;
        }


        public boolean isFecha() {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = formatter.parse(fecha);
            } catch (Exception e) {
                mensaje = "La fecha de operacion debe ser yyyy-mm-dd";
                return false;
            }
            return true;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getNumeroVuelo() {
            return numeroVuelo;
        }

        public void setNumeroVuelo(String numeroVuelo) {
            this.numeroVuelo = numeroVuelo;
        }

        public boolean isNumeroVuelo() {
            if (this.numeroVuelo == null) {
                mensaje = "Numero de vuelo no puede estar vacio";
                return false;
            }

            if (this.numeroVuelo
                    .trim()
                    .length() == 0) {
                mensaje = "Numero de vuelo no puede estar vacio";
                return false;
            }

            return true;
        }

        public int getPasajeros() {
            try {
                return Integer.parseInt(pasajeros);
            } catch (Exception e) {
                return 0;
            }
        }

        public boolean isPasajeros() {
            try {
                Integer.parseInt(pasajeros);
            } catch (Exception e) {
                mensaje = "Numero pasajeros erroneo";
                return false;
            }
            return true;
        }

        public void setPasajeros(String pasajeros) {
            this.pasajeros = pasajeros;
        }

        public int getPasajerosTransito() {
            try {
                return Integer.parseInt(pasajerosTransito);
            } catch (Exception e) {
                return 0;
            }
        }

        public boolean isPasajerosTransito() {
            try {
                Integer.parseInt(pasajerosTransito);
            } catch (Exception e) {
                mensaje = "Numero pasajeros transito erroneo";
                return false;
            }
            return true;
        }

        public void setPasajerosTransito(String pasajerosTransito) {
            this.pasajerosTransito = pasajerosTransito;
        }

        public int getPasajerosExentosTasas() {
            try {
                return Integer.parseInt(pasajerosExentosTasas);
            } catch (Exception e) {
                return 0;
            }
        }

        public boolean isPasajerosExentosTasas() {
            try {
                Integer.parseInt(pasajerosExentosTasas);
            } catch (Exception e) {
                mensaje = "Numero pasajeros exentos de tasas erroneo";
                return false;
            }
            return true;
        }


        public void setPasajerosExentosTasas(String pasajerosExentosTasas) {
            this.pasajerosExentosTasas = pasajerosExentosTasas;
        }

        public int getPasajerosPaganDolares() {
            try {
                return Integer.parseInt(pasajerosPaganDolares);
            } catch (Exception e) {
                return 0;
            }
        }

        public boolean isPasajerosPaganDolares() {
            try {
                Integer.parseInt(pasajerosPaganDolares);
            } catch (Exception e) {
                mensaje = "Numero pasajeros pagan dolares erroneo";
                return false;
            }
            return true;
        }

        public void setPasajerosPaganDolares(String pasajerosPaganDolares) {
            this.pasajerosPaganDolares = pasajerosPaganDolares;
        }

        public int getPasajerosExcentosTimbres() {
            try {
                return Integer.parseInt(pasajerosExcentosTimbres);
            } catch (Exception e) {
                return 0;
            }
        }

        public boolean isPasajerosExcentosTimbres() {
            try {
                Integer.parseInt(pasajerosExcentosTimbres);
            } catch (Exception e) {
                mensaje = "Numero pasajeros excentos timbres erroneo";
                return false;
            }
            return true;
        }

        public void setPasajerosExcentosTimbres(String pasajerosExcentosTimbres) {
            this.pasajerosExcentosTimbres = pasajerosExcentosTimbres;
        }

        public int getPasajerosPaganTimbresDolares() {
            try {
                return Integer.parseInt(pasajerosPaganTimbresDolares);
            } catch (Exception e) {
                return 0;
            }
        }

        /**
         * Si el pasajero esta correcto.
         *
         * @return
         */
        public boolean isPasajerosPaganTimbresDolares() {
            try {
                Integer.parseInt(pasajerosPaganTimbresDolares);
            } catch (Exception e) {
                mensaje = "Numero pasajeros pagan timbres dolares erroneo";
                return false;
            }
            return true;
        }

        public void setPasajerosPaganTimbresDolares(String pasajerosPaganTimbresDolares) {
            this.pasajerosPaganTimbresDolares = pasajerosPaganTimbresDolares;
        }

        public String getTipo() {
            return tipo;
        }

        /**
         * Si el tipo esta correcto.
         *
         * @return
         */
        public boolean isTipo() {
            if (this.tipo.compareToIgnoreCase("N") == 0) {
                return true;
            }
            if (this.tipo.compareToIgnoreCase("L") == 0) {
                return true;
            }
            return false;
        }

        /**
         * Si el registro ya existe.
         *
         * @param manifiestoModulo
         * @return
         */
        public boolean isExisteRegistro(ManifiestoModuloImpl manifiestoModulo) {
            Object data =
                manifiestoModulo.getBaseDML()
                .ejecutaConsultaUnicoDato(SQL_EXISTE_MANIFIESTO, this.indiceAerolinea, this.indiceAeropuertoOrigen,
                                          this.indiceAeropuertoDestino, this.indiceAeronave, this.numeroVuelo,
                                          this.fecha);
            if (data != null && String.valueOf(data).compareTo("0") == 0) {
                return true;
            }
            mensaje =
                "El registro ya existe (aerolinea, aeropuerto origen, aeropuerto destino, aeronave, numero de vuelo y fecha) ya existe";
            return false;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }
}
