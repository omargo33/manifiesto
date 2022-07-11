/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.tasasTimbres;

import com.aplicaciones13.nucleo.GeneradorWebServices;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Clase con la informacion del cuerpo a ser enviado.
 *
 * @author omargo33@hotmail.com
 */
public class Cuerpo extends GeneradorWebServices {

    private String activeOperationYN = "";
    private String aeropuertoBasedeOperacion = "";
    private String aeropuertoOrigenDestino = "";
    private BigDecimal amountExtendedPrice = new BigDecimal(0);
    private BigDecimal amountPriceperUnit = new BigDecimal(0);
    private Date dateThru = new Date();
    private Date fechaOperacionUTC = new Date();
    private Integer fiscalYear = 0;
    private Date fromDate = new Date();
    private String indicadorCobrableSN = "";
    private BigDecimal lineNumber = new BigDecimal(0);
    private String matriculaDeLaAeronave = "";
    private Integer month = 0;
    private Integer numberOfWeeksYear = 0;
    private Integer numeroDeVuelo = 0;
    private String originatorNumber = "";
    private Integer pasajerosEmbarcados = 0;
    private Integer pasajerosTasasEnDolares = 0;
    private Integer pasajerosTasasEnPesos = 0;
    private Integer pasajerosTimbreEnPesos = 0;
    private Integer pasajerosTimbresEnDolares = 0;
    private Integer pasajerosEnTransito = 0;
    private Integer pasajerosExentosDeTasas = 0;
    private Integer pasajerosExentosDeTimbre = 0;
    private String priceAdjustmentName = "";
    private String siglaDeLaAerolinea = "";
    private String tipodeVuelo = "";

    private String fechaOperacion = "";
    private String fechaDesde = "";
    private String fechaHasta = "";

    /**
     * Metodo para construir objeto
     *
     */
    public Cuerpo() {
        super();
    }

    /**
     * Metodo para generar un cuerpo XML de envio.
     *
     * @return
     */
    public String generarCuerpo() {
        return tag("ns2:InteraccionRegistroPortal",
                tag("activeOperationYN", activeOperationYN)
                + tag("aeropuertoBasedeOperacion", aeropuertoBasedeOperacion)
                + tag("aeropuertoOrigenDestino", aeropuertoOrigenDestino)
                + tag("amountExtendedPrice", amountExtendedPrice.toString())
                + tag("amountPriceperUnit", amountPriceperUnit.toString())
                + tag("dateThru", convertirDateToString(dateThru))
                + tag("fechaOperacionUTC", convertirDateToString(fechaOperacionUTC))
                + tag("fiscalYear", fiscalYear.toString())
                + tag("fromDate", convertirDateToString(fromDate))
                + tag("indicadorCobrableSN", indicadorCobrableSN)
                + tag("lineNumber", lineNumber.toString())
                + tag("matriculadelaaeronave", matriculaDeLaAeronave)
                + tag("month", month.toString())
                + tag("numberofWeeksYear", numberOfWeeksYear.toString())
                + tag("numerodevuelo", numeroDeVuelo.toString())
                + tag("originatorNumber", originatorNumber)
                + tag("pasajerosEmbarcados", pasajerosEmbarcados.toString())
                + tag("pasajerosTasasenDolares", pasajerosTasasEnDolares.toString())
                + tag("pasajerosTasasenpesos", pasajerosTasasEnPesos.toString())
                + tag("pasajerosTimbreenPesos", pasajerosTimbreEnPesos.toString())
                + tag("pasajerosTimbresenDolares", pasajerosTimbresEnDolares.toString())
                + tag("pasajerosenTransito", pasajerosEnTransito.toString())
                + tag("pasajerosexcentosdetasas", pasajerosExentosDeTasas.toString())
                + tag("pasajerosexentosdetimbre", pasajerosExentosDeTimbre.toString())
                + tag("priceAdjustmentName", priceAdjustmentName)
                + tag("sigladelaAerolinea", siglaDeLaAerolinea)
                + tag("tipodeVuelo", tipodeVuelo)
                + tag("alphaSpecData15", fechaOperacion)
                + tag("alphaSpecData16", fechaDesde)
                + tag("alphaSpecData17", fechaHasta)
        );
    }

