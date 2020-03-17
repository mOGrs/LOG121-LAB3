package commandes;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import modele.Perspective;

public class ZoomAction extends PerspectiveAbstractAction implements MouseWheelListener{
	
	public ZoomAction(Perspective perspective) {
		super(perspective);
	}

	@Override
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		double zoom = e.getPreciseWheelRotation();
		gc.faireCommande(new ZoomCommande(this.getPerspective(), zoom));
	}

}
