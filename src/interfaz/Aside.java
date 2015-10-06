package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;

public class Aside extends JPanel{
	
	
	private int X;
	private int Y;
	private int ancho;
	private int alto;
	
	
	public Aside(){
		setBackground(new Color(210,210,210));
	}
	
	
	public void ubicar(int x, int y) {
		// TODO Auto-generated method stub
		X = x;
		Y = y;
		//calculamos la proporcion aurea para el ancho y el 9x% para la altura
		int anchoPerfecto =(int)( x - (x * 0.618) );
		int altoPerfecto = (int) (y * 0.90);
		setSize(anchoPerfecto, altoPerfecto);
		
		ancho = anchoPerfecto;
		alto = altoPerfecto;
		
		int desplazamientoX = x - anchoPerfecto;
		int desplazamientoY = 0;
		setLocation(desplazamientoX, desplazamientoY);
				
		System.out.println("ancho perfecto: " + anchoPerfecto);
		System.out.println("alto prefecto: " + altoPerfecto);
		System.out.println("Desplazamiento X/Y : " + desplazamientoX + " / " + desplazamientoY);
	}
	//intento de mejorar el metodo ubicar
	public void ubicar() {
		// TODO Auto-generated method stub
		X = Ventana.X;
		Y = Ventana.Y;
		//calculamos la proporcion aurea para el ancho y el 9x% para la altura
		int anchoPerfecto =(int)( X - (X * 0.618) );
		int altoPerfecto = (int) (Y * 0.90);
		setSize(anchoPerfecto, altoPerfecto);
		
		ancho = anchoPerfecto;
		alto = altoPerfecto;
		
		int desplazamientoX = X - anchoPerfecto;
		int desplazamientoY = 0;
		setLocation(desplazamientoX, desplazamientoY);
				
		System.out.println("ancho perfecto: " + anchoPerfecto);
		System.out.println("alto prefecto: " + altoPerfecto);
		System.out.println("Desplazamiento X/Y : " + desplazamientoX + " / " + desplazamientoY);
	}
}
