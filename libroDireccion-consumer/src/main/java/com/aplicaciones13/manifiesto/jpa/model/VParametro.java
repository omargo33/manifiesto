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
 * Objeto para trabajar con la entidad de v parametro.
 *
 * @author omargo33@hotmail.com
 *
 */
@Entity
@Table(name = "v_parametro")
public class VParametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_parametro")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParametro;

    @Column(name = "id_modulo")
    private Long idModulo;

    @Column(length = 32)
    private String indice;

    @Column(length = 8)
    private String clave;

    @Column(length = 128)
    private String nombre;

    @Column(length = 512)
    private String descripcion;

    @Column(name = "valor_texto_01", length = 256)
    private String valorTexto01;

    @Column(name = "valor_texto_02", length = 256)
    private String valorTexto02;

    @Column(name = "valor_numero_01")
    private Double valorNumero01;

    @Column(name = "valor_numero_02")
    private Double valorNumero02;

    @Column(name = "default_texto_01", length = 256)
    private String defaultTexto01;

    @Column(name = "default_texto_02", length = 256)
    private String defaultTexto02;

    @Column(name = "default_numero_01")
    private Double defaultNumero01;

    @Column(name = "default_numero_02")
    private Double defaultNumero02;

    @Column(name = "usuario", length = 128)
    private String usuario;

    @Column(name = "usuario_fecha", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date usuarioFecha;

    @Column(name = "usuario_programa", length = 256)
    private String usuarioPrograma;

    public Long getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Long idParametro) {
        this.idParametro = idParametro;
    }

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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorTexto01() {
        return valorTexto01;
    }

    public void setValorTexto01(String valorTexto01) {
        this.valorTexto01 = valorTexto01;
    }

    public String getValorTexto02() {
        return valorTexto02;
    }

    public void setValorTexto02(String valorTexto02) {
        this.valorTexto02 = valorTexto02;
    }

    public Double getValorNumero01() {
        return valorNumero01;
    }

    public void setValorNumero01(Double valorNumero01) {
        this.valorNumero01 = valorNumero01;
    }

    public Double getValorNumero02() {
        return valorNumero02;
    }

    public void setValorNumero02(Double valorNumero02) {
        this.valorNumero02 = valorNumero02;
    }

    public String getDefaultTexto01() {
        return defaultTexto01;
    }

    public void setDefaultTexto01(String defaultTexto01) {
        this.defaultTexto01 = defaultTexto01;
    }

    public String getDefaultTexto02() {
        return defaultTexto02;
    }

    public void setDefaultTexto02(String defaultTexto02) {
        this.defaultTexto02 = defaultTexto02;
    }

    public Double getDefaultNumero01() {
        return defaultNumero01;
    }

    public void setDefaultNumero01(Double defaultNumero01) {
        this.defaultNumero01 = defaultNumero01;
    }

    public Double getDefaultNumero02() {
        return defaultNumero02;
    }

    public void setDefaultNumero02(Double defaultNumero02) {
        this.defaultNumero02 = defaultNumero02;
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
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VParametro)) {
            return false;
        }
        VParametro other = (VParametro) object;
        return !((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parametro{idParametro=").append(idParametro);
        sb.append(", idModulo=").append(idModulo);
        sb.append(", indice=").append(indice);
        sb.append(", clave=").append(clave);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", valorTexto01=").append(valorTexto01);
        sb.append(", valorTexto02=").append(valorTexto02);
        sb.append(", valorNumero01=").append(valorNumero01);
        sb.append(", valorNumero02=").append(valorNumero02);
        sb.append(", defaultTexto01=").append(defaultTexto01);
        sb.append(", defaultTexto02=").append(defaultTexto02);
        sb.append(", defaultNumero01=").append(defaultNumero01);
        sb.append(", defaultNumero02=").append(defaultNumero02);
        sb.append(", usuario=").append(usuario);
        sb.append(", usuarioFecha=").append(usuarioFecha);
        sb.append(", usuarioPrograma=").append(usuarioPrograma);
        sb.append('}');
        return sb.toString();
    }

}
