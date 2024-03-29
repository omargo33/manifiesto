package viewManifiesto.preliquidacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;

/**
 * Objeto para dar soporte a las busqueda dinamica con paneles extensos.
 *
 * Y control para la creacion de un pdf de preliquidacion.
 *
 */
public class PPRListaFrg extends BasePPR {
    @SuppressWarnings({ "compatibility:5936010330712211772", "oracle.jdeveloper.java.serialversionuid-stale" })
    private static final long serialVersionUID = 1L;

    private RichInputText it1; //indiceAerolinea
    private RichInputText it10; //indiceAerolineaDescripcion

    private RichInputText it2; //indiceAeropuertoOrigen
    private RichInputText it20; //indiceAeropuertoOrigenDescripcion

    private RichInputText it3; //indiceAeropuertoDestino
    private RichInputText it30; //indiceAeropuertoDestinoDescripcion
    private RichInputText it4; //indiceAeronave
    private RichInputText it40; //indiceAeronaveDescripcion
    private RichInputText it5; //noVuelo

    private RichInputDate id1; //fechaInicio
    private RichInputDate id2; //fechaFin

    private RichTable resId1; //Tabla manifiesto
    private RichTable resId2; //Tabla aerolinea destino
    private RichTable resId3; //Tabla aeronave
    private RichTable resId4; //Tabla aerolinea
    private RichTable resId5; //Tabla aeropuerto origen

    private RichPopup p1; //indiceAerolinea
    private RichPopup p2; //indiceAeropuertoOrigen
    private RichPopup p3; //indiceAeropuertoDestino
    private RichPopup p4; //indiceAeronave
    private RichPopup p5; //impresion reporte

    private RichButton b1;
    private RichButton b2;
    private RichInputText it29;

    private RichSelectOneChoice soc3;

    /**
     * Metodo para crear el objeto de soporte a la presentacion.
     *
     */
    public PPRListaFrg() {
        super();
        init();
        iniciarDatosFormularios();
    }

    /**
     * Inicializa datos.
     */
    private void init() {
        setIt1(new RichInputText());
        setIt10(new RichInputText());
        setIt2(new RichInputText());
        setIt20(new RichInputText());
        setIt3(new RichInputText());
        setIt30(new RichInputText());
        setIt4(new RichInputText());
        setIt40(new RichInputText());
        setIt5(new RichInputText());

        setId1(new RichInputDate());
        setId2(new RichInputDate());

        setResId1(new RichTable());
        setResId2(new RichTable());
        setResId3(new RichTable());
        setResId4(new RichTable());
        setResId5(new RichTable());

        setP1(new RichPopup());
        setP2(new RichPopup());
        setP3(new RichPopup());
        setP4(new RichPopup());
        setP5(new RichPopup());

        setB1(new RichButton());
        setB2(new RichButton());

        setSoc3(new RichSelectOneChoice());
    }

    /**
     * Metodo para ejecutar proceso de creacion y toma de datos iniciales.
     *
     * @return
     */
    public String actionCrear() {
        if (getResId5().getRowCount() == 0) {
            ADFUtils.setMensajeError("No existe datos para preliquidar, ingreso valores y vuelva a ejecutar la busqueda.");
            return null;
        }

        if (isAerolineaSeleccionada()) {
            return "Create";
        }
        return null;
    }

    /**
     * actionListener="#{bindings.ejecutarConsulta.execute}"
     */
    public String actionBuscar(ActionEvent actionEvent) {
        buscarIdLibroDireccion();

        if (isAerolineaSeleccionada()) {
            ejecutarBusqueda();
        }
        return null;
    }

    public String actionLimpiar() {
        iniciarDatosFormularios();
        return "Inicio";
    }

    /**
     * Metodo para tener una accion de limpia.
     *
     * @param actionEvent
     */
    public void accionLimpiar(ActionEvent actionEvent) {
        iniciarDatosFormularios();

        doPartialRefresh(getIt1());
        doPartialRefresh(getIt10());

        doPartialRefresh(getIt2());
        doPartialRefresh(getIt20());

        doPartialRefresh(getIt3());
        doPartialRefresh(getIt30());

        doPartialRefresh(getIt4());
        doPartialRefresh(getIt40());

        doPartialRefresh(getIt5());

        doPartialRefresh(getId1());
        doPartialRefresh(getId2());
    }

