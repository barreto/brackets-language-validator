package automaton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class Automaton {
	private State currentState;
	private HashSet<String> alphabet;
	Stack<String> stack;

	public Automaton() {
		currentState = null;
		stack = new Stack<String>();
		alphabet = new HashSet<String>(Arrays.asList("{", "[", "(", ")", "]", "}"));

		State q0 = new State("q0", false);
		State q1 = new State("q1", true);

		q0.addTransition("{", new Transition("}", q0, true));
		q0.addTransition("[", new Transition("]", q0, true));
		q0.addTransition("(", new Transition(")", q0, true));
		q0.addTransition("}", new Transition("}", q1, false));
		q0.addTransition("]", new Transition("]", q1, false));
		q0.addTransition(")", new Transition(")", q1, false));

		q1.addTransition("{", new Transition("}", q0, true));
		q1.addTransition("[", new Transition("]", q0, true));
		q1.addTransition("(", new Transition(")", q0, true));
		q1.addTransition("}", new Transition("}", q1, false));
		q1.addTransition("]", new Transition("]", q1, false));
		q1.addTransition(")", new Transition(")", q1, false));

		currentState = q0;
	}

	public boolean isContainedInAlphabet(String word) {
		for (int i = 0; i < word.length(); i++) {
			String letter = String.valueOf(word.charAt(i));
			if (!alphabet.contains(letter))
				return false;
		}

		return true;
	}

	private boolean itsValidPop(String stackItem) {
		if (stack.size() == 0)
			return false;

		boolean nextPopIsEqualStackItem = (stack.lastElement() == stackItem);

		return nextPopIsEqualStackItem;
	}

	private boolean customPop(String stackItem) {
		if (itsValidPop(stackItem)) {
			stack.pop();
			return true;
		}else
			return false;
	}

	private boolean itsOneValidWord(String word) {

		for (char letter : word.toCharArray()) {
			Transition transition = currentState.consume(String.valueOf(letter));

			if (transition.getIsPushAction()) {
				stack.push(transition.getStackItem());
			} else {
				if (customPop(transition.getStackItem()) == false)
					return false;
			}
		}

		return stack.isEmpty();
	}

	public boolean validate(String word) {
		stack.clear();
		return (isContainedInAlphabet(word) && itsOneValidWord(word));
	}

	public Hashtable<String, Boolean> validate(ArrayList<String> words) {
		Hashtable<String, Boolean> result = new Hashtable<String, Boolean>();

		for (String word : words) {
			result.put(word, this.validate(word));
		}
		return result;
	}

}
