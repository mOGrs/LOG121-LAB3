/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: VueInteractive.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package vue;

import modele.Image;
import modele.Modele;
import modele.Perspective;
import javax.swing.*;

import commandes.CollerAction;
import commandes.CopierAction;
import commandes.SerialiserPerspectiveAction;
import commandes.TranslationAction;
import commandes.ZoomAction;
import copierColler.ChangerStrategieCopierAction;
import copierColler.StrategieCopie;
import copierColler.StrategieEchelle;
import copierColler.StrategieEchelleEtTranslation;
import copierColler.StrategieRien;
import copierColler.StrategieTranslation;

import java.awt.BorderLayout;
import java.awt.Graphics;

/**
 * Classe représentatnt les vues interratives que l'on peut manipuler. Sans nul doute
 * la classe la plus importante du programme. Elle permet de charger une image, sauvegarder
 * et charger une perspective, manipuler une image. 
 */
public class VueInteractive extends Vue {
	private static final String ITEM_SERIALISER= "Sauvegarder la perspective";
	public final static int WIDTH = 500;
	public final static int HEIGHT = WIDTH;
	private final static String DESCRIPTION = "Éléments à copier: ";
	private final static String BTN_CP_ECHELLE = "Échelle";
	private final static String BTN_CP_TRANSLATION = "Translation";
	private final static String BTN_CP_LES_DEUX= "Les deux";
	private final static String BTN_CP_RIEN = "Rien";
	private final static String COPIER = "Copier";
	private final static String COLLER = "Coller";
	private StrategieCopie strategie;
	
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
		
		//Ajout des options de copier et coller
		pp.getActionMap().put(COPIER, new CopierAction(this));
		pp.getActionMap().put(COLLER, new CollerAction(this));
		
		InputMap im = pp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		//La stratégie de copie par défaut est de ne rien faire
		this.setStrategie(new StrategieRien());
		KeyStroke CtrlC = KeyStroke.getKeyStroke("control C");
		im.put(CtrlC, COPIER);
		
		KeyStroke CtrlV = KeyStroke.getKeyStroke("control V");
		im.put(CtrlV, COLLER);
		
		//Création du menu
		this.creerMenu();
	}
	
	public void creerMenu() {
		//Ajout d'un menu
		JMenuBar menuFenetre = new JMenuBar();
		JMenu menuFichier = MenuItemsGenerator.creerMenuFichier();
		
		//Ajout des options de sérialisation
		menuFichier.add(this.creerOptionMenuSerialisation());
		
		//Ajout de l'option de charger une perpective POUR CETTE VUE SEULEMENT
		menuFichier.add(MenuItemsGenerator.creerItemMenuChargerPerpsective(this));
		
		//Ajout de l'option de charger une image POUR CETTE VUE SEULEMENT
		menuFichier.add(MenuItemsGenerator.creerItemMenuChargerImage(this));
		
		//Ajouter l'option de quitter au menu, séparer d'un séparateur
		menuFichier.addSeparator();

		menuFichier.add(MenuItemsGenerator.creerMenuItemQuitter());
		
		menuFenetre.add(menuFichier);
		menuFenetre.add(new JLabel(DESCRIPTION));
		
		//Ajout des boutons pour le copier-coller
		JToggleButton echelle = new JToggleButton(BTN_CP_ECHELLE);
		echelle.addActionListener(new ChangerStrategieCopierAction(this, new StrategieEchelle()));
		JToggleButton translation = new JToggleButton(BTN_CP_TRANSLATION);
		translation.addActionListener(new ChangerStrategieCopierAction(this, new StrategieTranslation()));
		JToggleButton lesDeux = new JToggleButton(BTN_CP_LES_DEUX);
		lesDeux.addActionListener(new ChangerStrategieCopierAction(this, new StrategieEchelleEtTranslation()));
		JToggleButton rien = new JToggleButton(BTN_CP_RIEN);
		rien.setSelected(true);
		rien.addActionListener(new ChangerStrategieCopierAction(this, new StrategieRien()));
		
		ButtonGroup group = new ButtonGroup();
		group.add(echelle);
		group.add(translation);
		group.add(lesDeux);
		group.add(rien);

		menuFenetre.add(echelle);
		menuFenetre.add(translation);
		menuFenetre.add(lesDeux);
		menuFenetre.add(rien);
		
		add(menuFenetre, BorderLayout.NORTH);
	}
	
	private JMenuItem creerOptionMenuSerialisation() {
		JMenuItem itemSerialiser = new JMenuItem(ITEM_SERIALISER);
		itemSerialiser.addActionListener(new SerialiserPerspectiveAction(this));
		return itemSerialiser;
	}
	
	public StrategieCopie getStrategie() {
		return strategie;
	}

	public void setStrategie(StrategieCopie strategie) {
		this.strategie = strategie;
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