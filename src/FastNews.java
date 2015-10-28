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

import Canaletas.Canales;

//clase necesaria para ejecutar el progama
public class FastNews {
	
	static Ventana ventana;
	static RSS rr;
	 
	
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
		try {
			Canales.cargar();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		rr.cargarURL((Canales.dar()));
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
