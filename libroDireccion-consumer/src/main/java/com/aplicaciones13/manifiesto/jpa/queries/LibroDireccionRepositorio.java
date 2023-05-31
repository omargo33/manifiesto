package com.aplicaciones13.manifiesto.jpa.queries;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.aplicaciones13.manifiesto.jpa.model.LibroDireccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaces para busqueda libro direcciones.
 *
 * @author omargo33@hotmail.com
 * 
 */
@Repository
public interface LibroDireccionRepositorio extends JpaRepository<LibroDireccion, Long> {
    List<LibroDireccion> findByIndice(Long id);    
}
