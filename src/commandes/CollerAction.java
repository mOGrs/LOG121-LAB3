package commandes;

import java.awt.event.ActionEvent;

import copierColler.StrategieCopie;
import vue.VueInteractive;

public class CollerAction extends GeneralAction{
	private VueInteractive vue;

	public CollerAction(VueInteractive vue) {
		super();
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		gc.faireCommande(new CollerCommande(vue.getPerspective()));
	}
}
