package commandes;

import java.awt.event.ActionEvent;

import modele.Perspective;

public abstract class PerspectiveAbstractAction extends GeneralAbstraction{
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
