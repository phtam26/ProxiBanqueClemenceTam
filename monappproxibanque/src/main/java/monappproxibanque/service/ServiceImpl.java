package monappproxibanque.service;

import monappproxibanque.dao.Dao;
import monappproxibanque.dao.Idao;
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

public class ServiceImpl implements IConseiller , IGerant {

	private Idao dao = new Dao();

	@Override
	public void creerConseiller(Conseiller csl) {
		// TODO Auto-generated method stub
		dao.creerConseiller(csl);
	}

	@Override
	public void creerGerant(Gerant g) {
		// TODO Auto-generated method stub
		dao.creerGerant(g);
	}

	@Override
	public Employe lireEmploye(int idEmploye) {
		// TODO Auto-generated method stub
		return dao.lireEmploye(idEmploye);
	}

	@Override
	public void modifierEmploye(Employe epl) {
		// TODO Auto-generated method stub
		dao.modifierEmploye(epl);
	}

	@Override
	public void supprimerEmploye(int idEmploye) {
		// TODO Auto-generated method stub
		dao.supprimerEmploye(idEmploye);
	}

	@Override
	public void creerClientParticulier(ClientParticulier cltPaticulier) {
		// TODO Auto-generated method stub
		dao.creerClientParticulier(cltPaticulier);
	}

	@Override
	public void creerClientEntreprise(ClientEntreprise cltEntreprise) {
		// TODO Auto-generated method stub
		dao.creerClientEntreprise(cltEntreprise);
	}

	@Override
	public Client lireClient(int idClient) {
		// TODO Auto-generated method stub
		return dao.lireClient(idClient);
	}

	@Override
	public void modifierClient(Client clt) {
		// TODO Auto-generated method stub
		dao.modifierClient(clt);
	}

	@Override
	public void supprimerClient(int idClient) {
		// TODO Auto-generated method stub
		dao.supprimerClient(idClient);
	}

	@Override
	public void creerCartePremier(CarteVisaPremier crtPremier) {
		// TODO Auto-generated method stub
		dao.creerCartePremier(crtPremier);
	}

	@Override
	public void creerCarteElectron(CarteVisaElectron crtElectron) {
		// TODO Auto-generated method stub
		dao.creerCarteElectron(crtElectron);
	}

	@Override
	public Carte lireCarte(int idCarte) {
		// TODO Auto-generated method stub
		return dao.lireCarte(idCarte);
	}

	@Override
	public void modifierCarte(Carte crt) {
		// TODO Auto-generated method stub
		dao.modifierCarte(crt);
	}

	@Override
	public void supprimerCarte(int idCarte) {
		// TODO Auto-generated method stub
		dao.supprimerCarte(idCarte);
	}

	@Override
	public void creerCompteCourant(CompteCourant cptCourant) {
		// TODO Auto-generated method stub
	dao.creerCompteCourant(cptCourant);	
	}

	@Override
	public void creerCompteEpargne(CompteEpargne cptEpargne) {
		// TODO Auto-generated method stub
		dao.creerCompteEpargne(cptEpargne);
	}

	@Override
	public Compte lireCompte(int idCompte) {
		// TODO Auto-generated method stub
		return dao.lireCompte(idCompte);
	}

	@Override
	public void modifierCompte(Compte cpt) {
		// TODO Auto-generated method stub
		dao.modifierCompte(cpt);
	}

	@Override
	public void supprimerCompte(int idCompte) {
		// TODO Auto-generated method stub
		dao.supprimerCompte(idCompte);
	}


	@Override
	public String seConnecter(String loginEmploye, String motDePasse) {
		return dao.seConnecter(loginEmploye, motDePasse);
	}

	


	
	
	

}
