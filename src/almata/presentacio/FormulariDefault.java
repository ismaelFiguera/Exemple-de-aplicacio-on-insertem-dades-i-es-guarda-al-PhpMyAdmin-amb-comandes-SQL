package almata.presentacio;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import almata.utils.Util;




public class FormulariDefault extends JInternalFrame implements Formulari {

	private static final long serialVersionUID = 1L;
	
	private GridBagLayout layout;


	private JLabel logo;

	public FormulariDefault() {
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
		setVisible(true);
	}
	
	@Override
	public void inicialitzacions() {
		this.getContentPane().setLayout(layout=new GridBagLayout());
		this.setBorder(null);
		Util.treureBarraTitolInteralFrame(this);

	}

	@Override
	public void crearComponents() {
		logo= new JLabel(Util.redimensionarImatge("imatges/images.jpg", Aplicacio.AMPLADA, Aplicacio.ALCADA));

	}

	@Override
	public void afegirComponents() {
		add(logo);

	}

	@Override
	public void posicionarComponents() {
		GridBagConstraints gbc= new GridBagConstraints();
		//restriccions del botó...
		gbc.gridx= 0; //columna
		gbc.gridy= 0; //fila
		gbc.gridheight= 1; //alçada en files
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); //top,left, bottom, right
		gbc.weightx= 1;
		gbc.weighty= 1;
		gbc.fill= GridBagConstraints.BOTH;
		layout.setConstraints(logo, gbc);

	}


}




