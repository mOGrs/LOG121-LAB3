package modele;

public interface Originator {
	public Memento saveStateToMemento();
	public void getStateFromMemento(Memento memento);
}
