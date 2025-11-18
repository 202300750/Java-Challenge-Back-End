import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ServicioCambio {

    private static final String API_KEY = "4a27cda222a481705e089580";
    private static final String URL_API =
            "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Solo obtiene la tasa
    public double obtenerTasa(String monedaBase, String monedaDestino) {
        try {
            URL url = new URL(URL_API + monedaBase);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder respuesta = new StringBuilder();
            while (scanner.hasNext()) {
                respuesta.append(scanner.nextLine());
            }
            scanner.close();

            JsonObject json = JsonParser.parseString(respuesta.toString()).getAsJsonObject();
            JsonObject tasas = json.getAsJsonObject("conversion_rates");

            return tasas.get(monedaDestino).getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al obtener tasa: " + e.getMessage());
            return 0;
        }
    }

    // Convierte usando la tasa
    public double convertir(String monedaBase, String monedaDestino, double monto) {
        double tasa = obtenerTasa(monedaBase, monedaDestino);
        return monto * tasa;
    }
}

