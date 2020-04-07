/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
Étudiant(e)s: Marc-Olivier Gagner, Mathieu Béland, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: Mediateur.java
Date créé: 2019-04-06
Date créé: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package copierColler;

/**
 * Permet aux vus de copier et de coller des élémetns de Perspectives entre elles. 
 * Le mediateur possède une StrategieCopie à partir de laquelle on peut coller. 
 * On change la strategie lorsque l'on copie.  
 * 
 * Coordonne les interractions entre les différentes vues.
 * Pour simplifier le code, nous en avons fait un singleton pour ne pas avoir à passer
 * en paramètre le Mediateur à travers tous les objets qui en aurait de besoin. 
 */
public class Mediateur {
	private StrategieCopie strategie;
	private static Mediateur uniqueInstance = new Mediateur();
	
	private Mediateur() {
		super();
		this.strategie = new StrategieRien();
	}

	public StrategieCopie getStrategie() {
		return strategie;
	}

	public void setStrategie(StrategieCopie strategie) {
		this.strategie = strategie;
	}
	
	public static Mediateur getInstance() {
		return uniqueInstance;
	}
}
