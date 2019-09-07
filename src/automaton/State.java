package automaton;

import java.util.Hashtable;

public class State {
	private String label;
	private boolean isFinalState;
	private Hashtable<String, Transition> transitions;

	public State(String label, boolean isFinalState) {
		this.label = label;
		this.isFinalState = isFinalState;
		transitions = new Hashtable<String, Transition>();
	}

	public String getLabel() {
		return label;
	}

	public boolean getIsFinalState() {
		return this.isFinalState;
	}

	public void addTransition(String value, Transition transition) {
		transitions.put(value, transition);
	}

	public Transition consume(String value) {
		return transitions.get(value);
	}

}