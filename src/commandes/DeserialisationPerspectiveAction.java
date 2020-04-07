/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: DeserialisationPerspectiveAction.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.Vue;

/**
 * Cette classe permet de charger un fichier ser représenant 
 * une perspective et d'ensuite l'appliquer à plusieurs vues à l'aide 
 * de DeserialisationPerspectiveCommande. 
 */
public class DeserialisationPerspectiveAction extends PouvantEtreAppliqueAPlusieursVuesAction {
	private static final String LAST_USED_FOLDER = ""; //Permet de garder en mémoire l'emplacement 
	//de la dernière image sélectionnée
	private static final String EXTENSION = "ser";
	private static final String DESCRIPTION = ".ser";
	
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
		FileNameExtensionFilter filtre = new FileNameExtensionFilter(DESCRIPTION, EXTENSION);
		fileChooser.addChoosableFileFilter(filtre);

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) { //Si le fichier est valable
			prefs.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
			String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
			for(Vue vue:vues) {
				//On applique la perpective à toutes les vues passées en paramètres. 
				gc.faireCommande(new DeserialisationPerspectiveCommande(vue.getPerspective(), imagePath));
			}
		}
	}

}
