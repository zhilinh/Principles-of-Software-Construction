package edu.cmu.cs.cs214.hw2.operator;

public enum UnaryOperatorImp implements UnaryOperator {
	ABS{
		@Override
		public String toString() {
			return "abs";
		}
		
		public double apply(double arg){
			if (arg < 0) {
				return -arg;
			} else {
				return arg;
			}
		}
	},
	NEGATION{
		@Override
		public String toString() {
			return "¡À";
		}
		
		public double apply(double arg){
			return -arg;
		}
	};
}