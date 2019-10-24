package P4Bags;

public interface IBagFactory {

	// Create a new container, according to the specified type
	IBag makeBag(String type);
}
