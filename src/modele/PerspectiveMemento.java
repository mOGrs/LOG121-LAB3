package modele;

import java.awt.Point;

public class PerspectiveMemento extends Memento{
    private Point emplacement;
    private double facteurZoom;
	public PerspectiveMemento(Point emplacement, double facteurZoom) {
		super();
		this.emplacement = emplacement;
		this.facteurZoom = facteurZoom;
	}
	public Point getEmplacement() {
		return emplacement;
	}
	public double getFacteurZoom() {
		return facteurZoom;
	}
}
