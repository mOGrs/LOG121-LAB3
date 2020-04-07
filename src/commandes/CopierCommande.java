/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: CopierCommande.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import copierColler.StrategieCopie;
import modele.Perspective;

/**
 * Permet de copier la perspective d'une vue.
 */
public class CopierCommande implements Command {
	private StrategieCopie strategie; //La vue à partir de laquelle nous copions
	//nous indique elle-même la stratégie à adopter pour copier la perspective. 
	private Perspective perspective;

	public CopierCommande(StrategieCopie strategie, Perspective perspective) {
		super();
		this.strategie = strategie;
		this.perspective = perspective;
	}

	@Override
	public boolean faire() {
		strategie.copier(perspective);
		return false;
	}

	@Override
	public void defaire() {}

	@Override
	public void refaire() {}
}
