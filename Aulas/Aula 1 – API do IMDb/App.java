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

        // Conectando à API via HTTP em busca dos dados relacionados aos *TOP 250 FILMES*.
        String url = "https://imdb-api.com/en/API/Top250Movies/k_ompeyo46";
        URI endereco = URI.create(url);
        var cliente = HttpClient.newHttpClient();
        var solicitacao = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> resposta = cliente.send(solicitacao, BodyHandlers.ofString());
        String corpo = resposta.body();
        
        // Extraindo os dados úteis para o código atual - FILMES.
        var analisador = new JsonParser();
        List<Map<String, String>> listaDeFilmes = analisador.parse(corpo);
        
        // Processando e exibindo os dados úteis - FILMES.
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("rank"));
            System.out.println(filme.get("fullTitle"));
            System.out.println(filme.get("imDbRating"));
        }
    }
}