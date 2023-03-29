// Luiz Lucas FL --- @AstroCoelestis#7125.
import java.io.FileReader;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class App {
    public static void main(String[] args) throws Exception {
        // Obtendo a key da API no arquivo key.properties
        FileReader leitor = new FileReader("key.properties");  
        Properties leitorKey = new Properties();  
        leitorKey.load(leitor);  
        String imdbKey = leitorKey.getProperty("key");


        // Conectando à API via HTTP em busca dos dados relacionados aos *TOP 250 FILMES*.
        String url = "https://imdb-api.com/en/API/Top250Movies/" + imdbKey;
        URI endereco = URI.create(url);
        var cliente = HttpClient.newHttpClient();
        var solicitacao = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> resposta = cliente.send(solicitacao, BodyHandlers.ofString());
        String corpo = resposta.body();
        

        // Extraindo os dados úteis para o código atual - FILMES.
        var analisador = new JsonParser();
        List<Map<String, String>> listaDeFilmes = analisador.parse(corpo);
        
        
        // Processando e exibindo os dados úteis - FILMES.
        var figurinha = new GeradorDeFigurinhas();
        for (int i = 0; i <5; i++) {
            Map<String, String> filme = listaDeFilmes.get(i);

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";
            figurinha.gerador(inputStream, nomeArquivo);

            System.out.print("\u001b[1mClassificação:\u001b[m " + "\u001b[30;1m\u001b[47;1m " + filme.get("rank") + " \u001b[m");
            System.out.print("  —  ");
            System.out.print("\u001b[1mTítulo:\u001b[m " + "\u001b[30;1m\u001b[47;1m " + titulo + " \u001b[m");
            System.out.print("  —  ");
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int numeroEstrelinhas = (int) classificacao;
            for (int n = 1; n <= numeroEstrelinhas; n++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }
    }
}