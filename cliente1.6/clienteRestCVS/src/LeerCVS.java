import java.io.BufferedReader;
import java.io.FileReader;

public class LeerCVS {

    /**
     * main
     * @param path
     */
    public static void main(String[] args) {
        LeerCVS leerCVS = new LeerCVS();
        leerCVS.leerCVSFile("/home/ovelez/Descargas/test2.csv");
    }

    /**
    * metodo para leer un archivo cvs
    */
    public void leerCVSFile(String path){
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String separador = ",";
            while((linea = br.readLine())!=null){
                String[] str = linea.split(separador);
               
                Solicitud solicitud = new Solicitud();

                solicitud.setIndice(Integer.parseInt(str[0]));
                solicitud.setIndiceSecundario(str[1]);
                solicitud.setIdentificacionFiscal(str[2]);
                solicitud.setNombre(str[3]);
                solicitud.setTipo(str[4]);
                solicitud.setEstado("A");

                //System.out.println(solicitud.toString());


                ConsumoLibroDirecciones consumo = new ConsumoLibroDirecciones();
                consumo.setContexto("http://172.190.64.224:28080/manifiesto-0.0.1/libroDireccion/");
                consumo.setSolicitud(solicitud);
        
                //System.out.println(solicitud.toString());
        
                if (consumo.load(20000)) {
                   /* 
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
                    */
                } else {
                    System.out.println("Error:");
                    System.out.println("Timestamp: " + consumo.getRespuestaError().getTimestamp());
                    System.out.println("Status: " + consumo.getRespuestaError().getStatus());
                    System.out.println("Error: " + consumo.getRespuestaError().getError());
                    System.out.println("Path: " + consumo.getRespuestaError().getPath());
                    System.out.println(solicitud.toString());
                }


            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo cvs "+ e.toString());
        }
    }    
}
