/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
       
Professeur :  Vincent Lacasse
Nom du fichier: CollerAction.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import java.awt.event.ActionEvent;

import copierColler.StrategieCopie;
import vue.VueInteractive;

/**
 * Permet d'effectuer une opération de «coller» après avoir copier certains 
 * attributs d'une perspectives. 
 */
public class CollerAction extends GeneralAction{
	private VueInteractive vue; //L'action de coller s'effectue sur la perspective
	//d'une vue. 

	public CollerAction(VueInteractive vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gc.faireCommande(new CollerCommande(vue.getPerspective()));
	}
}
