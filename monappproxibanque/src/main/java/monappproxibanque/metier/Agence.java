package monappproxibanque.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * La classe Agence structure les caract�ristiques de l'agence, et ses employes.
 * @author Tam
 *
 */
public class Agence {

	private int idAgence;
	private String nomAgence;
	private String adresseAgence;
	private int codePostalAgence;
	private Date dateCreation;
	private List<Employe> employes = new ArrayList<Employe>();

	public Agence() {
		super();
	}

	public int getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAdresseAgence() {
		return adresseAgence;
	}

	public void setAdresseAgence(String adresseAgence) {
		this.adresseAgence = adresseAgence;
	}

	public int getCodePostalAgence() {
		return codePostalAgence;
	}

	public void setCodePostalAgence(int codePostalAgence) {
		this.codePostalAgence = codePostalAgence;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	public List<Employe> ajouterEmploye(Employe e) {
		employes.add(e);
		return employes;
	}

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", nomAgence=" + nomAgence + ", dateCreation=" + dateCreation
				+ ", adresseAgence=" + adresseAgence + ", codePostalAgence=" + codePostalAgence + ", employes="
				+ employes + "]";
	}
	
	
	
}
