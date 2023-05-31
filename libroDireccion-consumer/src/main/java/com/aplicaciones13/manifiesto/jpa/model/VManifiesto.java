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
 * Objeto para trabajar con la entidad de v manifiesto.
 *
 * @author omargo33@hotmail.com
 *
 */
@Entity
@Table(name = "v_manifiesto")
public class VManifiesto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_manifiesto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManifiesto;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(length = 128)
    private String nick;

    @Column(name = "nombre_usuario", length = 258)
    private String nombreUsuario;

    @Column(name = "id_libro_direccion_aerolinea")
    private Long idLibroDireccionAerolinea;

    @Column(name = "indice_aerolinea", length = 32)
    private String indiceAerolinea;

    @Column(name = "nombre_aerolinea", length = 128)
    private String nombreAerolinea;

    @Column(name = "id_libro_direccion_aeropuerto")
    private Long idLibroDireccionAeropuerto;

    @Column(name = "indice_aeropuerto", length = 32)
    private String indiceAeropuerto;

    @Column(name = "nombre_aeropuerto", length = 128)
    private String nombreAeropuerto;

    @Column(name = "id_libro_direccion_aeropuerto_des")
    private Long idLibroDireccionAeropuertoDes;

    @Column(name = "indice_destino", length = 32)
    private String indiceDestino;

    @Column(name = "nombre_destino", length = 128)
    private String nombreDestino;

    @Column(name = "id_libro_direccion_aeronave")
    private Long idLibroDireccionAeronave;

    @Column(name = "indice_aeronave", length = 32)
    private String indiceAeronave;

    @Column(name = "nombre_aeronave", length = 128)
    private String nombreAeronave;

    @Column(name = "fecha_local_operacion", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaLocalOperacion;

    @Column(name = "fecha_corta_local_operacion", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCortaLocalOperacion;

    @Column(name = "anio_fecha_operacion")
    private Long anioFechaOperacion;

    @Column(name = "mes_fecha_operacion")
    private Long mesFechaOperacion;

    @Column(name = "no_vuelo", length = 16)
    private String noVuelo;

    @Column(name = "pasajeros")
    private Long pasajeros;

    @Column(name = "pasajeros_transito")
    private Long pasajerosTransito;

    @Column(name = "pasajeros_locales")
    private Long pasajerosLocales;

    @Column(name = "pasajeros_exentos_tasas")
    private Long pasajerosExentosTasas;

    @Column(name = "pasajeros_pagan_tasas")
    private Long pasajerosPaganTasas;

    @Column(name = "pasajeros_pagan_dolares")
    private Long pasajerosPaganDolares;

    @Column(name = "pasajeros_pagan_pesos")
    private Long pasajerosPaganPesos;

    @Column(name = "pasajeros_exentos_timbres")
    private Long pasajerosExentosTimbres;

    @Column(name = "pasajeros_pagan_timbres")
    private Long pasajerosPaganTimbres;

    @Column(name = "pasajeros_pagan_timbres_dolares")
    private Long pasajerosPaganTimbresDolares;

    @Column(name = "pasajeros_pagan_timbres_pesos")
    private Long pasajerosPaganTimbresPesos;

    @Column(name = "tasa")
    private Double tasa;

    @Column(name = "timbre")
    private Double timbre;

    @Column(name = "timbre_total")
    private Double timbreTotal;

    @Column(name = "indicador_comprobable")
    private String indicadorComprobable;

    @Column(name = "tipo", length = 8)
    private String tipo;

    @Column(name = "estado", length = 8)
    private String estado;

    @Column(name = "usuario", length = 128)
    private String usuario;

    @Column(name = "usuario_fecha", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date usuarioFecha;

    @Column(name = "usuario_programa", length = 256)
    private String usuarioPrograma;

    /**
     * @return the idManifiesto
     */
    public Long getIdManifiesto() {
        return (idManifiesto == null) ? 0L : idManifiesto;
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
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
     * @return the indiceAerolinea
     */
    public String getIndiceAerolinea() {
        return indiceAerolinea;
    }

    /**
     * @param indiceAerolinea the indiceAerolinea to set
     */
    public void setIndiceAerolinea(String indiceAerolinea) {
        this.indiceAerolinea = indiceAerolinea;
    }

    /**
     * @return the nombreAerolinea
     */
    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    /**
     * @param nombreAerolinea the nombreAerolinea to set
     */
    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
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
     * @return the indiceAeropuerto
     */
    public String getIndiceAeropuerto() {
        return indiceAeropuerto;
    }

    /**
     * @param indiceAeropuerto the indiceAeropuerto to set
     */
    public void setIndiceAeropuerto(String indiceAeropuerto) {
        this.indiceAeropuerto = indiceAeropuerto;
    }

    /**
     * @return the nombreAeropuerto
     */
    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    /**
     * @param nombreAeropuerto the nombreAeropuerto to set
     */
    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    /**
     * @return the idLibroDireccionAeropuertoDes
     */
    public Long getIdLibroDireccionAeropuertoDes() {
        return idLibroDireccionAeropuertoDes;
    }

    /**
     * @param idLibroDireccionAeropuertoDes the idLibroDireccionAeropuertoDes to
     * set
     */
    public void setIdLibroDireccionAeropuertoDes(Long idLibroDireccionAeropuertoDes) {
        this.idLibroDireccionAeropuertoDes = (idLibroDireccionAeropuertoDes == null) ? 0L : idLibroDireccionAeropuertoDes;
    }

    /**
     * @return the indiceDestino
     */
    public String getIndiceDestino() {
        return indiceDestino;
    }

    /**
     * @param indiceDestino the indiceDestino to set
     */
    public void setIndiceDestino(String indiceDestino) {
        this.indiceDestino = indiceDestino;
    }

    /**
     * @return the nombreDestino
     */
    public String getNombreDestino() {
        return nombreDestino;
    }

    /**
     * @param nombreDestino the nombreDestino to set
     */
    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
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
     * @return the indiceAeronave
     */
    public String getIndiceAeronave() {
        return indiceAeronave;
    }

    /**
     * @param indiceAeronave the indiceAeronave to set
     */
    public void setIndiceAeronave(String indiceAeronave) {
        this.indiceAeronave = indiceAeronave;
    }

    /**
     * @return the nombreAeronave
     */
    public String getNombreAeronave() {
        return nombreAeronave;
    }

    /**
     * @param nombreAeronave the nombreAeronave to set
     */
    public void setNombreAeronave(String nombreAeronave) {
        this.nombreAeronave = nombreAeronave;
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
     * @return the fechaCortaLocalOperacion
     */
    public Date getFechaCortaLocalOperacion() {
        return fechaCortaLocalOperacion;
    }

    /**
     * @param fechaCortaLocalOperacion the fechaCortaLocalOperacion to set
     */
    public void setFechaCortaLocalOperacion(Date fechaCortaLocalOperacion) {
        this.fechaCortaLocalOperacion = fechaCortaLocalOperacion;
    }

    /**
     * @return the anioFechaOperacion
     */
    public Long getAnioFechaOperacion() {
        return anioFechaOperacion;
    }

    /**
     * @param anioFechaOperacion the anioFechaOperacion to set
     */
    public void setAnioFechaOperacion(Long anioFechaOperacion) {
        this.anioFechaOperacion = (anioFechaOperacion == null) ? 0L : anioFechaOperacion;
    }

    /**
     * @return the mesFechaOperacion
     */
    public Long getMesFechaOperacion() {
        return mesFechaOperacion;
    }

    /**
     * @param mesFechaOperacion the mesFechaOperacion to set
     */
    public void setMesFechaOperacion(Long mesFechaOperacion) {
        this.mesFechaOperacion = (mesFechaOperacion == null) ? 0L : mesFechaOperacion;
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
     * @return the pasajeros
     */
    public Long getPasajeros() {
        return (pasajeros == null) ? 0L : this.pasajeros;
    }

    /**
     * @param pasajeros the pasajeros to set
     */
    public void setPasajeros(Long pasajeros) {
        this.pasajeros = (pasajeros == null) ? 0L : pasajeros;
    }

    /**
     * @return the pasajeros_transito
     */
    public Long getPasajerosTransito() {
        return (pasajerosTransito == null) ? 0L : this.pasajerosTransito;
    }

    /**
     * @param pasajerosTransito the pasajerosTransito to set
     */
    public void setPasajerosTransito(Long pasajerosTransito) {
        this.pasajerosTransito = (pasajerosTransito == null) ? 0L : pasajerosTransito;
    }

    /**
     * @return the pasajeros_locales
     */
    public Long getPasajerosLocales() {
        return (pasajerosLocales == null) ? 0L : pasajerosLocales;
    }

    /**
     * @param pasajerosLocales the pasajerosLocales to set
     */
    public void setPasajerosLocales(Long pasajerosLocales) {
        this.pasajerosLocales = (pasajerosLocales == null) ? 0L : pasajerosLocales;
    }

    /**
     * @return the pasajerosExentosTasas
     */
    public Long getPasajerosExentosTasas() {
        return (pasajerosExentosTasas == null) ? 0L : pasajerosExentosTasas;
    }

    /**
     * @param pasajerosExentosTasas the pasajerosExentosTasas to set
     */
    public void setPasajerosExentosTasas(Long pasajerosExentosTasas) {
        this.pasajerosExentosTasas = (pasajerosExentosTasas == null) ? 0L : pasajerosExentosTasas;
    }

    /**
     * @return the pasajerosPaganTasas
     */
    public Long getPasajerosPaganTasas() {
        return (pasajerosPaganTasas == null) ? 0L : pasajerosPaganTasas;
    }

    /**
     * @param pasajerosPaganTasas the pasajerosPaganTasas to set
     */
    public void setPasajerosPaganTasas(Long pasajerosPaganTasas) {
        this.pasajerosPaganTasas = (pasajerosPaganTasas == null) ? 0L : pasajerosPaganTasas;
    }

    /**
     * @return the pasajerosPaganDolares
     */
    public Long getPasajerosPaganDolares() {
        return (pasajerosPaganDolares == null) ? 0L : pasajerosPaganDolares;
    }

    /**
     * @param pasajerosPaganDolares the pasajerosPaganDolares to set
     */
    public void setPasajerosPaganDolares(Long pasajerosPaganDolares) {
        this.pasajerosPaganDolares = (pasajerosPaganDolares == null) ? 0L : pasajerosPaganDolares;
    }

    /**
     * @return the pasajerosPaganPesos
     */
    public Long getPasajerosPaganPesos() {
        return (pasajerosPaganPesos == null) ? 0L : pasajerosPaganPesos;
    }

    /**
     * @param pasajerosPaganPesos the pasajerosPaganPesos to set
     */
    public void setPasajerosPaganPesos(Long pasajerosPaganPesos) {
        this.pasajerosPaganPesos = (pasajerosPaganPesos == null) ? 0L : pasajerosPaganPesos;
    }

    /**
     * @return the pasajerosExentosTimbres
     */
    public Long getPasajerosExentosTimbres() {
        return (pasajerosExentosTimbres == null) ? 0L : pasajerosExentosTimbres;
    }

    /**
     * @param pasajerosExentosTimbres the pasajerosExentosTimbres to set
     */
    public void setPasajerosExentosTimbres(Long pasajerosExentosTimbres) {
        this.pasajerosExentosTimbres = (pasajerosExentosTimbres == null) ? 0L : pasajerosExentosTimbres;
    }

    /**
     * @return the pasajerosPaganTimbres
     */
    public Long getPasajerosPaganTimbres() {
        return (pasajerosPaganTimbres == null) ? 0L : pasajerosPaganTimbres;
    }

    /**
     * @param pasajerosPaganTimbres the pasajerosPaganTimbres to set
     */
    public void setPasajerosPaganTimbres(Long pasajerosPaganTimbres) {
        this.pasajerosPaganTimbres = (pasajerosPaganTimbres == null) ? 0L : pasajerosPaganTimbres;
    }

    /**
     * @return the pasajerosPaganTimbresDolares
     */
    public Long getPasajerosPaganTimbresDolares() {
        return (pasajerosPaganTimbresDolares == null) ? 0l : pasajerosPaganTimbresDolares;
    }

    /**
     * @param pasajerosPaganTimbresDolares the pasajerosPaganTimbresDolares to
     * set
     */
    public void setPasajerosPaganTimbresDolares(Long pasajerosPaganTimbresDolares) {
        this.pasajerosPaganTimbresDolares = (pasajerosPaganTimbresDolares == null) ? 0L : pasajerosPaganTimbresDolares;
    }

    /**
     * @return the pasajerosPaganTimbresPesos
     */
    public Long getPasajerosPaganTimbresPesos() {
        return (pasajerosPaganTimbresPesos == null) ? 0L : pasajerosPaganTimbresPesos;
    }

    /**
     * @param pasajerosPaganTimbresPesos the pasajerosPaganTimbresPesos to set
     */
    public void setPasajerosPaganTimbresPesos(Long pasajerosPaganTimbresPesos) {
        this.pasajerosPaganTimbresPesos = (pasajerosPaganTimbresPesos == null) ? 0L : pasajerosPaganTimbresPesos;
    }

    /**
     * @return the tasa
     */
    public Double getTasa() {
        return tasa;
    }

    /**
     * @param tasa the tasa to set
     */
    public void setTasa(Double tasa) {
        this.tasa = (tasa == null) ? 0L : tasa;
    }

    /**
     * @return the timbre
     */
    public Double getTimbre() {
        return timbre;
    }

    /**
     * @param timbre the timbre to set
     */
    public void setTimbre(Double timbre) {
        this.timbre = (timbre == null) ? 0 : timbre;
    }

    /**
     * @return the timbreTotal
     */
    public Double getTimbreTotal() {
        return (timbreTotal == null) ? 0 : timbreTotal;
    }

    /**
     * @param timbreTotal the timbreTotal to set
     */
    public void setTimbreTotal(Double timbreTotal) {
        this.timbreTotal = (timbreTotal == null) ? 0 : timbreTotal;
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
        sb.append("VManifiesto{idManifiesto=").append(idManifiesto);
        sb.append(", idUsuario=").append(idUsuario);
        sb.append(", nick=").append(nick);
        sb.append(", nombreUsuario=").append(nombreUsuario);
        sb.append(", idLibroDireccionAerolinea=").append(idLibroDireccionAerolinea);
        sb.append(", indiceAerolinea=").append(indiceAerolinea);
        sb.append(", nombreAerolinea=").append(nombreAerolinea);
        sb.append(", idLibroDireccionAeropuerto=").append(idLibroDireccionAeropuerto);
        sb.append(", indiceAeropuerto=").append(indiceAeropuerto);
        sb.append(", nombreAeropuerto=").append(nombreAeropuerto);
        sb.append(", idLibroDireccionAeropuertoDes=").append(idLibroDireccionAeropuertoDes);
        sb.append(", indiceDestino=").append(indiceDestino);
        sb.append(", nombreDestino=").append(nombreDestino);
        sb.append(", idLibroDireccionAeronave=").append(idLibroDireccionAeronave);
        sb.append(", indiceAeronave=").append(indiceAeronave);
        sb.append(", nombreAeronave=").append(nombreAeronave);
        sb.append(", fechaLocalOperacion=").append(fechaLocalOperacion);
        sb.append(", fechaCortaLocalOperacion=").append(fechaCortaLocalOperacion);
        sb.append(", anioFechaOperacion=").append(anioFechaOperacion);
        sb.append(", mesFechaOperacion=").append(mesFechaOperacion);
        sb.append(", noVuelo=").append(noVuelo);
        sb.append(", pasajeros=").append(pasajeros);
        sb.append(", pasajerosTransito=").append(pasajerosTransito);
        sb.append(", pasajerosLocales=").append(pasajerosLocales);
        sb.append(", pasajerosExentosTasas=").append(pasajerosExentosTasas);
        sb.append(", pasajerosPaganTasas=").append(pasajerosPaganTasas);
        sb.append(", pasajerosPaganDolares=").append(pasajerosPaganDolares);
        sb.append(", pasajerosPaganPesos=").append(pasajerosPaganPesos);
        sb.append(", pasajerosExentosTimbres=").append(pasajerosExentosTimbres);
        sb.append(", pasajerosPaganTimbres=").append(pasajerosPaganTimbres);
        sb.append(", pasajerosPaganTimbresDolares=").append(pasajerosPaganTimbresDolares);
        sb.append(", pasajerosPaganTimbresPesos=").append(pasajerosPaganTimbresPesos);
        sb.append(", tasa=").append(tasa);
        sb.append(", timbre=").append(timbre);
        sb.append(", timbreTotal=").append(timbreTotal);
        sb.append(", indicadorComprobable=").append(indicadorComprobable);
        sb.append(", tipo=").append(tipo);
        sb.append(", estado=").append(estado);
        sb.append(", usuario=").append(usuario);
        sb.append(", usuarioFecha=").append(usuarioFecha);
        sb.append(", usuarioPrograma=").append(usuarioPrograma);
        sb.append('}');
        return sb.toString();
    }

}
