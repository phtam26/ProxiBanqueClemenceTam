package monappproxibanque.metier;
/**
 * Heritee de la classe Client, la classe ClientEntreprise represente les caracteristiques propres aux entreprises.
 * @author Tam
 *
 */
public class ClientEntreprise extends Client {
	
	private int clientEntrepriseID;

	public int getClientEntrepriseID() {
		return clientEntrepriseID;
	}

	public void setClientEntrepriseID(int clientEntrepriseID) {
		this.clientEntrepriseID = clientEntrepriseID;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
