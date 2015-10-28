package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Canaletas.Canales;
import noticias.rss.Canal;



public class CajaDialogo extends JFrame implements ActionListener{
	
	JPanel panel = new JPanel();
	//normal
	JLabel titulo = new JLabel();
	JButton [] boton;
	JLabel [] texto;
	JTextField [] entrada; 
	//no más
	String espera = "";
	
	public CajaDialogo(){
		this.setSize(400, 500);
		titulo.setBounds(10 , 10 , 300, 25);
		titulo.setForeground(Color.yellow);
		panel.setLayout(null);
	}
	
	//funcion que agrega canales
	public void agregarCanal() {
		//configuramos la ventana
		espera = "addRSS";
		boton = new JButton[1];
		texto = new JLabel[2];
		entrada = new JTextField[2];
		
		this.setSize(400, 300);
		
		//creamos objetos necesarios
		boton[0] = new JButton("Agregar");
		boton[0].setBackground(new Color(100,100,100));
		boton[0].setForeground(Color.white);
		boton[0].setBounds(150, 220, 100, 30); //corregir esto
		
		//agregamos campos de entrada de URL, titulo personalizado, y por ahora ya
		texto[0] = new JLabel("URL: ");
		texto[1] = new JLabel("titulo: ");
		texto[0].setBounds(10, 50, 100, 30);
		texto[0].setFont(new Font("Arial", Font.BOLD, 15));
		texto[0].setForeground(Color.WHITE);
		
		texto[1].setBounds(10, 90, 100, 30);
		texto[1].setForeground(Color.WHITE);
		texto[1].setFont(new Font("Arial", Font.BOLD, 15));

		//Agregamos los cammpo para que escriba el contenido
		entrada[0] = new JTextField("http://");
		entrada[1] = new JTextField("<titulo personalizado>");
		entrada[0].setBounds(80, 50, 280, 25);
		entrada[1].setBounds(80, 90, 280, 25);
		
		//habilitamos un escucha a este btn, pero lo haremos aqui mismo para evitar problemas :D
		boton[0].addActionListener((ActionListener) this);
		
		System.out.println("[CajaDialogo][agregarCanal] esperando acciones");
		this.setTitle("Introducir valores del nuevo canal");
		
		titulo.setText("Datos del nuevo RSS");
		panel.add(boton[0]);
		panel.add(titulo);
		panel.add(texto[0]);
		panel.add(texto[1]);
		panel.add(entrada[1]);
		panel.add(entrada[0]);
				
		estilizar();
		this.add(panel);
		this.setVisible(true);
	}
	
	//funcion que pone bonito todo, lo que puede
	public void estilizar(){
		panel.setBackground(new Color(33,33,33));
		panel.setForeground(Color.white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == boton[0]){
			System.out.println("[CajaDialogo][BTN] se \"agrego\" un elemento nuevo");
			if(espera == "addRSS"){
				//vamos a agregar entonces ::
				System.out.println("[CajaDialogo] adding: " + entrada[0].getText() + ", " + entrada[1].getText());
				Canales.agregarRSS(entrada[0].getText(), entrada[1].getText());
				this.dispose();
			}
		}
	}
	
}
