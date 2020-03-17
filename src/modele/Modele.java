package modele;

import java.util.ArrayList;

public class Modele {
	private ArrayList<Image> images;
	private ArrayList<Perspective>perspectives;
	
	public Modele() {
		this.images = new ArrayList<Image>();
		this.perspectives = new ArrayList<Perspective>();
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}

	public ArrayList<Perspective> getPerspectives() {
		return perspectives;
	}

	public void setPerspectives(ArrayList<Perspective> perspectivess) {
		this.perspectives = perspectivess;
	}
}
