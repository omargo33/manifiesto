package viewManifiesto.manifiestoUsuario;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;
import view.utilidades.Flow;

/**
 * Objeto para dar soporte a la pantalla de ingreso de item del sistema.
 *
 * @author omargo33@hotmail.com
 *
 */
public class PPRItemFrg extends BasePPR {

    private RichPanelFormLayout pfl3;
    private RichPanelFormLayout pfl5;
    private RichPanelFormLayout pfl6;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;
    private RichInputText it8;
    private RichInputText it9;
    private RichInputText it10;
    private RichInputText it11;
    private RichInputText it12;
    private RichInputText it13;
    private RichInputText it15;
    private RichInputText it18;
    private RichInputText it19;
    private RichInputText it20;
    private RichInputText it21;
    private RichSelectOneChoice soc1;
    private RichSelectOneChoice soc6;
    private int it6Int = 0;
    private int it8Int = 0;
    private int it10Int = 0;

    private int it19Int = 0;
    private int it20Int = 0;
    private int it21Int = 0;

    private RichPopup p1;
    private RichPopup p2;
    private RichPopup p3;
    private RichPopup p4;

    private RichTable resId1;
    private RichTable resId2;
    private RichTable resId3;
    private RichTable resId4;
    private RichRegion r1;
    private RichRegion r2;
    private RichInputText it180;
    private RichInputText it190;
    private RichInputText it200;
    private RichInputText it210;

    /**
     * Clase para dar soporte para la item de muletos.
     *
     */
    public PPRItemFrg() {
        setNombreBundle("view.ViewControllerBundle");

        setPfl3(new RichPanelFormLayout());
        setPfl5(new RichPanelFormLayout());
        setPfl6(new RichPanelFormLayout());

        setIt3(new RichInputText());
        setIt4(new RichInputText());
        setIt5(new RichInputText());
        setIt6(new RichInputText());
        setIt7(new RichInputText());
        setIt8(new RichInputText());
        setIt9(new RichInputText());
        setIt10(new RichInputText());
        setIt11(new RichInputText());
        setIt12(new RichInputText());

        getIt12().setValue("0");

        setIt13(new RichInputText());

        setSoc1(new RichSelectOneChoice());
        setSoc6(new RichSelectOneChoice());
        setIt15(new RichInputText());
        setIt18(new RichInputText());
        setIt19(new RichInputText());
        setIt20(new RichInputText());
        setIt21(new RichInputText());

        setIt180(new RichInputText());
        setIt190(new RichInputText());
        setIt200(new RichInputText());
        setIt210(new RichInputText());

        setResId1(new RichTable());
        setResId2(new RichTable());
        setResId3(new RichTable());
        setResId4(new RichTable());

        setR1(new RichRegion());
        setR2(new RichRegion());

        limpiarEjecute();
    }

    public void limpiarEjecute() {
        try {
            setIt6Int(ADFUtils.evaluateEL("#{bindings.PasajerosExentosTasas.inputValue}"));
            setIt8Int(ADFUtils.evaluateEL("#{bindings.PasajerosPaganDolares.inputValue}"));
            setIt10Int(ADFUtils.evaluateEL("#{bindings.PasajerosExentosTimbres.inputValue}"));

            Object tipoVuelo = ADFUtils.evaluateEL("#{bindings.Tipo.inputValue}");
            if (tipoVuelo == null) {
                getPfl5().setVisible(false);
            } else if (((String) tipoVuelo).compareToIgnoreCase("N") == 0) {
                getPfl5().setVisible(false);
            } else {
                getPfl5().setVisible(true);
            }
        } catch (Exception e) {
            getPfl5().setVisible(false);
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "limpiarEjecute() 1 ov " + e.toString());
        }

