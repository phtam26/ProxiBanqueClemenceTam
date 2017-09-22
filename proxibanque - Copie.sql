-
CREATE TABLE employe
(idEmploye INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomEmploye VARCHAR(32) NULL,
prenomEmploye VARCHAR(32) NULL,
emailEmploye VARCHAR(32) NULL,
telEmploye INT NULL,
loginEmploye VARCHAR(32) NULL,
motDePasse VARCHAR(32) NULL
) ENGINE = InnoDB;

CREATE TABLE agence
(idAgence INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nomAgence VARCHAR(32) NULL,
adresseAgence VARCHAR(32) NULL,
codePostalAgence INT NULL,
dateCreation DATE NULL
) ENGINE = InnoDB;

CREATE TABLE client
(idClient INT NULL AUTO_INCREMENT PRIMARY KEY,
nomClient VARCHAR(32) NULL,
prenomClient VARCHAR(32) NOT NULL,
adresseClient VARCHAR(32) NULL,
codePostal INT NULL,
ville VARCHAR(32) NULL,
telClient INT NULL,
emailClient VARCHAR(32) NULL
) ENGINE = InnoDB;

CREATE TABLE compte
(idCompte INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
solde DOUBLE,
dateOuverture DATE NULL,
decouvert DOUBLE,
taux DOUBLE
) ENGINE = InnoDB;

CREATE TABLE carte
(idCarte INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
dateExpiration DATE NULL,
titulaire VARCHAR(32) NULL,
cryptogramme INT NULL,
plafondPaiement DOUBLE,
plafondRetrait DOUBLE
) ENGINE = InnoDB;


/* association */

ALTER TABLE employe
ADD agenceID INT NULL;
ALTER TABLE employe
ADD CONSTRAINT fk_agenceid FOREIGN KEY (agenceID) REFERENCES agence (idAgence);

ALTER TABLE client
ADD conseillerID INT NULL;
ALTER TABLE client
ADD CONSTRAINT fk_conseillerid FOREIGN KEY (conseillerID) REFERENCES employe (idEmploye);

ALTER TABLE client
ADD gerantID INT NULL;
ALTER TABLE client
ADD CONSTRAINT fk_gerantid FOREIGN KEY (gerantID) REFERENCES employe (idEmploye);

ALTER TABLE compte
ADD clientID INT NULL;
ALTER TABLE compte
ADD CONSTRAINT fk_clientid FOREIGN KEY (clientID) REFERENCES client (idClient);

/* non utilisé*/
ALTER TABLE compte
ADD clientEntrepriseID INT NULL;
ALTER TABLE compte
ADD CONSTRAINT fk_clientEntrepriseid FOREIGN KEY (clientEntrepriseID) REFERENCES client (idClient);




/* heritage */ 

ALTER TABLE employe
ADD idGerant INT NULL;
ALTER TABLE employe
ADD CONSTRAINT fk_heritage_employe_gerant FOREIGN KEY (idGerant) REFERENCES employe (idEmploye) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE employe
ADD idConseiller INT NULL;
ALTER TABLE employe
ADD CONSTRAINT fk_heritage_employe_conseiller FOREIGN KEY (idConseiller) REFERENCES employe (idEmploye) ON DELETE CASCADE ON UPDATE CASCADE;



ALTER TABLE client
ADD idClientParticulier INT NULL;
ALTER TABLE client
ADD CONSTRAINT fk_heritage_client_particulier FOREIGN KEY (idClientParticulier) REFERENCES client(idClient) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE client
ADD idClientEntreprise INT NULL;
ALTER TABLE client
ADD CONSTRAINT fk_heritage_client_entreprise FOREIGN KEY (idClientEntreprise) REFERENCES client(idClient)ON DELETE CASCADE ON UPDATE CASCADE;



ALTER TABLE compte
ADD idCompteCourant INT NULL;
ALTER TABLE compte
ADD CONSTRAINT fk_heritage_compte_courant FOREIGN KEY (idCompteCourant) REFERENCES compte(idCompte)ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE compte
ADD idCompteEpargne INT NULL;
ALTER TABLE compte
ADD CONSTRAINT fk_heritage_compte_epargne FOREIGN KEY (idCompteEpargne) REFERENCES compte(idCompte)ON DELETE CASCADE ON UPDATE CASCADE;




ALTER TABLE carte
ADD idCartePremier INT NULL;
ALTER TABLE carte
ADD CONSTRAINT fk_heritage_carte_premier FOREIGN KEY (idCartePremier) REFERENCES carte(idCarte)ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE carte
ADD idCarteElectron INT NULL;
ALTER TABLE carte
ADD CONSTRAINT fk_heritage_carte_electron FOREIGN KEY (idCarteElectron) REFERENCES carte(idCarte)ON DELETE CASCADE ON UPDATE CASCADE;


INSERT INTO `employe`(`nomEmploye`, `prenomEmploye`, `emailEmploye`) VALUES ("morice","michel","mor.mich@laposte.net")
UPDATE `employe` SET idConseiller=idEmploye WHERE idEmploye=4;