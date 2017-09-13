package monappproxibanque.metier;

import java.util.ArrayList;
import java.util.List;
/**
 * Heritee de la classe Employe, la classe Gerant represente les caracteristiques propres au gerant de l'agence.
 * @author Tam
 *
 */
public class Gerant extends Employe {
	
	private int idGerant;
	private List<Conseiller> conseillers = new ArrayList<Conseiller>();

	public Gerant() {
		super();
	}
	
	public int getIdGerant() {
		return idGerant;
	}

	public void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}

	public List<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	
	public List<Conseiller> ajouterConseiller(Conseiller csl){
		conseillers.add(csl);
		return conseillers;
	}

	@Override
	public String toString() {
		return "Gerant [conseillers=" + conseillers + "]";
	}

}
