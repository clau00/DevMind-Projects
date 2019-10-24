package P5ExpressionsEvaluatorStack;

import java.util.Deque;
import java.util.ArrayDeque;

public class PostfixConversion {

	private Deque<String> stack = new ArrayDeque();
	private final String operators = "+-*/^";
	
	public String conversion(String str) {
		StringBuilder sb = new StringBuilder();
		for(String el : str.split("\\s")) {
			//System.out.println(el);
			if(el.equals("(")) {
				stack.push(el);
			}else if(el.equals(")")) {
				while(!stack.peek().equals("(")) {
					sb.append(stack.pop() + " ");
				}
				if(stack.isEmpty()) {
					System.out.println("\t Expresia avea paranteze gresite!");
					break;
				}else{
					stack.pop();
				}
			}else if(!operators.contains(el)) {
				sb.append(el + " ");
			}else if(operators.contains(el)){
				String op = stack.peek();
				while(!stack.isEmpty() && (!op.equals("(")) && 
						(precedenceOperator(el) < precedenceOperator(op) ||
						precedenceOperator(el) == precedenceOperator(op) && 
						associativityOperator(el) == "stanga-dreapta")) {
					sb.append(stack.pop() + " ");
					op = stack.peek();
				}
				stack.push(el);
			}
			//System.out.println("\t" + sb.toString());
			//System.out.println("\t" + stack);
		}
		while(!stack.isEmpty()) {
			if(stack.peek().equals("(")) {
				System.out.println("\t Expresia avea paranteze gresite!");
				break;
			}else {
				sb.append(stack.pop() + " ");
			}
		}
		return sb.toString();
	}
	
	private int precedenceOperator(String op) {
		switch(op) {
		case "+":
		case "-":
			return 11;
		case "*":
		case "/":
			return 12;
		case "^":
			return 13;
		default:
			System.out.println("\t Invalid operator!");
			return -1;
		}
	}
	
	private String associativityOperator(String op) {
		switch(op) {
		case "+":
		case "-":
		case "*":
		case "/":
			return "stanga-dreapta";
		case "^":
			return "dreapta-stanga";
		default:
			System.out.println("\t Invalid operator!");
			return null;
		}
	}
	
	public String getElementFromStr(String str) {
		String rez = "";
		
		
		return rez;
	}
	
}
