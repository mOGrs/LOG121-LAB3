package commandes;

import modele.Perspective;

public class ZoomCommande implements Command{
	private final static double MULTI_AGRANDISSEMENT = 1.1;
	private final static double MULTI_RAPETISSEMENT = 0.9;
	
	private Perspective perspective;
	private double toursSouris;
	
	public ZoomCommande(Perspective perspective, double toursSouris) {
		super();
		this.perspective = perspective;
		this.toursSouris = toursSouris;
	}

	@Override
	public boolean faire() {
		double multiplicateur = 1.0;
		if(toursSouris > 0) {
			multiplicateur = MULTI_AGRANDISSEMENT;
		} else if(toursSouris < 0) {
			multiplicateur = MULTI_RAPETISSEMENT;
		}
		double facteur = perspective.getFacteurZoom();
		System.out.println(facteur);
		this.perspective.setFacteurZoom(facteur * multiplicateur);
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refaire() {
		// TODO Auto-generated method stub
		
	}

}
