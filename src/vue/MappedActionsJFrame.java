package vue;

import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import commandes.DefaireAction;

/**
 * Cette classe permet de directement li� les actions et les commandes faires et refaire
 * aux fen�tres cr��es par le programme. 
 * 
 * C'�tait la solution la plus simple pour �binder� ctrl + Z et ctrl + Y � des actions.
 * 
 * Toutes les fen�tres du programme doivent en h�riter. 
 */
public class MappedActionsJFrame extends JFrame{
	public MappedActionsJFrame() {
		//Inspir� du code trouv� �:https://tips4java.wordpress.com/2008/10/10/key-bindings/
		
		//On Map les cl�s des actions � ex�cuter avec les actions apropri�es
		this.getRootPane().getActionMap().put("Defaire", new DefaireAction());
		
		//On pas map les actions avec les bonnes componaisons de touches
		InputMap im = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		KeyStroke CtrlZ = KeyStroke.getKeyStroke("control Z");
		im.put(CtrlZ, "Defaire");	
	}
}
