package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class menuAccion implements ActionListener, ItemListener{
	public menuAccion(){
		
	}
	@Override
	public void actionPerformed(ActionEvent elEvent) {
		// TODO Auto-generated method stub
		System.out.println("Evento Accion");		
	}

	@Override
	public void itemStateChanged(ItemEvent elItem) {
		// TODO Auto-generated method stub
		System.out.println("Evento Item");
	}

}
