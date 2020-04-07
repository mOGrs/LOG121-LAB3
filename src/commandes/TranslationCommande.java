/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: TranslationCommande.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import java.awt.Point;

import modele.Memento;
import modele.Perspective;
import modele.PerspectiveMemento;

/**
 * Commande permettant de déplacer une image en appliquant une translation sur une Perspective.
 */
public class TranslationCommande implements Command{
	private Point translation;
	private PerspectiveMemento nouvellePerspective;
	private Perspective perspective;
	private boolean translationComplete;
	
	public TranslationCommande(Perspective perspective, Point translation, boolean translationComplete) {
		super();
		this.perspective = perspective;
		this.translation = translation;
		this.translationComplete = translationComplete;
	}
	
	public Point getTranslation() {
		return translation;
	}
	
	public void setTranslation(Point translation) {
		this.translation = translation;
	}

	@Override
	public boolean faire() {
		if(!this.translationComplete) {
			int newX = perspective.getX() + translation.x;
			int newY =  perspective.getY() + translation.y;
			perspective.setEmplacement(new Point(newX, newY));
		} else {
			nouvellePerspective = (PerspectiveMemento) perspective.saveStateToMemento();
		}
		return translationComplete;
	}

	@Override
	public void defaire() {
		int newX = perspective.getX() - translation.x;
		int newY =  perspective.getY() - translation.y;
		perspective.setEmplacement(new Point(newX, newY));
	}

	@Override
	public void refaire() {
		this.perspective.getStateFromMemento(nouvellePerspective);
	}
}
