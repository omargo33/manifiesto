package modelManifiesto.bc.vistaNoDML;import model.bc.VistaObjeto;import modelManifiesto.bc.vistaNoDML.common.UsuarioAsignadoViewNoDML;import oracle.jbo.VariableValueManager;import oracle.jbo.ViewCriteria;// ---------------------------------------------------------------------// ---    File generated by Oracle ADF Business Components Design Time.// ---    Sun Mar 13 23:10:10 ECT 2022// ---    Custom code may be added to this class.// ---    Warning: Do not modify method signatures of generated methods.// ---------------------------------------------------------------------public class UsuarioAsignadoViewNoDMLImpl extends VistaObjeto implements UsuarioAsignadoViewNoDML {    /**     * This is the default constructor (do not remove).     */    public UsuarioAsignadoViewNoDMLImpl() {        super();    }    /**     * Metodo para ejecutar por idUsuario.     *     * @param idUsuario     */    public void ejecutarByIndice(int idUsuario) {        /*int idUsuarioInteger = 0;        if (idUsuario != null) {            try {                idUsuarioInteger = Integer.parseInt(idUsuario);            } catch (Exception e) {                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "convert error=" + e.toString());                idUsuarioInteger = 0;            }        }*/        ViewCriteria vc = this.getViewCriteriaManager().getViewCriteria("UsuarioAsignadoViewNoDMLCriteriaByIdUsuario");        VariableValueManager vvm = vc.ensureVariableManager();        //vvm.setVariableValue("v_IdUsuario", idUsuarioInteger);        vvm.setVariableValue("v_IdUsuario", idUsuario);        this.applyViewCriteria(vc, false);        this.executeQuery();        this.setApplyViewCriteriaName(null);    }}