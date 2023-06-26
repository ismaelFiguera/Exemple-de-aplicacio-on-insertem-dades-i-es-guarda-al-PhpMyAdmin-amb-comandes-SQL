package almata.presentacio;

import java.awt.BorderLayout;
import java.time.LocalDate;

import javax.swing.JInternalFrame;

import almata.domini.Client;
import almata.persistencia.HelperBBDDMem;

public class ControladorPresentacio {
	private static Aplicacio aplicacio=null;
	private static JInternalFrame pantallaActual=null;
	
	public static void crearAplicacio() {
		if(aplicacio==null) {
			aplicacio= new Aplicacio();
			aplicacio.setVisible(true);
		}
	}
	
	public static void canviPantalla(JInternalFrame pantallaSeguent) {
		if(pantallaActual!=null)
			pantallaActual.dispose();
		aplicacio.getContentPane().add(pantallaSeguent, BorderLayout.CENTER);
		aplicacio.setVisible(true);
		pantallaActual=pantallaSeguent;
	}
	
	//	Metodes de negoci
	
	
	public static void addClients(String Nom,
			String Cognom1r, String Cognom2n,
			String DNI, int telefono, String correu_electronic,
			int CP, String Pais, int Edat, LocalDate Data_Naixement) {
		HelperBBDDMem.addClient(new Client(Nom, Cognom1r, Cognom2n, DNI, telefono, correu_electronic, CP, Pais, Edat, Data_Naixement));
	}
	
}
