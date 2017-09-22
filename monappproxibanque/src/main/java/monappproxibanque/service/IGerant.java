package monappproxibanque.service;

import monappproxibanque.metier.Agence;
import monappproxibanque.metier.Conseiller;
import monappproxibanque.metier.Employe;
import monappproxibanque.metier.Gerant;

public interface IGerant extends IConseiller {

	public boolean seConnecter(String loginEmploye, String motDePasse);
	
	public void creerConseiller(Conseiller p);
	public void creerEmploye(Employe e);
	public void creerGerant(Gerant g);
	public Employe lireEmploye(int idEmploye);
	public void modifierEmploye(Employe epl);
	public void supprimerEmploye(int idEmploye);

	
	
}
