import java.util.Random;
import java.util.Scanner;

public class AssignmentTwo {

	public static void main(String[] args) {
		Random rng = new Random();
		Scanner input = new Scanner(System.in);

		int numberToGuess = rng.nextInt(100) + 1; // +1 to move range from 0-99 to 1-100
		int guess;
		int numGuesses = 0;
		final int GUESS_LIMIT = 5;

		do {
			System.out.print("Please enter a guess for the number:");
			guess = input.nextInt();
			numGuesses++;
			//System.out.println("");
			if(guess >= (numberToGuess - 10) && guess <= (numberToGuess + 10)) {
				System.out.println("The number was " + numberToGuess);
				input.close();
				System.exit(0);
			} else {
				System.out.println("Sorry, that wasn't it.");
			}
		} while ( numGuesses < GUESS_LIMIT );
		
		//this block only reached if the System.exit(0) wasn't called, meaning they failed to guess within the limit
		System.out.println("Sorry, you didn't guess the number in time. It was " + numberToGuess);
		input.close();

	}

}
