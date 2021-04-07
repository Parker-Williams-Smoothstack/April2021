/**
 * 
 */
package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Reads a given file and deals counts the number of times a given character
 * appears
 * 
 * @author Parker W.
 *
 */
public class CharCounter {

	/**
	 * Prints out the number of times a letter appears in a given file
	 * 
	 * @param ags the file to look in, the char to look for
	 */
	public static void main(String[] args) {
		// make sure the file and char are given, display error and usage if incorrect
		if (args.length != 2) {
			System.err.println("Incorrect usage. Usage: java CharCounter [file] [char]");
			System.exit(0);
		}

		// ensure file exists
		File startingDirectory = new File(args[0]);

		if (!startingDirectory.exists() || !startingDirectory.isFile()) {
			// starting location should be an existing file.
			// should also ensure given file is a valid type, but for now
			// just assume it's a valid file type.
			System.err.println("Error: " + args[0] + " is not a valid file.");
			System.exit(0);
		}

		try (FileInputStream reader = new FileInputStream(startingDirectory)) {
			int charAsInt;
			Integer total = 0;
			char lookFor = args[1].charAt(0);
			while ((charAsInt = reader.read()) != -1) {
				// should be a standard text file, can cast down to char
				Character realChar = (char) charAsInt;
				if (realChar == lookFor)
					total++;
			}
			System.out.println("The total number of times " + lookFor + " appears in " + startingDirectory.getPath()
					+ " is " + total);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
