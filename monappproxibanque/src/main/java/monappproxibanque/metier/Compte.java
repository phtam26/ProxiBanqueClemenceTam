package monappproxibanque.metier;

import java.util.Date;
/**
 * La classe abstraite Compte permet de structurer les caracteristiques de base de tout type de compte.
 * @author Tam
 *
 */
public abstract class Compte {
	
	private int idCompte;
	private double solde;
	private Date dateOuverture;
	private Client monProprietaire;
	private Carte maCarte;

	public Compte() {
		super();
	}
	
	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
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
		return "Compte [solde=" + solde + "]";
	}

}
