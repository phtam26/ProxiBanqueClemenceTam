package monappproxibanque.metier;
/**
 * Heritee de la clase Client, la classe ClientParticulier represente les caracteristiques propres aux clients particuliers.
 * @author Tam
 *
 */
public class ClientParticulier extends Client {
	
	private int ClientParticulierID;

	public int getClientParticulierID() {
		return ClientParticulierID;
	}

	public void setClientParticulierID(int clientParticulierID) {
		ClientParticulierID = clientParticulierID;
	}
	
	

}
