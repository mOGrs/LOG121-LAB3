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

import java.util.LinkedList;

/**
 * Gestionnaire de commandes impl.menter en suivant un Patron Singleton et qui
 *  devrait en principe �tre le seul � ex�cuter toutes les commandes. 
 */
public class GestionnaireCommandes {
	private static GestionnaireCommandes SINGLETON = null;
	private LinkedList<Command> historique = new LinkedList<Command>();
	private LinkedList<Command> listeRefaire = new LinkedList<Command>();
	
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
        } else if(cmd instanceof RefaireCommande) {
        	refaire();
        }else if(cmd.faire()) {
			historique.add(cmd);
			//D�s que l'on fait faire, on brise la liste des commandes � refaire,
			//on doit donc vider la liste � refaire 
			if(listeRefaire.size() > 0) {
				listeRefaire.clear();
			}
        }
	}
	
	/**
	 * Permet de f�faire les commandes effectu�es
	 */
    private void defaire() {
        if (historique.size() > 0) {
        	Command cmd = historique.removeLast();
        	cmd.defaire();
            listeRefaire.add(cmd);
        }
    }
    
	/**
	 * Permet de refaire les commandes d�faites directement apr�s les avoir d�faites.
	 * VOIR FAIRE COMMANDE
	 */
    private void refaire() {
        if (listeRefaire.size() > 0) {
        	Command cmd = listeRefaire.removeLast();
        	cmd.refaire();
        	historique.add(cmd);
        }
    }
}
