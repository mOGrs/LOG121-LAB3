package commandes;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import vue.Vue;

/**
 * Cette classe a �t� cr��e pour mettre en �vidence que certaines actions peuvent s'appliqu�es
 * sur une ou plusieurs actions. C'est un principe important pour distinguer certaines
 * actions que peuvent prendre et la fen�tre principale qui agit sur toutes les vues
 * et les vues individuelles dont les actions n'ont de r�percussions que sur elles-m�mes. 
 * Par exemple, lorsque l'on charge une image, si on le fait � partir de la fen�tre
 * principale, toutes les images sont chang�es. Par contre, si on le fait � partir d'une
 * vue, seule l'image de la vue est chang�e.
 */
public abstract class PouvantEtreAppliqueAPlusieursVuesAction extends GeneralAction{
	ArrayList<Vue> vues = new ArrayList<Vue>(); //Les vues dont on veut modifier l'image

	/**
	 * Pour ce type de classe, il a �t� d�cid� que d'offrir des constructeurs prenant en 
	 * param�tre des listes de vues et non seulement des vues individuelles pour rappeler
	 * la logique de ces classes. 
	 */
	public PouvantEtreAppliqueAPlusieursVuesAction(ArrayList<Vue> vues) {
		this.vues = vues;
	}
}
