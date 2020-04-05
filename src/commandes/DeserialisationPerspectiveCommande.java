package commandes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import modele.Memento;
import modele.Perspective;
import modele.PerspectiveMemento;

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
			FileInputStream fileIn = new FileInputStream(path);
		    ObjectInputStream in = new ObjectInputStream(fileIn);
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
