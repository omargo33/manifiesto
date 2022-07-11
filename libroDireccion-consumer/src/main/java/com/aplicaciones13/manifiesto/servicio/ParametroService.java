/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.servicio;

import com.aplicaciones13.manifiesto.jpa.model.VModulo;
import com.aplicaciones13.manifiesto.jpa.model.VParametro;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aplicaciones13.manifiesto.jpa.queries.VParametroRepositorio;
import com.aplicaciones13.manifiesto.jpa.queries.VModuloRepositorio;
import java.util.ArrayList;

/**
 * Servicio de parametro.
 *
 * @author omargo33@hotmail.com
 * 
 */
@Service
@Transactional
public class ParametroService {

    @Value("${aplicacion.id}")
    String idAplicacion;

    private final VParametroRepositorio vParametroRepositorio;
    private final VModuloRepositorio vModuloRepositorio;

    /**
     * Metodo para crear los repositorios.
     *
     * @param vParametroRepositorio
     * @param vModuloRepositorio
     */
    public ParametroService(VParametroRepositorio vParametroRepositorio, VModuloRepositorio vModuloRepositorio) {
        this.vParametroRepositorio = vParametroRepositorio;
        this.vModuloRepositorio = vModuloRepositorio;
    }

    /**
     * Parametros completos del modulo REST.
     *
     * @return
     */
    //@Cacheable(value = "parametrosCache")
    public List<VParametro> findParametros() {
        List<VParametro> listaVparametro = new ArrayList<>();
        VModulo modulo = vModuloRepositorio.findByIndice(idAplicacion);
        if (modulo != null) {
            listaVparametro = vParametroRepositorio.findByIdModulo(modulo.getIdModulo());
        }
        return listaVparametro;
    }

    /**
     * Parametro del modulo REST.
     *
     * @param indice
     * @return
     * 
     */
    //@Cacheable(value = "parametroCache", key = "#indice")
    public VParametro findParametro(String indice) {
        VParametro vParametro = new VParametro();        
        VModulo modulo = vModuloRepositorio.findByIndice(idAplicacion);
        if (modulo != null) {            
            VParametro vParametroTemp = vParametroRepositorio.findByIndiceAndIdModulo(indice, modulo.getIdModulo());
            if (vParametroTemp != null) {
                vParametro = vParametroTemp;
            }
        }

        return vParametro;
    }
}
