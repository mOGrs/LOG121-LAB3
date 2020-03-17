/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: ImageReduite.java
 Date créé: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package vue;
import modele.Image;
import modele.Perspective;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ImageReduite extends  Vue {
	private final int WIDTH = 50;
	private final int HEIGHT = 50;
	private final int barBuffer = 60;
	private final int leftBuffer = 10;
	
	public ImageReduite(Image image, Perspective perspective) {
		super(image, perspective);
		initWindow();
	}

	public ImageReduite(Image image) {
		super(image);
		initWindow();
	}
	
	private void initWindow() {
		this.setSize(WIDTH, HEIGHT + barBuffer);
		//setUndecorated(true);
	}
	
	@Override
	public void paint(Graphics g) {
		if(imageEnMemoire != null) {
			g.drawImage(imageEnMemoire, leftBuffer, barBuffer, WIDTH, HEIGHT, null);
		}
	}
}
