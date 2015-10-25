package acciones;

import interfaz.CajaDialogo;
import interfaz.ListaCanales;
import interfaz.Ventana;

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
	public void actionPerformed(ActionEvent elClick) {
		// TODO Auto-generated method stub
		System.out.println("[Escucha][BTN][ASIDE] se pincho action. ");
		
		if(elClick.getSource()==Ventana.abtnAgregar){
			new CajaDialogo().agregarCanal();
		}
		if(elClick.getSource()==Ventana.abtnEliminar){}
		if(elClick.getSource()==Ventana.abtnEditar){}
	}

}
