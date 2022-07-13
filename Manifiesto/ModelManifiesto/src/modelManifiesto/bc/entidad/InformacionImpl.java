  package WEB-INF.classes.modelManifiesto.bc.entidad;
  
  import model.bc.Entidad;
  import modelManifiesto.bc.entidad.InformacionImpl;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class InformacionImpl
    extends Entidad
  {
    public static final int IDINFORMACION = AttributesEnum.IdInformacion.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int VALOR01 = AttributesEnum.Valor01.index();
    public static final int VALOR02 = AttributesEnum.Valor02.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idInformacion) { return new Key(new Object[] { idInformacion }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelManifiesto.bc.entidad.Informacion"); }
  
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
      
      if (operation == 1)
        setAttribute(IDINFORMACION, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/entidad/InformacionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */