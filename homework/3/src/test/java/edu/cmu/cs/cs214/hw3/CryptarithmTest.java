package edu.cmu.cs.cs214.hw3;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the whole Cryptarithm class.
 * @author zhilinh
 *
 */
public class CryptarithmTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/**
	 * Set up the output stream.
	 */
	@Before
	public void setup() {
	    System.setOut(new PrintStream(outContent));
	}
	
	/**
	 * Test for Cryptarithm with 0 solution(s).
	 */
	@Test
	public void testMain() {
		String test = "0 solution(s)\r\n";
		String[] args = new String[]{"I", "+", "CANT", "+", "GET", "=", "NO", "+", "SATISFACTION"};
		Cryptarithm.main(args);
		assertEquals(test, outContent.toString());
	}
	
	/**
	 * Test for Cryptarithm with 1 solution(s).
	 */
	@Test
	public void testMainAgain() {
		String test = "1 solution(s):\r\n{S=9, E=5, N=6, D=7, M=1, O=0, R=8, Y=2}\r\n";
		String[] args = new String[]{"SEND", "+", "MORE", "=", "MONEY"};
		Cryptarithm.main(args);
		assertEquals(test, outContent.toString());
	}
}
