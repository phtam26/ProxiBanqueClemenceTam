package monappproxibanque.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import monappproxibanque.metier.Agence;
import monappproxibanque.metier.Carte;
import monappproxibanque.metier.CarteVisaElectron;
import monappproxibanque.metier.CarteVisaPremier;
import monappproxibanque.metier.Client;
import monappproxibanque.metier.ClientEntreprise;
import monappproxibanque.metier.ClientParticulier;
import monappproxibanque.metier.Compte;
import monappproxibanque.metier.CompteCourant;
import monappproxibanque.metier.CompteEpargne;
import monappproxibanque.metier.Conseiller;
import monappproxibanque.metier.Employe;
import monappproxibanque.metier.Gerant;

/**
 * La classe Dao permet repr�sente toutes les fonctionnalites du programme.
 * @author Tam
 *
 */
public class Dao implements Idao {
	
/**
 * CRUD Employe	
 */
	@Override
	public void creerConseiller(Conseiller csl) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "INSERT INTO employe(conseillerID, nomEmploye, prenomEmploye, emailEmploye, telEmploye, login, motDePasse) +"
								+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ps.setInt(1, csl.getConseillerID());
			ps.setString(2, csl.getNomEmploye()); 
			ps.setString(3, csl.getPrenomEmploye());
			ps.setString(4, csl.getEmailEmploye());
			ps.setString(5, csl.getTelEmploye());
			ps.setString(6, csl.getLogin());
			ps.setString(7, csl.getMotDePasse());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		
		
	}
	
	@Override
	public void creerGerant(Gerant g) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "INSERT INTO employe(gerantID, nomEmploye, prenomEmploye, emailEmploye, telEmploye, login, motDePasse) +"
								+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ps.setInt(1, g.getGerantID());
			ps.setString(2, g.getNomEmploye()); 
			ps.setString(3, g.getPrenomEmploye());
			ps.setString(4, g.getEmailEmploye());
			ps.setString(5, g.getTelEmploye());
			ps.setString(6, g.getLogin());
			ps.setString(7, g.getMotDePasse());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		
	}
	
	@Override
	public Employe lireEmploye(int idEmploye) {
		
		Gerant g = new Gerant();
		Conseiller csl = new Conseiller();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM employe WHERE idEmploye = ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idEmploye);

			ResultSet rs = ps.executeQuery();
				rs.next();
				if(rs.getInt("idEmploye") == rs.getInt("idGerant")) {

					g.setNomEmploye(rs.getString("nomEmploye"));
					g.setPrenomEmploye(rs.getString("prenomEmploye"));
					g.setEmailEmploye(rs.getString("emailEmploye"));
					g.setTelEmploye(rs.getString("telEmploye"));
					g.setLogin(rs.getString("login"));
					g.setMotDePasse(rs.getString("motDePasse"));
		
				} else if(rs.getInt("idEmploye") == rs.getInt("idConseiller")) {

					csl.setNomEmploye(rs.getString("nomEmploye"));
					csl.setPrenomEmploye(rs.getString("prenomEmploye"));
					csl.setEmailEmploye(rs.getString("emailEmploye"));
					csl.setTelEmploye(rs.getString("telEmploye"));
					csl.setLogin(rs.getString("login"));
					csl.setMotDePasse(rs.getString("motDePasse"));	
				}
				
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return g; // à revoir

		
	}
	@Override
	public void modifierEmploye(Employe epl) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "UPDATE employe SET nomEmploye = ?, prenomEmploye = ? " +
							 " WHERE idEmploye = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);

			ps.setString(1, epl.getNomEmploye());			
			ps.setString(2, epl.getPrenomEmploye());
			ps.setInt(3, epl.getIdEmploye());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void supprimerEmploye(int idEmploye) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "DELETE FROM employe WHERE idEmploye = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idEmploye);
			ps.executeUpdate();
			
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Employe> findAllEmployes() {
		
		List<Employe> listeEmployes = new ArrayList<Employe>();
		Gerant g = new Gerant();
		Conseiller csl = new Conseiller();
		
		try {
				
			Class.forName("com.mysql.jdbc.Driver");

			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
		
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM employe";
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				if(rs.getInt("idEmploye") == rs.getInt("idGerant")) {

					g.setIdEmploye(rs.getInt("idEmploye"));
					g.setNomEmploye(rs.getString("nomEmploye"));
					g.setPrenomEmploye(rs.getString("prenomEmploye"));
					g.setEmailEmploye(rs.getString("emailEmploye"));
					g.setTelEmploye(rs.getString("telEmploye"));
					g.setLogin(rs.getString("login"));
					g.setMotDePasse(rs.getString("motDePasse"));
					listeEmployes.add(g);
					
				} else if(rs.getInt("idEmploye") == rs.getInt("idConseiller")) {

					csl.setIdEmploye(rs.getInt("idEmploye"));
					csl.setNomEmploye(rs.getString("nomEmploye"));
					csl.setPrenomEmploye(rs.getString("prenomEmploye"));
					csl.setEmailEmploye(rs.getString("emailEmploye"));
					csl.setTelEmploye(rs.getString("telEmploye"));
					csl.setLogin(rs.getString("login"));
					csl.setMotDePasse(rs.getString("motDePasse"));	
					listeEmployes.add(csl);
					}			
			}
			
			ps.close();
			conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeEmployes;
	}
	
	

