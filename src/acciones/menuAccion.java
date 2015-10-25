package acciones;

import interfaz.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//esta clase se encarga de manejar los evento a menu de opciones
public class menuAccion implements ActionListener, ItemListener{
	private JMenuItem menuItem;

	public menuAccion(JMenuItem menuItem){
		this.menuItem = menuItem;
	}
	@Override
	public void actionPerformed(ActionEvent elEvent) {
		// revisamos que evento se genero, o sea, en que item.
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
			JOptionPane.showMessageDialog(null, "Funcion de Sobre la aplicacion");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent elItem) {
		// TODO Auto-generated method stub
		System.out.println("Evento Item");
	}

}
