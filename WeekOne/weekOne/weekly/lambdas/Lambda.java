package weekly.lambdas;

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
		for (int i = 0; i < numTests; i++) {
			String[] vals = input.nextLine().split(" ");
			l.runOperation(Operations.values()[Integer.parseInt(vals[0])], Integer.parseInt(vals[1]));
		}
		input.close();
	}

	/**
	 * Operation to determine if the number is odd
	 */
	PerformOperation isOdd = n -> {
		if (n % 2 == 0) {
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

		if (n % 2 == 0) { // Even numbers other than 2 can't be prime
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
			// System.out.println("Left most digit: " + (int) (curr / (Math.pow(10, (int)
			// Math.log10(curr) ) ) ));
			// System.out.println("Right most digit: " + curr % 10);
			// %10 for right most digit, Math.pow(10, Math.log10()) for left most digit
			if (curr % 10 != (int) (curr / (Math.pow(10, (int) Math.log10(curr))))) // check the first and last digit
				return false; // left and right most digit not equal therefore not palindrome
			curr %= (int) Math.pow(10, (int) Math.log10(curr)); // drop the left most digit
			curr /= 10; // drop right most digit
		}
		System.out.println("PALINDROME");
		return true; // down to a single digit, which is a palindrome

	};

	/**
	 * Enumeration to link the lambda implementations to the outside world. Helps
	 * with calls to the methods by limiting the runOperation method to only
	 * existing PerformOperation implementations.
	 * 
	 * @author Parker W.
	 *
	 */
	public enum Operations {
		ISODD, ISPRIME, ISPALINDROME;
	}

	/**
	 * Takes in the operation id and the number to run the operation on
	 * 
	 * @param cond   the operation to run
	 * @param number
	 * @return
	 */
	public boolean runOperation(Operations o, int number) {
		switch (o) {
		case ISODD:
			return isOdd.operation(number);
		case ISPRIME:
			return isPrime.operation(number);
		case ISPALINDROME:
			return isPalindrome.operation(number);
		default:
			System.err.println("Invalid test case given");
			throw new IllegalArgumentException();
		}
	}

}
