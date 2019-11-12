package elevensLab;

public class CardTester {
	
	public static void main(String[] args) {
		
		Card c1 = new Card("Ten", "Hearts", 10);
		Card c2 = new Card("Ten", "Hearts", 10);
		Card c3 = new Card("Four", "Diamonds", 4);
		
		System.out.println("This is the rank: " + c1.getRank());
		System.out.println("This is the suit: " + c1.getSuit());
		System.out.println("This is the point value: " + c1.getPointValue());
		System.out.println(c1);
		
		System.out.println("This is the rank: " + c2.getRank());
		System.out.println("This is the suit: " + c2.getSuit());
		System.out.println("This is the point value: " + c2.getPointValue());
		System.out.println(c2);
		
		System.out.println("This is the rank: " + c3.getRank());
		System.out.println("This is the suit: " + c3.getSuit());
		System.out.println("This is the point value: " + c3.getPointValue());
		System.out.println(c3);
		
		System.out.println(c1.isEqual(c2));
		System.out.println(c2.isEqual(c3));
		System.out.println(c3.isEqual(c1));
		
		
		
	}
}
