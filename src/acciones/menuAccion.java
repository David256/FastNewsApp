package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class menuAccion implements ActionListener, ItemListener{

	@Override
	public void actionPerformed(ActionEvent elEvent) {
		// TODO Auto-generated method stub
		System.out.println(elEvent.getActionCommand());
		
	}

	@Override
	public void itemStateChanged(ItemEvent elItem) {
		// TODO Auto-generated method stub
		
	}

}
