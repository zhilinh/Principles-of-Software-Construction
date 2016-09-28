package edu.cmu.cs.cs214.hw3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import edu.cmu.cs.cs214.hw2.expression.Variable;

/**
 * Class to test the WordExpression class.
 * @author zhilinh
 *
 */
public class WordTest {
	
	private List<Variable> vList = new ArrayList<Variable>();
	private List<Variable> wList = new ArrayList<Variable>();
	private WordExpression word;

	/**
	 * Set up to test the constructor and generate a named variable list.
	 */
	@Before
	public void setup() {
		for (int i = 0; i < 11; i++) {
			wList.add(new Variable(""));
		}
		vList.add(new Variable("A"));
		vList.add(new Variable("B"));
		vList.add(new Variable("C"));
		this.word = new WordExpression("ABC", vList);
	}
	
	/**
	 * Test for the toString method to get the right output for Expression.
	 */
	@Test
	public void testtoString() {
		assertEquals(word.toString(), "ABC");
	}
	
	/**
	 * Test for the eval method to get the correct value of a WordExpression.
	 */
	@Test
	public void testEval() {
		vList.get(0).store(1);
		vList.get(1).store(2);
		vList.get(2).store(3);
		assertEquals(BigDecimal.valueOf(word.eval()), BigDecimal.valueOf(123.0));
		vList.get(0).store(0);
		assertEquals(BigDecimal.valueOf(word.eval()), BigDecimal.valueOf(-1.1));
	}
	
}
