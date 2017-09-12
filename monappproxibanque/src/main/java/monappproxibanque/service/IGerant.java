package monappproxibanque.service;

import monappproxibanque.metier.Agence;
import monappproxibanque.metier.Employe;

public interface IGerant extends IConseiller {

	public void supressionAgence(Agence a);
	public void miseAjourAgence(Agence a);
	public void LireAgence(Agence a);
	

	public void suppressionEmploye(Employe e);//doit entrainer supressioncompte et carte
	public void miseAjourEmploye(Employe e);
	public void LireEmploye(Employe e);
	
	
}
