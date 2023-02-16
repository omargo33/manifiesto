package modelManifiesto.bc.reporte;

import com.aplicaciones13.reporte.pdf.ImpresionBaseElementos;
import com.aplicaciones13.reporte.pdf.itext.texto.Elemento;

import com.aplicaciones13.reporte.pdf.itext.texto.P;

import com.itextpdf.layout.property.TextAlignment;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.borders.Border;

/**
 *  Objeto de impresion de liquidacion.
 *
 *  @author omargo33@hotmail.com
 *
 */
public class PreliquidacionCobro extends ImpresionBaseElementos {

    /**
     * Metodo para encabezado del documento
     *
     */
    @Override
    public synchronized void elemento1() {
        getImagen().setPathImagen(getParametrosBusqueda().get("imagenAerocivil"));
        float total = getDocumento().getPdfDocument()
                                    .getDefaultPageSize()
                                    .getWidth();
        getImagen().setMaximoAncho(Math.round(25f / 100 * total));
        getImagen().procesar();
        Cell cellImagenDer = new Cell();
        cellImagenDer.setBorder(Border.NO_BORDER);
        cellImagenDer.add(getImagen().getImagen());

        getImagen().setPathImagen(getParametrosBusqueda().get("imagenColombia"));
        total = getDocumento().getPdfDocument()
                              .getDefaultPageSize()
                              .getWidth();
        getImagen().setMaximoAncho(Math.round(25f / 100 * total));
        getImagen().procesar();
        Cell cellImagenIzq = new Cell();
        cellImagenIzq.setBorder(Border.NO_BORDER);
        cellImagenIzq.add(getImagen().getImagen());

        getPanel().setListaDimensiones(26f, 48.7f, 26f);
        getPanel().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getPanel().getMapaAlineamiento().put(2, TextAlignment.CENTER);
        getPanel().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getPanel().setListaCeldas(cellImagenDer, generarTitulos(), cellImagenIzq);
        getPanel().procesarEscribir();
    }

    /**
     * Metodo para generar titulos.
     *
     * @return
     */
    private Table generarTitulos() {
        float total = getDocumento().getPdfDocument()
                                    .getDefaultPageSize()
                                    .getWidth();
        float dime[] = { total * 40 / 100 };
        Table tabla = new Table(dime);
        tabla.setBorder(Border.NO_BORDER);
        
        P ptitulo = new P(getParametrosBusqueda().get("tituloImpuesto"), P.NOTA);
        Cell cell = new Cell();
        cell.add(ptitulo.getParagraph());
        cell.setBorder(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.CENTER);
        tabla.addCell(cell);

        ptitulo = new P(getParametrosBusqueda().get("tituloDocumento"), P.TEXTO);
        ptitulo.negrita();
        Cell cell3 = new Cell();
        cell3.add(ptitulo.getParagraph());
        cell3.setBorder(Border.NO_BORDER);
        cell3.setTextAlignment(TextAlignment.CENTER);
        tabla.addCell(cell3);

        return tabla;
    }

