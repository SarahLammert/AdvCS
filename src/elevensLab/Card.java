package elevensLab;

public class Card {
	
	private String rank;
	private String suit;
	private int pointValue;
	
	public Card(String r, String s, int pV) {
		rank = r;
		suit = s;
		pointValue = pV;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getPointValue() {
		return pointValue;
	}
	
	public boolean isEqual(Card otherCard) {
		return rank.equals(otherCard.rank)
			&& suit.equals(otherCard.suit)
			&& pointValue == otherCard.pointValue;
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit + " (Point value = " + pointValue + ")";
	}
}