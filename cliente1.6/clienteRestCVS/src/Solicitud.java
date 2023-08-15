
//TODO: poner el paquete
/**
 * Solicitud para el JSON
 * {
 * "indice": 40023,
 * "indiceSecundario": "skck123456123123123",
 * "identificacionFiscal": "otro nombre raro",
 * "nombre": "super test",
 * "tipo": "AR",
 * "estado": "A"
 * }
 * 
 * @author omargo33@gmail.com
 * @since 2023-07-23
 * 
 */
public class Solicitud {

    int indice;
    String indiceSecundario;
    String identificacionFiscal;
    String nombre;
    String tipo;
    String estado;

    public Solicitud(int indice, String indiceSecundario, String identificacionFiscal, String nombre, String tipo,
            String estado) {
        this.indice = indice;
        this.indiceSecundario = indiceSecundario;
        this.identificacionFiscal = identificacionFiscal;
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Solicitud() {
        // Datos por defecto
        this.indice = 40023;
        this.indiceSecundario = "";
        this.identificacionFiscal = "";
        this.nombre = "";
        this.tipo = "";
        this.estado = "";
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

    public String generarJSON() {
        return "{\n" +
                "\"indice\": " + indice + ",\n" +
                "\"indiceSecundario\": \"" + indiceSecundario + "\",\n" +
                "\"identificacionFiscal\": \"" + identificacionFiscal + "\",\n" +
                "\"nombre\": \"" + nombre + "\",\n" +
                "\"tipo\": \"" + tipo + "\",\n" +
                "\"estado\": \"" + estado + "\"\n" +
                "}";
    }

    @Override
    public String toString() {
        return "Solicitud: \n" +
                "indice: " + indice + "\n" +
                "indiceSecundario: " + indiceSecundario + "\n" +
                "identificacionFiscal: " + identificacionFiscal + "\n" +
                "nombre: " + nombre + "\n" +
                "tipo: " + tipo + "\n" +
                "estado: " + estado + "\n";
    }
}
