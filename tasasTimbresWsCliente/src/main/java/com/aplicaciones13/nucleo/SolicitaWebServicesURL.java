/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.nucleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Objeto para hacer una consutal a un web services, directo al stream input del
 * servidor.
 *
 * @author omargo33@hotmail.com
 *
 */
public class SolicitaWebServicesURL {

    private int timeOut;
    private int HTTPEstado = 0;
    private String mensajeError;
    private String XMLConsulta;
    private String URLConsulta;
    private String XMLRespuesta;
    private Document XMLDocument;
    private Date fechaInicio;
    private Date fechaFin;

    /**
     * Metodo para crear el objeto.
     *
     */
    public SolicitaWebServicesURL() {
        super();
    }

    /**
     * Metodo para ejecutar una solicitud SOAP a un web services.Proceso el
     * ingreso a sitios SSL.Inicializa mensajes de error
     *
     * Inicializa datos para la conexion.Prepara a la conexion para enviar,
     * recibir datos y tiempos de espera en conexion y de escritura.
     *
     * Abre el puerto output y envia el xml a ser consultado y cierra el puerto.
     * Pregunta el estado de la respuesta. Si la respuesta es HTTP_OK estado
     * html 200 "respuesta ok del servidor consultado" Lee el contendio del
     * imputStream Caso contrario Lee el contenido del imputStream de Error
     * Consume el contenido del imputStream y pasa a un respuestaSOAP Cierra la
     * conexion al servidor. Si existio un error en el servidor lo notifica
     * Devuelve el valor de la consulta al web service.
     *
     * @return
     * @throws java.io.IOException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws Exception
     * @throws org.xml.sax.SAXException
     *
     */
    public String ejecutarConsultaWebService() throws IOException, ParserConfigurationException, SAXException, Exception {
        setFechaInicio(new Date());
        tratamientSSL();

        setMensajeError(null);
        setXMLRespuesta("");
        String responseString = "";
        InputStream inputStream = null;

        HttpURLConnection connection = generarConexion();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setConnectTimeout(getTimeOut());
        connection.setReadTimeout(getTimeOut());

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream())) {
            outputStreamWriter.write(getXMLConsulta());
        }

        setHTTPEstado(((HttpURLConnection) connection).getResponseCode());

        if (getHTTPEstado() != HttpURLConnection.HTTP_OK) {
            inputStream = ((HttpURLConnection) connection).getErrorStream();
        } else {
            inputStream = connection.getInputStream();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((responseString = bufferedReader.readLine()) != null) {
                setXMLRespuesta(getXMLRespuesta() + responseString);
            }
        }
        setFechaFin(new Date());

        if (getHTTPEstado() != HttpURLConnection.HTTP_OK) {
            throw new Exception(String.valueOf(getHTTPEstado()));
        }

        creaDocument();
        return getXMLRespuesta();
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
        URL url = new URL(getURLConsulta());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        return connection;
    }

    /**
     * M�todo para no comprobar el SSL de un servidor.
     *
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws Exception
     */
    public void tratamientSSL() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier allHostsValid = (String hostname, SSLSession session) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

    /**
     * Metodo para convertir en un Document, objeto contenedor de un XML.
     *
     * @return
     */
    private boolean creaDocument() {
        boolean estado = true;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(getXMLRespuesta()));
            setXMLDocument(db.parse(is));
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(SolicitaWebServicesURL.class.getName()).log(Level.SEVERE, null, ex);
            estado = false;
        }
        return estado;
    }

    /**
     * Metodo para informar del web service.
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Direccion: %s\nXML solicitado: %s\nTiempo de espera: %s\nRespuesta %s\nMensaje Error %s\n Fecha Inicio %s\n Fecha Fin %s\n",
                getURLConsulta(), getXMLConsulta(), getTimeOut(), getXMLRespuesta(), getMensajeError(),
                getFechaInicio(), getFechaFin());
    }

    //Propiedades
    /**
     * @return
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensaje
     */
    public void setMensajeError(String mensaje) {
        this.mensajeError = mensaje;
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
     * @param estadoConsulta
     */
    public void setHTTPEstado(int estadoConsulta) {
        this.HTTPEstado = estadoConsulta;
    }

    /**
     * @return
     */
    public String getXMLRespuesta() {
        return XMLRespuesta;
    }

    /**
     * @param XMLRespuesta
     */
    public void setXMLRespuesta(String XMLRespuesta) {
        this.XMLRespuesta = XMLRespuesta;
    }

    /**
     * @return
     */
    public Document getXMLDocument() {
        return XMLDocument;
    }

    /**
     * @param XMLDocument
     */
    public void setXMLDocument(Document XMLDocument) {
        this.XMLDocument = XMLDocument;
    }

    /**
     * @return
     */
    public String getXMLConsulta() {
        return XMLConsulta;
    }

    /**
     * @param XMLConsulta
     */
    public void setXMLConsulta(String XMLConsulta) {
        this.XMLConsulta = XMLConsulta;
    }

    /**
     * @return
     */
    public String getURLConsulta() {
        return URLConsulta;
    }

    /**
     * @param URLConsulta
     */
    public void setURLConsulta(String URLConsulta) {
        this.URLConsulta = URLConsulta;
    }

    /**
     * @return
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Metodo para agregar certificado SSL.
     *
     * @param pathCertificado
     * @param claveCertificado
     */
    public void agregarCertificadoSSL(String pathCertificado, String claveCertificado) {
        if (pathCertificado != null && pathCertificado.length() > 0) {
            System.setProperty("javax.net.ssl.trustStoore", pathCertificado);
            System.setProperty("javax.net.ssl.keyStorePassword", claveCertificado);
        }
    }

    /**
     * Metodo para quitar el certificado ssL
     * 
     * @param pathCertificado
     */
    public void quitarCertificadoSSL(String pathCertificado) {
        if (pathCertificado != null && pathCertificado.length() > 0) {
            System.clearProperty("http.proxyHost");
            System.clearProperty("https.proxyHost");
        }
    }
}
