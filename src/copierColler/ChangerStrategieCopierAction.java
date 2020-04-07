/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: ChangerStrategieCopierAction.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package copierColler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import vue.VueInteractive;

/**
 * Cette permet aux vues de changer leur strat�gie pour copier et coller. 
 */
public class ChangerStrategieCopierAction extends AbstractAction{
	private VueInteractive vue;
	private StrategieCopie strategie;

	public ChangerStrategieCopierAction(VueInteractive vue, StrategieCopie strategie) {
		super();
		this.vue = vue;
		this.strategie = strategie;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Puisque l'on n'interragit pas avec le mod�le, nous avons d�cider 
		//d'agir directement sur la vue
		this.vue.setStrategie(strategie);
	}
}
