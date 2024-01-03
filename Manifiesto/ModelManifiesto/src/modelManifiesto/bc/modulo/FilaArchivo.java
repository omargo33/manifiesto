package modelManifiesto.bc.modulo;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

//import jxl.Sheet;

import model.utilidades.Atributos;

import modelManifiesto.bc.common.ManifiestoModuloImpl;
import modelManifiesto.bc.entidad.ManifiestoImpl;
import modelManifiesto.bc.vista.ManifiestoInsertViewImpl;

import oracle.jbo.JboException;
import oracle.jbo.Row;

import org.apache.poi.ss.usermodel.Sheet;


/**
 * Objeto para dar soporte a validar e ingresar los archivos.
 *
 * @author omargo33@hotmail.com
 *
 */
public class FilaArchivo {

    final static String SQL_LIBRO_DIRECCIONES =
        "select count(*) existe from MV_001_00.libro_direccion ld where UPPER(indice_secundario) = UPPER(?) and UPPER(tipo) = UPPER(?) and estado = 'A'";

    final static String SQL_LIBRO_DIRECCIONES_ID =
        "select indice from MV_001_00.libro_direccion where UPPER(indice_secundario) = UPPER(?) and UPPER(tipo) = UPPER(?)";

    final static String SQL_EXISTE_MANIFIESTO =
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
    private boolean createOk = true;

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
     * @return
     */
    public boolean isValidar(ManifiestoModuloImpl manifiestoModulo) {

        if (!createOk) {
            return false;
        }


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

        if (!isFecha(manifiestoModulo)) {
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

    /**
     * Error de la validacion visible.
     *
     * @return
     */
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
        String mensajeCreacion = "";
        try {
            mensajeCreacion = "Indice de Aerolinea es texto";
            this.indiceAerolinea = String.valueOf(pagina.getRow(row)
                                                        .getCell(0)
                                                        .getStringCellValue());

            mensajeCreacion = "Indice de Aeropuerto Origen es texto";
            this.indiceAeropuertoOrigen = String.valueOf(pagina.getRow(row)
                                                               .getCell(2)
                                                               .getStringCellValue());

            mensajeCreacion = "Indice de Aeropuerto Destino es texto";
            this.indiceAeropuertoDestino = String.valueOf(pagina.getRow(row)
                                                                .getCell(3)
                                                                .getStringCellValue());

            mensajeCreacion = "Indice de Aeronave es texto";
            this.indiceAeronave = String.valueOf(pagina.getRow(row)
                                                       .getCell(4)
                                                       .getStringCellValue());

            mensajeCreacion = "Fecha Local Operacion es texto";
            this.fecha = String.valueOf(pagina.getRow(row)
                                              .getCell(5)
                                              .getStringCellValue());

            mensajeCreacion = "No. Vuelo debe ser un campo numérico";
            this.numeroVuelo = String.valueOf((int) pagina.getRow(row)
                                                          .getCell(8)
                                                          .getNumericCellValue());

            mensajeCreacion = "Pasajeros debe ser un campo numérico";
            this.pasajeros = String.valueOf((int) pagina.getRow(row)
                                                        .getCell(9)
                                                        .getNumericCellValue());

            mensajeCreacion = "Pasajeros Transito debe ser un campo numérico";
            this.pasajerosTransito = String.valueOf((int) pagina.getRow(row)
                                                                .getCell(10)
                                                                .getNumericCellValue());

            mensajeCreacion = "Pasajeros Exentos Tasas debe ser un campo numérico";
            this.pasajerosExentosTasas = String.valueOf((int) pagina.getRow(row)
                                                                    .getCell(12)
                                                                    .getNumericCellValue());

            mensajeCreacion = "Pasajeros Pagan Dolares debe ser un campo numérico";
            this.pasajerosPaganDolares = String.valueOf((int) pagina.getRow(row)
                                                                    .getCell(14)
                                                                    .getNumericCellValue());

            mensajeCreacion = "Pasajeros Exentos Timbres debe ser un campo numérico";
            this.pasajerosExcentosTimbres = String.valueOf((int) pagina.getRow(row)
                                                                       .getCell(17)
                                                                       .getNumericCellValue());

            mensajeCreacion = "Pasajeros Pagan Timbres Dolares debe ser un campo numérico";
            this.pasajerosPaganTimbresDolares = String.valueOf((int) pagina.getRow(row)
                                                                           .getCell(19)
                                                                           .getNumericCellValue());

            mensajeCreacion = "Tipo es texto";
            this.tipo = String.valueOf(pagina.getRow(row)
                                             .getCell(16)
                                             .getStringCellValue());
        } catch (Exception e) {
            createOk = false;
            mensaje = String.format("El formato de la columna %s", mensajeCreacion);
        }
    }

    public String getIndiceAerolinea() {
        return indiceAerolinea;
    }

    private int getEstadoLibroDirecciones(ManifiestoModuloImpl manifiestoModulo, String indice, String tipo) {
        Object data = manifiestoModulo.getBaseDML().ejecutaConsultaUnicoDato(SQL_LIBRO_DIRECCIONES, indice, tipo);
        if (data != null && String.valueOf(data).compareTo("1") == 0) {
            return 0;
        }

        try {
            if (data != null && Integer.parseInt(String.valueOf(data)) > 1) {
                return 1;
            }
        } catch (Exception e) {
            return 1;
        }

        return -1;
    }

    /**
     * Metodo para conocer el libro de direccion.
     *
     * @param indice
     * @param tipo
     * @return
     */
    private String idLibroDirecciones(ManifiestoModuloImpl manifiestoModulo, String indice, String tipo) {
        Object data = manifiestoModulo.getBaseDML().ejecutaConsultaUnicoDato(SQL_LIBRO_DIRECCIONES_ID, indice, tipo);
        if (manifiestoModulo.getBaseDML().getMensaje() == null) {
            return String.valueOf(data);
        }
        return null;
    }


    public boolean isAerolinea(ManifiestoModuloImpl manifiestoModulo) {
        int estado= getEstadoLibroDirecciones(manifiestoModulo, this.indiceAerolinea, "C");
        
        if (estado==0) {
            return true;
        }
        
        if (estado<0) {
            mensaje = "No se ha localizado la aerolinea";
        }
        
        if (estado>0) {
            mensaje = "Aerolinea duplicada";
        }
        
        return false;
    }

    /**
     * @param indiceAerolinea
     */
    public void setIndiceAerolinea(String indiceAerolinea) {
        this.indiceAerolinea = indiceAerolinea;
    }

    public String getIndiceAeropuertoOrigen() {
        return indiceAeropuertoOrigen;
    }

    public boolean isAeropuertoOrigen(ManifiestoModuloImpl manifiestoModulo) {
        int estado= getEstadoLibroDirecciones(manifiestoModulo, this.indiceAeropuertoOrigen, "AR");
        
        if (estado==0) {
            return true;
        }
        
        if (estado<0) {
            mensaje = "No se ha localizado el aeropuerto origen " + this.indiceAeropuertoOrigen;
        }
        
        if (estado>0) {
            mensaje = "Aeropuerto origen " + this.indiceAeropuertoOrigen + " esta duplicado";
        }
        
        return false;
    }

    /**
     * @param indiceAeropuertoOrigen
     */
    public void setIndiceAeropuertoOrigen(String indiceAeropuertoOrigen) {
        this.indiceAeropuertoOrigen = indiceAeropuertoOrigen;
    }

    public String getIndiceAeropuertoDestino() {
        return indiceAeropuertoDestino;
    }

    public boolean isAeropuertoDestino(ManifiestoModuloImpl manifiestoModulo) {
        int estado= getEstadoLibroDirecciones(manifiestoModulo, this.indiceAeropuertoDestino, "AR");
        
        if (estado==0) {
            return true;
        }
        
        if (estado<0) {
            mensaje = "No se ha localizado el aeropuerto destino " + this.indiceAeropuertoDestino;
            
        }
        
        if (estado>0) {
            mensaje = "El aeropuerto destino " + this.indiceAeropuertoDestino + " esta duplicado";
            
        }
        
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
        int estado= getEstadoLibroDirecciones(manifiestoModulo, this.indiceAeronave, "CA");
        
        if (estado==0) {
            return true;
        }
        
        if (estado<0) {
            mensaje = "No se ha localizado la aeronave " + this.indiceAeronave;
        }
        
        if (estado>0) {
            mensaje = "La aeronave " + this.indiceAeronave +" esta duplicada";
        }
        
        return false;
    }

    public Date getFecha() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(this.fecha);
        } catch (Exception e) {
            date = new Date();
        }
        return date;
    }


    public boolean isFecha(ManifiestoModuloImpl manifiestoModulo) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(this.fecha);
        } catch (Exception e) {
            mensaje = "La fecha de operacion debe ser yyyy-mm-dd";
            return false;
        }


        Double diasPrevios = manifiestoModulo.base_obtenerParametroNumerico01("004").doubleValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        calendar.add(Calendar.DAY_OF_YEAR, (diasPrevios.intValue() * -1));
        if (date.getTime() < calendar.getTime().getTime()) {
            mensaje = "La fecha de operacion tiene un limite de " + diasPrevios + " días";
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

        if (this.tipo.compareToIgnoreCase("I") == 0) {
            this.tipo = "L";
            return true;
        }
        return false;
    }

    /**
     * Si el registro ya existe.
     *
     * @return
     */
    public boolean isExisteRegistro(ManifiestoModuloImpl manifiestoModulo) {
        Object data =
            manifiestoModulo.getBaseDML()
            .ejecutaConsultaUnicoDato(SQL_EXISTE_MANIFIESTO, this.indiceAerolinea, this.indiceAeropuertoOrigen,
                                      this.indiceAeropuertoDestino, this.indiceAeronave, this.numeroVuelo, this.fecha);
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

    /**
     * Metodo para crear manifiesto.
     *
     * @param id
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public int crearManifiesto(ManifiestoModuloImpl manifiestoModulo, String id, String usuario,
                               String usuarioPrograma) {
        int codigo = 0;
        boolean estado = true;
        String idAerolinea = idLibroDirecciones(manifiestoModulo, getIndiceAerolinea(), "C");
        String idAeropuertoOrigen = idLibroDirecciones(manifiestoModulo, getIndiceAeropuertoOrigen(), "AR");
        String idAeropuertoDestino = idLibroDirecciones(manifiestoModulo, getIndiceAeropuertoDestino(), "AR");
        String idAeronave = idLibroDirecciones(manifiestoModulo, getIndiceAeronave(), "CA");

        ManifiestoInsertViewImpl manifiestoViewImpl = manifiestoModulo.getManifiestoInsertView1();
        Row row = manifiestoViewImpl.createRow();

        row.setAttribute(ManifiestoImpl.IDMANIFIESTO, 0);
        row.setAttribute(ManifiestoImpl.FECHALOCALOPERACION, new java.sql.Date(getFecha().getTime()));
        row.setAttribute(ManifiestoImpl.IDUSUARIO, Integer.parseInt(id));
        row.setAttribute(ManifiestoImpl.IDLIBRODIRECCIONAEROLINEA, idAerolinea);
        row.setAttribute(ManifiestoImpl.IDLIBRODIRECCIONAEROPUERTO, idAeropuertoOrigen);
        row.setAttribute(ManifiestoImpl.IDLIBRODIRECCIONAEROPUERTODES, idAeropuertoDestino);
        row.setAttribute(ManifiestoImpl.IDLIBRODIRECCIONAERONAVE, idAeronave);
        row.setAttribute(ManifiestoImpl.NOVUELO, getNumeroVuelo());
        row.setAttribute(ManifiestoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
        row.setAttribute(ManifiestoImpl.USUARIOFECHA, Atributos.sysTime());
        row.setAttribute(ManifiestoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
        row.setAttribute(ManifiestoImpl.TIPO, getTipo());
        row.setAttribute(ManifiestoImpl.PASAJEROS, getPasajeros());
        row.setAttribute(ManifiestoImpl.PASAJEROSTRANSITO, getPasajerosTransito());
        row.setAttribute(ManifiestoImpl.PASAJEROSEXENTOSTASAS, getPasajerosExentosTasas());
        row.setAttribute(ManifiestoImpl.PASAJEROSPAGANDOLARES, getPasajerosPaganTimbresDolares());
        row.setAttribute(ManifiestoImpl.PASAJEROSEXENTOSTIMBRES, getPasajerosExcentosTimbres());
        row.setAttribute(ManifiestoImpl.INDICADORCOMPROBABLE, "S");
        row.setAttribute(ManifiestoImpl.ESTADO, "C");
        row.setAttribute(ManifiestoImpl.CANCELADO, "N");
        row.validate();
        manifiestoViewImpl.insertRow(row);
        estado = manifiestoModulo.commitRollback("Manifiesto", "crearArchivo");
        if (estado) {
            codigo = ((Integer) row.getAttribute(ManifiestoImpl.IDMANIFIESTO)).intValue();
        } else {
            codigo = -1;
        }
        return codigo;
    }
}
