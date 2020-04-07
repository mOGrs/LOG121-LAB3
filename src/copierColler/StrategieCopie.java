/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: StrategieCopie.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package copierColler;

import modele.Perspective;
import modele.PerspectiveMemento;

/**
 * Cette classe permet de Copier et de coller des �l�metns d'une perspective. 
 */
public abstract class StrategieCopie {
	protected PerspectiveMemento memento;
	protected PerspectiveMemento original;
	private Mediateur mediateur;
	
	public StrategieCopie() {
		this.mediateur = Mediateur.getInstance();
	}
	
	/**
	 * Des qu'une perspective est copi�e, la strat�gie l'ayant prise en m�moire
	 * devient la strat�gie � partir de laquelle les actions �coller� vont se faire. 
	 */
	public void copier(Perspective perspective) {
		this.memento = (PerspectiveMemento) perspective.saveStateToMemento();
		mediateur.setStrategie(this);
	}
	
	public abstract void defaire(Perspective perspective);
	public abstract void coller(Perspective perspective);
}
