package monappproxibanque.metier;
/**
 * La classe abtraite Employe permet de structurer les caracteristiques communes de tous les employes.
 * @author Tam
 *
 */
public abstract class Employe {

	private int idEmploye;
	private String nomEmploye;
	private String prenomEmploye;
	private String emailEmploye;
	private String loginEmploye;
	private String passwordEmploye;
	private Agence monAgence;

	public Employe() {
		super();
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getEmailEmploye() {
		return emailEmploye;
	}

	public void setEmailEmploye(String emailEmploye) {
		this.emailEmploye = emailEmploye;
	}

	public String getLoginEmploye() {
		return loginEmploye;
	}

	public void setLoginEmploye(String loginEmploye) {
		this.loginEmploye = loginEmploye;
	}

	public String getPasswordEmploye() {
		return passwordEmploye;
	}

	public void setPasswordEmploye(String passwordEmploye) {
		this.passwordEmploye = passwordEmploye;
	}

	public Agence getMonAgence() {
		return monAgence;
	}

	public void setMonAgence(Agence monAgence) {
		this.monAgence = monAgence;
	}

	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", emailEmploye=" + emailEmploye + ", loginEmploye=" + loginEmploye + ", passwordEmploye="
				+ passwordEmploye + ", monAgence=" + monAgence + "]";
	}
	
	
	
}
