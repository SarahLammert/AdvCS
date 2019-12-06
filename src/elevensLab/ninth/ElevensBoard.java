package elevensLab.ninth;

import java.util.List;

public class ElevensBoard extends Board {
	
	private static final int BOARD_SIZE = 9;
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	private Card[] cards;
	private Deck deck;
	private static final boolean I_AM_DEBUGGING = false;

	public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}
	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		if((containsJQK(selectedCards) && selectedCards.size() == 3)
		|| (selectedCards.size() == 2 && containsPairSum11(selectedCards))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		boolean j = false;
		boolean q = false;
		boolean k = false;
		for(int p = 0; p < size(); p++) {
			if(cardAt(p).getRank() == "jack") {
				j = true;
			} else if(cardAt(p).getRank() == "queen") {
				q = true;
			} else if(cardAt(p).getRank() == "king") {
				k = true;
			}
		}
		if(j && q && k) {
			return true;
		}
		for(int x = 0; x < size()-1; x++) {
			for(int y = x + 1; y < size(); y++) {
				if(cardAt(x).getPointValue() + cardAt(y).getPointValue() == 11) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		for(int i = 0; i < selectedCards.size(); i++) {
			for(int j = i+1; j < selectedCards.size(); j++) {
				if(cardAt(selectedCards.get(i)).getPointValue()
				 + cardAt(selectedCards.get(j)).getPointValue() == 11) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		boolean thereIsJ = false;
		boolean thereIsQ = false;
		boolean thereIsK = false;
		
		for(Integer i: selectedCards) {
			if(cardAt(i).getRank() == "jack") {
				thereIsJ = true;
			}
			if(cardAt(i).getRank() == "queen") {
				thereIsQ = true;
			}
			if(cardAt(i).getRank() == "king") {
				thereIsK = true;
			}
		}
		if(thereIsJ && thereIsQ && thereIsK) {
			return true;
		} else {
			return false;
		}
	}
}
