  package WEB-INF.classes.modelManifiesto.bc;
  
  import java.sql.ResultSet;
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  import java.util.Locale;
  import java.util.logging.Level;
  import java.util.logging.Logger;
  import model.bc.ModuloImpl;
  import model.bc.VistaObjeto;
  import model.bc.modulo.Reporte;
  import model.bc.vistaNoDML.UsuarioViewNoDMLImpl;
  import modelAuditoria.bc.AuditoriaModuloImpl;
  import modelManifiesto.bc.ManifiestoModuloImpl;
  import modelManifiesto.bc.common.ManifiestoModulo;
  import modelManifiesto.bc.modulo.AerolineaUsuario;
  import modelManifiesto.bc.modulo.Manifiesto;
  import modelManifiesto.bc.vista.ManifiestoViewImpl;
  import modelManifiesto.bc.vistaNoDML.LibroDireccionesViewNoDMLImpl;
  import modelManifiesto.bc.vistaNoDML.ManifiestoViewNoDMLImpl;
  import modelManifiesto.bc.vistaNoDML.UsuarioAsignadoViewNoDMLImpl;
  import modelManifiesto.bc.vistaNoDML.UsuarioViewNoDMLImpl;
  import modelManifiesto.utilidades.estructura.AerolineaUsuarioIndices;
  import oracle.jbo.JboException;
  import oracle.jbo.server.ViewLinkImpl;
  
  
  
  
  
  
  
  
  
  
  public class ManifiestoModuloImpl
    extends AuditoriaModuloImpl
    implements ManifiestoModulo
  {
    AerolineaUsuarioIndices aerolineaUsuarioIndices = new AerolineaUsuarioIndices();
    
    final String SQL_MANIFIESTO = "SELECT id_manifiesto, id_usuario, nick, nombre_usuario, id_libro_direccion_aerolinea, indice_aerolinea, nombre_aerolinea, id_libro_direccion_aeropuerto, indice_aeropuerto, nombre_aeropuerto, id_libro_direccion_aeropuerto_des, indice_destino, nombre_destino, id_libro_direccion_aeronave, indice_aeronave, nombre_aeronave, fecha_local_operacion, fecha_corta_local_operacion, anio_fecha_operacion, mes_fecha_operacion, no_vuelo, pasajeros, pasajeros_transito, pasajeros_locales, pasajeros_exentos_tasas, pasajeros_pagan_tasas, pasajeros_pagan_dolares, pasajeros_pagan_pesos, pasajeros_exentos_timbres, pasajeros_pagan_timbres, pasajeros_pagan_timbres_dolares, pasajeros_pagan_timbres_pesos, tasa, timbre, timbre_total, indicador_comprobable, tipo, estado, usuario, usuario_fecha, usuario_programa FROM MV_001_00.v_manifiesto where";
  
  
  
  
  
  
  
    
    public ManifiestoModuloImpl() { setNombreBundle("modelManifiesto.ModelManifiestoBundle"); }
  
  
  
  
  
  
  
  
    
    public void cambiarEstadoManifiesto(String idManifiesto) { Manifiesto.cambiarEstado(this, idManifiesto); }
  
  
  
  
  
  
    
    public void cambiarEstadoManifiestos() { Manifiesto.cambiarEstadoCompleto(this); }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public int excelManifiesto(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen, int indiceAeropuertoDestino, int indiceAeronave, String noVuelo, String fechaInicio, String fechaFin, String tabla, String usuario, String usuarioPrograma) {
      int idArchivo = 0;
      String pattern = "yyyy-MM-dd-HH-mm-ss";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      String nombrePagina = String.format("%s-%s-%s.xls", new Object[] { tabla, usuario, simpleDateFormat.format(new Date()) });
      
      String sql = "SELECT id_manifiesto, id_usuario, nick, nombre_usuario, id_libro_direccion_aerolinea, indice_aerolinea, nombre_aerolinea, id_libro_direccion_aeropuerto, indice_aeropuerto, nombre_aeropuerto, id_libro_direccion_aeropuerto_des, indice_destino, nombre_destino, id_libro_direccion_aeronave, indice_aeronave, nombre_aeronave, fecha_local_operacion, fecha_corta_local_operacion, anio_fecha_operacion, mes_fecha_operacion, no_vuelo, pasajeros, pasajeros_transito, pasajeros_locales, pasajeros_exentos_tasas, pasajeros_pagan_tasas, pasajeros_pagan_dolares, pasajeros_pagan_pesos, pasajeros_exentos_timbres, pasajeros_pagan_timbres, pasajeros_pagan_timbres_dolares, pasajeros_pagan_timbres_pesos, tasa, timbre, timbre_total, indicador_comprobable, tipo, estado, usuario, usuario_fecha, usuario_programa FROM MV_001_00.v_manifiesto where";
      
      if (idUsuario > 0) {
        sql = sql + " (id_usuario = " + idUsuario + " )  AND";
      }
      if (indiceAerolinea > 0) {
        sql = sql + " (id_libro_direccion_aerolinea = " + indiceAerolinea + " )  AND";
      }
      if (indiceAeropuertoOrigen > 0) {
        sql = sql + " (id_libro_direccion_aeropuerto = " + indiceAeropuertoOrigen + " ) AND";
      }
      if (indiceAeropuertoDestino > 0) {
        sql = sql + " (id_libro_direccion_aeropuerto_des = " + indiceAeropuertoDestino + " ) AND";
      }
      if (indiceAeronave > 0) {
        sql = sql + " (id_libro_direccion_aeronave = " + indiceAeronave + " ) AND";
      }
      if (noVuelo != null && noVuelo.trim().length() > 0 && noVuelo.compareTo("0") != 0) {
        sql = sql + " (UPPER(no_vuelo) LIKE UPPER('%" + noVuelo + "%') ) AND";
      }
  
  
      
      sql = sql + " (fecha_corta_local_operacion BETWEEN  '" + convertirDate(fechaInicio) + "'  AND  '" + convertirDate(fechaFin) + "')";
      
      Logger.getLogger("global").log(Level.SEVERE, "SQL " + sql);
      
      ResultSet resultSet = getBaseDML().ejecutaConsulta(sql, new Object[0]);
      if (getBaseDML().getMensaje() != null) {
        throw new JboException("no consulta SQL");
      }
  
      
      idArchivo = Reporte.crearReporteExcel((ModuloImpl)this, resultSet, nombrePagina, "manifiesto", tabla, usuario, usuarioPrograma);
      return idArchivo;
    }
  
  
  
  
  
  
  
    
    private String convertirDate(String fechaStr) {
      DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
      DateFormat dateFormatSimple = new SimpleDateFormat("yyyy-MM-dd");
      String respuesta = fechaStr;
      try {
        Date fechaTemp = dateFormat.parse(fechaStr);
        
        respuesta = dateFormatSimple.format(fechaTemp);
      }
      catch (Exception e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
      } 
      return respuesta;
    }
  
  
  
  
  
  
  
  
  
    
    public int getIdUsuarioNick(String nick) {
      this.aerolineaUsuarioIndices = AerolineaUsuario.buscarUsuario(this, nick);
      return this.aerolineaUsuarioIndices.getIdUsuario();
    }
  
    
    public int getIdAerolineaNick(String nick) {
      this.aerolineaUsuarioIndices = AerolineaUsuario.buscarUsuario(this, nick);
      return this.aerolineaUsuarioIndices.getIdAerolinea();
    }
    
    public int getIdAeropuertoNick(String nick) {
      this.aerolineaUsuarioIndices = AerolineaUsuario.buscarUsuario(this, nick);
      return this.aerolineaUsuarioIndices.getIdAeropuerto();
    }
  
  
  
  
  
    
    public VistaObjeto getInformacionView1() { return (VistaObjeto)findViewObject("InformacionView1"); }
  
  
  
  
  
  
    
    public ManifiestoViewImpl getManifiestoView1() { return (ManifiestoViewImpl)findViewObject("ManifiestoView1"); }
  
  
  
  
  
  
  
    
    public VistaObjeto getLibroDireccionView1() { return (VistaObjeto)findViewObject("LibroDireccionView1"); }
  
  
  
  
  
  
  
    
    public UsuarioViewNoDMLImpl getUsuarioViewNoDML1() { return (UsuarioViewNoDMLImpl)findViewObject("UsuarioViewNoDML1"); }
  
  
  
  
  
  
    
    public VistaObjeto getAerolineaUsuarioView2() { return (VistaObjeto)findViewObject("AerolineaUsuarioView2"); }
  
  
  
  
  
  
    
    public VistaObjeto getAerolineaUsuarioView1() { return (VistaObjeto)findViewObject("AerolineaUsuarioView1"); }
  
  
  
  
  
  
    
    public ViewLinkImpl getLibroDireccionAerolineaUsuarioLink1() { return (ViewLinkImpl)findViewLink("LibroDireccionAerolineaUsuarioLink1"); }
  
  
  
  
  
  
  
    
    public UsuarioViewNoDMLImpl getBase_UsuarioViewNoDML1() { return (UsuarioViewNoDMLImpl)findViewObject("Base_UsuarioViewNoDML1"); }
  
  
  
  
  
  
    
    public UsuarioAsignadoViewNoDMLImpl getUsuarioAsignadoViewNoDML1() { return (UsuarioAsignadoViewNoDMLImpl)findViewObject("UsuarioAsignadoViewNoDML1"); }
  
  
  
  
  
  
    
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAeropuertoViewNoDML1() { return (LibroDireccionesViewNoDMLImpl)findViewObject("LibroDireccionesAeropuertoViewNoDML1"); }
  
  
  
  
  
  
    
    public VistaObjeto getTasaView1() { return (VistaObjeto)findViewObject("TasaView1"); }
  
  
  
  
  
  
    
    public ManifiestoViewNoDMLImpl getManifiestoViewNoDML1() { return (ManifiestoViewNoDMLImpl)findViewObject("ManifiestoViewNoDML1"); }
  
  
  
  
  
  
    
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAeronaveViewNoDML1() { return (LibroDireccionesViewNoDMLImpl)findViewObject("LibroDireccionesAeronaveViewNoDML1"); }
  
  
  
  
  
  
    
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAeropuertoDestinoViewNoDML1() { return (LibroDireccionesViewNoDMLImpl)findViewObject("LibroDireccionesAeropuertoDestinoViewNoDML1"); }
  
  
  
  
  
  
    
    public LibroDireccionesViewNoDMLImpl getLibroDireccionesAerolineaViewNoDML1() { return (LibroDireccionesViewNoDMLImpl)findViewObject("LibroDireccionesAerolineaViewNoDML1"); }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/ManifiestoModuloImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */