/**
 * 
 */
package directory;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Recursively crawls through a directory and prints all the files and folders
 * in the starting directory
 * 
 * @author Parker W.
 *
 */
public class RecursiveCrawl {

	/**
	 * @param args the starting directory ideally
	 */
	public static void main(String[] args) {
		// if the file is missing alert the user to the proper usage
		if (args.length != 1) {
			System.err.println("Incorrect usage: java RecursiveCrawl [file]");
			System.exit(0);
		}

		Queue<File> directories = new LinkedList<>(); // queue for folders
		File startingDirectory = new File(args[0]);

		if (!startingDirectory.exists() || !startingDirectory.isDirectory()) {
			// starting location should be an existing directory
			System.err.println("Error: " + args[0] + " is not a valid directory.");
			System.exit(0);
		}

		//Could also use the Files.walkFileTree() method to achieve the same results, but this allows for more control
		
		
		directories.add(startingDirectory); // load the initial directory
		while (!directories.isEmpty()) { // while queue not empty
			File folder = directories.remove(); // pop the next item out of the queue
			File[] items = folder.listFiles(); // get all the files and folders in the folder
			for (File i : items) { // for all the items in the folder
				if (i.isDirectory()) { // if the item is another folder
					directories.add(i); // add it to the queue.
					// Folders can't go back up to best of my knowledge (don't think shortcuts
					// count) so this shouldn't have loops
				}
				System.out.println(i); // print the item

			}
		}

	}

}
