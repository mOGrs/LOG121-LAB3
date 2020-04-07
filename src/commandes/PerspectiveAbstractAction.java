/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: PerspectiveAbstractAction.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import java.awt.event.ActionEvent;

import modele.Perspective;

/**
 * Classe m�re facilitant l'impl�mentation d'action devant agir sur une Perspective. 
 * Ne fait que contenir une perspective comme attribut. 
 */
public abstract class PerspectiveAbstractAction extends GeneralAction{
	private Perspective perspective;

	public PerspectiveAbstractAction(Perspective perspective) {
		super();
		this.perspective = perspective;
	}

	public Perspective getPerspective() {
		return perspective;
	}
	
	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}
}
