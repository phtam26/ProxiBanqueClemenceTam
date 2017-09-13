package monappproxibanque.dao;

import java.util.List;

import monappproxibanque.metier.Agence;
import monappproxibanque.metier.Carte;
import monappproxibanque.metier.CarteVisaElectron;
import monappproxibanque.metier.CarteVisaPremier;
import monappproxibanque.metier.Client;
import monappproxibanque.metier.ClientEntreprise;
import monappproxibanque.metier.ClientParticulier;
import monappproxibanque.metier.Compte;
import monappproxibanque.metier.CompteCourant;
import monappproxibanque.metier.CompteEpargne;
import monappproxibanque.metier.Conseiller;
import monappproxibanque.metier.Employe;
import monappproxibanque.metier.Gerant;

/**
 * 
 * @author Tam
 *
 */

public interface Idao {
	
	public String seConnecter(String loginEmploye, String motDePasse);
	
	public void creerConseiller(Conseiller csl);
	public void creerGerant(Gerant g);
	public Employe lireEmploye(int idEmploye);
	public void modifierEmploye(Employe epl);
	public void supprimerEmploye(int idEmploye);
	public List<Employe> findAllEmployes();
	
	public void creerClientParticulier(ClientParticulier cltParticulier);
//	public int recupererIdClient(ClientParticulier cltParticulier);
//	public void updateIdClientParticulier(int id);
	public void creerClientEntreprise(ClientEntreprise cltEntreprise);
	public Client lireClient(int idClient);
	public void modifierClient(Client clt);
	public void supprimerClient(int idClient);	
	public List<Client> findAllClients();
	
	public void creerCompteCourant(CompteCourant cptCourant);
	public void creerCompteEpargne(CompteEpargne cptEpargne);
	public Compte lireCompte(int idCompte);
	public void modifierCompte(Compte cpt);
	public void supprimerCompte(int idCompte);
	public List<Compte> findAllComptes();
	
	public void creerCartePremier(CarteVisaPremier crtPremier);
	public void creerCarteElectron(CarteVisaElectron crtElectron);
	public Carte lireCarte(int idCarte);
	public void modifierCarte(Carte crt);
	public void supprimerCarte(int idCarte);
	public List<Carte> findAllCartes();

	public Agence getAgence(int idAgence);
	public Employe getEmploye(int idEmploye);
	public Client getClient(int idClient);
	public Compte getCompte(int idCompte);
	public Carte getCarte(int idCarte);
	public void attribuerEmployeAgence(Employe epl, Agence a);
	public List<Employe> employesDeLAgence (int idAgence);
	public void attribuerClientEmploye(Client clt, Employe epl);
	public List<Client> clientsDuConseiller(int idEmploye);
	public void attribuerCompteClient(Compte cpt, Client clt);
	public List<Compte> comptesDuClient(int idClient);
	public void attribuerCarteCompte(Carte crt, Compte cpt); // une carte pour un compte
	
	
// pas encore developper les methodes ci-dessous, a part les sysout
	
	public void faireVirement(Compte cpt1, Compte cpt2);
	public void activerCarte(Carte crt);
	public void desactiverCarte(Carte crt);
	public void simulerCredit();
	public void gererPatrimoine();
	
	public void gererConseiller(Conseiller csl);
	public void gererAgence (Agence a);
	
	public void auditer(Compte cpt);

}
