package monappproxibanque.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
import monappproxibanque.metier.CompteCourant;
import monappproxibanque.service.IConseiller;
import monappproxibanque.service.IGerant;
import monappproxibanque.service.ServiceImpl;


public class PresentationSwingseconnecter extends JFrame {
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();

	private JButton seConnecter = new JButton ("Se connecter");
	
	private JLabel Login = new JLabel("Login");
	private JLabel Motdepasse = new JLabel("Mot de passe");
	
	private JTextField zonesaisielogin = new JTextField(10);
	private JTextField zonesaisiemotdepasse = new JTextField(10);
	
	public PresentationSwingseconnecter() {
		setTitle("Connexion");
		//la taille de la fenetre
		setSize(500,300);
		//précise la taille est non modifiable
		setResizable(false);
		//un clic droit sur la croix arrete le processus d'affichage de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//centrer la fenetre
		setLocationRelativeTo(null);
		IGerant ig=new ServiceImpl();
		seConnecter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				if (ig.seConnecter(zonesaisielogin.getText(),zonesaisiemotdepasse.getText())!=null);
				{
					PresentationSwingAccueil f = new PresentationSwingAccueil() ;
					f.setVisible(true);
				}
				
			}});
		
		panel2.add(Login);
		panel2.add(zonesaisielogin);
		
		panel2.add(Motdepasse);
		panel2.add(zonesaisiemotdepasse);
		
		panel4.add(seConnecter);
		
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		panel1.add(panel2);
		panel1.add(panel3);
		panel1.add(panel4);
		setContentPane(panel1);
	}
}
