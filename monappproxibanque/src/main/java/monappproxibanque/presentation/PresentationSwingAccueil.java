package monappproxibanque.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import monappproxibanque.service.IGerant;
import monappproxibanque.service.ServiceImpl;

public class PresentationSwingAccueil extends JFrame{
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	private JButton Compte = new JButton ("Lancer gestion compte");
	private JButton Client = new JButton ("Lancer gestion client");
	private JButton Employe = new JButton ("Lancer gestion employe");
	
	private JComboBox<String> comboCompte = new JComboBox<String>();
	private JComboBox<String> comboEmploye = new JComboBox<String>();
	private JComboBox<String> comboClient = new JComboBox<String>();
	
	private JLabel typecompte = new JLabel("Type de compte");
	private JLabel typeclient = new JLabel("Type de client");
	private JLabel typeemploye = new JLabel("Type d'employe");
	
	IGerant ig = new ServiceImpl();
	
	public PresentationSwingAccueil() {
		setTitle("Accueil");
		//la taille de la fenetre
		setSize(500,300);
		//précise la taille est non modifiable
		setResizable(false);
		//un clic droit sur la croix arrete le processus d'affichage de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centrer la fenetre
		setLocationRelativeTo(null);
		
	comboCompte.addItem("Compte Epargne");
	comboCompte.addItem("Compte Courant");
	
	comboEmploye.addItem("Conseiller");
	comboEmploye.addItem("Gerant");
	
	comboClient.addItem("Particulier");
	comboClient.addItem("Entreprise");
	
	
	Client.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if (comboClient.getSelectedItem().toString()=="Particulier") {
				
				PresentationSwingParticulier fp = new PresentationSwingParticulier() ;
				
				fp.setVisible(true);
			}
			else if (comboClient.getSelectedItem().toString()=="Entreprise") {
				PresentationSwingEntreprise fe = new PresentationSwingEntreprise() ;
				
				fe.setVisible(true);
			}
			
			
		}});
	
	
	
	Compte.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (comboCompte.getSelectedItem().toString()=="Compte Epargne") {
				
				PresentationSwingCompteEpargne fce = new PresentationSwingCompteEpargne() ;
				
				fce.setVisible(true);
			}
			else if (comboCompte.getSelectedItem().toString()=="Compte Courant") {
				PresentationSwingCompteCourant fcc = new PresentationSwingCompteCourant() ;
				
				fcc.setVisible(true);
			}
		
			
			
		}});
	Employe.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if (comboEmploye.getSelectedItem().toString()=="Conseiller") {
				
				PresentationSwingConseiller fc = new PresentationSwingConseiller() ;
				
				fc.setVisible(true);
			}
			else if (comboEmploye.getSelectedItem().toString()=="Gerant") {
				PresentationSwingGerant fg = new PresentationSwingCompteGerant() ;
				
				fg.setVisible(true);
			}
		
			
			
		}});
	
		panel2.add(typecompte);
		panel2.add(comboCompte);
		panel2.add(Compte);
		
		panel3.add(typeclient);
		panel3.add(comboClient);
		panel3.add(Client);
		
		panel4.add(typeemploye);
		panel4.add(comboEmploye);
		panel4.add(Employe);
		
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(panel3);
		panel1.add(panel2);
		panel1.add(panel4);
		
		
		setContentPane(panel1);
	}	
}
