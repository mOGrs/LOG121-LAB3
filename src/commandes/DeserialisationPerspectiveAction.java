package commandes;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.Vue;

public class DeserialisationPerspectiveAction extends FileChooserAction {
	private Vue vue;
	
	public DeserialisationPerspectiveAction(Vue vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Permet de se rappeler le chemin du dernier folder utilisé
		Preferences prefs = Preferences.userRoot().node(getClass().getName());
		JFileChooser fileChooser = new JFileChooser(prefs.get(LAST_USED_FOLDER,new File(".").getAbsolutePath()));
		fileChooser.setDialogTitle("Selectionnez un fichier de perspective à désérialiser");
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		// Creer un filtre
//		FileNameExtensionFilter filtre = new FileNameExtensionFilter(EXTENSION, EXTENSION);
//		fileChooser.addChoosableFileFilter(filtre);

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) { //Si le fichier est valable
			prefs.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
			String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
			gc.faireCommande(new DeserialisationPerspectiveCommande(vue.getPerspective(), imagePath));
		}
	}

}
