/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.tasasTimbres;

import com.aplicaciones13.nucleo.GeneradorWebServices;

/**
 * Objeto para estructura de respuesta de la tasas de timbre.
 *
 * @author omargo33@hotmail.com
 */
public class Respuesta extends GeneradorWebServices {

    private String errorDescripcion = null;

    /**
     * Metodo para analizar las respuestas de la solicitud URL.
     *
     */
    public Respuesta() {
        super();
        errorDescripcion = "";
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return (getTagValue("faultcode") + " " + getTagValue("errorCode")).trim();
    }

    /**
     * @return the errorDescripcion
     */
    public String getErrorDescripcion() {
        return (getTagValue("faultstring") + " " + getTagValue("errorDescription") + " " + errorDescripcion).trim();
    }

    /**
     *
     * @param errorDescripcion
     */
    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }
}
