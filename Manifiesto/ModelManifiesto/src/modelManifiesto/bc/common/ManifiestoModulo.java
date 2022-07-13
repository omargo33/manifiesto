package WEB-INF.classes.modelManifiesto.bc.common;

import model.bc.common.Modulo;

public interface ManifiestoModulo extends Modulo {
  int getIdAerolineaNick(String paramString);
  
  int getIdAeropuertoNick(String paramString);
  
  int getIdUsuarioNick(String paramString);
  
  int excelManifiesto(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  void cambiarEstadoManifiestos();
  
  void cambiarEstadoManifiesto(String paramString);
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/classes/modelManifiesto/bc/common/ManifiestoModulo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */