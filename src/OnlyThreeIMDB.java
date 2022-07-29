import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class OnlyThreeIMDB  implements OnlyThree{

	ContentExtractor extrator = new ContentExtractorIMDB();
	String json;
	List<Content> Contents;
	
	public void OnlyThreeResults(String url) throws Exception, Exception  {
		
    	var http = new ConnectionAPI();
        json = http.catchData(url);
        
        Contents = extrator.extractContent(json);

        IncludeRating();

	}
	
	public void IncludeRating() throws Exception, IOException{
	
		var generator = new StickerCreatorIMDB();
	
		for (int i = 0; i < 3; i++) {
			ContentExtractorIMDB extractor = new ContentExtractorIMDB();
			Content content = Contents.get(i);
			extractor.getRatings(i);
			InputStream inputStream = new URL(content.getUrlImagem()).openStream();
			String nomeArquivo = content.getTitulo();

			generator.create(inputStream, nomeArquivo, i);

			System.out.println(content.getTitulo());
			System.out.println();
		}
	}

}
