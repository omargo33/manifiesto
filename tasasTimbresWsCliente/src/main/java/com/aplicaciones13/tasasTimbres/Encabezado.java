/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.tasasTimbres;

import com.aplicaciones13.nucleo.GeneradorWebServices;

/**
 * Objeto con la estructura de encabezado para las tasas y timbres.
 *
 * @author omargo33@hotmail.com
 */
public class Encabezado extends GeneradorWebServices {

    private String url;
    private String pathCertificado;
    private String claveCertificado;

    private String usuario;
    private String clave;

    /**
     * Metodo para crear el encabezado.
     * 
     */
    public Encabezado() {
        this.url = "";
        this.pathCertificado = "";
        this.claveCertificado = "";
        this.usuario = "";
        this.clave = "";
    }

    /**
     * Metodo para construir objeto
     *
     * @param url
     * @param pathCertificado
     * @param claveCertificado
     * @param usuario
     * @param clave
     */
    public Encabezado(String url, String pathCertificado, String claveCertificado, String usuario, String clave) {
        this.url = url;
        this.pathCertificado = pathCertificado;
        this.claveCertificado = claveCertificado;
        this.usuario = usuario;
        this.clave = clave;
    }

    //Propiedades
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the pathCertificado
     */
    public String getPathCertificado() {
        return pathCertificado;
    }

    /**
     * @param pathCertificado the pathCertificado to set
     */
    public void setPathCertificado(String pathCertificado) {
        this.pathCertificado = pathCertificado;
    }

    /**
     * @return the claveCertificado
     */
    public String getClaveCertificado() {
        return claveCertificado;
    }

    /**
     * @param claveCertificado the claveCertificado to set
     */
    public void setClaveCertificado(String claveCertificado) {
        this.claveCertificado = claveCertificado;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String generarSeguridad() {
        return tag("ns1:Security",
                tag("ns1:UsernameToken",
                        tag("ns1:Username", getUsuario())
                        + tag("ns1:Password", getClave()))
        );
    }
}
