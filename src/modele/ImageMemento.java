package modele;

public class ImageMemento extends Memento{
	private String imagePath;

	public ImageMemento(String imagePath) {
		super();
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}
}