    /**
     * Metodo para converir una fecha en un XML fecha para String.
     *
     * @param date
     * @return
     */
    private String convertirDateToString(java.util.Date date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        String respuesta = "";
        try {
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            respuesta = xmlDate.toString();
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(Cuerpo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    /**
     * @param activeOperationYN the activeOperationYN to set
     */
    public void setActiveOperationYN(String activeOperationYN) {
        this.activeOperationYN = activeOperationYN;
    }

    /**
     * @param aeropuertoBasedeOperacion the aeropuertoBasedeOperacion to set
     */
    public void setAeropuertoBasedeOperacion(String aeropuertoBasedeOperacion) {
        this.aeropuertoBasedeOperacion = aeropuertoBasedeOperacion;
    }

    /**
     * @param aeropuertoOrigenDestino the aeropuertoOrigenDestino to set
     */
    public void setAeropuertoOrigenDestino(String aeropuertoOrigenDestino) {
        this.aeropuertoOrigenDestino = aeropuertoOrigenDestino;
    }

    /**
     * @param amountExtendedPrice the amountExtendedPrice to set
     */
    public void setAmountExtendedPrice(BigDecimal amountExtendedPrice) {
        this.amountExtendedPrice = amountExtendedPrice;
    }

    /**
     * @param amountPriceperUnit the amountPriceperUnit to set
     */
    public void setAmountPriceperUnit(BigDecimal amountPriceperUnit) {
        this.amountPriceperUnit = amountPriceperUnit;
    }

    /**
     * @param dateThru the dateThru to set
     */
    public void setDateThru(Date dateThru) {
        this.dateThru = dateThru;
    }

    /**
     * @param fechaOperacionUTC the fechaOperacionUTC to set
     */
    public void setFechaOperacionUTC(Date fechaOperacionUTC) {
        this.fechaOperacionUTC = fechaOperacionUTC;
    }

    /**
     * @param fiscalYear the fiscalYear to set
     */
    public void setFiscalYear(Integer fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @param indicadorCobrableSN the indicadorCobrableSN to set
     */
    public void setIndicadorCobrableSN(String indicadorCobrableSN) {
        this.indicadorCobrableSN = indicadorCobrableSN;
    }

    /**
     * @param lineNumber the lineNumber to set
     */
    public void setLineNumber(BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * @param matriculaDeLaAeronave the matriculaDeLaAeronave to set
     */
    public void setMatriculaDeLaAeronave(String matriculaDeLaAeronave) {
        this.matriculaDeLaAeronave = matriculaDeLaAeronave;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * @param numberOfWeeksYear the numberOfWeeksYear to set
     */
    public void setNumberOfWeeksYear(Integer numberOfWeeksYear) {
        this.numberOfWeeksYear = numberOfWeeksYear;
    }

    /**
     * @param numeroDeVuelo the numeroDeVuelo to set
     */
    public void setNumerodevuelo(Integer numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    /**
     * @param originatorNumber the originatorNumber to set
     */
    public void setOriginatorNumber(String originatorNumber) {
        this.originatorNumber = originatorNumber;
    }

    /**
     * @param pasajerosEmbarcados the pasajerosEmbarcados to set
     */
    public void setPasajerosEmbarcados(Integer pasajerosEmbarcados) {
        this.pasajerosEmbarcados = pasajerosEmbarcados;
    }

    /**
     * @param pasajerosTasasEnDolares the pasajerosTasasenDolares to set
     */
    public void setPasajerosTasasEnDolares(Integer pasajerosTasasEnDolares) {
        this.pasajerosTasasEnDolares = pasajerosTasasEnDolares;
    }

    /**
     * @param pasajerosTasasEnPesos the pasajerosTasasEnPesos to set
     */
    public void setPasajerosTasasEnPesos(Integer pasajerosTasasEnPesos) {
        this.pasajerosTasasEnPesos = pasajerosTasasEnPesos;
    }

    /**
     * @param pasajerosTimbreEnPesos the pasajerosTimbreEnPesos to set
     */
    public void setPasajerosTimbreEnPesos(Integer pasajerosTimbreEnPesos) {
        this.pasajerosTimbreEnPesos = pasajerosTimbreEnPesos;
    }

    /**
     * @param pasajerosTimbresEnDolares the pasajerosTimbresEnDolares to set
     */
    public void setPasajerosTimbresEnDolares(Integer pasajerosTimbresEnDolares) {
        this.pasajerosTimbresEnDolares = pasajerosTimbresEnDolares;
    }

    /**
     * @param pasajerosEnTransito the pasajerosEnTransito to set
     */
    public void setPasajerosEnTransito(Integer pasajerosEnTransito) {
        this.pasajerosEnTransito = pasajerosEnTransito;
    }

    /**
     * @param pasajerosExentosDeTasas the pasajerosExentosDeTasas to set
     */
    public void setPasajerosExentosDeTasas(Integer pasajerosExentosDeTasas) {
        this.pasajerosExentosDeTasas = pasajerosExentosDeTasas;
    }

    /**
     * @param pasajerosExentosDeTimbre the pasajerosExentosDeTimbre to set
     */
    public void setPasajerosExentosDeTimbre(Integer pasajerosExentosDeTimbre) {
        this.pasajerosExentosDeTimbre = pasajerosExentosDeTimbre;
    }

    /**
     * @param priceAdjustmentName the priceAdjustmentName to set
     */
    public void setPriceAdjustmentName(String priceAdjustmentName) {
        this.priceAdjustmentName = priceAdjustmentName;
    }

    /**
     * @param siglaDeLaAerolinea the siglaDeLaAerolinea to set
     */
    public void setSigladelaAerolinea(String siglaDeLaAerolinea) {
        this.siglaDeLaAerolinea = siglaDeLaAerolinea;
    }

    /**
     * @param tipodeVuelo the tipodeVuelo to set
     */
    public void setTipodeVuelo(String tipodeVuelo) {
        this.tipodeVuelo = tipodeVuelo;
    }

    /**
     * @return the fechaOperacion
     */
    public String getFechaOperacion() {
        return fechaOperacion;
    }

    /**
     * @param fechaOperacion the fechaOperacion to set
     */
    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    /**
     * @return the fechaDesde
     */
    public String getFechaDesde() {
        return fechaDesde;
    }

    /**
     * @param fechaDesde the fechaDesde to set
     */
    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    /**
     * @return the fechaHasta
     */
    public String getFechaHasta() {
        return fechaHasta;
    }

    /**
     * @param fechaHasta the fechaHasta to set
     */
    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}
