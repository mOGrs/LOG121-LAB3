/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: CopierAction.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
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
 * Permet de copier l'�tat de la perspective d'une vue. 
 */
public class CopierAction extends GeneralAction{
	private VueInteractive vue;

	public CopierAction(VueInteractive vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gc.faireCommande(new CopierCommande(vue.getStrategie(), vue.getPerspective()));
	}
}
