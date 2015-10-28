package Canaletas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import noticias.rss.Canal;

public class Canales {
	private static Vector<Canal> listCanales=null;
	private static String SutaDato = "/predata/fileObjectRSS.obj";
	
	public static void cargar() throws IOException, ClassNotFoundException {
		File file = new File(SutaDato);
		if(file.exists()){
			ObjectInputStream ois = null;
			try{
				FileInputStream fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				//vamos a cargar
				while(true){
					Canal unCanal = (Canal) ois.readObject();
					listCanales.addElement(unCanal);
					//listo
				}
			}catch(IOException io){
				
			}finally{
				ois.close();
			}
			System.out.println("[Canaletas][Cargar][UP] cargamos y retornamos valores");
		}else{
			//archivo no existe
			System.out.println("[CargarLocales][DOWN] no se puede cargar, no existe");
		}
	}
	public static Canal dar() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void agregarRSS(String url, String titulo) {
		// TODO Auto-generated method stub
		Canal canal = new Canal(url, titulo);
		listCanales.add(canal);
		System.out.println("[Canales][agregarRSS] se agrego la Url y el Titulo.");
	}
}
