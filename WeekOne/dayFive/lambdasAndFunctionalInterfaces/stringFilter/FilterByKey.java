/**
 * 
 */
package lambdasAndFunctionalInterfaces.stringFilter;

import java.util.Arrays;

/**
 * @author Parker W.
 *
 */
public class FilterByKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] list = filterList(args);
		System.out.println("filtered list: ");
		for(String s : list)
			System.out.println(s);
	}
	
	/**
	 * Takes a list of strings and returns a list of only the inputs that start with a lower case 'a' and have exactly 3 letters
	 * @param strings the list of string inputs
	 * @return a filtered list
	 */
	public static String[] filterList(String...strings) {
		return Arrays.stream(strings).filter(s -> s.length() == 3 && s.charAt(0) == 'a').toArray(a -> {
			return new String[a];
		});
		
	}

}
