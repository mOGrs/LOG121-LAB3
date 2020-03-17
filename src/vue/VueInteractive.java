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
import commandes.TranslationAction;
import commandes.ZoomAction;

import java.awt.Graphics;

public class VueInteractive extends Vue {
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
	}
	
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