package modelManifiesto.bc.common;

import model.bc.common.Modulo;

public interface ManifiestoModulo extends Modulo {
  int getIdAerolineaNick(String paramString);
  
  int getIdAeropuertoNick(String paramString);
  
  int getIdUsuarioNick(String paramString);
  

    int excelManifiesto(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen, int indiceAeropuertoDestino,
                        int indiceAeronave, String noVuelo, String fechaInicio, String fechaFin, String tabla,
                        String usuario, String usuarioPrograma);
  
  
  void cambiarEstadoManifiestos();
  
  void cambiarEstadoManifiesto(String paramString);
}

