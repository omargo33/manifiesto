  package WEB-INF.classes.modelManifiesto.bc.vistaNoDML;
  
  import model.bc.VistaObjeto;
  import modelManifiesto.bc.vistaNoDML.LibroDireccionesViewNoDMLImpl;
  import modelManifiesto.bc.vistaNoDML.common.LibroDireccionesViewNoDML;
  import oracle.jbo.Row;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class LibroDireccionesViewNoDMLImpl
    extends VistaObjeto
    implements LibroDireccionesViewNoDML
  {
    public void ejecutarByIndice(int indice) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("LibroDireccionesViewNoDMLCriteriaByIndice");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_Indice", Integer.valueOf(indice));
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  
  
  
  
  
  
    
    public String ejecutarByIndiceReturn(int indice) {
      String respuesta = "<No Definido>";
      ejecutarByIndice(indice);
      try {
        Row row = first();
        String codigo = String.valueOf(row.getAttribute("IndiceSecundario"));
        String nombre = String.valueOf(row.getAttribute("Nombre"));
        respuesta = String.format("%s %s", new Object[] { codigo, nombre }).trim();
      } catch (Exception e) {
        respuesta = "<No Definido>";
      } 
      return respuesta;
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/vistaNoDML/LibroDireccionesViewNoDMLImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */