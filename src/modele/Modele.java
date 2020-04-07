/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: Modele.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package modele;

import java.util.ArrayList;

/**
 * Classe Modele qui permet d'impl�menter le mod�le MVC. 
 * C'est en fait un wrapper qui contient tous les objets Image
 * et Perpective. 
 */
public class Modele {
	private ArrayList<Image> images;
	private ArrayList<Perspective>perspectives;
	
	public Modele() {
		this.images = new ArrayList<Image>();
		this.perspectives = new ArrayList<Perspective>();
	}

	public void addImage(Image image) {
		if(!images.contains(image)) {
			this.images.add(image);
		}
	}

	public void addPerspective(Perspective perspective) {
		if(!perspectives.contains(perspective)) {
			this.perspectives.add(perspective);
		}
	}
}
