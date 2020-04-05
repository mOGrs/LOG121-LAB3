package commandes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import modele.Perspective;

public class DeserialisationPerspectiveCommande implements Command{
	private Perspective perspective;//Référence vers la perspective à modifier.
	private Perspective anciennePerspective;//Copie de la perspective originale
	private Perspective nouvellePerspective;//Copie de la nouvelle perspective
	
	private String path;
	
	public DeserialisationPerspectiveCommande(Perspective perspective, String path) {
		super();
		this.perspective = perspective;
		this.path = path;
	}

	@Override
	public boolean faire() {
		try {
			FileInputStream fileIn = new FileInputStream(path);
		    ObjectInputStream in = new ObjectInputStream(fileIn);
		    nouvellePerspective = (Perspective) in.readObject();
		    in.close();
		    fileIn.close();
		} catch (IOException i) {
		    i.printStackTrace();
		    return false;
		} catch (ClassNotFoundException c) {
		    c.printStackTrace();
		    return false;
		}
		anciennePerspective = new Perspective(this.perspective);
		this.perspective.copierPerspective(nouvellePerspective);
		return true;
	}

	@Override
	public void defaire() {
		this.perspective.copierPerspective(anciennePerspective);
	}

	@Override
	public void refaire() {
		// TODO Auto-generated method stub
		
	}
	
}
