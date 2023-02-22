package modelManifiesto;

import com.aplicaciones13.reporte.pdf.ImpresionBaseIText;

import com.aplicaciones13.reporte.pdf.itext.presentacion.CenefaEstructura;

import java.math.BigDecimal;

import java.math.MathContext;

import java.util.HashMap;
import java.util.Map;


import modelManifiesto.bc.reporte.PreliquidacionCobro;


public class Test {
    public Test() {
        super();
    }

    public static void main(String[] args) {
        // Assign value to BigDecimal object b1
        
        String data="12.23";
        
        System.out.println("data " + data);
        System.out.println("data " + Integer.parseInt(data));
            
        
        /*BigDecimal b1 = new BigDecimal("12345678");
        MathContext mc = new MathContext(6);         
        b1 = b1.round(mc);
        System.out.println("The value of " + b1 + " after rounding is " + b1.toPlainString());*/
        
        //pdf();
    }

    public static void pdf() {
        Map<String, String> mapa = new HashMap<>();
        mapa.put("documentoNombre", "nombre");
        mapa.put("documentoCodigo", "codigo");

        // ingreso Sistema parametros
        mapa.put("imagenAerocivil", "/home/ovelez/izquierda.jpg");
        mapa.put("imagenColombia", "/home/ovelez/derecha.jpg");
        mapa.put("tituloImpuesto",
                 "IMPUESTO DE TIMBRE NACIONAL\nLEY 2 DE 1976 Y RESOLUCIÓN 1545 DE 2 DE JULIO DE 2015");
        mapa.put("tituloDocumento", "AERONÁUTICA CIVIL DE COLOMBIA\nLIQUIDACIÓN DE PAGO");

        // ingreso sistema busqueda previa
        mapa.put("fechaInicio", "2022-01-01");
        mapa.put("fechaFin", "2024-12-31");
        mapa.put("totalPasajeros", "826");
        mapa.put("totalPasajerosTransito", "14");
        mapa.put("totalPasajerosExcentosTimbre", "179");
        mapa.put("totalCobroImpuesto", "633");
        mapa.put("totalCalculoImpuesto", "633");
        mapa.put("tarifaImpuest", "99000.01");
        mapa.put("siglaAerolineaOrigen", "SKNH");
        mapa.put("descripcionAerolineaOrigen", "Aerolinea de Alemania del este que esta a prueba");

        //ingreso manual
        mapa.put("direccionAerolineaRecaudadora", "ingreso manual direccion");
        mapa.put("telefonoAerolineaRecaudadora", "ingreso manual telefono");

        //ingreso manual
        mapa.put("nombreEnCualRecuada", "ingreso manual del nombre");
        mapa.put("ciudadDepartamentoEnCualRecuada", "ingreso manual ciudad y departamento");

        //ingreso manual
        mapa.put("nombreContacto", "Nombre como anabel y otros para probar");
        mapa.put("emailContacto", "omargo33+keychron@hotmail.com");

        //ingreso manual
        mapa.put("efectivo", "X");
        mapa.put("cheque", " X\nNo.: 123456123");
        mapa.put("transferencia", "x");


        mapa.put("sutotal", "62667000.10");
        mapa.put("devoluciones", "0.11");
        mapa.put("valorLiquidacion", "430254000.12");
        mapa.put("valorAPagar", "430254000");

        mapa.put("aclaracion1", "\n");
        mapa.put("aclaracion2", "\n");
        mapa.put("aclaracion3", "\n ");
        mapa.put("aclaracion4", "\n");
        mapa.put("aclaracion5", "Total");

        mapa.put("aclaracionValor1", "");
        mapa.put("aclaracionValor2", "");
        mapa.put("aclaracionValor3", "");
        mapa.put("aclaracionValor4", "");
        mapa.put("aclaracionValor5", "");

        //ingreso sistema
        mapa.put("documentoDestino", "/home/ovelez/test.pdf");

        PreliquidacionCobro preliquidacionCobro = new PreliquidacionCobro();
        preliquidacionCobro.setOrdenElementos(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        ImpresionBaseIText impresionBaseIText = new ImpresionBaseIText(preliquidacionCobro);

        impresionBaseIText.ejecutar(18, 36, 30, 30, true, mapa);
    }
}
