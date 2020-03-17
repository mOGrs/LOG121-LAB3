package commandes;

import modele.Image;

public class ChargerImageCommande implements Command{
	private String newImagePath;
	private String oldImagePath;
	private Image image;
	
	
	
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
