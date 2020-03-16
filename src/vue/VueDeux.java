/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: VueDeux.java
 Date créé: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package vue;

import controleur.ImageControleur;
import controleur.PerspectiveControleur;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VueDeux extends JFrame implements Observer {

    public VueDeux(ImageControleur imageControleur, PerspectiveControleur perspectiveControleur){
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException();
    }
}
