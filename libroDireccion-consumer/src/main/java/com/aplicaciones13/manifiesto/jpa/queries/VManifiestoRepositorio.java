/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.jpa.queries;

import com.aplicaciones13.manifiesto.jpa.model.VManifiesto;
import com.aplicaciones13.manifiesto.jpa.queries.read.ReadOnlyRepository;
import java.util.List;

/**
 * Interfaces para cambio de busqueda desde la vista de manifiesto.
 *
 * @author omargo33@hotmail.com
 * 
 */
public interface VManifiestoRepositorio extends ReadOnlyRepository<VManifiesto, Long> {
    List<VManifiesto> findByEstado(String estado);
}
