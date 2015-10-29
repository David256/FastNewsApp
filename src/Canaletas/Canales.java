package Canaletas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import noticias.rss.Canal;

public class Canales {
	
	private static Vector<Canal> listCanales=new Vector();
	private static String SutaDato = "/predata/fileObjectRSS.obj";
	static int semilla = 0;
	public static Canal seleccionadoPorLista;
	
	
	public static void cargar() throws IOException, ClassNotFoundException {
		//carga desde archivos a vector
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
				System.err.println("[Canales][Cargar] ya no puedo leer más objetos");
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
		//da el ultimo valor
		if(listCanales.size()>0){
			return listCanales.lastElement();
		}
		return null;
	}
	public static void agregarRSS(String url, String titulo) {
		Canal tube = new Canal(url, titulo);
		System.out.println("[Canales][agregarRSS][toString] "+tube);
		listCanales.add(tube);
		System.out.println("[Canales][agregarRSS] se agrego la Url y el Titulo.");
		//agregamos a la lista del archivo
		//guardarRSS(url, titulo); no vamos a guardar hasta luego
	}
	private static void guardarRSS(String url, String titulo) {
		// Guarda el RSS en el archivo
		try {
			File saver = new File(SutaDato);
			saver.createNewFile();
			if(!(saver.canWrite() || saver.canRead())){
				System.err.println("Error, no puedo guardar o escribir");
			}
			//ahorramos codigo pero aumentamos la dificiltad		
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(saver));
			salida.writeObject(new Canal(url, titulo));
			
		} catch (FileNotFoundException e) {
			System.err.println("Error al intentar abrir el archivo donde se guardan los objetos Canal");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error al asociar el archivo abierto de objetos con una clase de escritura");
			e.printStackTrace();
		}
	}
	
	public static Canal sembrar(){
		if(semilla++ <= listCanales.size()){
			semilla = semilla + 1;
			return listCanales.get(semilla);
		}
		return null;
	}
	public static void setGen(int valor){
		semilla = valor;
	}
	public static int getGen(){
		return semilla;
	}
	public static Vector<Canal> getVector(){
		return listCanales;
	}
	public static String[] getVectorAsArray(){
		String []buffered = new String[listCanales.size()];
		
		for(int i=0; i< listCanales.size(); i++){
			buffered[i] = listCanales.get(i).getTitulo();
		}
		return buffered;
	}
}
