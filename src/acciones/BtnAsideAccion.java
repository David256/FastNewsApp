package acciones;

import interfaz.ListaCanales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BtnAsideAccion implements ActionListener, ItemListener{
	
	ListaCanales listaCanales = null;
		
	public BtnAsideAccion(ListaCanales listaCanales) {
		// TODO Auto-generated constructor stub
		listaCanales.getSelectedIndex();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}