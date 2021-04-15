/**
 * 
 */
package dayFive.lambdasAndFunctionalInterfaces.java8Features;

import java.util.Arrays;

/**
 * @author Parker W.
 *
 */
public class CSVSplitter {

	/**
	 * @param args The list of numbers as strings
	 */
	public static void main(String[] args) throws NumberFormatException{
		int[] inputs = new int[args.length];
		int count = 0;
		for(String s : args) {
			inputs[count++] = Integer.parseInt(s);
		}
		
		System.out.println(intsToString(inputs));
	}
	
	/**
	 * Takes a list of numbers and turns them into one single string
	 * @param numbers the list of numbers
	 * @return the string equivalent of the numbers with even-odd denotation
	 */
	public static String intsToString(int...numbers) {
		StringBuilder output = new StringBuilder();
			Arrays.stream(numbers).forEach(n -> {
				output.append(getAddendedString(n));				
			});
		return output.substring(0, output.length()-1);
			
			
			
	}

	/**
	 * Takes an input number, converts it to a string, and adds a marker to the
	 * front representing that the number is even or odd
	 * 
	 * @param num the input number
	 * @return the number as a string with even/odd marker
	 */
	public static String getAddendedString(int num) {
		StringBuilder output = new StringBuilder();
		output.append(num % 2 == 0 ? 'e' : 'o');
		output.append(num);
		output.append(',');
		return output.toString();
	}

}
