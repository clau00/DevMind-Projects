package P4Surprises;

import java.util.ArrayList;

import P4Bags.BagFactory;
import P4Bags.GatherSurprises;
import P4Bags.IBag;
import P4GiveSurprises.AbstractGiveSurprises;
import P4GiveSurprises.GiveSurpriseAndApplause;
import P4GiveSurprises.GiveSurpriseAndHug;
import P4GiveSurprises.GiveSurpriseAndSing;

import java.util.Random;

public class Main {
	private static Random random = new Random();

	public static void main(String[] args) {
		
		//
		//  Creating the bags, putting them in the ArrayList surprisesBag
		//
		BagFactory bagFactory = BagFactory.generateBagFactory();
		ArrayList<IBag> surprisesBag = new ArrayList<IBag>();
		
		surprisesBag.add(bagFactory.makeBag("RandomBag"));
		surprisesBag.add(bagFactory.makeBag("FifoBag"));
		surprisesBag.add(bagFactory.makeBag("LifoBag"));
		
		System.out.print("\t The sizes of the surprises bags in the BAGS ArrayList, before GatherSurprises: ");
		for(int i=0; i<surprisesBag.size(); i++) {
			System.out.print(surprisesBag.get(i).size() + "  ");
		}
		System.out.println();
		
		//
		// Gather the surprises and putting them in the Surprises Bags
		//
		for(int i=0; i<surprisesBag.size(); i++) {
			surprisesBag.get(i).put(GatherSurprises.gather(random.nextInt(10 - 3) + 3));
		}
		
		System.out.print("\t The sizes of the surprises bags in the BAGS ArrayList, after GatherSurprises:  ");
		for(int i=0; i<surprisesBag.size(); i++) {
			System.out.print(surprisesBag.get(i).size() + "  ");
		}
		System.out.println("\n\n");
		
		
		System.out.println("\t All the surprises putted in the bags: ");
		for(int i=0; i<surprisesBag.size(); i++) {
			ArrayList<ISurprise> a = surprisesBag.get(i).getSurprisesBag();
			System.out.println("\t ===================================================");
			for(int j=0; j<a.size(); j++) {
				a.get(j).enjoy();
			}
			System.out.println("\t =================================================== \n\n");
		}
		
		//
		//  Creating the GIVE types of bags, adding them to ArrayList "abstractGiveSurprises"
		//
		GiveSurpriseAndApplause giveApplause = new GiveSurpriseAndApplause("RandomBag", 1);
		GiveSurpriseAndHug giveHug = new GiveSurpriseAndHug("LifoBag", 1);
		GiveSurpriseAndSing giveSing = new GiveSurpriseAndSing("FifoBag", 1);
		
		ArrayList<AbstractGiveSurprises> abstractGiveSurprises = new ArrayList<AbstractGiveSurprises>();
		abstractGiveSurprises.add(giveApplause);
		abstractGiveSurprises.add(giveHug);
		abstractGiveSurprises.add(giveSing);
		
		//
		//  Copying the bags from Bags - "surprisesBags" to GiveBags - "abstractGiveSurprises"
		//
		System.out.print("\t The sizes of the surprises bags in the GIVE SURPRISES ArrayList, BEFORE copying the bags: ");
		for(int i=0; i<abstractGiveSurprises.size(); i++) {
			System.out.print(abstractGiveSurprises.get(i).size() + "  ");
		}
		System.out.println();
		
		for(int i=0; i<abstractGiveSurprises.size(); i++) {
			abstractGiveSurprises.get(i).put(surprisesBag.get(i));
		}
		
		System.out.print("\t The sizes of the surprises bags in the GIVE SURPRISES ArrayList, AFTER copying the bags:  ");
		for(int i=0; i<abstractGiveSurprises.size(); i++) {
			System.out.print(abstractGiveSurprises.get(i).size() + "  ");
		}
		System.out.println();
		
		System.out.print("\t The sizes of the surprises bags in the BAGS ArrayList, after copied the bags to GIVE:     ");
		for(int i=0; i<surprisesBag.size(); i++) {
			System.out.print(surprisesBag.get(i).size() + "  ");
		}
		System.out.println("\n\n");
		
		for(int i=0; i<abstractGiveSurprises.size(); i++) {
			//abstractGiveSurprises.get(i)
			abstractGiveSurprises.get(i).giveAll();
			//abstractGiveSurprises.get(i).enjoy();
			//abstractGiveSurprises.get(i).give().enjoy();
		}

		System.out.print("\n\t The sizes of the surprises bags in the GIVE SURPRISES ArrayList, "
						+ "AFTER gave 2 surprises from each bag:  ");
		for(int i=0; i<abstractGiveSurprises.size(); i++) {
			System.out.print(abstractGiveSurprises.get(i).size() + "  ");
		}
	}
}
