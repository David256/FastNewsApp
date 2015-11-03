package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JToolTip;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import noticias.rss.Canal;
import noticias.rss.RSS;
import Canaletas.Canales;

//Esta es la clase que se encarga de manejar el listado de canales

public class ListaCanales extends JList implements Runnable{
	
	private Vector<Canal> interno = new Vector();
	
	public ListaCanales(String[] valores){
		super(valores);
		estilizar();
		
		this.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(getValueIsAdjusting()){
					System.out.println("[ListaCanales][OnSelect] se selecciono algo");
					/*
					JToolTip bocadillo = new JToolTip();
					bocadillo.setTipText("Hola?");
					bocadillo.setBounds(200, 200, 500, 30);
					bocadillo.setVisible(true);
					*/
					int seleccionado = getSelectedIndex();
					if(interno.isEmpty()){
						System.out.println("[ListaCanales][IsEmpty] El \"interno\" esta vacio aún");
						return;
					}
					System.out.println("Se seleccionó el elemento "+seleccionado);
					Canal temporalCanal = new Canal(interno.get(seleccionado).getUrl(), interno.get(seleccionado).getTitulo());
					Canales.seleccionadoPorLista = temporalCanal;
					System.out.println("[ListaCanales][OnSelect](saving) se guarda en Canales el canal seleccionado");
					
					//vamos a ver que hay en esa url
					String uuu = interno.get(seleccionado).getUrl();
					RSS rss = new RSS();
					System.out.println("[ListaCanales][OnConnecting] Estamos estableciendo conexion, ¡ESPERE!");
					String data = rss.cargarURL(new Canal(uuu,""));
					Canales.mensaje = data;
				}
			}
			
		});
	}
	public void estilizar(){
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
	public void remove(int index){
		interno.remove(index);
		super.remove(index);
		System.out.println("-> [Override(-Remove-)].JList");
	}
	@Override
	public void run() {
		
		while(true){
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("[ListaCanales][RUN] Error en el Thread.sleep(n) _");
				e.printStackTrace();
			}
			//vamos a actualidar eso
			this.interno = Canales.getVector(); //guardamos el vector dentro del mismo
			//de esta forma, creo que sería más facil para el actualizador de estado y lista
			//this.setListData(interno.toArray());
			String[] vTitulos = new String[interno.size()];
			for(int i=0; i<interno.size(); i++){
				vTitulos[i] = interno.get(i).getTitulo();
			}//ahora guardamos
			this.setListData(vTitulos);
			//ahora debemos guardar en lista de archivos
			System.out.println("(Away)[ListaCanales] lanzamiento de thread exitoso");
		}
	}
	public void starter(){
		new Thread(this).start();
	}
	
	//metodos que se encargan de buscar sobre una url o sobre un titulo en particular
	public String buscarUrl(String titulo){
		for(int i=0; i<interno.size(); i++){
			if(interno.get(i).getTitulo() == titulo){
				return interno.get(i).getUrl();
			}
		}
		return null;
	}
	public String buscarTitulo(String url){
		for(int i=0; i<interno.size(); i++){
			if(interno.get(i).getUrl() == url){
				return interno.get(i).getTitulo();
			}
		}
		return null;
	}
}
