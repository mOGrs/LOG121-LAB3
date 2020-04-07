/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: Commande.java
 Date créé: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package commandes;

/**
 * Permet d'impl�menter le patron commande. 
 * Les commandes sont d�clench�s par certains �v�nements (formellemetn, 
 * dans notre mod�le, ce sont g�n�ralement des instance de Action) qui vont ensuite
 * �tre effectu�s par le gestionnaire de commande. 
 */
public interface Command {
	/**
	 * Permet d'effectuer la commande. 
	 * @return: si la commande peut �tre d�faite et, en cons�quence, refaite. 
	 */
    public boolean faire();
    
    /**
     * Permet de d�faire l'effet de la commande originale
     */
    public void defaire();
    
    /**
     * Permet de refaire l'effet de la commande lorsqu'elle a �t� d�faite pr�c�demment.
     */
    public void refaire();
}