/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: TranslationAction.java
Date créé: 2019-04-06
Date créé: 2019-04-06
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
 * Permet de créer des instances de TranslationCommande (qui vont ensuite faire bouger les images) à 
 * partir du drag d'une sourie.
 */
public class TranslationAction extends PerspectiveAbstractAction implements MouseListener, MouseMotionListener{
	private int xDepart = 0;
	private int yDepart = 0;
	private int xFin = 0;
	private int yFin = 0;
	
	//Ces variables sont utilisées pour déterminer si la translation
	//effectué est un mouvement complet où si c'est seulement un translation spontanée
	private int xClicked = 0;
	private int yClicked = 0;
	
	public TranslationAction(Perspective perspective) {
		super(perspective);
	}

	@Override
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		//Lorsque l'image est manipulé, des objets TranslationCommande sont
		//exécutés, mais seule l'instance finale se garder en mémoire pour être
		//défaite/refaite. 
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
		//On prend en note les coordonnées initales de l'image au début du mouvement. 
		xClicked = e.getPoint().x;
		yClicked = e.getPoint().y;
		xDepart = xClicked;
		yDepart = yClicked;

	}

	/**
	 * Mouse released est toujours appelé après mouseDragged. 
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		//Lorsque la souris est relâchée, c'est à ce moment que l'objet 
		//TranslationCommande qui pourra être défait et refait est créé. 
		int deplacementX = xFin - xClicked;
		int deplacementY = yFin - yClicked;
		gc.faireCommande(new TranslationCommande(this.getPerspective(), new Point(deplacementX, deplacementY), true));
	}
}
