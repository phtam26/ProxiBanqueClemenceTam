package monappproxibanque.metier;
/**
 * Heritee de la classe Client, la classe ClientEntreprise represente les caracteristiques propres aux entreprises.
 * @author Tam
 *
 */
public class ClientEntreprise extends Client {
	
	private String matricule;

	public ClientEntreprise() {
		super();
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Override
	public String toString() {
		return "ClientEntreprise [matricule=" + matricule + "]";
	}
	
	

}
