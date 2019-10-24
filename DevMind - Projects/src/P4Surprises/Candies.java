package P4Surprises;

import java.util.ArrayList;
import java.util.Random;

public class Candies implements ISurprise{
	private int candiesNo;
	private String candiesType;
	private static ArrayList<String> candiesTypeList = null;
	private static Random random = new Random();

	public Candies(int candiesNo, String candiesType) {
		this.candiesNo = candiesNo;
		this.candiesType = candiesType;
	}
			
	public static Candies generate() {
		Candies.generateCandiesTypeList();
		int candiesNo = random.nextInt(12 - 1) + 1;
		int candiesTypeIndex = random.nextInt(Candies.candiesTypeList.size());		
		String candiesType = Candies.candiesTypeList.get(candiesTypeIndex);
		return new Candies(candiesNo, candiesType);		
	}
	
	private static void generateCandiesTypeList() {
		if(candiesTypeList == null) {
			candiesTypeList = new ArrayList<String>();
		}
		candiesTypeList.add("chocolate");
		candiesTypeList.add("jelly");
		candiesTypeList.add("fruits");
		candiesTypeList.add("vanilla");
	}

	public void enjoy() {
		System.out.println("\t Surpriza \"Candies\" a fost deschisa, cu mesajul: \n"
						+ "\t " + this.candiesNo + " bomboane cu \"" + this.candiesType + "\". \n");
	}
}
