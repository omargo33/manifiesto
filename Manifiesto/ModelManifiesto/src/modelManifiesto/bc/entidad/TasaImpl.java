package modelManifiesto.bc.entidad;

import model.bc.Entidad;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Mar 14 01:40:11 ECT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TasaImpl extends Entidad {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdTasa,
        Nombre,
        Tasa,
        Timbre,
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
    public static final int IDTASA = AttributesEnum.IdTasa.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int TASA = AttributesEnum.Tasa.index();
    public static final int TIMBRE = AttributesEnum.Timbre.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TasaImpl() {
        super();
    }

    /**
     * @param idTasa key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer idTasa) {
        return new Key(new Object[] { idTasa });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("modelManifiesto.bc.entidad.Tasa");
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
            setAttribute(IDTASA, getUltimoId());
        
    }
}

