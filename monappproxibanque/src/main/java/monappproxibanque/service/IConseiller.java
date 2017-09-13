package monappproxibanque.service;

import monappproxibanque.metier.Carte;
import monappproxibanque.metier.Client;
import monappproxibanque.metier.Compte;
import monappproxibanque.metier.Employe;

public interface IConseiller {
	
	//public void seConnecter(String login, String mdp);
	
	//client

	public void creerClient(Client clt);
	public void supprimerClient(Client clt);//doit entrainer supressioncompte et carte
	public void modifierClient(Client clt);
	public void LireClient(Client clt);

	public void creerCarte(Carte crt);
	public void supprimerCarte(Carte crt);
	public void modifierCarte(Carte crt);
	public void LireCarte(Carte crt);
	
	
	public void creerCompte(Compte cpt);
	public void supprimerCompte(Compte cpt);
	public void modifierCompte(Compte cpt);
	public void LireCompte(Compte cpt);
	
	

	
}
