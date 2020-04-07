/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: CollerCommande.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import copierColler.Mediateur;
import copierColler.StrategieCopie;
import modele.Perspective;


/**
 * Cette classe permet de coller à une perspective certains attributs
 * d'une autres perspectives. 
 */
public class CollerCommande implements Command {
	private Perspective perspective;

	/**
	 * 
	 * @param perspective
	 */
	public CollerCommande(Perspective perspective) {
		super();
		this.perspective = perspective;
	}

	@Override
	public boolean faire() {
		StrategieCopie strategie = this.getStrategie();
		strategie.coller(perspective);
		return true;
	}

	@Override
	public void defaire() {
		StrategieCopie strategie = this.getStrategie();
		strategie.defaire(perspective);
	}

	@Override
	public void refaire() {
		StrategieCopie strategie = this.getStrategie();
		strategie.coller(perspective);
	}
	
	/**
	 * Permet d'obtenir la stratégie contenue dans le médiateur du 
	 * système de copier et coller.
	 */
	private StrategieCopie getStrategie() {
		Mediateur mediateur = Mediateur.getInstance();
		return mediateur.getStrategie();
	}
}
