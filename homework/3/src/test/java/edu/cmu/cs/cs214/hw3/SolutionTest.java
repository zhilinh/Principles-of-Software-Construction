package edu.cmu.cs.cs214.hw3;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import edu.cmu.cs.cs214.hw2.expression.Expression;
import edu.cmu.cs.cs214.hw2.expression.SumExpression;
import edu.cmu.cs.cs214.hw2.expression.Variable;

public class SolutionTest {

	Solution test;
	List<Expression> result = new ArrayList<Expression>();
	
	@Before
	public void setup() {
		Variable a = new Variable("A");Variable b = new Variable("B");
		Variable c = new Variable("C");
		List<Integer> num = new ArrayList<Integer>();
		num.add(1);num.add(2);num.add(3);
		List<Variable> vList = new ArrayList<Variable>();
		List<List<Integer>> cList = new ArrayList<List<Integer>>();
		cList.add(num);
		vList.add(a);vList.add(b);vList.add(c);
		Expression sum = new SumExpression(a, b);
		this.result.add(sum);
		this.result.add(c);
		this.test = new Solution(cList,vList,result);
	}
	
	@Test
	public void testComparison() {
		List<String> rList = new ArrayList<String>();
		rList.add("{A=1, B=2, C=3}");
		rList.add("{A=2, B=1, C=3}");
		assertEquals(rList, test.Comparison());
	}
	
}