/**
 * CRUD Client
 */
	
	@Override
	public void creerClientParticulier(ClientParticulier cltPaticulier) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "INSERT INTO client(clientParticulierID, nomClient, prenomClient, adresseClient, codePostal, ville, telClient, emailClient) +"
								+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ps.setInt(1, cltPaticulier.getClientParticulierID());
			ps.setString(1, cltPaticulier.getNomClient()); 
			ps.setString(2, cltPaticulier.getPrenomClient());
			ps.setString(3, cltPaticulier.getAdresseClient());
			ps.setInt(4, cltPaticulier.getCodePostal());
			ps.setString(5, cltPaticulier.getVille());
			ps.setString(6, cltPaticulier.getTelClient());
			ps.setString(7, cltPaticulier.getEmailClient());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		
			
	}
	@Override
	public void creerClientEntreprise(ClientEntreprise cltEntreprise) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "INSERT INTO client(clientEntrepriseID, nomClient, prenomClient, adresseClient, codePostal, ville, telClient, emailClient) +"
								+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ps.setInt(1, cltEntreprise.getClientEntrepriseID());
			ps.setString(1, cltEntreprise.getNomClient()); 
			ps.setString(2, cltEntreprise.getPrenomClient());
			ps.setString(3, cltEntreprise.getAdresseClient());
			ps.setInt(4, cltEntreprise.getCodePostal());
			ps.setString(5, cltEntreprise.getVille());
			ps.setString(6, cltEntreprise.getTelClient());
			ps.setString(7, cltEntreprise.getEmailClient());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		

		
	}
	
	@Override
	public Client lireClient(int idClient) {
		ClientParticulier cltPart = new ClientParticulier();
		ClientEntreprise cltEnt = new ClientEntreprise();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM client WHERE idClient = ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idClient);

			ResultSet rs = ps.executeQuery();
				rs.next();
				if(rs.getInt("idClient") == rs.getInt("idClientParticulier")) {

					cltPart.setIdClient(rs.getInt("idClient"));
					cltPart.setNomClient(rs.getString("nomClient"));
					cltPart.setPrenomClient(rs.getString("prenomClient"));
					cltPart.setAdresseClient(rs.getString("adresseClient"));
					cltPart.setCodePostal(rs.getInt("codePostal"));
					cltPart.setVille(rs.getString("ville"));
					cltPart.setTelClient(rs.getString("telClient"));
					cltPart.setEmailClient(rs.getString("emailClient"));
		
				} else if(rs.getInt("idClient") == rs.getInt("idClientEntreprise")) {

					cltEnt.setIdClient(rs.getInt("idClient"));
					cltEnt.setNomClient(rs.getString("nomClient"));
					cltEnt.setPrenomClient(rs.getString("prenomClient"));
					cltEnt.setAdresseClient(rs.getString("adresseClient"));
					cltEnt.setCodePostal(rs.getInt("codePostal"));
					cltEnt.setVille(rs.getString("ville"));
					cltEnt.setTelClient(rs.getString("telClient"));
					cltEnt.setEmailClient(rs.getString("emailClient"));
					
					}
				
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cltPart; // à revoir

	}

	@Override
	public void modifierClient(Client clt) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "UPDATE client SET nomClient = ?, prenomClient = ? " +
							 " WHERE idClient = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);

			ps.setString(1, clt.getNomClient());			
			ps.setString(2, clt.getPrenomClient());
			ps.setInt(3, clt.getIdClient());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerClient(int idClient) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "DELETE FROM client WHERE idClient = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idClient);
			ps.executeUpdate();
			
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Client> findAllClients() {
		List<Client> listeClients = new ArrayList<Client>();
		ClientParticulier cltPart = new ClientParticulier();
		ClientEntreprise cltEnt = new ClientEntreprise();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM client";
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("idClient") == rs.getInt("idClientParticulier")) {

					cltPart.setIdClient(rs.getInt("idClient"));
					cltPart.setNomClient(rs.getString("nomClient"));
					cltPart.setPrenomClient(rs.getString("prenomClient"));
					cltPart.setAdresseClient(rs.getString("adresseClient"));
					cltPart.setCodePostal(rs.getInt("codePostal"));
					cltPart.setVille(rs.getString("ville"));
					cltPart.setTelClient(rs.getString("telClient"));
					cltPart.setEmailClient(rs.getString("emailClient"));
		
				} else if(rs.getInt("idClient") == rs.getInt("idClientEntreprise")) {

					cltEnt.setIdClient(rs.getInt("idClient"));
					cltEnt.setNomClient(rs.getString("nomClient"));
					cltEnt.setPrenomClient(rs.getString("prenomClient"));
					cltEnt.setAdresseClient(rs.getString("adresseClient"));
					cltEnt.setCodePostal(rs.getInt("codePostal"));
					cltEnt.setVille(rs.getString("ville"));
					cltEnt.setTelClient(rs.getString("telClient"));
					cltEnt.setEmailClient(rs.getString("emailClient"));
					cltEnt.setMatricule(rs.getString("matriculeEntreprise"));
					
					}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeClients;
	}

