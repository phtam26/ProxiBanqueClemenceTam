package monappproxibanque.metier;

import java.util.Date;
/**
 * La classe abstraite Compte permet de structurer les caracteristiques de base de tout type de compte.
 * @author Tam
 *
 */
public abstract class Compte {
	
	private int numCompte;
	private float solde;
	private Date dateOuverture;
	private Client monProprietaire;
	private Carte maCarte;

	public Compte() {
		super();
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getMonProprietaire() {
		return monProprietaire;
	}

	public void setMonProprietaire(Client monProprietaire) {
		this.monProprietaire = monProprietaire;
	}

	public Carte getMaCarte() {
		return maCarte;
	}

	public void setMaCarte(Carte maCarte) {
		this.maCarte = maCarte;
	}

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture
				+ ", monProprietaire=" + monProprietaire + ", maCarte=" + maCarte + "]";
	}
	
	
	
	
	
}
