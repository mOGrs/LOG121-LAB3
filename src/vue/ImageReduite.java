/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Ã‰tudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: ImageReduite.java
 Date crÃ©Ã©: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package vue;
import modele.Image;
import modele.Modele;
import javax.swing.*;
import java.awt.Graphics;

/**
 * Hérite de vue et ne fait que représeneter une petite image
 */
public class ImageReduite extends  Vue {
	public final static int WIDTH = 120;
	public final static int HEIGHT = WIDTH;
	public final static int BORDURE_BARRE = 40;
	public final static int TAILLE_IMAGE = HEIGHT - BORDURE_BARRE;

	public ImageReduite(Modele modele, Image image) {
		super(modele, image);
		initWindow();
	}
	
	protected void initWindow() {
		this.setSize(WIDTH, HEIGHT);
		add(new PanneauPrincipal());
	}
	
	public class PanneauPrincipal extends JPanel {
		@Override
		public void paint(Graphics g) {
			if(imageEnMemoire != null) {
				super.paint(g);
				g.drawImage(imageEnMemoire, 0, 0, TAILLE_IMAGE, TAILLE_IMAGE, null);
			}
		}
	}
}
