  package viewManifiesto.manifiestoUsuario;
  
  import view.utilidades.ADFUtils;
  
/**
 * Metodo para anular datos para la pagina de item para las descripciones de datos.
 *
 * @author omargo33@hotmail.com
 */
public class SessionBean {
    public SessionBean() {
        super();
    }
 
    public void limpiar() {
      ADFUtils.setEL("#{sessionScope.aeropuertoDestinoDescripcion}", null);
      ADFUtils.setEL("#{sessionScope.aeronaveDescripcion}", null);
    }
  }
