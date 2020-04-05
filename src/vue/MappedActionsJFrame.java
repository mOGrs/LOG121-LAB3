package vue;

import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import commandes.DefaireAction;
import commandes.RefaireAction;

/**
 * Cette classe permet de directement lié les actions et les commandes faires et refaire
 * aux fenêtres créées par le programme. 
 * 
 * C'était la solution la plus simple pour «binder» ctrl + Z et ctrl + Y à des actions.
 * 
 * Toutes les fenêtres du programme doivent en hériter. 
 */
public class MappedActionsJFrame extends JFrame{
	private final static String DEFAIRE = "Defaire";
	private final static String REFAIRE = "Refaire";
	
	public MappedActionsJFrame() {
		//Inspiré du code trouvé à:https://tips4java.wordpress.com/2008/10/10/key-bindings/
		
		//On Map les clés des actions à exécuter avec les actions apropriées
		this.getRootPane().getActionMap().put(DEFAIRE, new DefaireAction());
		this.getRootPane().getActionMap().put(REFAIRE, new RefaireAction());
		
		//On pas map les actions avec les bonnes componaisons de touches
		InputMap im = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		KeyStroke CtrlZ = KeyStroke.getKeyStroke("control Z");
		im.put(CtrlZ, DEFAIRE);	
		
		KeyStroke CtrlY = KeyStroke.getKeyStroke("control Y");
		im.put(CtrlY, REFAIRE);	
	}
}
