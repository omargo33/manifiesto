package viewManifiesto.preliquidacion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;

/**
 * Objeto para dar soporte a la generacion del PDF precalificacion.
 *
 * @author omargo33@hotmail.com
 */
public class PPRItemFrg extends BasePPR {
    //Direcciones
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;

    // Liquidacion monto
    private RichInputText it22;
    private RichInputText it23;
    private RichInputText it24;
    private RichInputText it25;
    private RichInputText it26;
    private RichInputText it27;

    //Aclaraciones
    private RichInputText it12;
    private RichInputText it13;
    private RichInputText it14;
    private RichInputText it15;
    private RichInputText it16;
    private RichInputText it17;
    private RichInputText it18;
    private RichInputText it19;
    private RichInputText it20;
    private RichInputText it21;
    //Popup
    private RichPopup p1;
    private RichPanelFormLayout pfl5;

    private RichSelectOneRadio sor1;

    private RichInputText it28;
    private RichInputText it29;

    /**
     * Metodo para crear un objeto.
     *
     */
    public PPRItemFrg() {
        super();

        //Aclaraciones
        it12 = new RichInputText();
        it13 = new RichInputText();
        it14 = new RichInputText();
        it15 = new RichInputText();
        it16 = new RichInputText();
        it17 = new RichInputText();
        it18 = new RichInputText();
        it19 = new RichInputText();
        it20 = new RichInputText();
        it21 = new RichInputText();
        //sumatorias
        it22 = new RichInputText();
        it23 = new RichInputText();
        it24 = new RichInputText();
        it25 = new RichInputText();
        it25.setValue("0");
        it26 = new RichInputText();
        it27 = new RichInputText();
        // total aclaraciones
        it28 = new RichInputText();
        //Cheque
        it29 = new RichInputText();
    }

    /**
     * Metodo para generar un pdf a base de los datos del formulario.
     *
     * @return
     */
    public String actionGenerarPDF() {
        Map map = new HashMap<String, Object>();

        if (!validacionAclaraciones()) {
            return null;
        }

        /*
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
*/
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        getP1().show(hints);
        doPartialRefresh(getP1());

        return null;
    }


    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setIt22(RichInputText it22) {
        this.it22 = it22;
    }

    public RichInputText getIt22() {
        return it22;
    }

    public void setIt23(RichInputText it23) {
        this.it23 = it23;
    }

    public RichInputText getIt23() {
        return it23;
    }

    public void setIt24(RichInputText it24) {
        this.it24 = it24;
    }

    public RichInputText getIt24() {
        try {
            Object o22 = it22.getValue();
            Object o23 = it23.getValue();
            BigDecimal d22 = new BigDecimal(String.valueOf(o22));
            BigDecimal d23 = new BigDecimal(String.valueOf(o23));
            BigDecimal multi = d22.multiply(d23);
            this.it24.setValue(multi.toPlainString());
        } catch (Exception e) {
            this.it24.setValue("0");
        }
        return it24;
    }

    public void setIt25(RichInputText it25) {
        this.it25 = it25;
    }

    public RichInputText getIt25() {
        return it25;
    }

    public void setIt26(RichInputText it26) {
        this.it26 = it26;
    }

    public RichInputText getIt26() {
        try {
            Object o22 = it22.getValue();
            Object o23 = it23.getValue();
            Object o25 = it25.getValue();
            BigDecimal d22 = new BigDecimal(String.valueOf(o22));
            BigDecimal d23 = new BigDecimal(String.valueOf(o23));
            BigDecimal d25 = new BigDecimal(String.valueOf(o25));
            BigDecimal multi = d22.multiply(d23);
            this.it26.setValue(multi.subtract(d25).toPlainString());
        } catch (Exception e) {
            this.it26.setValue("0");
        }
        return it26;
    }

    public void setIt27(RichInputText it27) {
        this.it27 = it27;
    }

