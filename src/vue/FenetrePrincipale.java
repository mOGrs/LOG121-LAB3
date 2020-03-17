package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import commandes.ChargerImageAction;
import modele.Image;
import modele.Modele;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121";
	private static final Dimension DIMENSION = new Dimension(300, 55);
	private static final String MENU_FICHIER_TITRE = "Fichier";
	private static final String MENU_FICHIER_CHARGER = "Charger";
	private static final String MENU_FICHIER_QUITTER = "Quitter";
	private static final ArrayList<Vue> vues = new ArrayList<Vue>();
	private Modele modele;

	public FenetrePrincipale() {
		modele = new Modele();
		initVues();
		JMenuBar menuFenetre = new JMenuBar();
		menuFenetre.add(creerMenuFichier());
		add(menuFenetre, BorderLayout.NORTH);
		// Faire en sorte que le X de la fen�tre ferme la fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITRE_FENETRE);
		setSize(DIMENSION);
		// Rendre la fenetre visible
		setVisible(true);
		// Empecher la redimension de la fenetre
		setResizable(false);
	}
	
	private void initVues() {
		Image img = new Image(null);
		
		//Image reduite
		ImageReduite thum = new ImageReduite(modele, img);
		thum.setVisible(true);
		thum.setLocation(0, DIMENSION.height);
		vues.add(thum);
		
		//Vue 1
		VueInteractive vue1 = new VueInteractive(modele, img);
		vue1.setVisible(true);
		vue1.setLocation(DIMENSION.width, 0);
		vues.add(vue1);
		
		//Vue 2
		VueInteractive vue2 = new VueInteractive(modele, img);
		vue2.setVisible(true);
		vue2.setLocation(DIMENSION.width + VueInteractive.WIDTH, 0);
		vues.add(vue2);
	}
	
	private JMenu creerMenuFichier() {
		JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
		JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER);
		menuCharger.addActionListener(new ChargerImageAction(vues));
		JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);
		
		menuQuitter.addActionListener((ActionEvent e) -> {
			System.exit(0);
		});
		menuFichier.add(menuCharger);
		menuFichier.add(menuQuitter);
		return menuFichier;
	}
}
