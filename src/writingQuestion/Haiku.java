package writingQuestion;

public class Haiku extends Poem {
	public static final int HAIKU_LINES = 3;

	@Override
	public int getSyllables(int k) {
		if(k == 2) {
			return 7;
		} else {
			return 5;
		}
	}

	@Override
	public int numLines() {
		return HAIKU_LINES;
	}

}
