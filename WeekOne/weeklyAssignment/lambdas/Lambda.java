package lambdas;

import java.util.Scanner;

/**
 * 
 * @author Parker W.
 *
 */
public class Lambda {
	
	public static void main(String[] args) {
		Lambda l = new Lambda();
		Scanner input = new Scanner(System.in);
		int numTests = Integer.parseInt(input.nextLine());
		for(int i = 0; i < numTests; i++) {
			String[] vals = input.nextLine().split(" ");
			l.runOperation(Integer.parseInt(vals[0]),Integer.parseInt(vals[1]));
		}
		input.close();
	}

	/**
	 * Operation to determine if the number is odd
	 */
	PerformOperation isOdd = n -> {
		if(n % 2 == 0) {
			System.out.println("EVEN");
			return false;
		}
		System.out.println("ODD");
		return true;
	};

	/**
	 * Operation to determine if the number is prime
	 */
	PerformOperation isPrime = n -> {
		if (n == 1 || n == 2) {
			System.out.println("PRIME");
			return true;
		}
		
		if( n % 2 == 0) {	//Even numbers other than 2 can't be prime
			System.out.println("COMPOSITE");
			return false;
		}
		
		for (int i = 3; i < n; i += 2) {
			// 1 and 2 are prime
			// otherwise check every odd number (since even is always divisible by 2)
			if (n % i == 0) {
				System.out.println("COMPOSITE");
				return false;
			}
		}
		System.out.println("PRIME");
		return true;
	};

	/**
	 * Operation to determine if a number is the same read forwards and backwards
	 */
	PerformOperation isPalindrome = n -> {
		Integer curr = n;
		if (n < 10) {
			System.out.println("PALINDROME");
			return true;
		}

		while (curr >= 10) {
			System.out.println("Left most digit: " + (int) (curr / (Math.pow(10, (int) Math.log10(curr) ) ) ));
			System.out.println("Right most digit: " + curr % 10);
			if (curr % 10 != (int) ( curr / (Math.pow(10, (int) Math.log10(curr) ) ) ) ) // check the first and last digit
				return false; // left and right most digit not equal
			curr %= (int) Math.pow(10, (int) Math.log10(curr)); // drop the left most digit
			curr /= 10; // drop right most digit
		}
		System.out.println("PALINDROME");
		return true; // down to a single digit or 0, is a palindrome

	};
	
	public boolean runOperation(int cond, int number) {
		switch(cond) {
		case 1:
			return isOdd.operation(number);
		case 2:
			return isPrime.operation(number);
		case 3:
			return isPalindrome.operation(number);
		default:
			System.err.println("Invalid test case given");	
			throw new IllegalArgumentException();
		}
	}

}
