package modelManifiesto.utilidades.estructura;/** * @author omargo33@hotmail.com */public class AerolineaUsuarioIndices {    private int idUsuario;    private int idAeropuerto;    private int idAerolinea;    public AerolineaUsuarioIndices() {        super();    }    public int getIdUsuario() {        return idUsuario;    }    public void setIdUsuario(int idUsuario) {        this.idUsuario = idUsuario;    }    public int getIdAeropuerto() {        return idAeropuerto;    }    public void setIdAeropuerto(int idAeropuerto) {        this.idAeropuerto = idAeropuerto;    }    public int getIdAerolinea() {        return idAerolinea;    }    public void setIdAerolinea(int idAerolinea) {        this.idAerolinea = idAerolinea;    }    @Override    public String toString() {        return "IdAerolinea: " + getIdAerolinea() + " IdAeropuerto: " + getIdAeropuerto() + " IdIsuario " +               getIdUsuario();    }}