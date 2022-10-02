/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.libroDireccion.cliente;

import java.net.HttpURLConnection;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omarv
 */
public class SolicitaRESTURLTest {
    
    public SolicitaRESTURLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ejecutarConsultaWebService method, of class SolicitaRESTURL.
     */
    @Test
    public void testEjecutarConsultaWebService() throws Exception {
        System.out.println("ejecutarConsultaWebService");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.ejecutarConsultaWebService();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarConexion method, of class SolicitaRESTURL.
     */
    @Test
    public void testGenerarConexion() throws Exception {
        System.out.println("generarConexion");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        HttpURLConnection expResult = null;
        HttpURLConnection result = instance.generarConexion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeOut method, of class SolicitaRESTURL.
     */
    @Test
    public void testGetTimeOut() {
        System.out.println("getTimeOut");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        int expResult = 0;
        int result = instance.getTimeOut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeOut method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetTimeOut() {
        System.out.println("setTimeOut");
        int timeOut = 0;
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setTimeOut(timeOut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHTTPEstado method, of class SolicitaRESTURL.
     */
    @Test
    public void testGetHTTPEstado() {
        System.out.println("getHTTPEstado");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        int expResult = 0;
        int result = instance.getHTTPEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setURLConsulta method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetURLConsulta() {
        System.out.println("setURLConsulta");
        String URLConsulta = "";
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setURLConsulta(URLConsulta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getURLConsulta method, of class SolicitaRESTURL.
     */
    @Test
    public void testGetURLConsulta() {
        System.out.println("getURLConsulta");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        String expResult = "";
        String result = instance.getURLConsulta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaInicio method, of class SolicitaRESTURL.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        Date expResult = null;
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaFin method, of class SolicitaRESTURL.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        Date expResult = null;
        Date result = instance.getFechaFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getErrorRespuesta method, of class SolicitaRESTURL.
     */
    @Test
    public void testGetErrorRespuesta() {
        System.out.println("getErrorRespuesta");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        String expResult = "";
        String result = instance.getErrorRespuesta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setErrorRespuesta method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetErrorRespuesta() {
        System.out.println("setErrorRespuesta");
        String errorRespuesta = "";
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setErrorRespuesta(errorRespuesta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJSONConsulta method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetJSONConsulta() {
        System.out.println("setJSONConsulta");
        String JSONConsulta = "";
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setJSONConsulta(JSONConsulta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJSONRespuesta method, of class SolicitaRESTURL.
     */
    @Test
    public void testGetJSONRespuesta() {
        System.out.println("getJSONRespuesta");
        SolicitaRESTURL instance = new SolicitaRESTURL();
        String expResult = "";
        String result = instance.getJSONRespuesta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIpProxy method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetIpProxy() {
        System.out.println("setIpProxy");
        String ipProxy = "";
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setIpProxy(ipProxy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPuertoProxy method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetPuertoProxy() {
        System.out.println("setPuertoProxy");
        String puertoProxy = "";
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setPuertoProxy(puertoProxy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPathCertificado method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetPathCertificado() {
        System.out.println("setPathCertificado");
        String pathCertificado = "";
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setPathCertificado(pathCertificado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClaveCertificado method, of class SolicitaRESTURL.
     */
    @Test
    public void testSetClaveCertificado() {
        System.out.println("setClaveCertificado");
        String claveCertificado = "";
        SolicitaRESTURL instance = new SolicitaRESTURL();
        instance.setClaveCertificado(claveCertificado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
