package monappproxibanque.service;

import com.huios.architecture.metier.Agence;
import com.huios.architecture.metier.Carte;
import com.huios.architecture.metier.Client;
import com.huios.architecture.metier.Compte;
import com.huios.architecture.metier.Employe;

public interface IGerant extends IConseiller {

	public void supressionAgence(Agence a);
	public void miseAjourAgence(Agence a);
	public void LireAgence(Agence a);
	

	public void suppressionEmploye(Employe e);//doit entrainer supressioncompte et carte
	public void miseAjourEmploye(Employe e);
	public void LireEmploye(Employe e);
	
	
}
