package modele;

import java.util.ArrayList;

public class Modele {
	private ArrayList<Image> images;
	private ArrayList<Perspective>perspectives;
	
	public Modele() {
		this.images = new ArrayList<Image>();
		this.perspectives = new ArrayList<Perspective>();
	}

	public void addImage(Image image) {
		if(!images.contains(image)) {
			this.images.add(image);
		}
	}

	public void addPerspective(Perspective perspective) {
		if(!perspectives.contains(perspective)) {
			this.perspectives.add(perspective);
		}
	}
}
