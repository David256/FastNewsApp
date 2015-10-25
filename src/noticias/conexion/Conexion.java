package noticias.conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Conexion {
	public String cargarURL(String sUrl){
		String dato="";
		
		try{
			//abrimos conexion
			URL url = new URL(sUrl);
			URLConnection conexion = url.openConnection();
			conexion.connect();
			
			//leemos el contenido
			InputStream is = conexion.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			char[] buffer = new char[1000];
			int leido;
			while((leido = br.read(buffer)) > 0){
				dato = dato + leido;
			}
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
	        e.printStackTrace();
		}catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();	
		}catch(Exception e){
			System.out.println("Error desconocido ** : " + e.toString());
		}
		
		return dato;
	}
}
