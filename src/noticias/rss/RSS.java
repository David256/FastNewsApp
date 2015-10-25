package noticias.rss;


import java.io.BufferedReader;
import java.io.File;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |

public class RSS {
	
	public void cargarURL(Canal canal){
		String sUrl = canal.getUrl();
		String dato = "";
		
		// dale
		if(dato!=""){
			cargarXML(dato);
		}else{
			System.err.println("Error, no puedo leer el archivos");
		}
		
	}

	private void cargarXML(String dato) {
		//funcion encargada de leer el xml
		
		
	}

	public void starter() {
		// TODO Auto-generated method stub		
	}

}
