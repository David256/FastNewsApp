package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BotonAside extends JButton{

	public BotonAside(String texto) {
		super(texto);
		this.setBackground(new Color(33,33,33));
		this.setFont(new Font("consolas", Font.ITALIC, 14));
		this.setForeground(Color.WHITE); //new Color(14,14,14)
		
		//esto se puede mejorar pues :P
		this.setBorder(BorderFactory.createLineBorder(new Color(14,14,14)));
	}

}
