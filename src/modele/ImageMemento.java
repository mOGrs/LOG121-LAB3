/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: ImageMemento.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package modele;

/**
 * Permet de sauvegarder les éléments d'une objet Image. 
 */
public class ImageMemento extends Memento{
	private String imagePath;

	public ImageMemento(String imagePath) {
		super();
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}
}
