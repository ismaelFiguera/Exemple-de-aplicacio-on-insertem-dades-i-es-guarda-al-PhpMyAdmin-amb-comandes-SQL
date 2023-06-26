package almata;

import almata.presentacio.ControladorPresentacio;
import almata.presentacio.FormulariDefault;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ControladorPresentacio.crearAplicacio();
		ControladorPresentacio.canviPantalla(new FormulariDefault());
	}

}
