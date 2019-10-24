package P4Bags;

import java.util.ArrayList;

import P4Surprises.ISurprise;

public interface IBag {
	
	//adds a surprise in the bag
	void put(ISurprise newSurprise);
	
	void put(ArrayList<ISurprise> surprises);
	
	//adds all the surprises from another IBag
	//  -> the 'bagOfSurprises' will be empty afterwards
	void put(IBag bagOfSurprises);
	
	//removes a surprise from the bag and returns it
	ISurprise takeOut();
	
	//checks if the bag is empty or not
	boolean isEmpty();
	
	// returns the number of surprises
	int size();
	
	ArrayList<ISurprise> getSurprisesBag();
}
