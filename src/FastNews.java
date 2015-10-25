import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaz.Ventana;
import noticias.rss.*;

import org.xml.*;

//clase necesaria para ejecutar el progama
public class FastNews {
	
	static Ventana ventana;
	static RSS rr;
	private static Vector canales;
	static String SutaDato = "/predata/fileObjectRSS.obj"; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ventana = new Ventana(); //este objeto maneja la ventana
		ventana.mostrar();
		ventana.setTitle("Fast News App - by David");
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter(){
			//manejamos el evento de darle click al boton cerrar
			@Override
			public void windowClosing(WindowEvent e){
				cerrar();
			}
		});
		//cargamos los rss del archivo de rss llamado 
		try{
			canales = cargaLocales();
		}catch(Exception e){
			//error, por algo
			System.err.println("Error al cargar locales");
		}
	}
	
	private static Vector cargaLocales() throws ClassNotFoundException, IOException {
		Vector unVector = null;
		File file = new File(SutaDato);
		if(file.exists()){
			ObjectInputStream ois = null;
			try{
				FileInputStream fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				//vamos a cargar
				while(true){
					Canal unCanal = (Canal) ois.readObject();
					unVector.addElement(unCanal);
					//listo
				}
			}catch(IOException io){
				
			}finally{
				ois.close();
			}
			System.out.println("[CargarLocales][UP] cargamos y retornamos valores");
			return unVector;
		}else{
			//archivo no existe
			System.out.println("[CargarLocales][DOWN] no se puede cargar, no existe");
			return null;
		}
	}
	
	public static void cerrar(){
		//funcion encargada de gestionar el cierre de la aplicacion y control

		Object [] opciones = {"Irse", "Me arrepentí"};
		int eleccion = JOptionPane.showOptionDialog(ventana, "Realmente quieres irte de la aplicación???", "Mensaje de Fast News App",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Irse");
		if(eleccion == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}

}
