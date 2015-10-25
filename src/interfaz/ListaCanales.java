package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JList;

//Esta es la clase que se encarga de manejar el listado de canales

public class ListaCanales extends JList{
	
	public ListaCanales(String[] valores){
		super(valores);
		this.setSize(350, 400);
		this.setLocation(8, 50);
		this.setFont(new Font(Font.SANS_SERIF,Font.CENTER_BASELINE , 18));
		this.setForeground(new Color(107, 72, 1));
		this.setBackground(new Color(203, 198, 176));
		this.setSelectionBackground(new Color(0,0,0));
		this.setSelectionForeground(Color.white);
	}

}
