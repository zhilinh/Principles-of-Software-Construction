package edu.cmu.cs.cs214.hw2.guicalc;
import edu.cmu.cs.cs214.hw2.operator.BinaryOperator;
import edu.cmu.cs.cs214.hw2.operator.BinaryOperatorImp;
import edu.cmu.cs.cs214.hw2.operator.UnaryOperator;
import edu.cmu.cs.cs214.hw2.operator.UnaryOperatorImp;
import java.util.HashSet;
import java.util.Set;

/**
 * Main program that runs the GUI Calculator
 */
public class Main {
	
	/**
	 * Add BinaryOperators and UnaryOperators implements to the calculator.
	 * 
	 * @param args
	 */
    public static void main(String[] args) {    	
        Set<UnaryOperator> unaryOperators = new HashSet<>();
        unaryOperators.add(UnaryOperatorImp.ABS);
        unaryOperators.add(UnaryOperatorImp.NEGATION);
        
        Set<BinaryOperator> binaryOperators = new HashSet<>();
        binaryOperators.add(BinaryOperatorImp.ADDITION);
        binaryOperators.add(BinaryOperatorImp.SUBTRACTION);
        binaryOperators.add(BinaryOperatorImp.MULTIPLICATION);
        binaryOperators.add(BinaryOperatorImp.DIVISION);
        binaryOperators.add(BinaryOperatorImp.EXPONENTIATION);
                
        // Run the calculator!
        new GuiCalculator(unaryOperators, binaryOperators);
    }
}
