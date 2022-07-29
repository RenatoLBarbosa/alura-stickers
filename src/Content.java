
public class Content {
	
    private String titulo;
    private String urlImagem;
    private String rating;

	public Content(String titulo, String urlImagem, String rating) {
		this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.rating = rating;
    }	

	public Content() {

	}

	public String getRating() {
		return rating;
	}

	public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
    
    @Override
    public String toString() {
        return "[Titulo: " + this.titulo + ", urlimagem: " + this.urlImagem
        		+ " rating: "+ this.rating+"]";
    }

}
