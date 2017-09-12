package monappproxibanque.metier;

import java.util.Date;
/**
 * La classe Carte structure les caracteristiques communes de tout type de cartes bancaires.
 * @author Tam
 *
 */
public abstract class Carte {

	private String numCarte;
	private String titulaire;
	private Date dateExpiration;
	private String cryptogramme;
	private float plafondPaiement;
	private float plafondRetrait;
	private Compte monCompte;

	public Carte() {
		super();
	}

	public String getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public String getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public float getPlafondPaiement() {
		return plafondPaiement;
	}

	public void setPlafondPaiement(float plafondPaiement) {
		this.plafondPaiement = plafondPaiement;
	}

	public float getPlafondRetrait() {
		return plafondRetrait;
	}

	public void setPlafondRetrait(float plafondRetrait) {
		this.plafondRetrait = plafondRetrait;
	}

	public Compte getMonCompte() {
		return monCompte;
	}

	public void setMonCompte(Compte monCompte) {
		this.monCompte = monCompte;
	}
	
	@Override
	public String toString() {
		return "Carte [numCarte=" + numCarte + ", titulaire=" + titulaire + ", dateExpiration=" + dateExpiration
				+ ", cryptogramme=" + cryptogramme + ", plafondPaiement=" + plafondPaiement + ", plafondRetrait="
				+ plafondRetrait + ", monCompte=" + monCompte + "]";
	}
	
	
	
}
