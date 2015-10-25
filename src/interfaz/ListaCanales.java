package interfaz;

import java.awt.Font;

import javax.swing.JList;

//Esta es la clase que se encarga de manejar el listado de canales

public class ListaCanales extends JList{
	
	public ListaCanales(String[] valores){
		super(valores);
		this.setSize(350, 400);
		this.setLocation(8, 50);
		this.setFont(new Font("Georgia", Font.BOLD, 24));
	}

}
