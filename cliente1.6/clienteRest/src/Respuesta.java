//TODO: poner el paquete
/**
 * Respuesta para el JSON
 * 
 * {
 * "idLibroDireccion": 320,
 * "indice": 40023,
 * "indiceSecundario": "skck123456123123123",
 * "identificacionFiscal": "otro nombre raro",
 * "nombre": "super test",
 * "tipo": "AR",
 * "estado": "A",
 * "usuario": "none",
 * "usuarioFecha": "2023-07-23T16:51:41.104+00:00",
 * "usuarioPrograma": "Manifiesto"
 * }
 * 
 * @author omargo33@gmail.com
 * @since 2023-07-23
 */
public class Respuesta {

    int idLibroDireccion;
    int indice;
    String indiceSecundario;
    String identificacionFiscal;
    String nombre;
    String tipo;
    String estado;
    String usuario;
    String usuarioFecha;
    String usuarioPrograma;

    public Respuesta(int idLibroDireccion, int indice, String indiceSecundario, String identificacionFiscal,
            String nombre, String tipo, String estado, String usuario, String usuarioFecha, String usuarioPrograma) {
        this.idLibroDireccion = idLibroDireccion;
        this.indice = indice;
        this.indiceSecundario = indiceSecundario;
        this.identificacionFiscal = identificacionFiscal;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.usuario = usuario;
        this.usuarioFecha = usuarioFecha;
        this.usuarioPrograma = usuarioPrograma;
    }

    public Respuesta() {
        // Datos por defecto
        this.idLibroDireccion = 320;
        this.indice = 40023;
        this.indiceSecundario = "";
        this.identificacionFiscal = "";
        this.nombre = "";
        this.tipo = "";
        this.estado = "";
        this.usuario = "";
        this.usuarioFecha = "";
        this.usuarioPrograma = "";
    }

    public int getIdLibroDireccion() {
        return idLibroDireccion;
    }

    public void setIdLibroDireccion(int idLibroDireccion) {
        this.idLibroDireccion = idLibroDireccion;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getIndiceSecundario() {
        return indiceSecundario;
    }

    public void setIndiceSecundario(String indiceSecundario) {
        this.indiceSecundario = indiceSecundario;
    }

    public String getIdentificacionFiscal() {
        return identificacionFiscal;
    }

    public void setIdentificacionFiscal(String identificacionFiscal) {
        this.identificacionFiscal = identificacionFiscal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioFecha() {
        return usuarioFecha;
    }

    public void setUsuarioFecha(String usuarioFecha) {
        this.usuarioFecha = usuarioFecha;
    }

    public String getUsuarioPrograma() {
        return usuarioPrograma;
    }

    public void setUsuarioPrograma(String usuarioPrograma) {
        this.usuarioPrograma = usuarioPrograma;
    }

    /**
     * Lee un JSON y asigna los valores a los atributos de la clase
     * 
     * @param json
     */
    public void leerJSON(String json) {
        json = json.replace("{", "");
        json = json.replace("}", "");
        json = json.replace(",", ", ");
        json = json.replace("\"", " ");
        String[] jsonSplit = json.split(",");
        for (int i = 0; i < jsonSplit.length; i++) {

            jsonSplit[i] = jsonSplit[i].replaceFirst(":", "#");
            String[] jsonSplit2 = jsonSplit[i].split("#");

            if (jsonSplit2[0].trim().compareTo("idLibroDireccion") == 0) {
                this.idLibroDireccion = Integer.parseInt(jsonSplit2[1].trim());
            }
            if (jsonSplit2[0].trim().compareTo("indice") == 0) {
                this.indice = Integer.parseInt(jsonSplit2[1].trim());
            }
            if (jsonSplit2[0].trim().compareTo("indiceSecundario") == 0) {
                this.indiceSecundario = jsonSplit2[1].trim();
            }
            if (jsonSplit2[0].trim().compareTo("identificacionFiscal") == 0) {
                this.identificacionFiscal = jsonSplit2[1].trim();
            }
            if (jsonSplit2[0].trim().compareTo("nombre") == 0) {
                this.nombre = jsonSplit2[1].trim();
            }
            if (jsonSplit2[0].trim().compareTo("tipo") == 0) {
                this.tipo = jsonSplit2[1].trim();
            }
            if (jsonSplit2[0].trim().compareTo("estado") == 0) {
                this.estado = jsonSplit2[1].trim();
            }
            if (jsonSplit2[0].trim().compareTo("usuario") == 0) {
                this.usuario = jsonSplit2[1].trim();
            }
            if (jsonSplit2[0].trim().compareTo("usuarioFecha") == 0) {
                this.usuarioFecha = jsonSplit2[1].trim();
            }
            if (jsonSplit2[0].trim().compareTo("usuarioPrograma") == 0) {
                this.usuarioPrograma = jsonSplit2[1].trim();
            }
        }
    }

    @Override
    public String toString() {
        return "Respuesta: \n" +
                "idLibroDireccion: " + this.idLibroDireccion + "\n" +
                "indice: " + this.indice + "\n" +
                "indiceSecundario: " + this.indiceSecundario + "\n" +
                "identificacionFiscal: " + this.identificacionFiscal + "\n" +
                "nombre: " + this.nombre + "\n" +
                "tipo: " + this.tipo + "\n" +
                "estado: " + this.estado + "\n" +
                "usuario: " + this.usuario + "\n" +
                "usuarioFecha: " + this.usuarioFecha + "\n" +
                "usuarioPrograma: " + this.usuarioPrograma + "\n";
    }
}
