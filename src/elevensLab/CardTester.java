package elevensLab;

public class CardTester {
	public static void main(String[] args) {
		Card c1 = new Card("5", "Heart", 5);
		Card c2 = new Card("5", "Heart", 5);
		Card c3 = new Card("4", "Diamond", 4);
		System.out.println(c1.isEqual(c2));
	}
}
