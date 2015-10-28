package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JList;

import Canaletas.Canales;

//Esta es la clase que se encarga de manejar el listado de canales

public class ListaCanales extends JList implements Runnable{
	
	public ListaCanales(String[] valores){
		super(valores);
		this.setSize(350, 400);
		this.setLocation(8, 50);
		this.setFont(new Font(Font.SANS_SERIF,Font.CENTER_BASELINE , 18));
		
		//cambio de color a el JList
		this.setForeground(new Color(107, 72, 1));
		this.setBackground(new Color(203, 198, 176));
		this.setSelectionBackground(new Color(0,0,0));
		this.setSelectionForeground(Color.white);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("[ListaCanales][RUN] Error en el Thread.sleep(n) _");
				e.printStackTrace();
			}
			//vamos a actualidar eso
//			this.add(Canales.sembrar().getTitulo());
			String listado[] = null;
			int cantidad = Canales.getVectorAsArray().length;
			listado = new String[cantidad + 1];
			//listado tiene que tener lo anterior y lo nuevo juntos :3
			for(int i=0; i<cantidad+1; i++){
				listado[i] = Canales.getVectorAsArray()[i];
			}
			//this.setListData(listado);
			this.setListData(Canales.getVector().toArray());
			System.out.println("(Away)[ListaCanales] lanzamiento de thread exitoso");
		}
	}
	public void starter(){
		new Thread(this).start();
		
	}

}
