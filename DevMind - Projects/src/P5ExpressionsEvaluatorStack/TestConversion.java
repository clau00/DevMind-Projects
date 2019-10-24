package P5ExpressionsEvaluatorStack;

public class TestConversion {

	public static void main(String[] args) {
		PostfixConversion p = new PostfixConversion();		
		String str = "3 + ( 2 + 1 ) * 2 ^ 3 ^ 2 - 8 / ( 5 - 1 * 2 / 2 ) + 3 ^ 3 * 2";
		System.out.println("\t Sirul introdus: " + str + "\n");
		String rez = p.conversion(str);
		System.out.println("\t\t\t " + rez + "\n");
		
		EvaluateExpression e = new EvaluateExpression();
		System.out.println("\t " + e.evaluateExp(rez));
	}
}
