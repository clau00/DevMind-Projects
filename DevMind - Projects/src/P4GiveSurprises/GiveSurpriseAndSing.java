package P4GiveSurprises;

public class GiveSurpriseAndSing extends AbstractGiveSurprises{

	public GiveSurpriseAndSing(String typeOfBag, int waitSeconds) {
		super(typeOfBag, waitSeconds);
	}

	@Override
	protected void giveWithPassion() {
		System.out.println("\t Singing a nice song, full of joy and genuine excitement...");
	}
}
