/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.nucleo;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author omarv
 */
public class GeneradorWebServices {
    private Document xmlDoc = null;

    /**
     * Metodo para crear el objeto.
     *
     */
    public GeneradorWebServices() {
        super();
    }

    /**
     * Metodo para crear entrada Tag.
     *
     * @param nombreCampo
     * @param contenido
     * @return
     */
    public static String tag(String nombreCampo, String contenido) {
        if (contenido == null) {
            return "";
        }
        
        if (contenido.trim().length()==0) {
            return "";
        }

        return String.format("<%s>%s</%s>", nombreCampo, contenido, nombreCampo);
    }
    
    
    /**
     * Metodo para buscar los campos solicitados.
     *
     * @param tagName
     * @return
     *      
     */
    public String getTagValue(String tagName) {
        String respuesta = "";
        if (this.xmlDoc == null) {
            return respuesta;
        }

        xmlDoc.getDocumentElement().normalize();
        NodeList nodeList = xmlDoc.getElementsByTagName(tagName);

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node nNode = nodeList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;
                respuesta = eElement.getFirstChild().getNodeValue();
            }
        }
        return respuesta;
    }
    
    
    /**
     * @param xmlDoc the xmlDoc to set
     */
    public void setXmlDoc(Document xmlDoc) {
        this.xmlDoc = xmlDoc;
    }

}
