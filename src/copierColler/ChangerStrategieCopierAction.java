package copierColler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import vue.VueInteractive;

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
		//Puisque l'on n'interragit pas avec le modèle, nous avons décider 
		//d'agir directement sur la vue
		this.vue.setStrategie(strategie);
	}
}
