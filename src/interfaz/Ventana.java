package interfaz;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import acciones.menuAccion;


public class Ventana extends JFrame{
	
		
	private Papel papel;
	private Aside aside;
	private int X;
	private int Y;
	private BarraMenu miMenu;
	////////
	private JMenu menuArchivo;
	private JMenu menuAcceso;
	private JMenu menuOpciones;
	private JMenu menuAyuda;
	
	public static JMenuItem menuISalir;
	public static JMenuItem menuISobre;
	public static JMenuItem menuIActualizar;
	public static JMenuItem menuIInformacion;
	
	public Ventana(){
		papel = new Papel();
		aside = new Aside();
		papel.setLayout(null);
		papel.cargarImagen();
		miMenu = new BarraMenu();
		
		X = 1000;
		Y = 600;
		this.centrarVentana();
		
		aside.setLocation(X, Y);
		papel.add(aside);
		this.add(papel);
		this.prepararMenu();
		this.setJMenuBar(miMenu);
	}
	
	public void prepararMenu() {
		// TODO Auto-generated method stub
		//objetos de JMenu
		menuArchivo = new JMenu("Archivo");
		menuAcceso = new JMenu("Acceso");
		menuOpciones = new JMenu("Opciones");
		menuAyuda = new JMenu("Ayuda");
		
		//objeto JMenuItem
		menuISalir = new JMenuItem("Salir");
		menuISobre = new JMenuItem("Sobre");
		menuIActualizar = new JMenuItem("Actualizar");
		menuIInformacion = new JMenuItem("Informacion");
		
		//añadiendo los item en el menu
		menuArchivo.add(menuISalir);
		
		menuAyuda.add(menuISobre);
		menuAyuda.add(menuIActualizar);
		menuAyuda.add(menuIInformacion);
		
		//introducimos a la barra de menu
		miMenu.add(menuArchivo);
		miMenu.add(menuAcceso);
		miMenu.add(menuOpciones);
		miMenu.add(menuAyuda);
		
		//añado evento a el menú salir
		menuISalir.addActionListener(new menuAccion(menuISalir));
		menuISobre.addActionListener(new menuAccion(menuISobre));
		menuIActualizar.addActionListener(new menuAccion(menuIActualizar));
		menuIInformacion.addActionListener(new menuAccion(menuIInformacion));
	}

	public void centrarVentana() {
		// TODO Auto-generated method stub
		int anchoW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int altoW = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int lugarX = (anchoW / 2) - (X / 2);
		int lugarY = (altoW / 2) - (Y / 2);
		setBounds(lugarX, lugarY, X, Y);
		
		
	}
	public void setTitle(String title){
		super.setTitle(title);
	}

	public void mostrar(){
		setVisible(true);
	}
	
}
