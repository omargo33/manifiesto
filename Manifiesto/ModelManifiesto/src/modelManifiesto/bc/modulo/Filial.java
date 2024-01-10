package modelManifiesto.bc.modulo;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import modelManifiesto.bc.common.ManifiestoModuloImpl;

import modelManifiesto.utilidades.estructura.AerolineaUsuarioIndices;

import oracle.jbo.JboException;

/**
 * Metodo para manejar informacion filial
 *
 * @author omargo33@hotmail.com
 *
 */
public class Filial {
    private static String SQL_ID_AEROLINEA =
        "select ifnull(sum(f.id_filial), 0) from MV_001_00.filial f where f.id_libro_direccion = (select id_libro_direccion from MV_001_00.libro_direccion where indice = ?)";

    /**
     * Metodo para buscar la Id de Filiar a partir del nick de usuario.
     *
     * @param moduloAplicacion
     * @param nick
     * @return
     */
    public static int buscarNickFilial(ManifiestoModuloImpl moduloAplicacion, String nick) {
        AerolineaUsuarioIndices aerolineaUsuarioIndices = AerolineaUsuario.buscarUsuario(moduloAplicacion, nick);
        
        List<Integer> listaRespuestas = new ArrayList<Integer>();
        ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL_ID_AEROLINEA, aerolineaUsuarioIndices.getIdAerolinea());
        
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        try {
            while (resultSet.next()) {
                listaRespuestas.add(resultSet.getInt(1));
            }
        } catch (Exception e) {
            throw new JboException("no legible");
        }

        if (listaRespuestas.size() > 0) {
            return listaRespuestas.get(0);
        }

        return 0;
    }
}
