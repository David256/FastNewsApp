package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CajaDialogo extends JFrame{
	
	JPanel panel = new JPanel();
	JLabel titulo = new JLabel();
	JButton boton = new JButton();
	
	public CajaDialogo(){
		this.setSize(400, 500);
		titulo.setBounds(10 , 10 , 300, 25);
		titulo.setForeground(Color.yellow);
		panel.setLayout(null);
	}
	
	//funcion que agrega canales
	public void agregarCanal() {
		this.setSize(400, 300);
		
		//creamos objetos necesarios
		JButton agregar = new JButton("Agregar");
		agregar.setBackground(new Color(100,100,100));
		agregar.setForeground(Color.white);
		agregar.setBounds(125, 220, 100, 30); //corregir esto
		
		//agregamos campos de entrada de URL, titulo personalizado, y por ahora ya
		JLabel lblUrl = new JLabel("URL: ");
		JLabel lblTitulo = new JLabel("titulo: ");
		lblUrl.setBounds(10, 50, 100, 30);
		lblUrl.setFont(new Font("Arial", Font.BOLD, 15));
		lblUrl.setForeground(Color.WHITE);
		
		lblTitulo.setBounds(10, 90, 100, 30);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));

		//Agregamos los cammpo para que escriba el contenido
		JTextField textUrl = new JTextField("http://");
		JTextField textTitulo = new JTextField("<titulo personalizado>");
		textUrl.setBounds(80, 50, 280, 25);
		textTitulo.setBounds(80, 90, 280, 25);
		
		System.out.println("[CajaDialogo][agregarCanal] esperando acciones");
		this.setTitle("Introdicor valores del nuevo canal");
		
		titulo.setText("Datos del nuevo RSS");
		panel.add(agregar);
		panel.add(titulo);
		panel.add(lblUrl);
		panel.add(lblTitulo);
		panel.add(textTitulo);
		panel.add(textUrl);
				
		estilizar();
		this.add(panel);
		this.setVisible(true);
	}
	
	//funcion que pone bonito todo, lo que puede
	public void estilizar(){
		panel.setBackground(new Color(33,33,33));
		panel.setForeground(Color.white);
		
	}
	
}
