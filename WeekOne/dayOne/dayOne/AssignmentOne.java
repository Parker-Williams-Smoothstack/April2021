package dayOne;

public class AssignmentOne {

	public static void main(String[] args) {
		// see if user wants a specific number of numbers
		int levels = (args.length == 1 ? Integer.parseInt(args[0]) : 5);
		AssignmentOne runner = new AssignmentOne();
		runner.printTriangle(levels);
		System.out.println(" ");
		runner.printUpsideDownTriangle(levels);
		System.out.println(" ");
		runner.printPyramid(levels);
		System.out.println(" ");
		runner.printUpsideDownPyramid(levels);
	}

	private void printTriangle(int levels) {
		for (int i = 0; i < levels; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print('*');
			System.out.print('\n');
		}
	}

	private void printUpsideDownTriangle(int levels) {
		for (int i = levels; i > 0; i--) {
			for (int j = 0; j < i; j++)
				System.out.print('*');
			System.out.print('\n');
		}
	}

	private void printPyramid(int levels) {
		for (int i = 0; i < levels; i++) {
			for (int j = levels; j > i; j--)
				System.out.print(' ');
			for (int j = 0; j < (2 * i + 1); j++)
				System.out.print('*');
			System.out.print('\n');
		}
	}

	private void printUpsideDownPyramid(int levels) {
		for (int i = levels - 1; i >= 0; i--) {
			for (int j = levels; j > i; j--)
				System.out.print(' ');
			for (int j = 0; j < (2 * i + 1); j++)
				System.out.print('*');
			System.out.print('\n');
		}
	}

}
