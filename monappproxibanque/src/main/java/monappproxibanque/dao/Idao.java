package monappproxibanque.dao;

import monappproxibanque.metier.Agence;
import monappproxibanque.metier.Carte;
import monappproxibanque.metier.Client;
import monappproxibanque.metier.Compte;
import monappproxibanque.metier.Conseiller;
import monappproxibanque.metier.Employe;

/**
 * 
 * @author Tam
 *
 */

public interface Idao {

//	public void seConnecter(String loginEmploye, String passwordEmploye);
	
	public void creerEmploye(Employe epl);
	public void lireEmploye(Employe epl);
	public void modifierEmploye(Employe epl);
	public void supprimerEmploye(Employe epl);	
	
	public void creerClient(Client clt);
	public void lireClient(Client clt);
	public void modifierClient(Client clt);
	public void supprimerClient(Client clt);	
	
	public void creerCompte(Compte cpt);
	public void lireCompte(Compte cpt);
	public void modifierCompte(Compte cpt);
	public void supprimerCompte(Compte cpt);
	
	public void creerCarte(Carte crt);
	public void lireCarte(Carte crt);
	public void modifierCarte(Carte crt);
	public void supprimerCarte(Carte crt);
	
//	public void faireVirement(Compte cpt1, Compte cpt2);
//	public void activerCarte(Carte crt);
//	public void desactiverCarte(Carte crt);
//	public void simulerCredit();
//	public void gererPatrimoine();
//	
//	public void gererConseiller(Conseiller csl);
//	public void gererAgence (Agence a);
//	
//	public void auditer(Compte cpt);

}