/**
 * CRUD Compte	
 */
	
	@Override
	public void creerCompteCourant(CompteCourant cptCourant) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "INSERT INTO compte(solde, dateOuverture) +"
								+ " VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ps.setDouble(1, cptCourant.getSolde()); 
			ps.setDate(2, (Date) cptCourant.getDateOuverture());
	
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		
	}	
	
	@Override
	public void creerCompteEpargne(CompteEpargne cptEpargne) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "INSERT INTO compte(solde, dateOuverture) +"
								+ " VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ps.setDouble(1, cptEpargne.getSolde()); 
			ps.setDate(2, (Date) cptEpargne.getDateOuverture());
	
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		
	}
		
	

	@Override
	public Compte lireCompte(int idCompte) {
		
		CompteCourant cptCourant = new CompteCourant();
		CompteEpargne cptEpargne = new CompteEpargne();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM compte WHERE idCompte = ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idCompte);

			ResultSet rs = ps.executeQuery();
				rs.next();
				if(rs.getInt("idCompte") == rs.getInt("idCompteCourant")) {

					cptCourant.setSolde(rs.getDouble("solde"));
					cptCourant.setDateOuverture(rs.getDate("dateOuverture"));
							
					} else if(rs.getInt("idCompte") == rs.getInt("idCompteEpargne")) {

					cptEpargne.setSolde(rs.getDouble("solde"));
					cptEpargne.setDateOuverture(rs.getDate("dateOuverture"));
				}
				
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cptCourant; // à revoir
	}

	@Override
	public void modifierCompte(Compte cpt) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "UPDATE compte SET solde = ?, dateOuverture = ? " +
							 " WHERE idCompte = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);

			ps.setDouble(1, cpt.getSolde());			
			ps.setDate(2, (Date) cpt.getDateOuverture());
			ps.setInt(3, cpt.getIdCompte());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerCompte(int idCompte) {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "DELETE FROM compte WHERE idCompte = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idCompte);
			ps.executeUpdate();
			
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Compte> findAllComptes() {
		List<Compte> listeComptes = new ArrayList<Compte>();
		CompteCourant cptCourant = new CompteCourant();
		CompteEpargne cptEpargne = new CompteEpargne();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM compte";
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("idCompte") == rs.getInt("idCompteCourant")) {

					cptCourant.setSolde(rs.getDouble("solde"));
					cptCourant.setDateOuverture(rs.getDate("dateOuverture"));
							
					} else if(rs.getInt("idCompte") == rs.getInt("idCompteEpargne")) {

					cptEpargne.setSolde(rs.getDouble("solde"));
					cptEpargne.setDateOuverture(rs.getDate("dateOuverture"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listeComptes;

	}
	
/**
 * CRUD Carte	
 */
	
	@Override
	public void creerCartePremier(CarteVisaPremier crtPremier) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void creerCarteElectron(CarteVisaElectron crtElectron) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void creerCarte(Carte crt) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "INSERT INTO carte(dateExpiration, cryptogramme, plafondPaiement, plafondRetrait) +"
								+ " VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ps.setDate(1, (Date) crt.getDateExpiration()); 
			ps.setInt(2, crt.getCryptogramme());
			ps.setFloat(3, crt.getPlafondPaiement());
			ps.setFloat(4, crt.getPlafondRetrait());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		
		
	}
	@Override
	public Carte lireCarte(int idCarte) {
		CarteVisaElectron crtElectron = new CarteVisaElectron();
		CarteVisaPremier crtPremier = new CarteVisaPremier();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM carte WHERE idCarte = ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idCarte);

			ResultSet rs = ps.executeQuery();
				rs.next();
				if(rs.getInt("idCarte") == rs.getInt("idCartePremier")) {

					crtPremier.setIdCarte(rs.getInt("idCarte"));
					crtPremier.setDateExpiration(rs.getDate("dateExpiration"));
					crtPremier.setCryptogramme(rs.getInt("cryptogramme"));
					crtPremier.setPlafondPaiement(rs.getFloat("plafondPaiement"));
					crtPremier.setPlafondRetrait(rs.getFloat("plafondRetrait"));
		
				} else if(rs.getInt("idCarte") == rs.getInt("idCarteElectron")) {

					crtElectron.setIdCarte(rs.getInt("idCarte"));
					crtElectron.setDateExpiration(rs.getDate("dateExpiration"));
					crtElectron.setCryptogramme(rs.getInt("cryptogramme"));
					crtElectron.setPlafondPaiement(rs.getFloat("plafondPaiement"));
					crtElectron.setPlafondRetrait(rs.getFloat("plafondRetrait"));
					
					}
				
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return crtElectron; // à revoir

		
	}
	@Override
	public void modifierCarte(Carte crt) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "UPDATE carte SET plafondPaiement = ?, plafondRetrait = ? " +
							 " WHERE idCarte = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);

			ps.setDouble(1, crt.getPlafondPaiement());			
			ps.setDouble(1, crt.getPlafondRetrait());			
			ps.setInt(3, crt.getIdCarte());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void supprimerCarte(int idCarte) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "DELETE FROM carte WHERE idCarte = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idCarte);
			ps.executeUpdate();
			
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Carte> findAllCartes() {
		List<Carte> listeCartes = new ArrayList<Carte>();
		CarteVisaElectron crtElectron = new CarteVisaElectron();
		CarteVisaPremier crtPremier = new CarteVisaPremier();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";
			
			Connection conn = DriverManager.getConnection(adresse, login, mdp);
			
			String requete = "SELECT * FROM carte";
			PreparedStatement ps = conn.prepareStatement(requete);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("idCarte") == rs.getInt("idCartePremier")) {

					crtPremier.setIdCarte(rs.getInt("idCarte"));
					crtPremier.setDateExpiration(rs.getDate("dateExpiration"));
					crtPremier.setCryptogramme(rs.getInt("cryptogramme"));
					crtPremier.setPlafondPaiement(rs.getFloat("plafondPaiement"));
					crtPremier.setPlafondRetrait(rs.getFloat("plafondRetrait"));
		
					} else if(rs.getInt("idCarte") == rs.getInt("idCarteElectron")) {

					crtElectron.setIdCarte(rs.getInt("idCarte"));
					crtElectron.setDateExpiration(rs.getDate("dateExpiration"));
					crtElectron.setCryptogramme(rs.getInt("cryptogramme"));
					crtElectron.setPlafondPaiement(rs.getFloat("plafondPaiement"));
					crtElectron.setPlafondRetrait(rs.getFloat("plafondRetrait"));
					
					}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeCartes;
	}
	
	
	@Override
	public Agence getAgence(int idAgence) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "SELECT * FROM agence WHERE idAgence LIKE ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idAgence);

			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				rs.next();
	
				Agence a = new Agence();
				a.setIdAgence(rs.getInt("idAgence"));
				a.setNomAgence(rs.getString("nomAgence"));
				a.setAdresseAgence(rs.getString("adresseAgence"));
				a.setCodePostalAgence(rs.getInt("codePostalAgence"));
				a.setDateCreation(rs.getDate("dateCreation"));
			
			} else System.out.println("Aucun résultat.");
			

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Employe getEmploye(int idEmploye) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "SELECT * FROM employe WHERE idEmploye LIKE ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idEmploye);

			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				rs.next();
			
				int agenceID = rs.getInt("AgenceID");
				Agence a = new Agence();
				a.setIdAgence(agenceID);
			
				if(rs.getInt("idEmploye") == rs.getInt("idGerant")) {
					Gerant g = new Gerant();
					g.setIdEmploye(rs.getInt("idEmploye"));
					g.setNomEmploye(rs.getString("nomEmploye"));
					g.setPrenomEmploye(rs.getString("prenomEmploye"));
				
					g.setMonAgence(a); }
				
					else if(rs.getInt("idEmploye") == rs.getInt("idConseiller")) {
				
					Conseiller csl = new Conseiller();
					csl.setIdEmploye(rs.getInt("idEmploye"));
					csl.setNomEmploye(rs.getString("nomEmploye"));
					csl.setPrenomEmploye(rs.getString("prenomEmploye"));
				
					csl.setMonAgence(a);
	
				} else System.out.println("Aucun résultat.");
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Client getClient(int idClient) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "SELECT * FROM client WHERE idClient LIKE ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idClient);

			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				rs.next();
			
				int conseillerID = rs.getInt("employeID");
				Conseiller csl = new Conseiller();
				csl.setIdEmploye(conseillerID);
			
				if(rs.getInt("idClient") == rs.getInt("idClientParticulier")) {
					ClientParticulier cltPart = new ClientParticulier();
					
					cltPart.setIdClient(rs.getInt("idClient"));
					cltPart.setNomClient(rs.getString("nomClient"));
					cltPart.setPrenomClient(rs.getString("prenomClient"));
					cltPart.setAdresseClient(rs.getString("adresseClient"));
					cltPart.setCodePostal(rs.getInt("codePostal"));
					cltPart.setVille(rs.getString("ville"));
					cltPart.setTelClient(rs.getString("telClient"));
					cltPart.setEmailClient(rs.getString("emailClient"));
					
					cltPart.setMonConseiller(csl);
		
					} else if(rs.getInt("idClient") == rs.getInt("idClientEntreprise")) {
						ClientEntreprise cltEnt = new ClientEntreprise();
					
						cltEnt.setIdClient(rs.getInt("idClient"));
						cltEnt.setNomClient(rs.getString("nomClient"));
						cltEnt.setPrenomClient(rs.getString("prenomClient"));
						cltEnt.setAdresseClient(rs.getString("adresseClient"));
						cltEnt.setCodePostal(rs.getInt("codePostal"));
						cltEnt.setVille(rs.getString("ville"));
						cltEnt.setTelClient(rs.getString("telClient"));
						cltEnt.setEmailClient(rs.getString("emailClient"));
						cltEnt.setMatricule(rs.getString("matriculeEntreprise"));
						
						cltEnt.setMonConseiller(csl);
					}
	
				}
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Compte getCompte(int idCompte) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "SELECT * FROM compte WHERE idCompte LIKE ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idCompte);

			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				rs.next();
			
				if(rs.getInt("particulierID") != 0) {
					int clientID = rs.getInt("clientID");
					ClientParticulier cltPart = new ClientParticulier();
					cltPart.setIdClient(clientID);
					
					if(rs.getInt("idCompte") == rs.getInt("idCompteCourant")) {
						CompteCourant cptCourant = new CompteCourant();
							
						cptCourant.setSolde(rs.getDouble("solde"));
						cptCourant.setDateOuverture(rs.getDate("dateOuverture"));
						cptCourant.setMonProprietaire(cltPart);
								
						} else if(rs.getInt("idCompte") == rs.getInt("idCompteEpargne")) {
							CompteEpargne cptEpargne = new CompteEpargne();
							
							cptEpargne.setSolde(rs.getDouble("solde"));
							cptEpargne.setDateOuverture(rs.getDate("dateOuverture"));
							cptEpargne.setMonProprietaire(cltPart);
						}
					
				} else if(rs.getInt("entrepriseID") != 0) {
					int clientID = rs.getInt("clientID");
					ClientEntreprise cltEnt = new ClientEntreprise();
					cltEnt.setIdClient(clientID);
					
					if(rs.getInt("idCompte") == rs.getInt("idCompteCourant")) {
						CompteCourant cptCourant = new CompteCourant();
							
						cptCourant.setSolde(rs.getDouble("solde"));
						cptCourant.setDateOuverture(rs.getDate("dateOuverture"));
						cptCourant.setMonProprietaire(cltEnt);
						
						} else if(rs.getInt("idCompte") == rs.getInt("idCompteEpargne")) {
							CompteEpargne cptEpargne = new CompteEpargne();
							
							cptEpargne.setSolde(rs.getDouble("solde"));
							cptEpargne.setDateOuverture(rs.getDate("dateOuverture"));
							cptEpargne.setMonProprietaire(cltEnt);
						}
				}
			}
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Carte getCarte(int idCarte) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "SELECT * FROM carte WHERE idCarte LIKE ?";
			PreparedStatement ps = conn.prepareStatement(requete);
			ps.setInt(1, idCarte);

			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				rs.next();
				
				if(rs.getInt("compteCourantID") != 0) {
					int compteCourantID = rs.getInt("compteCourantID");
					CompteCourant cptCourant = new CompteCourant();
					cptCourant.setIdCompte(compteCourantID);
				
					if(rs.getInt("idCarte") == rs.getInt("idCartePremier")) {
						CarteVisaPremier crtPremier = new CarteVisaPremier();
						crtPremier.setIdCarte(rs.getInt("idCarte"));
						crtPremier.setDateExpiration(rs.getDate("dateExpiration"));
						crtPremier.setCryptogramme(rs.getInt("cryptogramme"));
						crtPremier.setPlafondPaiement(rs.getFloat("plafondPaiement"));
						crtPremier.setPlafondRetrait(rs.getFloat("plafondRetrait"));
						
						crtPremier.setMonCompte(cptCourant);
			
						} else if(rs.getInt("idCarte") == rs.getInt("idCarteElectron")) {
							CarteVisaElectron crtElectron = new CarteVisaElectron();	
							crtElectron.setIdCarte(rs.getInt("idCarte"));
							crtElectron.setDateExpiration(rs.getDate("dateExpiration"));
							crtElectron.setCryptogramme(rs.getInt("cryptogramme"));
							crtElectron.setPlafondPaiement(rs.getFloat("plafondPaiement"));
							crtElectron.setPlafondRetrait(rs.getFloat("plafondRetrait"));
						
							crtElectron.setMonCompte(cptCourant);
							
				} else if(rs.getInt("compteEpargneID") != 0) {
					
					int compteEpargneID = rs.getInt("compteEpargneID");
					CompteEpargne cptEpargne = new CompteEpargne();
					cptEpargne.setIdCompte(compteEpargneID);
				
					if(rs.getInt("idCarte") == rs.getInt("idCartePremier")) {
						CarteVisaPremier crtPremier = new CarteVisaPremier();
						crtPremier.setIdCarte(rs.getInt("idCarte"));
						crtPremier.setDateExpiration(rs.getDate("dateExpiration"));
						crtPremier.setCryptogramme(rs.getInt("cryptogramme"));
						crtPremier.setPlafondPaiement(rs.getFloat("plafondPaiement"));
						crtPremier.setPlafondRetrait(rs.getFloat("plafondRetrait"));
					
						crtPremier.setMonCompte(cptEpargne);
		
					} else if(rs.getInt("idCarte") == rs.getInt("idCarteElectron")) {
						CarteVisaElectron crtElectron = new CarteVisaElectron();	
						crtElectron.setIdCarte(rs.getInt("idCarte"));
						crtElectron.setDateExpiration(rs.getDate("dateExpiration"));
						crtElectron.setCryptogramme(rs.getInt("cryptogramme"));
						crtElectron.setPlafondPaiement(rs.getFloat("plafondPaiement"));
						crtElectron.setPlafondRetrait(rs.getFloat("plafondRetrait"));
					
						crtElectron.setMonCompte(cptEpargne);
					}
				}
			}
		}
		
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
				
				
		return null;
	}
	@Override
	public void attribuerEmployeAgence(Employe epl, Agence a) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String adresse = "jdbc:mysql://localhost:3306/proxibanque";
			String login = "root";
			String mdp = "";

			Connection conn = DriverManager.getConnection(adresse, login, mdp);

			String requete = "UPDATE employe SET employe.agenceId = ? " + 
								"WHERE employe.idEmploye = ? ";
			PreparedStatement ps = conn.prepareStatement(requete);		
			ps.setInt(1, a.getIdAgence());
			ps.setInt(2, epl.getIdEmploye());
	
			ps.executeUpdate();
			
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Employe> employesDeLAgence(int idAgence) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void attribuerClientEmploye(Client clt, Employe epl) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Client> clientsDuConseiller(int idEmploye) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void attribuerCompteClient(Compte cpt, Client clt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Compte> comptesDuClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void attribuerCarteCompte(Carte crt, Compte cpt) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
/**
 * L'utilisateur doit s'authentifier avant de pouvoir utiliser d'autres fonctionnalites.
 */
	@Override
	public void seConnecter(String loginEmploye, String passwordEmploye) {
			
		System.out.println("L'employe se connecte.");
	}	
/**
 * La methode faireVirement permet d'effectuer un virement entre un compte emetteur et un compte receveur.
 */
	@Override
	public void faireVirement(Compte cpt1, Compte cpt2) {
		
		System.out.println("Un virement a ete effectue du compte 1 vers le compte 2.");
	}
/**
 * La methode activerCarte permet d'activer la carte bancaire liee a un compte du client.
 */
	@Override
	public void activerCarte(Carte crt) {
		
		System.out.println("La carte a ete activee.");
	}
/**
 * La methode activerCarte permet desactiver la carte bancaire liee a un compte du client.
 */
	@Override
	public void desactiverCarte(Carte crt) {
		
		System.out.println("La carte a ete desactivee.");
	}
/**
 * La methode simulerCredit permet de simuler un credit de consommation ou immobilier.
 */
	@Override
	public void simulerCredit() {
		
		System.out.println("Simulation de credit.");
	}
/**
 * La methode gererPatrimoine permet de gerer les patrimoines des clients fortunes.
 */
	@Override
	public void gererPatrimoine() {
		
		System.out.println("Gestion de patrimoine");
	}
/**
 * Propre au gerant, la methode gererConseiller lui permet de gerer les conseillers de son agence. 
 */
	@Override
	public void gererConseiller(Conseiller csl) {
		
		System.out.println("Gestion de conseillers.");
	}
/**
 * Propre au gerant, la methode gererConseiller lui permet de gerer son agence. 
 */
	@Override
	public void gererAgence(Agence a) {
		
		System.out.println("Gestion d'agence.");
	}
/**
 * La methode auditer permet a l'auditeur de faire l'audit sur les comptes des clients.	
 */
	@Override
	public void auditer(Compte cpt) {
		
		System.out.println("Service d'audit.");
	}

}
