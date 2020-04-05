package commandes;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import vue.Vue;

/**
 * Cette classe a été créée pour mettre en évidence que certaines actions peuvent s'appliquées
 * sur une ou plusieurs actions. C'est un principe important pour distinguer certaines
 * actions que peuvent prendre et la fenêtre principale qui agit sur toutes les vues
 * et les vues individuelles dont les actions n'ont de répercussions que sur elles-mêmes. 
 * Par exemple, lorsque l'on charge une image, si on le fait à partir de la fenêtre
 * principale, toutes les images sont changées. Par contre, si on le fait à partir d'une
 * vue, seule l'image de la vue est changée.
 */
public abstract class PouvantEtreAppliqueAPlusieursVuesAction extends GeneralAction{
	ArrayList<Vue> vues = new ArrayList<Vue>(); //Les vues dont on veut modifier l'image

	/**
	 * Pour ce type de classe, il a été décidé que d'offrir des constructeurs prenant en 
	 * paramètre des listes de vues et non seulement des vues individuelles pour rappeler
	 * la logique de ces classes. 
	 */
	public PouvantEtreAppliqueAPlusieursVuesAction(ArrayList<Vue> vues) {
		this.vues = vues;
	}
}
