/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Ã‰tudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: GestionnaireCommandes.java
 Date crÃ©Ã©: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package commandes;

import java.util.LinkedList;

/**
 * Gestionnaire de commandes impl.menter en suivant un Patron Singleton et qui devrait en principe 
 * être le seul à exécuter les commandes. 
 */

//SE RÉFÉRER AUX EXEMPLES DONNÉES PAR LE PROF POUR COMPRENDRE LA LOGIQUE
public class GestionnaireCommandes {
	private static GestionnaireCommandes SINGLETON = null;//Utilisation OBLIGATOIRE du SINGLETON
	private LinkedList<Command> historique = new LinkedList<Command>();
	private LinkedList<Command> ListRefaire = new LinkedList<Command>();
	
	private GestionnaireCommandes() {}
	
	public synchronized static GestionnaireCommandes getGestionnaireCommande() {
		if(SINGLETON == null) {
			SINGLETON = new GestionnaireCommandes();
		}
		return SINGLETON;
	}
	
	public void faireCommande(Command cmd) {
		if (cmd instanceof DefaireCommande) {
            defaire();
        }
		if(cmd.faire()) {
			historique.add(cmd);
		}
	}
	
    private void defaire() {
        if (historique.size() > 0) {
        	//On enlève la première commande de la liste. 
        	Command cmd = historique.removeLast();
        	cmd.defaire();
            //aRefaire.addFirst(commandeADefaire);
        } 
    }
}
