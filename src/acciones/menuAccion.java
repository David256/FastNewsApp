package acciones;

import interfaz.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class menuAccion implements ActionListener, ItemListener{
	private JMenuItem menuItem;

	public menuAccion(JMenuItem menuItem){
		this.menuItem = menuItem;
	}
	@Override
	public void actionPerformed(ActionEvent elEvent) {
		// TODO Auto-generated method stub
		if(elEvent.getSource() == Ventana.menuISalir){
			System.exit(0);
		}
		if(elEvent.getSource() == Ventana.menuIActualizar){
			JOptionPane.showMessageDialog(null, "Funcion de actualizar");
		}
		if(elEvent.getSource() == Ventana.menuIInformacion){
			JOptionPane.showMessageDialog(null, "Funcion de informacion");
		}
		if(elEvent.getSource() == Ventana.menuISobre){
			JOptionPane.showMessageDialog(null, "Funcion de Sobre");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent elItem) {
		// TODO Auto-generated method stub
		System.out.println("Evento Item");
	}

}
