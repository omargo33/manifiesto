/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.libroDireccion.cliente.estructura;

/**
 *
 * @author omarv
 */
public class LibroDirecciones {

    private long idLibroDireccion;
    private long indice;
    private String indiceSecundario;
    private String identificacionFiscal;
    private String nombre;
    private String tipo;
    private String estado;
    private String usuario;
    private String usuarioFecha;
    private String usuarioPrograma;

    public LibroDirecciones() {
        idLibroDireccion = 0L;
        indice = 0L;
        indiceSecundario = "";
        identificacionFiscal = "";
        nombre = "";
        tipo = "";
        estado = "";
        usuario = "";
        usuarioFecha = "";
        usuarioPrograma = "";
    }

    /**
     * @return the idLibroDireccion
     */
    public long getIdLibroDireccion() {
        return idLibroDireccion;
    }

    /**
     * @param idLibroDireccion the idLibroDireccion to set
     */
    public void setIdLibroDireccion(long idLibroDireccion) {
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
    public String getUsuarioFecha() {
        return usuarioFecha;
    }

    /**
     * @param usuarioFecha the usuarioFecha to set
     */
    public void setUsuarioFecha(String usuarioFecha) {
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
        return "ddd{" + "idLibroDireccion=" + idLibroDireccion + ", indice=" + indice + ", indiceSecundario=" + indiceSecundario + ", identificacionFiscal=" + identificacionFiscal + ", nombre=" + nombre + ", tipo=" + tipo + ", estado=" + estado + ", usuario=" + usuario + ", usuarioFecha=" + usuarioFecha + ", usuarioPrograma=" + usuarioPrograma + '}';
    }

}
