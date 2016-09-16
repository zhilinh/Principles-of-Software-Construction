package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class AbsoluteValueTest {
	
	private Expression absTest1;
	private Expression absTest2;
	private double number1 = 1.0;
	private double number2 = -1.0;
	private Expression addend1 = new NumberExpression(number1);
	private Expression addend2 = new NumberExpression(number2);
	
	@Before
	public void setup() {
		absTest1 = new AbsoluteValueExpression(addend1);
		absTest2 = new AbsoluteValueExpression(addend2);
	}
	
	@Test
	public void testtoString() {
		assertEquals("-(" + addend2.toString() + ")", absTest2.toString());
		assertEquals(addend1.toString(), absTest1.toString());
	}
	
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(number1), BigDecimal.valueOf(absTest1.eval()));
		assertEquals(BigDecimal.valueOf(number1), BigDecimal.valueOf(absTest2.eval()));
	}

}
