/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: ZoomCommande.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import modele.Memento;
import modele.Perspective;
import modele.PerspectiveMemento;

/**
 * Commande permettant de changer le facteur d'�chelle d'une image. 
 */
public class ZoomCommande implements Command{
	private final static double MULTI_AGRANDISSEMENT = 1.1;
	private final static double MULTI_RAPETISSEMENT = 0.9;
	
	private PerspectiveMemento nouvellePerspective;
	private Perspective perspective;
	private double toursSouris;
	private double multiplicateur = 1; //Facteur d'agrandissement/rapetissement par
	//d�faut (rien n'est chang�)
	
	public ZoomCommande(Perspective perspective, double toursSouris) {
		super();
		this.perspective = perspective;
		this.toursSouris = toursSouris;
	}

	@Override
	public boolean faire() {
		if(toursSouris < 0) {//Si l'on roule la sourie vers l'avant, on agrandit
			multiplicateur = MULTI_AGRANDISSEMENT;
		} else if(toursSouris > 0) {//Si l'on roule la sourie vers l'arri�re, on rapetisse
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
