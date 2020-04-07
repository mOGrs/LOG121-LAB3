/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: SerialiserPerspectiveCommande.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
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
 * S�rialiser un objet Perspective � l'endroit pass� en param�tre. 
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
		 //Cr�e et �crit le fichier .ser
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
