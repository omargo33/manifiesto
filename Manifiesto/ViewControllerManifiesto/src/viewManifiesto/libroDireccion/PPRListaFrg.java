package viewManifiesto.libroDireccion;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;

/**
 * Clase para dar soporte al libro de direccion.
 *
 * @author omargo33@hotmail.com
 *
 */
public class PPRListaFrg extends BasePPR {
    private RichPopup p5;

    public PPRListaFrg() {
        super();
        setP5(new RichPopup());
    }

    public String actionDescargar() {
        String indice = "";
        String nombre = "";
        String tipo = "";
        String estado = "";
        DCIteratorBinding libroDireccion = ADFUtils.getIterator("LibroDireccionView1Iterator");
        try {
            ViewCriteria vc = libroDireccion.getViewCriteria();
            VariableValueManager vvm = vc.ensureVariableManager();

            Object objIndice = vvm.getVariableValue("v_Indice");
            if (objIndice != null && objIndice.toString()
                                              .trim()
                                              .length() > 0) {
                indice = objIndice.toString();
            }

            Object objNombre = vvm.getVariableValue("v_Nombre");
            if (objNombre != null && objNombre.toString()
                                              .trim()
                                              .length() > 0) {
                nombre = objNombre.toString();
            }

            Object objTipo = vvm.getVariableValue("v_Tipo");
            if (objTipo != null && objTipo.toString()
                                          .trim()
                                          .length() > 0) {
                tipo = objTipo.toString();
            }

            Object objEstado = vvm.getVariableValue("v_Estado");
            if (objEstado != null && objEstado.toString()
                                              .trim()
                                              .length() > 0) {
                estado = objEstado.toString();
            }


        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "error " + e.toString());
        }

        Map map = new HashMap<String, Object>();

        map.put("indice", indice);
        map.put("nombre", nombre);
        map.put("tipo", tipo);
        map.put("estado", estado);
        map.put("tabla", "LibroDirecciones");
        map.put("usuario", convertirString(ADFUtils.evaluateEL("#{BaseBean.nameUser}")));
        map.put("usuarioPrograma", convertirString(ADFUtils.evaluateEL("#{session.servletContext.contextPath}")));

        Object respuesta = ADFUtils.ejecutaActionConReturn(getBindings(), "excelLibroDirecciones", true, map);
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
