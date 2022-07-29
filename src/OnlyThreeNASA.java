import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class OnlyThreeNASA  implements OnlyThree{

	public void OnlyThreeResults(String url) throws Exception, IOException {

		
    	ContentExtractor extrator = new ContentExtractorNASA();

    	var http = new ConnectionAPI();
        String json = http.catchData(url);
        
		List<Content> Contents = extrator.extractContent(json);
		var generator = new StickerCreatorNASA();

        for (int i = 0; i < 3; i++) {

            Content content = Contents.get(i);

            InputStream inputStream = new URL(content.getUrlImagem()).openStream();
            String nomeArquivo = content.getTitulo();

            generator.create(inputStream, nomeArquivo);

            System.out.println(content.getTitulo());
            System.out.println();
        }
	}

}
