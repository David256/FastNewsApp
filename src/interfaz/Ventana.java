package interfaz;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	private Papel papel;
	private int X;
	private int Y;
	
	public Ventana(){
		papel = new Papel();
		papel.setLayout(null);
		papel.cargarImagen();
		
		X = 1000;
		Y = 600;
		centrarVentana();
		
		
		add(papel);		
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
