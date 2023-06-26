/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.manifiesto.scheduler;

import com.aplicaciones13.manifiesto.jpa.model.Manifiesto;
import com.aplicaciones13.manifiesto.jpa.model.VManifiesto;
import com.aplicaciones13.manifiesto.jpa.queries.VManifiestoRepositorio;
import com.aplicaciones13.manifiesto.servicio.ManifiestoService;
import com.aplicaciones13.manifiesto.servicio.ParametroService;
import com.aplicaciones13.tasasTimbres.TasasTimbresCliente;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Tarea de Scheduler para enviar una solicitud WSDL.
 *
 * @author omargo33@hotmail.com
 */
@Component
public class ManifiestoTarea {

    private static final Logger LOG = LoggerFactory.getLogger(ManifiestoTarea.class);

    @Value("${aplicacion.nombre}")
    String nompreAplicacion;

    @Autowired
    private VManifiestoRepositorio vManifiestoRepositorio;

    @Autowired
    private ManifiestoService manifiestoServicio;

    @Autowired
    private ParametroService parametroService;

    @Scheduled(cron = "2 * * * * *", zone = "GMT-5")
    public void performTaskUsingCron() {
        ejecutarServicio();
    }

    /**
     * 
     */
    private void ejecutarServicio() {
        List<VManifiesto> listaVManifiesto = manifiestoServicio.findVManifiestoEstado("B");
        for (VManifiesto vm : listaVManifiesto) {
            Manifiesto manifiesto = manifiestoServicio.findManifiestoByIndice(vm.getIdManifiesto());
            int estado = ejecutarWebServices(vm);
            if (estado == 0) {
                manifiestoServicio.updateEstado(manifiesto, nompreAplicacion, "JDE");
            } 
            if (estado < 0) {
                manifiestoServicio.updateEstado(manifiesto, nompreAplicacion, "BADCON");
            }
            if (estado > 0) {
                manifiestoServicio.updateEstado(manifiesto, nompreAplicacion, "BAD" + estado);
            }
        }
    }

