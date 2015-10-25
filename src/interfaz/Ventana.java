package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import acciones.menuAccion;


public class Ventana extends JFrame{
	
		
	private Papel papel; // el papel tapiz de la app
	private Aside aside; // campo lateral que tiene la lista de canales
	static final int X = 1000;
	static final int Y = 600;
	private BarraMenu miMenu; // barra de menu, pendiente modificar
	//////// Lista de menues
	private JMenu menuArchivo;
	private JMenu menuAcceso;
	private JMenu menuOpciones;
	private JMenu menuAyuda;
	// lista de submenues
	public static JMenuItem menuISalir;
	public static JMenuItem menuISobre;
	public static JMenuItem menuIActualizar;
	public static JMenuItem menuIInformacion;
	
	private JLabel tituloListaCanales;
	private JLabel logoMain;
	private ListaCanales listaCanales;
	
	//botones para el aside
	private JButton abtnEditar;
	private JButton abtnEliminar;
	private JButton abtnAgregar;
	
	//para la lista de canales
	public String [] nombreCorto = {"Vacio","No hay nada", "Chao"};
	
	
	public Ventana(){
		papel = new Papel();
		aside = new Aside();
		papel.cargarImagen();
		miMenu = new BarraMenu();
		tituloListaCanales = new JLabel();
		logoMain = new JLabel("Fast News App");
		
		this.centrarVentana();
		
		aside.ubicar();
		//aside.setLayout(new BorderLayout());
		aside.setLayout(null); //este ser· el que se escojer·
		//personalizamos el titulo de la lista de canales
		tituloListaCanales.setText("Lista de canales RSS");
		tituloListaCanales.setBounds(10, 5, 500, 50);
		tituloListaCanales.setFont(new Font("verdana", Font.BOLD, 20));
		tituloListaCanales.setForeground(new Color(33,33,33));
		
		listaCanales = new ListaCanales(nombreCorto);
		
		aside.add(tituloListaCanales);
		aside.add(listaCanales);
		
		logoMain.setFont(new Font("verdana", Font.BOLD, 24));
		logoMain.setForeground(Color.WHITE);
		logoMain.setBounds(10, 10, 500, 50);
		papel.add(logoMain);
		papel.add(aside);
		papel.setLayout(null);
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
		
		//a√±adiendo los item en el menu
		menuArchivo.add(menuISalir);
		
		menuAyuda.add(menuISobre);
		menuAyuda.add(menuIActualizar);
		menuAyuda.add(menuIInformacion);
		
		//introducimos a la barra de menu
		miMenu.add(menuArchivo);
		miMenu.add(menuAcceso);
		miMenu.add(menuOpciones);
		miMenu.add(menuAyuda);
		
		//a√±ado evento a el men√∫ salir
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
