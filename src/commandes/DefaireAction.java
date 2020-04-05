package commandes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Cette classe n'hérite pas de PerpectiveAbstractAction, car elle n'agit par sur 
 * une perspective en particulier. C'est la commande qui connait la perspective à laquelle
 * elle est associée. 
 */

public class DefaireAction extends GeneralAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gc.faireCommande(new DefaireCommande());
	}
}
