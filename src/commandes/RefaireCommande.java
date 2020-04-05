package commandes;

import modele.Memento;

public class RefaireCommande implements Command{

	@Override
	public boolean faire() {
		return false;
	}

	@Override
	public void defaire() {}

	@Override
	public void refaire() {}
}