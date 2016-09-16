package edu.cmu.cs.cs214.hw2.expression;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class NumberTest {
	
	private Expression value;
	private double number = 1.0;
	
	@Before
	public void setup() {
		value = new NumberExpression(number);
	}
	
	@Test
	public void testtoString() {
		assertEquals(value.toString(), Double.toString(number));
	}
	
	@Test
	public void testEval() {
		assertEquals(BigDecimal.valueOf(value.eval()), BigDecimal.valueOf(number));
	}

}
