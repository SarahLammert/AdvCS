package writingQuestion;

public class Limerick extends Poem {
	public static final int LIMERICK_LINES = 5;

	@Override
	public int getSyllables(int k) {
		if(k == 3 || k == 4) {
			return 6;
		} else {
			return 9;
		}
	}

	@Override
	public int numLines() {
		return LIMERICK_LINES;
	}
	
}
