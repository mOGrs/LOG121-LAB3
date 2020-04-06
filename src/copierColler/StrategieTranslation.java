package copierColler;

import modele.Perspective;
import modele.PerspectiveMemento;

public class StrategieTranslation extends StrategieCopie{

	@Override
	public void coller(Perspective perspective) {
		this.original = (PerspectiveMemento) perspective.saveStateToMemento();
		perspective.setEmplacement(this.memento.getEmplacement());
	}

	@Override
	public void defaire(Perspective perspective) {
		perspective.setEmplacement(this.original.getEmplacement());
	}
}