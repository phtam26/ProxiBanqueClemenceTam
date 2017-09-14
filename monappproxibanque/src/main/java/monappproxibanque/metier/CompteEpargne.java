package monappproxibanque.metier;
/**
 * Heritee de la classe abstraite Compte, la classe CompteEpargne represente les caracteristiques propres au compte d'epargne.
 * @author Tam
 *
 */
public class CompteEpargne extends Compte {

	private final double taux = 0.03;

	public double getTaux() {
		return taux;
	}

	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + super.toString()+"]";
	}

	
	
}
