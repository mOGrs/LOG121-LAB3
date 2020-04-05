package commandes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modele.Memento;
import modele.Perspective;

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
