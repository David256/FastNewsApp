//esta será una clase de datos, eso espero


public class Canal {
	private String url;
	private String titulo;
	
	//metodos constructores
	public Canal(){
		this.url = "";
		this.titulo = "";
	}
	//con un argv
	public Canal(String url){
		this.url = url;
		this.titulo = "";
	}
	//con dos argv
	public Canal(String url, String titulo){
		this.url = url;
		this.titulo = titulo;
	}
	
	
	
}
