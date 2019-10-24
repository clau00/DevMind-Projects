package P2OptimizareaPerformanta;

public class CalculatingMethods {
	
	public static boolean isPerfectNumber(int n) {
		int sum = 1;
		for(int i=2; i<=n/2; i++) {
			if(n % i == 0) {
				sum += i;
			}
		}
		if(n == sum) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isPrimeNumber(int n) {
		for(int i=2; i<=n/2; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isEvenNumber(int n) {
		if(n % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int digitsSum(int n) {
		int sum = 0;
		while(n != 0) {
			sum += n % 10;
			n /=10;
		}
		return sum;
	}
	
	static boolean isDivisibleBy3(int n) {
		if(n % 3 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	static int numberOfDigits(int number) {
		int count = 0;
		if(number == 0) {
			return 1;
		}
		while(number != 0) {
			count++;
			number /= 10;
		}
		return count;
	}
	
	static String formatThePrinting(int number) {
		int copyOfNumber = number;
		switch(numberOfDigits(copyOfNumber)) {
		case 1:
			return "     " + number;
		case 2:
			return "    " + number;
		case 3:
			return "   " + number;
		case 4:
			return "  " + number;
		case 5:
			return " " + number;
		case 6:
			return "" + number;
		default:
			return "" + number;
		}
	}
}
