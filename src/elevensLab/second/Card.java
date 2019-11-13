package elevensLab.second;

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
		return this.getRank().equals(otherCard.getRank())
			&& this.getSuit().equals(otherCard.getSuit())
			&& this.getPointValue() == otherCard.getPointValue();
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit + " (Point value = " + pointValue + ")";
	}
}