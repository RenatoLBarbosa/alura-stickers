import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorIMDB implements ContentExtractor {

	static List<Content> Contents = new ArrayList<>();
	String titulo;
	String rating;
	String urlImagem;
	Content objContent;
	
	public  static List<Content> getContents() {
		return Contents;
	}

	public void setContents(List<Content> contents) {
		Contents = contents;
	}
	
	public void addString(String titulo, String urlImagem, String rating) {

		System.out.println("get contents do add: "+getContents());
		Contents.add(new Content(this.titulo, this.urlImagem, this.rating));
		System.out.println("Contents: "+getContents());
	}

	


	public List<Content> extractContent(String json) {
        
		var parser = new JsonParser();
        List<Map<String, String>> ListAtt = parser.parse(json);

        for (Map<String, String> atributos : ListAtt) {
           titulo = atributos.get("title");
//           String urlImagem = atributos.get("image")
//                   .replaceAll("(@+)(.*).jpg$", "$1.jpg"); // Não utilizado devido a instabilidades na API IMDB
           rating = atributos.get("imDbRating");
           //Utilizado imagem unica para fins de estudo e instabilidade da API IMDB
           urlImagem = "https://imdb-api.com/images/original/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.6716_AL_.jpg";
           addString(titulo, urlImagem, rating);
        }
        
        System.out.println("TESTE CONTENT get msm metodo: "+getContents().size());

        return getContents();
   }

	public String getRatings(int i) {
		return Contents.get(i).getRating();
	}

}
