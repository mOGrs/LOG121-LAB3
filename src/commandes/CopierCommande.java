package commandes;

import copierColler.StrategieCopie;
import modele.Perspective;

public class CopierCommande implements Command {
	private StrategieCopie strategie;
	private Perspective perspective;

	public CopierCommande(StrategieCopie strategie, Perspective perspective) {
		super();
		this.strategie = strategie;
		this.perspective = perspective;
	}

	@Override
	public boolean faire() {
		strategie.copier(perspective);
		return false;
	}

	@Override
	public void defaire() {}

	@Override
	public void refaire() {}
}
