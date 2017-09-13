package monappproxibanque.metier;

import java.util.ArrayList;
import java.util.List;
/**
 * Heritee de la classe Employe, la classe Conseiller represente le lien entre le conseiller et son gerant, ainsi que ses clients.
 * @author Tam
 *
 */
public class Conseiller extends Employe {
	
	private int idConseiller;
	private Gerant monGerant;
	private List<Client> clients = new ArrayList<Client>();

	public Conseiller() {
		super();
	}


	public int getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}


	public Gerant getMonGerant() {
		return monGerant;
	}

	public void setMonGerant(Gerant monGerant) {
		this.monGerant = monGerant;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Client> ajouterClient(Client clt) {
		clients.add(clt);
		return clients;
	}

	@Override
	public String toString() {
		return "Conseiller [monGerant=" + monGerant + ", clients=" + clients + "]";
	}	
}
