package monappproxibanque.metier;

import java.util.ArrayList;
import java.util.List;
/**
 * La classe Client structure les caracteristiques du client, fait le lien avec ses comptes et son conseiller.
 * @author Tam
 *
 */
public abstract class Client {
	
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private int codePostalClient;
	private String villeClient;
	private String telephoneClient;
	private String mail;
	private Conseiller monConseiller;
	private List<Compte> comptes = new ArrayList<Compte>();
	
	public Client() {
		super();
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

	public int getCodePostalClient() {
		return codePostalClient;
	}

	public void setCodePostalClient(int codePostalClient) {
		this.codePostalClient = codePostalClient;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}

	public String getTelephoneClient() {
		return telephoneClient;
	}

	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
		return "Client [nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", adresseClient=" + adresseClient
				+ ", codePostalClient=" + codePostalClient + ", villeClient=" + villeClient + ", telephoneClient="
				+ telephoneClient + ", mail=" + mail + ", monConseiller=" + monConseiller + ", comptes=" + comptes
				+ "]";
	}
	
	

}
