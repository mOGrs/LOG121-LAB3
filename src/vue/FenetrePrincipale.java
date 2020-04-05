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
import commandes.DeserialisationPerspectiveAction;
import modele.Image;
import modele.Modele;

/**
 *
 */
public class FenetrePrincipale extends MappedActionsJFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121";
	private static final Dimension DIMENSION = new Dimension(300, 55);
	private static final String MENU_NOUVELLE_FENETRE= "Nouvelle fenetre";
	private static final ArrayList<Vue> vues = new ArrayList<Vue>();
	private static final String MENU_FICHIER_CHARGER_IMAGE = "Charger image";

	private Modele modele;

	public FenetrePrincipale() {
		modele = new Modele();
		//On initialise les vues tel que demand�
		initVues();
		
		//Mise en place du menu 
		this.creerMenu();
		
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
	 * Instancie le menu de la fen�ter principale
	 */
	public void creerMenu() {
		//Ajout du menu
		JMenuBar menuFenetre = new JMenuBar();
		add(menuFenetre, BorderLayout.NORTH);
		
		//Ajout du menu contenant les options d�roulantes
		JMenu menuFichier = MenuItemsGenerator.creerMenuFichier();
		
		//Ajout de l'option de charger une perpective POUR TOUTES LES VUES
		menuFichier.add(MenuItemsGenerator.creerItemMenuChargerPerpsective(vues));
		
		//Ajout de l'option de charger une image POUR TOUTES LES VUES
		menuFichier.add(MenuItemsGenerator.creerItemMenuChargerImage(vues));
		
		//Ajout de l'option permettant d'ouvrier de nouvelles fen�tres 
		menuFichier.add(creerMenuItemNouvelleFenetre());

		//Ajout de l'option de quitter
		menuFichier.addSeparator();
		menuFichier.add(MenuItemsGenerator.creerMenuItemQuitter());
		
		//Ajouter le menu contenant les options d�roulantes au menu de la fen�tre
		menuFenetre.add(menuFichier);
	}
	
	/**
	 * Cr�er un item de menu permettant de cr��er une nouvelle VueInteractive
	 * @return
	 */
	private JMenuItem creerMenuItemNouvelleFenetre() {
		JMenuItem nouvelleFenetre = new JMenuItem(MENU_NOUVELLE_FENETRE);
		//Listener permettant d'ouvrir de nouvelles fenetres
		nouvelleFenetre.addActionListener((ActionEvent e) -> {
			vues.add(createVueInteractive());
		});
		return nouvelleFenetre;
	}
	
	/**
	 * Initialisation des 3 vues initiales. 
	 */
	private void initVues() {
		//Image reduite
		ImageReduite thum = new ImageReduite(modele, new Image());
		thum.setVisible(true);
		thum.setLocation(0, DIMENSION.height);
		vues.add(thum);
		
		//Vue 1
		VueInteractive vue1 = new VueInteractive(modele, new Image());
		vue1.setVisible(true);
		vue1.setLocation(DIMENSION.width, 0);
		vues.add(vue1);
		
		//Vue 2
		VueInteractive vue2 = new VueInteractive(modele, new Image());
		vue2.setVisible(true);
		vue2.setLocation(DIMENSION.width + VueInteractive.WIDTH, 0);
		vues.add(vue2);
	}
	
	/**
	 * Permet de cr�er des vues suppl�mentaires � celles cr��es initialement. 
	 * @return nouvelle VueInteractive
	 */
	private VueInteractive createVueInteractive() {
		VueInteractive vue = new VueInteractive(modele, new Image());
		vue.setVisible(true);
		//Les nouvelles vues sont plac�es au milieu de l'�cran. 
		vue.setLocationRelativeTo(null);
		return vue;
	}
}
