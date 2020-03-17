package vue;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Image;
import modele.Perspective;

public class Vue extends JFrame implements Observer{
	protected Image image;
	protected ArrayList<Perspective> perspectives;
	protected BufferedImage imageEnMemoire = null;
	protected JPanel panneauDessin;
	
	public Vue(Image image) {
		this(image, new Perspective());
	}
	
	public Vue(Image image, Perspective perspective) {
		setImage(image);
		this.perspectives = new ArrayList<Perspective>();
		this.perspectives.add(perspective);
	}
	
	public void setImage(Image image) {
		this.image = image;
		this.image.addObserver(this);
		if(image.getImagePath() != null) {
			mettreImageEnMemoire();
		}
	}
	
	public Image getImage(){
		return image;
	}
	
	public void mettreImageEnMemoire() {
		try {
			imageEnMemoire = ImageIO.read(new File(image.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Image) {
			setImage((Image)o);
			repaint();
		}
	}
}
