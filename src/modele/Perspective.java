/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: Perspective.java
 Date créé: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package modele;

import java.awt.*;
import java.util.Observable;

public class Perspective extends Observable {
	private static double ZOOM_DEFAUT = 1;
    private Point emplacement;
    private double facteurZoom;
    
    public Perspective() {
        this(new Point(0,0), ZOOM_DEFAUT);
    }
    
    public Perspective(double facteurZoom) {
    	this(new Point(0,0), facteurZoom);
    	
    }
    
    public Perspective(Point emplacement) {
    	this(emplacement, ZOOM_DEFAUT);
    }
    
    public Perspective(Point emplacement, double facteurZoom) {
    	this.emplacement = emplacement;
    	this.facteurZoom = facteurZoom;
    }

    public void setEmplacement(Point emplacement) {
        this.emplacement = emplacement;
        triggerObservers();
    }
    
    public Point getEmplacement() {
		return emplacement;
	}

	public int getX() {
    	return emplacement.x;
    }
    
    public int getY() {
    	return emplacement.y;
    }

    public double getFacteurZoom() {
		return facteurZoom;
	}

	public void setFacteurZoom(double facteurZoom) {
		this.facteurZoom = facteurZoom;
		triggerObservers();
	}

	public void triggerObservers(){
        setChanged();
        notifyObservers();
    }
}
