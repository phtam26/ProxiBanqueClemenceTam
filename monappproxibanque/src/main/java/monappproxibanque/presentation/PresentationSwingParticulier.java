package monappproxibanque.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import monappproxibanque.metier.ClientParticulier;
import monappproxibanque.service.IConseiller;
import monappproxibanque.service.IGerant;
import monappproxibanque.service.ServiceImpl;


public class PresentationSwingParticulier extends JFrame {
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	//onglet ajouter
	
	private JPanel panelnom = new JPanel();
	private JPanel panelprenom = new JPanel();
	private JPanel panelemail = new JPanel();
	private JPanel panelbouton1 = new JPanel();
	private JPanel paneltel = new JPanel();
	private JPanel paneladresse = new JPanel();
	private JPanel panelcodepostal = new JPanel();
	private JPanel panelville = new JPanel();
	private JTextField zonesaisietel = new JTextField(10);
	private JTextField zonesaisieadresse = new JTextField(10);
	private JTextField zonesaisiecodepostal = new JTextField(10);
	private JTextField zonesaisieville = new JTextField(10);
	private JLabel tel = new JLabel("Teléphone");
	private JLabel adresse = new JLabel("Adresse");
	private JLabel codepostal = new JLabel("Code Postal");
	private JLabel ville = new JLabel("Ville");
	
	private JButton valider1 = new JButton ("Valider");
	
	private JTextField zonesaisieprenom = new JTextField(10);
	private JTextField zonesaisienom = new JTextField(10);
	private JTextField zonesaisieemail = new JTextField(10);
	
	private JLabel nom = new JLabel("Nom");
	private JLabel prenom = new JLabel("Prenom");
	private JLabel email = new JLabel("Email");
	
	//onglet lire
	private JPanel panelId = new JPanel();
	private JPanel paneltexte= new JPanel();
	private JPanel panelbouton2 = new JPanel();
	private JButton valider2 = new JButton ("Valider");
	private JTextField zonesaisieid = new JTextField(10);
	private JLabel id = new JLabel("Id");
	private JLabel texteclient = new JLabel("texteclient");
	
	
	//onglet modifier
	private JPanel panelId3 = new JPanel();
	private JPanel panelnom3 = new JPanel();
	private JPanel panelprenom3 = new JPanel();
	
	private JPanel panelbouton3 = new JPanel();
	
	private JTextField zonesaisieprenom3 = new JTextField(10);
	private JTextField zonesaisienom3 = new JTextField(10);
	
	private JTextField zonesaisieid3 = new JTextField(10);
	
	private JLabel id3 = new JLabel("Id");
	private JLabel nom3 = new JLabel("Nom");
	private JLabel prenom3 = new JLabel("Prenom");
	
	
	private JButton valider3 = new JButton ("Valider");
	
	
	//onglet supprimer
	private JPanel panelId4 = new JPanel();
	private JPanel panelbouton4 = new JPanel();
	private JTextField zonesaisieid4 = new JTextField(10);
	
	private JLabel id4 = new JLabel("Id");
	private JButton valider4 = new JButton ("Valider");
	
	
	IGerant ig=new ServiceImpl();
	
