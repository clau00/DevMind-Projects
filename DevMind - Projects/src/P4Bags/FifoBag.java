package P4Bags;

import java.util.ArrayList;

import P4Surprises.ISurprise;

public class FifoBag implements IBag{
	private ArrayList<ISurprise> surprisesBag;
	
	public FifoBag() {
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
		ISurprise selectedSurprise = this.surprisesBag.get(0);
		this.surprisesBag.remove(0);
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
