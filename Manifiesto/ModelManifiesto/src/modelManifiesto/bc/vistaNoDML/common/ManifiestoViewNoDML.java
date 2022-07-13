package WEB-INF.classes.modelManifiesto.bc.vistaNoDML.common;

import oracle.jbo.ViewObject;

public interface ManifiestoViewNoDML extends ViewObject {
  void cargarValoresDefaultBusqueda01(String paramString);
  
  void cargarValoresDefaultBusqueda02(String paramString);
  
  void ejecutarConsulta(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, String paramString3);
  
  void ejecutarConsultaErrorJDE();
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/vistaNoDML/common/ManifiestoViewNoDML.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */