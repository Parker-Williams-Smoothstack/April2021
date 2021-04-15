/**
 * 
 */
package dayThree.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Appends given text to a provided file
 * 
 * @author Parker W.
 *
 */
public class TextAppender {

	/**
	 * @param args the path to the file to append to
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		final boolean ADD_LINES = false;
		// make sure file is given, instruct on usage and terminate if missing
		if (args.length != 1) {
			System.err.println("Invalid arguments. Usage: java TextAppender [file]");
			System.exit(0);
		}

		File startingDirectory = new File(args[0]);

		if (!startingDirectory.exists() || !startingDirectory.isFile()) {
			// starting location should be an existing file.
			// should also ensure it can be written to without issue, but for now
			// we'll allow any file in case the user wants to do some stegonography and
			// write to an image or something
			System.err.println("Error: " + args[0] + " is not a valid file.");
			System.exit(0);
		}

		// prompt user for strings to appends
		Scanner input = new Scanner(System.in);
		StringBuilder line;
		System.out.println(
				"Please enter your text. Press enter to move to the next line.\nEnter a blank line (or press enter twice) to terminate.");
		while (true) {
			line = new StringBuilder();	//let the old StringBuilder get taken by garbage collection, quickest way to clear the string
			line.append(input.nextLine());

			if (line.toString().equals("")) // terminate when user enters blank line. ONLY WAY TO END, DO NOT COMMENT OUT
				break; // STOPS INFINITE LOOP, DO NOT COMMENT OUT WITHOUT CHANGING LOOP CONDITION

			try {
				if(ADD_LINES)
					line.append("\n");
				Files.write(Paths.get(startingDirectory.toURI()), line.toString().getBytes(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		input.close();
		System.out.println("Finished writing to file " + startingDirectory);

	}

}
