package commandes;

import java.awt.event.ActionEvent;

import modele.Perspective;

/**
 * Classe mère facilitant l'implémentation d'action devant agir sur une Perspective. 
 */
public abstract class PerspectiveAbstractAction extends GeneralActionAbstraction{
	private Perspective perspective;

	public PerspectiveAbstractAction(Perspective perspective) {
		super();
		this.perspective = perspective;
	}

	public Perspective getPerspective() {
		return perspective;
	}

	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}
}
