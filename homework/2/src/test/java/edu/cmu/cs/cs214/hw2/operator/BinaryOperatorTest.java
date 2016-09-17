package edu.cmu.cs.cs214.hw2.operator;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import edu.cmu.cs.cs214.hw2.operator.BinaryOperatorImp;

/**
 * Class to test the class BinaryOperatorImp
 * @author zhilinh
 *
 */
public class BinaryOperatorTest {
	
	/**
	 * Test for toString method and apply method of ADDITION.
	 */
	@Test
	public void testAddition() {
		final double arg1 = 1.0;
		final double arg2 = 2.0;
		final double arg3 = 3.0;
		BinaryOperator additionOperator = BinaryOperatorImp.ADDITION;
		assertEquals(additionOperator.toString(), "+");
		assertEquals(BigDecimal.valueOf(additionOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	/**
	 * Test for toString method and apply method of SUBTRACTION.
	 */
	@Test
	public void testSubtraction() {
		final double arg1 = 1.0;
		final double arg2 = 2.0;
		final double arg3 = -1.0;
		BinaryOperator subtractionOperator = BinaryOperatorImp.SUBTRACTION;
		assertEquals(subtractionOperator.toString(), "-");
		assertEquals(BigDecimal.valueOf(subtractionOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	/**
	 * Test for toString method and apply method of MULTIPLICATION.
	 */
	@Test
	public void testMultiplication() {
		final double arg1 = 2.0;
		final double arg2 = 4.0;
		final double arg3 = 8.0;
		BinaryOperator multiplicationOperator = BinaryOperatorImp.MULTIPLICATION;
		assertEquals(multiplicationOperator.toString(), "*");
		assertEquals(BigDecimal.valueOf(multiplicationOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	/**
	 * Test for toString method and apply method of DIVISION.
	 */
	@Test
	public void testDivision() {
		final double arg1 = 2.0;
		final double arg2 = 4.0;
		final double arg3 = 0.5;
		BinaryOperator divisionOperator = BinaryOperatorImp.DIVISION;
		assertEquals(divisionOperator.toString(), "/");
		assertEquals(BigDecimal.valueOf(divisionOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	/**
	 * Test for toString method and apply method of EXPONENTIATION.
	 */
	@Test
	public void testExponentiation() {
		final double arg1 = 2.0;
		final double arg2 = 4.0;
		final double arg3 = 16.0;
		BinaryOperator exponentiationOperator = BinaryOperatorImp.EXPONENTIATION;
		assertEquals(exponentiationOperator.toString(), "^");
		assertEquals(BigDecimal.valueOf(exponentiationOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}

}

