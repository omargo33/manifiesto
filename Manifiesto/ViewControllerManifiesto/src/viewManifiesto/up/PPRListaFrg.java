package viewManifiesto.up;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;

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

    public PPRListaFrg() {
        super();
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public String procesarUp() {
        String textoRespuesta = "";        
        Map<String, String> maParametros = new HashMap();
        maParametros.put("id", "#{sessionScope.idUsuario}");
        maParametros.put("esquema", "Manifiesto");
        maParametros.put("tabla", "Usuario");

        try {
            Object respuesta = ADFUtils.ejecutaActionConReturn(getBindings(), "subirLoteArchivos", true, maParametros);
            Map<String, String> map = (Map<String, String>) respuesta;

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

        getP1().hide();
        doPartialRefresh(getP1());
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
}
