  package WEB-INF.classes.modelManifiesto.bc.modulo;
  
  import modelManifiesto.bc.ManifiestoModuloImpl;
  import modelManifiesto.bc.modulo.Manifiesto;
  import oracle.jbo.JboException;
  
  
  
  
  
  
  public class Manifiesto
  {
    private static String SQL_UPDATE = "update manifiesto set estado = 'C' where estado = 'BAD'";
    
    private static String SQL_UPDATE_ID_MANIFIESTO = "update manifiesto set estado = 'C' where estado = 'BAD' and id_manifiesto = ?";
  
  
  
  
  
  
  
  
    
    public static boolean cambiarEstado(ManifiestoModuloImpl manifiestoModulo, String idManifiesto) {
      boolean estado = true;
      manifiestoModulo.getBaseDML().ejecutaDML(SQL_UPDATE_ID_MANIFIESTO, new Object[] { idManifiesto });
      
      if (manifiestoModulo.getBaseDML().getMensaje() != null) {
        throw new JboException(manifiestoModulo.getBaseDML().getMensaje());
      }
      manifiestoModulo.commitRollback("", "");
      
      return estado;
    }
  
  
  
  
  
  
  
    
    public static boolean cambiarEstadoCompleto(ManifiestoModuloImpl manifiestoModulo) {
      boolean estado = true;
      manifiestoModulo.getBaseDML().ejecutaDML(SQL_UPDATE, new Object[0]);
      if (manifiestoModulo.getBaseDML().getMensaje() != null) {
        throw new JboException(manifiestoModulo.getBaseDML().getMensaje());
      }
      manifiestoModulo.commitRollback("", "");
      
      return estado;
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/modulo/Manifiesto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */