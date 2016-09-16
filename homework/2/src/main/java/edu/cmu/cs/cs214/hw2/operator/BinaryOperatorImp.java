package edu.cmu.cs.cs214.hw2.operator;

public enum BinaryOperatorImp implements BinaryOperator {
	ADDITION{
		@Override
		public String toString() {
			return "+";
		}
		
		public double apply(double arg1, double arg2) {
			return arg1 + arg2;
		}
	},
	SUBTRACTION{
		@Override
		public String toString() {
			return "-";
		}
		
		public double apply(double arg1, double arg2) {
			return arg1 - arg2;
		}
	},
	MULTIPLICATION{
		@Override
		public String toString() {
			return "*";
		}
		
		public double apply(double arg1, double arg2) {
			return arg1 * arg2;
		}
	},
	DIVISION{
		@Override
		public String toString() {
			return "/";
		}
		
		public double apply(double arg1, double arg2) {
			return arg1 / arg2;
		}
	},
	EXPONENTIATION{
		@Override
		public String toString() {
			return "^";
		}
		
		public double apply(double arg1, double arg2) {
			return Math.pow(arg1, arg2);
		}
	};
}
