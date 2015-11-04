package acciones;

import interfaz.CajaDialogo;
import interfaz.ListaCanales;
import interfaz.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BtnAsideAccion implements ActionListener{
	
	public ListaCanales listaCanales = null;
		
	public BtnAsideAccion(ListaCanales listaCanales) {
		//listaCanales.getSelectedIndex();
		this.listaCanales = listaCanales;
	}

	@Override
	public void actionPerformed(ActionEvent elClick) {
		System.out.println("[Escucha][BTN][ASIDE] se pincho action. ");
		
		if(elClick.getSource()==Ventana.abtnAgregar){
			new CajaDialogo().agregarCanal();
		}
		if(elClick.getSource()==Ventana.abtnEliminar){
			int seleccionado = this.listaCanales.getSelectedIndex();
			this.listaCanales.remove(seleccionado);
			System.out.println("[Eliminar][Click] Se elimino el elemento "+seleccionado);
		}
		if(elClick.getSource()==Ventana.abtnEditar){}
	}

}
