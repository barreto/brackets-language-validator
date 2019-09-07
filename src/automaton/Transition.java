package automaton;

public class Transition {

	// private String consumeItem;
	private String stackItem;
	private State nextState;
	private boolean isPushAction;

	/*
	 * public Transition(String consumeItem, String stackItem, State nextState) { //
	 * this.consumeItem = consumeItem; this.stackItem = stackItem; this.nextState =
	 * nextState; this.pushAction = true; }
	 */
	
	public Transition(String stackItem, State nextState, boolean isPushAction) {
		// this.consumeItem = consumeItem;
		this.stackItem = stackItem;
		this.nextState = nextState;
		this.isPushAction = isPushAction;
	}

	public String getStackItem() {
		return stackItem;
	}

	public void setStackItem(String stackItem) {
		this.stackItem = stackItem;
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}
	
	public boolean getIsPushAction() {
		return isPushAction;
	}

	public void seIsPushAction(boolean isPushAction) {
		this.isPushAction = isPushAction;
	}

}
