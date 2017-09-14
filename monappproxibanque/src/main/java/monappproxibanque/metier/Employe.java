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
	private String telEmploye;
	private String loginEmploye;
	private String motDePasse;
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
	
	public String getTelEmploye() {
		return telEmploye;
	}

	public void setTelEmploye(String telEmploye) {
		this.telEmploye = telEmploye;
	}
	


	public Agence getMonAgence() {
		return monAgence;
	}

	public void setMonAgence(Agence monAgence) {
		this.monAgence = monAgence;
	}

	public String getLoginEmploye() {
		return loginEmploye;
	}

	public void setLoginEmploye(String loginEmploye) {
		this.loginEmploye = loginEmploye;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", emailEmploye=" + emailEmploye + ", loginEmploye=" + loginEmploye
				+ ", motDePasse=" + motDePasse ;
	}
}