    /**
     * Metodo para imprimir el elemento 1.
     *
     * Titulo del documento
     *
     */
    @Override
    public synchronized void elemento2() {
        getEspacio().escribir(2);
        getTabla().setListaTitulos("a. PERÍODO LIQUIDADO Y PAGADO", "", "", "");
        List<Object[]> lista = new ArrayList();
        Object[] fechas = new Object[] {
            "Formato de fechas (aaaa-mm-dd)", getParametrosBusqueda().get("fechaInicio"), "al",
            getParametrosBusqueda().get("fechaFin")
        };
        lista.add(fechas);
        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.CENTER);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.CENTER);
        getTabla().getMapaAlineamiento().put(3, TextAlignment.CENTER);
        getTabla().getMapaAlineamiento().put(4, TextAlignment.CENTER);
        getTabla().setListaDimensiones(40f, 20f, 20f, 20f);
        getTabla()
            .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                              Elemento.FORMATO_STRING);
        getTabla().procesarMargenesEscribir();
    }

    /**
     * Metodo con los datos de razon socila e informacion del socio
     */
    @Override
    public synchronized void elemento3() {
        getEspacio().escribir(1);
        getTabla().setListaTitulos("b. RAZON SOCIAL", "Nit");
        List<Object[]> lista = new ArrayList();
        Object[] fechas = new Object[] {
            getParametrosBusqueda().get("descripcionAerolineaOrigen"),
            getParametrosBusqueda().get("siglaAerolineaOrigen")
        };
        lista.add(fechas);
        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getTabla().setListaDimensiones(75f, 25f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().procesarMargenesEscribir();

        getTabla()
            .setListaTitulos("c. DIRECCIÓN DE LA AEROLÍNEA RECAUDADORA",
                             "TELÉFONOS DEL CONTACTO - AEROLÍNEA RECAUDADORA");
        lista = new ArrayList();
        fechas = new Object[] {
            getParametrosBusqueda().get("direccionAerolineaRecaudadora"),
            getParametrosBusqueda().get("telefonoAerolineaRecaudadora") };
        lista.add(fechas);
        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getTabla().setListaDimensiones(50f, 50f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().procesarMargenesEscribir();

        getTabla().setListaTitulos("NOMBRE DE LA AEROLÍNEA EN NOMBRE DE LA CUAL SE RECAUDA", "CIUDAD Y DEPARTAMENTO");
        lista = new ArrayList();
        fechas = new Object[] {
            getParametrosBusqueda().get("nombreEnCualRecuada"),
            getParametrosBusqueda().get("ciudadDepartamentoEnCualRecuada") };
        lista.add(fechas);
        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getTabla().setListaDimensiones(75f, 25f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().procesarMargenesEscribir();

        getTabla().setListaTitulos("NOMBRE DEL CONTACTO PARA INFORMACIÓN", "EMAIL DEL CONTACTO PARA INFORMACIÓN");
        lista = new ArrayList();
        fechas = new Object[] {
            getParametrosBusqueda().get("nombreContacto"), getParametrosBusqueda().get("emailContacto") };
        lista.add(fechas);
        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.LEFT);
        getTabla().setListaDimensiones(50f, 50f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().procesarMargenesEscribir();
    }

    /**
     * Metodo con la informacion de los pasajeros.
     */
    @Override
    public synchronized void elemento4() {
        getEspacio().escribir(1);
        getForm()
            .setListaTitulos("d. Número de total de pasajeros embarcados durante el período liquidado",
                             "d. Número de total de pasajeros en Tránsito",
                             "e. Número de pasajeros exentos de Timbre durante el período liquidado",
                             "f. Número de pasajeros sujetos al cobro de impuesto de timbre (d-e)");
        getForm()
            .setListaValores(getParametrosBusqueda().get("totalPasajeros"),
                             getParametrosBusqueda().get("totalPasajerosTransito"),
                             getParametrosBusqueda().get("totalPasajerosExcentosTimbre"),
                             getParametrosBusqueda().get("totalCobroImpuesto"));
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
        getForm().setListaDimensiones(80f, 20f);
        getForm()
            .setListaFormatos(Elemento.FORMATO_ENTERO, Elemento.FORMATO_ENTERO, Elemento.FORMATO_ENTERO,
                              Elemento.FORMATO_ENTERO);
        getForm().procesarMargenesEscribir();
    }
    
    
    /**
     * Metodo para presentar la informacion de la liquidacion y totales.
     */
    @Override
    public synchronized void elemento5() {
        getEspacio().escribir(1);
        getH3().setTextoCentro("LIQUIDACIÓN PRIVADA DEL MONTO A PAGAR POR CONCEPTO DEL RECAUDO DEL IMPUESTO DE TIMBRE");
        getH3().escribir();
        getForm()
            .setListaTitulos("f. Número de pasajeros sujetos a cobro", "g. Tarifa del impuesto de timbre por pasajero",
                             "h. Subtotal (Casilla f multiplicada por Casilla g)", "i. Devoluciones y/o aclaraciones",
                             "j. Valor de la liquidación privada (Casilla h menos Casilla i)",
                             "k. Valor a Pagar (Aproximar el valor obtenido en la casilla j al múltiplo de mil más cercano)");
        getForm()
            .setListaValores(getParametrosBusqueda().get("totalCobroImpuesto"),
                             getParametrosBusqueda().get("tarifaImpuest"), getParametrosBusqueda().get("sutotal"),
                             getParametrosBusqueda().get("devoluciones"),
                             getParametrosBusqueda().get("valorLiquidacion"),
                             getParametrosBusqueda().get("valorAPagar"));
        getForm().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(2, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(3, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(4, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(5, TextAlignment.RIGHT);
        getForm().getMapaAlineamiento().put(6, TextAlignment.RIGHT);
        getForm().setListaDimensiones(80f, 20f);
        getForm()
            .setListaFormatos(Elemento.FORMATO_DOUBLE, Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA,
                              Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA, Elemento.FORMATO_MONEDA);
        getForm().procesarMargenesEscribir();
    }

    /**
     * Metodo para informacion del pago.
     */
    @Override
    public synchronized void elemento6() {
        getEspacio().escribir(1);
        getTabla().setListaTitulos("19 FORMA DE PAGO", "EFECTIVO", "CHEQUE", "TRANSFERENCIA");
        List<Object[]> lista = new ArrayList();
        Object[] fechas = new Object[] {
            "(marque X en)", getParametrosBusqueda().get("efectivo"), getParametrosBusqueda().get("cheque"),
            getParametrosBusqueda().get("transferencia")
        };
        lista.add(fechas);
        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.CENTER);
        getTabla().getMapaAlineamiento().put(2, TextAlignment.CENTER);
        getTabla().getMapaAlineamiento().put(3, TextAlignment.CENTER);
        getTabla().getMapaAlineamiento().put(4, TextAlignment.CENTER);
        getTabla().setListaDimensiones(40f, 20f, 20f, 20f);
        getTabla()
            .setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING, Elemento.FORMATO_STRING,
                              Elemento.FORMATO_STRING);
        getTabla().procesarMargenesEscribir();
    }

    /**
     * Metodo para presentar la informacion del Banco.
     */
    @Override
    public synchronized void elemento7() {
        float total = getDocumento().getPdfDocument()
                                    .getDefaultPageSize()
                                    .getWidth();
        float dime[] = { total };
        Table tabla = new Table(dime);

        P ptitulo = new P("Banco de la República \nCuenta corriente No. 61011060 \n\nNIT 899 999 090 2", P.TEXTO);
        Cell cell = new Cell();
        cell.add(ptitulo.getParagraph());
        cell.setBorderBottom(Border.NO_BORDER);
        cell.setTextAlignment(TextAlignment.LEFT);
        tabla.addCell(cell);

        getDocumento().add(tabla);

        elemento70();
        elemento80();
    }

    /**
     * Metodo para presentar las informacion de aclaraciones.
     *
     */
    public synchronized void elemento70() {
        getTabla().setListaTitulos("l. CONCEPTO DEVOLUCIONES/ACLARACIONES", "");
        List<Object[]> lista = new ArrayList();
        Object[] aclaraciones1 = new Object[] {
            getParametrosBusqueda().get("aclaracion1"), getParametrosBusqueda().get("aclaracionValor1"), };
        lista.add(aclaraciones1);

        Object[] aclaraciones2 = new Object[] {
            getParametrosBusqueda().get("aclaracion2"), getParametrosBusqueda().get("aclaracionValor2"), };
        lista.add(aclaraciones2);

        Object[] aclaraciones3 = new Object[] {
            getParametrosBusqueda().get("aclaracion3"), getParametrosBusqueda().get("aclaracionValor3"), };
        lista.add(aclaraciones3);


        Object[] aclaraciones4 = new Object[] {
            getParametrosBusqueda().get("aclaracion4"), getParametrosBusqueda().get("aclaracionValor4"), };
        lista.add(aclaraciones4);

        Object[] aclaraciones5 = new Object[] {
            getParametrosBusqueda().get("aclaracion5"), getParametrosBusqueda().get("aclaracionValor5"), };
        lista.add(aclaraciones5);

        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(0, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.RIGHT);
        getTabla().setListaDimensiones(75f, 25f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_STRING);
        getTabla().procesarMargenesEscribir();
    }

    /**
     * Metodo con los valores para firmas de la preliquidacion
     *
     */
    public synchronized void elemento80() {
        getEspacio().escribir(1);
        getTabla().setListaTitulos("m. NOMBRES Y FIRMAS :", "");
        List<Object[]> lista = new ArrayList();
        Object[] firma1 = new Object[] { "RESPONSABLE:\n\n\n\nMARTHA PATRICIA NIÑO RUIZ\nC.C. 39.745.264" };
        lista.add(firma1);

        Object[] firma2 = new Object[] {
            "REVISOR FISCAL o CONTADOR:\n\n\n\nJAIME LEON\nC.C. 17.135.692     T.P. 710-T" };
        lista.add(firma2);

        getTabla().setListaValores(lista);
        getTabla().getMapaAlineamiento().put(0, TextAlignment.LEFT);
        getTabla().getMapaAlineamiento().put(1, TextAlignment.LEFT);
        getTabla().setListaDimensiones(50f, 50f);
        getTabla().setListaFormatos(Elemento.FORMATO_STRING, Elemento.FORMATO_MONEDA);
        getTabla().procesarMargenesEscribir();
    }
}
