package copierColler;

import modele.Perspective;
import modele.PerspectiveMemento;

public class StrategieEchelleEtTranslation extends StrategieCopie{

	@Override
	public void coller(Perspective perspective) {
		this.original = (PerspectiveMemento) perspective.saveStateToMemento();
		perspective.getStateFromMemento(memento);
	}

	@Override
	public void defaire(Perspective perspective) {
		perspective.getStateFromMemento(original);
	}
}
