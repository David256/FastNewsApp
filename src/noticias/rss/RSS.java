package noticias.rss;


import java.io.BufferedReader;
import java.io.File;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import noticias.conexion.Conexion;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |

public class RSS {
	Conexion job = new Conexion();
	
	public String cargarURL(Canal canal){
		String sUrl = canal.getUrl();
		
		String dato = "";
		dato = job.cargarURL(sUrl);
		
		if(dato != ""){
			return cargarXML(dato);
		}else{
			System.err.println("Error, no puedo leer el archivos");
		}
		return "";
		
	}

	private String cargarXML(String dato) {
		//funcion encargada de leer el xml
		SAXBuilder builder = new SAXBuilder();
		
		System.out.println("---[[[");
		
		String paquete = "";
		
		try{
			// se obtiene el documento a partir del archivos
			Document document = (Document) builder.build(dato);
			//se obtiene la raiz de nodos
			Element rootNode = document.getRootElement();
			//se obtiene la lista de nodos de la raiz
			List list = rootNode.getChildren("channel");
			System.out.println("No. canales: " + list.size());
			//podia seguir el tutorial, pero voy a hacerlo solo
			
			Element elCanal = (Element) list.get(0);
			String titulo = elCanal.getChildText("title");
			String descripcion = elCanal.getChildText("description");
			String link = elCanal.getChildText("link");
			
			paquete = paquete + titulo + ":\n" + "(" + descripcion + " -" + link + " -)"; //guardamos en paquete
			
			System.out.println("titulo: " + titulo);
			System.out.println("link: " + link);
			System.out.println("descripcion: " + descripcion);
			
			List listItem = elCanal.getChildren("item");
			System.out.println("Hay items: " + listItem.size());
			
			paquete = paquete + "\n" + "<" + listItem.size() + ">"; //volvemos a guardar en paquete
			
			String salidas = "";
			
			for (int i=0; i<listItem.size(); i++){
				Element items = (Element) listItem.get(i);
				String ti = items.getChildText("title");
				String des = items.getChildText("description");
				String lnk = items.getChildText("link");
				salidas = salidas + "__________________________________________________________";
				salidas = salidas + "[+] "+ti;
				salidas = salidas + "(Más info: "+lnk + ")";
				salidas = salidas + "\n"+des;
				salidas = salidas + "<----------------------------------------\n";
			}
			paquete = paquete + salidas; //guardamos toda la salida
			
			System.out.println("[RSS][Conexion] buscando datos de url");
						
			System.out.println("]]]---");
			return paquete;
			
		}catch(Exception e){
			System.err.println("Error, Por tal motivo no puedo leer XML: " + e.toString());
		}
		
		///////////////////////////////////////////////////////////
		System.out.println("]]]---");
		return "";
	}

	public void starter() {
		// TODO Terminar clase RSS		
	}

}
