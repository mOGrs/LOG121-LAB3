package copierColler;

import modele.Perspective;
import modele.PerspectiveMemento;

public abstract class StrategieCopie {
	protected PerspectiveMemento memento;
	protected PerspectiveMemento original;
	private Mediateur mediateur;
	
	public StrategieCopie() {
		this.mediateur = Mediateur.getInstance();
	}
	
	public void copier(Perspective perspective) {
		this.memento = (PerspectiveMemento) perspective.saveStateToMemento();
		mediateur.setStrategie(this);
	}
	public abstract void defaire(Perspective perspective);
	public abstract void coller(Perspective perspective);
}
