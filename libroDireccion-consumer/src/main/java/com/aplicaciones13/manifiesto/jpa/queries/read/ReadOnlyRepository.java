/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.jpa.queries.read;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repositorio para hacer repositoris unicamente de busqueda.
 *
 * @author omargo33@hotmail.com
 */
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {
    Optional<T> findById(ID id);
    List<T> findAll();
}