    public RichInputText getIt27() {
        try {
            Object o22 = it22.getValue();
            Object o23 = it23.getValue();
            Object o25 = it25.getValue();
            BigDecimal d22 = new BigDecimal(String.valueOf(o22));
            BigDecimal d23 = new BigDecimal(String.valueOf(o23));
            BigDecimal d25 = new BigDecimal(String.valueOf(o25));
            BigDecimal multi = d22.multiply(d23);
            BigDecimal aprox = multi.subtract(d25);
            MathContext mc = new MathContext(6);
            aprox = aprox.round(mc);
            this.it27.setValue(aprox.toPlainString());
        } catch (Exception e) {
            this.it27.setValue("0");
        }
        return it27;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setIt14(RichInputText it14) {
        this.it14 = it14;
    }

    public RichInputText getIt14() {
        return it14;
    }

    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }

    public RichInputText getIt15() {
        return it15;
    }

    public void setIt16(RichInputText it16) {
        this.it16 = it16;
    }

    public RichInputText getIt16() {
        return it16;
    }

    public void setIt17(RichInputText it17) {
        this.it17 = it17;
    }

    public RichInputText getIt17() {
        return it17;
    }

    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }

    public RichInputText getIt18() {
        return it18;
    }

    public void setIt19(RichInputText it19) {
        this.it19 = it19;
    }

    public RichInputText getIt19() {
        return it19;
    }

    public void setIt20(RichInputText it20) {
        this.it20 = it20;
    }

    public RichInputText getIt20() {
        return it20;
    }

    public void setIt21(RichInputText it21) {
        this.it21 = it21;
    }

    public RichInputText getIt21() {
        return it21;
    }

    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }

    public void it22ValueChange(ValueChangeEvent valueChangeEvent) {
        doPartialRefresh((UIComponent) getIt24());
        doPartialRefresh((UIComponent) getIt26());
        doPartialRefresh((UIComponent) getIt27());
    }

    public void it23ValueChange(ValueChangeEvent valueChangeEvent) {
        doPartialRefresh((UIComponent) getIt24());
        doPartialRefresh((UIComponent) getIt26());
        doPartialRefresh((UIComponent) getIt27());
    }

    public void it25ValueChange(ValueChangeEvent valueChangeEvent) {
        doPartialRefresh((UIComponent) getIt24());
        doPartialRefresh((UIComponent) getIt26());
        doPartialRefresh((UIComponent) getIt27());
    }

    public void b1ValueChange(ActionEvent actionEvent) {
        this.it12.setValue("");
        this.it13.setValue("");
        calcularAclaraciones();
        doPartialRefresh((UIComponent) getIt12());
        doPartialRefresh((UIComponent) getIt13());

    }

    public void b2ValueChange(ActionEvent actionEvent) {
        this.it14.setValue("");
        this.it15.setValue("");
        calcularAclaraciones();
        doPartialRefresh((UIComponent) getIt14());
        doPartialRefresh((UIComponent) getIt15());
    }

    public void b3ValueChange(ActionEvent actionEvent) {
        this.it16.setValue("");
        this.it17.setValue("");
        calcularAclaraciones();
        doPartialRefresh((UIComponent) getIt16());
        doPartialRefresh((UIComponent) getIt17());

    }

    public void b4ValueChange(ActionEvent actionEvent) {
        this.it18.setValue("");
        this.it19.setValue("");
        calcularAclaraciones();
        doPartialRefresh((UIComponent) getIt18());
        doPartialRefresh((UIComponent) getIt19());

    }

    public void b5ValueChange(ActionEvent actionEvent) {
        this.it20.setValue("");
        this.it21.setValue("");
        calcularAclaraciones();
        doPartialRefresh((UIComponent) getIt20());
        doPartialRefresh((UIComponent) getIt21());
    }

    public void it13ValueChange(ValueChangeEvent valueChangeEvent) {
        calcularAclaraciones();
    }

    public void it15ValueChange(ValueChangeEvent valueChangeEvent) {
        calcularAclaraciones();
    }

    public void it17ValueChange(ValueChangeEvent valueChangeEvent) {
        calcularAclaraciones();
    }

    public void it19ValueChange(ValueChangeEvent valueChangeEvent) {
        calcularAclaraciones();
    }

    public void it21ValueChange(ValueChangeEvent valueChangeEvent) {
        calcularAclaraciones();
    }

    /**
     * Metodo para hacer los calculos de aclaraciones.
     *
     */
    private void calcularAclaraciones() {
        BigDecimal d13 = new BigDecimal(0);
        BigDecimal d15 = new BigDecimal(0);
        BigDecimal d17 = new BigDecimal(0);
        BigDecimal d19 = new BigDecimal(0);
        BigDecimal d21 = new BigDecimal(0);
        try {
            Object o13 = it13.getValue();
            d13 = new BigDecimal(String.valueOf(o13));
        } catch (Exception e) {
            d13 = new BigDecimal(0);
        }
        try {
            Object o15 = it15.getValue();
            d15 = new BigDecimal(String.valueOf(o15));
        } catch (Exception e) {
            d15 = new BigDecimal(0);
        }
        try {
            Object o17 = it17.getValue();
            d17 = new BigDecimal(String.valueOf(o17));
        } catch (Exception e) {
            d17 = new BigDecimal(0);
        }
        try {
            Object o19 = it19.getValue();
            d19 = new BigDecimal(String.valueOf(o19));
        } catch (Exception e) {
            d19 = new BigDecimal(0);
        }
        try {
            Object o21 = it21.getValue();
            d21 = new BigDecimal(String.valueOf(o21));
        } catch (Exception e) {
            d21 = new BigDecimal(0);
        }

        BigDecimal aclaracion = new BigDecimal(0);
        aclaracion = d13.add(d15);
        aclaracion = aclaracion.add(d17);
        aclaracion = aclaracion.add(d19);
        aclaracion = aclaracion.add(d21);

        this.it28.setValue(aclaracion.toPlainString());
        doPartialRefresh((UIComponent) getIt28());
    }

    public void setIt28(RichInputText it28) {
        this.it28 = it28;
    }

    public RichInputText getIt28() {
        return it28;
    }

    public void sor1ValueChange(ValueChangeEvent valueChangeEvent) {
        Object newValue = valueChangeEvent.getNewValue();
        if (newValue != null && String.valueOf(newValue).compareTo("C") == 0) {
            this.it29.setValue("");
            this.it29.setDisabled(false);
            doPartialRefresh((UIComponent) getIt29());
        } else {
            this.it29.setDisabled(true);
            doPartialRefresh((UIComponent) getIt29());
        }
    }

    /**
     * Metodo para validar las aclaraciones.
     *
     * @return
     */
    private boolean validacionAclaraciones() {

        if (isVacio(this.it12) != isVacio(this.it13)) {
            ADFUtils.setMensajeError("La aclaración 1 se encuentra erronea");
            return false;
        }

        if (isVacio(this.it14) != isVacio(this.it15)) {
            ADFUtils.setMensajeError("La aclaración 2 se encuentra erronea");
            return false;
        }

        if (isVacio(this.it16) != isVacio(this.it17)) {
            ADFUtils.setMensajeError("La aclaración 3 se encuentra erronea");
            return false;
        }

        if (isVacio(this.it18) != isVacio(this.it19)) {
            ADFUtils.setMensajeError("La aclaración 4 se encuentra erronea");
            return false;
        }

        if (isVacio(this.it20) != isVacio(this.it21)) {
            ADFUtils.setMensajeError("La aclaración 5 se encuentra erronea");
            return false;
        }
        return true;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setIt29(RichInputText it29) {
        this.it29 = it29;
    }

    public RichInputText getIt29() {
        return it29;
    }

    private boolean isVacio(RichInputText inputText) {
        if (inputText == null) {
            return true;
        }

        if (inputText.getValue() == null) {
            return true;
        }

        if (String.valueOf(inputText.getValue())
                  .trim()
                  .compareTo("") == 0) {
            return true;
        }

        return false;

    }
}
