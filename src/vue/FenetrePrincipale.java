package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import commandes.ChargerImageAction;
import commandes.DefaireAction;
import modele.Image;
import modele.Modele;

/**
 *
 */
public class FenetrePrincipale extends MappedActionsJFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121";
	private static final Dimension DIMENSION = new Dimension(300, 55);
	private static final String MENU_FICHIER_TITRE = "Fichier";
	private static final String MENU_FICHIER_CHARGER_IMAGE = "Charger image";
	private static final String MENU_FICHIER_QUITTER = "#Quitter";
	private static final String MENU_NOUVELLE_FENETRE= "Nouvelle fenetre";
	private static final ArrayList<Vue> vues = new ArrayList<Vue>();
	private Modele modele;

	public FenetrePrincipale() {
		modele = new Modele();
		//On initialise les vues tel que demandé
		initVues();
		
		//Mise en place de la fenetre principale.
		JMenuBar menuFenetre = new JMenuBar();
		menuFenetre.add(creerMenuFichier(vues));
		add(menuFenetre, BorderLayout.NORTH);
		JMenuItem nouvelleFenetre = new JMenuItem(MENU_NOUVELLE_FENETRE);
		//Listener permettant d'ouvrir de nouvelles fenetres
		nouvelleFenetre.addActionListener((ActionEvent e) -> {
			vues.add(createVueInteractive());
		});
		menuFenetre.add(nouvelleFenetre);
		
		
		//Faire en sorte que le X de la fenetre ferme la fenetre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		// Rendre la fenetre visible
		setVisible(true);
		// Empecher la redimension de la fenetre
		setResizable(false);
	}
	
	/**
	 * Initialisation des vues initiales. 
	 */
	private void initVues() {
		//Image reduite
		ImageReduite thum = new ImageReduite(modele, new Image(null));
		thum.setVisible(true);
		thum.setLocation(0, DIMENSION.height);
		vues.add(thum);
		
		//Vue 1
		VueInteractive vue1 = new VueInteractive(modele, new Image(null));
		vue1.setVisible(true);
		vue1.setLocation(DIMENSION.width, 0);
		vues.add(vue1);
		
		//Vue 2
		VueInteractive vue2 = new VueInteractive(modele, new Image(null));
		vue2.setVisible(true);
		vue2.setLocation(DIMENSION.width + VueInteractive.WIDTH, 0);
		vues.add(vue2);
	}
	
	public VueInteractive createVueInteractive() {
		VueInteractive vue = new VueInteractive(modele, new Image(null));
		vue.setVisible(true);
		//Les nouvelles vues sont placées au milieu de l'écran. 
		vue.setLocationRelativeTo(null);
		return vue;
	}
	
	/**
	 * Crée le menu Permettant d'ouvrir de nouveaux fichiers
	 * @return
	 */
	public static JMenu creerMenuFichier(ArrayList<Vue> vues) {
		JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
		JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER_IMAGE);
		menuCharger.addActionListener(new ChargerImageAction(vues));		
		menuFichier.add(menuCharger);
		return menuFichier;
	}
	
	public static JMenuItem creerMenuItemQuitter() {
		JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);
		menuQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});
		return menuQuitter;
	}
	
	public static JMenu creerMenuFichier(Vue vue) {
		ArrayList<Vue> vues = new ArrayList<Vue>();
		vues.add(vue);
		return creerMenuFichier(vues);
	}
}
