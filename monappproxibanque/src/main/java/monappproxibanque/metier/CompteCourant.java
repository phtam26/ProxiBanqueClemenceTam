package monappproxibanque.metier;
/**
 * Heritee de la classe abstraite Compte, la classe CompteCourant represente les caracteristiques propres au compte courant.
 * @author Tam
 *
 */
public class CompteCourant extends Compte {

	private final float decouvert = 1000;

	public float getDecouvert() {
		return decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + "]";
	}


	
	
	
	
}
