package edu.cmu.cs.cs214.hw2.guicalc;
import edu.cmu.cs.cs214.hw2.operator.BinaryOperator;
import edu.cmu.cs.cs214.hw2.operator.UnaryOperator;

import java.util.Set;

/**
 * Main program that runs the GUI Calculator
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Replace null with your own unary operators. Use a Linked HashSet so operators are displayed in order.
        Set<UnaryOperator> unaryOperators = null;

        // TODO: Replace null with your own binary operators. Use a Linked HashSet so operators are displayed in order
        Set<BinaryOperator> binaryOperators = null;

        // Run the calculator!
        new GuiCalculator(unaryOperators, binaryOperators);
    }
}
