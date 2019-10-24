package P5ExpressionsEvaluatorStack;

import java.util.Deque;
import java.util.ArrayDeque;

public class EvaluateExpression {

	private Deque<Integer> operands = new ArrayDeque();
	private String operators = "-+/*^";
	
	public int evaluateExp(String str) {
		int rez = 0;
		for(String el : str.split("\\s")) {
			//System.out.println(el);
			if(!operators.contains(el)) {
				operands.push(Integer.valueOf(el));
				//System.out.println("\t " + operands);
			}else {
				double op1 = (double)operands.pop();
				//System.out.println("\t\t" + op1);
				double op2 = (double)operands.pop();
				//System.out.println("\t\t" + op2);
				if(Double.valueOf(op1) == null || Double.valueOf(op2) == null) {
					System.out.println("\t Expresie postfixata gresita!");
				}
				operands.push((int)calculate(op1, op2, el));
				//System.out.println("\t " + operands);
			}
		}
		rez = operands.pop();
		if(!operands.isEmpty()) {
			System.out.println("\t Expresie postfixata gresita!");
		}
		return rez;
	}
	
	private boolean checkIfEmpty() {
		if(operands.isEmpty()) {
			System.out.println("\t Operands stack is empty!");
			return true;
		}
		return false;
	}
	
	private double calculate(double op1, double op2, String operator) {
		switch(operator) {
		case "+":
			return op1 + op2;
		case "-":
			return op2 - op1;
		case "*":
			return op1 * op2;
		case "/":
			return op2 / op1;
		case "^":
			return Math.pow(op2, op1);
		default:
			System.out.println("\t Invalid operator for the 'calculate' function!");
			return 0;
		}
	}
}
