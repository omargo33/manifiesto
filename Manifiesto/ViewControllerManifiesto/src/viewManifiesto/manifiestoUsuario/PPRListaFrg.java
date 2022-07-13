  package WEB-INF.classes.viewManifiesto.manifiestoUsuario;
  
  import java.util.HashMap;
  import java.util.Map;
  import javax.faces.component.UIComponent;
  import javax.faces.event.ActionEvent;
  import javax.faces.event.ValueChangeEvent;
  import oracle.adf.view.rich.component.rich.RichPopup;
  import oracle.adf.view.rich.component.rich.data.RichTable;
  import oracle.adf.view.rich.component.rich.input.RichInputDate;
  import oracle.adf.view.rich.component.rich.input.RichInputText;
  import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
  import view.plantilla.BasePPR;
  import view.utilidades.ADFUtils;
  import viewManifiesto.manifiestoUsuario.PPRListaFrg;
  
  
  
  
  
  
  
  
  
  
  
  
  public class PPRListaFrg
    extends BasePPR
  {
    private static final long serialVersionUID = 1L;
    private RichInputText it1;
    private RichInputText it10;
    private RichInputText it2;
    private RichInputText it20;
    private RichInputText it3;
    private RichInputText it30;
    private RichInputText it4;
    private RichInputText it40;
    private RichInputText it5;
    private RichInputDate id1;
    private RichInputDate id2;
    private RichTable resId1;
    private RichTable resId2;
    private RichTable resId3;
    private RichTable resId4;
    private RichTable resId5;
    private RichPopup p1;
    private RichPopup p2;
    private RichPopup p3;
    private RichPopup p4;
    private RichPopup p5;
    
    public PPRListaFrg() {
      init();
      iniciarDatosFormularios();
    }
  
  
  
    
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
  
  
  
  
  
    
    public void actionBuscar(ActionEvent actionEvent) { ejecutarBusqueda(); }
  
    
    public String actionLimpiar() {
      iniciarDatosFormularios();
      return "Inicio";
    }
  
  
  
  
  
    
    public void accionLimpiar(ActionEvent actionEvent) {
      iniciarDatosFormularios();
      
      doPartialRefresh((UIComponent)getIt1());
      doPartialRefresh((UIComponent)getIt10());
      
      doPartialRefresh((UIComponent)getIt2());
      doPartialRefresh((UIComponent)getIt20());
      
      doPartialRefresh((UIComponent)getIt3());
      doPartialRefresh((UIComponent)getIt30());
      
      doPartialRefresh((UIComponent)getIt4());
      doPartialRefresh((UIComponent)getIt40());
      
      doPartialRefresh((UIComponent)getIt5());
      
      doPartialRefresh((UIComponent)getId1());
      doPartialRefresh((UIComponent)getId2());
      
      ejecutarBusqueda();
    }
  
  
  
  
    
    private void ejecutarBusqueda() {
      Map<Object, Object> map = new HashMap<>();
      
      Object rolUsuario = ADFUtils.evaluateEL("#{sessionScope.isCLI02}");
      boolean isUsuario = ((Boolean)rolUsuario).booleanValue();
      if (isUsuario) {
        map.put("idUsuario", Integer.valueOf(convertirInt(ADFUtils.evaluateEL("#{sessionScope.idUsuario}"))));
      } else {
        map.put("idUsuario", Integer.valueOf(0));
      } 
      
      map.put("indiceAerolinea", Integer.valueOf(convertirInt(getIt1().getValue())));
      map.put("indiceAeropuertoOrigen", Integer.valueOf(convertirInt(getIt2().getValue())));
      map.put("indiceAeropuertoDestino", Integer.valueOf(convertirInt(getIt3().getValue())));
      map.put("indiceAeronave", Integer.valueOf(convertirInt(getIt4().getValue())));
      map.put("noVuelo", convertirString(getIt5().getValue()));
      map.put("fechaInicio", convertirString(getId1().getValue()));
      map.put("fechaFin", convertirString(getId2().getValue()));
      
      ADFUtils.ejecutaAction(getBindings(), "ejecutarConsulta", null, null, map);
      doPartialRefresh((UIComponent)getResId5());
    }
  
  
  
  
    
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
    }
  
  
  
    
    public void valueChangeListenerIt5(ValueChangeEvent valueChangeEvent) {}
  
  
  
    
    public void valueChangeListenerId1(ValueChangeEvent valueChangeEvent) {}
  
  
  
    
    public void valueChangeListenerId2(ValueChangeEvent valueChangeEvent) {}
  
  
  
    
    public void accionSeleccionar1(ActionEvent actionEvent) {
      getP1().hide();
      doPartialRefresh((UIComponent)getP1());
      
      JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding)getResId1().getSelectedRowData();
  
      
      String descripcion = String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " + String.valueOf(nodeBinding.getAttribute("Nombre"));
      String indice = String.valueOf(nodeBinding.getAttribute("Indice"));
      
      getIt1().setValue(indice);
      getIt10().setValue(descripcion);
      doPartialRefresh((UIComponent)getIt1());
      doPartialRefresh((UIComponent)getIt10());
    }
  
  
  
  
  
  
    
    public void accionSeleccionar2(ActionEvent actionEvent) {
      getP2().hide();
      doPartialRefresh((UIComponent)getP2());
      
      JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding)getResId4().getSelectedRowData();
  
      
      String descripcion = String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " + String.valueOf(nodeBinding.getAttribute("Nombre"));
      String indice = String.valueOf(nodeBinding.getAttribute("Indice"));
      
      getIt2().setValue(indice);
      getIt20().setValue(descripcion);
      doPartialRefresh((UIComponent)getIt2());
      doPartialRefresh((UIComponent)getIt20());
    }
  
  
  
  
  
  
    
    public void accionSeleccionar3(ActionEvent actionEvent) {
      getP3().hide();
      doPartialRefresh((UIComponent)getP3());
      
      JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding)getResId2().getSelectedRowData();
  
      
      String descripcion = String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " + String.valueOf(nodeBinding.getAttribute("Nombre"));
      String indice = String.valueOf(nodeBinding.getAttribute("Indice"));
      
      getIt3().setValue(indice);
      getIt30().setValue(descripcion);
      doPartialRefresh((UIComponent)getIt3());
      doPartialRefresh((UIComponent)getIt30());
    }
  
  
  
  
  
    
    public void accionSeleccionar4(ActionEvent actionEvent) {
      getP4().hide();
      doPartialRefresh((UIComponent)getP4());
      
      JUCtrlHierNodeBinding nodeBinding = (JUCtrlHierNodeBinding)getResId3().getSelectedRowData();
  
      
      String descripcion = String.valueOf(nodeBinding.getAttribute("IndiceSecundario")) + " " + String.valueOf(nodeBinding.getAttribute("Nombre"));
      String indice = String.valueOf(nodeBinding.getAttribute("Indice"));
      
      getIt4().setValue(indice);
      getIt40().setValue(descripcion);
      doPartialRefresh((UIComponent)getIt4());
      doPartialRefresh((UIComponent)getIt40());
    }
  
  
    
    public void setResId1(RichTable resId1) { this.resId1 = resId1; }
  
  
    
    public RichTable getResId1() { return this.resId1; }
  
  
    
    public void setResId2(RichTable resId2) { this.resId2 = resId2; }
  
  
    
    public RichTable getResId2() { return this.resId2; }
  
  
  
    
    public void setIt1(RichInputText it1) { this.it1 = it1; }
  
  
    
    public RichInputText getIt1() { return this.it1; }
  
  
    
    public void setId2(RichInputDate id2) { this.id2 = id2; }
  
  
    
    public RichInputDate getId2() { return this.id2; }
  
  
    
    public void setId1(RichInputDate id1) { this.id1 = id1; }
  
  
    
    public RichInputDate getId1() { return this.id1; }
  
  
    
    public RichInputText getIt2() { return this.it2; }
  
  
    
    public void setIt2(RichInputText it2) { this.it2 = it2; }
  
  
    
    public RichInputText getIt3() { return this.it3; }
  
  
    
    public void setIt3(RichInputText it3) { this.it3 = it3; }
  
  
    
    public RichInputText getIt4() { return this.it4; }
  
  
    
    public void setIt4(RichInputText it4) { this.it4 = it4; }
  
  
    
    public RichInputText getIt5() { return this.it5; }
  
  
    
    public void setIt5(RichInputText it5) { this.it5 = it5; }
  
  
    
    public void setIt30(RichInputText it30) { this.it30 = it30; }
  
  
    
    public RichInputText getIt30() { return this.it30; }
  
  
    
    public void setP1(RichPopup p1) { this.p1 = p1; }
  
  
    
    public RichPopup getP1() { return this.p1; }
  
  
    
    public void setResId3(RichTable resId3) { this.resId3 = resId3; }
  
  
    
    public RichTable getResId3() { return this.resId3; }
  
  
    
    public void setP2(RichPopup p2) { this.p2 = p2; }
  
  
    
    public RichPopup getP2() { return this.p2; }
  
  
    
    public void setIt40(RichInputText it40) { this.it40 = it40; }
  
  
    
    public RichInputText getIt40() { return this.it40; }
  
  
    
    public void setP3(RichPopup p3) { this.p3 = p3; }
  
  
    
    public RichPopup getP3() { return this.p3; }
  
  
    
    public void setP4(RichPopup p4) { this.p4 = p4; }
  
  
    
    public RichPopup getP4() { return this.p4; }
  
  
    
    public void setIt10(RichInputText it10) { this.it10 = it10; }
  
  
    
    public RichInputText getIt10() { return this.it10; }
  
  
    
    public void setIt20(RichInputText it20) { this.it20 = it20; }
  
  
    
    public RichInputText getIt20() { return this.it20; }
  
  
    
    public void setResId4(RichTable resId4) { this.resId4 = resId4; }
  
  
    
    public RichTable getResId4() { return this.resId4; }
  
  
    
    public void setResId5(RichTable resId5) { this.resId5 = resId5; }
  
  
    
    public RichTable getResId5() { return this.resId5; }
  
    
    public String actionDescargar() {
      Map<Object, Object> map = new HashMap<>();
  
      
      Object rolUsuario = ADFUtils.evaluateEL("#{sessionScope.isCLI02}");
      boolean isUsuario = ((Boolean)rolUsuario).booleanValue();
      if (isUsuario) {
        map.put("idUsuario", Integer.valueOf(convertirInt(ADFUtils.evaluateEL("#{sessionScope.idUsuario}"))));
      } else {
        map.put("idUsuario", Integer.valueOf(0));
      } 
      map.put("indiceAerolinea", Integer.valueOf(convertirInt(getIt1().getValue())));
      map.put("indiceAeropuertoOrigen", Integer.valueOf(convertirInt(getIt2().getValue())));
      map.put("indiceAeropuertoDestino", Integer.valueOf(convertirInt(getIt3().getValue())));
      map.put("indiceAeronave", Integer.valueOf(convertirInt(getIt4().getValue())));
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
      doPartialRefresh((UIComponent)getP5());
      
      return null;
    }
  
    
    public void setP5(RichPopup p5) { this.p5 = p5; }
  
  
    
    public RichPopup getP5() { return this.p5; }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/viewManifiesto/manifiestoUsuario/PPRListaFrg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */