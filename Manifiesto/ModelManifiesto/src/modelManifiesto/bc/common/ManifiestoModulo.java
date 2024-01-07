package modelManifiesto.bc.common;

import java.util.Map;

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

    boolean isOnlyUsuarioRol(String nick, String rol, String indiceModulo);

    void errorMysql(int param, String param2);


    Map calculosPreCalificacion(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen,
                                int indiceAeropuertoDestino, int indiceAeronave, String noVuelo, String fechaInicio,
                                String fechaFin);

    Map<String, String> subirLoteArchivos(String id, String esquema, String tabla, String usuario,
                                          String usuarioPrograma);

    int excelManifiestoExtendida(int idUsuario, int indiceAerolinea, int indiceAeropuertoOrigen,
                                 int indiceAeropuertoDestino, int indiceAeronave, String noVuelo, String fechaInicio,
                                 String fechaFin, String idManifiesto, String estado, String tipoVuelo,
                                 String tipoObservacion, String tabla, String usuario, String usuarioPrograma);

    int buscarFilial(String nick);
}

