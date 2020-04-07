/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: PerspectiveMemento.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package modele;

import java.awt.Point;

/**
 * Permet de sauvegarder les éléments d'un objet Perspective. 
 */
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
