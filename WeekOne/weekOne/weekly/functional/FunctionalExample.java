/**
 * 
 */
package weekly.functional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Parker W.
 *
 */
public class FunctionalExample {
	
	/**
	 * Takes a list of (positive) Integers and returns a list of the right-most
	 * digits
	 * 
	 * @param in the list of input positive Integers
	 * @return the list of the right-most digits
	 */
	public Functional<Integer> rightDigits = (in) -> {
		List<Integer> asList = new ArrayList<>();
		for (int n : in)
			asList.add(n);

		for (int i = 0; i < asList.size(); i++) {
			asList.set(i, asList.get(i) % 10);
		}

		return asList.toArray(a -> {
			return new Integer[a];
		});
	};

	/**
	 * Implementation of the Functional Interface that returns the input list
	 * multiplied by two
	 * 
	 * @param in the list of Integers to multiply
	 * @return a copy of the list with all values multiplied by two
	 */
	public Functional<Integer> multiplyByTwo = (in) -> {
		List<Integer> asList = new ArrayList<>();
		for (int n : in)
			asList.add(n);

		for (int i = 0; i < asList.size(); i++) {
			asList.set(i, asList.get(i) * 2);
		}

		return asList.toArray(a -> {
			return new Integer[a];
		});
	};

	/**
	 * Implementaion of the Functional Interface that returns the input list with
	 * all instances of the character "x" removed
	 * 
	 * @param in the list of Strings to remove "x" from
	 * @return a copy of the input list with all "x" removed
	 */
	public Functional<String> removeX = (in) -> {
		List<String> asList = new ArrayList<>();
		for (String s : in) {
			asList.add(s);
		}

		for (int i = 0; i < asList.size(); i++) {
			asList.set(i, asList.get(i).replaceAll("x", ""));
		}

		return asList.toArray(a -> {
			return new String[a];
		});

	};

}
