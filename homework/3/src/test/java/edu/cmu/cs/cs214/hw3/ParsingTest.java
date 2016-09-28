package edu.cmu.cs.cs214.hw3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import edu.cmu.cs.cs214.hw2.expression.Variable;

/**
 * Class to test the Parsing class.
 * @author zhilinh
 *
 */
public class ParsingTest {

	Parsing test, wrongTest1,wrongTest2;
	
	/**
	 * Set up to test the constructor and generate legal and
	 * illegal string for parsing.
	 */
	@Before
	public void setup() {
		this.test = new Parsing(new String[]{"ABC", "+", "CD", "=", "EF"});
		this.wrongTest1 = new Parsing(new String[]{"%"});
		this.wrongTest2 = new Parsing(new String[]{"ABC", "GH", "CD", "IJKLM", "EF"});
	}
	
	/**
	 * Test for the doParsing method and exception due to
	 * illegal characters and character numbers for than ten.
	 */
	@Test
	public void testdoParsing() {
		List<Variable> testList = test.doParsing();
		List<String> nameList = new ArrayList<String>();
		nameList.add("A");nameList.add("B");nameList.add("C");
		nameList.add("D");nameList.add("E");nameList.add("F");
		for (int i = 0; i < testList.size(); i++) {
			assertEquals(testList.get(i).name(), nameList.get(i));
		}
		try{
			testList = wrongTest1.doParsing();
			fail("No exception thrown.");
	    }catch(Exception ex){
	        assertTrue(ex instanceof IllegalArgumentException);
	        assertTrue(ex.getMessage().contains("Invalid Input!"));
	    }
		try{
			testList = wrongTest2.doParsing();
			fail("No exception thrown.");
	    }catch(Exception ex){
	        assertTrue(ex instanceof IllegalArgumentException);
	        assertTrue(ex.getMessage().contains("Invalid Input!"));
	    }
	}
}
