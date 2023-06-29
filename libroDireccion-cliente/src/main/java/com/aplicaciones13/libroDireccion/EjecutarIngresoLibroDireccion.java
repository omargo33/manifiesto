/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.libroDireccion;

import com.aplicaciones13.libroDireccion.cliente.Consumo;
import com.aplicaciones13.libroDireccion.cliente.estructura.LibroDirecciones;

/**
 *
 * @author omarv
 */
public class EjecutarIngresoLibroDireccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean respuesta = false;
        long indice = 200;
        Consumo consumo = new Consumo();
        LibroDirecciones libroDirecciones = new LibroDirecciones();
        libroDirecciones.setIndice(indice);
        libroDirecciones.setIndiceSecundario("DAJDA-11");
        libroDirecciones.setIdentificacionFiscal("skldfjsalk");
        libroDirecciones.setNombre("Hola fabrici");
        libroDirecciones.setTipo("A");
        libroDirecciones.setEstado("A");
        consumo.setLibroDirecciones(libroDirecciones);

        respuesta = consumo.load(null, null, null, null, "http://3.139.25.45:8080/manifiesto-0.0.1/", null, null, 15000);

        if (respuesta) {
            System.out.println(consumo.getLibroDireccionesRespuesta().toString());
        } else {
            System.out.println(consumo.getErrorRespuesta());
        }

    }
}
