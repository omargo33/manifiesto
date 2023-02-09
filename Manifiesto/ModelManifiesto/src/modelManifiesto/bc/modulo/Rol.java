package modelManifiesto.bc.modulo;


import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import model.bc.ModuloImpl;

import oracle.jbo.JboException;

/**
 * Metodo para manejar informacion del rol de forma interna
 *
 * @author omargo33@hotmail.com
 *
 */
public class Rol {
 
    private static String SQL_ROLES_POR_USUARIO =
        "SELECT r.tipo from GS_001_00.usuario u, GS_001_00.rol_usuario ru, GS_001_00.rol r, GS_001_00.permiso p, GS_001_00.menu m, GS_001_00.modulo m2 where r.id_rol = ru.id_rol and ru.id_usuario = u.id_usuario and p.id_rol = r.id_rol and p.id_menu = m.id_menu and m.id_modulo = m2.id_modulo and upper(u.nick) = upper(?) and upper(m2.indice) = upper(?) GROUP by r.tipo";

    /**
     * Metodo para validar que un usuario tenga un unico rol para un modulo especifico.
     *
     * @param moduloAplicacion
     * @param indiceModulo
     * @param nick
     * @return
     */
    public static boolean validarRolPorModulo(ModuloImpl moduloAplicacion, String indiceModulo, String rol,
                                              String nick) {  
        System.out.println("solicitud local!!");
        
        List<String> listaRespuestas = new ArrayList<String>();
        ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL_ROLES_POR_USUARIO, nick, indiceModulo);
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        try {
            while (resultSet.next()) {
                listaRespuestas.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            throw new JboException("no legible");
        }

        if (listaRespuestas.size() == 1) {
            if (listaRespuestas.get(0).compareToIgnoreCase(rol) == 0) {                
                return true;
            }
        }        
        return false;
    }
}