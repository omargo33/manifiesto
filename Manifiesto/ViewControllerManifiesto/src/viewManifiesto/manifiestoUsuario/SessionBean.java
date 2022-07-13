  package WEB-INF.classes.viewManifiesto.manifiestoUsuario;
  
  import view.utilidades.ADFUtils;
  
  
  
  
  
  
  
  
  
  
  public class SessionBean
  {
    public void limpiar() {
      ADFUtils.setEL("#{sessionScope.aeropuertoDestinoDescripcion}", null);
      ADFUtils.setEL("#{sessionScope.aeronaveDescripcion}", null);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/viewManifiesto/manifiestoUsuario/SessionBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */