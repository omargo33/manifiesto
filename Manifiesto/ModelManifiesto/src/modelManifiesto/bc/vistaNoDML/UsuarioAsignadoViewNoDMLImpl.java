  package WEB-INF.classes.modelManifiesto.bc.vistaNoDML;
  
  import model.bc.VistaObjeto;
  import modelManifiesto.bc.vistaNoDML.UsuarioAsignadoViewNoDMLImpl;
  import modelManifiesto.bc.vistaNoDML.common.UsuarioAsignadoViewNoDML;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class UsuarioAsignadoViewNoDMLImpl
    extends VistaObjeto
    implements UsuarioAsignadoViewNoDML
  {
    public void ejecutarByIndice(int idUsuario) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("UsuarioAsignadoViewNoDMLCriteriaByIdUsuario");
      VariableValueManager vvm = vc.ensureVariableManager();
      
      vvm.setVariableValue("v_IdUsuario", Integer.valueOf(idUsuario));
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/vistaNoDML/UsuarioAsignadoViewNoDMLImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */