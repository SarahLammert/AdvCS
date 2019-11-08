package harryPotterReader;

public class Word {
	
	private String word;
	private int count = 1;
	
	public Word(String s) {
		word = s;
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
}
