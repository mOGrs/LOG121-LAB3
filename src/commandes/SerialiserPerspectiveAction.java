/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: Simulation.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
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
 * Permet de s�rialiser la perspective d'une vue en ouvrant un explorateur 
 * de fichier permettant de s�lectionner le fichier et l'endroit dans lequel 
 * effectuer l'op�ration. La r�sialisation est effectu�e par un objet
 * SerialiserPerspectiveCommande. 
 */
public class SerialiserPerspectiveAction extends GeneralAction {
	private static final String LAST_USED_FOLDER = ""; //Permet de garder en m�moire l'emplacement 
	//de la derni�re image s�lectionn�e
	private static final String EXTENSION = ".ser"; //Par convention, 
	//les Perspectives s�rialis�es le seront dans des fichiers .ser
	private Vue vue;
	
	public SerialiserPerspectiveAction(Vue vue) {
		this.vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Permet de se rappeler le chemin du dernier folder utilis�
		Preferences prefs = Preferences.userRoot().node(getClass().getName());
		JFileChooser fileChooser = new JFileChooser(prefs.get(LAST_USED_FOLDER,new File(".").getAbsolutePath()));
		fileChooser.setDialogTitle("Selectionnez un emplacement et un nom de fichier");
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		// Creer un filtre
		FileNameExtensionFilter filtre = new FileNameExtensionFilter(EXTENSION, EXTENSION);
		fileChooser.setFileFilter(filtre);

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) { //Si le fichier est valable
			prefs.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
			String imagePath = fileChooser.getSelectedFile().getAbsolutePath()+EXTENSION;
			gc.faireCommande(new SerialiserPerspectiveCommande(vue.getPerspective(), imagePath));
		}
	}

}
