/**
 * Clase para consumir el servicio web de Libro de Direcciones.
 * 
 * Este es solo el ejemplo de ejecucion que puede ser usado en cualquier momento para testear el servicio rest.
 * 
 * @Author omargo33@gamil.com
 * @since 2023-07-23
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {

        Solicitud solicitud = new Solicitud();
        solicitud.setIndice(40024);
        solicitud.setIndiceSecundario("0102591709");
        solicitud.setIdentificacionFiscal("0102581709-001");
        solicitud.setNombre("omar");
        solicitud.setTipo("C");
        solicitud.setEstado("A");

        ConsumoLibroDirecciones consumo = new ConsumoLibroDirecciones();
        consumo.setContexto("http://172.190.64.224:28080/manifiesto-0.0.1/libroDireccion/");
        consumo.setSolicitud(solicitud);

        System.out.println(solicitud.toString());

        if (consumo.load(20000)) {
            System.out.println("Ok:");
            System.out.println("Libro direccion: " + consumo.getRespuesta().getIdLibroDireccion());
            System.out.println("Indice: " + consumo.getRespuesta().getIndice());
            System.out.println("IndiceSecundario: " + consumo.getRespuesta().getIndiceSecundario());
            System.out.println("IdentificacionFiscal: " + consumo.getRespuesta().getIdentificacionFiscal());
            System.out.println("Nombre: " + consumo.getRespuesta().getNombre());
            System.out.println("Tipo: " + consumo.getRespuesta().getTipo());
            System.out.println("Estado: " + consumo.getRespuesta().getEstado());
            System.out.println("Usuario: " + consumo.getRespuesta().getUsuario());
            System.out.println("Fecha: " + consumo.getRespuesta().getUsuarioFecha());
            System.out.println("UsuarioPrograma: " + consumo.getRespuesta().getUsuarioPrograma());

        } else {
            System.out.println("Error:");
            System.out.println("Timestamp: " + consumo.getRespuestaError().getTimestamp());
            System.out.println("Status: " + consumo.getRespuestaError().getStatus());
            System.out.println("Error: " + consumo.getRespuestaError().getError());
            System.out.println("Path: " + consumo.getRespuestaError().getPath());
        }
    }
}
