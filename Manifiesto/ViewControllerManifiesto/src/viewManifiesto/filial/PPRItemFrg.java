package viewManifiesto.filial;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichButton;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import view.plantilla.BasePPR;

import view.utilidades.Flow;

import view.utilidades.ADFUtils;


/**
 * Objeto para dar soporte a las busqueda dinamica con paneles extensos.
 *
 * Y control para la creacion de la filial.
 *
 */
public class PPRItemFrg extends BasePPR {
    private static final long serialVersionUID = 1L;

    private RichInputText it2; //indiceAerolinea
    private RichInputText it20; //indiceAerolineaDescripcion
    private RichButton b2; //Boton aerolina
    private RichTable resId2; //Tabla aerolinea
    private RichPopup p2; //indiceAerolinea

    public PPRItemFrg() {
        super();
        init();
        iniciarDatosFormularios();
    }

    /**
     * Inicializa datos.
     */
    private void init() {
        setIt2(new RichInputText());
        setIt20(new RichInputText());
        setB2(new RichButton());
        setResId2(new RichTable());
        setP2(new RichPopup());
    }

    /**
     * Metodo para inicializar los datos de los formularios.
     *
     */
    public void iniciarDatosFormularios() {
        if (getAccionEstadoTaskFlow() == TASK_FLOW_EDITAR) {
            String nombreAerolinea = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.NombreAerolinea}"));
            getIt20().setValue(nombreAerolinea);
        }
    }

    /**
     * Accion Guardar.
     *
     * @return
     */
    public String actionGuardar() {
        if (getIt2() == null) {
            ADFUtils.setMensajeError("No ha sido Seleccionado la Aerolinea");
            return Flow.FLOW_NULL;
        }

        if (getIt2().getValue() == null) {
            ADFUtils.setMensajeError("No ha sido Seleccionado la Aerolinea");
            return Flow.FLOW_NULL;
        }

        try {
            if (Integer.valueOf(String.valueOf(getIt2().getValue())).intValue() < 1) {
                ADFUtils.setMensajeError("No ha sido Seleccionado la Aerolinea");
                return Flow.FLOW_NULL;
            }
        } catch (Exception e) {
            ADFUtils.setMensajeError("No ha sido Seleccionado la Aerolinea");
            return Flow.FLOW_NULL;
        }

        ADFUtils.setEL("#{bindings.IdLibroDireccion.inputValue}", Integer.valueOf(String.valueOf(getIt2().getValue())));

        if (ADFUtils.commitRollback(getBindings(), Flow.ACCION_COMMIT, Flow.ACCION_ROLLBACK,
                                    getBundle("msg_guardar_ko"), getBundle("msg_guardar_ok"))) {
            setAccionEstadoTaskFlow(TASK_FLOW_EDITAR);

            //Actualizar region.
            //doPartialRefresh(getR1().getParent());
            return Flow.FLOW_NULL;
        }

        return Flow.FLOW_INICIO;
    }

    /**
     * Accion Borrar.
     * @return
     */
    public String actionDelete() {
        ADFUtils.ejecutaFormulario(getBindings(), Flow.ACCION_DELETE, Flow.ACCION_COMMIT, Flow.ACCION_ROLLBACK,
                                   getBundle("msg_borrar_ko"), getBundle("msg_borrar_ok"));
        return Flow.FLOW_INICIO;
    }

    /**
     * Seleccionar Aeropuerto Origen
     *
     * @param actionEvent
     */
    public void accionSeleccionar2(ActionEvent actionEvent) {
        getP2().hide();
        doPartialRefresh(getP2());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId2().getSelectedRowData();
        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("IdLibroDireccion"));

        getIt2().setValue(indice);
        getIt20().setValue(descripcion);
        doPartialRefresh(getIt2());
        doPartialRefresh(getIt20());
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt20(RichInputText it20) {
        this.it20 = it20;
    }

    public RichInputText getIt20() {
        return it20;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setResId2(RichTable resId2) {
        this.resId2 = resId2;
    }

    public RichTable getResId2() {
        return resId2;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }
}
