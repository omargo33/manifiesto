//TODO: poner el paquete
/**
 * Respuesta para el JSON
 {
    "timestamp": "2023-07-23T16:58:41.603+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/manifiesto-0.0.1/libroDireccion/"
 }
 *
 * @author omargo33@gmail.com
 * @since 2023-07-23
  * 
 */
public class RespuestaError {

    String timestamp;
    int status;
    String error;
    String path;

    public RespuestaError(String timestamp, int status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public RespuestaError() {
        // datos por defecto
        this.timestamp = "2021-05-01T00:00:00.000+00:00";
        this.status = 404;
        this.error = "Not Found";
        this.path = "/api/usuarios";
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Lee un JSON y asigna los valores a los atributos de la clase
     * 
     * @param json
     */
    public void leerJSON(String json) {
        json=json.replace("{", "");
        json=json.replace("}", "");
        json=json.replace(",", ", ");
        json=json.replace("\"", " ");

        String[] jsonSplit = json.split(",");
        for (int i = 0; i < jsonSplit.length; i++) {

            jsonSplit[i] = jsonSplit[i].replaceFirst(":", "#");
            String[] jsonSplit2 = jsonSplit[i].split("#");
            
            if (jsonSplit2[0].trim().compareTo("timestamp") == 0) {
                this.timestamp = jsonSplit2[1].trim();
            }

            if (jsonSplit2[0].trim().compareTo("status") == 0) {
                this.status = Integer.parseInt(jsonSplit2[1].trim());
            }

            if (jsonSplit2[0].trim().compareTo("error") == 0) {
                this.error = jsonSplit2[1].trim();
            }

            if (jsonSplit2[0].trim().compareTo("path") == 0) {
                this.path = jsonSplit2[1].trim();
            }          
        }
    }

    @Override
    public String toString(){
        return "Respuesta: \n" +
        "timestamp: " + this.timestamp + "\n" +
        "status: " + this.status + "\n" +
        "error: " + this.error + "\n" +
        "path: " + this.path + "\n";
    }
}
