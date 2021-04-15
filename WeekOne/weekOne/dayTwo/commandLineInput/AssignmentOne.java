package dayTwo.commandLineInput;

/**
 * Assignment: Take multiple values from the command line and show the result of adding all of them
 * 
 * @author Parker W.
 *
 */
public class AssignmentOne {
	
	/**
	 * Runner method, args are a list of Integers to be added together
	 * @param args
	 */
	public static void main(String[] args) {
		Integer sum = 0;
		
		for(String s : args) {//for all strings in the args
			
			try{	//Check that the argument is actually an integer
				sum += Integer.parseInt(s);
			} catch(NumberFormatException e) {	//in the event that the current argument is not an integer
				System.err.println(s + " is not an integer.");
			}
		}
		System.out.println("The sum of the numbers is: " + sum);
	}

}
