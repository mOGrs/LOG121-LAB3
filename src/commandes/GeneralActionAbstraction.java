package commandes;

import javax.swing.AbstractAction;

/**
 * Action abstraite dont peuvent h�riter toutes les autres instances d'action et qui 
 * poss�de d�j� une r�f�rence vers le gestionnaire de commande. 
 */
public abstract class GeneralActionAbstraction extends AbstractAction{
	protected final static GestionnaireCommandes gc = GestionnaireCommandes.getGestionnaireCommande();
}