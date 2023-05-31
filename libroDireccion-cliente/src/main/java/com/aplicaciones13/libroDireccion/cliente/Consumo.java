/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.libroDireccion.cliente;

import com.aplicaciones13.libroDireccion.cliente.estructura.LibroDirecciones;
import com.aplicaciones13.tools.LogTemp;


import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omarv
 */
public class Consumo extends SolicitaRESTURL {

    private static final String END_POINT_LIBRO_DIRECCION = "libroDireccion/";
    private LibroDirecciones libroDirecciones;
    private LibroDirecciones libroDireccionesRespuesta;
    private String contexto;

    /**
     * Metodo para cargar el Json solicitado.
     * 
     * @param pathCertificado
     * @param claveCertificado
     * @param ipProxy
     * @param puertoProxy
     * @param urlContexto
     * @param timeOut
     * @return 
     */    
    public boolean load(String pathCertificado, String claveCertificado, String ipProxy, String puertoProxy, String urlContexto, String usuario, String clave, int timeOut) {
        boolean respuesta = false;
        setPathCertificado(pathCertificado);
        setClaveCertificado(claveCertificado);
        setIpProxy(ipProxy);
        setPuertoProxy(puertoProxy);
        setTimeOut(timeOut);
        setContexto(urlContexto);

        if (ejecutarLibroDireccion()) {
            respuesta=true;
            //Log.escribir(this.getClass().getName(),"Load Ok");
        }
        
        return respuesta;
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
     * Metodo para ejecutar el certificado.
     *
     * @return
     */
    private boolean ejecutarLibroDireccion() {
        setJSONConsulta(getLibroDirecciones());
        setURLConsulta(this.contexto + END_POINT_LIBRO_DIRECCION);
        try {
            ejecutarConsultaWebService();
        } catch (Exception e) {
            //Log.escribir(this.getClass().getName(), ".ejecutarLibroDireccion()", e);
            return false;
        }
        if (getHTTPEstado() == 200) {
            if (isRespuestaLibroDirecicon(getJSONRespuesta())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para conocer
     *
     * @param json
     * @return
     */
    private boolean isRespuestaLibroDirecicon(String json) {
        try {
            libroDireccionesRespuesta = new LibroDirecciones();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            libroDireccionesRespuesta = objectMapper.readValue(json, LibroDirecciones.class);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(LibroDirecciones.class.getName()).log(Level.INFO, ex.toString());
            return false;
        }
        return true;
    }

    public void setLibroDirecciones(LibroDirecciones libroDirecciones) {
        this.libroDirecciones = libroDirecciones;
    }

    public String getLibroDirecciones() {
        String json = "";
        try {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(this.libroDirecciones);
        } catch (JsonProcessingException e) {
            LogTemp.escribir(Consumo.class.getName(), e.toString());
        }

        return json;
    }

    /**
     * Metodo para alimentar el contexto
     *
     * @param contexto
     */
    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    /**
     * @return the libroDireccionesRespuesta
     */
    public LibroDirecciones getLibroDireccionesRespuesta() {
        return libroDireccionesRespuesta;
    }
}