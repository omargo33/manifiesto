package modelManifiesto.bc.modulo;

import modelManifiesto.bc.common.ManifiestoModuloImpl;
import modelManifiesto.bc.vista.AerolineaUsuarioViewRowImpl;
import modelManifiesto.bc.vistaNoDML.UsuarioViewNoDMLRowImpl;

import modelManifiesto.utilidades.estructura.AerolineaUsuarioIndices;

import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewObject;

/**
 * Metodo para crear un objeto de Aerolinea de Usuario.
 *
 * @author omargo33@hotmail.com
 */
public class AerolineaUsuario {
    
    /**
     * Metodo para consultar los datos de usuario, aerolinea y aeropuerto.
     *
     * @param manifiestoModulo
     * @param nick
     * @return
     */
    public static AerolineaUsuarioIndices buscarUsuario(ManifiestoModuloImpl manifiestoModulo, String nick) {
        AerolineaUsuarioIndices aerolineaUsuarioIndices = new AerolineaUsuarioIndices();
        ViewObject vo = manifiestoModulo.getUsuarioViewNoDML1();
        ViewCriteriaManager vcm = vo.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("UsuarioViewNoDMLCriteria");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_Nick", nick);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
        while (vo.hasNext()) {
            Row r = vo.next();
            aerolineaUsuarioIndices.setIdUsuario((Integer) r.getAttribute(UsuarioViewNoDMLRowImpl.IDUSUARIO));
        }

        if (aerolineaUsuarioIndices.getIdUsuario() != 0) {
            ViewObject vo1 = manifiestoModulo.getAerolineaUsuarioView2();
            ViewCriteriaManager vcm1 = vo1.getViewCriteriaManager();
            ViewCriteria vc1 = vcm1.getViewCriteria("AerolineaUsuarioViewCriteriaByIdUsuario");
            VariableValueManager vvm1 = vc1.ensureVariableManager();
            vvm1.setVariableValue("v_IdUsuario", aerolineaUsuarioIndices.getIdUsuario());
            vo1.applyViewCriteria(vc1);
            vo1.executeQuery();
            while (vo1.hasNext()) {
                Row r = vo1.next();                
                aerolineaUsuarioIndices.setIdAerolinea((Integer) r.getAttribute(AerolineaUsuarioViewRowImpl.IDLIBRODIRECCIONAEROLINEA));
                aerolineaUsuarioIndices.setIdAeropuerto((Integer) r.getAttribute(AerolineaUsuarioViewRowImpl.IDLIBRODIRECCIONAEROPUERTO));
            }
        }
        return aerolineaUsuarioIndices;
    }


}
