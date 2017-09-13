package monappproxibanque.service;

import monappproxibanque.dao.Idao;
import monappproxibanque.metier.Carte;
import monappproxibanque.metier.Client;
import monappproxibanque.metier.Compte;
import monappproxibanque.metier.Employe;

public class ServiceImpl implements IConseiller , IGerant {

	private Idao dao = new Dao();

	@Override
	public void creerClient(Client clt) {
		// TODO Auto-generated method stub
		dao.creerClient(clt);
	}

	@Override
	public void supprimerClient(Client clt) {
		// TODO Auto-generated method stub
		dao.supprimerClient(clt);
	}

	@Override
	public void modifierClient(Client clt) {
		// TODO Auto-generated method stub
		dao.modifierClient(clt);
	}

	@Override
	public void LireClient(Client clt) {
		// TODO Auto-generated method stub
		dao.lireClient(clt);
	}

	@Override
	public void creerCarte(Carte crt) {
		// TODO Auto-generated method stub
		dao.creerCarte(crt);
	}

	@Override
	public void supprimerCarte(Carte crt) {
		// TODO Auto-generated method stub
		dao.supprimerCarte(crt);
	}

	@Override
	public void modifierCarte(Carte crt) {
		// TODO Auto-generated method stub
		dao.modifierCarte(crt);
	}

	@Override
	public void LireCarte(Carte crt) {
		// TODO Auto-generated method stub
		dao.lireCarte(crt);
	}

	@Override
	public void creerCompte(Compte cpt) {
		// TODO Auto-generated method stub
		dao.creerCompte(cpt);
	}

	@Override
	public void supprimerCompte(Compte cpt) {
		// TODO Auto-generated method stub
		dao.supprimerCompte(cpt);
	}

	@Override
	public void modifierCompte(Compte cpt) {
		// TODO Auto-generated method stub
		dao.modifierCompte(cpt);
	}

	@Override
	public void LireCompte(Compte cpt) {
		// TODO Auto-generated method stub
		dao.lireCompte(cpt);
	}

	@Override
	public void creerEmploye(Employe epl) {
		// TODO Auto-generated method stub
		dao.creerEmploye(epl);
	}

	@Override
	public void supprimerEmploye(Employe epl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierEmploye(Employe epl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LireEmploye(Employe epl) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
