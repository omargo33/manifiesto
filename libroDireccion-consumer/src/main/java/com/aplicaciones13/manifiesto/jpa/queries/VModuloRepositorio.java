/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.jpa.queries;

import com.aplicaciones13.manifiesto.jpa.model.VModulo;
import com.aplicaciones13.manifiesto.jpa.queries.read.ReadOnlyRepository;

/**
 * Repositorio para buscar los modulos.
 *
 * @author omargo33@hotmail.com
 */
public interface VModuloRepositorio extends ReadOnlyRepository<VModulo, Long> {    
    VModulo findByIndice(String indice);
}
