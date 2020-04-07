/******************************************************
Cours:   LOG121
Session: H2020
Groupe:  02
Projet: Laboratoire #3
�tudiant(e)s: Marc-Olivier Gagner, Mathieu B�land, Omar Elkhiraoui
              
              
Professeur :  Vincent Lacasse
Nom du fichier: Mediateur.java
Date cr��: 2019-04-06
Date cr��: 2019-04-06
*******************************************************
Historique des modifications
*******************************************************
2019-04-06 Version initiale
*******************************************************/

package copierColler;

/**
 * Permet aux vus de copier et de coller des �l�metns de Perspectives entre elles. 
 * Le mediateur poss�de une StrategieCopie � partir de laquelle on peut coller. 
 * On change la strategie lorsque l'on copie.  
 * 
 * Coordonne les interractions entre les diff�rentes vues.
 * Pour simplifier le code, nous en avons fait un singleton pour ne pas avoir � passer
 * en param�tre le Mediateur � travers tous les objets qui en aurait de besoin. 
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
