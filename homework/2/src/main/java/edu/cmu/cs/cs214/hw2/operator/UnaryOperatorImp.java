package edu.cmu.cs.cs214.hw2.operator;

public enum UnaryOperatorImp implements UnaryOperator {
	ABS{
		
		/**
		 * toString method that returns the abs operator "abs".
		 */
		@Override
		public String toString() {
			return "abs";
		}
		
		/**
		 * Method that returns the absolute value of arg.
		 */
		public double apply(double arg){
			if (arg < 0) {
				return -arg;
			} else {
				return arg;
			}
		}
	},
	NEGATION{
		
		/**
		 * toString method that returns the negation operator "¡À".
		 */
		@Override
		public String toString() {
			return "¡À";
		}
		
		/**
		 * Method that returns the value of arg with a contrary sign.
		 */
		public double apply(double arg){
			return -arg;
		}
	};
}