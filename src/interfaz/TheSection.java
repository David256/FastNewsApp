package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Canaletas.Canales;

public class TheSection extends JPanel implements Runnable{

	JLabel textoTitulo = new JLabel("Sin Titulo");
	JLabel textoUrl = new JLabel("http://david.com");
	JTextArea textoNormal = new JTextArea("[Vacio]");
	JScrollPane scroll;

	public TheSection(){
		super();
		textoTitulo.setBounds(20, 10, 500, 30);
		textoTitulo.setFont(new Font("verdana", Font.BOLD, 14));
		textoTitulo.setForeground(Color.red);
		textoUrl.setBounds(20, 40, 500, 30);
		textoUrl.setFont(new Font("Arial", Font.ITALIC, 11));
		textoNormal.setEditable(false);
		textoNormal.setSelectedTextColor(Color.GREEN);
		textoNormal.setLineWrap(true);
		textoNormal.setFont(new Font("consolas", Font.ITALIC, 14));
		
		scroll  = new JScrollPane(textoNormal, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 70, 550, 500);
		
		add(textoTitulo);
		add(textoUrl);
		add(scroll);
	}

	public void starter(){
		new Thread(this).start();
	}
	@Override
	public void run() {
		System.out.println("Iniciado RUN()");
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("[TheSection] Error en el Thread");
				e.printStackTrace();
			}//fin de try/catch
			textoTitulo.setText(Canales.seleccionadoPorLista.getTitulo());
			textoUrl.setText(Canales.seleccionadoPorLista.getUrl());
			textoNormal.setText(Canales.mensaje);		
			System.out.println("Valor de Canales.mensaje = " + Canales.mensaje);
		}
	}

}
