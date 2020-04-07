/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: SerialiserPerspectiveCommande.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package commandes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modele.Memento;
import modele.Perspective;

/**
 * Sérialiser un objet Perspective à l'endroit passé en paramètre. 
 */
public class SerialiserPerspectiveCommande implements Command{
	private Perspective perspective;
	private String path;
	
	public SerialiserPerspectiveCommande(Perspective perspective, String path) {
		super();
		this.perspective = perspective;
		this.path = path;
	}

	@Override
	public boolean faire() {
	   try {
		 //Crée et écrit le fichier .ser
         FileOutputStream fileOut = new FileOutputStream(path);
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(perspective);
         out.close();
         fileOut.close();
	   } catch (IOException i) {
         i.printStackTrace();
       }
	   return false;
	}

	@Override
	public void defaire() {}

	@Override
	public void refaire() {}
}
