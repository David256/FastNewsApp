package interfaz;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class CajaDialogo extends JFrame{
	
	JPanel panel = new JPanel();
	JLabel titulo = new JLabel();
	JButton boton = new JButton();
	
	public CajaDialogo(){
		this.setSize(400, 500);
		titulo.setLocation(10,10);
		titulo.setForeground(Color.yellow);
		//panel.setLayout(null);
	}
	
	public void agregarCanal() {
		// TODO Auto-generated method stub
		System.out.println("[CajaDialogo][agregarCanal] esperando acciones");
		this.setTitle("Introdicor valores del nuevo canal");
		
		titulo.setText("Datos del nuevo RSS");
		panel.add(titulo);
		
			
		
		
		estilizar();
		this.add(panel);
		this.setVisible(true);
	}
	
	public void estilizar(){
		panel.setBackground(new Color(33,33,33));
		panel.setForeground(Color.white);
		
	}
	
}
