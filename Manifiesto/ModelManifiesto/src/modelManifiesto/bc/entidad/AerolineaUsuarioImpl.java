  package WEB-INF.classes.modelManifiesto.bc.entidad;
  
  import model.bc.Entidad;
  import modelManifiesto.bc.entidad.AerolineaUsuarioImpl;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class AerolineaUsuarioImpl
    extends Entidad
  {
    public static final int IDAEROLINEAUSUARIO = AttributesEnum.IdAerolineaUsuario.index();
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int IDLIBRODIRECCIONAEROLINEA = AttributesEnum.IdLibroDireccionAerolinea.index();
    public static final int IDLIBRODIRECCIONAEROPUERTO = AttributesEnum.IdLibroDireccionAeropuerto.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int LIBRODIRECCION = AttributesEnum.LibroDireccion.index();
    public static final int MANIFIESTO = AttributesEnum.Manifiesto.index();
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idAerolineaUsuario) { return new Key(new Object[] { idAerolineaUsuario }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelManifiesto.bc.entidad.AerolineaUsuario"); }
  
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
      
      if (operation == 1)
        setAttribute(IDAEROLINEAUSUARIO, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/entidad/AerolineaUsuarioImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */