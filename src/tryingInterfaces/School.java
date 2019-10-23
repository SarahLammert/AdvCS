package tryingInterfaces;

public class School implements Place {
	private int location;
	public School(int l) {
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
