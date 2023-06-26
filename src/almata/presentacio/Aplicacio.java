package almata.presentacio;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;



public class Aplicacio extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static final int ALCADA = 600;
	public static final int AMPLADA = 600;
	
	private static final String MENU = "Menu";
	private JMenu gestio;
	
	private static final String TEXT_TITOL_FINESTRA="Persones i cotxes";
	
	private JMenuItem altaPersones;
	private Controlador controlador;
	
	public Aplicacio()  {
		inicialitzacions();
		this.setJMenuBar(menu());
	}
	
	
	private JMenuBar menu() {
		//El contenidor del menu
		JMenuBar barraMenu= new JMenuBar();
		//Opcions de menú
		gestio= new JMenu(MENU);
		barraMenu.add(gestio);
		altaPersones= new JMenuItem("Alta Persones");
		altaPersones.setMnemonic(KeyEvent.VK_A);
		altaPersones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.ALT_MASK));
		altaPersones.setActionCommand("altaPersones");
		altaPersones.addActionListener(controlador);
		gestio.add(altaPersones);

		return barraMenu;
		
	}
	
	private void inicialitzacions() {
		this.setBounds(300, 50, AMPLADA, ALCADA);//x,y,amplada,alçada
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TEXT_TITOL_FINESTRA);
		this.setIconImage(new ImageIcon("imatges/montserrat.jpg").getImage());
		Container c= this.getContentPane();
		((JComponent) c).setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		controlador= new Controlador();
	}
	
	public class Controlador implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Object obj= e.getSource();
			if(obj instanceof JMenuItem) {
				JMenuItem jmi= (JMenuItem) obj;
				switch (jmi.getActionCommand()) {
				case "altaPersones":
					ControladorPresentacio.canviPantalla(new FormulariPersones());
					break;

				}

			}
				
			
			}
		}

}
