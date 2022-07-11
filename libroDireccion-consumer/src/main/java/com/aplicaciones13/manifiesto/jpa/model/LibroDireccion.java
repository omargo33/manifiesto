/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.jpa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Objeto para trabajar con la entidad de libro de direcciones de intercambio.
 *
 * @author omargo33@hotmail.com
 * 
 */
@Entity
@Table(name = "libro_direccion_intercambio")
public class LibroDireccion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_libro_direccion_intercambio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibroDireccion;
    private long indice;
    @Column(name = "indice_secundario", length = 32)
    private String indiceSecundario;
    @Column(name = "identificacion_fiscal", length = 32)
    private String identificacionFiscal;
    @Column(length = 128)
    private String nombre;
    @Column(length = 8)
    private String tipo;
    @Column(length = 8)
    private String estado;
    @Column(length = 128)
    private String usuario;
    @Column(name = "usuario_fecha", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date usuarioFecha;
    @Column(name = "usuario_programa", length = 128)
    private String usuarioPrograma;

    /**
     * @return the idLibroDireccion
     */
    public Long getIdLibroDireccion() {
        return idLibroDireccion;
    }

    /**
     * @param idLibroDireccion the idLibroDireccion to set
     */
    public void setIdLibroDireccionTemporal(Long idLibroDireccion) {
        this.idLibroDireccion = idLibroDireccion;
    }

    /**
     * @return the indice
     */
    public long getIndice() {
        return indice;
    }

    /**
     * @param indice the indice to set
     */
    public void setIndice(long indice) {
        this.indice = indice;
    }

    /**
     * @return the indiceSecundario
     */
    public String getIndiceSecundario() {
        return indiceSecundario;
    }

    /**
     * @param indiceSecundario the indiceSecundario to set
     */
    public void setIndiceSecundario(String indiceSecundario) {
        this.indiceSecundario = indiceSecundario;
    }

    /**
     * @return the identificacionFiscal
     */
    public String getIdentificacionFiscal() {
        return identificacionFiscal;
    }

    /**
     * @param identificacionFiscal the identificacionFiscal to set
     */
    public void setIdentificacionFiscal(String identificacionFiscal) {
        this.identificacionFiscal = identificacionFiscal;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioFecha
     */
    public Date getUsuarioFecha() {
        return usuarioFecha;
    }

    /**
     * @param usuarioFecha the usuarioFecha to set
     */
    public void setUsuarioFecha(Date usuarioFecha) {
        this.usuarioFecha = usuarioFecha;
    }

    /**
     * @return the usuarioPrograma
     */
    public String getUsuarioPrograma() {
        return usuarioPrograma;
    }

    /**
     * @param usuarioPrograma the usuarioPrograma to set
     */
    public void setUsuarioPrograma(String usuarioPrograma) {
        this.usuarioPrograma = usuarioPrograma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LibroDireccion{idLibroDireccion=").append(idLibroDireccion);
        sb.append(", indice=").append(indice);
        sb.append(", indiceSecundario=").append(indiceSecundario);
        sb.append(", identificacionFiscal=").append(identificacionFiscal);
        sb.append(", nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        sb.append(", estado=").append(estado);
        sb.append(", usuario=").append(usuario);
        sb.append(", usuarioFecha=").append(usuarioFecha);
        sb.append(", usuarioPrograma=").append(usuarioPrograma);
        sb.append('}');
        return sb.toString();
    }
}
