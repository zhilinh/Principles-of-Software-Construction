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
 * Class to test the ExpressionConstructor class.
 * @author zhilinh
 *
 */
public class ExpressionTest {

	private ExpressionConstructor rightExpression;
	private ExpressionConstructor wrongExpression1;
	private ExpressionConstructor wrongExpression2;
	private ExpressionConstructor wrongExpression3;
	private List<Variable> wList = new ArrayList<Variable>();
	private Variable a = new Variable("A");
	
	/**
	 * Set up to test the construct and generate correct
	 * and wrong Expressions for test.
	 */
	@Before
	public void setup () {
		this.wList.add(a);
		String[] rightString = new String[]{"A","+","A","-","A",".","A","=","A"};
		String[] wrongString1 = new String[]{"A","=","A","="};
		String[] wrongString2 = new String[]{"A","=","+"};
		String[] wrongString3 = new String[]{"A","A","+"};
		this.rightExpression = new ExpressionConstructor(rightString, wList);
		this.wrongExpression1 = new ExpressionConstructor(wrongString1, wList);
		this.wrongExpression2 = new ExpressionConstructor(wrongString2, wList);
		this.wrongExpression3 = new ExpressionConstructor(wrongString3, wList);
	}
	
	/**
	 * Test for constructing the correct Expression and
	 * exception for wrong Expression due to redundant
	 * operators and characters.
	 */
	@Test
	public void testConstructor() {
		assertEquals(rightExpression.Constructor().get(0).toString(), "(((A+A)-A)*A)");
		assertEquals(rightExpression.Constructor().get(1).toString(), "A");
		a.store(2.0);
		assertEquals(BigDecimal.valueOf(rightExpression.Constructor().get(0).eval()), BigDecimal.valueOf(4.0));
		try{
			wrongExpression1.Constructor();
			fail("No exception thrown.");
	    }catch(Exception ex){
	        assertTrue(ex instanceof IllegalArgumentException);
	        assertTrue(ex.getMessage().contains("Invalid Input!"));
	    }
		try{
			wrongExpression2.Constructor();
			fail("No exception thrown.");
	    }catch(Exception ex){
	        assertTrue(ex instanceof IllegalArgumentException);
	        assertTrue(ex.getMessage().contains("Invalid Input!"));
	    }
		try{
			wrongExpression3.Constructor();
			fail("No exception thrown.");
	    }catch(Exception ex){
	        assertTrue(ex instanceof IllegalArgumentException);
	        assertTrue(ex.getMessage().contains("Invalid Input!"));
	    }
	}
}
