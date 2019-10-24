package P4GiveSurprises;

import java.util.concurrent.TimeUnit;

import P4Bags.BagFactory;
import P4Bags.IBag;
import P4Surprises.ISurprise;

public abstract class AbstractGiveSurprises{
	private IBag surprisesBag;
	private int waitTime;
	
	public AbstractGiveSurprises(String typeOfBag, int waitSeconds) {
		this.surprisesBag = BagFactory.generateBagFactory().makeBag(typeOfBag);
		this.waitTime = waitSeconds;
	}
	
	private void waitingTime() {
		try {
			TimeUnit.SECONDS.sleep(this.waitTime);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void put(ISurprise newSurprise) {
		this.surprisesBag.put(newSurprise);
	}
	
	public void put(IBag surprises) {
		this.surprisesBag.put(surprises);
	}
	
	public ISurprise give() {
		if(this.surprisesBag.size() > 0) {
			giveWithPassion();
			return this.surprisesBag.takeOut();
		}else {
			return null;
		}
	}
	
	public void giveAll() {
		while(this.surprisesBag.size() > 0) {
			this.give().enjoy();
			this.waitingTime();
		}
	}
		
	public boolean isEmpty() {
		if(this.surprisesBag.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public int size() {
		return surprisesBag.size();
	}
	
	protected abstract void giveWithPassion();
}
