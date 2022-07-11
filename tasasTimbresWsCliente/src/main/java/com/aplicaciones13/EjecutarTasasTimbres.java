package com.aplicaciones13;

import com.aplicaciones13.tasasTimbres.TasasTimbresCliente;
import java.math.BigDecimal;
//import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author omarv
 */
public class EjecutarTasasTimbres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        TasasTimbresCliente tasasTimbresCliente = new TasasTimbresCliente();

        tasasTimbresCliente.getEncabezado().setUrl("https://186.31.107.90:8089/PY920/IntegracionPortalTasasTimbres");
        tasasTimbresCliente.getEncabezado().setUsuario("CONSULTOR");
        tasasTimbresCliente.getEncabezado().setClave("C0nsult0r2021#*");
        tasasTimbresCliente.getEncabezado().setPathCertificado("/home/omarv/ssl_jde_aerocivil");
        tasasTimbresCliente.getEncabezado().setClaveCertificado("1937480");

        //for (int i = 10; i < 15; i++) {
        tasasTimbresCliente.getCuerpo().setActiveOperationYN("Y");
        tasasTimbresCliente.getCuerpo().setAeropuertoBasedeOperacion("SKBO");
        tasasTimbresCliente.getCuerpo().setAeropuertoOrigenDestino("SKBU");
        tasasTimbresCliente.getCuerpo().setAmountExtendedPrice(new BigDecimal(1100));
        tasasTimbresCliente.getCuerpo().setAmountPriceperUnit(new BigDecimal(1100));
        //tasasTimbresCliente.getCuerpo().setDateThru(new Date());
        //tasasTimbresCliente.getCuerpo().setFechaOperacionUTC(new Date());
        tasasTimbresCliente.getCuerpo().setFiscalYear(21);
        //tasasTimbresCliente.getCuerpo().setFromDate(new Date());
        tasasTimbresCliente.getCuerpo().setIndicadorCobrableSN("N");
        tasasTimbresCliente.getCuerpo().setLineNumber(new BigDecimal(1));
        tasasTimbresCliente.getCuerpo().setMatriculaDeLaAeronave("HK3586");
        tasasTimbresCliente.getCuerpo().setMonth(5);
        tasasTimbresCliente.getCuerpo().setNumberOfWeeksYear(63);
        tasasTimbresCliente.getCuerpo().setNumerodevuelo(5005);
        tasasTimbresCliente.getCuerpo().setOriginatorNumber("java");
        tasasTimbresCliente.getCuerpo().setPasajerosEmbarcados(120);
        tasasTimbresCliente.getCuerpo().setPasajerosTasasEnDolares(35);
        tasasTimbresCliente.getCuerpo().setPasajerosTasasEnPesos(85);
        tasasTimbresCliente.getCuerpo().setPasajerosTimbreEnPesos(75);
        tasasTimbresCliente.getCuerpo().setPasajerosTimbresEnDolares(15);
        tasasTimbresCliente.getCuerpo().setPasajerosEnTransito(10);
        tasasTimbresCliente.getCuerpo().setPasajerosExentosDeTasas(7);
        tasasTimbresCliente.getCuerpo().setPasajerosExentosDeTimbre(8);
        tasasTimbresCliente.getCuerpo().setPriceAdjustmentName("ADFNM");
        tasasTimbresCliente.getCuerpo().setSigladelaAerolinea("IBE");
        tasasTimbresCliente.getCuerpo().setTipodeVuelo("I");

        if (!tasasTimbresCliente.ejecutarConsulta()) {
            System.out.println("error code: " + tasasTimbresCliente.getRespuesta().getErrorCode());
            System.out.println("error descripcion: " + tasasTimbresCliente.getRespuesta().getErrorDescripcion());
        } else {
            System.out.println("No se pudo ejecutar el servicio.");

        }
        System.out.println(tasasTimbresCliente.toString());
    }
    //}
}
