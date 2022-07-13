  package WEB-INF.classes.modelManifiesto.bc.modulo;
  
  import model.bc.VistaObjeto;
  import modelManifiesto.bc.ManifiestoModuloImpl;
  import modelManifiesto.bc.vista.AerolineaUsuarioViewRowImpl;
  import modelManifiesto.bc.vistaNoDML.UsuarioViewNoDMLImpl;
  import modelManifiesto.bc.vistaNoDML.UsuarioViewNoDMLRowImpl;
  import modelManifiesto.utilidades.estructura.AerolineaUsuarioIndices;
  import oracle.jbo.Row;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  import oracle.jbo.ViewCriteriaManager;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class AerolineaUsuario
  {
    public static AerolineaUsuarioIndices buscarUsuario(ManifiestoModuloImpl manifiestoModulo, String nick) {
      AerolineaUsuarioIndices aerolineaUsuarioIndices = new AerolineaUsuarioIndices();
      UsuarioViewNoDMLImpl usuarioViewNoDMLImpl = manifiestoModulo.getUsuarioViewNoDML1();
      ViewCriteriaManager vcm = usuarioViewNoDMLImpl.getViewCriteriaManager();
      ViewCriteria vc = vcm.getViewCriteria("UsuarioViewNoDMLCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_Nick", nick);
      usuarioViewNoDMLImpl.applyViewCriteria(vc);
      usuarioViewNoDMLImpl.executeQuery();
      while (usuarioViewNoDMLImpl.hasNext()) {
        Row r = usuarioViewNoDMLImpl.next();
        aerolineaUsuarioIndices.setIdUsuario(((Integer)r.getAttribute(UsuarioViewNoDMLRowImpl.IDUSUARIO)).intValue());
      } 
      
      if (aerolineaUsuarioIndices.getIdUsuario() != 0) {
        VistaObjeto vistaObjeto = manifiestoModulo.getAerolineaUsuarioView2();
        ViewCriteriaManager vcm1 = vistaObjeto.getViewCriteriaManager();
        ViewCriteria vc1 = vcm1.getViewCriteria("AerolineaUsuarioViewCriteriaByIdUsuario");
        VariableValueManager vvm1 = vc1.ensureVariableManager();
        vvm1.setVariableValue("v_IdUsuario", Integer.valueOf(aerolineaUsuarioIndices.getIdUsuario()));
        vistaObjeto.applyViewCriteria(vc1);
        vistaObjeto.executeQuery();
        while (vistaObjeto.hasNext()) {
          Row r = vistaObjeto.next();
          aerolineaUsuarioIndices.setIdAerolinea(((Integer)r.getAttribute(AerolineaUsuarioViewRowImpl.IDLIBRODIRECCIONAEROLINEA)).intValue());
          aerolineaUsuarioIndices.setIdAeropuerto(((Integer)r.getAttribute(AerolineaUsuarioViewRowImpl.IDLIBRODIRECCIONAEROPUERTO)).intValue());
        } 
      } 
      return aerolineaUsuarioIndices;
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/modulo/AerolineaUsuario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */