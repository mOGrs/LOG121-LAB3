package commandes;

import modele.Memento;
import modele.Perspective;
import modele.PerspectiveMemento;

/**
 * Commande permettant de changer le focus d'une image
 */
public class ZoomCommande implements Command{
	private final static double MULTI_AGRANDISSEMENT = 1.1;
	private final static double MULTI_RAPETISSEMENT = 0.9;
	
	private PerspectiveMemento nouvellePerspective;
	private Perspective perspective;
	private double toursSouris;
	private double multiplicateur = 1; //Facteur d'agrandissement/rapetissement par
	//défaut (rien n'est changé)
	
	public ZoomCommande(Perspective perspective, double toursSouris) {
		super();
		this.perspective = perspective;
		this.toursSouris = toursSouris;
	}

	@Override
	public boolean faire() {
		if(toursSouris < 0) {
			multiplicateur = MULTI_AGRANDISSEMENT;
		} else if(toursSouris > 0) {
			multiplicateur = MULTI_RAPETISSEMENT;
		}
		double facteur = perspective.getFacteurZoom();
		this.perspective.setFacteurZoom(facteur * multiplicateur);
		nouvellePerspective = (PerspectiveMemento) perspective.saveStateToMemento();
		return true;
	}

	@Override
	public void defaire() {
		double facteur = perspective.getFacteurZoom();
		this.perspective.setFacteurZoom(facteur / multiplicateur);
	}

	@Override
	public void refaire() {
		this.perspective.getStateFromMemento(nouvellePerspective);
	}
}
