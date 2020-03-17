package commandes;

import javax.swing.AbstractAction;

public abstract class GeneralAbstraction extends AbstractAction{
	protected final static GestionnaireCommandes gc = GestionnaireCommandes.getGestionnaireCommande();
}
