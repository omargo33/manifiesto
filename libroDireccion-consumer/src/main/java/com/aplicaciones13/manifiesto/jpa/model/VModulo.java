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
 * Objeto para trabajar con la entidad de v modulo.
 *
 * @author omargo33@hotmail.com
 *
 */
@Entity
@Table(name = "v_modulo")
public class VModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idModulo;

    @Column(length = 32)
    private String indice;

    @Column(length = 128)
    private String nombre;

    @Column(length = 128)
    private String contexto;

    @Column(length = 8)
    private String estado;

    @Column(name = "usuario", length = 128)
    private String usuario;

    @Column(name = "usuario_fecha", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date usuarioFecha;

    @Column(name = "usuario_programa", length = 256)
    private String usuarioPrograma;

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContexto() {
        return contexto;
    }

    public void setContexto(String contexto) {
        this.contexto = contexto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getUsuarioFecha() {
        return usuarioFecha;
    }

    public void setUsuarioFecha(Date usuarioFecha) {
        this.usuarioFecha = usuarioFecha;
    }

    public String getUsuarioPrograma() {
        return usuarioPrograma;
    }

    public void setUsuarioPrograma(String usuarioPrograma) {
        this.usuarioPrograma = usuarioPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulo != null ? idModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VModulo)) {
            return false;
        }
        VModulo other = (VModulo) object;
        return !((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Modulo{idModulo=").append(idModulo);
        sb.append(", indice=").append(indice);
        sb.append(", nombre=").append(nombre);
        sb.append(", contexto=").append(contexto);
        sb.append(", estado=").append(estado);
        sb.append(", usuario=").append(usuario);
        sb.append(", usuarioFecha=").append(usuarioFecha);
        sb.append(", usuarioPrograma=").append(usuarioPrograma);
        sb.append('}');
        return sb.toString();
    }

}
