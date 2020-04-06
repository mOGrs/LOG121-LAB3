package commandes;

import java.awt.event.ActionEvent;

import copierColler.StrategieCopie;
import vue.VueInteractive;

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
