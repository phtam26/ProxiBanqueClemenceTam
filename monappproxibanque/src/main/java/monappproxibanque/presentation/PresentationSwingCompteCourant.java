package monappproxibanque.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import monappproxibanque.metier.CompteCourant;
import monappproxibanque.metier.CompteEpargne;
import monappproxibanque.metier.Conseiller;
import monappproxibanque.service.IGerant;
import monappproxibanque.service.ServiceImpl;

public class PresentationSwingCompteCourant extends JFrame{
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	//onglet ajouter
	private JPanel panelsolde = new JPanel();
	private JPanel paneldatedouverture = new JPanel();
	
	private JPanel panelbouton1 = new JPanel();
	private JButton valider1 = new JButton ("Valider");
	private JTextField zonesaisiesolde = new JTextField(10);
	private JTextField zonesaisiedatedouverture = new JTextField(10);
	
	private JLabel solde = new JLabel("Solde");
	private JLabel datedouverture = new JLabel("Date d'ouverture du compte");
	
	
	//onglet lire
	private JPanel panelId = new JPanel();
	private JPanel panelbouton2 = new JPanel();
	private JButton valider2 = new JButton ("Valider");
	private JTextField zonesaisieid = new JTextField(10);
	private JLabel id = new JLabel("Id");
	
	private JPanel paneltexte = new JPanel();
	
	private JLabel texte = new JLabel("texte");
	
	//onglet modifier
	private JPanel panelId3 = new JPanel();
	private JPanel panelsolde3 = new JPanel();
	private JPanel paneldatedouverture3 = new JPanel();
	
	private JPanel panelbouton3 = new JPanel();
	
	private JTextField zonesaisiesolde3 = new JTextField(10);
	private JTextField zonesaisiedatedouverture3 = new JTextField(10);
	
	private JTextField zonesaisieid3 = new JTextField(10);
	
	private JLabel id3 = new JLabel("Id");
	private JLabel solde3 = new JLabel("Solde");
	private JLabel datedouverture3 = new JLabel("Date d'ouverture");
	
	
	private JButton valider3 = new JButton ("Valider");
	
	
	//onglet supprimer
	private JPanel panelId4 = new JPanel();
	private JPanel panelbouton4 = new JPanel();
	private JTextField zonesaisieid4 = new JTextField(10);
	
	private JLabel id4 = new JLabel("Id");
	private JButton valider4 = new JButton ("Valider");
	
	
	IGerant ig=new ServiceImpl();
	
	//constructeur
		public PresentationSwingCompteCourant() {
		setTitle("Gestion des Comptes Courants");
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
				CompteCourant p = new CompteCourant();
				SimpleDateFormat formatter = new SimpleDateFormat("AAAA-MM-JJ");
				p.setSolde(Integer.parseInt(zonesaisiesolde.getText()));
				zonesaisiesolde.setText("");
				try {
					p.setDateOuverture(formatter.parse(zonesaisiedatedouverture.getText()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				zonesaisiedatedouverture.setText("");
				
				
				ig.creerCompteCourant(p);
			
			}});
		
		//lire info
		valider2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CompteCourant p = new CompteCourant();
				p.setIdCompte(Integer.parseInt(zonesaisieid.getText()));
				int id =(Integer.parseInt(zonesaisieid.getText()));
				p=(CompteCourant)ig.lireCompte(id);
				texte.setText(p.toString());
				
			
			}});
		
		valider3.addActionListener(new ActionListener() {
			
			//modifier
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CompteCourant p = new CompteCourant();
				
				SimpleDateFormat formatter = new SimpleDateFormat("AAAA-MM-JJ");
				p.setIdCompte(Integer.parseInt(zonesaisiesolde3.getText()));
				zonesaisiesolde3.setText("");
				try {
					p.setDateOuverture(formatter.parse(zonesaisiedatedouverture3.getText()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				zonesaisiedatedouverture3.setText("");
					
				ig.modifierCompte(p);
			
			}});
		
		valider4.addActionListener(new ActionListener() {
			
			//supprimer
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int id;
				id=(Integer.parseInt(zonesaisieid4.getText()));
				
				ig.supprimerCompte(id);
			
			}});
	
	
	//onglet ajouter
	
		panelsolde.add(solde);
		panelsolde.add(zonesaisiesolde);
		
		paneldatedouverture.add(datedouverture);
		paneldatedouverture.add(datedouverture);
		
		panelbouton1.add(valider1);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));

		panel1.add(panelsolde);
		panel1.add(paneldatedouverture);
		panel1.add(panelbouton1);
		
		
		//onglet lire
		panelId.add(id);
		panelId.add(zonesaisieid);
		
		panelbouton2.add(valider2);
		
		paneltexte.add(texte);
		
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
		panel2.add(panelId);
		panel2.add(panelbouton2);
		panel2.add(paneltexte);
		
		
		//onglet Modifier
		panelId3.add(id3);
		panelId3.add(zonesaisieid3);
		
		panelsolde3.add(solde3);
		panelsolde3.add(zonesaisiesolde3);
		
		paneldatedouverture3.add(datedouverture3);
		paneldatedouverture3.add(zonesaisiedatedouverture3);
		
		panelbouton3.add(valider3);
		
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.add(panelId3);
		panel3.add(panelsolde3);
		panel3.add(paneldatedouverture3);
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
