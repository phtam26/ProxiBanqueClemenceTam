package monappproxibanque.service;


public interface IConseiller {
	
	//public void seConnecter(String login, String mdp);

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
	
	public void creerEmploye(Employe e);
	public void supprimerEmploye(Employe e);
	public void modifierEmploye(Employe e);
	public void LireEmploye(Employe e);

	
}
