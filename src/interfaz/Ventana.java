package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import acciones.menuAccion;
import acciones.BtnAsideAccion;


public class Ventana extends JFrame{
	
		
	private Papel papel; // el papel tapiz de la app
	private Aside aside; // campo lateral que tiene la lista de canales
	private TheSection section; //la seccion de noticias, lo importante
	static final int X = 1000;
	static final int Y = 600;
	private BarraMenu miMenu; // barra de menu, pendiente modificar
	private JScrollPane scroll;
	
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
	public static BotonAside abtnEditar;
	public static BotonAside abtnEliminar;
	public static BotonAside abtnAgregar;
	
	//para la lista de canales
	public String [] nombreCorto = {""}; //Vacio","No hay nada", "Chao
	
	//cosas de la parte principal
	
	
	public Ventana(){
		papel = new Papel();
		aside = new Aside();
		section = new TheSection();
		
		//section.setLayout(null);
		section.setLayout(null);
		
		//vertical scroll para 
		scroll = new JScrollPane(section,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scroll.setViewportView(section);
		
		
		papel.cargarImagen();
		miMenu = new BarraMenu();
		tituloListaCanales = new JLabel();
		logoMain = new JLabel("Fast News App");
		
		this.centrarVentana();
		
		aside.ubicar();
		//aside.setLayout(new BorderLayout());
		aside.setLayout(null); //este ser� el que se escojer�
		//personalizamos el titulo de la lista de canales
		tituloListaCanales.setText("Lista de canales RSS");
		tituloListaCanales.setBounds(10, 5, 500, 50);
		tituloListaCanales.setFont(new Font("verdana", Font.BOLD, 20));
		tituloListaCanales.setForeground(new Color(33,33,33));
		
		listaCanales = new ListaCanales(nombreCorto);
		listaCanales.starter();
		
		//agregamos btns de manejo del aside
		abtnAgregar = new BotonAside("Agregar");
		abtnEditar = new BotonAside("Editar");
		abtnEliminar = new BotonAside("Eliminar");
		//ubicamos cada uno
		
		abtnAgregar.setBounds(25, 460, 100, 30);
		abtnEditar.setBounds(135, 460, 100, 30);
		abtnEliminar.setBounds(245, 460, 100, 30);
				
		aside.add(abtnAgregar);
		aside.add(abtnEditar);
		aside.add(abtnEliminar);
		
		abtnAgregar.addActionListener(new BtnAsideAccion(listaCanales));
		//cambiamos los btn para ejecutar el c�digo aqu�
		abtnEliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg) {
				// TODO Auto-generated method stub
				listaCanales.remove( listaCanales.getSelectedIndex() );
				System.out.println("[Ventana][Action Delete] elminando el elemento seleccionado");
			}
			
		});
		//abtnEliminar.addActionListener(new BtnAsideAccion(listaCanales));
		
		abtnEditar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("[Ventana][Action Editar] editando el elemento seleccionado");
			}
			
		});
		
		aside.add(tituloListaCanales);
		aside.add(listaCanales);
		
		//configurar la section y el scroll
		//section.setBounds(20, 70, 570, 450);
		scroll.setBounds(20, 70, 570, 450);
		//section.setLayout(null);
		
		logoMain.setFont(new Font("verdana", Font.BOLD, 24));
		logoMain.setForeground(Color.WHITE);
		logoMain.setBounds(10, 10, 500, 50);
		papel.add(logoMain);
		papel.add(aside);
		papel.add(scroll);
		papel.setLayout(null);
		this.add(papel);
		this.prepararMenu();
		this.setJMenuBar(miMenu);
		
		section.starter();
	}
	
	public void prepararMenu() {
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
