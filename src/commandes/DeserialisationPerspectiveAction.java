package commandes;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.Vue;

public class DeserialisationPerspectiveAction extends PouvantEtreAppliqueAPlusieursVuesAction {
	private static final String LAST_USED_FOLDER = ""; //Permet de garder en mémoire l'emplacement 
	//de la dernière image sélectionnée
	
	/**
	 * PAS de constructeur avec des vues individuelles voir la class
	 * PouvantEtreAppliqueAPlusieursVuesAction
	 * @param vues: toutes les vues étant modifiées lorsques le change
	 * la perspective. 
	 */
	public DeserialisationPerspectiveAction(ArrayList<Vue> vues) {
		super(vues);
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
			for(Vue vue:vues) {
				gc.faireCommande(new DeserialisationPerspectiveCommande(vue.getPerspective(), imagePath));
			}
		}
	}

}
