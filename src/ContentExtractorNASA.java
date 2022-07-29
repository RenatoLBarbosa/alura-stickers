import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorNASA  implements ContentExtractor {

    public List<Content> extractContent(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listAtt = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listAtt) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            String rating = "";
            
            var content = new Content(titulo, urlImagem, rating);

            contents.add(content);
        }

        return contents;
    }
}