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
import modele.Modele;
import modele.Perspective;

public abstract class Vue extends JFrame implements Observer{
	protected Image image;
	protected Perspective perspective;
	protected BufferedImage imageEnMemoire = null;
	protected JPanel panneauDessin;
	protected Modele modele;
	
	public Vue(Modele modele, Image image) {
		this(modele, image, new Perspective());
	}
	
	public Vue(Modele modele, Image image, Perspective perspective) {
		this.modele = modele;
		setImage(image);
		setPerspective(perspective);
	}
	
	public void setPerspective(Perspective perspective) {
		if(perspective != this.perspective) {
			this.perspective = perspective;
			this.perspective.addObserver(this);
			this.modele.addPerspective(perspective);
		}
	}
	
	public void setImage(Image image) {
		this.image = image;
		this.image.addObserver(this);
		this.modele.addImage(image);
		if(image.getImagePath() != null) {
			mettreImageEnMemoire();
		}
	}
	
	public Image getImage(){
		return image;
	}
	
	public Perspective getPerspective() {
		return perspective;
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
			if(((Image)o) != this.image) {
				setImage((Image)o);
			} else if(image.getImagePath() != null) {
				mettreImageEnMemoire();
			}
		} else if(o instanceof Perspective && ((Perspective)o) != this.perspective) {
			setPerspective((Perspective)o);
		}
		repaint();
	}
	
	protected abstract void initWindow();
}
