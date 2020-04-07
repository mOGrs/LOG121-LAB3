/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: TranslationAction.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

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
		//Lorsque l'image est manipul�, des objets TranslationCommande sont
		//ex�cut�s, mais seule l'instance finale se garder en m�moire pour �tre
		//d�faite/refaite. 
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
		//On prend en note les coordonn�es initales de l'image au d�but du mouvement. 
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
		//Lorsque la souris est rel�ch�e, c'est � ce moment que l'objet 
		//TranslationCommande qui pourra �tre d�fait et refait est cr��. 
		int deplacementX = xFin - xClicked;
		int deplacementY = yFin - yClicked;
		gc.faireCommande(new TranslationCommande(this.getPerspective(), new Point(deplacementX, deplacementY), true));
	}
}
