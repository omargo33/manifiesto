package com.aplicaciones13.manifiesto.http.request;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.aplicaciones13.manifiesto.servicio.LibroDireccionService;
import com.aplicaciones13.manifiesto.jpa.model.LibroDireccion;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Objeto para dar soporte a servicio REST.
 *
 * @author omargo33@hotmail.com
 */
@RestController
@RequestMapping(value = "/libroDireccion")
public class LibroDireccionControlador {
    
    @Autowired
    LibroDireccionService libroDireccionService;
    
    @Value("${aplicacion.nombre}")
    String nombreAplicacion;
    
    /**
     * Libro Direccion por indice.
     * 
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public List<LibroDireccion> getLibroDireccion(@PathVariable Long id) {
        return libroDireccionService.findLibroDireccionByIndice(id);
    }

    /**
     * Libro direccion completa
     * 
     * @return 
     */    
    @GetMapping("/")
    public List<LibroDireccion> getAllLibroDireccion() {
        return libroDireccionService.findAllLibroDireccion();
    }

    /**
     * Crea entrada al libro de direccion.
     * 
     * @param libroDireccion
     * @return 
     */
    @PostMapping("/")
    public ResponseEntity<LibroDireccion> createLibroDireccion(@RequestBody LibroDireccion libroDireccion) {
        try {
            LibroDireccion libroDireccionRespuesta = libroDireccionService.saveLibroDirecciones(libroDireccion,"none",nombreAplicacion);
            return new ResponseEntity<>(libroDireccionRespuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }    

    /**
     * Actualizacion una entrada al Libro de direccion 
     * 
     * @param libroDireccion
     * @param id
     * @return 
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLibroDireccion(@RequestBody LibroDireccion libroDireccion, @PathVariable Long id) {
        try {
            List<LibroDireccion> existUser = libroDireccionService.findLibroDireccionByIndice(id);
            existUser.get(0).setIdLibroDireccionTemporal(id);
            libroDireccionService.saveLibroDirecciones(existUser.get(0),"none",nombreAplicacion);
            return new ResponseEntity(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
