/******************************************************
 Cours:   LOG121
 Session: H2020
 Groupe:  02
 Projet: Laboratoire #3
 Ã‰tudiant(e)s: Marc-Olivier Gagner


 Professeur :  Vincent Lacasse
 Nom du fichier: Commande.java
 Date crÃ©Ã©: 2019-03-10
 Date dern. modif. 2019-03-10
 *******************************************************
 Historique des modifications
 *******************************************************
 2019-03-02 Version initiale
 *******************************************************/

package commandes;

/**
 * Permet d'implémenter le patron commande. 
 * Les commandes sont déclenchés par certains évènements (formellemetn, 
 * dans notre modèle, ce sont généralement des instance de Action) qui vont ensuite
 * être effectués par le gestionnaire de commande. 
 */
public interface Command {
	/**
	 * Permet d'effectuer la commande. 
	 * @return: si la commande peut être défaite et, en conséquence, refaite. 
	 */
    public boolean faire();
    
    /**
     * Permet de défaire l'effet de la commande originale
     */
    public void defaire();
    
    /**
     * Permet de refaire l'effet de la commande lorsqu'elle a été défaite précédemment.
     */
    public void refaire();
}