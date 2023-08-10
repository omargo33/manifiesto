import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

//TODO: poner el paquete
/**
 * 
 * @author omargo33@gmail.com
 * @since 2023-07-23
 * 
 */
public class SolicitaRESTURL {

    private int timeOut;
    private int HTTPEstado = 0;

    private String JSONConsulta;
    private String URLConsulta;
    private String JSONRespuesta;
    private String errorRespuesta;

    private final Date fechaInicio;
    private Date fechaFin;

    /**
     * Metodo para crear el objeto.
     *
     */
    public SolicitaRESTURL() {
        super();
        timeOut = 0;
        HTTPEstado = 0;
        JSONConsulta = "";
        URLConsulta = "";
        JSONRespuesta = "";
        fechaInicio = new Date();
        fechaFin = new Date();
    }

    /**
     * Metodo para ejecutar una solicitud SOAP a un web services.
     *
     * Proceso el ingreso a sitios SSL. Inicializa mensajes de error Inicializa
     * datos para la conexion. Prepara a la conexion para enviar, recibir datos
     * y tiempos de espera en conexion y de escritura. Abre el puerto output y
     * envia el xml a ser consultado y cierra el puerto. Pregunta el estado de
     * la respuesta. Si la respuesta es HTTP_OK estado html 200 "respuesta ok
     * del servidor consultado" Lee el contendio del imputStream Caso contrario
     * Lee el contenido del imputStream de Error
     *
     * Consume el contenido del imputStream y pasa a un respuestaSOAP Cierra la
     * conexion al servidor.
     *
     * Si existio un error en el servidor lo notifica Devuelve el valor de la
     * consulta al web service.
     *
     * @throws Exception
     *
     */
    public void ejecutarConsultaWebService() throws Exception {
        String responseString = "";
        String respuesta = "";
        InputStream inputStream = null;

        HttpURLConnection connection = generarConexion();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setConnectTimeout(getTimeOut());
        connection.setReadTimeout(getTimeOut());

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
        outputStreamWriter.write(JSONConsulta);
        outputStreamWriter.close();

        HTTPEstado = ((HttpURLConnection) connection).getResponseCode();

        if (getHTTPEstado() != HttpURLConnection.HTTP_OK) {
            inputStream = ((HttpURLConnection) connection).getErrorStream();
        } else {
            inputStream = connection.getInputStream();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while ((responseString = bufferedReader.readLine()) != null) {
            respuesta = respuesta + responseString;
        }

        bufferedReader.close();
        fechaFin = new Date();
        
        if (getHTTPEstado() != HttpURLConnection.HTTP_OK) {
            errorRespuesta = respuesta;
            throw new Exception(String.valueOf(getHTTPEstado()));
        }

        JSONRespuesta = respuesta;
    }

    /**
     * Metodo para crear una nueva conexion.
     *
     * Se la puede sobrecargar.
     *
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public HttpURLConnection generarConexion() throws MalformedURLException, IOException {
        URL url = new URL(this.URLConsulta);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection;
    }
    
    /**
     * @return
     */
    public int getTimeOut() {
        return (timeOut == 0) ? 15000 : timeOut;
    }

    /**
     * @param timeOut
     */
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * @return
     */
    public int getHTTPEstado() {
        return HTTPEstado;
    }

    /**
     * @param URLConsulta
     */
    public void setURLConsulta(String URLConsulta) {
        this.URLConsulta = URLConsulta;
    }

    /**
     *
     * @return
     */
    public String getURLConsulta() {
        return this.URLConsulta;
    }

    /**
     * @return
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @return
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @return the errorRespuesta
     */
    public String getErrorRespuesta() {
        return errorRespuesta;
    }

    public void setErrorRespuesta(String errorRespuesta) {
        this.errorRespuesta = errorRespuesta;
    }

    /**
     * @param JSONConsulta the JSONConsulta to set
     */
    public void setJSONConsulta(String JSONConsulta) {
        this.JSONConsulta = JSONConsulta;
    }

    /**
     * @return the JSONRespuesta
     */
    public String getJSONRespuesta() {
        return JSONRespuesta;
    }
}
