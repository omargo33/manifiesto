  package WEB-INF.classes.modelManifiesto.bc.entidad;
  
  import java.sql.Date;
  import java.util.Calendar;
  import java.util.Date;
  import model.bc.Entidad;
  import modelManifiesto.bc.entidad.ManifiestoImpl;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  
  
  
  public class ManifiestoImpl
    extends Entidad
  {
    public boolean validateFechaLocalOperacion(Date fechalocaloperacion) {
      Double diasPrevios = getParametroValor01("004");
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(new Date());
      calendar.add(6, diasPrevios.intValue() * -1);
      return (fechalocaloperacion.getTime() > calendar.getTime().getTime());
    }
  
  
  
    
    public boolean validatePasajeros(Integer pasajeros) {
      Double pasajerosMaximo = getParametroValor01("005");
      return (pasajeros.intValue() < pasajerosMaximo.intValue());
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static final int IDMANIFIESTO = AttributesEnum.IdManifiesto.index();
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int IDLIBRODIRECCIONAEROLINEA = AttributesEnum.IdLibroDireccionAerolinea.index();
    public static final int IDLIBRODIRECCIONAEROPUERTO = AttributesEnum.IdLibroDireccionAeropuerto.index();
    public static final int IDLIBRODIRECCIONAEROPUERTODES = AttributesEnum.IdLibroDireccionAeropuertoDes.index();
    public static final int IDLIBRODIRECCIONAERONAVE = AttributesEnum.IdLibroDireccionAeronave.index();
    public static final int FECHALOCALOPERACION = AttributesEnum.FechaLocalOperacion.index();
    public static final int NOVUELO = AttributesEnum.NoVuelo.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int PASAJEROS = AttributesEnum.Pasajeros.index();
    public static final int PASAJEROSTRANSITO = AttributesEnum.PasajerosTransito.index();
    public static final int PASAJEROSLOCALES = AttributesEnum.PasajerosLocales.index();
    public static final int PASAJEROSEXENTOSTASAS = AttributesEnum.PasajerosExentosTasas.index();
    public static final int PASAJEROSPAGANTASAS = AttributesEnum.PasajerosPaganTasas.index();
    public static final int PASAJEROSPAGANDOLARES = AttributesEnum.PasajerosPaganDolares.index();
    public static final int PASAJEROSPAGANPESOS = AttributesEnum.PasajerosPaganPesos.index();
    public static final int PASAJEROSEXENTOSTIMBRES = AttributesEnum.PasajerosExentosTimbres.index();
    public static final int PASAJEROSPAGANTIMBRES = AttributesEnum.PasajerosPaganTimbres.index();
    public static final int PASAJEROSPAGANTIMBRESDOLARES = AttributesEnum.PasajerosPaganTimbresDolares.index();
    public static final int PASAJEROSPAGANTIMBRESPESOS = AttributesEnum.PasajerosPaganTimbresPesos.index();
    public static final int INDICADORCOMPROBABLE = AttributesEnum.IndicadorComprobable.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int AEROLINEAUSUARIO = AttributesEnum.AerolineaUsuario.index();
  
  
  
  
  
    
    public ManifiestoImpl() { setNombreBundle("modelManifiesto.ModelManifiestoBundle"); }
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idManifiesto) { return new Key(new Object[] { idManifiesto }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelManifiesto.bc.entidad.Manifiesto"); }
  
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
      
      if (operation == 1)
        setAttribute(IDMANIFIESTO, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/entidad/ManifiestoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */