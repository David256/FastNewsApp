package noticias.rss;

import java.io.Serializable;

//esta será una clase de datos, eso espero


public class Canal implements Serializable{
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
	
	public void setUrl(String url){
		this.url = url;
	}
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public String getUrl(){
		return this.url;
	}
	public String getTitulo(){
		return this.titulo;
	}
	
}
