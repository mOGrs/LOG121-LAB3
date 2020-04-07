/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: ChargerImageCommande.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import modele.Image;
import modele.ImageMemento;
import modele.Memento;

/**
 * Commande permettant de changer le fichier d'image associé à une instance d'Image.
 */
public class ChargerImageCommande implements Command{
	private ImageMemento nouvelleImage;
	private ImageMemento ancienneImage; //Si on fait éventuellement le undo/redo
	private Image image;
	
	/**
	 * @param image: Instance d'Image dont on veut modifier le fichier d'image
	 * @param imagePath: Le chemin vers le nouveau fichier
	 */
	public ChargerImageCommande(Image image, String imagePath) {
		super();
		this.nouvelleImage = new ImageMemento(imagePath);
		this.image = image;
	}

	@Override
	public boolean faire() {
		ancienneImage = (ImageMemento) image.saveStateToMemento();
		this.image.getStateFromMemento(nouvelleImage);
		return true;
	}

	@Override
	public void defaire() {
		this.image.getStateFromMemento(ancienneImage);
	}

	@Override
	public void refaire() {
		this.image.getStateFromMemento(nouvelleImage);
	}
}
