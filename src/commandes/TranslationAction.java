package commandes;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modele.Perspective;

/**
 * Permet de cr�er des instances de TranslationCommande (qui vont ensuite faire bouger les images) � 
 * partir du drag d'une sourie.
 */
public class TranslationAction extends PerspectiveAbstractAction implements MouseListener, MouseMotionListener{
	private int xDepart = 0;
	private int yDepart = 0;
	private int xFin = 0;
	private int yFin = 0;
	
	//Ces variables sont utilis�es pour d�terminer si la translation
	//effectu� est un mouvement complet o� si c'est seulement un translation spontan�e
	private int xClicked = 0;
	private int yClicked = 0;
	
	public TranslationAction(Perspective perspective) {
		super(perspective);
	}

	@Override
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		xFin = e.getPoint().x;
		yFin = e.getPoint().y;
		int deplacementX = xFin - xDepart;
		int deplacementY = yFin - yDepart;
		gc.faireCommande(new TranslationCommande(this.getPerspective(), new Point(deplacementX, deplacementY), false));
		xDepart = e.getPoint().x;
		yDepart = e.getPoint().y;
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		xClicked = e.getPoint().x;
		yClicked = e.getPoint().y;
		xDepart = xClicked;
		yDepart = yClicked;

	}

	/**
	 * Mouse released est toujours appel� apr�s mouseDragged. 
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		int deplacementX = xFin - xClicked;
		int deplacementY = yFin - yClicked;
		gc.faireCommande(new TranslationCommande(this.getPerspective(), new Point(deplacementX, deplacementY), true));
	}
}
