package modelManifiesto.bc.entidad;

import model.bc.Entidad;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Feb 18 00:53:11 ECT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InformacionImpl extends Entidad {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdInformacion,
        Nombre,
        Valor01,
        Valor02,
        Usuario,
        UsuarioFecha,
        UsuarioPrograma;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int IDINFORMACION = AttributesEnum.IdInformacion.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int VALOR01 = AttributesEnum.Valor01.index();
    public static final int VALOR02 = AttributesEnum.Valor02.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();

    /**
     * This is the default constructor (do not remove).
     */
    public InformacionImpl() {
        super();
    }

    /**
     * @param idInformacion key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer idInformacion) {
        return new Key(new Object[] { idInformacion });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("modelManifiesto.bc.entidad.Informacion");
    }


    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
        //Id refresh
        if (operation == DML_INSERT)
            setAttribute(IDINFORMACION, getUltimoId());
    }
}

