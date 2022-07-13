  package WEB-INF.classes.modelManifiesto.bc.vistaNoDML;
  
  import java.sql.Date;
  import java.sql.Timestamp;
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  import java.util.Locale;
  import java.util.logging.Level;
  import java.util.logging.Logger;
  import model.bc.VistaObjeto;
  import modelManifiesto.bc.vistaNoDML.ManifiestoViewNoDMLImpl;
  import modelManifiesto.bc.vistaNoDML.common.ManifiestoViewNoDML;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class ManifiestoViewNoDMLImpl
    extends VistaObjeto
    implements ManifiestoViewNoDML
  {
    public void ejecutarConsulta(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen, int indiceAeropuertoDestino, int indiceAeronave, String noVuelo, String fechaInicio, String fechaFin) {
      Date fechaSQLInicio = convertirDate(fechaInicio);
      Date fechaSQLFin = convertirDate(fechaFin);
      
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("ManifiestoViewNoDMLCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
  
      
      if (idUsuario > 0) {
        vvm.setVariableValue("v_IdUsuario", Integer.valueOf(idUsuario));
      } else {
        vvm.setVariableValue("v_IdUsuario", null);
      } 
      if (indiceAerolinea > 0) {
        vvm.setVariableValue("v_IndiceAerolinea", Integer.valueOf(indiceAerolinea));
      } else {
        vvm.setVariableValue("v_IndiceAerolinea", null);
      } 
      if (indiceAeropuertoOrigen > 0) {
        vvm.setVariableValue("v_IndiceAeropuertoOrigen", Integer.valueOf(indiceAeropuertoOrigen));
      } else {
        vvm.setVariableValue("v_IndiceAeropuertoOrigen", null);
      } 
      if (indiceAeropuertoDestino > 0) {
        vvm.setVariableValue("v_IndiceAeropuertoDestino", Integer.valueOf(indiceAeropuertoDestino));
      } else {
        vvm.setVariableValue("v_IndiceAeropuertoDestino", null);
      } 
      if (indiceAeronave > 0) {
        vvm.setVariableValue("v_IndiceAeronave", Integer.valueOf(indiceAeronave));
      } else {
        vvm.setVariableValue("v_IndiceAeronave", null);
      } 
      if (noVuelo != null && noVuelo.trim().length() > 0 && noVuelo.compareTo("0") != 0) {
        vvm.setVariableValue("v_NoVuelo", noVuelo);
      } else {
        vvm.setVariableValue("v_NoVuelo", null);
      } 
      
      if (fechaSQLInicio != null && fechaSQLFin != null) {
        vvm.setVariableValue("v_FechaInicio", fechaSQLInicio);
        vvm.setVariableValue("v_FechaFin", fechaSQLFin);
      } else {
        vvm.setVariableValue("v_FechaInicio", new Date((new Date()).getTime() - 1296000000L));
        vvm.setVariableValue("v_FechaFin", new Date((new Date()).getTime() + 300000L));
      } 
      
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  
  
    
    public void ejecutarConsultaErrorJDE() {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("ManifiestoViewNoDMLCriteriaErrorRest");
      
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  
  
  
  
    
    public void cargarValoresDefaultBusqueda01(String idUsuario) {
      Timestamp fechaInicio = new Timestamp((new Date()).getTime() - 86400000L);
      Timestamp fechaFin = new Timestamp((new Date()).getTime() + 300000L);
      ensureVariableManager().setVariableValue("v_FechaInicioCompleta", fechaInicio);
      ensureVariableManager().setVariableValue("v_FechaFinCompleta", fechaFin);
      ensureVariableManager().setVariableValue("v_IdUsuario", idUsuario);
      ensureVariableManager().setVariableValue("v_Estado", "C");
    }
  
  
  
  
    
    public void cargarValoresDefaultBusqueda02(String idUsuario) {
      Date fechaInicio = new Date((new Date()).getTime() - 86400000L);
      Date fechaFin = new Date((new Date()).getTime() + 300000L);
      ensureVariableManager().setVariableValue("v_FechaInicioCompleta", fechaInicio);
      ensureVariableManager().setVariableValue("v_FechaFinCompleta", fechaFin);
      ensureVariableManager().setVariableValue("v_IdUsuario", idUsuario);
      ensureVariableManager().setVariableValue("v_Estado", "C");
    }
  
  
  
  
  
  
  
    
    private Date convertirDate(String fechaStr) {
      DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
      try {
        Date fechaTemp = dateFormat.parse(fechaStr);
        Date fechaSQLTemp = new Date(fechaTemp.getTime());
        return fechaSQLTemp;
      } catch (Exception e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
        
        return null;
      } 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/vistaNoDML/ManifiestoViewNoDMLImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */