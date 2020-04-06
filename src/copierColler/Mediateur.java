package copierColler;

import modele.PerspectiveMemento;

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
