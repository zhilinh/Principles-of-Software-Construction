package edu.cmu.cs.cs214.hw2.operator;

/**
 * Enum that contains implements of BinaryOperator
 * @author zhilinh
 *
 */
public enum BinaryOperatorImp implements BinaryOperator {
	ADDITION{
		
		/**
		 * toString method that returns the addition operator "+".
		 */
		@Override
		public String toString() {
			return "+";
		}
		
		/**
		 * Method that returns the sum of arg1 and arg2.
		 */
		public double apply(double arg1, double arg2) {
			return arg1 + arg2;
		}
	},
	SUBTRACTION{
		
		/**
		 * toString method that returns the subtraction operator "-".
		 */
		@Override
		public String toString() {
			return "-";
		}
		
		/**
		 * Method that returns the difference of arg1 and arg2.
		 */
		public double apply(double arg1, double arg2) {
			return arg1 - arg2;
		}
	},
	MULTIPLICATION{
		
		/**
		 * toString method that returns the multiplication operator "*".
		 */
		@Override
		public String toString() {
			return "*";
		}
		
		/**
		 * Method that returns the product of arg1 and arg2.
		 */
		public double apply(double arg1, double arg2) {
			return arg1 * arg2;
		}
	},
	DIVISION{
		
		/**
		 * toString method that returns the division operator "/".
		 */
		@Override
		public String toString() {
			return "/";
		}
		
		/**
		 * Method that returns the division of arg1 and arg2.
		 */
		public double apply(double arg1, double arg2) {
			return arg1 / arg2;
		}
	},
	EXPONENTIATION{
		
		/**
		 * toString method that returns the exponentiation operator "^".
		 */
		@Override
		public String toString() {
			return "^";
		}
		
		/**
		 * Method that returns the product of arg1 and arg2.
		 */
		public double apply(double arg1, double arg2) {
			return Math.pow(arg1, arg2);
		}
	};
}
