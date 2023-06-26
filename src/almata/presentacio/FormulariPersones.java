package almata.presentacio;
import almata.utils.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;


public class FormulariPersones extends JInternalFrame implements Formulari {

	private static final long serialVersionUID = 1L;
	private GridBagLayout layout;
	private Controlador controlador;
	private FormulariPersones formulariPersones;
	
	private static final String DNI = "DNI:";
	private static final String NOM = "Nom:";
	private static final String COGNOM1 = "1r Cognom:";
	private static final String COGNOM2 = "2n Cognom:";
	private static final String TELEFON = "Telefon:";
	private static final String CORREU = "Correu electronic:";
	private static final String CP = "Codi postal:";
	private static final String PAIS = "Pais:";
	private static final String EDAT = "Edat:";
	private static final String DN = "Data Naixement:";
	private static final String BA = "Acceptar";
	private static final String BOTO_A = "botoAcceptar";
	private static final String BC = "Cancelar";
	private static final String BOTO_C = "botoCancelar";
	
	
	
	private JLabel lblDni;
	private JFormattedTextField ftfDNI;
	
	private JLabel lblNom;
	private JTextField txtNom;
	
	private JLabel lbl1rCognom;
	private JTextField txt1rCognom;
	
	private JLabel lbl2nCognom;
	private JTextField txt2nCognom;
	
	private JLabel lblTelefon;
	private JFormattedTextField ftfTelefon;
	
	private JLabel lblCorreu;
	private JTextField txtCorreu;
	
	private JLabel lblCP;
	private JFormattedTextField ftfCP;
	
	private JLabel lblPais;
	private JComboBox<String> llistaPaisos;
	
	private JLabel lblEdat;
	private JTextField txtEdat;
	
	private JLabel lblDn;
	private DatePicker txtDataNaixement;
	
	private JButton btnAcceptar;
	private JButton btnCancelar;
	
	private JPanel pnlBotons;
	
	
	
