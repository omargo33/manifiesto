package modelManifiesto.bc.reporte;

import com.aplicaciones13.reporte.pdf.ImpresionBaseElementos;

import com.itextpdf.layout.property.TextAlignment;

import com.aplicaciones13.reporte.pdf.itext.texto.Elemento;


import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para crear el formato de pdf de preliquidacion
 *
 * @author omargo33@hotmail.com
 *
 */
public class Preliquidacion extends ImpresionBaseElementos {

    private List<Object[]> valores;

    /**
     * Metodo para imprimir el elemento 1.
     *
     * Titulo del documento
     *
     */
    @Override
    public synchronized void elemento1() {        
        getEspacio().escribir(1);
        getH1().setTextoCentro("PRELIQUIDACION");
        getH1().escribir();
        getEspacio().escribir(1);
    }

    /**
     * Metodo para imprimir una form con los datos de la consulta.
     *
     */
    @Override
    public synchronized void elemento2() {
        getForm().setListaTitulos(
                "Aeropuerto Origen", 
                "Aeropuerto Destiono", 
                "Aeronave",
                "No. de Vuelo",
                "Fecha de inicio",
                "Fecha fin"                
                );
        getForm().setListaValores(
                getParametrosBusqueda().get("aeropuertoOrigen"), 
                getParametrosBusqueda().get("aeropuertoDestino"),
                getParametrosBusqueda().get("aeronave"),
                getParametrosBusqueda().get("noVuelo"),
                getParametrosBusqueda().get("fechaInicio"),
                getParametrosBusqueda().get("fechaFin")
                );
        getForm().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(4, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(5, TextAlignment.LEFT);
        getForm().getMapaAlineamiento().put(6, TextAlignment.LEFT);
        getForm().setListaDimensiones(15f, 85f);
        getForm().setListaFormatos(
            Elemento.FORMATO_STRING, 
            Elemento.FORMATO_STRING, 
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING
            );
        getForm().procesarEscribir();
    }

    /**
     * Metodo para imprimir el detalle del la consulta.
     *
     */
    @Override
    public synchronized void elemento3() {
        getTabla().setListaTitulos("Id. Manifiesto", 
                                   "Sigla Aeropuerto Origen", 
                                   "Aeropuerto Origen", 
                                   "Sigla Aeropuerto Destino", 
                                   "Aeropuerto Destino", 
                                   "Matricula Aeronave", 
                                   "Aeronave", 
                                   "Fecha Operación", 
                                   "No. Vuelo",
                                   "Pasajeros Embarcados",
                                   "Pasajeros en Transito",
                                   "Pasajeros Locales",
                                   "Pasajeros Exentos de Tasas",
                                   "Pasajeros Pagan Tasas",
                                   "Pasajeros Exentos Timbre",
                                   "Pasajeros Pagan Timbre",
                                   "Valor Unit. en pesos Timbres",
                                   "Valor Pesos Timbre",
                                   "Tipo",
                                   "Estado"
                                   );
        getTabla().setListaValores(valores);

        getTabla().getMapaAlineamiento().put(0, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);        
        getTabla().getMapaAlineamiento().put(3, TextAlignment.LEFT);        
        getTabla().getMapaAlineamiento().put(4, TextAlignment.LEFT);        
        getTabla().getMapaAlineamiento().put(5, TextAlignment.LEFT);        
        getTabla().getMapaAlineamiento().put(6, TextAlignment.LEFT);        
        getTabla().getMapaAlineamiento().put(7, TextAlignment.LEFT);        
        getTabla().getMapaAlineamiento().put(8, TextAlignment.LEFT);        
        
        getTabla().getMapaAlineamiento().put(9, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(10, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(11, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(12, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(13, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(14, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(15, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(16, TextAlignment.RIGHT);
        getTabla().getMapaAlineamiento().put(17, TextAlignment.RIGHT);
        
        getTabla().getMapaAlineamiento().put(18, TextAlignment.LEFT);        
        getTabla().getMapaAlineamiento().put(19, TextAlignment.LEFT);        
        
        
        getTabla().setListaDimensiones(5f, 5f, 10f, 5f, 10f, 5f, 10f, 5f, 5f, 5f,5f,5f,5f,5f,5f,5f, 7f, 7f, 5f,5f);
        getTabla().setListaFormatos(
            Elemento.FORMATO_STRING, 
            Elemento.FORMATO_STRING, 
            Elemento.FORMATO_STRING, 
            Elemento.FORMATO_STRING, 
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_ENTERO,
            Elemento.FORMATO_ENTERO,
            Elemento.FORMATO_ENTERO,
            Elemento.FORMATO_ENTERO,
            Elemento.FORMATO_ENTERO,
            Elemento.FORMATO_ENTERO,
            Elemento.FORMATO_ENTERO,
            Elemento.FORMATO_MONEDA,
            Elemento.FORMATO_MONEDA,
            Elemento.FORMATO_STRING,
            Elemento.FORMATO_STRING
            );
        getTabla().procesarEscribir();
    }

    /**
     * Metodo para alimentar los datos al formato.
     *
     * @param resultSet
     */
    public void setValores(ResultSet resultSet) {
        List<Object[]> valoresTemp = new ArrayList<Object[]>();
        Object[] fila = null;
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                fila = new Object[columns];
                for (int i = 0; i < columns; i++) {
                    fila[i] = resultSet.getObject(i + 1);
                }
                valoresTemp.add(fila);
            }
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        this.valores = valoresTemp;
    }
}
