import java.util.Properties;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws Exception {
		// Acessar http a api, top 250 filmes
		// https://imdb-api.com/en/API/Top250Movies/

		LoadKey lk = new LoadKey();
		Properties prop = lk.getProp();
		String key = prop.getProperty("prop.imdbapi.key");
		String keyNasa = prop.getProperty("prop.nasaapi.key");
		// String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm" + key;
//        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o número da lista do IMDB desejada: ");
		System.out.println("1 - Top 3 filmes");
		System.out.println("2 - Filmes mais populares");
		System.out.println("3 - Top 3 séries");
		System.out.println("4 - Séries mais populares");
		System.out.println("5 - NASA - Astronomy Picture of the Day (12/06/2022 a 14/06/2022)");

		int op = sc.nextInt();
		System.out.println("Opção desejada: " + op);

//        String apiurl =  "https://imdb-api.com/en/API/";

		String url;
		OnlyThree o;

		switch (op) {
		case 1:
//        	url = apiurl +"Top250Movies/"+ key; // não usado devido a instabilidade na API
			url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
			o = new OnlyThreeIMDB();
			o.OnlyThreeResults(url);

			break;
		case 2:
			url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
			o = new OnlyThreeIMDB();
			o.OnlyThreeResults(url);

			break;
		case 3:
			url = "https://api.mocki.io/v2/549a5d8b/Top250TVs";
			o = new OnlyThreeIMDB();
			o.OnlyThreeResults(url);

			break;
		case 4:
			url = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
			o = new OnlyThreeIMDB();
			o.OnlyThreeResults(url);

			break;
		case 5:
			url = "https://api.nasa.gov/planetary/apod?api_key=" + keyNasa
					+ "&start_date=2022-06-12&end_date=2022-06-14";
			o = new OnlyThreeNASA();
			o.OnlyThreeResults(url);

			break;
		default:
			System.out.println("Valor inválido");
			sc.close();

		}

	}
}