	//constructeur
	public PresentationSwingParticulier() {
	setTitle("Gestion des Clients Particuliers");
	//la taille de la fenetre
	setSize(500,300);
	//précise la taille est non modifiable
	setResizable(false);
	//un clic droit sur la croix arrete le processus d'affichage de la fenetre
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//centrer la fenetre
	setLocationRelativeTo(null);
	
	
	//ajouter
	valider1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ClientParticulier p = new ClientParticulier();
			p.setNomClient(zonesaisienom.getText());
			zonesaisienom.setText("");
			p.setPrenomClient(zonesaisieprenom.getText());
			zonesaisieprenom.setText("");
			p.setEmailClient(zonesaisieemail.getText()); 
			zonesaisieemail.setText("");
			p.setTelClient(zonesaisietel.getText()); 
			zonesaisietel.setText("");
			p.setAdresseClient(zonesaisieadresse.getText()); 
			zonesaisieadresse.setText("");
			p.setCodePostal(Integer.parseInt(zonesaisiecodepostal.getText())); 
			zonesaisiecodepostal.setText("");
			p.setVille(zonesaisieville.getText()); 
			zonesaisieville.setText("");
			
			ig.creerClient(p);
			ig.creerClientParticulier(p);
			
			
			
			
			
		}});
	
	//lire info
	valider2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int id =Integer.parseInt(zonesaisieid.getText());
			ClientParticulier p = new ClientParticulier();
			p=(ClientParticulier)ig.lireClient(id);
			texteclient.setText(p.toString());
		
		}});
	
	valider3.addActionListener(new ActionListener() {
		
		//modifier
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ClientParticulier p = new ClientParticulier();
			
			
			p.setIdClient(Integer.parseInt(zonesaisieid3.getText()));
			zonesaisieid3.setText("");
			p.setNomClient(zonesaisienom3.getText());
			zonesaisienom3.setText("");
			p.setPrenomClient(zonesaisieprenom3.getText());
			zonesaisieprenom3.setText("");
			
			ig.modifierClient(p);
		
		}});
	
	valider4.addActionListener(new ActionListener() {
		
		//supprimer
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int id;
			id=(Integer.parseInt(zonesaisieid4.getText()));
			zonesaisieid4.setText("");
			ig.supprimerClient(id);
		
		}});
	
	
	//onglet ajouter
	
	
	panelnom.add(nom);
	panelnom.add(zonesaisienom);
	
	panelprenom.add(prenom);
	panelprenom.add(zonesaisieprenom);
	
	panelemail.add(email);
	panelemail.add(zonesaisieemail);
	
	paneltel.add(tel);
	paneltel.add(zonesaisietel);
	
	paneladresse.add(adresse);
	paneladresse.add(zonesaisieadresse);
	
	panelcodepostal.add(codepostal);
	panelcodepostal.add(zonesaisiecodepostal);
	
	panelville.add(ville);
	panelville.add(zonesaisieville);
	
	panelbouton1.add(valider1);
	
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
	
	panel1.add(panelnom);
	panel1.add(panelprenom);
	panel1.add(panelemail);
	panel1.add(paneltel);
	panel1.add(paneladresse);
	panel1.add(panelcodepostal);
	panel1.add(panelville);
	panel1.add(panelbouton1);
	
	
	//onglet lire
	panelId.add(id);
	panelId.add(zonesaisieid);
	
	panelbouton2.add(valider2);
	
	paneltexte.add(texteclient);
	
	panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
	panel2.add(panelId);
	panel2.add(panelbouton2);
	panel2.add(paneltexte);
	
	
	//onglet Modifier
	panelId3.add(id3);
	panelId3.add(zonesaisieid3);
	
	panelnom3.add(nom3);
	panelnom3.add(zonesaisienom3);
	
	panelprenom3.add(prenom3);
	panelprenom3.add(zonesaisieprenom3);
	
	panelbouton3.add(valider3);
	
	panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
	panel3.add(panelId3);
	panel3.add(panelnom3);
	panel3.add(panelprenom3);
	panel3.add(panelbouton3);
	
	
	//Supprimer
	panelId4.add(id4);
	panelId4.add(zonesaisieid4);
	
	panelbouton4.add(valider4);
	
	panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
	panel4.add(panelId4);
	panel4.add(panelbouton4);
	
	
	

	//Les onglets
	JTabbedPane onglets = new JTabbedPane();
	onglets.addTab("Ajouter",panel1);
	onglets.addTab("Lire",panel2);
	onglets.addTab("Modifier",panel3);
	onglets.addTab("Supprimer",panel4);
	getContentPane().add(onglets);
	
	
	

	}

}
