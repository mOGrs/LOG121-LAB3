package vue;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import commandes.ChargerImageAction;
import commandes.DeserialisationPerspectiveAction;

/**
 * Cette classe rassemble les éléments des menus des classes FenetrePrincipale
 * et VueInteractive qui leur sont communs.
 */
public class MenuItemsGenerator {
	private static final String MENU_FICHIER_QUITTER = "Quitter";
	private static final String MENU_FICHIER_TITRE = "Fichier";
	private static final String CHARGER_PERSPECTIVE= "Charger une perspective";
	private static final String MENU_FICHIER_CHARGER_IMAGE = "Charger image";
	
	/**
	 * Crée le menu de fichier offrant des options déroulantes. 
	 * @return menu
	 */
	public static JMenu creerMenuFichier() {
		JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
		return menuFichier;
	}
	
	/**
	 * Crée un item de menu permettant de quitter le programme. 
	 * @return item
	 */
	public static JMenuItem creerMenuItemQuitter() {
		JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);
		menuQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});
		return menuQuitter;
	}
	
	/**
	 * Permet de creer un item permettant de charger une perspective pour une vue 
	 * individuelle.
	 * @param vue
	 * @return JMenuItem
	 */
	public static JMenuItem creerItemMenuChargerPerpsective(Vue vue) {
		return creerItemMenuChargerPerpsective(convertirVueEnArrayListVues(vue));
	}
	
	/**
	 * Permet de creer un item permettant de charger une perspective pour plusieurs vues en
	 * même temps. 
	 * @param vue
	 * @return JMenuItem
	 */
	public static JMenuItem creerItemMenuChargerPerpsective(ArrayList<Vue> vues) {
		JMenuItem itemDeserialiser = new JMenuItem(CHARGER_PERSPECTIVE);
		itemDeserialiser.addActionListener(new DeserialisationPerspectiveAction(vues));
		return itemDeserialiser;
	}
	
	/**
	 * Permet de creer un item permettant de charger une image pour une vue individuelle.
	 * @param vue
	 * @return JMenuItem
	 */
	public static JMenuItem creerItemMenuChargerImage(Vue vue) {
		return creerItemMenuChargerImage(convertirVueEnArrayListVues(vue));
	}
	
	/**
	 * Permet de creer un item permettant de charger une image pour plusierus vues en
	 * même temps. 
	 * @param vue
	 * @return JMenuItem
	 */
	public static JMenuItem creerItemMenuChargerImage(ArrayList<Vue> vues) {
		JMenuItem itemCharger = new JMenuItem(MENU_FICHIER_CHARGER_IMAGE);
		itemCharger.addActionListener(new ChargerImageAction(vues));
		return itemCharger;
	}
	
	/**
	 * @param vue: la vue à convertir en ArrayList
	 * @return: ArrayList de vues
	 */
	public static ArrayList<Vue> convertirVueEnArrayListVues(Vue vue){
		ArrayList<Vue> vues = new ArrayList<Vue>();
		vues.add(vue);
		return vues;
	}
}
