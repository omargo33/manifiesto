  package WEB-INF.classes.modelManifiesto.bc.entidad;
  
  import model.bc.Entidad;
  import modelManifiesto.bc.entidad.TasaImpl;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class TasaImpl
    extends Entidad
  {
    public static final int IDTASA = AttributesEnum.IdTasa.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int TASA = AttributesEnum.Tasa.index();
    public static final int TIMBRE = AttributesEnum.Timbre.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idTasa) { return new Key(new Object[] { idTasa }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelManifiesto.bc.entidad.Tasa"); }
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
  
      
      if (operation == 1)
        setAttribute(IDTASA, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/entidad/TasaImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */