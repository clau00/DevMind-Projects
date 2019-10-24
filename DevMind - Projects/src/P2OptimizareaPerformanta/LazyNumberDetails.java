package P2OptimizareaPerformanta;
 

public class LazyNumberDetails {
	private int number;
	
	private boolean isPrime;
	private boolean isPerfect;
	private boolean isMagic;
	
	private boolean primeResult;
	private boolean perfectResult;
	private boolean magicResult;
	
	public boolean getIsPrime() {
		return isPrime;
	}

	public void setIsPrime(boolean isPrime) {
		this.isPrime = isPrime;
	}
	
	public boolean getIsPerfect() {
		return isPerfect;
	}

	public void setIsPerfect(boolean isPerfect) {
		this.isPerfect = isPerfect;
	}

	public boolean getIsMagic() {
		return isMagic;
	}

	public void setIsMagic(boolean isMagic) {
		this.isMagic = isMagic;
	}

	public void setPrimeResult(boolean primeResult) {
		this.primeResult = primeResult;
	}
	
	public boolean getPrimeResult() {
		return primeResult;
	}
	
	public void setPerfectResult(boolean perfectResult) {
		this.perfectResult = perfectResult;
	}
	
	public boolean getPerfectResult() {
		return perfectResult;
	}
	
	public void setMagicResult(boolean magicResult) {
		this.magicResult = magicResult;
	}
	
	public boolean getMagicResult() {
		return magicResult;
	}
	
	public LazyNumberDetails(int number) {
		this.number = number;
	}
	
	public void updateNumber(int number) {
		this.number = number;
		isPrime = false;
		isPerfect = false;
		isMagic = false;

	}
	
	public boolean isMagicNumber(int number) {
		int sum;
		while(true) {
			sum = CalculatingMethods.digitsSum(number);
			if(sum < 10) {
				break;
			}else {
				number = sum;
			}
		}
		if(sum == 3 || sum == 7 || sum == 9) {
			return true;
		}else {
			return false;
		}
	}
}
