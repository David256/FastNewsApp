package interfaz;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Canaletas.Canales;

public class TheSection extends JPanel implements Runnable{
	
	JLabel textoTitulo = new JLabel("Sin Titulo");
	JLabel textoUrl = new JLabel("http://david.com");
	JTextField textoNormal = new JTextField("[Vacio]");
	
	JPanel capa = new JPanel();
	
	public TheSection(){
		textoTitulo.setBounds(10, 10, 400, 50);
		textoUrl.setBounds(10, 100, 400, 50);
		textoNormal.setBounds(10, 200, 600, 500);
		
		capa.add(textoTitulo);
		capa.add(textoUrl);
		capa.add(textoNormal);
		
		add(capa);
	}
	
	public void starter(){
		new Thread(this).start();
	}
	@Override
	public void run() {
		// 
		System.out.println("Iniciado RUN()");
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("[TheSection] Error en el Thread");
				e.printStackTrace();
			}
			
			textoTitulo.setText(Canales.seleccionadoPorLista.getTitulo());
			textoUrl.setText(Canales.seleccionadoPorLista.getUrl());
			textoNormal.setText(Canales.mensaje);
			
			System.out.println("Valor de Canales.mensaje = " + Canales.mensaje);
			this.repaint();
		}
	}
	
	

}
