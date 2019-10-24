package P4Bags;

import java.util.ArrayList;
import java.util.Random;

import P4Surprises.ISurprise;

public class RandomBag implements IBag{
	private static Random random = new Random();
	private ArrayList<ISurprise> surprisesBag;
	
	public RandomBag() {
		this.surprisesBag = new ArrayList<ISurprise>();
	}
	
	@Override
	public void put(ISurprise newSurprise) {
		this.surprisesBag.add(newSurprise);
	}
	
	@Override
	public void put(ArrayList<ISurprise> surprises) {
		this.surprisesBag.addAll(surprises);
	}
	
	@Override
	public void put(IBag bagOfSurprises) {
		ArrayList<ISurprise> array = new ArrayList<ISurprise>();
		array = bagOfSurprises.getSurprisesBag();
		this.surprisesBag.addAll(array);	
		array.clear();
	}
	
	@Override
	public ISurprise takeOut() {
		if(isEmpty()) {
			return null;
		}
		int n = random.nextInt(this.surprisesBag.size());
		ISurprise selectedSurprise = this.surprisesBag.get(n);
		this.surprisesBag.remove(n);
		return selectedSurprise;
		}
	
	@Override
	public boolean isEmpty() {
		if(this.surprisesBag.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int size() {
		return this.surprisesBag.size();
	}
	
	public ArrayList<ISurprise> getSurprisesBag(){
		return this.surprisesBag;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i=0; i<this.surprisesBag.size(); i++) {
			result += this.surprisesBag.get(i);
		}
		return result;
	}
}
