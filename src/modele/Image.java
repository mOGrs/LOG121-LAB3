/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: Image.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package modele;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Observable;

/**
 * Élément du modèle qui contient une image. C'est de la que les vues 
 * vont chercher les images à représenter. 
 */
public class Image extends Observable implements Originator{
    private String imagePath = null;
    
    public Image(Image aCopier) {
    	this.setImagePath(aCopier.getImagePath());
    }
    
    public Image() {}
    
    public Image(String imagePath) {
    	this.setImagePath(imagePath);
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
    	if(imagePath != null) {
            this.imagePath = imagePath;
            triggerObservers();
    	}
    }

    public void triggerObservers(){
        setChanged();
        notifyObservers();
    }

	@Override
	public Memento saveStateToMemento() {
		return new ImageMemento(imagePath);
	}

	@Override
	public void getStateFromMemento(Memento memento) {
		this.setImagePath(((ImageMemento)memento).getImagePath());
	}
}
