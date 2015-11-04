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
			System.out.println("[Conexion][Starting] desde el mismisimo Needer se llama a Internet >:0 ");
			URL url = new URL(sUrl);
			InputStreamReader isReader = new InputStreamReader(url.openStream());
			BufferedReader bReader = new BufferedReader(isReader);
			StringBuffer buffer = new StringBuffer();
			
			String linealURL = "";
			
			while((linealURL = bReader.readLine()) != null){
				buffer.append(linealURL);
			}
			bReader.close();
			isReader.close();
			
			dato = buffer.toString();
			
			System.out.println("[URL:] -> "+sUrl);
			System.out.println("Leído: "+dato);
			
		}catch (MalformedURLException e) {
	        e.printStackTrace();
		}catch (IOException e) {
	        e.printStackTrace();	
		}catch(Exception e){
			System.out.println("Error desconocido ** : " + e.toString());
		}
		
		return dato;
	}
}
