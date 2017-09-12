package monappproxibanque.metier;

import java.util.Date;
/**
 * La classe Carte structure les caracteristiques communes de tout type de cartes bancaires.
 * @author Tam
 *
 */
public abstract class Carte {

	private int idCarte;
	private Date dateExpiration;
	private int cryptogramme;
	private float plafondPaiement;
	private float plafondRetrait;
	private Compte monCompte;

	public Carte() {
		super();
	}

	public int getIdCarte() {
		return idCarte;
	}

	public void setIdCarte(int idCarte) {
		this.idCarte = idCarte;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public int getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(int cryptogramme) {
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
		return "Carte [idCarte=" + idCarte + ", dateExpiration=" + dateExpiration + ", cryptogramme=" + cryptogramme
				+ ", plafondPaiement=" + plafondPaiement + ", plafondRetrait=" + plafondRetrait + ", monCompte="
				+ monCompte + "]";
	}	
}
