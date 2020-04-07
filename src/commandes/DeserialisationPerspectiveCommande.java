/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: DeserialisationPerspectiveCommande.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import modele.Memento;
import modele.Perspective;
import modele.PerspectiveMemento;

/**
 * Cette commande permet de désérialiser une perspective et de l'appliquer à une
 * perpective passée en paramètre. 
 */
public class DeserialisationPerspectiveCommande implements Command{
	private Perspective perspective;//Référence vers la perspective à modifier.
	private PerspectiveMemento anciennePerspective;//Copie de la perspective originale
	private PerspectiveMemento nouvellePerspective;//Copie de la nouvelle perspective
	
	private String path;
	
	public DeserialisationPerspectiveCommande(Perspective perspective, String path) {
		super();
		this.perspective = perspective;
		this.path = path;
	}

	@Override
	public boolean faire() {
		try {
			//On lie le fichier .ser
			FileInputStream fileIn = new FileInputStream(path);
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		    //On désérialise la perspective. 
		    Perspective nvl = (Perspective) in.readObject();
		    nouvellePerspective = (PerspectiveMemento) nvl.saveStateToMemento();
		    in.close();
		    fileIn.close();
		} catch (IOException i) {
		    i.printStackTrace();
		    return false;
		} catch (ClassNotFoundException c) {
		    c.printStackTrace();
		    return false;
		}
		anciennePerspective = (PerspectiveMemento) this.perspective.saveStateToMemento();
		//On appliquer la perspective désérialisée à la perspective passée
		//en paramètre. 
		this.perspective.getStateFromMemento(nouvellePerspective);
		return true;
	}

	@Override
	public void defaire() {
		this.perspective.getStateFromMemento(anciennePerspective);
	}

	@Override
	public void refaire() {
		this.perspective.getStateFromMemento(nouvellePerspective);
	}
}
