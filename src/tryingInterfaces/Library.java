package tryingInterfaces;

public class Library implements Place {
	private int location;
	public Library(int l) {
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
