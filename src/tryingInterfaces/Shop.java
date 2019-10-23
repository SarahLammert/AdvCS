package tryingInterfaces;

public class Shop implements Place{
	private int location;
	public Shop(int l) {
		location = l;
	}

	@Override
	public int distance(Place other) {
		return Math.abs(other.getLoc() - location);
	}

	@Override
	public int getLoc() {
		return location;
	}

}
