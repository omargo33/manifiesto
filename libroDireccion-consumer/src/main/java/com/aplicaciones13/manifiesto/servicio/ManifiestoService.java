/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.servicio;

import com.aplicaciones13.manifiesto.jpa.model.Manifiesto;
import com.aplicaciones13.manifiesto.jpa.model.VManifiesto;
import com.aplicaciones13.manifiesto.jpa.queries.ManifiestoRepositorio;
import com.aplicaciones13.manifiesto.jpa.queries.VManifiestoRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio de manifiesto.
 *
 * @author omargo33@hotmail.com
 * 
 */
@Service
public class ManifiestoService {

    private final ManifiestoRepositorio manifiestoRepositorio;
    private final VManifiestoRepositorio vManifiestoRepositorio;

    /**
     * Metodo para creacion del objeto.
     *
     * @param manifiestoRepositorio
     * @param vManifiestoRepositorio
     */
    public ManifiestoService(
            ManifiestoRepositorio manifiestoRepositorio,
            VManifiestoRepositorio vManifiestoRepositorio) {
        this.manifiestoRepositorio = manifiestoRepositorio;
        this.vManifiestoRepositorio = vManifiestoRepositorio;
    }
    
    public List<VManifiesto> findAllVManifiesto() {
        return vManifiestoRepositorio.findAll();
    }

    public List<VManifiesto> findVManifiestoEstado(String estado) {
        return vManifiestoRepositorio.findByEstado(estado);
    }

    public Manifiesto updateEstado(Manifiesto manifiesto, String usuarioPrograma, String estado) {
        manifiesto.setUsuarioFecha(new Date());
        manifiesto.setUsuarioPrograma(usuarioPrograma);
        manifiesto.setEstado(estado);
        return manifiestoRepositorio.save(manifiesto);
    }
    

    public Manifiesto findManifiestoByIndice(Long idManifiesto) {
        return manifiestoRepositorio.findByIdManifiesto(idManifiesto);
    }
}
