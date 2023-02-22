package viewManifiesto.up;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.el.ValueExpression;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.jbo.Row;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;

/**
 * Objeto para soportar la pantalla de proceso de lotes.
 *
 * @author omargo33@hotmail.com
 *
 */
public class PPRListaFrg extends BasePPR {
    private RichPopup p1;
    private RichInputText it1;
    private RichRegion r1;
    private RichPopup p2;

    public PPRListaFrg() {
        super();
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    /**
     * Metodo para borrar los archivos.
     *
     * @return
     */
    public String borrarArchivos() {
        if (borrarLotes()) {
            getP2().hide();
            doPartialRefresh((UIComponent) getP2());
            return "Inicio";
        }
        return null;
    }

    /**
     * Metodo para borrar el lote de archivos sin procesar.
     *
     * @return
     */
    private boolean borrarLotes() {
        int idGrupo = 0;
        boolean estado = false;

        Map<String, String> mapaIdGrupo = new HashMap<String, String>();
        Map<String, String> mapaGrupoBorrar = new HashMap<String, String>();
        mapaIdGrupo.put("id", String.valueOf(ADFUtils.evaluateEL("#{sessionScope.idUsuario}")));
        mapaIdGrupo.put("esquema", "Manifiesto");
        mapaIdGrupo.put("tabla", "Usuario");

        idGrupo =
            Integer.parseInt(String.valueOf(ADFUtils.ejecutaActionConReturn(getBindings(), "base_grupoBuscarIdGrupo",
                                                                            true, mapaIdGrupo)));
        if (idGrupo <= 0) {
            ADFUtils.setMensajeError("No se ha podido localizar el grupo.");
            return estado;
        }

        mapaGrupoBorrar.put("idGrupo", String.valueOf(idGrupo));
        mapaGrupoBorrar.put("informacion", String.valueOf(ADFUtils.evaluateEL("#{BaseBean.remoteIp}")));
        mapaGrupoBorrar.put("usuario", String.valueOf(ADFUtils.evaluateEL("#{BaseBean.nameUser}")));
        mapaGrupoBorrar.put("usuarioPrograma",
                            String.valueOf(ADFUtils.evaluateEL("#{BaseBean.session.servletContext.contextPath}")));

        if (!ADFUtils.ejecutaActionConReturn(getBindings(), "base_grupoBorrarArchivos", mapaGrupoBorrar)) {
            ADFUtils.setMensajeError("No se ha podido borrar los archivos del lote.");
            return estado;
        }

        try {
            DCIteratorBinding archivo = ADFUtils.getIterator("Base_ArchivoView2Iterator");
            Row[] rows = archivo.getAllRowsInRange();
            for (Row r : rows) {
                r.setAttribute("Estado", "X");
            }
            ADFUtils.commitRollback(getBindings(), "Commit", "Rollback", null, null);

            rows = archivo.getAllRowsInRange();
            for (Row r : rows) {
                r.remove();
            }
            estado = true;
        } catch (Exception e) {
            ADFUtils.setMensajeError("No se pudo borrar la información de archivos.");
            estado = false;
        }

        doPartialRefresh((UIComponent) getR1());
        return estado;
    }

    public String procesarUp() {
        String textoRespuesta = "";
        Map<String, String> maParametros = new HashMap<String, String>();
        maParametros.put("id", "#{sessionScope.idUsuario}");
        maParametros.put("esquema", "Manifiesto");
        maParametros.put("tabla", "Usuario");

        try {
            Object respuesta = ADFUtils.ejecutaActionConReturn(getBindings(), "subirLoteArchivos", true, maParametros);
            Map<String, String> map = (Map<String, String>) respuesta;
            
            getP1().hide();
            doPartialRefresh(getP1());
            
            if (map.size() == 0) {
                if (borrarLotes()) {
                    return null;        
                }
            }

            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                textoRespuesta = textoRespuesta + entry.getKey() + ", valor: " + entry.getValue() + "\n";
            }
            getIt1().setValue(textoRespuesta);
            doPartialRefresh(getIt1());
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }

        return null;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void b1Action(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        doPartialRefresh(getP1());
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }
}