	private static JComboBox<String> llistatPaisos() {
		DefaultComboBoxModel<String> p = new DefaultComboBoxModel<String>();
			p.addElement("...");
			p.addElement("Espanya");
			p.addElement("França");
			p.addElement("Italia");
			p.addElement("Alemania");
			p.addElement("Inglaterra");
			p.addElement("Polonia");
			
			
		JComboBox<String> llistaPaisos = new JComboBox<String>(p);
		return llistaPaisos;
	}
	
	
    private static JFormattedTextField createCPTextField() {
        JFormattedTextField CP = null;
        try {
            MaskFormatter formatter = new MaskFormatter("#####");
            formatter.setPlaceholderCharacter('_');
            CP = new JFormattedTextField(formatter);
            CP.setColumns(10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return CP;
    }
	
	
    private static JFormattedTextField createDNITextField() {
        JFormattedTextField dniField = null;
        try {
            MaskFormatter formatter = new MaskFormatter("########?");
            formatter.setPlaceholderCharacter('_');
            dniField = new JFormattedTextField(formatter);
            dniField.setColumns(10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dniField;
    }
    
    
    private static JFormattedTextField createTelefonTextField() {
        JFormattedTextField telefon = null;
        try {
            MaskFormatter formatter = new MaskFormatter("#########");
            formatter.setPlaceholderCharacter('_');
            telefon = new JFormattedTextField(formatter);
            telefon.setColumns(10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return telefon;
    }
    
    
    
	
	public FormulariPersones() {
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
		setVisible(true);
	}
	
	@Override
	public void inicialitzacions() {
		Container c= this.getContentPane();
		((JComponent) c).setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder( new Color(135, 206, 235), 5, true), "Persona", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, Fonts.fontTitol(), Color.BLACK));
		getContentPane().setLayout(layout= new GridBagLayout());
		controlador= new Controlador();
		formulariPersones=this;
		Util.treureBarraTitolInteralFrame(this);

	}

	@Override
	public void crearComponents() {
		lblDni=new JLabel(DNI);
		ftfDNI= createDNITextField();
		
		lblNom = new JLabel(NOM);
		txtNom = new JTextField();
		txtNom.setFont(Fonts.fontTextField());
		
		lbl1rCognom = new JLabel(COGNOM1);
		txt1rCognom = new JTextField();
		txt1rCognom.setFont(Fonts.fontTextField());
		
		lbl2nCognom = new JLabel(COGNOM2);
		txt2nCognom = new JTextField();
		txt2nCognom.setFont(Fonts.fontTextField());
	
		lblTelefon = new JLabel(TELEFON);
		ftfTelefon= createTelefonTextField();
		
		lblCorreu = new JLabel(CORREU);
		txtCorreu = new JTextField();
		txtCorreu.setFont(Fonts.fontTextField());
		
		lblPais = new JLabel(PAIS);
		llistaPaisos = llistatPaisos();
		
		lblCP = new JLabel(CP);
		ftfCP = createCPTextField();
		
		lblEdat = new JLabel(EDAT);
		txtEdat = new JTextField();
		txtEdat.setFont(Fonts.fontTextField());
		
		lblDn=new JLabel(DN);
		txtDataNaixement=new DatePicker();
		txtDataNaixement.setFont(Fonts.fontTextField());
		
		btnAcceptar=new JButton(BA);
		btnAcceptar.addActionListener(controlador);
		btnAcceptar.setActionCommand(BOTO_A);
		
		btnCancelar=new JButton(BC);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(BOTO_C);
		
		pnlBotons=new JPanel();
		pnlBotons.add(btnAcceptar);
		pnlBotons.add(btnCancelar);
	}

	@Override
	public void afegirComponents() {
		add(lblDni);
		add(ftfDNI);
		
		add(lblNom);
		add(txtNom);
		
		add(lbl1rCognom);
		add(txt1rCognom);
		
		add(lbl2nCognom);
		add(txt2nCognom);
		
		add(lblTelefon);
		add(ftfTelefon);
		
		add(lblCorreu);
		add(txtCorreu);
		
		add(lblPais);
		add(llistaPaisos);
		
		add(lblCP);
		add(ftfCP);
		
		add(lblEdat);
		add(txtEdat);
		
		add(lblDn);
		add(txtDataNaixement);
		
		add(pnlBotons);
	}

	@Override
	public void posicionarComponents() {
		GridBagConstraints gbc= new GridBagConstraints();
		
		//	NOM
		gbc.gridx= 0; 
		gbc.gridy= 0; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblNom, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 0; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(txtNom, gbc);
		
		
		
		//	1r COGNOM
		gbc.gridx= 0; 
		gbc.gridy= 1; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lbl1rCognom, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 1; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(txt1rCognom, gbc);
		
		
		
		//	2n COGNOM
		gbc.gridx= 0; 
		gbc.gridy= 2; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lbl2nCognom, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 2; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(txt2nCognom, gbc);
		
		
		
		//	DNI
		gbc.gridx= 0; 
		gbc.gridy= 3; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblDni, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 3; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1; 
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 1;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(ftfDNI, gbc);
		
		
		
		//	Telefon
		gbc.gridx= 0; 
		gbc.gridy= 4; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblTelefon, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 4; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1; 
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 1;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(ftfTelefon, gbc);
		
		
		
		//	Correu
		gbc.gridx= 0; 
		gbc.gridy= 5; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblCorreu, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 5; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1; 
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 1;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(txtCorreu, gbc);
		
		
		
		//	Pais
		gbc.gridx= 0; 
		gbc.gridy= 6; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblPais, gbc);
		
		gbc.gridx= 1;
		gbc.gridy= 6;
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5);
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(llistaPaisos, gbc);
		
		
		
		//	CP
		gbc.gridx= 0; 
		gbc.gridy= 7; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblCP, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 7; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1; 
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 1;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(ftfCP, gbc);
		
		
		
		//	Edat
		gbc.gridx= 0; 
		gbc.gridy= 8; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblEdat, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 8; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1; 
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 1;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(txtEdat, gbc);
		
		
		
		//	Data naixement
		gbc.gridx= 0; 
		gbc.gridy= 9; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1;
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(lblDn, gbc);
		
		gbc.gridx= 1; 
		gbc.gridy= 9; 
		gbc.gridheight= 1; 
		gbc.gridwidth= 1; 
		gbc.insets= new Insets(5, 5, 5, 5); 
		gbc.weightx= 1;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		layout.setConstraints(txtDataNaixement, gbc);
		
		//	Botons
		gbc.gridx= 1; //columna
		gbc.gridy= 10; //fila
		gbc.gridheight= 1; //alçada 
		gbc.gridwidth= 1; //amplada 
		gbc.weightx= 0;
		gbc.weighty= 0;
		gbc.anchor= GridBagConstraints.EAST;
		gbc.fill= GridBagConstraints.NONE;
		layout.setConstraints(pnlBotons, gbc);
	}
	
	
	public class Controlador implements ActionListener {
		
		String cami="";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj instanceof JButton) {
				JButton boto= (JButton) obj;
				if(boto.getActionCommand().equals(BOTO_A)) {
					System.out.println("He polsat el botó acceptar!!");		
					ControladorPresentacio.addClients(txtNom.getText(),
							txt1rCognom.getText(),
							txt2nCognom.getText(), 
							ftfDNI.getText(),
							Integer.parseInt(ftfTelefon.getText()),
							txtCorreu.getText(),
							Integer.parseInt(ftfCP.getText()),
							String.valueOf(llistaPaisos.getSelectedItem()),
							Integer.parseInt(txtEdat.getText()),
							txtDataNaixement.getDate());
				
				
					ControladorPresentacio.canviPantalla(new FormulariDefault());
				
				}else if(boto.getActionCommand().equals(BOTO_C)) {
					System.out.println("He polsat el botó cancel·lar!!");
					ControladorPresentacio.canviPantalla(new FormulariDefault());

			}
			
		}
		
	}

}
}
