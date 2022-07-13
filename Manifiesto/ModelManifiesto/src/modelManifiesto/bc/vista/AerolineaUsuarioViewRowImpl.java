  package WEB-INF.classes.modelManifiesto.bc.vista;
  
  import java.sql.Timestamp;
  import modelManifiesto.bc.entidad.AerolineaUsuarioImpl;
  import modelManifiesto.bc.vista.AerolineaUsuarioViewRowImpl;
  import oracle.jbo.RowIterator;
  import oracle.jbo.RowSet;
  import oracle.jbo.server.ViewRowImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class AerolineaUsuarioViewRowImpl
    extends ViewRowImpl
  {
    public static final int ENTITY_AEROLINEAUSUARIO = 0;
    public static final int IDAEROLINEAUSUARIO = AttributesEnum.IdAerolineaUsuario.index();
    public static final int IDLIBRODIRECCIONAEROLINEA = AttributesEnum.IdLibroDireccionAerolinea.index();
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int IDLIBRODIRECCIONAEROPUERTO = AttributesEnum.IdLibroDireccionAeropuerto.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int MANIFIESTOVIEW = AttributesEnum.ManifiestoView.index();
    public static final int USUARIOVIEWNODML1 = AttributesEnum.UsuarioViewNoDML1.index();
    public static final int LIBRODIRECCIONVIEW1 = AttributesEnum.LibroDireccionView1.index();
  
  
  
  
  
  
  
  
  
  
  
    
    public AerolineaUsuarioImpl getAerolineaUsuario() { return (AerolineaUsuarioImpl)getEntity(0); }
  
  
  
  
  
  
  
    
    public Integer getIdAerolineaUsuario() { return (Integer)getAttributeInternal(IDAEROLINEAUSUARIO); }
  
  
  
  
  
  
    
    public void setIdAerolineaUsuario(Integer value) { setAttributeInternal(IDAEROLINEAUSUARIO, value); }
  
  
  
  
  
  
    
    public Integer getIdLibroDireccionAerolinea() { return (Integer)getAttributeInternal(IDLIBRODIRECCIONAEROLINEA); }
  
  
  
  
  
  
    
    public void setIdLibroDireccionAerolinea(Integer value) { setAttributeInternal(IDLIBRODIRECCIONAEROLINEA, value); }
  
  
  
  
  
  
    
    public Integer getIdUsuario() { return (Integer)getAttributeInternal(IDUSUARIO); }
  
  
  
  
  
  
    
    public void setIdUsuario(Integer value) { setAttributeInternal(IDUSUARIO, value); }
  
  
  
  
  
  
  
    
    public Integer getIdLibroDireccionAeropuerto() { return (Integer)getAttributeInternal(IDLIBRODIRECCIONAEROPUERTO); }
  
  
  
  
  
  
    
    public void setIdLibroDireccionAeropuerto(Integer value) { setAttributeInternal(IDLIBRODIRECCIONAEROPUERTO, value); }
  
  
  
  
  
  
  
    
    public String getUsuario() { return (String)getAttributeInternal(USUARIO); }
  
  
  
  
  
  
    
    public void setUsuario(String value) { setAttributeInternal(USUARIO, value); }
  
  
  
  
  
  
    
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }
  
  
  
  
  
  
    
    public void setUsuarioFecha(Timestamp value) { setAttributeInternal(USUARIOFECHA, value); }
  
  
  
  
  
  
    
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }
  
  
  
  
  
  
    
    public void setUsuarioPrograma(String value) { setAttributeInternal(USUARIOPROGRAMA, value); }
  
  
  
  
  
    
    public RowIterator getManifiestoView() { return (RowIterator)getAttributeInternal(MANIFIESTOVIEW); }
  
  
  
  
  
    
    public RowSet getUsuarioViewNoDML1() { return (RowSet)getAttributeInternal(USUARIOVIEWNODML1); }
  
  
  
  
  
    
    public RowSet getLibroDireccionView1() { return (RowSet)getAttributeInternal(LIBRODIRECCIONVIEW1); }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/vista/AerolineaUsuarioViewRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */