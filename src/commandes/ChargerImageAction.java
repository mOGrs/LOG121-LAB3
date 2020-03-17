package commandes;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Image;
import vue.Vue;

public class ChargerImageAction extends GeneralAbstraction {
	private static final String LAST_USED_FOLDER = "";
	ArrayList<Vue> vues = new ArrayList<Vue>();
	
	public ChargerImageAction(ArrayList<Vue> vues) {
		super();
		this.vues = vues;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Permet de se rappeler le chemin du dernier folder utilisé
		Preferences prefs = Preferences.userRoot().node(getClass().getName());
		JFileChooser fileChooser = new JFileChooser(prefs.get(LAST_USED_FOLDER,new File(".").getAbsolutePath()));
		//JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Sï¿½lectionnez un fichier de configuration");
		fileChooser.setAcceptAllFileFilterUsed(false);
		// Crï¿½er un filtre
		FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png", "png", ".jpg", "jpg");
		fileChooser.addChoosableFileFilter(filtre);

		int returnValue = fileChooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			prefs.put(LAST_USED_FOLDER, fileChooser.getSelectedFile().getParent());
			String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println(imagePath);
			for(Vue vue:vues) {
				gc.faireCommande(new ChargerImageCommande(vue.getImage(), imagePath));
			}
		}
	}
}