    /**
     * Metodo para enviar el manifiesto al web services de
     * IntegracionPortalTasasTimbres.
     *
     * @param vmanifiesto
     * @return
     */
    private int ejecutarWebServices(VManifiesto vmanifiesto) {
        int estado = 0;
        TasasTimbresCliente tasasTimbresCliente = new TasasTimbresCliente();
        try {
            //Datos de configuracion
            tasasTimbresCliente.getEncabezado().setUrl(parametroService.findParametro("001").getValorTexto01());
            tasasTimbresCliente.getEncabezado().setUsuario(parametroService.findParametro("002").getValorTexto01());
            tasasTimbresCliente.getEncabezado().setClave(parametroService.findParametro("002").getValorTexto02());
            tasasTimbresCliente.getEncabezado().setPathCertificado(parametroService.findParametro("003").getValorTexto01());
            tasasTimbresCliente.getEncabezado().setClaveCertificado(parametroService.findParametro("003").getValorTexto02());

            //Datos fijos
            tasasTimbresCliente.getCuerpo().setActiveOperationYN("Y");
            tasasTimbresCliente.getCuerpo().setIndicadorCobrableSN("S");
            tasasTimbresCliente.getCuerpo().setLineNumber(new BigDecimal(1));
            tasasTimbresCliente.getCuerpo().setPriceAdjustmentName("1");
            tasasTimbresCliente.getCuerpo().setDateThru(new Date());

            //Datos dinamicos
            tasasTimbresCliente.getCuerpo().setAeropuertoBasedeOperacion(vmanifiesto.getIndiceAeropuerto());
            tasasTimbresCliente.getCuerpo().setAeropuertoOrigenDestino(vmanifiesto.getIndiceDestino());
            tasasTimbresCliente.getCuerpo().setFechaOperacionUTC(vmanifiesto.getFechaLocalOperacion());
            tasasTimbresCliente.getCuerpo().setFiscalYear(vmanifiesto.getAnioFechaOperacion().intValue());
            tasasTimbresCliente.getCuerpo().setFromDate(vmanifiesto.getUsuarioFecha());
            tasasTimbresCliente.getCuerpo().setIndicadorCobrableSN(vmanifiesto.getIndicadorComprobable());
            tasasTimbresCliente.getCuerpo().setMatriculaDeLaAeronave(vmanifiesto.getIndiceAeronave());
            tasasTimbresCliente.getCuerpo().setMonth(vmanifiesto.getMesFechaOperacion().intValue());
            tasasTimbresCliente.getCuerpo().setNumberOfWeeksYear(calcularSemanaAnio(vmanifiesto.getFechaLocalOperacion()));
            tasasTimbresCliente.getCuerpo().setNumerodevuelo(Integer.parseInt(vmanifiesto.getNoVuelo()));
            tasasTimbresCliente.getCuerpo().setOriginatorNumber(vmanifiesto.getUsuario());
            tasasTimbresCliente.getCuerpo().setPasajerosEmbarcados(vmanifiesto.getPasajeros().intValue());
            
            tasasTimbresCliente.getCuerpo().setPasajerosTasasEnDolares(vmanifiesto.getPasajerosPaganDolares().intValue());
            tasasTimbresCliente.getCuerpo().setPasajerosTasasEnPesos(vmanifiesto.getPasajerosPaganPesos().intValue());
            
            tasasTimbresCliente.getCuerpo().setPasajerosTimbreEnPesos(vmanifiesto.getPasajerosPaganTimbres().intValue());
            tasasTimbresCliente.getCuerpo().setPasajerosTimbresEnDolares(vmanifiesto.getPasajerosPaganTimbresDolares().intValue());
            
            tasasTimbresCliente.getCuerpo().setPasajerosEnTransito(vmanifiesto.getPasajerosTransito().intValue());
            tasasTimbresCliente.getCuerpo().setPasajerosExentosDeTasas(vmanifiesto.getPasajerosExentosTasas().intValue());
            tasasTimbresCliente.getCuerpo().setPasajerosExentosDeTimbre(vmanifiesto.getPasajerosExentosTimbres().intValue());
            tasasTimbresCliente.getCuerpo().setSigladelaAerolinea(vmanifiesto.getIndiceAerolinea());
            tasasTimbresCliente.getCuerpo().setTipodeVuelo(vmanifiesto.getTipo());
            tasasTimbresCliente.getCuerpo().setAmountExtendedPrice(new BigDecimal(vmanifiesto.getTimbreTotal()));
            tasasTimbresCliente.getCuerpo().setAmountPriceperUnit(new BigDecimal(vmanifiesto.getTimbre()));
            tasasTimbresCliente.getCuerpo().setFechaOperacion(formatoFechaString(vmanifiesto.getFechaLocalOperacion()));
            tasasTimbresCliente.getCuerpo().setFechaDesde(formatoFechaString(inicioSemana(vmanifiesto.getFechaLocalOperacion())));
            tasasTimbresCliente.getCuerpo().setFechaHasta(formatoFechaString(finSemana(vmanifiesto.getFechaLocalOperacion())));

            if (!tasasTimbresCliente.ejecutarConsulta()) {
                LOG.error("error"+tasasTimbresCliente.getRespuesta().getErrorCode());
                LOG.error("error"+tasasTimbresCliente.getRespuesta().getErrorDescripcion());
                estado = Integer.parseInt(tasasTimbresCliente.getRespuesta().getErrorCode());
            }
        } catch (Exception e) {
            LOG.error(e.toString());
            tasasTimbresCliente.getRespuesta().setErrorDescripcion(e.toString());
            estado = -1;
        }
        return estado;
    }

    /**
     * Metodo para conocer la semana del anio.
     *
     * @param date
     * @return
     */
    private int calcularSemanaAnio(Date date) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);
        return calendario.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Metodo para dar formato de string.
     *
     * @param date
     * @return
     */
    private String formatoFechaString(Date date) {
        String pattern = "ddMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * Metodo para inicio de la semana.
     * 
     * @param dateBusqueda
     * @return 
     */
    private Date inicioSemana(Date dateBusqueda) {
        LocalDate now = dateBusqueda.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        return Date.from(now.with(fieldISO, 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Metodo para conocer el fin de semana.
     * 
     * @param dateBusqueda
     * @return 
     */
    private Date finSemana(Date dateBusqueda) {
        LocalDate now = dateBusqueda.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        return Date.from(now.with(fieldISO, 1).plusDays(6).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}
