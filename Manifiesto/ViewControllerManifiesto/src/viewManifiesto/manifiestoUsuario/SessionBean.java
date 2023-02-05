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

    /**
     * Metodo para limpiar los datos.
     */
    public void limpiar() {
        ADFUtils.setEL("#{sessionScope.aeropuertoDestinoDescripcion}", null);
        ADFUtils.setEL("#{sessionScope.aeronaveDescripcion}", null);
    }

    /**
     * Metodo para validar un data ingreso al ejecutar la pantalla de edit varias veces.
     */
    public void valiarDataIngreso() {
        PPRItemFrg pPRItemFrg = (PPRItemFrg) ADFUtils.evaluateEL("#{PPRBackingManifiestoUsuarioItemFrg}");
        if (pPRItemFrg != null) {
            pPRItemFrg.limpiarEjecute();
        }
    }
}
