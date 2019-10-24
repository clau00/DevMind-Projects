package P4Bags;

import java.util.ArrayList;
import java.util.Random;

import P4Surprises.Candies;
import P4Surprises.FortuneCookie;
import P4Surprises.ISurprise;
import P4Surprises.MinionToy;

public final class GatherSurprises {
	private static Random random = new Random();
	
	private GatherSurprises() {
	}
	
	public static ArrayList<ISurprise> gather(int n){
		
		ArrayList<ISurprise> surprises = new ArrayList<ISurprise>(n);
		for(int i=0; i<n; i++) {
			int randomSurpriseIndex = random.nextInt(3);
			//System.out.println(randomSurpriseIndex);
			
			// randomSurpriseIndex:
			//		1 -> FortuneCookie;
			//		2 -> Candies;
			//		3 -> MinionToy.
			
			switch (randomSurpriseIndex) {
			case 0:
				surprises.add(FortuneCookie.generate());
				break;
			case 1:
				surprises.add(Candies.generate());
				break;
			case 2:
				surprises.add(MinionToy.generate());
				break;				

			default:
				System.out.println("\t Unknown type of surprise! \n");
				break;
			}
		}
		
		return surprises;
	}
	
	public static ISurprise gather() {
		int randomSurpriseIndex = random.nextInt(3);
		//System.out.println(randomSurpriseIndex);
	
		// randomSurpriseIndex:
		//		1 -> FortuneCookie;
		//		2 -> Candies;
		//		3 -> MinionToy.
		switch (randomSurpriseIndex) {
		case 0:
			return FortuneCookie.generate();
		case 1:
			return Candies.generate();
		case 2:
			return MinionToy.generate();	
		default:
			System.out.println("\t Unknown type of surprise! \n");
			return null;
		}
	}
}
