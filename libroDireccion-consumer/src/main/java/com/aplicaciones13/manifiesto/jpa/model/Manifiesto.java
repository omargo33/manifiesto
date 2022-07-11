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
 * Objeto para trabajar con la entidad de Manifiesto
 *
 * @author omargo33@hotmail.com
 *
 */
@Entity
@Table(name = "manifiesto")
public class Manifiesto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_manifiesto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManifiesto;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_libro_direccion_aerolinea")
    private Long idLibroDireccionAerolinea;

    @Column(name = "id_libro_direccion_aeropuerto")
    private Long idLibroDireccionAeropuerto;

    @Column(name = "id_libro_direccion_aeropuerto_des")
    private Long idLibroDireccionAeropuertoDes;

    @Column(name = "id_libro_direccion_aeronave")
    private Long idLibroDireccionAeronave;

    @Column(name = "fecha_local_operacion", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaLocalOperacion;

    @Column(name = "no_vuelo", length = 16)
    private String noVuelo;

    @Column(length = 128)
    private String usuario;

    @Column(name = "usuario_fecha", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date usuarioFecha;

    @Column(name = "usuario_programa", length = 256)
    private String usuarioPrograma;

    @Column(length = 8)
    private String tipo;

    private Long pasajeros;

    @Column(name = "pasajeros_transito")
    private Long pasajerosTransito;

    @Column(name = "pasajeros_exentos_tasas")
    private Long pasajerosExentosTasas;

    @Column(name = "pasajeros_pagan_dolares")
    private Long pasajerosPaganDolares;

    @Column(name = "pasajeros_exentos_timbres")
    private Long pasajerosExentosTimbres;

    @Column(name = "pasajeros_pagan_timbres_dolares")
    private Long pasajerosPaganTimbresDolares;

    @Column(name = "valor_pesos_tasas")
    private Double valorPesosTasas;

    @Column(name = "valor_pesos_timbres")
    private Double valorPesosTimbres;

    @Column(name = "indicador_comprobable")
    private String indicadorComprobable;

    @Column(length = 8)
    private String estado;

    /**
     * @return the idManifiesto
     */
    public Long getIdManifiesto() {
        return idManifiesto;
    }

    /**
     * @param idManifiesto the idManifiesto to set
     */
    public void setIdManifiesto(Long idManifiesto) {
        this.idManifiesto = (idManifiesto == null) ? 0L : idManifiesto;
    }

    /**
     * @return the idUsuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = (idUsuario == null) ? 0L : idUsuario; 
    }

    /**
     * @return the idLibroDireccionAerolinea
     */
    public Long getIdLibroDireccionAerolinea() {
        return idLibroDireccionAerolinea;
    }

    /**
     * @param idLibroDireccionAerolinea the idLibroDireccionAerolinea to set
     */
    public void setIdLibroDireccionAerolinea(Long idLibroDireccionAerolinea) {
        this.idLibroDireccionAerolinea = (idLibroDireccionAerolinea == null) ? 0L : idLibroDireccionAerolinea;  
    }

    /**
     * @return the idLibroDireccionAeropuerto
     */
    public Long getIdLibroDireccionAeropuerto() {
        return idLibroDireccionAeropuerto;
    }

    /**
     * @param idLibroDireccionAeropuerto the idLibroDireccionAeropuerto to set
     */
    public void setIdLibroDireccionAeropuerto(Long idLibroDireccionAeropuerto) {
        this.idLibroDireccionAeropuerto = (idLibroDireccionAeropuerto == null) ? 0L : idLibroDireccionAeropuerto;   
    }

    /**
     * @return the idLibroDireccionAeropuertoDes
     */
    public Long getIdLibroDireccionAeropuertoDes() {
        return idLibroDireccionAeropuertoDes;
    }

    /**
     * @param idLibroDireccionAeropuertoDes the idLibroDireccionAeropuertoDes to set
     */
    public void setIdLibroDireccionAeropuertoDes(Long idLibroDireccionAeropuertoDes) {
        this.idLibroDireccionAeropuertoDes = (idLibroDireccionAeropuertoDes == null) ? 0L : idLibroDireccionAeropuertoDes;    
    }

    /**
     * @return the idLibroDireccionAeronave
     */
    public Long getIdLibroDireccionAeronave() {
        return idLibroDireccionAeronave;
    }

    /**
     * @param idLibroDireccionAeronave the idLibroDireccionAeronave to set
     */
    public void setIdLibroDireccionAeronave(Long idLibroDireccionAeronave) {
        this.idLibroDireccionAeronave = (idLibroDireccionAeronave == null) ? 0L : idLibroDireccionAeronave;     
    }

    /**
     * @return the fechaLocalOperacion
     */
    public Date getFechaLocalOperacion() {
        return fechaLocalOperacion;
    }

    /**
     * @param fechaLocalOperacion the fechaLocalOperacion to set
     */
    public void setFechaLocalOperacion(Date fechaLocalOperacion) {
        this.fechaLocalOperacion = fechaLocalOperacion;
    }

    /**
     * @return the noVuelo
     */
    public String getNoVuelo() {
        return noVuelo;
    }

    /**
     * @param noVuelo the noVuelo to set
     */
    public void setNoVuelo(String noVuelo) {
        this.noVuelo = noVuelo;
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
     * @return the pasajeros
     */
    public Long getPasajeros() {
        return pasajeros;
    }

    /**
     * @param pasajeros the pasajeros to set
     */
    public void setPasajeros(Long pasajeros) {
        this.pasajeros = pasajeros;
    }

    /**
     * @return the pasajeros_transito
     */
    public Long getPasajerosTransito() {
        return pasajerosTransito;
    }

    /**
     * @param pasajerosTransito the pasajeros_transito to set
     */
    public void setPasajerosTransito(Long pasajerosTransito) {
        this.pasajerosTransito = pasajerosTransito;
    }

    /**
     * @return the pasajerosExentosTasas
     */
    public Long getPasajerosExentosTasas() {
        return pasajerosExentosTasas;
    }

    /**
     * @param pasajerosExentosTasas the pasajerosExentosTasas to set
     */
    public void setPasajerosExentosTasas(Long pasajerosExentosTasas) {
        this.pasajerosExentosTasas = ( pasajerosExentosTasas == null) ? 0L :  pasajerosExentosTasas;     
    }

    /**
     * @return the pasajerosPaganDolares
     */
    public Long getPasajerosPaganDolares() {
        return pasajerosPaganDolares;
    }

    /**
     * @param pasajerosPaganDolares the pasajerosPaganDolares to set
     */
    public void setPasajerosPaganDolares(Long pasajerosPaganDolares) {
        this.pasajerosPaganDolares =  (    pasajerosPaganDolares == null) ? 0L :     pasajerosPaganDolares;     
    }

    /**
     * @return the pasajerosExentosTimbres
     */
    public Long getPasajerosExentosTimbres() {
        return pasajerosExentosTimbres;
    }

    /**
     * @param pasajerosExentosTimbres the pasajerosExentosTimbres to set
     */
    public void setPasajerosExentosTimbres(Long pasajerosExentosTimbres) {
        this.pasajerosExentosTimbres = (     pasajerosExentosTimbres == null) ? 0L :      pasajerosExentosTimbres;     
    }

    /**
     * @return the pasajerosPaganTimbresDolares
     */
    public long getPasajerosPaganTimbresDolares() {
        return pasajerosPaganTimbresDolares;
    }

    /**
     * @param pasajerosPaganTimbresDolares the pasajerosPaganTimbresDolares to set
     */
    public void setPasajerosPaganTimbresDolares(Long pasajerosPaganTimbresDolares) {
        this.pasajerosPaganTimbresDolares =  (pasajerosPaganTimbresDolares == null) ? 0L :pasajerosPaganTimbresDolares;      
    }

    /**
     * @return the valorPesosTasas
     */
    public Double getValorPesosTasas() {
        return valorPesosTasas;
    }

    /**
     * @param valorPesosTasas the valorPesosTasas to set
     */
    public void setValorPesosTasas(Double valorPesosTasas) {
        this.valorPesosTasas = (valorPesosTasas == null) ? 0 :valorPesosTasas;      
    }

    /**
     * @return the valorPesosTimbres
     */
    public Double getValorPesosTimbres() {
        return valorPesosTimbres;
    }

    /**
     * @param valorPesosTimbres the valorPesosTimbres to set
     */
    public void setValorPesosTimbres(Double valorPesosTimbres) {
        this.valorPesosTimbres = (valorPesosTimbres == null) ? 0 :valorPesosTimbres;      
    }

    /**
     * @return the indicadorComprobable
     */
    public String getIndicadorComprobable() {
        return indicadorComprobable;
    }

    /**
     * @param indicadorComprobable the indicadorComprobable to set
     */
    public void setIndicadorComprobable(String indicadorComprobable) {
        this.indicadorComprobable = indicadorComprobable;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Manifiesto{idManifiesto=").append(idManifiesto);
        sb.append(", idUsuario=").append(idUsuario);
        sb.append(", idLibroDireccionAerolinea=").append(idLibroDireccionAerolinea);
        sb.append(", idLibroDireccionAeropuerto=").append(idLibroDireccionAeropuerto);
        sb.append(", idLibroDireccionAeropuertoDes=").append(idLibroDireccionAeropuertoDes);
        sb.append(", idLibroDireccionAeronave=").append(idLibroDireccionAeronave);
        sb.append(", fechaLocalOperacion=").append(fechaLocalOperacion);
        sb.append(", noVuelo=").append(noVuelo);
        sb.append(", usuario=").append(usuario);
        sb.append(", usuarioFecha=").append(usuarioFecha);
        sb.append(", usuarioPrograma=").append(usuarioPrograma);
        sb.append(", tipo=").append(tipo);
        sb.append(", pasajeros=").append(pasajeros);
        sb.append(", pasajerosTransito=").append(pasajerosTransito);
        sb.append(", pasajerosExentosTasas=").append(pasajerosExentosTasas);
        sb.append(", pasajerosPaganDolares=").append(pasajerosPaganDolares);
        sb.append(", pasajerosExentosTimbres=").append(pasajerosExentosTimbres);
        sb.append(", pasajerosPaganTimbresDolares=").append(pasajerosPaganTimbresDolares);
        sb.append(", valorPesosTasas=").append(valorPesosTasas);
        sb.append(", valorPesosTimbres=").append(valorPesosTimbres);
        sb.append(", indicadorComprobable=").append(indicadorComprobable);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }    
}
