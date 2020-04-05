/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: VueMiniature.java
 Date créé: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package vue;

import modele.Image;
import modele.Modele;
import modele.Perspective;
import javax.swing.*;

import commandes.ChargerImageAction;
import commandes.DeserialisationPerspectiveAction;
import commandes.SerialiserPerspectiveAction;
import commandes.TranslationAction;
import commandes.ZoomAction;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

/**
 * Classe repr�sentatnt les vues interratives que l'on peut manipuler. 
 */
public class VueInteractive extends Vue {
	private static final String ITEM_SERIALISER= "Sauvegarder la perspective";
	public final static int WIDTH = 500;
	public final static int HEIGHT = WIDTH;
	
	public VueInteractive(Modele modele, Image image, Perspective perspective) {
		super(modele, image, perspective);
		initWindow();
	}

	public VueInteractive(Modele modele, Image image) {
		super(modele, image);
		initWindow();
	}
	
	@Override
	protected void initWindow() {
		this.setSize(WIDTH, HEIGHT);
		
		PanneauPrincipal pp = new PanneauPrincipal();
		TranslationAction translationlst = new TranslationAction(perspective);
		ZoomAction zoomlst = new ZoomAction(perspective);
		
		pp.addMouseListener(translationlst);
		pp.addMouseMotionListener(translationlst);
		pp.addMouseWheelListener(zoomlst);
		add(pp);
		
		//Cr�ation du menu
		this.creerMenu();
	}
	
	public void creerMenu() {
		//Ajout d'un menu
		JMenuBar menuFenetre = new JMenuBar();
		JMenu menuFichier = MenuFactory.creerMenuFichier();
		
		//Ajout des options de s�rialisation
		menuFichier.add(this.creerOptionMenuSerialisation());
		
		//Ajout de l'option de charger une perpective POUR CETTE VUE SEULEMENT
		menuFichier.add(MenuFactory.creerItemMenuChargerPerpsective(this));
		
		//Ajout de l'option de charger une image POUR CETTE VUE SEULEMENT
		menuFichier.add(MenuFactory.creerItemMenuChargerImage(this));
		
		//Ajouter l'option de quitter au menu, s�parer d'un s�parateur
		menuFichier.addSeparator();
		menuFichier.add(MenuFactory.creerMenuItemQuitter());
		
		menuFenetre.add(menuFichier);
		add(menuFenetre, BorderLayout.NORTH);
	}
	
	private JMenuItem creerOptionMenuSerialisation() {
		JMenuItem itemSerialiser = new JMenuItem(ITEM_SERIALISER);
		itemSerialiser.addActionListener(new SerialiserPerspectiveAction(this));
		return itemSerialiser;
	}
	
	/**
	 * Permet de dessiner l'Image en y appliquant les modifications de la perspective.
	 */
	public class PanneauPrincipal extends JPanel {
		@Override
		public void paint(Graphics g) {
			if(imageEnMemoire != null) {
				super.paint(g);
				int x = perspective.getX();
				int y = perspective.getY();
				int h = (int) ((double)imageEnMemoire.getHeight() * perspective.getFacteurZoom());
				int l = (int) ((double)imageEnMemoire.getWidth() * perspective.getFacteurZoom());
				g.drawImage(imageEnMemoire, x, y, h, l, null);
			}
		}
	}
}