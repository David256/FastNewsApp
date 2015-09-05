import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaz.Ventana;


public class FastNews {
	
	static Ventana ventana;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ventana = new Ventana();
		ventana.mostrar();
		ventana.setTitle("Fast News App - by David");
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.out.print("kvnsdkjvds");
				cerrar();
			}
		});
		
	}
	public static void cerrar(){
		//funcion encargada de gestionar el cierre de la aplicacion
		Object [] opciones = {"Irme", "Me arrepentí"};
		int eleccion = JOptionPane.showOptionDialog(ventana, "Realmente quieres irte de la aplicación???", "Mensaje de Fast News App",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Irme");
		if(eleccion == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	
}
