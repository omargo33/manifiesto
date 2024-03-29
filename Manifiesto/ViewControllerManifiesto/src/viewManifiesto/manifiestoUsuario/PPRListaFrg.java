package viewManifiesto.manifiestoUsuario;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import modelManifiesto.utilidades.GenerarSqlManifiesto;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;


import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;

public class PPRListaFrg extends BasePPR {
    @SuppressWarnings("compatibility:5936010330712211772")
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

    private RichInputText it6; //idManifiesto

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

    private RichSelectOneChoice soc10;
    private RichSelectOneChoice soc20;
    private RichSelectOneChoice soc30;
    private RichSelectOneChoice soc40;
    private RichPanelLabelAndMessage plam1;
    private RichColumn resId1c6;
    private RichColumn resId1c7;


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
        setIt6(new RichInputText());

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

        setSoc10(new RichSelectOneChoice());
        setSoc20(new RichSelectOneChoice());
        setSoc30(new RichSelectOneChoice());
        setSoc40(new RichSelectOneChoice());

        setB1(new RichButton());
        setB2(new RichButton());

        setPlam1(new RichPanelLabelAndMessage());
        setResId1c6(new RichColumn());
        setResId1c7(new RichColumn());
    }

    /**
     * actionListener="#{bindings.ejecutarConsulta.execute}"
     */
    public String actionBuscar(ActionEvent actionEvent) {
        ejecutarBusqueda();
        return null;
    }

    public String actionLimpiar() {
        iniciarDatosFormularios();
        ejecutarBusqueda();
        return null;
    }

    /**
     * Metodo para tener una accion de limpia.
     *
     * @param actionEvent
     */
    public void accionLimpiar(ActionEvent actionEvent) {
        ADFUtils.setEL("#{sessionScope.ingresoMenu}", "0");

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
        doPartialRefresh(getIt6());

        doPartialRefresh(getId1());
        doPartialRefresh(getId2());

        doPartialRefresh(getSoc10());
        doPartialRefresh(getSoc20());
        doPartialRefresh(getSoc30());
        doPartialRefresh(getSoc40());

        ejecutarBusqueda();
    }

    /**
     * Metodo para buscar.
     *
     */
    private void ejecutarBusqueda() {
        Map map = new HashMap<String, Object>();

        Object rolUsuario = ADFUtils.evaluateEL("#{sessionScope.isCLI02}");

        if (rolUsuario != null && String.valueOf(rolUsuario).compareToIgnoreCase("TRUE") == 0) {
            map.put("idUsuario", convertirInt(ADFUtils.evaluateEL("#{sessionScope.idUsuario}")));
        } else {
            map.put("idUsuario", 0);
        }
        
        buscarIdLibroDireccion();

        map.put("indiceAerolinea", convertirInt(getIt1().getValue()));
        map.put("indiceAeropuertoOrigen", convertirInt(getIt2().getValue()));
        map.put("indiceAeropuertoDestino", convertirInt(getIt3().getValue()));
        map.put("indiceAeronave", convertirInt(getIt4().getValue()));
        map.put("noVuelo", convertirString(getIt5().getValue()));
        map.put("fechaInicio", convertirString(getId1().getValue()));
        map.put("fechaFin", convertirString(getId2().getValue()));

        map.put("idManifiesto", convertirString(getIt6().getValue()));
        map.put("estado", convertirString(getSoc10().getValue()));
        map.put("tipoVuelo", convertirString(getSoc20().getValue()));
        map.put("tipoObservacion", convertirString(getSoc30().getValue()));

        ADFUtils.ejecutaAction(getBindings(), "ejecutarConsultaExtendida", null, null, map);
        ADFUtils.ejecutaAction(getBindings(), "ejecutarConsultaExtendidaSumatoria", null, null, map);

        ADFUtils.setEL("#{sessionScope.idAerolineaFiltro}", String.valueOf(getIt1().getValue()));
        ADFUtils.setEL("#{sessionScope.aerolineaDescripcionFiltro}", String.valueOf(getIt10().getValue()));

        ADFUtils.setEL("#{sessionScope.idAeropuertoFiltro}", String.valueOf(getIt2().getValue()));
        ADFUtils.setEL("#{sessionScope.aeropuertoDescripcionFiltro}", String.valueOf(getIt20().getValue()));

        ADFUtils.setEL("#{sessionScope.idAeropuertoDestinoFiltro}", String.valueOf(getIt3().getValue()));
        ADFUtils.setEL("#{sessionScope.aeropuertoDestinoDescripcionFiltro}", String.valueOf(getIt30().getValue()));

        ADFUtils.setEL("#{sessionScope.idAeronaveFiltro}", String.valueOf(getIt4().getValue()));
        ADFUtils.setEL("#{sessionScope.aeronaveDescripcionFiltro}", String.valueOf(getIt40().getValue()));

        ADFUtils.setEL("#{sessionScope.noVueloFiltro}", String.valueOf(getIt5().getValue()));
        ADFUtils.setEL("#{sessionScope.idManifiestoFiltro}", String.valueOf(getIt6().getValue()));

        ADFUtils.setEL("#{sessionScope.fechaInicioFiltro}",
                       GenerarSqlManifiesto.convertirDateString(String.valueOf(getId1().getValue())));
        ADFUtils.setEL("#{sessionScope.fechaFinFiltro}",
                       GenerarSqlManifiesto.convertirDateString(String.valueOf(getId2().getValue())));

        ADFUtils.setEL("#{sessionScope.estadoFiltro}", String.valueOf(getSoc10().getValue()));
        ADFUtils.setEL("#{sessionScope.tipoVueloFiltro}", String.valueOf(getSoc20().getValue()));
        ADFUtils.setEL("#{sessionScope.observacionFiltro}", String.valueOf(getSoc30().getValue()));

        ADFUtils.setEL("#{sessionScope.ingresoMenu}", "1");


        doPartialRefresh(getResId5());
    }

    /**
     * Metodo para inicializar los datos de los formularios.
     *
     */
    public void iniciarDatosFormularios() {
        String ingresoMenu = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.ingresoMenu}"));

        if (ingresoMenu.compareTo("0") == 0) {
            getIt1().setValue("");
            getIt10().setValue("<No Definido>");

            getIt2().setValue("");
            getIt20().setValue("<No Definido>");

            getIt3().setValue("");
            getIt30().setValue("<No Definido>");

            getIt4().setValue("");
            getIt40().setValue("<No Definido>");

            getIt5().setValue("");
            getIt6().setValue("");

            getId1().setValue(getFecha15DiasCorto());
            getId2().setValue(getFechaHoyCorto());

            getSoc10().setValue(" ");
            getSoc20().setValue(" ");
            getSoc30().setValue(" ");

            Object cli03 = ADFUtils.evaluateEL("#{sessionScope.isCLI03}");
            if (cli03 != null && String.valueOf(cli03).compareToIgnoreCase("TRUE") == 0) {
                try {
                    String idAerolinea = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.idAerolinea}")).trim();
                    String aerolineaDescripcion =
                        String.valueOf(ADFUtils.evaluateEL("#{sessionScope.aerolineaDescripcion}")).trim();

                    String idAeropuerto = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.idAeropuerto}")).trim();
                    String aeropuertoDescripcion =
                        String.valueOf(ADFUtils.evaluateEL("#{sessionScope.aeropuertoDescripcion}")).trim();

                    getIt1().setValue(idAerolinea);
                    getIt10().setValue(aerolineaDescripcion);
                    getB1().setDisabled(true);
                    getIt2().setValue("");
                    getIt20().setValue("<No Definido>");
                    getB2().setDisabled(false);

                    
                } catch (Exception e) {
                    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
                }
            }
        }
        
        presentacionFilial();

        if (ingresoMenu.compareTo("1") == 0) {
            getIt1().setValue(ADFUtils.evaluateEL("#{sessionScope.idAerolineaFiltro}"));
            getIt10().setValue(ADFUtils.evaluateEL("#{sessionScope.aerolineaDescripcionFiltro}"));

            getIt2().setValue(ADFUtils.evaluateEL("#{sessionScope.idAeropuertoFiltro}"));
            getIt20().setValue(ADFUtils.evaluateEL("#{sessionScope.aeropuertoDescripcionFiltro}"));

            getIt3().setValue(ADFUtils.evaluateEL("#{sessionScope.idAeropuertoDestinoFiltro}"));
            getIt30().setValue(ADFUtils.evaluateEL("#{sessionScope.aeropuertoDestinoDescripcionFiltro}"));

            getIt4().setValue(ADFUtils.evaluateEL("#{sessionScope.idAeronaveFiltro}"));
            getIt40().setValue(ADFUtils.evaluateEL("#{sessionScope.aeronaveDescripcionFiltro}"));

            getIt5().setValue(ADFUtils.evaluateEL("#{sessionScope.noVueloFiltro}"));
            getIt6().setValue(ADFUtils.evaluateEL("#{sessionScope.idManifiestoFiltro}"));

            getId1().setValue(ADFUtils.evaluateEL("#{sessionScope.fechaInicioFiltro}"));
            getId2().setValue(ADFUtils.evaluateEL("#{sessionScope.fechaFinFiltro}"));

            getSoc10().setValue(ADFUtils.evaluateEL("#{sessionScope.estadoFiltro}"));
            getSoc20().setValue(ADFUtils.evaluateEL("#{sessionScope.tipoVueloFiltro}"));
            getSoc30().setValue(ADFUtils.evaluateEL("#{sessionScope.observacionFiltro}"));
        }
    }

    /**
     * Metodo para presentar la busqueda por aerolineas filial
     */
    private void presentacionFilial() {
        Object cli03 = ADFUtils.evaluateEL("#{sessionScope.isCLI03}");
        Object idFilial = ADFUtils.evaluateEL("#{sessionScope.idFilial}");
        Integer idFiliarInt = (Integer) idFilial;
        
        if (idFiliarInt > 0 && cli03 != null && String.valueOf(cli03).compareToIgnoreCase("TRUE") == 0) {
            getSoc40().setVisible(true);
            getPlam1().setVisible(false);
            getResId1c6().setVisible(true);
            getResId1c7().setVisible(true);
        } else {
            getSoc40().setVisible(false);
            getPlam1().setVisible(true);
            getResId1c6().setVisible(false);
            getResId1c7().setVisible(false);
        }
        doPartialRefresh(getSoc40());
        doPartialRefresh(getPlam1());
        doPartialRefresh(getResId5());
    }

    public void valueChangeListenerIt5(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerIt6(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerId1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerId2(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerSoc10(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerSoc20(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerSoc30(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    /**
     * Seleccionar Aerolinea
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
     * Metodo para buscarIdLibroDireccion desde la filial
     */
    private void buscarIdLibroDireccion() {
        Object cli03 = ADFUtils.evaluateEL("#{sessionScope.isCLI03}");
        Object idFilial = ADFUtils.evaluateEL("#{sessionScope.idFilial}");
        Integer idFiliarInt = (Integer) idFilial;
        
        if (idFiliarInt > 0 && cli03 != null && String.valueOf(cli03).compareToIgnoreCase("TRUE") == 0) {
            String nombreSeleccionado = String.valueOf(getSoc40().getValue());
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


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
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

    public RichInputText getIt6() {
        return it6;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }


    public void setIt30(RichInputText it30) {
        this.it30 = it30;
    }

    public RichInputText getIt30() {
        return it30;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setResId3(RichTable resId3) {
        this.resId3 = resId3;
    }

    public RichTable getResId3() {
        return resId3;
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

    public RichInputText getIt10() {
        return it10;
    }

    public void setIt20(RichInputText it20) {
        this.it20 = it20;
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

    public String actionDescargar() {
        Map map = new HashMap<String, Object>();


        Object rolUsuario = ADFUtils.evaluateEL("#{sessionScope.isCLI02}");
        boolean isUsuario = (Boolean) rolUsuario;
        if (isUsuario) {
            map.put("idUsuario", convertirInt(ADFUtils.evaluateEL("#{sessionScope.idUsuario}")));
        } else {
            map.put("idUsuario", 0);
        }
        map.put("indiceAerolinea", convertirInt(getIt1().getValue()));
        map.put("indiceAeropuertoOrigen", convertirInt(getIt2().getValue()));
        map.put("indiceAeropuertoDestino", convertirInt(getIt3().getValue()));
        map.put("indiceAeronave", convertirInt(getIt4().getValue()));
        map.put("noVuelo", convertirString(getIt5().getValue()));
        map.put("fechaInicio", convertirString(getId1().getValue()));
        map.put("fechaFin", convertirString(getId2().getValue()));

        map.put("idManifiesto", convertirString(getIt6().getValue()));
        map.put("estado", convertirString(getSoc10().getValue()));
        map.put("tipoVuelo", convertirString(getSoc20().getValue()));
        map.put("tipoObservacion", convertirString(getSoc30().getValue()));

        map.put("tabla", "Manifiesto");
        map.put("usuario", convertirString(ADFUtils.evaluateEL("#{BaseBean.nameUser}")));
        map.put("usuarioPrograma", convertirString(ADFUtils.evaluateEL("#{session.servletContext.contextPath}")));

        Object respuesta = ADFUtils.ejecutaActionConReturn(getBindings(), "excelManifiestoExtendida", true, map);
        ADFUtils.setEL("#{sessionScope.idArchivo}", respuesta);

        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP5().show(hints);
        doPartialRefresh(getP5());

        return null;
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

    public RichSelectOneChoice getSoc10() {
        return soc10;
    }

    public void setSoc10(RichSelectOneChoice soc10) {
        this.soc10 = soc10;
    }

    public RichSelectOneChoice getSoc20() {
        return soc20;
    }

    public void setSoc20(RichSelectOneChoice soc20) {
        this.soc20 = soc20;
    }

    public RichSelectOneChoice getSoc30() {
        return soc30;
    }

    public void setSoc30(RichSelectOneChoice soc30) {
        this.soc30 = soc30;
    }

    public void setSoc40(RichSelectOneChoice soc40) {
        this.soc40 = soc40;
    }

    public RichSelectOneChoice getSoc40() {
        return soc40;
    }

    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setResId1c6(RichColumn resId1c6) {
        this.resId1c6 = resId1c6;
    }

    public RichColumn getResId1c6() {
        return resId1c6;
    }

    public void setResId1c7(RichColumn resId1c7) {
        this.resId1c7 = resId1c7;
    }

    public RichColumn getResId1c7() {
        return resId1c7;
    }
}
