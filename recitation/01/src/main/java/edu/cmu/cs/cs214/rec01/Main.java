package edu.cmu.cs.cs214.rec01;

/**
 * Class containing the main method for this example program.
 */
public final class Main {

	private static final int SIZE = 15;

	/**
	 * Empty constructor for the a utility class. It is good style to have no
	 * default constructor for a Java class if it has no public, non-static
	 * methods.
	 */
	private Main() {
		// Never called
	}

	/**
	 * Method that is called when this program is run (the 'main' method).
	 *
	 * @param args
	 *            command line arguments--not used in this program
	 */
	public static void main(String[] args) {
		new Example().printList(SIZE);
	}
}