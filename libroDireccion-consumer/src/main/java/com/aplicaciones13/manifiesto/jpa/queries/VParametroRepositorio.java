/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.jpa.queries;

import com.aplicaciones13.manifiesto.jpa.queries.read.ReadOnlyRepository;
import com.aplicaciones13.manifiesto.jpa.model.VParametro;
import java.util.List;


/**
 * Repositorio para buscar parametros repositorios.
 *
 * @author omargo33@hotmail.com
 */
public interface VParametroRepositorio extends ReadOnlyRepository<VParametro, Long> {
    List<VParametro> findByIdModulo(Long idModulo);
    VParametro findByIndiceAndIdModulo(String indice, Long idModulo);
}
