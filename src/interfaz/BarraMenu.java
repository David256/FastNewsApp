package interfaz;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JMenuBar;

public class BarraMenu extends JMenuBar{
	
	public void paint(Graphics g){
		g.setColor(new Color(00,23,23));
		super.paint(g);
		System.out.println("Mejoro el menu");
	}


}
