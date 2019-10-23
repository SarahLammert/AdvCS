package writingQuestion;

public abstract class Poem {

	public abstract int numLines();
	public abstract int getSyllables(int k);
	public void printRhythm() {
		for(int l = 1; l <= numLines(); l++) {
			for(int s = getSyllables(l); s > 0; s--) {
				if(s != 1) {
					System.out.print("ta-");
				} else {
					System.out.print("ta");
				}
			}
			System.out.print("\n");
		}
	}
}
