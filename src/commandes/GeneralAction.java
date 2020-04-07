/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: GeneralAction.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import javax.swing.AbstractAction;

/**
 * Action abstraite dont peuvent hériter toutes les autres instances d'action et qui 
 * possède déjà une référence vers le gestionnaire de commande. 
 */
public abstract class GeneralAction extends AbstractAction{
	protected final static GestionnaireCommandes gc = GestionnaireCommandes.getGestionnaireCommande();
}