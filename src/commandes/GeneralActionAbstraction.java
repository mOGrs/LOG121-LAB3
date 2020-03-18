package commandes;

import javax.swing.AbstractAction;

/**
 * Action abstraite dont peuvent hériter toutes les autres instances d'action et qui 
 * possède déjà une référence vers le gestionnaire de commande. 
 */
public abstract class GeneralActionAbstraction extends AbstractAction{
	protected final static GestionnaireCommandes gc = GestionnaireCommandes.getGestionnaireCommande();
}