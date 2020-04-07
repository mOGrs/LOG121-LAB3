/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: DefaireCommande.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import modele.Memento;

/**
 * Cette classe n'est qu'un contenant vide qui indique au gestionnaire de commande
 * de d�faire la derni�re commande effectu�e. 
 */
public class DefaireCommande implements Command{

	@Override
	public boolean faire() {
		return false;
	}

	@Override
	public void defaire() {}

	@Override
	public void refaire() {}
}
