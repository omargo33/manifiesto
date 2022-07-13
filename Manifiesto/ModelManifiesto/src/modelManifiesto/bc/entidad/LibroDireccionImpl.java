  package WEB-INF.classes.modelManifiesto.bc.entidad;
  
  import model.bc.Entidad;
  import modelManifiesto.bc.entidad.LibroDireccionImpl;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  public class LibroDireccionImpl
    extends Entidad
  {
    public void remove() {
      setAttribute(ESTADO, "X");
      super.remove();
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static final int IDLIBRODIRECCION = AttributesEnum.IdLibroDireccion.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int INDICESECUNDARIO = AttributesEnum.IndiceSecundario.index();
    public static final int IDENTIFICACIONFISCAL = AttributesEnum.IdentificacionFiscal.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int CORREO = AttributesEnum.Correo.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int AEROLINEAUSUARIO = AttributesEnum.AerolineaUsuario.index();
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idLibroDireccion) { return new Key(new Object[] { idLibroDireccion }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelManifiesto.bc.entidad.LibroDireccion"); }
  
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      if (operation == 3) {
        noBorrar(new int[] { AEROLINEAUSUARIO });
        operation = 2;
      } 
      
      super.doDML(operation, e);
      
      if (operation == 1)
        setAttribute(IDLIBRODIRECCION, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/entidad/LibroDireccionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */