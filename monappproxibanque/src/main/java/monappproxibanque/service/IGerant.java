package monappproxibanque.service;

import monappproxibanque.metier.Agence;
import monappproxibanque.metier.Employe;

public interface IGerant extends IConseiller {

	
	
	public void creerEmploye(Employe epl);
	public void supprimerEmploye(Employe epl);//doit entrainer supressioncompte et carte
	public void modifierEmploye(Employe epl);
	public void LireEmploye(Employe epl);
	
	
}
