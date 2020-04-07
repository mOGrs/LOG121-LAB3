/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: StrategieEchelleEtTranslation.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package copierColler;

import modele.Perspective;
import modele.PerspectiveMemento;

/**
 * Permet de coller l'Echelle  et la Translation d'une Perspective
 */
public class StrategieEchelleEtTranslation extends StrategieCopie{

	@Override
	public void coller(Perspective perspective) {
		this.original = (PerspectiveMemento) perspective.saveStateToMemento();
		perspective.getStateFromMemento(memento);
	}

	@Override
	public void defaire(Perspective perspective) {
		perspective.getStateFromMemento(original);
	}
}
