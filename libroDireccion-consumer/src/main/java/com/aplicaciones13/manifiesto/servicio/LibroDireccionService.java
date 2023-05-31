package com.aplicaciones13.manifiesto.servicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aplicaciones13.manifiesto.jpa.queries.LibroDireccionRepositorio;
import com.aplicaciones13.manifiesto.jpa.model.LibroDireccion;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio de libro de direccion.
 *
 * @author omargo33@hotmail.com
 * 
 */
@Service
@Transactional
public class LibroDireccionService {

    private final LibroDireccionRepositorio libroDireccionRepositorio;

    public LibroDireccionService(LibroDireccionRepositorio libroDireccionRepositorio) {
        this.libroDireccionRepositorio = libroDireccionRepositorio;
    }

    /**
     * Metodo para hacer un guardado personalizado.
     *
     * @param libroDireccion
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public LibroDireccion saveLibroDirecciones(LibroDireccion libroDireccion, String usuario, String usuarioPrograma) {
        libroDireccion.setUsuario(usuario);
        libroDireccion.setUsuarioFecha(new Date());
        libroDireccion.setUsuarioPrograma(usuarioPrograma);
        return libroDireccionRepositorio.save(libroDireccion);
    }

    public List<LibroDireccion> findAllLibroDireccion() {
        return libroDireccionRepositorio.findAll();
    }

    public List<LibroDireccion> findLibroDireccionByIndice(Long id) {
        return libroDireccionRepositorio.findByIndice(id);
    }
}
