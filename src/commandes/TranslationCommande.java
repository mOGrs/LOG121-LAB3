package commandes;

import java.awt.Point;

import modele.Perspective;

public class TranslationCommande implements Command{
	private Point translation;
	private Perspective perspective;
	
	public TranslationCommande(Perspective perspective, Point translation) {
		super();
		this.perspective = perspective;
		this.translation = translation;
	}
	
	public Point getTranslation() {
		return translation;
	}
	
	public void setTranslation(Point translation) {
		this.translation = translation;
	}

	@Override
	public boolean faire() {
		int newX = perspective.getX() + translation.x;
		int newY =  perspective.getY() + translation.y;
		perspective.setEmplacement(new Point(newX, newY));
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
