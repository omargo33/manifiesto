package viewManifiesto.manifiestoUsuario;

import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

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

    }

    /**
     * actionListener="#{bindings.ejecutarConsulta.execute}"
     */
    public void actionBuscar(ActionEvent actionEvent) {
        ejecutarBusqueda();
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

        ejecutarBusqueda();
    }

    /**
     * Metodo para buscar.
     *
     */
    private void ejecutarBusqueda() {
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

        ADFUtils.ejecutaAction(getBindings(), "ejecutarConsulta", null, null, map);
        doPartialRefresh(getResId5());
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
        
        //TODO validar cliente nivel cli02
        //para anular las busqueda y dejar con el valor del aeropuerto de forma quemada
    }


    public void valueChangeListenerIt5(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerId1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void valueChangeListenerId2(ValueChangeEvent valueChangeEvent) {
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
        map.put("tabla", "manifiesto");
        map.put("usuario", convertirString(ADFUtils.evaluateEL("#{BaseBean.nameUser}")));
        map.put("usuarioPrograma", convertirString(ADFUtils.evaluateEL("#{session.servletContext.contextPath}")));

        Object respuesta = ADFUtils.ejecutaActionConReturn(getBindings(), "excelManifiesto", true, map);
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
}
