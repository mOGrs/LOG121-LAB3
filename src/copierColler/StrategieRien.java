/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: StrategieRien.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package copierColler;

import modele.Perspective;

/**
 * Permet de coller l'Echelle  et la Translation d'une Perspective
 */
public class StrategieRien extends StrategieCopie{
	@Override
	public void copier(Perspective perspective) {}

	@Override
	public void coller(Perspective perspective) {}

	@Override
	public void defaire(Perspective perspective) {}
}