    /**
     * Metodo para buscar.
     *
     */
    private void ejecutarBusqueda() {
        Object aerolienaId = ADFUtils.evaluateEL("#{sessionScope.idAerolinea}");
        String aerolienaIdString = String.valueOf(aerolienaId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("idUsuario", 0);
        map.put("indiceAerolinea", convertirInt(getIt1().getValue()));
        map.put("indiceAeropuertoOrigen", convertirInt(getIt2().getValue()));
        map.put("indiceAeropuertoDestino", convertirInt(getIt3().getValue()));
        map.put("indiceAeronave", convertirInt(getIt4().getValue()));
        map.put("noVuelo", convertirString(getIt5().getValue()));
        map.put("fechaInicio", convertirString(getId1().getValue()));
        map.put("fechaFin", convertirString(getId2().getValue()));
        ADFUtils.ejecutaAction(getBindings(), "ejecutarConsultaPreliquidacion", null, null, map);
        doPartialRefresh(getResId5());

        Map<String, String> mapa =
            (Map) ADFUtils.ejecutaActionConReturn(getBindings(), "calculosPreCalificacion", true, map);

        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                value = value.trim();
            }
            ADFUtils.setEL("#{sessionScope." + entry.getKey() + "}", value);
        }
        ADFUtils.setEL("#{sessionScope.indiceAerolinea}", convertirInt(aerolienaIdString));
    }

    /**
     * Metodo para inicializar los datos de los formularios.
     *
     */
    public void iniciarDatosFormularios() {
        getIt1().setValue("");
        getIt10().setValue("<No Definido>");

        getIt2().setValue("");
        getIt20().setValue("<No Definido>");

        getIt3().setValue("");
        getIt30().setValue("<No Definido>");

        getIt4().setValue("");
        getIt40().setValue("<No Definido>");

        getIt5().setValue("%");
        getId1().setValue(getFecha15DiasCorto());
        getId2().setValue(getFechaHoyCorto());

        String idUsuario = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.idUsuario}"));
        String isCli01 = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.isCLI01}"));
        String isCli02 = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.isCLI02}"));
        String isCli03 = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.isCLI03}"));
        String idAerolinea = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.idAerolinea}")).trim();
        String aerolineaDescripcion =
            String.valueOf(ADFUtils.evaluateEL("#{sessionScope.aerolineaDescripcion}")).trim();

        try {
            if (isCli01.compareToIgnoreCase("TRUE") == 0) {
                getIt1().setValue("0");
                getIt10().setValue("<No Definido>");
                getB1().setDisabled(false);
            }

            if (isCli02.compareToIgnoreCase("TRUE") == 0) {
                getIt1().setValue(idAerolinea);
                getIt10().setValue(aerolineaDescripcion);
                getB1().setDisabled(true);
            }

            if (isCli03.compareToIgnoreCase("TRUE") == 0) {
                getIt1().setValue(idAerolinea);
                getIt10().setValue(aerolineaDescripcion);
                getB1().setDisabled(true);
            }

            getIt2().setValue("");
            getIt20().setValue("<No Definido>");
            getB2().setDisabled(false);

        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
    }


    /**
     * Seleccionar Aerolienea
     *
     * @param actionEvent
     */
    public void accionSeleccionar1(ActionEvent actionEvent) {
        getP1().hide();
        doPartialRefresh(getP1());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId1().getSelectedRowData();
        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        getIt1().setValue(indice);
        getIt10().setValue(descripcion);
        doPartialRefresh(getIt1());
        doPartialRefresh(getIt10());
    }

    /**
     * Seleccionar Aeropuerto Origen
     *
     * @param actionEvent
     */
    public void accionSeleccionar2(ActionEvent actionEvent) {
        getP2().hide();
        doPartialRefresh(getP2());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId4().getSelectedRowData();
        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        getIt2().setValue(indice);
        getIt20().setValue(descripcion);
        doPartialRefresh(getIt2());
        doPartialRefresh(getIt20());
    }


    /**
     * Seleccionar Aeropuerto Destino
     *
     * @param actionEvent
     */
    public void accionSeleccionar3(ActionEvent actionEvent) {
        getP3().hide();
        doPartialRefresh(getP3());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId2().getSelectedRowData();
        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        getIt3().setValue(indice);
        getIt30().setValue(descripcion);
        doPartialRefresh(getIt3());
        doPartialRefresh(getIt30());
    }

    /**
     * Seleccionar Aeronave
     *
     * @param actionEvent
     */
    public void accionSeleccionar4(ActionEvent actionEvent) {
        getP4().hide();
        doPartialRefresh(getP4());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId3().getSelectedRowData();
        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        getIt4().setValue(indice);
        getIt40().setValue(descripcion);
        doPartialRefresh(getIt4());
        doPartialRefresh(getIt40());
    }


    /**
     * Metodo para conocer si esta seleccionada una aerolinea.
     *
     * @return
     */
    private boolean isAerolineaSeleccionada() {
        boolean respuesta = true;

        Object aerolienaId = getIt1().getValue();


        try {
            if (aerolienaId == null || aerolienaId.toString().compareTo("") == 0 ||
                Integer.parseInt(aerolienaId.toString()) <= 0) {
                respuesta = false;
            }
        } catch (Exception e) {
            respuesta = false;
        }

        if (!respuesta) {
            ADFUtils.setMensajeError("Por lo menos debe escoger una Aerolinea");
            return respuesta;
        }

        Object fechaInicio = getId1().getValue();
        Object fechaFin = getId2().getValue();
        try {
            String yearFechaInicio = convertirDate(String.valueOf(fechaInicio)).substring(0, 4);
            String yearFechaFin = convertirDate(String.valueOf(fechaFin)).substring(0, 4);
            respuesta = (yearFechaInicio.compareTo(yearFechaFin) == 0);
        } catch (Exception e) {
            respuesta = false;
        }

        if (!respuesta) {
            ADFUtils.setMensajeError("Las fechas deben pertenecer al mismo año");
        }

        return respuesta;
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

    //Propiedades
    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }

    public RichTable getResId1() {
        return resId1;
    }

    public void setResId2(RichTable resId2) {
        this.resId2 = resId2;
    }

    public RichTable getResId2() {
        return resId2;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public void setIt30(RichInputText it30) {
        this.it30 = it30;
    }

    public RichInputText getIt30() {
        return it30;
    }

    public void setResId3(RichTable resId3) {
        this.resId3 = resId3;
    }

    public RichTable getResId3() {
        return resId3;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }


    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void setIt40(RichInputText it40) {
        this.it40 = it40;
    }

    public RichInputText getIt40() {
        return it40;
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public void setIt20(RichInputText it20) {
        this.it20 = it20;
    }

    public RichInputText getIt10() {
        return it10;
    }

    public RichInputText getIt20() {
        return it20;
    }

    public void setResId4(RichTable resId4) {
        this.resId4 = resId4;
    }

    public RichTable getResId4() {
        return resId4;
    }

    public void setResId5(RichTable resId5) {
        this.resId5 = resId5;
    }

    public RichTable getResId5() {
        return resId5;
    }

    public void setP5(RichPopup p5) {
        this.p5 = p5;
    }

    public RichPopup getP5() {
        return p5;
    }

    public RichButton getB1() {
        return this.b1;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB2() {
        return this.b2;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public void setIt29(RichInputText it29) {
        this.it29 = it29;
    }

    public RichInputText getIt29() {
        return it29;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void actionValueChange(ValueChangeEvent valueChangeEvent) {
        Object objeto = valueChangeEvent.getNewValue();
        String nombreSeleccionado = String.valueOf(objeto);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "nombreSeleccionado " + nombreSeleccionado);
    }


    /**
     * Metodo para buscarIdLibroDireccion desde la filial
     */
    private void buscarIdLibroDireccion() {
        Object idFilial = ADFUtils.evaluateEL("#{sessionScope.idFilial}");
        Integer idFiliarInt = (Integer) idFilial;

        if (idFiliarInt > 0) {
            String nombreSeleccionado = String.valueOf(getSoc3().getValue());
            DCIteratorBinding binding = ADFUtils.findIterator("CatalogoFilialesViewNoDML1Iterator");
            Row[] rows = binding.getAllRowsInRange();

            for (Row r : rows) {
                Integer idLibroDireccion = (Integer) r.getAttribute("IdLibroDireccion");
                String nombre = String.valueOf(r.getAttribute("Nombre"));

                if (nombre.compareTo(nombreSeleccionado) == 0) {
                    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                        .log(Level.SEVERE, "Se va a buscar con " + idLibroDireccion);
                    getIt1().setValue(idLibroDireccion);
                    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "Se puso " + getIt1().getValue());
                }
            }
        }
    }
}
