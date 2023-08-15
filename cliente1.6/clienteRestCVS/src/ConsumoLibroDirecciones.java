//TODO: poner el paquete
 

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Clase para consumir el servicio web de Libro de Direcciones.
 * 
 * @Author omargo33@gmail.com
 * @since 2023-07-23
 * 
 */
public class ConsumoLibroDirecciones extends SolicitaRESTURL {

    private String contexto="";
    private Solicitud solicitud=new Solicitud();
    private Respuesta respuesta=new Respuesta();
    private RespuestaError respuestaError=new RespuestaError();

    /**
     * Metodo para cargar el Json solicitado.
     * 
     * @param timeOut
     * @return
     */
    public boolean load(int timeOut) {
        setTimeOut(timeOut);
        return ejecutar();
    }

    /**
     * Metodo para sobrecargar la conexion.
     *
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    @Override
    public HttpURLConnection generarConexion() throws MalformedURLException, IOException {
        URL url = new URL(getURLConsulta());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        return connection;
    }

    /**
     * Metodo para ejecutar la consulta.
     *
     * @return
     */
    private boolean ejecutar() {
        setJSONConsulta(solicitud.generarJSON());
        setURLConsulta(this.contexto);
        try {
            ejecutarConsultaWebService();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        if (getHTTPEstado() == 200) {
            if (isRespuestaOrdenCompra(getJSONRespuesta())) {
                return true;
            }else{
                respuestaError.leerJSON(getErrorRespuesta());
                return false;
            }
        } else {
            respuestaError.leerJSON(getErrorRespuesta());
            return false;
        }
        //return false;
    }

    /**
     * Metodo para conocer
     *
     * @param json
     * @return
     */
    private boolean isRespuestaOrdenCompra(String json) {
        respuesta.leerJSON(json);
        if (respuesta.getIdLibroDireccion() > 0) {
            return true;
        }
        return false;
    }

    // Getters and Setters
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public RespuestaError getRespuestaError() {
        return respuestaError;
    }


    public void setContexto(String contexto) {
        this.contexto = contexto;
    }
}