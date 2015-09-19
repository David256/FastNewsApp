package interfaz;

import java.awt.Color;
import java.awt.Graphics;

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
		//calculamos la proporcion aurea para el ancho y el 95% para la altura
		int anchoPerfecto =(int)( x - (x * 0.618) );
		int altoPerfecto = (int) (y * 0.95);
		setSize(anchoPerfecto, altoPerfecto);
		
		ancho = anchoPerfecto;
		alto = altoPerfecto;
		
		int desplazamientoX = x - anchoPerfecto;
		int desplazamientoY = 0;
		setLocation(desplazamientoX, desplazamientoY);
	}

}
