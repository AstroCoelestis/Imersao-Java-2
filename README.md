# Imersão Java ♨️ — [Alura](https://www.alura.com.br/)

A Imersão Java é um evento gratuito oferecido pela Alura com o objetivo de desenvolver do zero a primeira aplicação em Java para começar o portifólio, proporcionar a progressão ou ampliar carreira.


### ✔ Aula 1 — **IMDb-API**

 + Nessa aula aprendemos o básico sobre como **criar uma aplicação Java** para realizar uma conexão HTTP com a **[API do IMDb](https://imdb-api.com/)** solicitando os dados dos **[250 Melhores Filmes](https://imdb-api.com/en/API/Top250Movies/)** usando uma *Key*.
 + Com *endpoint* fornecido pela API, usamos um código **[Json Parser](https://gist.github.com/alexandreaquiles/cf337d3bcb59dd790ed2b08a0a4db7a3)** para analisar-lo e retornar somente os dados necessários para essa aula.
 + Por fim, utilizamos o loop `for (Map<String,String>` para gerar uma lista contendo o **Título**, a **Imagem** e a **Classificação** dos filmes.

####  👇 Resultado da **Aula 1** — [Desafio 1](https://github.com/AstroCoelestis/Imersao-Java-2/blob/main/Resultados/Aula%201%20%E2%80%93%20Desafio%201%20%E2%80%93%20Top250TVs.png?raw=true) — [Desafio 2](https://github.com/AstroCoelestis/Imersao-Java-2/blob/main/Resultados/Aula%201%20%E2%80%93%20Desafio%202%20%E2%80%93%20Personaliza%C3%A7%C3%A3o.png?raw=true) — [Desafio 3](https://github.com/AstroCoelestis/Imersao-Java-2/blob/main/Resultados/Aula%201%20%E2%80%93%20Desafio%203%20%E2%80%93%20Arquivo%20key.png?raw=true)
![](../../blob/main/Resultados/Aula%201.png)

### ✔ Aula 2 — **Figurinhas**
 + Criando uma nova **Java Class** no projeto, construímos na aula de hoje um cógido **Gerador de Figurinhas**.
 + Aprendemos a usar o `InputStream` para obter os dados de uma imagem via arquivo e posteriormente via URL - fornecida pela API do IMDb.
 + Com a imagem na *memória*, utilizamos `Grpahics2D`para manipular a imagem, extendendo-a com um pequeno fundo transparente e adicionamos um texto à ela.
 + Após isso, usamos a aplicação App.java da **Aula 1** para rodar o código do Gerador de Figurinhas, adicionando o nome do filme como nome do arquivo de imagem.
 
#### Resultado do **Aula 2**
![](../../blob/main/Resultados/Aula%202.png?raw=true)


