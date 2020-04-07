/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: Perspective.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package modele;

import java.awt.*;
import java.util.Observable;

/**
 * �l�ment du mod�le qui contient une les op�rations pouvant 
 * �tre appliqu�es sur une image. C'est de la que les vues 
 * vont chercher les transformation � repr�senter. 
 */
public class Perspective extends Observable implements java.io.Serializable, Originator{
	private static double ZOOM_DEFAUT = 1;
    private Point emplacement;
    private double facteurZoom;
    
    public Perspective(Perspective aCopier) {
    	copierPerspective(aCopier);
    }
    
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
   
    public void copierPerspective(Perspective aCopier) {
    	this.setEmplacement(aCopier.emplacement);
    	this.setFacteurZoom(aCopier.facteurZoom);
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

	@Override
	public Memento saveStateToMemento() {
		return new PerspectiveMemento(emplacement, facteurZoom);
	}

	@Override
	public void getStateFromMemento(Memento memento) {
    	this.setEmplacement(((PerspectiveMemento)memento).getEmplacement());
    	this.setFacteurZoom(((PerspectiveMemento)memento).getFacteurZoom());
	}

	@Override
	public String toString() {
		return "Perspective [emplacement=" + emplacement + ", facteurZoom=" + facteurZoom + "]";
	}
}
