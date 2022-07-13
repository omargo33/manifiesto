  package WEB-INF.classes.modelManifiesto.bc.vista;
  
  import model.bc.VistaObjeto;
  import modelManifiesto.bc.vista.ManifiestoViewImpl;
  import modelManifiesto.bc.vista.common.ManifiestoView;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class ManifiestoViewImpl
    extends VistaObjeto
    implements ManifiestoView
  {
    public void ejecutarByIndice(int idManifiesto) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("ManifiestoViewCriteriaByIndice");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_IdManifiesto", Integer.valueOf(idManifiesto));
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/vista/ManifiestoViewImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */