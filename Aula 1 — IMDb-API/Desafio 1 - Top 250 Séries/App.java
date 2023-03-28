// Luiz Lucas FL --- @AstroCoelestis#7125.
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        // Conectando à API via HTTP em busca dos dados relacionados aos *TOP 250 SÉRIES*.
        String url = "https://imdb-api.com/en/API/Top250TVs/k_ompeyo46";
        URI endereco = URI.create(url);
        var cliente = HttpClient.newHttpClient();
        var solicitacao = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> resposta = cliente.send(solicitacao, BodyHandlers.ofString());
        String corpo = resposta.body();
        
        // Extraindo os dados úteis para o código atual - SÉRIES.
        var analisador = new JsonParser();
        List<Map<String, String>> listaDeSeries = analisador.parse(corpo);
        
        // Processando e exibindo os dados úteis - SÉRIES.
        for (int i = 0; i < 3; i++) {
            Map<String, String> serie = listaDeSeries.get(i);
            System.out.println(serie.get("rank"));
            System.out.println(serie.get("fullTitle"));
            System.out.println(serie.get("imDbRating"));
        }
    }
}