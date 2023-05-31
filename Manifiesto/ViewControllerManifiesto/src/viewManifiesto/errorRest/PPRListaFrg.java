package viewManifiesto.errorRest;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;


public class PPRListaFrg extends BasePPR {
    private static final long serialVersionUID = 1L;
    private RichPopup p1;
    private RichPopup p2;
    private RichTable restId;

    public PPRListaFrg() {
        init();
    }

    private void init() {
        setP1(new RichPopup());
        setP2(new RichPopup());
        setRestId(new RichTable());
    }


    public String cambiarEstadoManifiestos() {
        ADFUtils.ejecutaAction(getBindings(), "cambiarEstadoManifiestos", null, null);
        getP1().hide();
        doPartialRefresh((UIComponent) getP1());

        ADFUtils.ejecutaAction(getBindings(), "ejecutarConsultaErrorJDE", null, null);
        doPartialRefresh((UIComponent) getRestId());
        return "Inicio";
    }


    public String cambiarEstadoManifiesto() {
        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getRestId().getSelectedRowData();
        String idManifiesto = String.valueOf(nodeBinding.getAttribute("IdManifiesto"));
        Map<Object, Object> mapaParametro = new HashMap<>();
        mapaParametro.put("idManifiesto", idManifiesto);

        ADFUtils.ejecutaAction(getBindings(), "cambiarEstadoManifiesto", null, null, mapaParametro);
        getP2().hide();
        doPartialRefresh((UIComponent) getP2());

        ADFUtils.ejecutaAction(getBindings(), "ejecutarConsultaErrorJDE", null, null);
        doPartialRefresh((UIComponent) getRestId());
        return "Inicio";
    }


    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }


    public RichPopup getP1() {
        return this.p1;
    }


    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }


    public RichPopup getP2() {
        return this.p2;
    }


    public void setRestId(RichTable restId) {
        this.restId = restId;
    }


    public RichTable getRestId() {
        return this.restId;
    }
}