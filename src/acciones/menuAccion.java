package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;


public class menuAccion implements ActionListener, ItemListener{
	private JMenuItem menuItem;

	public menuAccion(JMenuItem menuItem){
		this.menuItem = menuItem;
	}
	@Override
	public void actionPerformed(ActionEvent elEvent) {
		// TODO Auto-generated method stub
		if(elEvent.getSource() == menuItem){
			System.exit(0);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent elItem) {
		// TODO Auto-generated method stub
		System.out.println("Evento Item");
	}

}
