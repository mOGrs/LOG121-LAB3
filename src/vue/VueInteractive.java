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
import modele.Perspective;

import javax.swing.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VueInteractive extends Vue {

	public VueInteractive(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paint(Graphics g) {
		if(imageEnMemoire != null) {
			super.paint(g);
			g.drawImage(imageEnMemoire, perspectives.get(0).getEmplacement().x, perspectives.get(0).getEmplacement().y, null);
		}
	}
}
