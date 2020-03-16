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

//TODO Gestion de la rotation

public class Perspective extends Observable {
    private Point emplacement;

    public Point getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Point emplacement) {
        this.emplacement = emplacement;
        triggerObservers();
    }

    public Perspective(Point emplacement) {
        this.emplacement = emplacement;
    }

    public void triggerObservers(){
        setChanged();
        notifyObservers();
    }
}
