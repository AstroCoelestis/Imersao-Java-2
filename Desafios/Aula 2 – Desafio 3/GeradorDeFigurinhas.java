import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {


    public void gerador(InputStream inputStream, String nomeArquivo) throws Exception {
        // Leitura da imagem
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Criação uma nova imagem com transparência e redimensionamento (em memória)
        int altura = imagemOriginal.getHeight();
        int largura = imagemOriginal.getWidth();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
    
        // Copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte do texto
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);
    
        // Escrever uma frase na imagem (em memória)
        graphics.drawString("Top FIlmes do IMDb", 100, novaAltura - 100);
    
        // Escrever a imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
