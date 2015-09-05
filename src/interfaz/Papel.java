package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Papel extends JPanel{
	
	private Image fondoImagen;
	
	public Papel(){
		super();
		this.setOpaque(false);
	}
	public void cargarImagen(){
		URL urlImagen = getClass().getResource("../res/wood.jpg");
		if(urlImagen != null){
			fondoImagen = new ImageIcon(urlImagen).getImage();
		}else{
			System.err.println("Error, no puedo cargar la imagen de fondo para la ventana: archivo wood.jpg");
		}
	}
	@Override
	public void paint(Graphics g){
		if(fondoImagen != null){
			g.drawImage(fondoImagen, 0, 0, null);
		}
		super.paint(g);
	}
	
}
