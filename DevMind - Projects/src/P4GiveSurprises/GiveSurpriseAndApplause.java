package P4GiveSurprises;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises{

	public GiveSurpriseAndApplause(String typeOfBag, int waitSeconds) {
		super(typeOfBag, waitSeconds);
	}

	@Override
	protected void giveWithPassion() {
		System.out.println("\t Loud applause to you... For it is in giving that we receive.");
	}
}
