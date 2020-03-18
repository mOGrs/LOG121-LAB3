/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: GestionnaireCommandes.java
 Date créé: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package commandes;

import java.util.ArrayList;

/**
 * Gestionnaire de commandes impl.menter en suivant un Patron Singleton et qui devrait en principe 
 * �tre le seul � ex�cuter les commandes. 
 */

//SE R�F�RER AUX EXEMPLES DONN�ES PAR LE PROF POUR COMPRENDRE LA LOGIQUE
public class GestionnaireCommandes {
	private static GestionnaireCommandes SINGLETON = null;//Utilisation OBLIGATOIRE du SINGLETON
	private ArrayList<Command> historique = new ArrayList<Command>();
	private ArrayList<Command> ListRefaire = new ArrayList<Command>();
	
	private GestionnaireCommandes() {}
	
	public synchronized static GestionnaireCommandes getGestionnaireCommande() {
		if(SINGLETON == null) {
			SINGLETON = new GestionnaireCommandes();
		}
		return SINGLETON;
	}
	
	public void faireCommande(Command cmd) {
		if(cmd.faire()) {
			historique.add(cmd);
		}
	}
}
