package P4GiveSurprises;

public class GiveSurpriseAndHug extends AbstractGiveSurprises{

	public GiveSurpriseAndHug(String typeOfBag, int waitSeconds) {
		super(typeOfBag, waitSeconds);
	}

	@Override
	protected void giveWithPassion() {
		System.out.println("\t Warm wishes and a big hug!");
	}
}

