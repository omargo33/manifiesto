/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.tasasTimbres;

import com.aplicaciones13.nucleo.SolicitaWebServicesURL;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Objeto para realizar la consulta al cliente con la estructura de tasas de
 * interes
 *
 * @author omargo33@hotmail.com
 */
public class TasasTimbresCliente {

    private final Encabezado encabezado = new Encabezado();
    private final Cuerpo cuerpo = new Cuerpo();
    private final Respuesta respuesta = new Respuesta();

    final static String XML_CONSULTA = "<?xml version = '1.0' encoding = 'UTF-8'?><env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:ns2=\"http://oracle.e1.bssv.JP574224/\"><env:Header>%s</env:Header><env:Body>%s</env:Body></env:Envelope>";

    public TasasTimbresCliente() {
        super();
    }

    /**
     * Metodo para ejecutar la consulta.
     *
     * @return
     */
    public boolean ejecutarConsulta() {
        boolean estado = true;
        SolicitaWebServicesURL solicitaWebServicesURL = new SolicitaWebServicesURL() {
            @Override
            public HttpURLConnection generarConexion() throws MalformedURLException, IOException {
                URL url = new URL(getURLConsulta());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
                connection.setRequestProperty("SOAPACTION", "");
                return connection;
            }
        };

        solicitaWebServicesURL.setTimeOut(30000);
        solicitaWebServicesURL.setURLConsulta(getEncabezado().getUrl());
        solicitaWebServicesURL.setXMLConsulta(String.format(XML_CONSULTA, getEncabezado().generarSeguridad(), getCuerpo().generarCuerpo()));

        try {
            solicitaWebServicesURL.agregarCertificadoSSL(getEncabezado().getPathCertificado(), getEncabezado().getClaveCertificado());
            solicitaWebServicesURL.ejecutarConsultaWebService();
            solicitaWebServicesURL.quitarCertificadoSSL(getEncabezado().getPathCertificado());
        } catch (Exception e) {
            estado = false;
            this.respuesta.setErrorDescripcion("Error en la solicitud web service " + e.toString());
            return estado;
        }

        this.respuesta.setXmlDoc(solicitaWebServicesURL.getXMLDocument());
        if (getRespuesta().getErrorCode().length() > 0) {
            estado = false;
        }
        return estado;
    }

    //Propiedades
    /**
     * @return the encabezado
     */
    public Encabezado getEncabezado() {
        return encabezado;
    }

    /**
     * @return the cuerpo
     */
    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    /**
     * @return the respuesta
     */
    public Respuesta getRespuesta() {
        return respuesta;
    }
}