        try {
            Object vueloCancelado = ADFUtils.evaluateEL("#{bindings.Cancelado.inputValue}");
            if (vueloCancelado == null) {
                anularCamposVueloCancelado(false);
            } else {
                if (((String) vueloCancelado).compareToIgnoreCase("C") == 0) {
                    //Deshabilitar
                    acerarValores();
                    anularCamposVueloCancelado(true);
                } else {
                    //Habilitar
                    anularCamposVueloCancelado(false);
                }
                //Refrescar
                doPartialRefresh((UIComponent) getPfl3());
                doPartialRefresh((UIComponent) getPfl5());
                doPartialRefresh((UIComponent) getPfl6());
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "limpiarEjecute() 2 ov " + e.toString());
        }
    }

    public void valueChangeSoc1(ValueChangeEvent valueChangeEvent) {

        try {

            Object oldValue = valueChangeEvent.getOldValue();
            Object newValue = valueChangeEvent.getNewValue();

            try {
                String old = String.valueOf(oldValue);
                String nuevo = String.valueOf(newValue);

                if (old.compareTo(nuevo) == 0) {
                    return;
                }
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                    .log(Level.WARNING, "valueChangeSoc1() 1 ov " + e.toString());

            }

            if (newValue != null) {
                if (String.valueOf(newValue).compareToIgnoreCase("C") == 0) {
                    //Deshabilitar
                    acerarValores();
                    anularCamposVueloCancelado(true);
                } else {
                    //Habilitar
                    anularCamposVueloCancelado(false);
                }
                //Refrescar
                doPartialRefresh((UIComponent) getPfl3());
                doPartialRefresh((UIComponent) getPfl5());
                doPartialRefresh((UIComponent) getPfl6());
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeSoc1() 2 ov " + e.toString());
        }
    }

    private void acerarValores() {
        try {
            // Input activos
            getIt3().setValue("0");
            getIt4().setValue("0");
            getIt6().setValue("0");
            getIt8().setValue("0");
            getIt10().setValue("0");
            getIt12().setValue("0");

            // Input inactivos
            getIt5().setValue("0");
            getIt7().setValue("0");
            getIt9().setValue("0");
            getIt11().setValue("0");
            getIt13().setValue("0");
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "acerarValores() ov " + e.toString());

        }
    }

    /**
     * Metodo para anular los campos de vuelo cancelado.
     *
     * @param estatus
     */
    private void anularCamposVueloCancelado(boolean estatus) {
        try {
            getIt3().setDisabled(estatus);
            getIt4().setDisabled(estatus);
            getIt6().setDisabled(estatus);
            getIt8().setDisabled(estatus);
            getIt10().setDisabled(estatus);
            //getIt12().setDisabled(estatus);
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                .log(Level.WARNING, "anularCamposVueloCancelado() ov " + e.toString());
        }
    }


    public void valueChangeSoc6(ValueChangeEvent valueChangeEvent) {
        Object oldValue = valueChangeEvent.getOldValue();
        Object newValue = valueChangeEvent.getNewValue();

        try {
            String old = String.valueOf(oldValue);
            String nuevo = String.valueOf(newValue);

            if (old.compareTo(nuevo) == 0) {
                return;
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeSoc6() 1 ov " + e.toString());

        }

        try {
            if (newValue != null) {
                if (String.valueOf(newValue).compareToIgnoreCase("N") == 0) {
                    getIt10().setValue("0");
                    getIt12().setValue("0");
                    getPfl5().setVisible(false);
                    doPartialRefresh((UIComponent) getPfl5());
                }

                if (String.valueOf(newValue).compareToIgnoreCase("I") == 0) {
                    getPfl5().setVisible(true);
                    doPartialRefresh((UIComponent) getPfl5());
                }
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeSoc6() 2 ov " + e.toString());

        }
    }


    public void valueChangeIt3(ValueChangeEvent valueChangeEvent) {
        try{
        doPartialRefresh((UIComponent) getIt5());

        doPartialRefresh((UIComponent) getIt7());

        doPartialRefresh((UIComponent) getIt9());

        doPartialRefresh((UIComponent) getIt11());
        doPartialRefresh((UIComponent) getIt12());
        doPartialRefresh((UIComponent) getIt13());
        }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeIt3() ov " + e.toString());

            }
    }


    public void valueChangeIt4(ValueChangeEvent valueChangeEvent) {
        try{
        doPartialRefresh((UIComponent) getIt5());

        doPartialRefresh((UIComponent) getIt7());

        doPartialRefresh((UIComponent) getIt9());

        doPartialRefresh((UIComponent) getIt11());
        doPartialRefresh((UIComponent) getIt12());
        doPartialRefresh((UIComponent) getIt13());
        }catch(Exception e){

                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeIt4() ov " + e.toString());
            }
    }


    public void valueChangeIt6(ValueChangeEvent valueChangeEvent) {
        try{
        setIt6Int(valueChangeEvent.getNewValue());
        doPartialRefresh((UIComponent) getIt7());

        doPartialRefresh((UIComponent) getIt9());

        doPartialRefresh((UIComponent) getIt11());
        doPartialRefresh((UIComponent) getIt12());
        doPartialRefresh((UIComponent) getIt13());
        }catch(Exception e){

                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeIt6() ov " + e.toString());
            }
    }


    public void valueChangeIt8(ValueChangeEvent valueChangeEvent) {
        try{
        setIt8Int(valueChangeEvent.getNewValue());

        doPartialRefresh((UIComponent) getIt9());

        doPartialRefresh((UIComponent) getIt11());
        doPartialRefresh((UIComponent) getIt12());
        doPartialRefresh((UIComponent) getIt13());
        }catch(Exception e){Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeIt8() ov " + e.toString());
            }
    }


    public void valueChangeIt10(ValueChangeEvent valueChangeEvent) {
        try{
        setIt10Int(valueChangeEvent.getNewValue());

        getIt12().setValue("0");
        doPartialRefresh((UIComponent) getIt11());
        doPartialRefresh((UIComponent) getIt12());
        doPartialRefresh((UIComponent) getIt13());
        }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueChangeIt10() ov " + e.toString());
            
            }
    }


    private String valueResta(RichInputText arg1, RichInputText arg2) {
        int argRespuesta=0;
        
        try{
        
        if (arg1 == null) {
            arg1 = new RichInputText();
            arg1.setValue("0");
        }

        if (arg2 == null) {
            arg2 = new RichInputText();
            arg2.setValue("0");
        }

        if (arg1.getValue() == null) {
            arg1 = new RichInputText();
            arg1.setValue("0");
        }

        if (arg2.getValue() == null) {
            arg2 = new RichInputText();
            arg2.setValue("0");
        }

        int arg1Int = 0;
        int arg2Int = 0;
        try {
            arg1Int = Integer.valueOf((String) arg1.getValue()).intValue();
        } catch (Exception e) {
            arg1Int = 0;
        }
        try {
            arg2Int = Integer.valueOf((String) arg2.getValue()).intValue();
        } catch (Exception e) {
            arg2Int = 0;
        }

        argRespuesta = arg1Int - arg2Int;
        }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "valueResta() ov " + e.toString());
            }
        return String.valueOf(argRespuesta);
    }

    public void accionSeleccionar1(ActionEvent actionEvent) {
        try{
        getP1().hide();
        doPartialRefresh((UIComponent) getP1());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId1().getSelectedRowData();

        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        getIt20().setValue(indice);
        getIt200().setValue(descripcion);

        ADFUtils.setEL("#{bindings.IdLibroDireccionAeropuertoDes.inputValue}", indice);

        doPartialRefresh((UIComponent) getIt20());
        doPartialRefresh((UIComponent) getIt200());
        }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "accionSeleccionar1() ov " + e.toString());
            }
    }

    public void accionSeleccionar2(ActionEvent actionEvent) {
        try{
        getP2().hide();
        doPartialRefresh((UIComponent) getP2());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId2().getSelectedRowData();


        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        ADFUtils.setEL("#{bindings.IdLibroDireccionAeronave.inputValue}", indice);

        getIt21().setValue(indice);
        getIt210().setValue(descripcion);
        doPartialRefresh((UIComponent) getIt21());
        doPartialRefresh((UIComponent) getIt210());
        }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "accionSeleccionar2() ov " + e.toString());
            }
    }

    public void accionSeleccionar3(ActionEvent actionEvent) {
        try{
        getP3().hide();
        doPartialRefresh((UIComponent) getP3());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId3().getSelectedRowData();


        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        ADFUtils.setEL("#{bindings.IdLibroDireccionAeropuerto.inputValue}", indice);

        getIt19().setValue(indice);
        getIt190().setValue(descripcion);
        doPartialRefresh((UIComponent) getIt19());
        doPartialRefresh((UIComponent) getIt190());
        }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "accionSeleccionar3() ov " + e.toString());
            }
    }

    public void accionSeleccionar4(ActionEvent actionEvent) {
        try{
        getP4().hide();
        doPartialRefresh((UIComponent) getP4());

        JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding) getResId4().getSelectedRowData();


        String descripcion =
            String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " +
            String.valueOf(nodeBinding.getAttribute("Nombre"));
        String indice = String.valueOf(nodeBinding.getAttribute("Indice"));

        ADFUtils.setEL("#{bindings.IdLibroDireccionAerolinea.inputValue}", indice);

        getIt18().setValue(indice);
        getIt180().setValue(descripcion);
        doPartialRefresh((UIComponent) getIt18());
        doPartialRefresh((UIComponent) getIt180());
        }catch(Exception e){
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "accionSeleccionar4() ov " + e.toString());
            }
    }


    public String actionGuardar() {

        try {

            boolean estado = true;

            if (getIt19() == null || getIt19().getValue() == null || String.valueOf(getIt19().getValue())
                                                                           .trim()
                                                                           .length() == 0) {
                estado = false;
                ADFUtils.setMensajeError("No ha sido Seleccionado el Aeropuerto Origen");
            }

            if (getIt20() == null || getIt20().getValue() == null || String.valueOf(getIt20().getValue())
                                                                           .trim()
                                                                           .length() == 0) {
                estado = false;
                ADFUtils.setMensajeError("No ha sido Seleccionado el Aeropuerto Destino");
            }

            if (getIt21() == null || getIt21().getValue() == null || String.valueOf(getIt21().getValue())
                                                                           .trim()
                                                                           .length() == 0) {
                estado = false;
                ADFUtils.setMensajeError("No ha sido Seleccionado la Matricula de la Aeronave");
            }

            ADFUtils.setEL("#{bindings.PasajerosExentosTasas.inputValue}", Integer.valueOf(getIt6Int()));
            ADFUtils.setEL("#{bindings.PasajerosPaganDolares.inputValue}", Integer.valueOf(getIt8Int()));
            ADFUtils.setEL("#{bindings.PasajerosExentosTimbres.inputValue}", Integer.valueOf(getIt10Int()));


            valueRespuesta(getIt3(), "it3");
            valueRespuesta(getIt4(), "it4");
            valueRespuesta(getIt5(), "it5");
            valueRespuesta(getIt6(), "it6");
            valueRespuesta(getIt7(), "it7");
            valueRespuesta(getIt8(), "it8");
            valueRespuesta(getIt9(), "it9");
            valueRespuesta(getIt10(), "it10");
            valueRespuesta(getIt11(), "it11");
            valueRespuesta(getIt12(), "it12");
            valueRespuesta(getIt13(), "it13");


            if (estado) {
                if (ADFUtils.commitRollback(getBindings(), "Commit", "Rollback",
                                            getBundle("msg_guardar_ko", new Object[0]),
                                            getBundle("msg_guardar_ok", new Object[0]))) {
                    setAccionEstadoTaskFlow(2);
                    getR1().setRendered(true);
                    getR2().setRendered(true);
                    doPartialRefresh(getR1().getParent());
                    doPartialRefresh(getR2().getParent());
                    Logger.getLogger("global").log(Level.WARNING, "actualizao region=yes");

                    getIt6().setValue(Integer.valueOf(getIt6Int()));
                    getIt8().setValue(Integer.valueOf(getIt8Int()));
                    getIt10().setValue(Integer.valueOf(getIt10Int()));
                    return Flow.FLOW_NULL;
                }
                return "Inicio";
            }
        } catch (Exception e) {

            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "actionGuardar() ov " + e.toString());
        }
        return Flow.FLOW_NULL;
    }


    private void valueRespuesta(RichInputText arg1, String tex) {
        try {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, tex + "=" + arg1.getValue());
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING,"valueRespuesta() ov " + e.toString());
        }
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }


    public RichSelectOneChoice getSoc1() {
        return this.soc1;
    }


    public void setSoc6(RichSelectOneChoice soc6) {
        this.soc6 = soc6;
    }


    public RichSelectOneChoice getSoc6() {
        return this.soc6;
    }


    public RichInputText getIt15() {
        if (this.it15 == null) {
            this.it15 = new RichInputText();
        }
        return this.it15;
    }


    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }


    public RichInputText getIt18() {
        if (this.it18 == null) {
            this.it18 = new RichInputText();
        }

        return this.it18;
    }


    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }


    public RichInputText getIt19() {
        if (this.it19 == null) {
            this.it19 = new RichInputText();
        }

        return this.it19;
    }


    public void setIt19(RichInputText it19) {
        this.it19 = it19;
    }


    public RichInputText getIt20() {
        if (this.it20 == null) {
            this.it20 = new RichInputText();
        }

        return this.it20;
    }


    public void setIt20(RichInputText it20) {
        this.it20 = it20;
    }


    public RichInputText getIt21() {
        if (this.it21 == null) {
            this.it21 = new RichInputText();
        }
        return this.it21;
    }


    public void setIt21(RichInputText it21) {
        this.it21 = it21;
    }


    public int getIt19Int() {
        return this.it19Int;
    }


    public void setIt19Int(int it19Int) {
        this.it19Int = it19Int;
        getIt19().setValue(Integer.valueOf(it19Int));
        doPartialRefresh((UIComponent) getIt19());
    }


    public int getIt20Int() {
        return this.it20Int;
    }


    public void setIt20Int(int it20Int) {
        this.it20Int = it20Int;
        getIt20().setValue(Integer.valueOf(it20Int));
        doPartialRefresh((UIComponent) getIt20());
    }


    public int getIt21Int() {
        return this.it21Int;
    }


    public void setIt21Int(int it21Int) {
        this.it21Int = it21Int;
        getIt21().setValue(Integer.valueOf(it21Int));
        doPartialRefresh((UIComponent) getIt21());
    }


    public void setPfl3(RichPanelFormLayout panelFormInternacional) {
        this.pfl3 = panelFormInternacional;
    }

    public RichPanelFormLayout getPfl3() {
        return this.pfl3;
    }

    public void setPfl5(RichPanelFormLayout panelFormInternacional) {
        this.pfl5 = panelFormInternacional;
    }

    public RichPanelFormLayout getPfl5() {
        return this.pfl5;
    }

    public void setPfl6(RichPanelFormLayout panelFormInternacional) {
        this.pfl6 = panelFormInternacional;
    }

    public RichPanelFormLayout getPfl6() {
        return this.pfl6;
    }


    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }


    public RichInputText getIt3() {
        return this.it3;
    }


    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }


    public RichInputText getIt4() {
        return this.it4;
    }


    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }


    public RichInputText getIt5() {
        this.it5.setValue(valueResta(getIt3(), getIt4()));
        return this.it5;
    }


    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }


    public RichInputText getIt6() {
        return this.it6;
    }


    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }


    public RichInputText getIt7() {
        this.it7.setValue(valueResta(getIt5(), getIt6()));
        return this.it7;
    }


    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }


    public RichInputText getIt8() {
        return this.it8;
    }


    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }


    public RichInputText getIt9() {
        this.it9.setValue(valueResta(getIt7(), getIt8()));
        return this.it9;
    }


    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }


    public RichInputText getIt10() {
        return this.it10;
    }


    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }


    public RichInputText getIt11() {
        this.it11.setValue(valueResta(getIt5(), getIt10()));
        return this.it11;
    }


    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }


    public RichInputText getIt12() {
        if (this.it12 == null) {
            this.it12 = new RichInputText();
        }

        return this.it12;
    }


    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }


    public RichInputText getIt13() {
        this.it13.setValue(valueResta(getIt11(), getIt12()));
        return this.it13;
    }


    public void setIt200(RichInputText it200) {
        this.it200 = it200;
    }


    public RichInputText getIt200() {
        if (this.it200 == null) {
            this.it200 = new RichInputText();
        }

        return this.it200;
    }


    public void setIt210(RichInputText it210) {
        this.it210 = it210;
    }


    public RichInputText getIt210() {
        if (this.it210 == null) {
            this.it210 = new RichInputText();
        }

        return this.it210;
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


    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }


    public RichPopup getP3() {
        return this.p3;
    }


    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }


    public RichPopup getP4() {
        return this.p4;
    }


    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }


    public RichTable getResId1() {
        return this.resId1;
    }


    public void setResId2(RichTable resId2) {
        this.resId2 = resId2;
    }


    public RichTable getResId2() {
        return this.resId2;
    }


    public void setResId3(RichTable resId3) {
        this.resId3 = resId3;
    }


    public RichTable getResId3() {
        return this.resId3;
    }


    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }


    public RichRegion getR1() {
        return this.r1;
    }


    public void setR2(RichRegion r2) {
        this.r2 = r2;
    }


    public RichRegion getR2() {
        return this.r2;
    }


    public void setIt190(RichInputText it190) {
        this.it190 = it190;
    }


    public RichInputText getIt190() {
        if (this.it190 == null) {
            this.it190 = new RichInputText();
        }

        return this.it190;
    }


    public boolean isCrear() {
        return verificarPermiso("#{pageFlowScope.pPermisoCrear}");
    }


    public boolean isActualizar() {
        return verificarPermiso("#{pageFlowScope.pPermisoActualizar}");
    }


    public boolean isBorrar() {
        return verificarPermiso("#{pageFlowScope.pPermisoBorrar}");
    }


    private boolean verificarPermiso(String permiso) {
        boolean flag = true;
        try {
            Object estado = ADFUtils.evaluateEL("#{bindings.Estado.inputValue}");
            flag = (((String) estado).compareToIgnoreCase("C") == 0);
            if (flag) {
                flag = ((Boolean) ADFUtils.evaluateEL(permiso)).booleanValue();
            }
        } catch (Exception e) {
            flag = true;
        }
        return flag;
    }


    public RichTable getResId4() {
        return this.resId4;
    }


    public void setResId4(RichTable resId4) {
        this.resId4 = resId4;
    }


    public RichInputText getIt180() {
        if (this.it180 == null) {
            this.it180 = new RichInputText();
        }

        return this.it180;
    }


    public void setIt180(RichInputText it180) {
        this.it180 = it180;
    }


    public int getIt6Int() {
        return this.it6Int;
    }


    public void setIt6Int(Object it6Obj) {
        this.it6Int = evaluarValue(it6Obj);
    }


    private int evaluarValue(Object value) {
        int valorInt = 0;
        try {
            String valorString = value.toString();
            valorInt = Integer.valueOf(valorString).intValue();
        } catch (Exception e) {
            valorInt = 0;
        }
        return valorInt;
    }


    public int getIt8Int() {
        return this.it8Int;
    }


    public void setIt8Int(Object it8Obj) {
        this.it8Int = evaluarValue(it8Obj);
    }


    public int getIt10Int() {
        return this.it10Int;
    }


    public void setIt10Int(Object it10Obj) {
        this.it10Int = evaluarValue(it10Obj);
    }

    public String getCorregir() {
        limpiarEjecute();
        return "_";
    }

    public void setCorregir(String corregir) {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "corregir " + corregir);
    }
}
