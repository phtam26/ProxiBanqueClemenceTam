package monappproxibanque.service;

import monappproxibanque.metier.Carte;
import monappproxibanque.metier.CarteVisaElectron;
import monappproxibanque.metier.CarteVisaPremier;
import monappproxibanque.metier.Client;
import monappproxibanque.metier.ClientEntreprise;
import monappproxibanque.metier.ClientParticulier;
import monappproxibanque.metier.Compte;
import monappproxibanque.metier.CompteCourant;
import monappproxibanque.metier.CompteEpargne;
import monappproxibanque.metier.Employe;

public interface IConseiller {
	
	//public void seConnecter(String login, String mdp);
	
	//client

	public void creerClientParticulier(ClientParticulier cltPaticulier);
	public void creerClientEntreprise(ClientEntreprise cltEntreprise);
	public Client lireClient(int idClient);
	public void modifierClient(Client clt);
	public void supprimerClient(int idClient);	
	
	public void creerCartePremier(CarteVisaPremier crtPremier);
	public void creerCarteElectron(CarteVisaElectron crtElectron);
	public Carte lireCarte(int idCarte);
	public void modifierCarte(Carte crt);
	public void supprimerCarte(int idCarte);
	
	public void creerCompteCourant(CompteCourant cptCourant);
	public void creerCompteEpargne(CompteEpargne cptEpargne);
	public Compte lireCompte(int idCompte);
	public void modifierCompte(Compte cpt);
	public void supprimerCompte(int idCompte);
	
	

	
}
