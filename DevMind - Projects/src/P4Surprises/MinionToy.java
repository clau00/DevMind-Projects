package P4Surprises;

import java.util.ArrayList;

public class MinionToy implements ISurprise{
	private String name;
	private static ArrayList<String> minionToyNames = null;
	private static int minionToyIndex = 0;
	
	public MinionToy(String name) {
		this.name = name;
	}

	public static MinionToy generate() {
		MinionToy.generateMinionToyNames();
		if(MinionToy.minionToyIndex == MinionToy.minionToyNames.size()-1) {
			MinionToy.minionToyIndex = 0;
		}
		
		String minionToyName = MinionToy.minionToyNames.get(MinionToy.minionToyIndex);
		MinionToy.minionToyIndex++;
		
		return new MinionToy(minionToyName);
	}
	
	private static void generateMinionToyNames() {
		if(MinionToy.minionToyNames == null) {
			MinionToy.minionToyNames = new ArrayList<String>();
		}
		MinionToy.minionToyNames.add("Dave");
		MinionToy.minionToyNames.add("Carl");
		MinionToy.minionToyNames.add("Kevin");
		MinionToy.minionToyNames.add("Stuart");
		MinionToy.minionToyNames.add("Jerry");
		MinionToy.minionToyNames.add("Tim");
	}

	public void enjoy() {
		System.out.println("\t Surpriza \"MinionToy\" a fost deschisa, cu mesajul: \n"
						+ "\t Ati castigat minionul " + this.name + ". \n");
	}
}
