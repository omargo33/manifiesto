/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.jpa.queries;


import com.aplicaciones13.manifiesto.jpa.model.Manifiesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaces para cambio de manifiesto.
 *
 * @author omargo33@hotmail.com
 * 
 */
@Repository
public interface ManifiestoRepositorio extends JpaRepository<Manifiesto, Long> {
    Manifiesto findByIdManifiesto(Long idManifiesto);
}
