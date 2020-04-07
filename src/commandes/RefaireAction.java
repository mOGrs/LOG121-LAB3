/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: RefaireAction.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Cette classe n'h�rite pas de PerpectiveAbstractAction, car elle n'agit par sur 
 * une perspective en particulier. C'est la commande qui connait la perspective � laquelle
 * elle est associ�e. 
 */

public class RefaireAction extends GeneralAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gc.faireCommande(new RefaireCommande());
	}
}
