package monappproxibanque.metier;
/**
 * Heritee de la classe abstraite Compte, la classe CompteCourant represente les caracteristiques propres au compte courant.
 * @author Tam
 *
 */
public class CompteCourant extends Compte {

	private final double decouvert = 1000;

	public double getDecouvert() {
		return decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + super.toString()+ "]";
	}


	
	
	
	
}
