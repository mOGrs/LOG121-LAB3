package commandes;

import modele.Image;

/**
 * Commande permettant de changer le fichier d'image associé à une instance d'Image
 */
public class ChargerImageCommande implements Command{
	private String newImagePath;
	private String oldImagePath; //Si on fait éventuellement le undo/redo
	private Image image;
	
	/**
	 * @param image: Instance d'Image dont on veut modifier le fichier d'image
	 * @param imagePath: Le chemin vers le nouveau fichier
	 */
	public ChargerImageCommande(Image image, String imagePath) {
		super();
		this.newImagePath = imagePath;
		this.image = image;
	}

	@Override
	public boolean faire() {
		this.image.setImagePath(this.newImagePath);
		return false;
	}

	@Override
	public void defaire() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refaire() {
		// TODO Auto-generated method stub
		
	}

}
