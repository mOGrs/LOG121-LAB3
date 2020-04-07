/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: FenetrePrincipale.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

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
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import commandes.ChargerImageAction;
import commandes.DefaireAction;
import commandes.DeserialisationPerspectiveAction;
import modele.Image;
import modele.Modele;

/**
 * Cette fenêtre est le point de départ du programme. C'est elle qui crée toutes les vues.
 * Lors de l'exécution, elle peut également créer de nouvelles VuesInterractives, charger
 * de nouvelles images pour toutes les vues en même temps ou encore charger une perspective
 * qui sera appliquée à toutes les VuesInteractives. 
 * 
 * L'interface graphique de cette classe a pris comme base l'interface graphique du 
 * LABORATOIRE 1. 
 */
public class FenetrePrincipale extends MappedActionsJFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121";
	private static final Dimension DIMENSION = new Dimension(300, 55);
	private static final String MENU_NOUVELLE_FENETRE= "Nouvelle fenetre";
	private static final ArrayList<Vue> vues = new ArrayList<Vue>();
	private static final String MENU_FICHIER_CHARGER_IMAGE = "Charger image";
	private static final String MENU_AIDE_TITRE = "Aide et instructions";
	private static final String MENU_AIDE_PRINCIPALE = "Fonctionnement de la fenêtre principale";
	private static final String MENU_AIDE_VUES = "Fonctionnement des fenêtres interactives.";
	
	private Modele modele;

	public FenetrePrincipale() {
		modele = new Modele();
		//On initialise les vues tel que demandé
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
	 * Cr�er le menu Aide
	 */
	private JMenu creerMenuAide() {
		JMenu menuAide = new JMenu(MENU_AIDE_TITRE);
		JMenuItem menuProposPrincipale = new JMenuItem(MENU_AIDE_PRINCIPALE);
		menuAide.add(menuProposPrincipale);

		menuProposPrincipale.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(null,
					"<html><p>Options de la fenetre principale:</p>" + "<br>"
							+ "<p>-Charger une Image: Permet de charger une image</p>"
							+ "<p> lors de l'exécution. Cette image sera appliquées à </p>"
							+ "<p> toutes les vues.</p>"
							+ "<p></p>"
							+ "<p>-Charger une perspective: Permet de charger un fichier .ser</p>"
							+ "<p> contenant une perspective sérialisée. Cette perspective sera</p>"
							+ "<p> appliqué à toutes les vues.</p>"
							+ "<p></p>"
							+ "<p>-Créer fenêtre: Permet de créer une nouvelle fenêres de type</p>" 
							+ "<p> VueInteractive qui sera liée à la fenêtre principale</p>"
							+ "<p></p>"
							+ "<p>-Ctrl+Z: Permet de défaire la dernière commande effecutée sur une des vues.</p>"
							+ "<p></p>"
							+ "<p>-Ctrl+Y: Permet de refaire la dernière commande défaite sur une des vues.</p>"
							+ "<p></p></html>");
		});
		add(menuAide);
		JMenuItem menuProposVues = new JMenuItem(MENU_AIDE_VUES);
		menuAide.add(menuProposVues);

		menuProposVues.addActionListener((ActionEvent e) -> {
			JOptionPane.showMessageDialog(null,
					"<html><p>Options de la fenetre principale:</p>" + "<br>"
							+ "<p>-Charger une Image: Permet de charger une image</p>"
							+ "<p> lors de l'exécution. Cette image sera appliquées à </p>"
							+ "<p> cette vue seulement.</p>"
							+ "<p></p>"
							+ "<p>-Charger une perspective: Permet de charger un fichier .ser</p>"
							+ "<p> contenant une perspective sérialisée. Cette perspective sera</p>"
							+ "<p> appliqué à cette vue seulement.</p>"
							+ "<p></p>"
							+ "<p>-Translation: Pour effectuer une translation, cliquer</p>"
							+ "<p> sur la zone de dessin pour et garder la sourie enfoncer</p>"
							+ "<p> pour bouger l'image</p>"
							+ "<p></p>"
							+ "<p>-Zoom: Pour changer l'image de l'échelle utiliser</p>"
							+ "<p> la roulette de la sourie.</p>"
							+ "<p></p>"
							+ "<p>-Éléments à copier: Les boutons permettent de choisir quoi</p>" 
							+ "<p> copier et coller.</p>"
							+ "<p></p>"
							+ "<p>-Ctrl+C: Permettent de copier des éléments de la perspective</p>"
							+ "<p> de l'image de la vue. (Lorsqu'effectué sur la zone de dessin.</p>"
							+ "<p></p>"
							+ "<p>-Ctrl+V: Permettent de coller des éléments de la perspective</p>"
							+ "<p> suur l'image d'une vue. (Lorsqu'effectué sur la zone de dessin).</p>"
							+ "<br>"
							+ "<p></p></html>");
		});
		add(menuAide);
		return menuAide;
	}
	
	/**
	 * Instancie le menu de la fenêter principale
	 */
	public void creerMenu() {
		//Ajout du menu
		JMenuBar menuFenetre = new JMenuBar();
		add(menuFenetre, BorderLayout.NORTH);
		
		//Ajout du menu contenant les options déroulantes
		JMenu menuFichier = MenuItemsGenerator.creerMenuFichier();
		
		//Ajout de l'option de charger une perpective POUR TOUTES LES VUES
		menuFichier.add(MenuItemsGenerator.creerItemMenuChargerPerpsective(vues));
		
		//Ajout de l'option de charger une image POUR TOUTES LES VUES
		menuFichier.add(MenuItemsGenerator.creerItemMenuChargerImage(vues));
		
		//Ajout de l'option permettant d'ouvrier de nouvelles fenêtres 
		menuFichier.add(creerMenuItemNouvelleFenetre());

		//Ajout de l'option de quitter
		menuFichier.addSeparator();
		menuFichier.add(MenuItemsGenerator.creerMenuItemQuitter());
		
		//Ajouter le menu contenant les options déroulantes au menu de la fenêtre
		menuFenetre.add(menuFichier);
		
		menuFenetre.add(creerMenuAide());
	}
	
	/**
	 * Créer un item de menu permettant de crééer une nouvelle VueInteractive
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
	 * Permet de créer des vues supplémentaires à celles créées initialement. 
	 * @return nouvelle VueInteractive
	 */
	private VueInteractive createVueInteractive() {
		VueInteractive vue = new VueInteractive(modele, new Image());
		vue.setVisible(true);
		//Les nouvelles vues sont placées au milieu de l'écran. 
		vue.setLocationRelativeTo(null);
		return vue;
	}
}
