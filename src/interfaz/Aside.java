package interfaz;

import javax.swing.JPanel;

public class Aside extends JPanel{

	public void ubicar(int x, int y) {
		// TODO Auto-generated method stub
		//calculamos la proporcion aurea para el ancho y el 95% para la altura
		int anchoPerfecto =(int)( x - (x * 0.618) );
		int altoPerfecto = (int) (y * 0.95);
		setSize(anchoPerfecto, altoPerfecto);
		
		int desplazamientoX = x - anchoPerfecto;
		int desplazamientoY = 0;
		setLocation(desplazamientoX, desplazamientoY);
	}

}
