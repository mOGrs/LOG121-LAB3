package copierColler;

import modele.Perspective;
import modele.PerspectiveMemento;

public class StrategieEchelle extends StrategieCopie{

	@Override
	public void coller(Perspective perspective) {
		this.original = (PerspectiveMemento) perspective.saveStateToMemento();
		perspective.setFacteurZoom(this.memento.getFacteurZoom());
	}

	@Override
	public void defaire(Perspective perspective) {
		perspective.setFacteurZoom(this.original.getFacteurZoom());
	}
}
