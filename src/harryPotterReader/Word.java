package harryPotterReader;

public class Word {
	
	private String word;
	private int count;
	
	public Word(String s) {
		word = s;
		count = 1;
	}
	
	public void addCount() {
		count += 1;
	}

	public String getWord() {
		return word;
	}
	
	public int getCount() {
		return count;
	}
	
	public String toString() {
		return word + ": " + count;
	}
}
