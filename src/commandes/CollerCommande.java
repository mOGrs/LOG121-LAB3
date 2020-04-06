package commandes;

import copierColler.Mediateur;
import copierColler.StrategieCopie;
import modele.Perspective;

public class CollerCommande implements Command {
	private Perspective perspective;

	public CollerCommande(Perspective perspective) {
		super();
		this.perspective = perspective;
	}

	@Override
	public boolean faire() {
		StrategieCopie strategie = this.getStrategie();
		System.out.println("coller: " + strategie.getClass());
		strategie.coller(perspective);
		return true;
	}

	@Override
	public void defaire() {
		StrategieCopie strategie = this.getStrategie();
		strategie.defaire(perspective);
	}

	@Override
	public void refaire() {
		StrategieCopie strategie = this.getStrategie();
		strategie.coller(perspective);
	}
	
	private StrategieCopie getStrategie() {
		Mediateur mediateur = Mediateur.getInstance();
		return mediateur.getStrategie();
	}
}
