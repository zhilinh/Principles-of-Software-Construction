package edu.cmu.cs.cs214.hw2.operator;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;
import edu.cmu.cs.cs214.hw2.operator.BinaryOperatorImp;

public class BinaryOperatorTest {
	
	@Test
	public void testAddition() {
		double arg1 = 1.0;
		double arg2 = 2.0;
		double arg3 = 3.0;
		BinaryOperator additionOperator = BinaryOperatorImp.ADDITION;
		assertEquals(additionOperator.toString(), "+");
		assertEquals(BigDecimal.valueOf(additionOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	@Test
	public void testSubtraction() {
		double arg1 = 1.0;
		double arg2 = 2.0;
		double arg3 = -1.0;
		BinaryOperator subtractionOperator = BinaryOperatorImp.SUBTRACTION;
		assertEquals(subtractionOperator.toString(), "-");
		assertEquals(BigDecimal.valueOf(subtractionOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	@Test
	public void testMultiplication() {
		double arg1 = 2.0;
		double arg2 = 4.0;
		double arg3 = 8.0;
		BinaryOperator multiplicationOperator = BinaryOperatorImp.MULTIPLICATION;
		assertEquals(multiplicationOperator.toString(), "*");
		assertEquals(BigDecimal.valueOf(multiplicationOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	@Test
	public void testDivision() {
		double arg1 = 2.0;
		double arg2 = 4.0;
		double arg3 = 0.5;
		BinaryOperator divisionOperator = BinaryOperatorImp.DIVISION;
		assertEquals(divisionOperator.toString(), "/");
		assertEquals(BigDecimal.valueOf(divisionOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}
	
	@Test
	public void testExponentiation() {
		double arg1 = 2.0;
		double arg2 = 4.0;
		double arg3 = 16.0;
		BinaryOperator exponentiationOperator = BinaryOperatorImp.EXPONENTIATION;
		assertEquals(exponentiationOperator.toString(), "^");
		assertEquals(BigDecimal.valueOf(exponentiationOperator.apply(arg1, arg2)), BigDecimal.valueOf(arg3));
	}

}

