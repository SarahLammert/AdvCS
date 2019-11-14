package elevensLab.third;

import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> cards;

	private int size;

	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<>();
		for(int rVIndex = 0; rVIndex < ranks.length; rVIndex++) {
			for(int sIndex = 0; sIndex < suits.length; sIndex++)
			cards.add(new Card(ranks[rVIndex], suits[sIndex], values[rVIndex]));
		}
		size = cards.size();
		shuffle(); //Activity 4
	}

	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}

	}

	//Cards left to be dealt
	public int size() {
		return size;
	}

	public void shuffle() {
		
	}
	
	public Card deal() {
		size -= 1;
		return cards.get(size);
	}
	
	public ArrayList getCards() {
		return cards;
	}

	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
