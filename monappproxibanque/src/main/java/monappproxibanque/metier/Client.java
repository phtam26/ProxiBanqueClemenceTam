package monappproxibanque.metier;

import java.util.ArrayList;
import java.util.List;
/**
 * La classe Client structure les caracteristiques du client, fait le lien avec ses comptes et son conseiller.
 * @author Tam
 *
 */
public abstract class Client {
	
	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private int codePostal;
	private String ville;
	private String telClient;
	private String emailClient;
	private Conseiller monConseiller;
	private List<Compte> comptes = new ArrayList<Compte>();
	
	public Client() {
		super();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelClient() {
		return telClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public Conseiller getMonConseiller() {
		return monConseiller;
	}

	public void setMonConseiller(Conseiller monConseiller) {
		this.monConseiller = monConseiller;
	}

	public List<Compte> ajouterCompte(Compte cpt){
		comptes.add(cpt);
		return comptes;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", adresseClient=" + adresseClient + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", telClient=" + telClient + ", emailClient=" + emailClient + ", monConseiller=" + monConseiller
				+ ", comptes=" + comptes + "]";
	}
}
