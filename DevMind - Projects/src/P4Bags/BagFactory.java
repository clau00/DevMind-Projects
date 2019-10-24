package P4Bags;

public class BagFactory implements IBagFactory{
	private static BagFactory instance = null;
	
	private BagFactory() {}
	
	public static BagFactory generateBagFactory() {
		if(BagFactory.instance == null) {
			BagFactory.instance = new BagFactory();
		}
		
		return BagFactory.instance;
	}

	public IBag makeBag(String type) {
		if(type.equals("RandomBag")) {
			return new RandomBag();
		}else if(type.equals("LifoBag")) {
			return new FifoBag();
		}else if(type.equals("FifoBag")) {
			return new FifoBag();
		}else {
			System.out.println("\t Unknown type of BAG! \n");
			return null;
		}
	}
}
