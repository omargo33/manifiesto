package modelManifiesto.bc.vistaNoDML;

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.bc.VistaObjeto;

import modelManifiesto.bc.vistaNoDML.common.ManifiestoViewNoDML;

import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 14 12:48:31 ECT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ManifiestoViewNoDMLImpl extends VistaObjeto implements ManifiestoViewNoDML {
    /**
     * This is the default constructor (do not remove).
     */
    public ManifiestoViewNoDMLImpl() {
        super();
    }

    /**
     * Metodo para ejecutar una busqueda de manifiesto general.
     *
     * @param indiceAerolinea
     * @param indiceAeropuertoOrigen
     * @param indiceAeropuertoDestino
     * @param indiceAeronave
     * @param noVuelo
     * @param fechaInicio
     * @param fechaFin
     */
    public void ejecutarConsulta(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen, int indiceAeropuertoDestino,
                                 int indiceAeronave, String noVuelo, String fechaInicio, String fechaFin) {

        java.sql.Date fechaSQLInicio = convertirDate(fechaInicio);
        java.sql.Date fechaSQLFin = convertirDate(fechaFin);

        ViewCriteria vc = this.getViewCriteriaManager().getViewCriteria("ManifiestoViewNoDMLCriteria");
        VariableValueManager vvm = vc.ensureVariableManager();
        
        
        if (idUsuario > 0) {
            vvm.setVariableValue("v_IdUsuario", idUsuario);
        } else {
            vvm.setVariableValue("v_IdUsuario", null);
        }        
        if (indiceAerolinea > 0) {
            vvm.setVariableValue("v_IndiceAerolinea", indiceAerolinea);
        } else {
            vvm.setVariableValue("v_IndiceAerolinea", null);
        }
        if (indiceAeropuertoOrigen > 0) {
            vvm.setVariableValue("v_IndiceAeropuertoOrigen", indiceAeropuertoOrigen);
        } else {
            vvm.setVariableValue("v_IndiceAeropuertoOrigen", null);
        }
        if (indiceAeropuertoDestino > 0) {
            vvm.setVariableValue("v_IndiceAeropuertoDestino", indiceAeropuertoDestino);
        } else {
            vvm.setVariableValue("v_IndiceAeropuertoDestino", null);
        }
        if (indiceAeronave > 0) {
            vvm.setVariableValue("v_IndiceAeronave", indiceAeronave);
        } else {
            vvm.setVariableValue("v_IndiceAeronave", null);
        }
        if (noVuelo != null && noVuelo.trim().length() > 0 && noVuelo.compareTo("0") != 0) {
            vvm.setVariableValue("v_NoVuelo", noVuelo);
        } else {
            vvm.setVariableValue("v_NoVuelo", null);
        }
        
        if (fechaSQLInicio != null && fechaSQLFin != null) {
            vvm.setVariableValue("v_FechaInicio", fechaSQLInicio);
            vvm.setVariableValue("v_FechaFin", fechaSQLFin);
        } else {
            vvm.setVariableValue("v_FechaInicio", new java.sql.Date( new Date().getTime() - (15 * 24 * 60 * 60 * 1000)));
            vvm.setVariableValue("v_FechaFin", new java.sql.Date(new Date().getTime() + (5 * 60 * 1000)));
        }

        this.applyViewCriteria(vc, false);
        this.executeQuery();
        this.setApplyViewCriteriaName(null);
    }


    public void ejecutarConsultaErrorJDE() {
        ViewCriteria vc = getViewCriteriaManager().getViewCriteria("ManifiestoViewNoDMLCriteriaErrorRest");
        
        applyViewCriteria(vc, false);
        executeQuery();
        setApplyViewCriteriaName(null);
      }

    /**
     * Metodo para cargar valores por default para busquedas.
     */
    public void cargarValoresDefaultBusqueda01(String idUsuario) {
        java.sql.Timestamp fechaInicio = new Timestamp(new java.util.Date().getTime() - (24 * 60 * 60 * 1000));
        java.sql.Timestamp fechaFin = new Timestamp(new java.util.Date().getTime() + (5 * 60 * 1000));
        this.ensureVariableManager().setVariableValue("v_FechaInicioCompleta", fechaInicio);
        this.ensureVariableManager().setVariableValue("v_FechaFinCompleta", fechaFin);
        this.ensureVariableManager().setVariableValue("v_IdUsuario", idUsuario);
        this.ensureVariableManager().setVariableValue("v_Estado", "C");
    }


    /**
     * Metodo para cargar valores por default para busquedas.
     */
    public void cargarValoresDefaultBusqueda02(String idUsuario) {
        java.sql.Date fechaInicio = new java.sql.Date(new java.util.Date().getTime() - (24 * 60 * 60 * 1000));
        java.sql.Date fechaFin = new java.sql.Date(new java.util.Date().getTime() + (5 * 60 * 1000));
        this.ensureVariableManager().setVariableValue("v_FechaInicioCompleta", fechaInicio);
        this.ensureVariableManager().setVariableValue("v_FechaFinCompleta", fechaFin);
        this.ensureVariableManager().setVariableValue("v_IdUsuario", idUsuario);
        this.ensureVariableManager().setVariableValue("v_Estado", "C");
    }


    /**
     * Metodo para convertir una fecha.
     *
     * @param fechaStr
     * @return
     */
    private java.sql.Date convertirDate(String fechaStr) {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try {
            java.util.Date fechaTemp = dateFormat.parse(fechaStr);
            java.sql.Date fechaSQLTemp = new java.sql.Date(fechaTemp.getTime());
            return fechaSQLTemp;
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
        return null;
    }
}

