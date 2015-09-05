package interfaz;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Ventana extends JFrame{
	
	private Papel papel;
	private int X;
	private int Y;
	private JMenuBar miMenu;
	
	public Ventana(){
		papel = new Papel();
		papel.setLayout(null);
		papel.cargarImagen();
		miMenu = new JMenuBar();
		
		X = 1000;
		Y = 600;
		centrarVentana();
		
		
		add(papel);
		this.setJMenuBar(miMenu);
	}
	
	private void centrarVentana() {
		// TODO Auto-generated method stub
		int anchoW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int altoW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int lugarX = (anchoW / 2) - (X / 2);
		int lugarY = (altoW / 2) - (Y / 2);
		setBounds(lugarX, lugarY, X, Y);
		
		
	}
	public void setTitle(String title){
		super.setTitle(title);
	}

	public void mostrar(){
		setVisible(true);
	}
	
}
