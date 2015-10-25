package acciones;

import interfaz.ListaCanales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BtnAsideAccion implements ActionListener{
	
	ListaCanales listaCanales = null;
		
	public BtnAsideAccion(ListaCanales listaCanales) {
		// TODO Auto-generated constructor stub
		listaCanales.getSelectedIndex();
	}

	@Override
	public void actionPerformed(ActionEvent elCLick) {
		// TODO Auto-generated method stub
		System.out.println("[Escucha][BTN][ASIDE] se pincho action");
	}

}
